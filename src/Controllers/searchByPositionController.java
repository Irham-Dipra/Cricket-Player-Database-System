package Controllers;
import Controls.*;
import Phase1.PlayerList;
import Phase1.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.List;


public class searchByPositionController {
    private Main main;

    @FXML
    private TextField positionField;

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

        // Get the list of players by position
        List<Player> playerList = PlayerList.getSearchByPosition(position);
        
        if (playerList == null || playerList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No players found for the given position!");
            alert.showAndWait();
        } else {
            // Show player details (if you want to display in a TableView or other UI element)
            PlayerList.showAllPlayers(playerList);
            try {
                main.showPlayersListDetails(playerList); // Show the list of players (this can be customized)
            } catch (Exception e) {
                e.printStackTrace();
            }
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
