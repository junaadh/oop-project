package oopsdg;

/**
 * @author Junaadh
 */

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

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
    @FXML 
    private Button backButton;

    @FXML
    private Button aboutButton;

    @FXML
    private WebView webview;

    // Method which runs by default when the scene loads, part of the Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webview.getEngine().load("https://www.globalgoals.org/goals/13-climate-action/");   //loads selected url in webview
    }

    // method to goes to last visited page in webview mapped to a button
    public void goBack(ActionEvent e) throws IOException {
        if (webview.getEngine().getHistory().getCurrentIndex() > 0) {
                webview.getEngine().getHistory().go(-1);
            }
    }
    
    // method to switch scenes mapped to a button
    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("credits.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
