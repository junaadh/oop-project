package oopsdg;

/**
 * @author Junaadh
 */

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

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
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

    // volatile variables which can be accessed by different threads
    private volatile boolean loopRun;
    private volatile Map<String, Admin> adminmap = FileHandler.loadAdmin();

    // Method which runs by default when the scene loads, part of the Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loopRun = true;
        checkUsernameAvailability();
        
    }

    // Method to create a seperate thread which run in parallel to main thread, which checks username availability in realtime
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
                if (Thread.currentThread().isInterrupted()) {   // if loop which if thread is interuppted ends it
                    loopRun = false;
                    break;
                }

                // try catch block to Handle exceptions
                try {
                    Thread.sleep(300);                  // makes the loop sleep for 300ms to prevent cpu overload
                } catch (Exception e) {
                    loopRun = false;
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
        });
        // starts the thread
        thread.start();
    }

    //Method which listens to an Event/ click on the button to which its linked to and changes scene
    public void addAdmin(ActionEvent e) throws IOException {
        if (password.getText().length() >= 6) {
            Admin.guiAddAdmin(firstname.getText(), lastname.getText(), username.getText(), password.getText());
            Helper.showFloatingToast(stage, firstname.getText() + " " + lastname.getText() + " has been added", null);
            switchBack(e);
        } else {
            Helper.showFloatingToast(stage, "*password cannot be less than 6 digits", null);
        }
    }

    //Method which listens to an Event/ click on the button to which its linked to and changes scene
    public void switchBack(ActionEvent e) throws IOException {
        loopRun = false;
        String text[] = Helper.tempLoginCreds().split(",");
        String fxml = " ";
        
        // If loop which checks the logged in user type based on the created tmp file and decides which scene to load
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
