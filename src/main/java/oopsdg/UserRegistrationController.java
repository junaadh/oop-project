package oopsdg;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserRegistrationController implements Initializable{

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
    
    @FXML
    private ImageView correct;
    
    @FXML
    private ImageView wrong;

    private volatile boolean loopRun = true;
    private volatile Map<String, User> usermap = FileHandler.loadUser();

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerButton.setDisable(true);
        loopRun = true;
        loopthread();
    }

    private void loopthread() {
        Thread thread = new Thread(() -> {
            while (loopRun) {
                if (!username.getText().isEmpty()) {
                    if (usermap.containsKey(username.getText())) {
                        correct.setVisible(false);
                        wrong.setVisible(true);
                        registerButton.setDisable(true);
                    } else {
                        wrong.setVisible(false);
                        correct.setVisible(true);
                        registerButton.setDisable(false);
                    }
                }
                if (Thread.currentThread().isInterrupted()) {
                    loopRun = false;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    loopRun = false;
                    //Thread.currentThread().interrupt;
                }
            }
        });
        thread.start();
    }

    public void switchToLogin(ActionEvent e) throws IOException {
        loopRun = false;
        root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWelcome(ActionEvent e) throws IOException {
        loopRun = false;
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void reegister(ActionEvent e) throws IOException {

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
            Helper.showFloatingToast(stage, "password cannot be left blank", null);
        } else {
            if (User.guiLogin(username.getText(), null).equals("!username")) {
                if (password.getText().length() >= 6) {
                        loopRun = false;
                        User.guiRegister(firstName.getText(), lastName.getText(), username.getText(), password.getText());
                        root = FXMLLoader.load(getClass().getResource("user.fxml"));
                        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        errorMessage.setText("*password must be atleast 6 letters long");
                        Helper.showFloatingToast(stage, "password must be longer than 6 letters", null);
                    }
            } else {
                errorMessage.setText("*Username already registered");
                Helper.showFloatingToast(stage, "Username already registered", null);
            }
        }
    }
}
