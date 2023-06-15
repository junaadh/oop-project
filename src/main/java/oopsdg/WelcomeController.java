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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WelcomeController {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Stage stage;
    private Scene scene;
    private Parent root;

    //Inject FXML components to be able to use them in methods
    @FXML
    private ImageView userIcon;

    @FXML
    private Button userButton;
    
    @FXML
    private ImageView creditsIcon;

    @FXML
    private Button creditsButton;

    @FXML
    private ImageView adminIcon;

    @FXML
    private Button adminButton;

    // method to switch to user login scene mapped to button
    public void switchToUserLogin(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to switch to about scene mapped to button
    public void switchToCredits(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("credits.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to switch to admin login scene mapped to button
    public void switchToAdminLogin(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
