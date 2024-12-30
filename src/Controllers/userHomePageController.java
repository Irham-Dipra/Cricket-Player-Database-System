package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

import Controls.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class userHomePageController {

    public Main main;

    @FXML
    private TableView<Player> playersTable;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableColumn<Player, Void> actionColumn;

    // Observable list to hold players
    private final ObservableList<Player> playerList = FXCollections.observableArrayList();

    // Initialize the controller
    @FXML
    public void init(ArrayList<Player> list) {
        // Set up the player name column
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Set up the action column for the buttons
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button detailsButton = new Button("Details");
            private final Button sellButton = new Button("Sell");

            {
                // Button styles
                detailsButton.setStyle("-fx-background-color: #1abc9c; -fx-text-fill: white; -fx-font-weight: bold;");
                sellButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");

                // Action for Details button
                detailsButton.setOnAction(event -> {
                    Player player = getTableView().getItems().get(getIndex());
                    showPlayerDetails(player);
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
                hbox.getChildren().addAll(detailsButton, sellButton);
                return hbox;
            }
        });

        // Load sample players
        loadPlayers(list);
    }

    // Method to load sample players
    private void loadPlayers(ArrayList<Player> list) {
        listOperations.showAllPlayers(list);
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Player Sold");
        alert.setHeaderText("Player Sold");
        alert.setContentText(player.getName() + " has been sold.");
        alert.showAndWait();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
