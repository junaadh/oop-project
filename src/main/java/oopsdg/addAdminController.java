package oopsdg;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addAdminController {
    
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
    private Text confirmText;

    @FXML
    private CheckBox confirm;

    @FXML
    private Text warningMessage;

    @FXML
    private Button backButton;

    public void addAdmin(ActionEvent e) throws IOException {
        Admin.guiAddAdmin(firstname.getText(), lastname.getText(), username.getText(), password.getText());
        Helper.showFloatingToast(stage, firstname.getText() + " " + lastname.getText() + "has been added", null);
    }

    public void switchBack(ActionEvent e) throws IOException {
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
