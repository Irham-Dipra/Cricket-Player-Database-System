package Menu.guestMenu.searchPlayers;
import Phase1.PlayerList;
import Phase1.Player;
import javafx.event.ActionEvent;
import Menu.Main; // Add this import statement
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class searchByNameController {
    private Main main;

    @FXML
    private TextField nameField;
    public void searchClicked(ActionEvent actionEvent)
    {
        System.out.println("search button clicked");
        String name = nameField.getText();
        Player player = PlayerList.getSearchByNamePlayer(name);
        if(player == null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Player not found!");
            alert.showAndWait();
        }
        else
        {
            PlayerList.showDetails(player);
            try {
                main.showPlayerDetails(player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void backClicked(ActionEvent actionEvent)
    {
        System.out.println("back button initiated");
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
