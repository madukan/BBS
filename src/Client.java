import java.io.*;
import java.net.*;

public class Client{
	protected Socket client;
    protected BufferedReader in;

    public Client(String hostName, int ip){
    	try{
    		this.client = new Socket(hostName, ip);
    		this.in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            		
			String buffer = null;
            		
			while((buffer = in.readLine()) != null){
                		System.out.println(buffer);
            }
    	}
        catch(UnknownHostException e){
        	e.printStackTrace();
        }
        catch(IOException e){
        	e.printStackTrace();
        }
    }
}