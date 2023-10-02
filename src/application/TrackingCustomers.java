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

public class TrackingCustomers implements Initializable {
	
	@FXML
	private ListView<Customer> customers;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		customers.setStyle("-fx-control-inner-background: lightgray;");
		
		customers.getItems().addAll(Main.gym.getCustomers().values());
		
	}
	
	
	 
		 
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }

}
