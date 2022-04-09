package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    public ComboBox countryComboBox = new ComboBox();
    @FXML
    public ComboBox fldComboBox = new ComboBox();

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
        countryComboBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                //Clear first-level-division ComboBox when a new item has been clicked from country ComboBox.
                fldComboBox.getItems().removeAll(fldComboBox.getItems());

                if (countryComboBox.getSelectionModel().getSelectedIndex() == 0) {
                    //Populating the first-level-division ComboBox with Canada values.
                    ObservableList<String> comboBoxValues = FXCollections.observableArrayList();
                    comboBoxValues.add("Alberta"); comboBoxValues.add("British Columbia");
                    comboBoxValues.add("Manitoba"); comboBoxValues.add("New Brunswick");
                    comboBoxValues.add("Newfoundland and Labrador"); comboBoxValues.add("Nova Scotia");
                    comboBoxValues.add("Ontario"); comboBoxValues.add("Prince Edward Island");
                    comboBoxValues.add("Quebec"); comboBoxValues.add("Saskatchewan");

                    fldComboBox.setItems(comboBoxValues);
                }
                if (countryComboBox.getSelectionModel().getSelectedIndex() == 1) {
                    //Populating the first-level-division ComboBox with England values.

                    //FIXME MAY NOT BE THE PROPER VALUES
                    ObservableList<String> comboBoxValues = FXCollections.observableArrayList();
                    comboBoxValues.add("London"); comboBoxValues.add("North East");
                    comboBoxValues.add("North West"); comboBoxValues.add("Yorkshire");
                    comboBoxValues.add("East Midlands"); comboBoxValues.add("West Midlands");
                    comboBoxValues.add("South East"); comboBoxValues.add("East of England");
                    comboBoxValues.add("South West");

                    fldComboBox.setItems(comboBoxValues);
                }
                if (countryComboBox.getSelectionModel().getSelectedIndex() == 2) {
                    //Populating the first-level-division ComboBox with state values.
                    ObservableList<String> comboBoxValues = FXCollections.observableArrayList();
                    comboBoxValues.add("Alabama"); comboBoxValues.add("Alaska");
                    comboBoxValues.add("Arizona"); comboBoxValues.add("Arkansas");
                    comboBoxValues.add("California"); comboBoxValues.add("Colorado");
                    comboBoxValues.add("Connecticut"); comboBoxValues.add("Delaware");
                    comboBoxValues.add("Florida"); comboBoxValues.add("Georgia");
                    comboBoxValues.add("Hawaii"); comboBoxValues.add("Idaho");
                    comboBoxValues.add("Illinois"); comboBoxValues.add("Indiana");
                    comboBoxValues.add("Iowa"); comboBoxValues.add("Kansas");
                    comboBoxValues.add("Kentucky"); comboBoxValues.add("Louisiana");
                    comboBoxValues.add("Maine"); comboBoxValues.add("Maryland");
                    comboBoxValues.add("Massachusetts"); comboBoxValues.add("Michigan");
                    comboBoxValues.add("Minnesota"); comboBoxValues.add("Mississippi");
                    comboBoxValues.add("Missouri"); comboBoxValues.add("Montana");
                    comboBoxValues.add("Nebraska"); comboBoxValues.add("Nevada");
                    comboBoxValues.add("New Hampshire"); comboBoxValues.add("New Jersey");
                    comboBoxValues.add("New Mexico"); comboBoxValues.add("New York");
                    comboBoxValues.add("North Carolina"); comboBoxValues.add("North Dakota");
                    comboBoxValues.add("Ohio"); comboBoxValues.add("Oklahoma");
                    comboBoxValues.add("Oregon"); comboBoxValues.add("Pennsylvania");
                    comboBoxValues.add("Rhode Island"); comboBoxValues.add("South Carolina");
                    comboBoxValues.add("South Dakota"); comboBoxValues.add("Tennessee");
                    comboBoxValues.add("Texas"); comboBoxValues.add("Utah");
                    comboBoxValues.add("Vermont"); comboBoxValues.add("Virginia");
                    comboBoxValues.add("Washington"); comboBoxValues.add("West Virginia");
                    comboBoxValues.add("Wisconsin"); comboBoxValues.add("Wyoming");

                    fldComboBox.setItems(comboBoxValues);
                }
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
    public void handleAddButtonAction() throws IOException {

        Stage stage = (Stage) addButton.getScene().getWindow();

        customerName = customerNameText.getText();
        customerAddress = customerAddressText.getText();
        customerPostalCode = customerPostalCodeText.getText();
        customerPhoneNumber = customerPhoneNumberText.getText();
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
