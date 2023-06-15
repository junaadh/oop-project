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

public class CreditsController {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
    @FXML
    private Button backButton;

    @FXML
    private Button sdgButton;

    @FXML
    private Button teamButton;

    @FXML
    private Button programButton;

    // method to switch to scene displaying information about sdg13 mapped to a button
    public void switchToSdg(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutsdg.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Method which listens to an Event/ click on the button to which its linked to and changes scene
    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to change scene to about program mapped to a button
    public void switchToProgram(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutprogram.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to chnage scene to about team mapped to a button
    public void switchToTeam(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutus.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
