package application;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class weightLose3TrainingController implements Initializable {
	/**
	 * 
	 */

	
	
	int x=0;;
	
	
	
	ArrayList<exercise> workedone = new ArrayList<exercise>();
	
	@FXML
    private MediaView ex1;
	
	MediaPlayer player;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		

		
	if(Main.saveperviospage == "MB3") {
		workedone.clear();
		workedone.addAll(Main.gym.getMuscleBuilding3days());	
	}
	if(Main.saveperviospage == "WL3") {
		workedone.clear();
		workedone.addAll(Main.gym.getWeightlose3daya());	
	}
	
	  String firstone = workedone.get(0).path;
		Media media = new Media(getClass().getResource("/Images/"+firstone ).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);
		
		
	
		
	
	}
	
	public void next(ActionEvent event) throws IOException {
		x++;
		String worked = workedone.get(x).path;
		Media media = new Media(getClass().getResource("/Images/" +worked).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);
	}
public void back1(ActionEvent event) throws IOException {
	
	if(x>0) {
		x--;
	}

	   String worked = workedone.get(x).path;
		Media media = new Media(getClass().getResource("/Images/"+worked).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);
	}


public void back(ActionEvent event) throws IOException{
	String page ="";
	
	if(Main.category == "WL3") {
		page="wieghtLose3Days.fxml";
	}
	if(Main.category == "WL4") {
		page="wieghtLose4Days.fxml";
	}
	if(Main.category == "WL5") {
		page="wieghtLose5Days.fxml";
	}
	if(Main.category == "MB3") {
		page="MuscleBuilding3Days.fxml";
	}
	if(Main.category == "MB4") {
		page="MuscleBuilding3Days.fxml";
	}
	if(Main.category == "MB5") {
		page="MuscleBuilding3Days.fxml";
	}
	 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource(page));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("SignUp");
	    primaryStage.show();
}
	
	
	

}
