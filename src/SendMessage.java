import java.io.*;
import java.nio.*;
import java.net.*;
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
                	System.out.println("Enter message:");
            	}
            
		try{
                	if(clients.size() > 0){
                    		this.console = new BufferedReader(new InputStreamReader(System.in));

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
