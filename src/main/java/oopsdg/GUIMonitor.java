package oopsdg;

/**
 * @author Junaadh
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIMonitor extends Application {

    // sets the stage and scene for gui
    @Override
    public void start(Stage stage) throws Exception {
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeRoot, 1220, 720);

        Image icon = new Image(getClass().getResource("assets/world.png").toExternalForm());
        stage.setOnCloseRequest((WindowEvent w) -> {
            Platform.exit();
            System.exit(0);
        });
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