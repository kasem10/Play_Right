package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class clientChatControll implements Initializable {
    @FXML
    private TextArea viewChat;

    @FXML
    private TextField clientMessage;

    @FXML
    private Button sendbtn;

    private static final DatagramSocket socket;
    static {
        try {
            socket = new DatagramSocket(); // init to any available port
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    private static final InetAddress address;

    static {
        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
    
    static String name = Main.saveCustomer.getUserName();

    private static final String identifier = name ;

    private static final int SERVER_PORT = 8000;
    
    public void send(ActionEvent event) throws IOException{
    	 String temp = identifier + ";" + clientMessage.getText(); // message to send
    	 viewChat.setText(viewChat.getText() + clientMessage.getText() + "\n"); // update messages on screen
         byte[] msg = temp.getBytes(); // convert to bytes
         clientMessage.setText(""); // remove text from input box

         // create a packet & send
         DatagramPacket send = new DatagramPacket(msg, msg.length, address, SERVER_PORT);
         try {
             socket.send(send);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         
         
     }
    	
    
    
    public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 ClientThread clientThread = new ClientThread(socket, viewChat);
	        clientThread.start();

	        // send initialization message to the server
	        byte[] uuid = ("init;" + identifier).getBytes();
	        DatagramPacket initialize = new DatagramPacket(uuid, uuid.length, address, SERVER_PORT);
	        try {
				socket.send(initialize);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}

