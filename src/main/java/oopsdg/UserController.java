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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserController implements Initializable {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Text welcomeMessage;

    @FXML
    private Button listButton;

    @FXML
    private Button companyButton;

    @FXML
    private Button monthButton;

    @FXML
    private Button baduseButton;

    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialized as per JavaFX Docs.
        String[] username = Helper.tempLoginCreds().split(",");
        String text = "Welcome, " + Helper.getFullName(username[0]);
        welcomeMessage.setText(text);
    }

    public void switchToListByCompany(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("company.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToList(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
