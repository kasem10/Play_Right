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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class clientChatControll implements Initializable  {
	
	   @FXML
	    private ListView<?> viewChat;

	    @FXML
	    private TextField clientMessage;

	    @FXML
	    private Button sendbtn;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("CustomerMainPage");
		    primaryStage.show();
	 }

}
