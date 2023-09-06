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
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class musicControll implements Initializable {
	
	@FXML
	private MediaView mediaView;
	
	@FXML 
	private Slider controlVolume;
	
	@FXML
	private ListView<music> music;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		music.getItems().addAll(Main.gym.getMusic().values());
		controlVolume.setValue(Main.saveMediaPlayer.getVolume() * 100);
		controlVolume.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				
				Main.saveMediaPlayer.setVolume(controlVolume.getValue() / 100);
				
			}
			
			
		});
		
	}
	
	 public void playMusic(ActionEvent event) throws IOException{
		 
		     int Select = music.getSelectionModel().getSelectedIndex(); 
		 
		    Media media = new Media(getClass().getResource(music.getItems().get(Select).getPath()).toString());
			MediaPlayer player = new MediaPlayer(media);
			Main.saveMediaPlayer = player;
			mediaView.setMediaPlayer(Main.saveMediaPlayer);
			Main.saveMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			Main.saveMediaPlayer.setVolume(0.2);
			Main.saveMediaPlayer.play();
			controlVolume.setValue(Main.saveMediaPlayer.getVolume() * 100);
			controlVolume.valueProperty().addListener(new InvalidationListener() {

				@Override
				public void invalidated(Observable observable) {
					
					Main.saveMediaPlayer.setVolume(controlVolume.getValue() / 100);
					
				}
				
				
			});
	 }
	 
	 public void stopMusic(ActionEvent event) throws IOException{
		 Main.saveMediaPlayer.stop();
	 }
	
	
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }

}
