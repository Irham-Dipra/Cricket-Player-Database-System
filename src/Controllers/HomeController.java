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
    public void loginClicked(ActionEvent actionEvent)
    {
        System.out.println("User Login clicked");
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
            main.getSocketWrapper().write("exit");
            main.getSocketWrapper().flush();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
