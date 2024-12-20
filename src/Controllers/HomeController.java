package Controllers;
import Controls.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import Phase1.phase1Main;
import java.io.IOException;


public class HomeController {
    private Main main;
    @FXML
    private Label label;
    public void guestLoginClicked(ActionEvent actionEvent)
    {
        System.out.println("Guest Login clicked");
        try {
            main.showGuestHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void userLoginClicked(ActionEvent actionEvent)
    {
        System.out.println("User Login clicked");
        try {
            main.connectToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            main.showUserLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exitClicked(ActionEvent actionEvent)
    {
        System.out.println("Exit clicked");
        try {
            phase1Main.saveData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
