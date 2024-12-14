package Menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import Menu.guestMenu.guestHomePageController;
import Menu.guestMenu.searchPlayersController;
import Menu.guestMenu.searchClubsController;
import Menu.guestMenu.addPlayersController;
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
        loader.setLocation(getClass().getResource("guestHomePage.fxml"));
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
        loader.setLocation(getClass().getResource("Menu/guestMenu/searchPlayers.fxml"));
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
        loader.setLocation(getClass().getResource("searchClubs.fxml"));
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
        loader.setLocation(getClass().getResource("addPlayers.fxml"));
        Parent root = loader.load();

        // Loading the controller
        addPlayersController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Add Players");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showWrongInputAlert(String str)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect " + str + " format");
        alert.setHeaderText("Incorrect input format");
        alert.setContentText("The " + str + " format is not correct.");
        alert.showAndWait();
    }
}
