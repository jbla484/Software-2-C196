package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class Controller {

    //Buttons
    @FXML
    public Button closeButton = new Button();

    //TextFields
    @FXML
    public TextField userID = new TextField();
    @FXML
    public TextField userPassword = new TextField();

    //Variables
    @FXML
    public String userIDs = "";
    @FXML
    public String userPasswords = "";

    @FXML
    public void initialize() {
        closeButton.setOnMouseClicked(event -> onCloseButtonClick());
    }

    @FXML
    public void checkLoginButton() {

        //Get user input from TextField and save data in variables.
        userIDs = userID.getText();
        userPasswords = userPassword.getText();

        System.out.println(userIDs + "\n" + userPasswords);
    }

    @FXML
    public void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
