package Part3HW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);

                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;

                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }

    protected synchronized void disconnect(ServerThread client) {
        long id = client.getId();
        client.disconnect();
        broadcast("Disconnected", id);
    }

    protected synchronized void broadcast(String message, long id) {
        if (processCommand(message, id)) {

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect

        // end temp identifier

        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);

            }

        }
    }

    private boolean processCommand(String message, long clientId) {
        System.out.println("Checking command: " + message);
        if (message.equalsIgnoreCase("disconnect")) {
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if (client.getId() == clientId) {
                    it.remove();
                    disconnect(client);

                    break;
                }
            }
            return true;
        }
        if (message.equalsIgnoreCase("Coin Toss")) {
            broadcast(CoinToss(), clientId);
            return true;
        }
        if (message.startsWith("shuffle")) {
            String[] msgParts = message.split("shuffle");
            String msg = msgParts[1];
            broadcast(shuffler(msg), clientId);
            return true;
        }
        return false;
    }
    //UCID: 31485020    
    //Date  June 20, 2022
    // Logic:  For this function of CoinToss, I created a function that would create a random integer from 0-10; The intial state of the coin is heads however 
    // if the random integer were to change to an odd number than the message would be that the coin is tails. The message will then get returned and passed into
    // the broadcast function. this would then allow the user to see the state of the coin after each flip command.


    private String CoinToss() {
        Random random = new Random();
        int state = random.nextInt(10);
        String msg = "Coin is Heads";

        if (state % 2 == 0) {// broadcast("Coin is Heads", clientId);
            return msg;
        } else {
            // broadcast("Coin Is Tails", clientId);
            return (msg = "Coin is Tails");
        }
    }

    //UCID: 31485020
    //Date: June 20, 2022
    // Logic: The logic for the shuffler message revolves with taking in a string parameter, and storing the string into a charater array.
    // this will make it easier to loop over and change the places of each letter within the string. The logic for shuffling the word around 
    // revolves around switching the last letter of the word with the first letter up until the for loop reaches the middle letter of the word. 
    // when the middle is reached then the loop will break and the character array will be returned as a string  and broadcasted above.
    
    private String shuffler(String message) {

        char[] mesgToChar = message.toCharArray();
        char temp;

        for(int i=0;i<mesgToChar.length;i++)
        {
            if(i!=mesgToChar.length/2)
            {

                temp =mesgToChar[mesgToChar.length-i-1];
                mesgToChar[mesgToChar.length-i-1]=mesgToChar[i];
                mesgToChar[i]=temp;
            }
            else 
            {break;}
        }
        return String.valueOf(mesgToChar);
    }

    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}
