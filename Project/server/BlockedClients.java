package Project.server;

public class BlockedClients {
    public BlockedClients(ServerThread client) {
	this.client = client;
    }
    public ServerThread client;
    
}
