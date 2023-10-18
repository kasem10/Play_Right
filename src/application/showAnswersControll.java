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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class showAnswersControll implements Initializable {
	
    @FXML
    private TextField clientMessage;

    @FXML
    private Button sendbtn;

    @FXML
    private VBox viewAns;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		
		clientMessage.setStyle("-fx-control-inner-background: lightgray;");
		
		// TODO Auto-generated method stub
		
		
            // Create a new label with the entered text
            Label newLabel = new Label(Main.saveQuestion.getAsker() + ": " + Main.saveQuestion.getQuestionText());

            // Add the new label to the container
            viewAns.getChildren().add(newLabel);
            
            Label viewLabel = new Label("Answers: ");
            viewAns.getChildren().add(viewLabel);
            
            for(String ans: Main.saveQuestion.getAnswers()) {
            	
            	 Label newLabelANS = new Label(ans);
            	 viewAns.getChildren().add(newLabelANS);
            }
            
		}
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("QuestionsAndAnswers.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }
	 
	   @FXML
	    private void sendMessage(ActionEvent event) {
	        String text = clientMessage.getText();
	        
	        String name;
	        if(Main.saveCustomer!=null) {
	        	name= Main.saveCustomer.getFirstName();
	        }
	        else {
	        	name= "manager";
	        }

	        // Create a new label with the entered text
	        Label newLabel = new Label(name+": "+ text);
	        
	        Main.saveQuestion.getAnswers().add(newLabel.getText());
	        Main.update();
	        
	       
	        // Add the new label to the container
	        viewAns.getChildren().add(newLabel);
	        
	        
	        
	       

	        // Clear the text field
	        clientMessage.clear();
	    }
	    

}
