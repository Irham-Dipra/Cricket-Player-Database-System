package Menu.guestMenu.searchPlayers;

import Phase1.PlayerList;
import Phase1.Player;
import javafx.event.ActionEvent;
import Menu.Main; // Add this import statement
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.List;


public class searchByClubCountryController {
    private Main main;

    @FXML
    private TextField clubField;
    @FXML
    private TextField countryField;

    
    public void searchClicked(ActionEvent actionEvent)
    {
        System.out.println("search button clicked");
        String club = clubField.getText();
        String country = countryField.getText();
        System.out.println(club + " " + country);
        List <Player> playerList = PlayerList.getSearchByClubAndCountryList(country, club);
        PlayerList.showAllPlayers(playerList);
        if(playerList.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Player not found!");
            alert.showAndWait();
        }
        else
        {
            try {
                main.showPlayersListDetails(playerList);
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
