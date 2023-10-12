package application;

import java.io.*;
import java.net.Socket;

public class clientHandler extends Thread {
    private Socket clientSocket;
    private PrintWriter writer;

    public clientHandler(Socket socket, PrintWriter writer) {
        this.clientSocket = socket;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message;

            while ((message = reader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Client disconnected");
                    break;
                }

                System.out.println("Received message: " + message);

                // Handle the message, e.g., by broadcasting it to other clients
                server.broadcastMessage(clientSocket, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}

