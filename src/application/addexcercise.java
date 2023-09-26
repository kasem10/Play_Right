package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class addexcercise implements Initializable {
	
	@FXML
	TextField name, path , desc;
	 @FXML
	    private ComboBox<String> type;

	    @FXML
	    private ComboBox<Integer> day;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<String> list = FXCollections.observableArrayList("mb3","mb4","mb5","wl3","wl4","wl5");
		type.setItems(list);
		

		ObservableList<Integer> list2 = FXCollections.observableArrayList(1,2,3,4,5);
		day.setItems(list2);
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public void submitaddex (ActionEvent event) throws IOException {
			
		exercise ex = new exercise(name.getText(),path.getText() , desc.getText());
		Main.gym.addex(ex, type.getValue(),day.getValue());
		
	//System.out.println(Main.gym.mb3.values());
		Main.update();
		
			
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
		    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }


	

}
