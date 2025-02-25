package Controls;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Controllers.*;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Main extends Application {

    
    private Stage stage;
    public static HashMap<String, String> userMap;
    public static HashMap<String, String> imageMap;
    public SocketWrapper socketWrapper;
    public String clubName;

    public Stage getStage() {
        return stage;
    }

    public SocketWrapper getSocketWrapper() {
        return socketWrapper;
    }

    public void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 8080;
        socketWrapper = new SocketWrapper(serverAddress, serverPort, "ClientSocketWrapper");
        System.out.println("socketWrapper created" + socketWrapper.name);
        new ReadThread(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        connectToServer();
        showHomePage();
        // Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        // primaryStage.setTitle("Hello World");
        // primaryStage.setScene(new Scene(root, 875, 524));
        // primaryStage.setResizable(false);
        // primaryStage.show();
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubName() {
        return clubName;
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
        stage.setScene(new Scene(root, 875, 524));
        stage.show();
    }

    public void showUserHomePage(String userName, ArrayList <Player> playerList, String imagePath) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/userHomePage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        userHomePageController controller = loader.getController();
        controller.setMain(this);
        controller.setBackgroundImage(imagePath);
        controller.init(playerList);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
        stage.show();
    }

    public void showPlayerDetails(Player player, String imagePath) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/showPlayerDetails.fxml"));
        Parent root = loader.load();

        // Loading the controller
        showPlayerDetailsController controller = loader.getController();
        controller.setPlayer(player);
        controller.setBackgroundImage(imagePath);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Details");
        stage.setScene(new Scene(root, 875, 524));
        stage.show();
    }

    public void showSearchByClubCountry() throws Exception
    {
        System.out.println("main e ashche search by club country");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/searchByClubCountry.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchByClubCountryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By club and country");
        stage.setScene(new Scene(root, 875, 524));
        stage.show();
    }

    public void showPlayersListDetails(ArrayList<Player> playerList) throws Exception
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
        stage.setScene(new Scene(root, 875, 524));
        stage.show();
    }

    public void showClubListDetails(ArrayList<Player> playerList, String searchType) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/showClubListDetails.fxml"));
        Parent root = loader.load();

        // Loading the controller
        showClubListDetailsController controller = loader.getController();
        controller.setPlayerList(playerList);
        controller.setSearchType(searchType);
        controller.setMain(this);
        controller.init();

        // Set the primary stage
        stage.setTitle("Player Details");
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        controller.init();

        // Set the primary stage
        stage.setTitle("Country Player Count");
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
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
        stage.setScene(new Scene(root, 875, 524));
        stage.show();
    }

    public void showBuyPlayerList(ArrayList<Player> playerList, String imagePath) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Scenes/buyPlayerList.fxml"));
        Parent root = loader.load();

        // Loading the controller
        buyPlayerListController controller = loader.getController();
        controller.setBackgroundImage(imagePath);
        controller.setMain(this);
        controller.init(playerList);

        // Set the primary stage
        stage.setTitle("Buy Player List");
        stage.setScene(new Scene(root, 875, 524));
        stage.show();
    }

    public void showAlert(String head, String msg)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(head);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void showInvalidLoginAlert() {
        System.out.println("Alert");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }

    public static class CountryPlayerCount {
        private final String country;
        private final Integer playerCount;
    
        public CountryPlayerCount(String country, Integer playerCount) {
            this.country = country;
            this.playerCount = playerCount;
        }
    
        public String getCountry() {
            return country;
        }
    
        public Integer getPlayerCount() {
            return playerCount;
        }
    }

    public void showPlayerAlertDetails(Player player) throws IOException {
        // Create a new alert with INFORMATION type
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Player Details");
        alert.setHeaderText(player.getName());

        // Create a VBox to hold the content
        VBox vbox = new VBox(15); // Spacing between labels

        // Create and add labels for player details
        Label ageLabel = new Label("Age: " + player.getAge());
        Label positionLabel = new Label("Position: " + player.getPosition());
        Label countryLabel = new Label("Country: " + player.getCountry());
        Label clubLabel = new Label("Club: " + player.getClub());
        Label salaryLabel = new Label("Value: " + player.getSalary());
        Label jerseyLabel = new Label("Jersey No: " + player.getJersey());

        // Set custom font size and style for labels
        Font labelFont = new Font("Robota", 14); // Font size 14 for better readability
        ageLabel.setFont(labelFont);
        positionLabel.setFont(labelFont);
        countryLabel.setFont(labelFont);
        clubLabel.setFont(labelFont);
        salaryLabel.setFont(labelFont);
        jerseyLabel.setFont(labelFont);

        // Add labels to VBox
        vbox.getChildren().addAll(ageLabel, positionLabel, countryLabel, clubLabel, salaryLabel, jerseyLabel);

        // Set the custom content for the alert using VBox
        alert.getDialogPane().setContent(vbox);

        // Set custom width and height for the alert window
        alert.getDialogPane().setPrefSize(400, 300); // You can adjust these values

        // Apply CSS styles (Optional: define styles in a separate CSS file)
        alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());

        // Show the alert
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
