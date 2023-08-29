package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class weightLose3TrainingController implements Initializable {
	
	
	@FXML
    private MediaView ex1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Media media = new Media(getClass().getResource("/Images/yes.mp4").toString());
		MediaPlayer player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.play();
		ex1.setMediaPlayer(player);
		
		
		
		// TODO Auto-generated method stub
		
	}
	
	

}
