package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ManagerMainPageController implements Initializable {
	
	@FXML
    private ComboBox<String> lang;
	 @FXML
	    private Button ManageTraining;

	    @FXML
	    private Button manageMeals;

	    @FXML
	    private Button ManageMusic;

	    @FXML
	    private Button MembersTrack;

	    @FXML
	    private Button Chat;
	    @FXML
	    private Button btnback;

	    @FXML
	    private Button QA;
	    
	    @FXML
	    private Label welcome;
	
	   public void AddMeals(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("ManageMeals.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   public void Addexercise(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("ManageTraining.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   public void tracking(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("TrackingCustomers.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   
	   public void AddMusic(ActionEvent event) throws IOException{
		   
			 Parent root = FXMLLoader.load(getClass().getResource("ManageMusic.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
				
		}
	   public void chat(ActionEvent event) throws IOException{
		   
			 Parent root = FXMLLoader.load(getClass().getResource("managerChat.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
				
		}
	   
	   public void questions(ActionEvent event) throws IOException{
		   
			 Parent root = FXMLLoader.load(getClass().getResource("QuestionsAndAnswers.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
				
		}
	   
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList("English","Hebrew");
		lang.setItems(list);
		
	
	}
	
	public void changelang(ActionEvent event) throws IOException {
		
		
		if(lang.getValue().equals("English")) {
			 ManageTraining.setText("Manage Training");
			welcome.setText("Welcome manager");

		   manageMeals.setText("Manage Meals");

		   ManageMusic.setText("Manage Music");
           MembersTrack.setText("Members Track");
           Chat.setText("Chat");
           QA.setText("Questions&Answers");
           btnback.setText("back");
			
		}
		 if(lang.getValue().equals("Hebrew")) {
			 welcome.setText("ברוך הבא מנהל");
			 btnback.setText("חזור");
			
			
			 ManageTraining.setText("ניהול אימונים");
			   manageMeals.setText("ניהול ארוחות");

			   ManageMusic.setText("ניהול שירים");
	           MembersTrack.setText("מעקב");
	           Chat.setText("צא'ט");
	           QA.setText("שאלות ותשובות");
			
		}
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
