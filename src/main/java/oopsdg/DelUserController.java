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
    
    private Parent root;
    private Scene scene;
    private Stage stage;

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

    private volatile boolean loopRun;
    private volatile Map<String, User> usermap = FileHandler.loadUser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loopRun = true;
        checkUserPresent();
        
    }

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

    public void delUser(ActionEvent e) throws IOException {
        Admin.guiDelUser(username.getText());
        Helper.showFloatingToast(stage, "User " + username.getText() + " has been deleted", null);
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