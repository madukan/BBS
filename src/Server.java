import java.net.*;
import java.io.*;

/**
 *
 * Two way communications enabled in Server.java. May need threading.
 *
 * Damien Hunter (11/08/2016)
 *
 **/
public class Server extends Thread{
	private ServerSocket sersock;
	private Socket sock;
	private int port = 0;

	public Server(){}

	public Server(int port){
		this.port = port;
		run();
	}

	public void run(){
		try{
			sersock = new ServerSocket(port);
                	System.out.println("BBS Server Initialised!");

                	sock = sersock.accept();
                	BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                	OutputStream ostream = sock.getOutputStream();
                	PrintWriter pwrite = new PrintWriter(ostream, true);

                	// Receiving
                	InputStream istream = sock.getInputStream();
                	BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
                	String receiveMessage, sendMessage;

                	while(true){
                        	if((receiveMessage = receiveRead.readLine()) != null){
                                	System.out.println(receiveMessage);
                        	}
                        	sendMessage = keyRead.readLine();
                        	pwrite.println(sendMessage);
                        	pwrite.flush();
                	}
		}
		catch(Exception e){}
	}

	public static void main(String[] args) throws Exception{
		Server a = new Server(1025);
	}
}
