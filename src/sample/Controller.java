package sample;

import javafx.beans.property.SimpleIntegerProperty;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    // TableViews
    @FXML
    public TableView<Customer> customerTable = new TableView<>();
    @FXML
    public TableView<Appointment> appointmentTable = new TableView<>();
    @FXML
    public TableView<Appointment> appointmentTable2 = new TableView<>();
    @FXML
    public TableView<Appointment> associatedAppointmentTable = new TableView<>();


    // Customer TableColumns
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

    //Appointment TableColumns
    @FXML
    public TableColumn<Appointment, Number> appointmentIDCol = new TableColumn<>("Appointment ID");
    @FXML
    public TableColumn<Appointment, String> appointmentTitleCol = new TableColumn<>("Title");
    @FXML
    public TableColumn<Appointment, String> appointmentDescriptionCol = new TableColumn<>("Description");
    @FXML
    public TableColumn<Appointment, String> appointmentLocationCol = new TableColumn<>("Location");
    @FXML
    public TableColumn<Appointment, String> appointmentTypeCol = new TableColumn<>("Type");
    @FXML
    public TableColumn<Appointment, String> appointmentStartCol = new TableColumn<>("Start");
    @FXML
    public TableColumn<Appointment, String> appointmentEndCol = new TableColumn<>("End");
    @FXML
    public TableColumn<Appointment, String> appointmentCreationCol = new TableColumn<>("Creation Date");
    @FXML
    public TableColumn<Appointment, String> appointmentCreatedByCol = new TableColumn<>("Created By");
    @FXML
    public TableColumn<Appointment, String> appointmentUpdatedCol = new TableColumn<>("Last Update");
    @FXML
    public TableColumn<Appointment, String> appointmentUpdatedByCol = new TableColumn<>("Updated By");
    @FXML
    public TableColumn<Appointment, Number> appointmentCustomerIDCol = new TableColumn<>("Customer ID");
    @FXML
    public TableColumn<Appointment, Number> appointmentUserIDCol = new TableColumn<>("User ID");
    @FXML
    public TableColumn<Appointment, Number> appointmentContactIDCol = new TableColumn<>("Contact ID");

    @FXML
    public TableColumn<Appointment, Number> appointmentIDCol1 = new TableColumn<>("Appointment ID");
    @FXML
    public TableColumn<Appointment, String> appointmentTitleCol1 = new TableColumn<>("Title");
    @FXML
    public TableColumn<Appointment, String> appointmentDescriptionCol1 = new TableColumn<>("Description");
    @FXML
    public TableColumn<Appointment, String> appointmentLocationCol1 = new TableColumn<>("Location");
    @FXML
    public TableColumn<Appointment, String> appointmentTypeCol1 = new TableColumn<>("Type");
    @FXML
    public TableColumn<Appointment, String> appointmentStartCol1 = new TableColumn<>("Start");
    @FXML
    public TableColumn<Appointment, String> appointmentEndCol1 = new TableColumn<>("End");
    @FXML
    public TableColumn<Appointment, String> appointmentCreationCol1 = new TableColumn<>("Creation Date");
    @FXML
    public TableColumn<Appointment, String> appointmentCreatedByCol1 = new TableColumn<>("Created By");
    @FXML
    public TableColumn<Appointment, String> appointmentUpdatedCol1 = new TableColumn<>("Last Update");
    @FXML
    public TableColumn<Appointment, String> appointmentUpdatedByCol1 = new TableColumn<>("Updated By");
    @FXML
    public TableColumn<Appointment, Number> appointmentCustomerIDCol1 = new TableColumn<>("Customer ID");
    @FXML
    public TableColumn<Appointment, Number> appointmentUserIDCol1 = new TableColumn<>("User ID");
    @FXML
    public TableColumn<Appointment, Number> appointmentContactIDCol1 = new TableColumn<>("Contact ID");


    //Buttons
    @FXML
    public Button closeButton = new Button();
    @FXML
    public Button loginButton = new Button();
    @FXML
    public Button addButton = new Button();

    //Login TextFields
    @FXML
    public TextField userID = new TextField();
    @FXML
    public TextField userPassword = new TextField();

    //Customer TextFields
    @FXML
    public TextField customerIDText = new TextField();
    @FXML
    public TextField customerIDText2 = new TextField();
    @FXML
    public TextField customerNameText = new TextField();
    @FXML
    public TextField customerNameText2 = new TextField();
    @FXML
    public TextField customerAddressText = new TextField();
    @FXML
    public TextField customerAddressText2 = new TextField();
    @FXML
    public TextField customerPostalCodeText = new TextField();
    @FXML
    public TextField customerPostalCodeText2 = new TextField();
    @FXML
    public TextField customerPhoneNumberText = new TextField();
    @FXML
    public TextField customerPhoneNumberText2 = new TextField();

    //Appointment TextFields
    @FXML
    public TextField appointmentIDText = new TextField();
    @FXML
    public TextField appointmentIDText2 = new TextField();
    @FXML
    public TextField appointmentTitleText = new TextField();
    @FXML
    public TextField appointmentTitleText2 = new TextField();
    @FXML
    public TextField appointmentDescriptionText = new TextField();
    @FXML
    public TextField appointmentDescriptionText2 = new TextField();
    @FXML
    public TextField appointmentLocationText = new TextField();
    @FXML
    public TextField appointmentLocationText2 = new TextField();
    @FXML
    public TextField appointmentTypeText = new TextField();
    @FXML
    public TextField appointmentTypeText2 = new TextField();
    @FXML
    public DatePicker appointmentStartDate = new DatePicker();
    @FXML
    public DatePicker appointmentEndDate = new DatePicker();
    @FXML
    public TextField appointmentCustomerIDText = new TextField();
    @FXML
    public TextField appointmentCustomerIDText2 = new TextField();
    @FXML
    public TextField appointmentUserIDText = new TextField();
    @FXML
    public TextField appointmentUserIDText2 = new TextField();

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
    @FXML
    public Label customerErrorLabel = new Label();
    @FXML
    public Label appointmentErrorLabel = new Label();
    @FXML
    public Label addCustomerErrorLabel = new Label();

    //Variables
    @FXML
    public static boolean found = false;
    @FXML
    public static boolean found2 = false;
    @FXML
    public static boolean found3 = false;
    @FXML
    public String userIDs = "";
    @FXML
    public String userPasswords = "";
    @FXML
    public Locale locale;
    @FXML
    public static int nextCustomerID = 1;
    @FXML
    public static int nextAppointmentID = 1;
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
    @FXML
    public ObservableList<String> comboBoxValuesContacts = FXCollections.observableArrayList();
    @FXML
    public ObservableList<String> comboBoxValuesTime = FXCollections.observableArrayList();
    @FXML
    public static ObservableList<Customer> customers = FXCollections.observableArrayList();
    @FXML
    public static ObservableList<Appointment> appointments = FXCollections.observableArrayList();
    @FXML
    public ObservableList<Appointment> associatedAppointments = FXCollections.observableArrayList();
    @FXML
    public static ObservableList<Appointment> associatedAppointments2 = FXCollections.observableArrayList();
    @FXML
    public static String copyCustomerID = "";
    @FXML
    public static String copyCustomerName = "";
    @FXML
    public static String copyCustomerAddress = "";
    @FXML
    public static String copyCustomerPostal = "";
    @FXML
    public static String copyCustomerPhone = "";
    @FXML
    public static String copyCustomerCountry = "";
    @FXML
    public static String copyCustomerDivisionID = "";
    @FXML
    public static int first = 0;

    @FXML
    public static String copyAppointmentID = "";
    @FXML
    public static String copyAppointmentTitle = "";
    @FXML
    public static String copyAppointmentDescription = "";
    @FXML
    public static String copyAppointmentLocation = "";
    @FXML
    public static String copyAppointmentContact = "";
    @FXML
    public static String copyAppointmentType = "";
    @FXML
    public static String copyAppointmentStartDate = "";
    @FXML
    public static String copyAppointmentEndDate = "";
    @FXML
    public static String copyAppointmentCustomerID = "";
    @FXML
    public static String copyAppointmentUserID = "";
    @FXML
    public static String copyAppointmentContactID = "";


    //ComboBoxes
    @FXML
    public ComboBox<String> countryComboBox = new ComboBox<>();
    @FXML
    public ComboBox<String> fldComboBox = new ComboBox<>();
    @FXML
    public ComboBox<String> contactComboBox = new ComboBox<>();
    @FXML
    public ComboBox<String> appointmentStartTimeComboBox = new ComboBox<>();
    @FXML
    public ComboBox<String> appointmentEndTimeComboBox = new ComboBox<>();

    @FXML
    public void initialize() throws SQLException {

        if (found3) {
            associatedAppointmentTable.setItems(associatedAppointments2);
            associatedAppointmentTable.refresh();
            found3 = false;
        }

        customerTable.refresh();

        comboBoxValuesTime.add("00:15:00"); comboBoxValuesTime.add("00:30:00");
        comboBoxValuesTime.add("00:45:00"); comboBoxValuesTime.add("01:00:00");
        comboBoxValuesTime.add("01:15:00"); comboBoxValuesTime.add("01:30:00");
        comboBoxValuesTime.add("01:45:00"); comboBoxValuesTime.add("02:00:00");
        comboBoxValuesTime.add("02:15:00"); comboBoxValuesTime.add("02:30:00");
        comboBoxValuesTime.add("02:45:00"); comboBoxValuesTime.add("03:00:00");
        comboBoxValuesTime.add("03:15:00"); comboBoxValuesTime.add("03:30:00");
        comboBoxValuesTime.add("03:45:00"); comboBoxValuesTime.add("04:00:00");
        comboBoxValuesTime.add("04:15:00"); comboBoxValuesTime.add("04:30:00");
        comboBoxValuesTime.add("04:45:00"); comboBoxValuesTime.add("05:00:00");
        comboBoxValuesTime.add("05:15:00"); comboBoxValuesTime.add("05:30:00");
        comboBoxValuesTime.add("05:45:00"); comboBoxValuesTime.add("06:00:00");
        comboBoxValuesTime.add("06:15:00"); comboBoxValuesTime.add("06:30:00");
        comboBoxValuesTime.add("06:45:00"); comboBoxValuesTime.add("07:00:00");
        comboBoxValuesTime.add("07:15:00"); comboBoxValuesTime.add("07:30:00");
        comboBoxValuesTime.add("07:45:00"); comboBoxValuesTime.add("08:00:00");
        comboBoxValuesTime.add("08:15:00"); comboBoxValuesTime.add("08:30:00");
        comboBoxValuesTime.add("08:45:00"); comboBoxValuesTime.add("09:00:00");
        comboBoxValuesTime.add("09:15:00"); comboBoxValuesTime.add("09:30:00");
        comboBoxValuesTime.add("09:45:00"); comboBoxValuesTime.add("10:00:00");
        comboBoxValuesTime.add("10:15:00"); comboBoxValuesTime.add("10:30:00");
        comboBoxValuesTime.add("10:45:00"); comboBoxValuesTime.add("11:00:00");
        comboBoxValuesTime.add("11:15:00"); comboBoxValuesTime.add("11:30:00");
        comboBoxValuesTime.add("11:45:00"); comboBoxValuesTime.add("12:00:00");
        comboBoxValuesTime.add("12:15:00"); comboBoxValuesTime.add("12:30:00");
        comboBoxValuesTime.add("12:45:00"); comboBoxValuesTime.add("13:00:00");
        comboBoxValuesTime.add("13:15:00"); comboBoxValuesTime.add("13:30:00");
        comboBoxValuesTime.add("13:45:00"); comboBoxValuesTime.add("14:00:00");
        comboBoxValuesTime.add("14:15:00"); comboBoxValuesTime.add("14:30:00");
        comboBoxValuesTime.add("14:45:00"); comboBoxValuesTime.add("15:00:00");
        comboBoxValuesTime.add("15:15:00"); comboBoxValuesTime.add("15:30:00");
        comboBoxValuesTime.add("15:45:00"); comboBoxValuesTime.add("16:00:00");
        comboBoxValuesTime.add("16:15:00"); comboBoxValuesTime.add("16:30:00");
        comboBoxValuesTime.add("16:45:00"); comboBoxValuesTime.add("17:00:00");
        comboBoxValuesTime.add("17:15:00"); comboBoxValuesTime.add("17:30:00");
        comboBoxValuesTime.add("17:45:00"); comboBoxValuesTime.add("18:00:00");
        comboBoxValuesTime.add("18:15:00"); comboBoxValuesTime.add("18:30:00");
        comboBoxValuesTime.add("18:45:00"); comboBoxValuesTime.add("19:00:00");
        comboBoxValuesTime.add("19:15:00"); comboBoxValuesTime.add("19:30:00");
        comboBoxValuesTime.add("19:45:00"); comboBoxValuesTime.add("20:00:00");
        comboBoxValuesTime.add("20:15:00"); comboBoxValuesTime.add("20:30:00");
        comboBoxValuesTime.add("20:45:00"); comboBoxValuesTime.add("21:00:00");
        comboBoxValuesTime.add("21:15:00"); comboBoxValuesTime.add("21:30:00");
        comboBoxValuesTime.add("21:45:00"); comboBoxValuesTime.add("22:00:00");
        comboBoxValuesTime.add("22:15:00"); comboBoxValuesTime.add("22:30:00");
        comboBoxValuesTime.add("22:45:00"); comboBoxValuesTime.add("23:00:00");
        comboBoxValuesTime.add("23:15:00"); comboBoxValuesTime.add("23:30:00");
        comboBoxValuesTime.add("23:45:00"); comboBoxValuesTime.add("24:00:00");
        appointmentStartTimeComboBox.setItems(comboBoxValuesTime);
        appointmentEndTimeComboBox.setItems(comboBoxValuesTime);

        if(found) {

            customerIDText2.setText(copyCustomerID);
            customerNameText2.setText(copyCustomerName);
            customerAddressText2.setText(copyCustomerAddress);
            customerPostalCodeText2.setText(copyCustomerPostal);
            customerPhoneNumberText2.setText(copyCustomerPhone);

            if (Integer.parseInt(copyCustomerDivisionID) <= 55) {
                countryComboBox.getSelectionModel().select("United States");
            } else if (Integer.parseInt(copyCustomerDivisionID) <= 75) {
                countryComboBox.getSelectionModel().select("Canada");
            } else {
                countryComboBox.getSelectionModel().select("United Kingdom");
            }

            String query = "SELECT * FROM first_level_divisions;";
            Connection connection = JDBC.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);

            while (resultset.next()) {
                if (resultset.getString(1).equals(copyCustomerDivisionID)) {
                    fldComboBox.getSelectionModel().select(resultset.getString(2));
                }
            }
        }
        found = false;

        if(found2) {

            appointmentIDText2.setText(copyAppointmentID);
            appointmentTitleText2.setText(copyAppointmentTitle);
            appointmentDescriptionText2.setText(copyAppointmentDescription);
            appointmentLocationText2.setText(copyAppointmentLocation);
            appointmentTypeText2.setText(copyAppointmentType);
            appointmentCustomerIDText2.setText(copyAppointmentCustomerID);
            appointmentUserIDText2.setText(copyAppointmentUserID);

            if (Integer.parseInt(copyAppointmentContactID) == 1) {
                contactComboBox.getSelectionModel().select("Anika Costa");
            }
            if (Integer.parseInt(copyAppointmentContactID) == 2) {
                contactComboBox.getSelectionModel().select("Daniel Garcia");
            }
            if (Integer.parseInt(copyAppointmentContactID) == 3) {
                contactComboBox.getSelectionModel().select("Li Lee");
            }

            //Start date and time
            String[] startDateAndTime = copyAppointmentStartDate.split("(\\s)", 2);
            LocalDate localDate = LocalDate.parse(startDateAndTime[0]);
            appointmentStartDate.setValue(localDate);
            appointmentStartTimeComboBox.getSelectionModel().select(startDateAndTime[1]);

            //End date and time
            String[] endDateAndTime = copyAppointmentEndDate.split("(\\s)", 2);
            localDate = LocalDate.parse(endDateAndTime[0]);
            appointmentEndDate.setValue(localDate);
            appointmentEndTimeComboBox.getSelectionModel().select(endDateAndTime[1]);

        }
        found2 = false;

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

        appointmentIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        appointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        appointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        appointmentCreationCol.setCellValueFactory(new PropertyValueFactory<>("creation date"));
        appointmentCreatedByCol.setCellValueFactory(new PropertyValueFactory<>("created by"));
        appointmentUpdatedCol.setCellValueFactory(new PropertyValueFactory<>("updated"));
        appointmentUpdatedByCol.setCellValueFactory(new PropertyValueFactory<>("updated by"));
        appointmentCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customer id"));
        appointmentUserIDCol.setCellValueFactory(new PropertyValueFactory<>("user id"));
        appointmentContactIDCol.setCellValueFactory(new PropertyValueFactory<>("contact id"));

        appointmentIDCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
        appointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentDescriptionCol1.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentLocationCol1.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentStartCol1.setCellValueFactory(new PropertyValueFactory<>("start"));
        appointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        appointmentCreationCol1.setCellValueFactory(new PropertyValueFactory<>("creation date"));
        appointmentCreatedByCol1.setCellValueFactory(new PropertyValueFactory<>("created by"));
        appointmentUpdatedCol1.setCellValueFactory(new PropertyValueFactory<>("updated"));
        appointmentUpdatedByCol1.setCellValueFactory(new PropertyValueFactory<>("updated by"));
        appointmentCustomerIDCol1.setCellValueFactory(new PropertyValueFactory<>("customer id"));
        appointmentUserIDCol1.setCellValueFactory(new PropertyValueFactory<>("user id"));
        appointmentContactIDCol1.setCellValueFactory(new PropertyValueFactory<>("contact id"));

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

        appointmentIDCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getID()));
        appointmentTitleCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTitle()));
        appointmentDescriptionCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescription()));
        appointmentLocationCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLocation()));
        appointmentTypeCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getType()));
        appointmentStartCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStart()));
        appointmentEndCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEnd()));
        appointmentCreationCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCreation()));
        appointmentCreatedByCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCreatedBy()));
        appointmentUpdatedCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getUpdated()));
        appointmentUpdatedByCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getUpdatedBy()));
        appointmentCustomerIDCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getCustomerID()));
        appointmentUserIDCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getUserID()));
        appointmentContactIDCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getContactID()));

        appointmentIDCol1.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getID()));
        appointmentTitleCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTitle()));
        appointmentDescriptionCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescription()));
        appointmentLocationCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLocation()));
        appointmentTypeCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getType()));
        appointmentStartCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStart()));
        appointmentEndCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEnd()));
        appointmentCreationCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCreation()));
        appointmentCreatedByCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCreatedBy()));
        appointmentUpdatedCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getUpdated()));
        appointmentUpdatedByCol1.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getUpdatedBy()));
        appointmentCustomerIDCol1.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getCustomerID()));
        appointmentUserIDCol1.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getUserID()));
        appointmentContactIDCol1.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getContactID()));


        if (first == 1) {
            // Populates the tables
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

            // Populates the tables
            String query2 = "SELECT * FROM appointments";
            ResultSet resultset2 = statement.executeQuery(query2);
            appointments.clear();

            while (resultset2.next()) {
                Appointment appointment = new Appointment();
                appointment.setID(resultset2.getInt(1));
                appointment.setTitle(resultset2.getString(2));
                appointment.setDescription(resultset2.getString(3));
                appointment.setLocation(resultset2.getString(4));
                appointment.setType(resultset2.getString(5));
                appointment.setStart(resultset2.getString(6));
                appointment.setEnd(resultset2.getString(7));
                appointment.setCreation(resultset2.getString(8));
                appointment.setCreatedBy(resultset2.getString(9));
                appointment.setUpdated(resultset2.getString(10));
                appointment.setUpdatedBy(resultset2.getString(11));
                appointment.setCustomerID(Integer.parseInt(resultset2.getString(12)));
                appointment.setUserID(Integer.parseInt(resultset2.getString(13)));
                appointment.setContactID(Integer.parseInt(resultset2.getString(14)));
                appointments.add(appointment);
            }
            appointmentTable.setItems(appointments);
            appointmentTable2.setItems(appointments);
        }
        if (first >= 2) {
            Connection connection = JDBC.getConnection();
            Statement statement = connection.createStatement();
            // Populates the tables
            String query2 = "SELECT * FROM appointments";
            ResultSet resultset2 = statement.executeQuery(query2);
            appointments.clear();

            while (resultset2.next()) {
                Appointment appointment = new Appointment();
                appointment.setID(resultset2.getInt(1));
                appointment.setTitle(resultset2.getString(2));
                appointment.setDescription(resultset2.getString(3));
                appointment.setLocation(resultset2.getString(4));
                appointment.setType(resultset2.getString(5));
                appointment.setStart(resultset2.getString(6));
                appointment.setEnd(resultset2.getString(7));
                appointment.setCreation(resultset2.getString(8));
                appointment.setCreatedBy(resultset2.getString(9));
                appointment.setUpdated(resultset2.getString(10));
                appointment.setUpdatedBy(resultset2.getString(11));
                appointment.setCustomerID(Integer.parseInt(resultset2.getString(12)));
                appointment.setUserID(Integer.parseInt(resultset2.getString(13)));
                appointment.setContactID(Integer.parseInt(resultset2.getString(14)));
                appointments.add(appointment);
            }
            appointmentTable.setItems(appointments);
            appointmentTable2.setItems(appointments);
        }
        first++;

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
        appointmentIDText.setText("" + nextAppointmentID);

        //Populate ComboBox
        comboBoxValues.add("Canada");
        comboBoxValues.add("United Kingdom");
        comboBoxValues.add("United States");
        countryComboBox.setItems(comboBoxValues);

        //Populate Contact ComboBox
        String query = "Select Contact_ID, Contact_Name FROM contacts;";

        Connection connection = JDBC.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery(query)) {

            while (resultset.next()) {
                comboBoxValuesContacts.add(resultset.getString(2));
            }
        }
        contactComboBox.setItems(comboBoxValuesContacts);

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
    public void handleAddAppointmentButtonAction() {

        try {

            appointmentErrorLabel.setText("");

            Stage stage = (Stage) addButton.getScene().getWindow();

            //Get input values from TextFields into variables
            String appointmentID = appointmentIDText.getText();
            String appointmentTitle = appointmentTitleText.getText();
            String appointmentDescription = appointmentDescriptionText.getText();
            String appointmentLocation = appointmentLocationText.getText();
            String appointmentType = appointmentTypeText.getText();
            LocalDate startDate = appointmentStartDate.getValue();
            LocalDate endDate = appointmentEndDate.getValue();

            int customerID = Integer.parseInt(appointmentCustomerIDText.getText());
            int userID = Integer.parseInt(appointmentUserIDText.getText());
            int contactIndex = contactComboBox.getSelectionModel().getSelectedIndex() + 1;
            int startTimeIndex = appointmentStartTimeComboBox.getSelectionModel().getSelectedIndex();
            int endTimeIndex = appointmentEndTimeComboBox.getSelectionModel().getSelectedIndex();

            String startTime = comboBoxValuesTime.get(startTimeIndex);
            LocalTime localStartTime = LocalTime.parse(startTime);
            String endTime = comboBoxValuesTime.get(endTimeIndex);
            LocalTime localEndTime = LocalTime.parse(endTime);

            LocalDateTime startDateTime = LocalDateTime.of(startDate, localStartTime);
            startDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp timestamp2 = Timestamp.valueOf(startDateTime);
            String s2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp2);

            LocalDateTime endDateTime = LocalDateTime.of(endDate, localEndTime);
            endDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp timestamp3 = Timestamp.valueOf(endDateTime);
            String s3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp3);

            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            String creationDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp);

            String createdBy = "James";

            String query2 = "INSERT INTO appointments VALUES ('" + appointmentID + "', '" + appointmentTitle + "', '" +
                    appointmentDescription + "', '" + appointmentLocation + "', '" + appointmentType + "', '" +
                    s2 + "', '" + s3 + "', '" + creationDate + "', '" + createdBy + "', '" +
                    creationDate + "', '" + createdBy + "', '" + customerID + "', '" + userID + "', '" + contactIndex + "');";

            Connection connection = JDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query2);

            //Add appointment to list
            appointments.add(new Appointment(Integer.parseInt(appointmentID), appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, s2, s3, creationDate, createdBy, creationDate, createdBy, customerID, userID, contactIndex));
            appointmentTable.setItems(appointments);
            appointmentTable.refresh();
            appointmentTable2.setItems(appointments);
            appointmentTable2.refresh();

            //Once done, close
            stage.close();
        }
        catch (Exception e) {
        }
    }

    @FXML
    public void handleAddButtonAction() {

        try {

            customerErrorLabel.setText("");

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

            int divisionIDString = Integer.parseInt(divisionID);
            Customer c = new Customer(nextCustomerID, customerName, customerAddress, customerPostalCode, customerPhoneNumber, s, createdBy, s, createdBy, divisionIDString);
            customers.add(c);
            customerTable.setItems(customers);
            customerTable.refresh();

            associatedAppointments = associatedAppointmentTable.getItems();
            for (Appointment a : associatedAppointments) {
                c.addAppointment(a);
            }

            nextCustomerID++;

            //Once done, close
            stage.close();
        }
        catch (Exception e) {
            if (customerNameText.getText().equals("") || customerAddressText.getText().equals("") || customerPostalCodeText.getText().equals("") || customerPhoneNumberText.getText().equals("") || countryComboBox.getSelectionModel().getSelectedIndex() < 0 || fldComboBox.getSelectionModel().getSelectedIndex() < 0) {
                addCustomerErrorLabel.setText("Missing input values.");
            } else {
                addCustomerErrorLabel.setText("Wrong address format.");
            }
        }
    }

    @FXML
    public void handleModifyAddButtonAction() {

        try {

            customerErrorLabel.setText("");

            Stage stage = (Stage) addButton.getScene().getWindow();

            //Get input values from TextFields into variables
            customerName = customerNameText2.getText();
            customerPostalCode = customerPostalCodeText2.getText();
            customerPhoneNumber = customerPhoneNumberText2.getText();

            int countryIndex = countryComboBox.getSelectionModel().getSelectedIndex();
            int fldIndex = fldComboBox.getSelectionModel().getSelectedIndex();
            String customerCountry = comboBoxValues.get(countryIndex);
            String customerFLD = "";

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

            String query = "SELECT Division_ID, Division FROM first_level_divisions;";

            Connection connection = JDBC.getConnection();
            Statement statement = connection.createStatement();
            try (ResultSet resultset = statement.executeQuery(query)) {

                while (resultset.next()) {
                    if (customerFLD.equals(resultset.getString(2))) {
                        customerFLD = resultset.getString(1);
                        break;
                    }
                }
            }

            //Create a query and execute it.
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp);

            String query2 = "UPDATE customers SET Customer_Name = '" + customerName + "', Address = '" + customerAddressText2.getText() + "', Postal_Code = '" + customerPostalCode + "', Phone = '" + customerPhoneNumber + "', Last_Update = '" + s + "', Division_ID = '" + customerFLD + "' WHERE Customer_ID = " + customerIDText2.getText() + ";";
            statement.executeUpdate(query2);

            //FIXME NOT CORRECTLY UPDATING ASSOCIATED APPOINTMENT TABLE
            for (Customer c : customers) {
                if (String.valueOf(c.getId()).equals(customerIDText2.getText())) {
                    ObservableList<Appointment> list = c.getAppointments();
                    customers.remove(c);
                    c.setName(customerName);
                    c.setAddress(customerAddressText2.getText());
                    c.setPostalCode(customerPostalCode);
                    c.setPhoneNumber(customerPhoneNumber);
                    c.setLastUpdate(s);
                    c.setDivisionID(Integer.parseInt(customerFLD));
                    for (Appointment a : list) {
                        c.addAppointment(a);
                    }
                    for (Appointment a : associatedAppointments) {
                        c.addAppointment(a);
                    }
                    customers.add(c);
                    break;
                }
            }

            customerTable.setItems(customers);
            customerTable.refresh();

            //Once done, close
            stage.close();
        }
        catch (Exception e) {
            if (customerNameText2.getText().equals("") || customerAddressText2.getText().equals("") || customerPostalCodeText2.getText().equals("") || customerPhoneNumberText2.getText().equals("") || countryComboBox.getSelectionModel().getSelectedIndex() < 0 || fldComboBox.getSelectionModel().getSelectedIndex() < 0) {
                addCustomerErrorLabel.setText("Missing input values.");
            } else {
                addCustomerErrorLabel.setText("Wrong address format.");
            }
        }

    }

    @FXML
    public void modifyCustomer() {

        try {

            customerTable.getSelectionModel().setCellSelectionEnabled(true);
            customerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            if (customerTable.getSelectionModel().getSelectedItem() == null) {
                throw new Exception();
            }

            customerErrorLabel.setText("");
            Customer customer = customerTable.getSelectionModel().getSelectedItem();

            for (Customer c : customers) {

                if (c.getId() == customer.getId()) {
                    found = true;
                    found3 = true;

                    copyCustomerID = String.valueOf(c.getId());
                    copyCustomerName = c.getName();
                    copyCustomerAddress = c.getAddress();
                    copyCustomerPostal = c.getPostalCode();
                    copyCustomerPhone = c.getPhoneNumber();
                    copyCustomerDivisionID = String.valueOf(c.getDivisionID());
                    associatedAppointments2 = c.getAppointments();

                    switchToUpdateCustomer();
                    break;
                }
            }
            customerTable.refresh();
        } catch (Exception e) {
            customerErrorLabel.setText("Select a customer to be modified.");
        }
    }

    @FXML
    public void handleModifyAddAppointmentButtonAction() {

        try {

            appointmentErrorLabel.setText("");

            Stage stage = (Stage) addButton.getScene().getWindow();

            //Get input values from TextFields into variables
            String appointmentID = appointmentIDText2.getText();
            String appointmentTitle = appointmentTitleText2.getText();
            String appointmentDescription = appointmentDescriptionText2.getText();
            String appointmentLocation = appointmentLocationText2.getText();
            String appointmentType = appointmentTypeText2.getText();
            LocalDate appointmentStartDates = appointmentStartDate.getValue();
            LocalDate appointmentEndDates = appointmentEndDate.getValue();
            String appointmentCustomerID = appointmentCustomerIDText2.getText();
            String appointmentUserID = appointmentUserIDText2.getText();

            String appointmentStartTime = appointmentStartTimeComboBox.getValue();
            String appointmentEndTime = appointmentEndTimeComboBox.getValue();
            String appointmentStartTimeAndDate = appointmentStartDates.toString() + " " + appointmentStartTime;
            String appointmentEndTimeAndDate = appointmentEndDates.toString() + " " + appointmentEndTime;
            int contactID = contactComboBox.getSelectionModel().getSelectedIndex() + 1;

            //Create a query and execute it.
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp);

            String query = "UPDATE appointments SET Title = '" + appointmentTitle + "', Description = '" + appointmentDescription + "', Location = '" + appointmentLocation + "', Type = '" + appointmentType + "', Start = '" + appointmentStartTimeAndDate + "', End = '" + appointmentEndTimeAndDate + "', Last_Update = '" + s + "', Customer_ID = '" + appointmentCustomerID + "', User_ID = '" + appointmentUserID + "', Contact_ID = '" + contactID + "' WHERE Appointment_ID = " + appointmentUserIDText2.getText() + ";";

            Connection connection = JDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            for (Appointment a : appointments) {
                if (String.valueOf(a.getID()).equals(appointmentIDText2.getText())) {
                    String creation = a.getCreation();
                    String createdBy = a.getCreatedBy();
                    String updatedBy = a.getUpdatedBy();
                    appointments.remove(a);
                    a.setTitle(appointmentTitle);
                    a.setDescription(appointmentDescription);
                    a.setLocation(appointmentLocation);
                    a.setType(appointmentType);
                    a.setStart(appointmentStartTimeAndDate);
                    a.setEnd(appointmentEndTimeAndDate);
                    a.setCreation(creation);
                    a.setCreatedBy(createdBy);
                    a.setUpdated(s);
                    a.setUpdatedBy(updatedBy);
                    a.setCustomerID(Integer.parseInt(appointmentCustomerID));
                    a.setUserID(Integer.parseInt(appointmentUserID));
                    a.setContactID(contactID);
                    appointments.add(a);
                    break;
                }
            }

            appointmentTable.setItems(appointments);
            appointmentTable.refresh();
            appointmentTable2.setItems(appointments);
            appointmentTable2.refresh();

            //Once done, close
            stage.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            if (customerNameText2.getText().equals("") || customerAddressText2.getText().equals("") || customerPostalCodeText2.getText().equals("") || customerPhoneNumberText2.getText().equals("") || countryComboBox.getSelectionModel().getSelectedIndex() < 0 || fldComboBox.getSelectionModel().getSelectedIndex() < 0) {
                addCustomerErrorLabel.setText("Missing input values.");
            } else {
                addCustomerErrorLabel.setText("Wrong address format.");
            }
        }

    }

    @FXML
    public void modifyAppointment() {

        try {

            appointmentTable.getSelectionModel().setCellSelectionEnabled(true);
            appointmentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            if (appointmentTable.getSelectionModel().getSelectedItem() == null) {
                throw new Exception();
            }

            appointmentErrorLabel.setText("");
            Appointment appointment = appointmentTable.getSelectionModel().getSelectedItem();

            for (Appointment a : appointments) {

                if (a.getID() == appointment.getID()) {

                    found2 = true;

                    copyAppointmentID = String.valueOf(appointment.getID());
                    copyAppointmentTitle = appointment.getTitle();
                    copyAppointmentDescription = appointment.getDescription();
                    copyAppointmentLocation = appointment.getLocation();
                    copyAppointmentType = appointment.getType();
                    copyAppointmentStartDate = appointment.getStart();
                    copyAppointmentEndDate = appointment.getEnd();
                    copyAppointmentCustomerID = String.valueOf(appointment.getCustomerID());
                    copyAppointmentUserID = String.valueOf(appointment.getUserID());
                    copyAppointmentContactID = String.valueOf(appointment.getContactID());

                    switchToUpdateAppointment();
                    break;
                }
            }
            appointmentTable.refresh();
            appointmentTable2.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            appointmentErrorLabel.setText("Select an appointment to be modified.");
        }
    }

    @FXML
    private void addAppointment() {

        try {

            appointmentTable2.getSelectionModel().setCellSelectionEnabled(true);
            appointmentTable2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            if (appointmentTable2.getSelectionModel().getSelectedItem() == null) {
                throw new Exception();
            }

            customerErrorLabel.setText("");
            //FIXME HERE Glitch after addiong twice
            Appointment appointment = appointmentTable2.getSelectionModel().getSelectedItem();
            for (Appointment a : associatedAppointments2) {
                associatedAppointments.add(a);
            }
            associatedAppointments.add(appointment);
            associatedAppointmentTable.setItems(associatedAppointments);
            associatedAppointmentTable.refresh();

            customerErrorLabel.setText("Appointment successfully added.");
        } catch (Exception e) {
            customerErrorLabel.setText("Select an appointment to be added.");
        }
    }

    @FXML
    public void deleteCustomer() {

        try {

            customerTable.getSelectionModel().setCellSelectionEnabled(true);
            customerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            if (customerTable.getSelectionModel().getSelectedItem() == null) {
                throw new Exception();
            }

            customerErrorLabel.setText("");
            Customer customer = customerTable.getSelectionModel().getSelectedItem();

            for (Customer c : customers) {

                if (c.getId() == customer.getId()) {

                    String query = "DELETE FROM customers WHERE Customer_ID = " + customer.getId() + ";";

                    Connection connection = JDBC.getConnection();
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);

                    customers.remove(c);
                    break;
                }
            }
            customerErrorLabel.setText("Customer successfully deleted.");
            customerTable.refresh();
        } catch (Exception e) {
            customerErrorLabel.setText("Select a customer to be deleted.");
        }
    }

    @FXML
    private void removeAssociatedAppointment() {
        try {

            associatedAppointmentTable.getSelectionModel().setCellSelectionEnabled(true);
            associatedAppointmentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            if (associatedAppointmentTable.getSelectionModel().getSelectedItem() == null) {
                throw new Exception();
            }

            appointmentErrorLabel.setText("");
            Appointment appointment = associatedAppointmentTable.getSelectionModel().getSelectedItem();

            associatedAppointments.remove(appointment);
            appointmentErrorLabel.setText("Appointment successfully removed.");
            associatedAppointmentTable.refresh();
        } catch (Exception e) {
            appointmentErrorLabel.setText("Select an appointment to be removed.");
        }
    }

    @FXML
    public void deleteAppointment() {

        try {

            appointmentTable.getSelectionModel().setCellSelectionEnabled(true);
            appointmentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            if (appointmentTable.getSelectionModel().getSelectedItem() == null) {
                throw new Exception();
            }

            appointmentErrorLabel.setText("");
            Appointment appointment = appointmentTable.getSelectionModel().getSelectedItem();

            for (Appointment a : appointments) {

                if (a.getID() == appointment.getID()) {

                    String query = "DELETE FROM appointments WHERE Appointment_ID = " + appointment.getID() + ";";

                    Connection connection = JDBC.getConnection();
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);

                    appointments.remove(a);
                    break;
                }
            }
            appointmentErrorLabel.setText("Appointment successfully deleted.");
            appointmentTable.refresh();
            appointmentTable2.refresh();
        } catch (Exception e) {
            appointmentErrorLabel.setText("Select an appointment to be deleted.");
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
    private void switchToAddCustomer() throws IOException, SQLException {
        customerErrorLabel.setText("");

        //Find next Customer ID
        String query3 = "SELECT Customer_ID FROM customers;";
        int max = 0;

        Connection connection3 = JDBC.getConnection();
        Statement statement3 = connection3.createStatement();
        try (ResultSet resultset = statement3.executeQuery(query3)) {

            while (resultset.next()) {
                if (Integer.parseInt(resultset.getString(1)) > max) {
                    max = Integer.parseInt(resultset.getString(1));
                }
            }
        }
        nextCustomerID = ++max;

        String fileName = "addCustomer";
        Main.loadAddCustomer(fileName);
    }

    @FXML
    private void switchToAddAppointment() throws IOException, SQLException {
        appointmentErrorLabel.setText("");

        //Find next Customer ID
        String query3 = "SELECT Appointment_ID FROM appointments;";
        int max = 0;

        Connection connection3 = JDBC.getConnection();
        Statement statement3 = connection3.createStatement();
        try (ResultSet resultset = statement3.executeQuery(query3)) {

            while (resultset.next()) {
                if (Integer.parseInt(resultset.getString(1)) > max) {
                    max = Integer.parseInt(resultset.getString(1));
                }
            }
        }
        nextAppointmentID = ++max;

        //Find next Appointment ID

        String fileName = "addAppointment";
        Main.loadAddAppointment(fileName);
    }

    @FXML
    private void switchToUpdateCustomer() throws IOException {
        String fileName = "updateCustomer";
        Main.loadModifyCustomer(fileName);
    }

    @FXML
    private void switchToUpdateAppointment() throws IOException {
        String fileName = "updateAppointment";
        Main.loadModifyAppointment(fileName);
    }
}
