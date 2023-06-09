package oopsdg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WelcomeController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // Done as per JavaFX Documentation
    }

    public void switchToUserLogin(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCredits(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("credits.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminLogin(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
