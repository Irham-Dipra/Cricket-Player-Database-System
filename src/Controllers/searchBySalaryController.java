package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.*;

public class searchBySalaryController {
    private Main main;

    @FXML
    private TextField minSalaryField;

    @FXML
    private TextField maxSalaryField;

    public void searchClicked(ActionEvent actionEvent) {
        System.out.println("Search button clicked");
        try {
            // Retrieve and parse salary input
            int minSalary = Integer.parseInt(minSalaryField.getText());
            int maxSalary = Integer.parseInt(maxSalaryField.getText());

            // Validate the salary range
            if (minSalary > maxSalary) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invalid Range");
                alert.setHeaderText(null);
                alert.setContentText("Minimum salary cannot be greater than maximum salary.");
                alert.showAndWait();
                return;
            }

            // Fetch players within the salary range
            ArrayList<Player> players = null;
            try {
                players = main.getPlayersBySalary(minSalary, maxSalary);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (players.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("No players found in the given salary range!");
                alert.showAndWait();
            } else {
                try {
                    main.showPlayersListDetails(players); // Navigate to a screen displaying the player list
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (NumberFormatException e) {
            // Handle invalid numeric input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numeric values for salaries.");
            alert.showAndWait();
        }
    }

    public void backClicked(ActionEvent actionEvent) {
        System.out.println("Back button clicked");
        try {
            main.searchPlayersMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
