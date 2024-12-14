package Menu.guestMenu;
import javafx.event.ActionEvent;
import Menu.Main; // Add this import statement
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;

public class searchClubsController {
    private Main main;

    public void maxSalaryClicked(ActionEvent actionEvent)
    {
        System.out.println("max Salary initiated");
    }
    public void maxAgeClicked(ActionEvent actionEvent)
    {
        System.out.println("max Age initiated");
    }
    public void maxHeightClicked(ActionEvent actionEvent)
    {
        System.out.println("max Height initiated");
    }
    public void totalSalaryClicked(ActionEvent actionEvent)
    {
        System.out.println("total salary initiated");
    }
    public void backClicked(ActionEvent actionEvent)
    {
        System.out.println("back button initiated");
        try {
            main.showGuestHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
