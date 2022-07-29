package Project.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import Project.common.Constants;

public class Room implements AutoCloseable {
	private String name;
	private List<ServerThread> clients = Collections.synchronizedList(new ArrayList<ServerThread>());

	private boolean isRunning = false;
	// Commands
	private final static String COMMAND_TRIGGER = "/";
	private final static String CREATE_ROOM = "createroom";
	private final static String JOIN_ROOM = "joinroom";
	private final static String DISCONNECT = "disconnect";
	private final static String LOGOUT = "logout";
	private final static String LOGOFF = "logoff";
	private final static String FLIP = "flip";
	private final static String ROLL = "roll";
	private final static String MUTE = "mute";
	private final static String UNMUTE = "unmute";
	private static Logger logger = Logger.getLogger(Room.class.getName());

	public Room(String name) {
		this.name = name;
		isRunning = true;
	}

	private void info(String message) {
		logger.log(Level.INFO, String.format("Room[%s]: %s", name, message));
	}

	public String getName() {
		return name;
	}

	public boolean isRunning() {
		return isRunning;
	}

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			sendConnectionStatus(client, true);
			sendRoomJoined(client);
			sendUserListToClient(client);
		}
	}

	protected synchronized void removeClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		clients.remove(client);
		// we don't need to broadcast it to the server
		// only to our own Room
		if (clients.size() > 0) {
			// sendMessage(client, "left the room");
			sendConnectionStatus(client, false);
		}
		checkClients();
	}

	/***
	 * Checks the number of clients.
	 * If zero, begins the cleanup process to dispose of the room
	 */
	private void checkClients() {
		// Cleanup if room is empty and not lobby
		if (!name.equalsIgnoreCase("lobby") && clients.size() == 0) {
			close();
		}
	}

	/***
	 * Helper function to process messages to trigger different functionality.
	 * 
	 * @param message The original message being sent
	 * @param client  The sender of the message (since they'll be the ones
	 *                triggering the actions)
	 */
	private boolean processCommands(String message, ServerThread client) {
		boolean wasCommand = false;
		List<String> mutedClients = new ArrayList<String>();
		List<String> dm = new ArrayList<String>();
		try {

			if (message.startsWith(COMMAND_TRIGGER)) {
				String[] comm = message.split(COMMAND_TRIGGER);
				String part1 = comm[1];
				String[] comm2 = part1.split(" ");
				String command = comm2[0];
				String roomName;
				wasCommand = true;
				switch (command) {
					case CREATE_ROOM:
						roomName = comm2[1];
						Room.createRoom(roomName, client);
						break;
					case JOIN_ROOM:
						roomName = comm2[1];
						Room.joinRoom(roomName, client);
						break;
					case DISCONNECT:
					case LOGOUT:
					case LOGOFF:
						Room.disconnectClient(client, this);
						break;
					case FLIP:
						flip(client);
						break;
					case ROLL:
						int n = Integer.valueOf(comm2[1]);
						roll(client, n);
						break;

						//UCID 31485020 
						// Jul 28, 2022
						// attempt to create an mute function where users are put on a StringLIST and not 
						// allowed to send a msg to client
					case MUTE:
						String s = message;
						if (s.indexOf("@") > -1) {
							String[] ats = s.split("@");
							for (int i = 0; i < ats.length; i++) {
								if (i % 2 != 0) {
									String[] data = ats[i].split(" ");
									String user = data[0].toLowerCase();
									mutedClients.add(user);
								}
							}
							sendPrivateMessage(client, mutedClients, client.getClientName() + " muted you");
						}
						break;
						//UCID 31485020 
						// Jul 28, 2022
						// attempt to create an unmute function where users are taken off of a string list
					case UNMUTE:
						String ss = message;
						if (ss.indexOf("@") > -1) {
							String[] ats = ss.split("@");
							List<String> unblock = new ArrayList<String>();
							for (int i = 0; i < ats.length; i++) {
								if (i % 2 != 0) {
									String[] data = ats[i].split(" ");
									String user = data[0].toLowerCase();
									mutedClients.remove(user);
									unblock.add(user);
								}
							}
							sendPrivateMessage(client, unblock, client.getClientName() + " unmuted you");
						}
					case "PM":
						String y = message;
						
						if(y.indexOf("@")>-1)
						{
							List<String> g = new ArrayList<String>();
							String[] t = y.split("@");
							
							for(int i=0;i<t.length;i++){
								if(i%2!=0)
								{
									String[]d=t[i].split(" ");
									String u = d[0];
									g.add(u);
								}
							}
							sendPrivateMessage(client, g, message);
						}
						

						break;

					default:

						wasCommand = false;
						break;
				}

			}
			if (!message.startsWith(COMMAND_TRIGGER)) {
				String m = message;
				List<String> clientss = new ArrayList<String>();

				if (m.indexOf("@") > -1) {
					String arr[] = m.split("@");
					String clientName = "";
					for (int i = 0; i < arr.length; i++) {
						if (i > 0) {
							clientName = clientName.trim().toLowerCase();
							clientss.add(clientName);
						}
					}
					sendPrivateMessage(client, clientss, message);
					
					
				}

				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return wasCommand;
		// return response;

	}

	// Command helper methods
	protected String change(boolean change, String msg, String delimiter, String tag, String end) {
		String[] splitmsg = msg.split(delimiter);
		String temp = "";
		for (int i = 0; i < splitmsg.length; i++) {
			if (i % 2 == 0) {temp += splitmsg[i];
			} else {
				temp += tag + splitmsg[i] + end;
			}
		}

		return temp;
	}

	protected String formatMessage(String message) {
		String newMSG = message;

		newMSG = change(newMSG.indexOf("##") > -1, newMSG, "##", "<b>", "</b>");
		newMSG = change(newMSG.indexOf("**") > -1, newMSG, "\\*\\*", "<u>", "</u>");
		newMSG = change(newMSG.indexOf("$$") > -1, newMSG, "\\$\\$", "<i>", "</i>");
		// color for red
		if (newMSG.indexOf("-r") > -1) {
			String[] s1 = newMSG.split("\\-");
			String m = "";

			for (int i = 0; i < s1.length; i++) {
				if (s1[i].startsWith("r") || s1[i].endsWith("r")) {
					m += "<font color=\"red\">" + s1[i].substring(2, s1[i].length() - 2) + "</font>";
				} else {
					m += s1[i];

				}
				System.out.println(s1[i]);
			}

			newMSG = m;

		}
		if (newMSG.indexOf("-y") > -1) {
			String[] s1 = newMSG.split("\\-");
			String m = "";

			for (int i = 0; i < s1.length; i++) {
				if (s1[i].startsWith("y") || s1[i].endsWith("y")) {
					m += "<font color=\"yellow\">" + s1[i].substring(2, s1[i].length() - 2) + "</font>";
				} else {m += s1[i];				}
				System.out.println(s1[i]);
			}
			newMSG = m;
		}
		return newMSG;
	}

	protected static void getRooms(String query, ServerThread client) {
		String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
		client.sendRoomsList(rooms,
				(rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
	}

	protected static void createRoom(String roomName, ServerThread client) {
		if (Server.INSTANCE.createNewRoom(roomName)) {
			Room.joinRoom(roomName, client);
		} else {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
			client.sendRoomsList(null, String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!Server.INSTANCE.joinRoom(roomName, client)) {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
			client.sendRoomsList(null, String.format("Room %s doesn't exist", roomName));
		}
	}

	protected static void disconnectClient(ServerThread client, Room room) {
		client.setCurrentRoom(null);
		client.disconnect();
		room.removeClient(client);
	}
	// end command helper methods

	/***
	 * Takes a sender and a message and broadcasts the message to all clients in
	 * this room. Client is mostly passed for command purposes but we can also use
	 * it to extract other client info.
	 * 
	 * @param sender  The client sending the message
	 * @param message The message to broadcast inside the room
	 */
	protected synchronized void sendMessage(ServerThread sender, String message) {
		if (!isRunning) {
			return;
		}
		info("Sending message to " + clients.size() + " clients");

		if (sender != null && processCommands(message, sender)) {
			// it was a command, don't broadcast
			return;
		}
		message = formatMessage(message);
		long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				boolean messageSent = client.sendMessage(from, message);
				if (!messageSent) {
					handleDisconnect(iter, client);
				}
			}
		}
	}

	protected synchronized void sendUserListToClient(ServerThread receiver) {
		logger.log(Level.INFO, String.format("Room[%s] Syncing client list of %s to %s", getName(), clients.size(),
				receiver.getClientName()));
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread clientInRoom = iter.next();
				if (clientInRoom.getClientId() != receiver.getClientId()) {
					boolean messageSent = receiver.sendExistingClient(clientInRoom.getClientId(),
							clientInRoom.getClientName());
					// receiver somehow disconnected mid iteration
					if (!messageSent) {
						handleDisconnect(null, receiver);
						break;
					}
				}
			}
		}
	}

	protected synchronized void sendRoomJoined(ServerThread receiver) {
		boolean messageSent = receiver.sendRoomName(getName());
		if (!messageSent) {
			handleDisconnect(null, receiver);
		}
	}

	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
		// converted to a backwards loop to help avoid concurrent list modification
		// due to the recursive sendConnectionStatus()
		// this should only be needed in this particular method due to the recusion
		if (clients == null) {
			return;
		}
		synchronized (clients) {
			for (int i = clients.size() - 1; i >= 0; i--) {
				ServerThread client = clients.get(i);
				boolean messageSent = client.sendConnectionStatus(sender.getClientId(), sender.getClientName(),
						isConnected);
				if (!messageSent) {
					clients.remove(i);
					info("Removed client " + client.getClientName());
					checkClients();
					sendConnectionStatus(client, false);
				}
			}
		}
	}

	private synchronized void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
		if (iter != null) {
			iter.remove();
		}
		info("Removed client " + client.getClientName());
		checkClients();
		sendConnectionStatus(client, false);
		// sendMessage(null, client.getClientName() + " disconnected");
	}

	//UCID 31485020 
	// Jul 28, 2022
	// flip function will check if a random integer is even, if it's even its heads and else its flip
	protected synchronized void flip(ServerThread sender) {
		Random random = new Random();
		int coin = random.nextInt(4);
		String message;
		if (coin % 2 == 0) {
			message = "-r The Coin is Heads r-";

		} else {
			message = "-r The Coin is tails r-";

		}

		sendMessage(sender, message);

		// return message;

	}
	//UCID 31485020 
	// Jul 28, 2022
	// roll function will take in the users int paramater and roll a random integer between 0 to that number
	protected synchronized void roll(ServerThread sender, int number) {
		Random random = new Random();
		int num = random.nextInt(number);
		String message = "-r Your Number is " + num + " r-";
		String newr = formatMessage(message);

		sendMessage(sender, newr);

	}
	
	//UCID 31485020 
	// Jul 28, 2022
	// sending private msg which will take a client, and send the message to a stringlist containg
	// a list of clientnames

	protected void sendPrivateMessage(ServerThread sender, List<String> dest, String message) {
		Iterator<ServerThread> iter = clients.iterator();
		long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();

		while (iter.hasNext()) {
			ServerThread client = iter.next();
			if (dest.contains(client.getClientName().toLowerCase())) {
				boolean messageSent = client.sendMessage(from, message);
				if (!messageSent) {
					iter.remove();
				}
				break;
			}

		}
	}

	public void close() {
		Server.INSTANCE.removeRoom(this);
		isRunning = false;
		clients = null;
	}
}
