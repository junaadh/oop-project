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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddAdminController implements Initializable {
    
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private ImageView correct;

    @FXML
    private ImageView wrong;

    private volatile boolean loopRun;
    private volatile Map<String, Admin> adminmap = FileHandler.loadAdmin();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loopRun = true;
        checkUsernameAvailability();
        
    }

    private void checkUsernameAvailability() {
        Thread thread = new Thread(() -> {
            while(loopRun) {
                if (!username.getText().isEmpty()) {
                    if (adminmap.containsKey(username.getText())) {
                        wrong.setVisible(true);
                        correct.setVisible(false);
                        addButton.setDisable(true);
                    } else {
                        correct.setVisible(true);
                        wrong.setVisible(false);
                        addButton.setDisable(false);
                    }
                }
                if (Thread.currentThread().isInterrupted()) {
                    loopRun = false;
                    break;
                }

                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    loopRun = false;
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
        });
        thread.start();
    }

    public void addAdmin(ActionEvent e) throws IOException {
        Admin.guiAddAdmin(firstname.getText(), lastname.getText(), username.getText(), password.getText());
        Helper.showFloatingToast(stage, firstname.getText() + " " + lastname.getText() + " has been added", null);
        switchBack(e);
    }

    public void switchBack(ActionEvent e) throws IOException {
        loopRun = false;
        String text[] = Helper.tempLoginCreds().split(",");
        String fxml = " ";
        
        if (text[1].equals("u")) {
            fxml = "user.fxml";
        } else if (text[1].equals("#")) {
            fxml = "suAdmin.fxml";
        } else if (text[1].equals("$")) {
            fxml = "admin.fxml";
        }

        root = FXMLLoader.load(getClass().getResource(fxml));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
