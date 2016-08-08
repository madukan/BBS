import java.net.*;
import java.util.*;

public class Server extends Thread{
	private ServerSocket server;
    protected List<ClientHandler> clients;

    public Server(int port){
    	try{
    		this.server = new ServerSocket(port);
    		System.out.println("BBS Server has been Initialized!");
    		
    		clients = Collections.synchronizedList(new ArrayList<ClientHandler>());
    		this.start();
    	}
		catch(Exception e){
			e.printStackTrace();
		}
    }
    
	public void run(){
		while(true){
			try{
				Socket client = server.accept();
				System.out.println(client.getInetAddress().getHostName() + " Connected");
				
				ClientHandler newClient = new ClientHandler(client);
				clients.add(newClient);
				new SendMessage(clients);
            }
			catch(Exception e){
				e.printStackTrace();
            }
        }
    }
}