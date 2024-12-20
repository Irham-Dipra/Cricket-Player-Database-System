package Controls;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import Controllers.*;
import java.util.Map;
import Phase1.phase1Main;
import Phase1.Player;
import java.io.IOException;
import java.util.List;
// import javafx.scene.control.Alert;

public class Main extends Application {

    private Stage stage;

    private SocketWrapper socketWrapper;

    public Stage getStage() {
        return stage;
    }

    public SocketWrapper getSocketWrapper() {
        return socketWrapper;
    }

    public void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 8080;
        socketWrapper = new SocketWrapper(serverAddress, serverPort);
        new ReadThread(this);
    }

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
        loader.setLocation(getClass().getResource("/Scenes/home.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("home");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showUserHomePage(String userName) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/userHomePage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        userHomePageController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showGuestHomePage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/guestHomePage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        guestHomePageController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showUserLoginPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 400, 250));
        stage.show();
    }

    public void searchPlayersMenu() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/searchPlayers.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchClubs.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/addPlayers.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchByName.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/showPlayerDetails.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchByClubCountry.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/showPlayersListDetails.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/showClubsListDetails.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchByPosition.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchBySalary.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchByMaxSalary.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchByMaxAge.fxml"));
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
        loader.setLocation(getClass().getResource("/Scenes/searchByMaxHeight.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByMaxHeightController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Max Salary");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showCountryPlayerCount(Map <String, Integer> countryMap) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/countryPlayerCount.fxml"));
        Parent root = loader.load();

        // Loading the controller
        countryPlayerCountController controller = loader.getController();
        controller.setCountryList(countryMap);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Country Player Count");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showSearchTotalSalary() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/searchTotalSalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchTotalSalaryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search Total Salary");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showTotalSalary(String clubName, int salary) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/showTotalSalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        showTotalSalaryController controller = loader.getController();
        controller.setClubDetails(clubName, salary);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Total Salary");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public void showInvalidLoginAlert() {
        System.out.println("Alert");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
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
