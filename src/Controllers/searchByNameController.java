package Controllers;
import java.io.IOException;

import Controls.*;
import javafx.event.ActionEvent;
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
        try {
            main.socketWrapper.write("getPlayerByName");
            main.socketWrapper.write(name);
            main.socketWrapper.flush();
        } catch (IOException e) {
            main.showAlert("Error", "Network Error: Unable to send data. Please try again.");
            e.printStackTrace();
        } catch (Exception e) {
            main.showAlert("Error", "An unexpected error occurred.");
            e.printStackTrace();
        }
        // else
        // {
        //     try {
        //         main.showPlayerDetails(player);
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // }
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
