package oopsdg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeRoot, 1220, 720);

        // WelcomeController welcome = loader.getController();
        // welcome.initialize();
        
        stage.setResizable(false);
        stage.setTitle("JavaApp");
        stage.setScene(welcomeScene);
        stage.show();

    }

    public static void main(String[] args) {
        // EnergyMonitor.StartEngine();
        launch();
    }

}