package main;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class EmailBreachesScreenController {

    @FXML
    private TextField emailBreachesTextField;

    @FXML
    private Label emailBreachesLabel;
    
    private List<Breach> breaches;
    private int currentBreachIndex;

    @FXML
    private Button generateBreachButton;

    @FXML
    private Button nextBreachButton;

    @FXML
    private void initialize() {
        currentBreachIndex = 0;
    }

    @FXML
    private void emailBreachesButtonClicked() {
        // Get the user to input email
        String email = emailBreachesTextField.getText();

        breaches = HIBPApiService.getBreachesForEmail(email);

        if (!breaches.isEmpty()) {
            displayBreach();
        } else {
            emailBreachesLabel.setText("No breaches found for this email.");
        }
    }

    @FXML
    private void nextBreachButtonClicked() {
        if (!breaches.isEmpty()) {
            currentBreachIndex = (currentBreachIndex + 1) % breaches.size();
            displayBreach();
        }
    }

    private void displayBreach() {
        Breach currentBreach = breaches.get(currentBreachIndex);
        String currentBreachText = currentBreach.toString();
        emailBreachesLabel.setText(currentBreachText);
    }
}