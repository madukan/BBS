import java.net.*;
import java.io.*;

public class Server{
	public static void main(String[] args) throws Exception{
		ServerSocket sersock = new ServerSocket(1025);
		System.out.println("BBS Server Initialised!");

		Socket sock = sersock.accept();
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
}
