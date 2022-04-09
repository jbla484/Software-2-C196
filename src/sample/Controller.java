package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;


public class Controller {

    //Buttons
    @FXML
    public Button closeButton = new Button();
    @FXML
    public Button loginButton = new Button();
    @FXML
    public Button addButton = new Button();

    //TextFields
    @FXML
    public TextField userID = new TextField();
    @FXML
    public TextField userPassword = new TextField();
    @FXML
    public TextField customerIDText = new TextField();
    @FXML
    public TextField customerNameText = new TextField();
    @FXML
    public TextField customerAddressText = new TextField();
    @FXML
    public TextField customerPostalCodeText = new TextField();
    @FXML
    public TextField customerPhoneNumberText = new TextField();

    // Labels
    @FXML
    public Label errorDescription = new Label();
    @FXML
    public Label locationText = new Label();
    @FXML
    public Label dashTitle = new Label();
    @FXML
    public Label dashTitle2 = new Label();
    @FXML
    public Label dashLabel1 = new Label();
    @FXML
    public Label dashLabel2 = new Label();
    @FXML
    public Label dashLabel3 = new Label();
    @FXML
    public Label dashLabel4 = new Label();
    @FXML
    public Label dashUsername = new Label();
    @FXML
    public Label dashPassword = new Label();

    //Variables
    @FXML
    public String userIDs = "";
    @FXML
    public String userPasswords = "";
    @FXML
    public Locale locale;
    @FXML
    public static int nextCustomerID = 1;
    @FXML
    public String customerName = "";
    @FXML
    public String customerAddress = "";
    @FXML
    public String customerPostalCode = "";
    @FXML
    public String customerPhoneNumber = "";

    //ComboBoxes
    @FXML
    public ComboBox<String> countryComboBox = new ComboBox<>();
    @FXML
    public ComboBox<String> fldComboBox = new ComboBox<>();

    @FXML
    public void initialize() {

        //Get locale based on devices location, and create a resource bundle from it.
        locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);

        //Buttons mouse click event handlers.
        closeButton.setOnMouseClicked(event -> onCloseButtonClick());

        //Finds and displays the country the user is in via locale.
        String country = locale.getDisplayCountry();
        locationText.setText("Location: " + country);

        //Translates English to French base on Canada locale value.
        if(locale.toString().equals("fr_CA")) {
            dashTitle.setText(rb.getString("home1"));
            dashTitle2.setText(rb.getString("home2"));
            dashLabel1.setText(rb.getString("home3"));
            dashLabel4.setText(rb.getString("home4"));
            dashLabel2.setText("");
            dashLabel3.setText(rb.getString("home5"));
            dashUsername.setText(rb.getString("home6"));
            dashPassword.setText(rb.getString("home7"));
            locationText.setText(rb.getString("home8") + country);
            closeButton.setText(rb.getString("home9"));
            loginButton.setText(rb.getString("home2"));
        }
        customerIDText.setText("" + nextCustomerID);

        //Populate ComboBox
        ObservableList<String> comboBoxValues = FXCollections.observableArrayList();
        comboBoxValues.add("Canada");
        comboBoxValues.add("England");
        comboBoxValues.add("United States");
        countryComboBox.setItems(comboBoxValues);

        //Set action event for ComboBox
        countryComboBox.setOnAction(event -> {

            //Clear first-level-division ComboBox when a new item has been clicked from country ComboBox.
            fldComboBox.getItems().removeAll(fldComboBox.getItems());

            if (countryComboBox.getSelectionModel().getSelectedIndex() == 0) {
                //Populating the first-level-division ComboBox with Canada values.
                ObservableList<String> comboBoxValues1 = FXCollections.observableArrayList();
                comboBoxValues1.add("Alberta"); comboBoxValues1.add("British Columbia");
                comboBoxValues1.add("Manitoba"); comboBoxValues1.add("New Brunswick");
                comboBoxValues1.add("Newfoundland and Labrador"); comboBoxValues1.add("Nova Scotia");
                comboBoxValues1.add("Ontario"); comboBoxValues1.add("Prince Edward Island");
                comboBoxValues1.add("Quebec"); comboBoxValues1.add("Saskatchewan");

                fldComboBox.setItems(comboBoxValues1);
            }
            if (countryComboBox.getSelectionModel().getSelectedIndex() == 1) {
                //Populating the first-level-division ComboBox with England values.

                //FIXME MAY NOT BE THE PROPER VALUES
                ObservableList<String> comboBoxValues1 = FXCollections.observableArrayList();
                comboBoxValues1.add("London"); comboBoxValues1.add("North East");
                comboBoxValues1.add("North West"); comboBoxValues1.add("Yorkshire");
                comboBoxValues1.add("East Midlands"); comboBoxValues1.add("West Midlands");
                comboBoxValues1.add("South East"); comboBoxValues1.add("East of England");
                comboBoxValues1.add("South West");

                fldComboBox.setItems(comboBoxValues1);
            }
            if (countryComboBox.getSelectionModel().getSelectedIndex() == 2) {
                //Populating the first-level-division ComboBox with state values.
                ObservableList<String> comboBoxValues1 = FXCollections.observableArrayList();
                comboBoxValues1.add("Alabama"); comboBoxValues1.add("Alaska");
                comboBoxValues1.add("Arizona"); comboBoxValues1.add("Arkansas");
                comboBoxValues1.add("California"); comboBoxValues1.add("Colorado");
                comboBoxValues1.add("Connecticut"); comboBoxValues1.add("Delaware");
                comboBoxValues1.add("Florida"); comboBoxValues1.add("Georgia");
                comboBoxValues1.add("Hawaii"); comboBoxValues1.add("Idaho");
                comboBoxValues1.add("Illinois"); comboBoxValues1.add("Indiana");
                comboBoxValues1.add("Iowa"); comboBoxValues1.add("Kansas");
                comboBoxValues1.add("Kentucky"); comboBoxValues1.add("Louisiana");
                comboBoxValues1.add("Maine"); comboBoxValues1.add("Maryland");
                comboBoxValues1.add("Massachusetts"); comboBoxValues1.add("Michigan");
                comboBoxValues1.add("Minnesota"); comboBoxValues1.add("Mississippi");
                comboBoxValues1.add("Missouri"); comboBoxValues1.add("Montana");
                comboBoxValues1.add("Nebraska"); comboBoxValues1.add("Nevada");
                comboBoxValues1.add("New Hampshire"); comboBoxValues1.add("New Jersey");
                comboBoxValues1.add("New Mexico"); comboBoxValues1.add("New York");
                comboBoxValues1.add("North Carolina"); comboBoxValues1.add("North Dakota");
                comboBoxValues1.add("Ohio"); comboBoxValues1.add("Oklahoma");
                comboBoxValues1.add("Oregon"); comboBoxValues1.add("Pennsylvania");
                comboBoxValues1.add("Rhode Island"); comboBoxValues1.add("South Carolina");
                comboBoxValues1.add("South Dakota"); comboBoxValues1.add("Tennessee");
                comboBoxValues1.add("Texas"); comboBoxValues1.add("Utah");
                comboBoxValues1.add("Vermont"); comboBoxValues1.add("Virginia");
                comboBoxValues1.add("Washington"); comboBoxValues1.add("West Virginia");
                comboBoxValues1.add("Wisconsin"); comboBoxValues1.add("Wyoming");

                fldComboBox.setItems(comboBoxValues1);
            }
        });
    }

    @FXML
    public void checkLoginButton() throws SQLException, IOException {

        //Get user input from TextField and save data in variables.
        userIDs = userID.getText();
        userPasswords = userPassword.getText();

        String query = "Select * FROM users WHERE User_Name = '" + userIDs + "' AND Password = '" + userPasswords + "';";

        Connection connection = JDBC.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        if (!resultset.next()) {
            if (locale.toString().equals("fr_CA")) {
                errorDescription.setText("Nom d'utilisateur ou mot de passe invalide.");
            } else {
                errorDescription.setText("Invalid username or password.");
            }

        } else {

            errorDescription.setText("Successfully logged in.");

            switchToHome();
            System.out.println("Logged in!");
        }

        //Find customer ID number for next customer
        String query2 = "Select Customer_ID FROM customers";
        ResultSet resultset2 = statement.executeQuery(query2);

        while (resultset2.next()) {
            nextCustomerID++;
        }
    }

    @FXML
    public void handleAddButtonAction() {

        Stage stage = (Stage) addButton.getScene().getWindow();

        customerName = customerNameText.getText();
        customerAddress = customerAddressText.getText();
        customerPostalCode = customerPostalCodeText.getText();
        customerPhoneNumber = customerPhoneNumberText.getText();

        //Once done, close
        stage.close();
    }

    @FXML
    public void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void switchToHome() throws IOException {
        String fileName = "home";
        Main.loadHome(fileName);
    }

    @FXML
    private void switchToAddCustomer() throws IOException {
        String fileName = "addCustomer";
        Main.loadAddCustomer(fileName);
    }
}
