package Menu;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import Phase1.phase1Main;


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
    void setMain(Main main) {
        this.main = main;
    }
}
