package Menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Menu.guestMenu.guestHomePageController;
import Menu.guestMenu.searchPlayersController;
import Menu.guestMenu.searchClubsController;
import Menu.guestMenu.addPlayersController;
import Menu.guestMenu.searchPlayers.showPlayerDetailsController;
import Menu.guestMenu.searchPlayers.searchByClubCountryController;
import Menu.guestMenu.searchPlayers.searchByPositionController;
import Menu.guestMenu.searchPlayers.showPlayersListDetailsController;
import Menu.guestMenu.searchPlayers.searchByNameController;
import Menu.guestMenu.searchPlayers.searchBySalaryController;
import Menu.guestMenu.searchClubs.searchByMaxSalaryController;
import Menu.guestMenu.searchClubs.showClubsListDetailsController;
import Menu.guestMenu.searchClubs.searchByMaxHeightController;
import Menu.guestMenu.searchClubs.searchByMaxAgeController;
import Phase1.phase1Main;
import Phase1.Player;
import java.util.List;
// import javafx.scene.control.Alert;

public class Main extends Application {

    private Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showHomePage();
        // Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        // primaryStage.setTitle("Hello World");
        // primaryStage.setScene(new Scene(root, 500, 400));
        // primaryStage.setResizable(false);
        // primaryStage.show();
    }

    public void showHomePage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("home");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showGuestHomePage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/guestHomePage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        guestHomePageController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void searchPlayersMenu() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchPlayers.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchPlayersController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search Players");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void searchClubsMenu() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchClubs.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchClubsController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By Clubs");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void addPlayersMenu() throws Exception
    {
        System.out.println("ashche");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/addPlayers.fxml"));
        Parent root = loader.load();

        // Loading the controller
        addPlayersController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Add Players");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showSearchByName() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchPlayers/searchByName.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByNameController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By Name");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showPlayerDetails(Player player) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchPlayers/showPlayerDetails.fxml"));
        Parent root = loader.load();

        // Loading the controller
        showPlayerDetailsController controller = loader.getController();
        controller.setPlayer(player);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Details");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showSearchByClubCountry() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchPlayers/searchByClubCountry.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByClubCountryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By club and country");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showPlayersListDetails(List<Player> playerList) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchPlayers/showPlayersListDetails.fxml"));
        Parent root = loader.load();

        // Loading the controller
        showPlayersListDetailsController controller = loader.getController();
        controller.setPlayerList(playerList);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Details");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showClubsListDetails(List<Player> playerList) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchClubs/showClubsListDetails.fxml"));
        Parent root = loader.load();

        // Loading the controller
        showClubsListDetailsController controller = loader.getController();
        controller.setPlayerList(playerList);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Details");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showSearchByPosition() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchPlayers/searchByPosition.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByPositionController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By Position");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showSearchBySalary() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guestMenu/searchPlayers/searchBySalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchBySalaryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By Salary");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showMaxSalary() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        System.out.println("ashche");
        loader.setLocation(getClass().getResource("guestMenu/searchClubs/searchByMaxSalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByMaxSalaryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Max Salary");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
    
    public void showMaxAge() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        System.out.println("ashche");
        loader.setLocation(getClass().getResource("guestMenu/searchClubs/searchByMaxAge.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByMaxAgeController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Max Salary");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showMaxHeight() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        System.out.println("ashche");
        loader.setLocation(getClass().getResource("guestMenu/searchClubs/searchByMaxHeight.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByMaxHeightController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Max Salary");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
    
    public static void main(String[] args) {
        try {
            phase1Main.setFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);

    }

}
