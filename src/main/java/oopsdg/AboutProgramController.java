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

public class AboutProgramController {
    
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Button backButton;

    public void goBack(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("credits.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
