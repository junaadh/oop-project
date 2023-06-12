package oopsdg;

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
    private Parent root;
    private Scene scene;
    private Stage stage;

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

    public void switchToWelcome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void login(ActionEvent e) throws IOException {
        if (username.getText().isEmpty()) {
            errorMessage.setText("*Username field cannot be empty");
        } else if (password.getText().isEmpty()) {
            errorMessage.setText("*Password field cannot be empty");
        } else {
            if (Admin.guiAuth(username.getText(), password.getText()).equals("#")) {
                root = FXMLLoader.load(getClass().getResource("suAdmin.fxml"));
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

            } else if (Admin.guiAuth(username.getText(), password.getText()).equals("!username")) {
                Helper.showFloatingToast(stage, "Please enter a correct username", null);
                errorMessage.setText("*Invaild username");
                    
            } else if (Admin.guiAuth(username.getText(), password.getText()).equals("!password")) {
                Helper.showFloatingToast(stage, "Please enter correct password", null);
                errorMessage.setText("*Incorrect password");
                    
            } 
        }
    }
}
