package oopsdg;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeRoot, 1220, 720);
        stage.setOnCloseRequest(event -> {
            Platform.exit();
        });
        stage.setResizable(false);
        stage.setTitle("JavaApp");
        stage.setScene(welcomeScene);
        stage.show();

    }
}