package Controllers;
import Controls.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class showPlayerDetailsController {

    private Main main;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private Label nameLabel;
    @FXML
    private Label clubLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label positionLabel;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label jerseyLabel;
    @FXML
    private Label heightLabel;
    String searchType;

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    // Set dynamic background image
    public void setBackgroundImage(String imagePath) {
        backgroundImage.setImage(new Image(imagePath));
    }


    @FXML
    public void backClicked(ActionEvent actionEvent)
    {
        System.out.println("back button initiated");
        try {
            main.showSearchByName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main)
    {
        this.main = main;
    }
    public void setPlayer(Player player)
    {
        nameLabel.setText(player.getName());
        clubLabel.setText(player.getClub());
        countryLabel.setText(player.getCountry());
        positionLabel.setText(player.getPosition());
        salaryLabel.setText(String.valueOf(player.getSalary()));
        ageLabel.setText(String.valueOf(player.getAge()));
        jerseyLabel.setText(String.valueOf(player.getJersey()));
        heightLabel.setText(String.valueOf(player.getHeight()));
    }
}
