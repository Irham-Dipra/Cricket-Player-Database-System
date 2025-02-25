package Controllers;
import java.io.IOException;

import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class searchTotalSalaryController {
    private Main main;

    @FXML
    private TextField clubField; // TextField for entering the club name


    public void searchClicked(ActionEvent actionEvent) {
        System.out.println("Search button clicked");
        String clubName = clubField.getText();

        // Validate input
        if (clubName == null || clubName.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Club name cannot be empty. Please enter a valid club name.");
            alert.showAndWait();
            return;
        }

        try {
            main.socketWrapper.write("getTotalSalary");
            main.socketWrapper.write(clubName);
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
        System.out.println("Back button clicked");
        try {
            main.searchClubsMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
