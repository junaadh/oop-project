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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserLoginController {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Stage stage;
    private Parent root;
    private Scene scene;

    //Inject FXML components to be able to use them in methods
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

    // method to log user in mapped to a button
    public void switchToUser(ActionEvent e) throws IOException{
        if (username.getText().isEmpty()) {
            errorMessage.setText("*Username field cannot be empty");
        } else if (password.getText().isEmpty()) {
            errorMessage.setText("*Password field cannot be empty");
        } else {
            switch (User.guiLogin(username.getText(), password.getText())) {
                case "!username":
                    Helper.showFloatingToast(stage, "Please enter a correct username", null);
                    errorMessage.setText("*Invaild username");
                    break;

                case "!password":
                    Helper.showFloatingToast(stage, "Please enter the correct password for " + username.getText(), null);
                    errorMessage.setText("*Password entered is incorrect");
                    break;

                default:
                    username.getText();
                    root = FXMLLoader.load(getClass().getResource("user.fxml"));
                    stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
            }
        }
    }

    // method to go back to welcome page mapped to a button
    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to go to user registration scene mapped to a button
    public void switchToRegistration(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userRegistration.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
