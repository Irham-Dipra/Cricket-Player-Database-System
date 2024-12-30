package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.*;


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
        ArrayList <Player> playerList = null;
        try {
            playerList = main.getPlayersByClubAndCountry(country, club);
        } catch (Exception e) {
            // TODO: handle exception
        }
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
