package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class LogInWithVideoCont implements Initializable {
	
	@FXML
	private MediaView mediaView;
	
	@FXML 
	private Label lblStatus;
	
	@FXML 
	private TextField userNameText;
	
	@FXML 
	private PasswordField passwordText;
	
	@FXML 
	private Slider controlVolume;

	/* adding a video to be a background for login page */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Media media = new Media(getClass().getResource("/Images/videoBackground.mp4").toString());
		MediaPlayer player = new MediaPlayer(media);
		Main.saveMediaPlayer = player;
		mediaView.setMediaPlayer(Main.saveMediaPlayer);
		Main.saveMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		Main.saveMediaPlayer.setVolume(1);
		Main.saveMediaPlayer.play();
		controlVolume.setValue(Main.saveMediaPlayer.getVolume() * 100);
		controlVolume.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				
				Main.saveMediaPlayer.setVolume(controlVolume.getValue() / 100);
				
			}
			
			
		});
		
	}
	
	
	/* Check if it's a manager or a client and everything's fine  */
    public void Login(ActionEvent event) throws IOException {
		
    	
		if(userNameText.getText().equals("manager") && passwordText.getText().equals("manager")) {
			lblStatus.setText("Login Success");
			Main.saveMediaPlayer.setVolume(0);
			Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
			Scene scene = new Scene(root,623,627);
			Image icon = new Image("/Images/icon.png");
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manager screen");
			primaryStage.show();
		}
		else {
			for(Customer cust : Main.gym.getCustomers().values()) {
				if((userNameText.getText() != "") && (passwordText.getText() != "") && cust.getUserName().equals(userNameText.getText())&&cust.getPassword().equals(passwordText.getText())){
					Main.saveCustomer=cust;
					Main.saveMediaPlayer.setVolume(0);
					Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
					Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
					Scene scene = new Scene(root,623,627);
					Image icon = new Image("/Images/icon.png");
					primaryStage.getIcons().add(icon);
					primaryStage.setScene(scene);
					primaryStage.setTitle("Customer screen");
					primaryStage.show();
					
				}
				else {
					lblStatus.setText("Login Failed");
				}
			}
		
		}
		
	}
	
     /* go to sign up screen */
     public void SignUp(ActionEvent event) throws IOException{
    	Main.saveMediaPlayer.setVolume(0);
	    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
	    Scene scene = new Scene(root,700,620);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("SignUp");
	    primaryStage.show();
    }

	

}
