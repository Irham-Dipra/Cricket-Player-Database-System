package Menu.guestMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import Menu.Main; // Add this import statement

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
        positionBox.getItems().addAll("Batsman", "All-Rounder", "Bowler");
    }

    @FXML
    public void addClicked(ActionEvent actionEvent) {
        // No restrictions needed since all input is accepted by default
        // name = nameField.getText();
        // country = countryField.getText();
        // String text = ageField.getText();
        // if (text.isEmpty()) {
        //     age = 0; // or you can return 0 or a default value if required
        // }
        // try {
        //     age = Integer.parseInt(text); // Convert the text to an integer
        // } catch (NumberFormatException e) {
        //     // Handle the case where the input is not a valid integer
        //     System.out.println("Invalid number input.");
        //     main.showWrongInputAlert("age");
        //     age = 0; // or handle it in another way, like returning a default value
        // }
        // text = heightField.getText();
        // if (text.isEmpty()) {
        //     height = 0; // or you can return 0 or a default value if required
        // }
        
        // try {
        //     height = Double.parseDouble(text); // Convert the text to an integer
        // } catch (NumberFormatException e) {
        //     // Handle the case where the input is not a valid integer
        //     System.out.println("Invalid number input.");
        //     main.showWrongInputAlert("height");
        //     height = 0; // or handle it in another way, like returning a default value
        // }
        // club = clubField.getText();
        // text = jerseyField.getText();
        // if (text.isEmpty()) {
        //     jersey = -1; // or you can return 0 or a default value if required
        // }
        
        // try {
        //     jersey = Integer.parseInt(text); // Convert the text to an integer
        // } catch (NumberFormatException e) {
        //     // Handle the case where the input is not a valid integer
        //     System.out.println("Invalid number input.");
        //     main.showWrongInputAlert("jersey number");
        //     jersey = -1; // or handle it in another way, like returning a default value
        // }
        // text = salaryField.getText();
        // if (text.isEmpty()) {
        //     salary = 0; // or you can return 0 or a default value if required
        // }
        
        // try {
        //     salary = Integer.parseInt(text); // Convert the text to an integer
        // } catch (NumberFormatException e) {
        //     // Handle the case where the input is not a valid integer
        //     System.out.println("Invalid number input.");
        //     main.showWrongInputAlert("salary");
        //     salary = 0; // or handle it in another way, like returning a default value
        // }
        // position = positionBox.getValue();
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
    public String getNameInput() {
        return name;
    }

    public String getCountryInput() {
        return country;
    }

    public Integer getAgeInput() {
        return age;
    }

    public Double getHeightInput() {
        return height;
    }

    public String getClubInput() {
        return club;
    }

    public Integer getJerseyInput() {
        return jersey;
    }

    public Integer getSalaryInput() {
        return salary;
    }

    public String getPositionInput() {
        return position;  // Retrieves the selected item as a String
    }

    public void setMain(Main main) {
        this.main = main;
    }

    
}
