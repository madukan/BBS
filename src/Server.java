import java.net.*;
import java.io.*;

/**
 *
 * Two way communications enabled in Server.java. May need threading. Also needs Client
 * Handling for logging purposes.
 *
 * Damien Hunter (11/08/2016) damien.hunter9@gmail.com
 *
 **/
public class Server extends Thread{
	private ServerSocket sersock;
	private Socket sock;
	private int port = 0;
	private String receiveMessage, sendMessage;

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

			System.out.println(sock.toString() + " is Connected!");
                	BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                	OutputStream ostream = sock.getOutputStream();
                	PrintWriter pwrite = new PrintWriter(ostream, true);

                	InputStream istream = sock.getInputStream();
                	BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
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
		// Initialising a new Server. Will make use of arguments
		// instead of hard coding the port number.
		Server a = new Server(1025);
	}
}
