package oopsdg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX GUI App
 */
public class GUIMonitor extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeRoot, 1220, 720);

        // WelcomeController welcome = loader.getController();
        // welcome.initialize();
        
        // Image icon = new Image("src/main/resources/oopsdg/assets/world.png");
        stage.setResizable(false);
        stage.setTitle("EcoWatch");
        stage.setScene(welcomeScene);
        // stage.getIcons().add(icon);
        stage.show();

    }

    public static void Launch() {
        launch();
    }

}