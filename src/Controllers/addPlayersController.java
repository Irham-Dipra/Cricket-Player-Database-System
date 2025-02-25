package Controllers;
import Controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class addPlayersController {

    private Main main;
    String name, country, club, position;
    int age, jersey, salary;
    double height;
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField countryField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField clubField;

    @FXML
    private TextField jerseyField;

    @FXML
    private TextField salaryField;

    @FXML
    private ComboBox<String> positionBox;


    @FXML
    public void initialize()
    {
        System.out.println("Intialized");
        positionBox.getItems().addAll("Batsman", "All-Rounder", "Bowler");
    }

    @FXML
    public void addClicked(ActionEvent actionEvent) {
        System.out.println("Add button clicked");
        setPlayerDetails();
        try {
            main.getSocketWrapper().write("addPlayer");
            Player player = new Player(name, country, age, height, club, position, jersey, salary, true);
            main.getSocketWrapper().write(player);
            main.getSocketWrapper().flush();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void backClicked(ActionEvent actionEvent)
    {
        System.out.println("back button initiated");
        try {
            main.showGuestHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Method to retrieve the input as a String
    public void setPlayerDetails()
    {
        System.out.println("Loading player details");
        name = nameField.getText();
        country = countryField.getText();
        age = Integer.parseInt(ageField.getText());
        height = Double.parseDouble(heightField.getText());
        club = clubField.getText();
        jersey = Integer.parseInt(jerseyField.getText());
        salary = Integer.parseInt(salaryField.getText());
        position = positionBox.getValue();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    
}
