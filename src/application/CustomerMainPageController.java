package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerMainPageController implements Initializable {
	
	 private final DropShadow dropShadow = new DropShadow();
	
	@FXML
	Label welcome;
	
	@FXML
	Button training;
	@FXML
	Button nutrition;
	
	@FXML
	Button findFriends;
	
	@FXML
	Button music;
	

	
	
	 @FXML
	    private void onButtonMouseEntered(MouseEvent event) {
		 
		 Button button = (Button) event.getSource();
		 button.setStyle("-fx-background-color: black; -fx-text-fill: red;");
		 button.setEffect(dropShadow);
	    }
	    @FXML
	    private void onButtonMouseExited(MouseEvent event) {
	     Button button = (Button) event.getSource();
	     button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     button.setEffect(null);
	    }
	
	
	   public void gonutrition(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("nutritionMainPage.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   public void goTraining(ActionEvent event) throws IOException{
		System.out.println(Main.saveCustomer.toString());
			 Parent root = FXMLLoader.load(getClass().getResource("TrainingMainPage.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   public void findFreinds(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("joinFreinds.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
				 Alert a=new Alert(AlertType.INFORMATION);
			       a.setHeaderText("The details you enter are shown to others for the purpose of finding partners");
			       a.showAndWait();
		}
	   
	   public void viewMusic(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("viewMusic.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {


	     training.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     nutrition.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     findFriends.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     music.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	          
	
	}
	
	
	
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("LogInWithVideo.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }

}
