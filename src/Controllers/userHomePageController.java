package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import Controls.*;
import java.util.ArrayList;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class userHomePageController {

    private Main main;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TableView<Player> playersTable;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableColumn<Player, Void> actionColumn;

    // Observable list to hold players
    private final ObservableList<Player> playerList = FXCollections.observableArrayList();

    // Set dynamic background image
    public void setBackgroundImage(String imagePath) {
        backgroundImage.setImage(new Image(imagePath));
    }

    @FXML
    public void init(ArrayList<Player> list) {
        // Set up the player name column
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Set up the action column for the buttons
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button detailsButton = new Button("Details");
            private final Button sellButton = new Button("Sell");

            {
                // Apply style classes for buttons
                detailsButton.getStyleClass().add("details-button");
                sellButton.getStyleClass().add("sell-button");

                // Action for Details button
                detailsButton.setOnAction(event -> {
                    Player player = getTableView().getItems().get(getIndex());
                    try {
                        main.getSocketWrapper().write("showPlayer");
                        main.getSocketWrapper().write(player);
                        main.getSocketWrapper().flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                // Action for Sell button
                sellButton.setOnAction(event -> {
                    Player player = getTableView().getItems().get(getIndex());
                    sellPlayer(player);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : createActionButtons());
            }

            private HBox createActionButtons() {
                HBox hbox = new HBox(10);
                hbox.getStyleClass().add("action-buttons");
                hbox.getChildren().addAll(detailsButton, sellButton);
                return hbox;
            }
        });

        // Load sample players
        loadPlayers(list);
    }

    // Method to load sample players
    private void loadPlayers(ArrayList<Player> list) {
        playerList.addAll(list);
        playersTable.setItems(playerList);
    }

    // Show player details (this is just a placeholder)
    private void showPlayerDetails(Player player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Player Details");
        alert.setHeaderText(player.getName());
        alert.setContentText("Details for " + player.getName());
        alert.showAndWait();
    }

    // Sell player (just a placeholder)
    private void sellPlayer(Player player) {
        playerList.remove(player);
        try {
            main.getSocketWrapper().write("sellPlayer");
            main.getSocketWrapper().write(player);
            main.getSocketWrapper().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Player Sold");
        alert.setHeaderText("Player Sold");
        alert.setContentText(player.getName() + " has been sold.");
        alert.showAndWait();
    }

    public void buyClicked(ActionEvent actionEvent) {
        System.out.println("Buy button clicked");
        try {
            main.getSocketWrapper().write("buyPlayers");
            main.getSocketWrapper().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backClicked(ActionEvent actionEvent) {
        System.out.println("Back button clicked");
        try {
            main.showUserLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
