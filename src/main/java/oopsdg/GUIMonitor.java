package oopsdg;

/**
 * @author Junaadh
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GUIMonitor extends Application {

    // sets the stage and scene for gui
    @Override
    public void start(Stage stage) throws Exception {
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeRoot, 1220, 720);

        Image icon = new Image(getClass().getResource("assets/world.png").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("EcoWatcher");
        stage.setScene(welcomeScene);
        stage.getIcons().add(icon);
        stage.show();

    }

    // lauches app using lauch method of application superclass
    public static void Launch() {
        launch();
    }

}