import java.io.*;
import java.net.*;

public class OneToOneServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        // Thread to read messages from client
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client says: " + message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
            }
        }).start();

        // Thread to send messages to client
        new Thread(() -> {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
                String serverMsg;
                while ((serverMsg = serverInput.readLine()) != null) {
                    out.println(serverMsg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}