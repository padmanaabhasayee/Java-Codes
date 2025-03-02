import java.io.*;
import java.net.*;

public class OneToManyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server.");

        // Thread to listen for messages from server
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Disconnected from server.");
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