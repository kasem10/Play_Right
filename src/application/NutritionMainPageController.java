package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NutritionMainPageController implements Initializable {
	
    @FXML
    private Label welcome;

    @FXML
    private TextField age;

    @FXML
    private TextField height;

    @FXML
    private TextField weight;

    @FXML
    private Label result;
    
    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;
    
    
    
    public void calc(ActionEvent event) throws IOException{
    	
    	double heightCm = Double.parseDouble(height.getText());
        double weightKg = Double.parseDouble(weight.getText());
        int ageYears = Integer.parseInt(age.getText());

        boolean isMale = male.isSelected();
        boolean isFemale = female.isSelected();

        if (!isMale && !isFemale) {
            result.setText("Please select gender.");
            return;
        }

        // Calculate BMI
        double bmi = weightKg / ((heightCm / 100.0) * (heightCm / 100.0));

        // Calculate recommended calorie intake, protein, and carbohydrates
        double recommendedCalories = calculateRecommendedCalories(weightKg, heightCm, ageYears, isMale);
        double recommendedProtein = calculateRecommendedProtein(weightKg, isMale);
        double recommendedCarbs = calculateRecommendedCarbs(recommendedCalories);

        // Display results in the label
        String resultText = "BMI: " + String.format("%.2f", bmi) + "\n";
        resultText += "Recommended Calories in day: " + String.format("%.2f", recommendedCalories) +
                "\nRecommended Protein in day: " + String.format("%.2f", recommendedProtein) +
                "\nRecommended Carbs in day: " + String.format("%.2f", recommendedCarbs);

        result.setText(resultText);
		 
	}
    
    private double calculateRecommendedCalories(double weightKg, double heightCm, int ageYears, boolean isMale) {
        // Implement your calorie calculation logic here
        // This is just a placeholder example
        double baseCalories = isMale ? 66.5 : 655.1;
        double weightFactor = isMale ? 13.75 : 9.56;
        double heightFactor = isMale ? 5.003 : 1.85;
        double ageFactor = isMale ? 6.75 : 4.68;

        return baseCalories + (weightFactor * weightKg) + (heightFactor * heightCm) - (ageFactor * ageYears);
    }

    private double calculateRecommendedProtein(double weightKg, boolean isMale) {
        // Implement your protein calculation logic here
        // This is just a placeholder example
        return isMale ? weightKg * 1.2 : weightKg * 1.1;
    }

    private double calculateRecommendedCarbs(double recommendedCalories) {
        // Implement your carbohydrate calculation logic here
        // This is just a placeholder example
        return recommendedCalories * 0.6;
    }
	
	
	
	
	
	   
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	   
	
	}
	

}
