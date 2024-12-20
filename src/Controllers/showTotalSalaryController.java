package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class showTotalSalaryController {

    private Main main;

    @FXML
    private Label clubLabel;

    @FXML
    private Label totalSalaryLabel;

    @FXML
    public void backClicked(ActionEvent actionEvent) {
        System.out.println("Back button initiated");
        try {
            main.searchClubsMenu(); // Replace with the appropriate method to navigate back
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Sets the club name and total salary details.
     * 
     * @param clubName    Name of the club.
     * @param totalSalary Total salary of the players in the club.
     */
    public void setClubDetails(String clubName, int totalSalary) {
        clubLabel.setText(clubName);
        totalSalaryLabel.setText(String.valueOf(totalSalary));
    }
}
