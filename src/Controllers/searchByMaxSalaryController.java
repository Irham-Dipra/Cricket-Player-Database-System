package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.*;

public class searchByMaxSalaryController {
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

        // Fetch the list of players with the maximum salary for the given club
        ArrayList<Player> maxSalaryPlayers = null;
        try {
            maxSalaryPlayers = main.getPlayersWithMaxSalary(clubName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (maxSalaryPlayers == null || maxSalaryPlayers.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No players found for the given club or no players with a maximum salary!");
            alert.showAndWait();
        } else {
            try {
                main.showClubsListDetails(maxSalaryPlayers); // Navigate to a screen displaying the players
            } catch (Exception e) {
                e.printStackTrace();
            }
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
