package Menu.guestMenu.searchPlayers;
import javafx.event.ActionEvent;
import Menu.Main; // Add this import statement

public class searchByNameController {
    private Main main;
    public void searchClicked(ActionEvent actionEvent)
    {
        System.out.println("search button clicked");
    }
    public void backClicked(ActionEvent actionEvent)
    {
        System.out.println("back button initiated");
        try {
            main.searchPlayersMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
