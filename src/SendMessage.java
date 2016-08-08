import java.io.*;
import java.util.*;

public class SendMessage extends Thread{
	protected List<ClientHandler> clients;
    protected String userInput;
    protected BufferedReader console;

    public SendMessage(List<ClientHandler> clients){
    	this.clients = clients;
        this.userInput = null;
        this.start();
    }

    public void run(){
    	System.out.println("New Communication Thread Started");
            
		if(clients.size() == 1){
			System.out.println("Enter Message to Clients: ");
        }
            
		try{
			if(clients.size() > 0){
				this.console = new BufferedReader(new InputStreamReader(System.in));
				
				for(ClientHandler client : clients){
        			client.out.println("         ***********************************************");
    				client.out.println("         *                                             *");
    				client.out.println("         * Bulletin Board System v0.1                  *");
    				client.out.println("         *                                             *");
    				client.out.println("         *      Serving Files and Off Topic Chat       *");
    				client.out.println("         *                                             *");
    				client.out.println("         ***********************************************");
    				
        			client.out.flush();
				}
				
                while((this.userInput = console.readLine()) != null){
                	if(userInput != null & userInput.length() > 0){
                		
                		for(ClientHandler client : clients){
                			client.out.println(userInput);
                            client.out.flush();
                            
                            Thread.currentThread();
                            Thread.sleep(1 * 1000);
                		}
                	}
                }
			}
		}
		catch(Exception e){
			e.printStackTrace();
        }
    }
}