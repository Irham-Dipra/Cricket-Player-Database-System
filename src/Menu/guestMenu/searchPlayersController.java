package Menu.guestMenu;
import javafx.event.ActionEvent;
import Menu.Main; // Add this import statement
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;

public class searchPlayersController {
    private Main main;

    public void searchByNameClicked(ActionEvent actionEvent)
    {
        System.out.println("search by name initiated");
        try {
            main.showSearchByName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchByClubCountryClicked(ActionEvent actionEvent)
    {
        System.out.println("search by clubs and country initiated");
        try {
            main.showSearchByClubCountry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchByPositionClicked(ActionEvent actionEvent)
    {
        System.out.println("search by position initiated");
        try {
            main.showSearchByPosition();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchBySalaryClicked(ActionEvent actionEvent)
    {
        System.out.println("search by salary initiated");
    }
    public void countryPlayerCountClicked(ActionEvent actionEvent)
    {
        System.out.println("country wise player count initiated");
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
