import java.io.*;
import java.nio.*;
import java.net.*;

public class ClientHandler {
    protected Socket client;
    protected PrintWriter out;

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            this.out = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
