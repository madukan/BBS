import java.io.*;
import java.nio.*;
import java.net.*;

class test2
{
	public test2(){}

	public static void main(String[] args){
        	try{
            		final ServerSocket serverSocket = new ServerSocket(23);
            		new Thread("BBS Server"){
                		public void run(){
                    			try{
                        			System.out.println("BBS Server Running . . .");
                        			Socket socket = null;
                        
						while((socket = serverSocket.accept()) != null){
                            				System.out.println("Incoming : " + socket.toString());
                        			}
                    			}
					catch(Exception e){
                        			e.printStackTrace();
                    			}
                		};
            		}.start();
        	}
		catch(Exception ex){
            		ex.printStackTrace();
        	}
    	}
}
