package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class addMusic {
	
	@FXML
	TextField name, path;
	
	
	
	
	
	public void submitaddMusic (ActionEvent event) throws IOException {
			
		music music = new music(name.getText(),path.getText());
		
		
		checkid(music);
		if(Main.gym.addMusic(music)) {
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully add");
			aler.showAndWait();	
			
				}
			
		}
	
	
	public void checkid(music music) {
		int x=0;
		for(int c : Main.gym.getMusic().keySet()) {
			if(c>x)
				x=c;
		}
		music.setId(x+1);
		return;
	}
	
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("ManageMusic.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }

}
