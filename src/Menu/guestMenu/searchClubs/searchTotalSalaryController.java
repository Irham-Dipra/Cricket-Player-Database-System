package Menu.guestMenu.searchClubs;

import Phase1.PlayerList; // Ensure this import is correct and the PlayerList class exists
import javafx.event.ActionEvent;
import Menu.Main; // Import the Main class for navigation
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

        // Fetch the list of players with the maximum salary for the given club
        int total = PlayerList.getTotalSalary(clubName);
        try {
            main.showTotalSalary(clubName, total); // Navigate to a screen displaying the players
        } catch (Exception e) {
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
