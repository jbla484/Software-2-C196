package sample;

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

    //TextFields
    @FXML
    public TextField userID = new TextField();
    @FXML
    public TextField userPassword = new TextField();

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
    public String lang = "";

    @FXML
    public void initialize() {

        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);

        closeButton.setOnMouseClicked(event -> onCloseButtonClick());

        String country = locale.getDisplayCountry();
        locationText.setText("Location: " + country);

        //Translate English to French on dashboard.
        if(locale.toString().equals("fr_FR")) {
            dashTitle.setText(rb.getString("home1"));
            dashTitle2.setText("Connexion");
            dashLabel1.setText("Cette application permet à ses utilisateurs de se connecter à leur compte à " +
                    "partir d'une base de données, de déterminer le pays de l'utilisateur et d'afficher un " +
                    "calendrier de tous les rendez-vous programmés.");
            dashLabel4.setText("L'application permet également à l'utilisateur d'ajouter, de supprimer et de " +
                    "mettre à jour les enregistrements et les rendez-vous des clients. Les utilisateurs peuvent " +
                    "afficher les horaires de rendez-vous d'un mois à l'autre ou d'une semaine à l'autre. " +
                    "L'application alerte ses utilisateurs lorsqu'il y a un rendez-vous dans les 15 minutes " +
                    "suivant la connexion de l'utilisateur.");
            dashLabel2.setText("");
            dashLabel3.setText("Si vous avez des questions ou des préoccupations, n'hésitez pas à me contacter à " +
                    "Jbla484@wgu.edu.");
            dashUsername.setText("Nom d'utilisateur:");
            dashPassword.setText("Mot de passe:");
            locationText.setText("Lieu: " + country);
            closeButton.setText("Fermer");
            loginButton.setText("Connexion");
        }
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
            if (lang != "English") {
                errorDescription.setText("Nom d'utilisateur ou mot de passe invalide.");
            } else {
                errorDescription.setText("Invalid username or password.");
            }

        } else {

            errorDescription.setText("Successfully logged in.");

            switchToHome();
            System.out.println("Logged in!");
        }
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
