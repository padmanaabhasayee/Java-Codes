import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class OneToManyServer {
    private static CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Waiting for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket);
            ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
            clients.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private CopyOnWriteArrayList<ClientHandler> clients;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket, CopyOnWriteArrayList<ClientHandler> clients) throws IOException {
        this.socket = socket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Broadcast to all other clients
                for (ClientHandler client : clients) {
                    if (client != this) {
                        client.out.println("Client " + socket.getRemoteSocketAddress() + ": " + message);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
        } finally {
            try {
                socket.close();
                clients.remove(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}