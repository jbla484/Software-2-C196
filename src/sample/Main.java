package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
        primaryStage.setTitle("Dashboard");
        primaryStage.setScene(new Scene(root, 627, 328));
        primaryStage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

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

    public static void loadAddCustomer(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 424, 450);
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

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

    public static void loadModifyCustomer(String file) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(loadFXML(file), 424, 450);
        stage.setTitle("Modify Customer");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }


    public static void main(String[] args) {
        JDBC.makeConnection();

        launch(args);

        JDBC.closeConnection();
    }
}
