package oopsdg;

/*
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserController implements Initializable {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
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

    // Method which runs by default when the scene loads, part of the Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialized as per JavaFX Docs.
        String[] username = Helper.tempLoginCreds().split(",");     // reads username from tmp file created upon login
        String text = "Welcome, " + Helper.getFullName(username[0]);      // gets first name and last name and displays it
        welcomeMessage.setText(text);
    }

    // Method to switch scene to list by compnay mapped to a button
    public void switchToListByCompany(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("company.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Method to switch scene to list by month mapped to a button
    public void switchToListByMonth(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("month.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Method to switch scene to list by overuse mapped to a button
    public void switchToBadUse(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("baduse.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Method to switch scene to list mapped to a button
    public void switchToList(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    // method to switch back to welcome page / logout
    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
