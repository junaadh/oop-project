package oopsdg;

/**
 * @author Junaadh
 */

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutUsContoller {
    
    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
    @FXML
    private Button backButton;

    //Method which listens to an Event/ click on the button to which its linked to and changes scene
    public void goBack(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("credits.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
