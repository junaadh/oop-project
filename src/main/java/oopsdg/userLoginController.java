package oopsdg;

import java.io.IOException;

/**
 * @author Junaadh
 */

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

public class userLoginController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    private String user;

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
                    user = username.getText();
                    System.out.println(user);
                    root = FXMLLoader.load(getClass().getResource("user.fxml"));
                    stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
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
