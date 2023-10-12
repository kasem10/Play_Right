package application;

	
	import java.io.*;
	import java.net.*;
	import java.util.*;
	import java.util.concurrent.ConcurrentHashMap;

	public class server {
	    private static final int PORT = 12345;
	    private static Map<Socket, PrintWriter> clients = new ConcurrentHashMap<>();
	    private static Map<Socket, String> userTypes = new ConcurrentHashMap<>();

	    public static void main(String[] args) {
	        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
	            System.out.println("Chat server is running on port " + PORT);

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("New client connected");

	                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
	                clients.put(clientSocket, writer);

	                clientHandler client = new clientHandler(clientSocket, writer);
	                client.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void broadcastMessage(Socket sender, String message) {
	        String senderType = userTypes.get(sender);
	        for (Socket client : clients.keySet()) {
	            if (client != sender) {
	                String receiverType = userTypes.get(client);
	                if (senderType.equals("manager") || receiverType.equals("manager")) {
	                    clients.get(client).println(userTypes.get(sender) + ": " + message);
	                }
	            }
	        }
	    }

	    public static void setUserType(Socket socket, String userType) {
	        userTypes.put(socket, userType);
	    }
	}



