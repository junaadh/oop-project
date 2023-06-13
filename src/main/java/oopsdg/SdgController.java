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
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class SdgController implements Initializable {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML 
    private Button backButton;

    @FXML
    private Button aboutButton;

    @FXML
    private WebView webview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webview.getEngine().load("https://www.globalgoals.org/goals/13-climate-action/");
    }

    public void goBack(ActionEvent e) throws IOException {
        if (webview.getEngine().getHistory().getCurrentIndex() > 0) {
                webview.getEngine().getHistory().go(-1);
            }
    }
    
    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
