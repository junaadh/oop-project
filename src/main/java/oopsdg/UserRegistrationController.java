package oopsdg;

import java.io.IOException;

import javafx.application.Platform;
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

public class UserRegistrationController {

    private Parent root;
    private Scene scene;
    private Stage stage;

    
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerButton;

    @FXML
    private Button menuButton;

    @FXML
    private Text errorMessage;

    @FXML
    private Hyperlink login;

    public void switchToLogin(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
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

    // public void reegister(ActionEvent e) throws IOException {

    //     if (firstName.getText().isEmpty()) {
    //         errorMessage.setText("*First name cannot be left blank");
    //         Helper.showFloatingToast(stage, "First name cannot be left blank", null);
    //     } else if (lastName.getText().isEmpty()) {
    //         errorMessage.setText("*Last name cannot be left blank");
    //         Helper.showFloatingToast(stage, "Last name cannot be blank", null);
    //     } else if (username.getText().isEmpty()) {
    //         errorMessage.setText("*Username cannot be left blank");
    //         Helper.showFloatingToast(stage, "Username cannot be left blank", null);
    //     } else if (password.getText().isEmpty()) {
    //         errorMessage.setText("*Password cannot be left blank");
    //         Helper.showFloatingToast(stage, "password cannot be left blank", null);
    //     } else {
    //         if (User.guiLogin(username.getText(), null).equals("!username")) {
    //             if (password.getText().length() >= 6) {
    //                     User.guiRegister(firstName.getText(), lastName.getText(), username.getText(), password.getText());
    //                     root = FXMLLoader.load(getClass().getResource("user.fxml"));
    //                     stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    //                     scene = new Scene(root);
    //                     stage.setScene(scene);
    //                     stage.show();
    //                 } else {
    //                     errorMessage.setText("*password must be atleast 6 letters long");
    //                     Helper.showFloatingToast(stage, "password must be longer than 6 letters", null);
    //                 }
    //         } else {
    //             errorMessage.setText("*Username already registered");
    //             Helper.showFloatingToast(stage, "Username already registered", null);
    //         }
    //     }
    // }

    public void reegister(ActionEvent e) {
    if (firstName.getText().isEmpty()) {
        errorMessage.setText("*First name cannot be left blank");
        Helper.showFloatingToast(stage, "First name cannot be left blank", null);
    } else if (lastName.getText().isEmpty()) {
        errorMessage.setText("*Last name cannot be left blank");
        Helper.showFloatingToast(stage, "Last name cannot be blank", null);
    } else if (username.getText().isEmpty()) {
        errorMessage.setText("*Username cannot be left blank");
        Helper.showFloatingToast(stage, "Username cannot be left blank", null);
    } else if (password.getText().isEmpty()) {
        errorMessage.setText("*Password cannot be left blank");
        Helper.showFloatingToast(stage, "Password cannot be left blank", null);
    } else {
        if (User.guiLogin(username.getText(), null).equals("!username")) {
            if (password.getText().length() >= 6) {
                Thread registrationThread = new Thread(() -> {
                    User.guiRegister(firstName.getText(), lastName.getText(), username.getText(), password.getText());
                });
                registrationThread.start();
                
                try {
                    registrationThread.join();
                    // Registration is complete, perform UI updates
                    Platform.runLater(() -> {
                        try {
                            root = FXMLLoader.load(getClass().getResource("user.fxml"));
                            stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } else {
                errorMessage.setText("*Password must be at least 6 letters long");
                Helper.showFloatingToast(stage, "Password must be longer than 6 letters", null);
            }
        } else {
            errorMessage.setText("*Username already registered");
            Helper.showFloatingToast(stage, "Username already registered", null);
        }
    }
}

}
