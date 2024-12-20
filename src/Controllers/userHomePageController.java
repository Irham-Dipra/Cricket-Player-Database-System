package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class userHomePageController {

    private Main main;

    @FXML
    private Label message;

    @FXML
    private ImageView image;

    @FXML
    private Button button;

    public void init(String msg) {
        message.setText(msg);
        Image img = new Image(Main.class.getResourceAsStream("1.png"));
        image.setImage(img);
    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showUserLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
