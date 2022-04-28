package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/**
 * The main method of the program. This program allows users to login to their account to add and modify customers and their corresponding appointments.
 *
 * @author James Blankenship
 * @version 1.0
 */

public class Main extends Application {

    /**
     * Loads the login GUI.
     * @param primaryStage the stage to be loaded.
     * @throws Exception if the file is not found.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
        primaryStage.setTitle("Dashboard");
        primaryStage.setScene(new Scene(root, 627, 328));
        primaryStage.show();
    }

    /**
     *
     * @param fxml the fxml file to be loaded.
     * @return the parent fxml loader.
     * @throws IOException if the file cannot be found.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Loads main GUI.
     * @param file the FXML file to be loaded.
     * @throws IOException if the file cannot be found.
     */
    public static void loadHome(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 880, 356);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * Loads add customer GUI.
     * @param file the FXML file to be loaded.
     * @throws IOException if the file cannot be found.
     */
    public static void loadAddCustomer(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 439, 454);
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * Loads upcoming appointment GUI.
     * @param file the FXML file to be loaded.
     * @throws IOException if the file cannot be found.
     */
    public static void loadUpcomingAppointment(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 439, 235);
        stage.setTitle("Upcoming Appointment");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * Loads the add appointment GUI.
     * @param file the FXML file to be loaded.
     * @throws IOException if the file cannot be found.
     */
    public static void loadAddAppointment(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 424, 566);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * Loads the modify customer GUI.
     * @param file the FXML file to be loaded.
     * @throws IOException if the file cannot be found.
     */
    public static void loadModifyCustomer(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 881, 454);
        stage.setTitle("Modify Customer");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * Loads the modify appointment GUI.
     * @param file the FXML file to be loaded.
     * @throws IOException if the file cannot be found.
     */
    public static void loadModifyAppointment(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 424, 566);
        stage.setTitle("Modify Appointment");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * Loads report GUI.
     * @param file the FXML file to be loaded.
     * @throws IOException if the file cannot be found.
     */
    public static void loadReports(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 880, 415);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * Main method
     * @param args starting arguments.
     */
    public static void main(String[] args) {
        JDBC.makeConnection();

        launch(args);

        JDBC.closeConnection();
    }
}
