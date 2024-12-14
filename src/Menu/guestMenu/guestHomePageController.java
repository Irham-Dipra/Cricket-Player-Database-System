package Menu.guestMenu;
import javafx.event.ActionEvent;
import Menu.Main; // Add this import statement
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;

public class guestHomePageController {
    private Main main;

    public void searchPlayersClicked(ActionEvent actionEvent)
    {
        System.out.println("search players initiated");
        try {
            main.searchPlayersMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchClubsClicked(ActionEvent actionEvent)
    {
        System.out.println("search clubs initiated");
        try {
            main.searchClubsMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addPlayersClicked(ActionEvent actionEvent)
    {
        System.out.println("add players initiated");
        try {
            main.addPlayersMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void backClicked(ActionEvent actionEvent)
    {
        System.out.println("back button initiated");
        try {
            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
