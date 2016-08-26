import java.io.*;
import java.net.*;

public class Server extends Thread{
	private int port;
	private String receiveMessage, sendMessage, user, pass;

	public Server(){}

	public Server(int port){
		this.port = port;
		System.out.println("BBS Server Initialised");
		run();
	}

	public void run(){
		try{
			ServerSocket sersock = new ServerSocket(port);
			Socket sock = sersock.accept();

			BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

			OutputStream ostream = sock.getOutputStream();
			PrintWriter pwrite = new PrintWriter(ostream, true);

			InputStream istream = sock.getInputStream();
			BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

			while(true){
				if((receiveMessage = receiveRead.readLine()) != null){
					if(receiveMessage.equals("login")){
						pwrite.println("User Name: ");
						user = receiveRead.readLine();
						System.out.println(user);

						pwrite.println("Pass: ");
						pass = receiveRead.readLine();
						System.out.println(pass);

						userLogin(user, pass);
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

	public void userLogin(String user, String pass){
		this.user = user;
		this.pass = pass;
	}
}
