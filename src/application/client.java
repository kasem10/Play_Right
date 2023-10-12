package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class client extends Application {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String username;

    private TextArea chatArea;
    private TextField messageField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat Client");

        chatArea = new TextArea();
        chatArea.setEditable(false);
        messageField = new TextField();
        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(chatArea, messageField, sendButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(event -> {
            try {
                writer.println("exit");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        connectToServer();

        primaryStage.show();
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 12345);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            // Prompt the user for their username
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Username");
            dialog.setHeaderText("Enter your username:");
            dialog.setContentText("Username:");
            dialog.showAndWait().ifPresent(username -> {
                this.username = username;
                writer.println(username);

                server.setUserType(socket, "regular"); // You can set the user type here
            });

            Thread messageReader = new Thread(this::readMessages);
            messageReader.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessages() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                final String finalMessage = message;
                Platform.runLater(() -> chatArea.appendText(finalMessage + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            writer.println(message);
            messageField.clear();
        }
    }
}

