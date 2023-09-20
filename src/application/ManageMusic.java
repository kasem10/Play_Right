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
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ManageMusic implements Initializable {
	
	@FXML
	private ListView<music> music;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		music.setStyle("-fx-control-inner-background: lightgray;");
		music.getItems().addAll(Main.gym.getMusic().values());
		// TODO Auto-generated method stub
		
	}
	
	 public void AddMusic(ActionEvent event) throws IOException{
		   
		 Parent root = FXMLLoader.load(getClass().getResource("addMusic.fxml"));
		 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene cn = new Scene(root);
			st.setScene(cn);
			st.show();
			
	}
	 public void removemusic(ActionEvent event) throws IOException{
		 
		 int Select = music.getSelectionModel().getSelectedIndex();
		 if(Main.gym.removemusic((music)music.getItems().get(Select))) {
			music.getItems().remove(Select);
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully remove");
			aler.showAndWait();
			}
		 
	 }
	 
		 
	 
	 
	
	 
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }

}