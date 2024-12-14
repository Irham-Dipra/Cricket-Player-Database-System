package Menu;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;


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
    void setMain(Main main) {
        this.main = main;
    }
}
