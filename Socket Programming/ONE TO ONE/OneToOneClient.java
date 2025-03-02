import java.io.*;
import java.net.*;

public class OneToOneClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server.");

        // Thread to read messages from server
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println("Server says: " + response);
                }
            } catch (IOException e) {
                System.out.println("Server disconnected.");
            }
        }).start();

        // Thread to send messages to server
        new Thread(() -> {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String userMsg;
                while ((userMsg = userInput.readLine()) != null) {
                    out.println(userMsg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}