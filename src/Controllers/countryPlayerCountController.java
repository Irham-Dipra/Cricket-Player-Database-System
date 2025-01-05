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

public class countryPlayerCountController {

    private Main main;

    @FXML
    private TableView<Main.CountryPlayerCount> table;

    @FXML
    private TableColumn<Main.CountryPlayerCount, String> country;

    @FXML
    private TableColumn<Main.CountryPlayerCount, Integer> playerCount;

    private ObservableList<Main.CountryPlayerCount> countryList = FXCollections.observableArrayList();

    public void setCountryList(Map<String, Integer> countryMap) {
        for (Map.Entry<String, Integer> entry : countryMap.entrySet()) {
            countryList.add(new Main.CountryPlayerCount(entry.getKey(), entry.getValue()));
        }
    }

    public void init() {
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
