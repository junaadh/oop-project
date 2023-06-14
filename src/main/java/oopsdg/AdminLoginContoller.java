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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminLoginContoller {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button menuButton;

    @FXML
    private Text errorMessage;

    // method to switch to welcome scene
    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // method which controlls login mapped to a button
    public void login(ActionEvent e) throws IOException {

        if (username.getText().isEmpty()) {
            errorMessage.setText("*Username field cannot be empty");    // checks that username field is not empty

        } else if (password.getText().isEmpty()) {
            errorMessage.setText("*Password field cannot be empty");    // checks that password field is not empty

        } else {
            if (Admin.guiAuth(username.getText(), password.getText()).equals("#")) {    // inputs user input into Auth method which returns admin access level
                root = FXMLLoader.load(getClass().getResource("suAdmin.fxml"));             // based on said access either # or $ assigns which scene to log them into
                stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else if (Admin.guiAuth(username.getText(), password.getText()).equals("$")) {
                root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else if (Admin.guiAuth(username.getText(), password.getText()).equals("!username")) {     //checks if username is not present in admin file
                Helper.showFloatingToast(stage, "Please enter a correct username", null);       // if username not found sets the warning message
                errorMessage.setText("*Invaild username");
                    
            } else if (Admin.guiAuth(username.getText(), password.getText()).equals("!password")) {     //checks if password is wrong
                Helper.showFloatingToast(stage, "Please enter correct password", null);        
                errorMessage.setText("*Incorrect password");
                    
            } 
        }
    }
}
