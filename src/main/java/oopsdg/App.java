package oopsdg;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeRoot, 1220, 720);
        stage.setOnCloseRequest(event -> {
            Platform.exit();
        });
        Image icon = new Image(getClass().getResourceAsStream("assets/world.png"));
        stage.setResizable(false);
        stage.setTitle("Energy Best");
        stage.getIcons().add(icon);
        stage.setScene(welcomeScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}