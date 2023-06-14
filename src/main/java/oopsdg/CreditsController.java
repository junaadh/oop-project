package oopsdg;

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

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button backButton;

    @FXML
    private Button sdgButton;

    @FXML
    private Button teamButton;

    @FXML
    private Button programButton;

    public void switchToSdg(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutsdg.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToProgram(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutprogram.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTeam(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutus.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
