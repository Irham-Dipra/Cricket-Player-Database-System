package Controllers;

import Controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import java.io.IOException;

import java.util.ArrayList;

public class showClubListDetailsController {

    @FXML private TableView<Player> playerTable;
    @FXML private TableColumn<Player, String> nameColumn;
    @FXML private TableColumn<Player, Player> infoColumn;
    @FXML private TableColumn<Player, Player> actionColumn;
    @FXML private TextField commandField;
    private Main main;
    private String searchType;

    private ArrayList<Player> playerList;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    @FXML
    public void init() {
        // Set up name column
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Set up info column with custom cell factory
        infoColumn.setCellValueFactory(param -> new javafx.beans.property.SimpleObjectProperty<>(param.getValue()));
        infoColumn.setCellFactory(createInfoCellFactory());

        // Set up action column with custom cell factory for buttons
        actionColumn.setCellValueFactory(param -> new javafx.beans.property.SimpleObjectProperty<>(param.getValue()));
        actionColumn.setCellFactory(createActionCellFactory());

        updatePlayerTable();
        System.out.println("search type: " + searchType);
    }

    private void updatePlayerTable() {
        playerTable.getItems().clear();
        playerTable.getItems().addAll(playerList);

        // Save the command in a way accessible to the cell factory
        playerTable.setUserData(searchType);
    }

    private Callback<TableColumn<Player, Player>, TableCell<Player, Player>> createInfoCellFactory() {
        return param -> new TableCell<>() {
            @Override
            protected void updateItem(Player player, boolean empty) {
                super.updateItem(player, empty);
                if (empty || player == null) {
                    setGraphic(null);
                } else {
                    String command = (String) getTableView().getUserData();
                    HBox infoBox = new HBox(10);
                    infoBox.getStyleClass().add("info-box");
                    System.out.println("command: " + command);

                    if (command != null) {
                        // Handle different commands
                        switch (command) {
                            case "searchClubCountry":
                                infoBox.getChildren().addAll(
                                    createLabel("Club: " + player.getClub()),
                                    createLabel("Country: " + player.getCountry())
                                );
                                break;
                            case "searchPosition":
                                break;
                            case "searchMaxAge":
                                infoBox.getChildren().add(createLabel("Age: " + player.getAge()));
                                break;
                            case "searchMaxHeight":
                                infoBox.getChildren().add(createLabel("Height: " + player.getHeight()));
                                break;
                            case "searchMaxSalary":
                                infoBox.getChildren().add(createLabel("Salary: " + player.getSalary()));
                                break;
                            case "searchSalary":
                                infoBox.getChildren().add(createLabel("Salary: " + player.getSalary()));
                                break;
                            default:
                                infoBox.getChildren().add(createLabel("Invalid command."));
                        }
                    }

                    setGraphic(infoBox);
                }
            }
        };
    }

    private Callback<TableColumn<Player, Player>, TableCell<Player, Player>> createActionCellFactory() {
        return param -> new TableCell<>() {
            @Override
            protected void updateItem(Player player, boolean empty) {
                super.updateItem(player, empty);
                if (empty || player == null) {
                    setGraphic(null);
                } else {
                    HBox actionBox = new HBox(10);
                    actionBox.getStyleClass().add("action-box");

                    // "View" Button
                    Button viewButton = new Button("Details");
                    viewButton.getStyleClass().add("modern-button");
                    viewButton.setOnAction(e -> {
                        try {
                            main.showPlayerAlertDetails(player);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });

                    actionBox.getChildren().addAll(viewButton);
                    setGraphic(actionBox);
                }
            }
        };
    }

    private Text createLabel(String text) {
        Text label = new Text(text);
        label.setFill(Color.DARKGRAY); // Add color styling
        label.getStyleClass().add("info-label"); // Optionally apply CSS
        return label;
    }

    private void showFullInfo(Player player) {
        // Display full information about the player (dialog, alert, or new screen)
        listOperations.showDetails(player);
    }

    private void editPlayer(Player player) {
        // Code to edit player details
        System.out.println("Editing player: " + player.getName());
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void backClicked(ActionEvent actionEvent) {
        try {
            if (searchType.equals("searchClubCountry")) {
                main.showSearchByClubCountry();
            } else if (searchType.equals("searchPosition")) {
                main.showSearchByPosition();
            } else if (searchType.equals("searchSalary")) {
                main.showSearchBySalary();
            } else if (searchType.equals("searchMaxSalary")) {
                main.showMaxSalary();
            } else if (searchType.equals("searchMaxAge")) {
                main.showMaxAge();
            } else if (searchType.equals("searchMaxHeight")) {
                main.showMaxHeight();
            } else {
                main.showGuestHomePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
