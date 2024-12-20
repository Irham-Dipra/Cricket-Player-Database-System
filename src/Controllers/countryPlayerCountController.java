package Controllers;
import Controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Map;
import Phase1.PlayerList;

public class countryPlayerCountController {

    private Main main;

    @FXML
    private TableView<PlayerList.CountryPlayerCount> table;

    @FXML
    private TableColumn<PlayerList.CountryPlayerCount, String> country;

    @FXML
    private TableColumn<PlayerList.CountryPlayerCount, Integer> playerCount;

    private ObservableList<PlayerList.CountryPlayerCount> countryList = FXCollections.observableArrayList();

    public void setCountryList(Map<String, Integer> countryMap) {
        for (Map.Entry<String, Integer> entry : countryMap.entrySet()) {
            countryList.add(new PlayerList.CountryPlayerCount(entry.getKey(), entry.getValue()));
        }
    }

    public void initialize() {
        country.setCellValueFactory(new PropertyValueFactory<>("country"));
        playerCount.setCellValueFactory(new PropertyValueFactory<>("playerCount"));

        table.setItems(countryList);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void backClicked(ActionEvent actionEvent) {
        System.out.println("back button initiated");
        try {
            main.searchPlayersMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
