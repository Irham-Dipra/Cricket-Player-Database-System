package Menu.guestMenu.searchPlayers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import Phase1.Player;
import Menu.Main;

public class showPlayerDetailsController {

    private Main main;
    private Player player;
    
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
        this.player = player;
        nameLabel.setText(player.getName());
        clubLabel.setText(player.getClub());
        countryLabel.setText(player.getCountry());
        positionLabel.setText(player.getPosition());
        salaryLabel.setText(String.valueOf(player.getSalary()));
        ageLabel.setText(String.valueOf(player.getAge()));
        jerseyLabel.setText(String.valueOf(player.getJerseyNumber()));
        heightLabel.setText(String.valueOf(player.getHeight()));
    }
}
