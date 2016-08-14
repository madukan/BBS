import java.io.*;
import java.net.*;

public class Server extends Thread{
	private int port;

	public Server(){}

	public Server(int port){
		this.port = port;
		run();
	}

	public void run(){
		try{
			ServerSocket sersock = new ServerSocket(port);
			System.out.println("BBS Server Initialised");
			Socket sock = sersock.accept();

			BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

			OutputStream ostream = sock.getOutputStream();
			PrintWriter pwrite = new PrintWriter(ostream, true);

			InputStream istream = sock.getInputStream();
			BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

			String receiveMessage, sendMessage, user;

			while(true){
				if((receiveMessage = receiveRead.readLine()) != null){
					if(receiveMessage.equals("login")){
                                		pwrite.println("User Name: ");
						user = receiveRead.readLine();
						System.out.println(user);
					}
					System.out.println(receiveMessage);
				}
				sendMessage = keyRead.readLine();
				pwrite.println(sendMessage);
				pwrite.flush();
			}
		}
		catch(Exception e){}
	}
}      
