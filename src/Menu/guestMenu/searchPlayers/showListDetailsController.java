package Menu.guestMenu.searchPlayers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Phase1.Player;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import Menu.Main;


public class showListDetailsController {

    private Menu.Main main;

    @FXML
    private TableView<Player> table;

    @FXML
    private TableColumn<Player, Integer> age;

    @FXML
    private TableColumn<Player, String> club;

    @FXML
    private TableColumn<Player, String> country;

    @FXML
    private TableColumn<Player, Integer> height;

    @FXML
    private TableColumn<Player, Integer> jersey;

    @FXML
    private TableColumn<Player, String> name;

    @FXML
    private TableColumn<Player, String> position;

    @FXML
    private TableColumn<Player, Integer> salary;

    ObservableList<Player> playerList = FXCollections.observableArrayList(
            // new Player("Lionel Messi", "Argentina", 33, 170, "Barcelona", "Forward", 10, 1000000, true),
            // new Player("Cristiano Ronaldo", "Portugal", 35, 188, "Juventus", "Forward", 7, 1000000, true),
            // new Player("Neymar Jr", "Brazil", 28, 175, "PSG", "Forward", 10, 1000000, true),
            // new Player("Kylian Mbappe", "France", 21, 178, "PSG", "Forward", 7, 1000000, true),
            // new Player("Mohamed Salah", "Egypt", 28, 175, "Liverpool", "Forward", 11, 1000000, true),
            // new Player("Sadio Mane", "Senegal", 28, 175, "Liverpool", "Forward", 10, 1000000, true)
    );
    public void setPlayerList(List<Player> playerList)
    {
        for(Player player: playerList)
        {
            this.playerList.add(player);
        }
    }
    public void initialize()
    {
        name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        country.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
        age.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
        height.setCellValueFactory(new PropertyValueFactory<Player, Integer>("height"));
        club.setCellValueFactory(new PropertyValueFactory<Player, String>("club"));
        position.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
        jersey.setCellValueFactory(new PropertyValueFactory<Player, Integer>("jersey"));
        salary.setCellValueFactory(new PropertyValueFactory<Player, Integer>("salary"));

        table.setItems(playerList);
    }
    public void setMain(Main main)
    {
        this.main = main;
    }
    public void backClicked(ActionEvent actionEvent)
    {
        System.out.println("back button initiated");
        try {
            main.showSearchByClubCountry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
