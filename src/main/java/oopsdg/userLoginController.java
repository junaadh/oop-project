package oopsdg;

import java.io.IOException;

/**
 * @author Junaadh
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class userLoginController implements Initializable {

    private Stage stage;
    private Parent root;
    private Scene scene;

    private String user;
    private Alert alert;

    @FXML
    private Button loginButton;

    @FXML
    private Button menButton;

    @FXML
    private Text errorMessage;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Hyperlink register;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Implemented as according to JavaFX Docs;
    }

    private void alert(String header, String content) {
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    public void switchToUser(ActionEvent e) throws IOException{
        if (username.getText() == "") {
            errorMessage.setText("*Username field cannot be emoty");
        } else if (password.getText() == "") {
            errorMessage.setText("*Password field cannot be empty");
        } else {
            switch (User.guiLogin(username.getText(), password.getText())) {
                case "!username":
                    alert("Username not found", "Please enter a correct username");
                    errorMessage.setText("*Invaild username");
                    break;

                case "!password":
                    alert("Password incorrect", "Please enter the correct password for " + username.getText());
                    errorMessage.setText("*Password entered is incorrect");
                    break;

                default:
                    user = username.getText();
                    System.out.println(user);
                    // root = FXMLLoader.load(getClass().getResource("user.fxml"));
                    // stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                    // scene = new Scene(root);
                    // stage.setScene(scene);
                    // stage.show();
                    //WORK IN PROGRESS
            }
        }
    }

    public void awitchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegistration(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userRegistration.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
