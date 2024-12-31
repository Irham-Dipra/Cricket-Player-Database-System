package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
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
        try {
            main.socketWrapper.write("getPlayersByClubAndCountry");
            main.socketWrapper.write(club);
            main.socketWrapper.write(country);
            main.socketWrapper.flush();
        } catch (IOException e) {
            main.showAlert("Error", "Network Error: Unable to send data. Please try again.");
            e.printStackTrace();
        } catch (Exception e) {
            main.showAlert("Error", "An unexpected error occurred.");
            e.printStackTrace();
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
