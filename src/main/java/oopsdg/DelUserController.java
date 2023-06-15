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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class DelUserController implements Initializable {
    
    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
    @FXML
    private TextField username;

    @FXML
    private Button deleteButton;
    
    @FXML
    private Button backButton;

    @FXML
    private ImageView correct;

    @FXML
    private ImageView wrong;

    // volatile variables which can be accessed by different threads
    private volatile boolean loopRun;
    private volatile Map<String, User> usermap = FileHandler.loadUser();

    // Method which runs by default when the scene loads, part of the Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loopRun = true;
        checkUserPresent();
        
    }

    // Method to create a seperate thread which run in parallel to main thread, which checks if useer is present in userData.txt file in realtime
    private void checkUserPresent() {
        Thread thread = new Thread(() -> {
            while(loopRun) {
                if (!username.getText().isEmpty()) {
                    if (usermap.containsKey(username.getText())) {
                        wrong.setVisible(false);
                        correct.setVisible(true);
                        deleteButton.setDisable(false);

                    } else {
                        correct.setVisible(false);
                        wrong.setVisible(true);
                        deleteButton.setDisable(true);
                    }
                }
                if (Thread.currentThread().isInterrupted()) {   // if loop when thread is interrupted ends thread
                    loopRun = false;
                    break;
                }

                // try catch block to Handle exceptions
                try {
                    Thread.sleep(300);                  // makes loop sleep for 300ms to prevent cpu overload
                } catch (Exception e) {
                    loopRun = false;
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
        });
        //starts the thread
        thread.start();
    }

    // method to delete user which is mapped to a button
    public void delUser(ActionEvent e) throws IOException {
        Admin.guiDelUser(username.getText());
        Helper.showFloatingToast(stage, "User " + username.getText() + " has been deleted", null);
        switchBack(e);
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