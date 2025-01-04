package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.*;


public class searchByPositionController {
    private Main main;

    @FXML
    private TextField positionField;


    public void initialize() {
        // Set focus to a different component (e.g., the first button)
        // search.requestFocus();
        positionField.setFocusTraversable(false);
    }

    public void searchClicked(ActionEvent actionEvent) {
        System.out.println("search button clicked");
        String position = positionField.getText().trim(); // Get the position entered by the user
        
        // Check if position is empty
        if (position.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a position!");
            alert.showAndWait();
            return;
        }
        try {
            main.socketWrapper.write("getPlayersByPosition"); // Send the request to the server
            main.socketWrapper.write(position);
            main.socketWrapper.flush();
        } catch (IOException e) {
            main.showAlert("Error", "Network Error: Unable to send data. Please try again.");
            e.printStackTrace();
        } catch (Exception e) {
            main.showAlert("Error", "An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    public void backClicked(ActionEvent actionEvent) {
        System.out.println("back button initiated");
        try {
            main.searchPlayersMenu(); // Go back to the search players menu
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main; // Set the main application reference
    }
}
