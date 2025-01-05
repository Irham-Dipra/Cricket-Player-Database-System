package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.util.*;

import Controls.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class buyPlayerListController {

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
            private final Button buyButton = new Button("Buy");

            {
                // Button styles
                detailsButton.setStyle("-fx-background-color: #1abc9c; -fx-text-fill: white; -fx-font-weight: bold;");
                buyButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");

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

                // Action for Buy button
                buyButton.setOnAction(event -> {
                    Player player = getTableView().getItems().get(getIndex());
                    buyPlayer(player);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : createActionButtons());
            }

            private HBox createActionButtons() {
                HBox hbox = new HBox(10);
                hbox.getChildren().addAll(detailsButton, buyButton);
                return hbox;
            }
        });

        // Load sample players
        loadPlayers(list);
    }

    // Method to load players
    private void loadPlayers(ArrayList<Player> list) {
        listOperations.showAllPlayers(list);
        playerList.addAll(list);
        playersTable.setItems(playerList);
    }


    // Buy player
    private void buyPlayer(Player player) {
        playerList.remove(player);
        try {
            main.getSocketWrapper().write("playerBought");
            main.getSocketWrapper().write(player);
            main.getSocketWrapper().write(main.getClubName());
            main.getSocketWrapper().flush();
        } catch (IOException e) {
            // TODO: handle exception
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Player Bought");
        alert.setHeaderText("Player Bought");
        alert.setContentText(player.getName() + " has been bought.");
        alert.showAndWait();
    }

    public void backClicked() {
        System.out.println("Back button clicked");
        try {
            main.getSocketWrapper().write("backToClubList");
            main.getSocketWrapper().write(main.getClubName());
            main.getSocketWrapper().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
