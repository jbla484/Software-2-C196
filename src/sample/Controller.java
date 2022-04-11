package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    // TableViews
    @FXML
    public TableView<Customer> customerTable = new TableView<>();

    // TableColumns
    @FXML
    public TableColumn<Customer, Number> customerIDCol = new TableColumn<>("Customer ID");
    @FXML
    public TableColumn<Customer, String> customerNameCol = new TableColumn<>("Customer Name");
    @FXML
    public TableColumn<Customer, String> customerAddressCol = new TableColumn<>("Address");
    @FXML
    public TableColumn<Customer, String> customerPostalCol = new TableColumn<>("Postal Code");
    @FXML
    public TableColumn<Customer, String> customerPhoneCol = new TableColumn<>("Phone Number");
    @FXML
    public TableColumn<Customer, String> customerCreationDateCol = new TableColumn<>("Creation Date");
    @FXML
    public TableColumn<Customer, String> customerCreatedByCol = new TableColumn<>("Created By");
    @FXML
    public TableColumn<Customer, String> customerLastUpdateCol = new TableColumn<>("Last Update");
    @FXML
    public TableColumn<Customer, String> customerLastUpdatedByCol = new TableColumn<>("Last Updated By");
    @FXML
    public TableColumn<Customer, Number> customerDivisionIDCol = new TableColumn<>("Division ID");

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
    @FXML
    public ObservableList<String> comboBoxValues = FXCollections.observableArrayList();
    @FXML
    public ObservableList<String> comboBoxValues0 = FXCollections.observableArrayList();
    @FXML
    public ObservableList<String> comboBoxValues1 = FXCollections.observableArrayList();
    @FXML
    public ObservableList<String> comboBoxValues2 = FXCollections.observableArrayList();

    //ComboBoxes
    @FXML
    public ComboBox<String> countryComboBox = new ComboBox<>();
    @FXML
    public ComboBox<String> fldComboBox = new ComboBox<>();

    @FXML
    public void initialize() throws SQLException {

        // Sets Cell Value Factory for columns
        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        customerPostalCol.setCellValueFactory(new PropertyValueFactory<>("postal"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerCreationDateCol.setCellValueFactory(new PropertyValueFactory<>("creation"));
        customerCreatedByCol.setCellValueFactory(new PropertyValueFactory<>("created by"));
        customerLastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("updated"));
        customerLastUpdatedByCol.setCellValueFactory(new PropertyValueFactory<>("updated by"));
        customerDivisionIDCol.setCellValueFactory(new PropertyValueFactory<>("division"));

        // Sets Cell Value Factory for cells
        customerIDCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getId()));
        customerNameCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        customerAddressCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAddress()));
        customerPostalCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPostalCode()));
        customerPhoneCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPhoneNumber()));
        customerCreationDateCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCreationDate()));
        customerCreatedByCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCreatedBy()));
        customerLastUpdateCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLastUpdate()));
        customerLastUpdatedByCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLastUpdatedBy()));
        customerDivisionIDCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getDivisionID()));

        // Populates the tables
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        String query = "SELECT * FROM customers";
        Connection connection = JDBC.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        while (resultset.next()) {
            Customer customer = new Customer();
            customer.setId(resultset.getInt(1));
            customer.setName(resultset.getString(2));
            customer.setAddress(resultset.getString(3));
            customer.setPostalCode(resultset.getString(4));
            customer.setPhoneNumber(resultset.getString(5));
            customer.setCreationDate(resultset.getString(6));
            customer.setCreatedBy(resultset.getString(7));
            customer.setLastUpdate(resultset.getString(8));
            customer.setLastUpdatedBy(resultset.getString(9));
            customer.setDivisionID(resultset.getInt(10));
            customers.add(customer);
        }
        customerTable.setItems(customers);

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
        comboBoxValues.add("Canada");
        comboBoxValues.add("United Kingdom");
        comboBoxValues.add("United States");
        countryComboBox.setItems(comboBoxValues);

        //Set action event for ComboBox
        countryComboBox.setOnAction(event -> {

            //Clear first-level-division ComboBox when a new item has been clicked from country ComboBox.
            fldComboBox.getItems().removeAll(fldComboBox.getItems());

            if (countryComboBox.getSelectionModel().getSelectedIndex() == 0) {
                //Populating the first-level-division ComboBox with Canada values.
                comboBoxValues0.add("Northwest Territories");
                comboBoxValues0.add("Alberta");
                comboBoxValues0.add("British Columbia");
                comboBoxValues0.add("Manitoba");
                comboBoxValues0.add("New Brunswick");
                comboBoxValues0.add("Nova Scotia");
                comboBoxValues0.add("Prince Edward Island");
                comboBoxValues0.add("Ontario");
                comboBoxValues0.add("Québec");
                comboBoxValues0.add("Saskatchewan");
                comboBoxValues0.add("Nunavut");
                comboBoxValues0.add("Yukon");
                comboBoxValues0.add("Newfoundland and Labrador");

                fldComboBox.setItems(comboBoxValues0);
            }
            if (countryComboBox.getSelectionModel().getSelectedIndex() == 1) {
                //Populating the first-level-division ComboBox with United Kingdom values.
                comboBoxValues1.add("Scotland"); comboBoxValues1.add("Northern Ireland");
                comboBoxValues1.add("Wales"); comboBoxValues1.add("England");

                fldComboBox.setItems(comboBoxValues1);
            }
            if (countryComboBox.getSelectionModel().getSelectedIndex() == 2) {
                //Populating the first-level-division ComboBox with state values.
                comboBoxValues2.add("Alabama"); comboBoxValues2.add("Alaska");
                comboBoxValues2.add("Arizona"); comboBoxValues2.add("Arkansas");
                comboBoxValues2.add("California"); comboBoxValues2.add("Colorado");
                comboBoxValues2.add("Connecticut"); comboBoxValues2.add("Delaware");
                comboBoxValues2.add("District of Columbia");
                comboBoxValues2.add("Florida"); comboBoxValues2.add("Georgia");
                comboBoxValues2.add("Hawaii"); comboBoxValues2.add("Idaho");
                comboBoxValues2.add("Illinois"); comboBoxValues2.add("Indiana");
                comboBoxValues2.add("Iowa"); comboBoxValues2.add("Kansas");
                comboBoxValues2.add("Kentucky"); comboBoxValues2.add("Louisiana");
                comboBoxValues2.add("Maine"); comboBoxValues2.add("Maryland");
                comboBoxValues2.add("Massachusetts"); comboBoxValues2.add("Michigan");
                comboBoxValues2.add("Minnesota"); comboBoxValues2.add("Mississippi");
                comboBoxValues2.add("Missouri"); comboBoxValues2.add("Montana");
                comboBoxValues2.add("Nebraska"); comboBoxValues2.add("Nevada");
                comboBoxValues2.add("New Hampshire"); comboBoxValues2.add("New Jersey");
                comboBoxValues2.add("New Mexico"); comboBoxValues2.add("New York");
                comboBoxValues2.add("North Carolina"); comboBoxValues2.add("North Dakota");
                comboBoxValues2.add("Ohio"); comboBoxValues2.add("Oklahoma");
                comboBoxValues2.add("Oregon"); comboBoxValues2.add("Pennsylvania");
                comboBoxValues2.add("Rhode Island"); comboBoxValues2.add("South Carolina");
                comboBoxValues2.add("South Dakota"); comboBoxValues2.add("Tennessee");
                comboBoxValues2.add("Texas"); comboBoxValues2.add("Utah");
                comboBoxValues2.add("Vermont"); comboBoxValues2.add("Virginia");
                comboBoxValues2.add("Washington"); comboBoxValues2.add("West Virginia");
                comboBoxValues2.add("Wisconsin"); comboBoxValues2.add("Wyoming");

                fldComboBox.setItems(comboBoxValues2);
            }
        });
    }

    @FXML
    public void checkLoginButton() throws SQLException, IOException {

        Stage stage = (Stage) loginButton.getScene().getWindow();

        //Get user input from TextField and save data in variables.
        userIDs = userID.getText();
        userPasswords = userPassword.getText();

        String query = "Select * FROM users WHERE User_Name = '" + userIDs + "' AND Password = '" + userPasswords + "';";

        Connection connection = JDBC.getConnection();
        try (Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query)) {

            if (!resultset.next()) {
                if (locale.toString().equals("fr_CA")) {
                    errorDescription.setText("Nom d'utilisateur ou mot de passe invalide.");
                } else {
                    errorDescription.setText("Invalid username or password.");
                }

            } else {

                errorDescription.setText("Successfully logged in.");
                switchToHome();

                stage.close();
            }

            //Find customer ID number for next customer
            String query2 = "Select Customer_ID FROM customers";
            ResultSet resultset2 = statement.executeQuery(query2);

            while (resultset2.next()) {
                nextCustomerID++;
            }
        }
    }

    @FXML
    public void handleAddButtonAction() {

        try {

            Stage stage = (Stage) addButton.getScene().getWindow();

            //Get input values from TextFields into variables
            customerName = customerNameText.getText();
            customerPostalCode = customerPostalCodeText.getText();
            customerPhoneNumber = customerPhoneNumberText.getText();

            int countryIndex = countryComboBox.getSelectionModel().getSelectedIndex();
            int fldIndex = fldComboBox.getSelectionModel().getSelectedIndex();
            String customerCountry = comboBoxValues.get(countryIndex);
            String customerFLD = "";

            //United States address format.
            if (customerCountry.equals("United States")) {
                Pattern r = Pattern.compile("\\d+\\s\\w+\\s\\w+\\p{Punct}\\s\\w+\\s\\w+");
                Matcher m = r.matcher(customerAddressText.getText());

                if (m.find()) {
                    customerAddress = customerAddressText.getText();
                } else {
                    throw new Exception();
                }
            }

            //United Kingdom address format.
            if (customerCountry.equals("United Kingdom")) {
                Pattern r = Pattern.compile("\\d+\\s\\w+\\s\\w+\\p{Punct}\\s\\w+\\p{Punct}\\s\\w+");
                Matcher m = r.matcher(customerAddressText.getText());

                if (m.find()) {
                    customerAddress = customerAddressText.getText();
                } else {
                    throw new Exception();
                }
            }

            //Canada address format.
            if (customerCountry.equals("Canada")) {
                Pattern r = Pattern.compile("\\d+\\s\\w+\\s\\w+\\p{Punct}\\s\\w+");
                Matcher m = r.matcher(customerAddressText.getText());

                if (m.find()) {
                    customerAddress = customerAddressText.getText();
                } else {
                    throw new Exception();
                }
            }

            //Set first-level-division based on fldIndex value.
            if (customerCountry.equals("United States")) {
                customerFLD = comboBoxValues2.get(fldIndex);
            }
            if (customerCountry.equals("United Kingdom")) {
                customerFLD = comboBoxValues1.get(fldIndex);
            }
            if (customerCountry.equals("Canada")) {
                customerFLD = comboBoxValues0.get(fldIndex);
            }

            //Create a query and execute it.
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp);

            String createdBy = "James";
            String divisionID = "";

            //Execute a statement to get a division id matching our first-level-division value.
            String query = "SELECT Division_ID, Division FROM first_level_divisions;";

            Connection connection = JDBC.getConnection();
            Statement statement = connection.createStatement();
            try (ResultSet resultset = statement.executeQuery(query)) {

                while (resultset.next()) {
                    if (customerFLD.equals(resultset.getString(2))) {
                        divisionID = resultset.getString(1);
                    }
                }
            }

            String query2 = "INSERT INTO customers VALUES ('" + nextCustomerID + "', '" + customerName + "', '" +
                    customerAddress + "', '" + customerPostalCode + "', '" + customerPhoneNumber + "', '" +
                    s + "', '" + createdBy + "', '" + timestamp + "', '" + createdBy + "', '" +
                    divisionID + "');";

            statement.executeUpdate(query2);

            nextCustomerID++;

            //Once done, close
            stage.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void closeApplication() {
        System.exit(0);
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

    @FXML
    private void switchToUpdateCustomer() throws IOException {
        String fileName = "updateCustomer";
        Main.loadModifyCustomer(fileName);
    }
}
