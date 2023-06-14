package oopsdg;

/**
 * @author Junaadh
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminController implements Initializable {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
    @FXML
    private Text welcomeMessage;

    @FXML
    private Button listButton;

    @FXML
    private Button companyButton;

    @FXML
    private Button monthButton;

    @FXML
    private Button baduseButton;

    @FXML
    private ToggleButton editButton;

    @FXML
    private Button addDataButton;

    @FXML
    private Button minusDataButton;

    @FXML
    private Button editDataButton;

    @FXML
    private ToggleButton suButton;

    @FXML
    private Button addAdminButton;

    @FXML
    private Button delUserButton;

    @FXML
    private Button logoutButton;

    // Method which runs by default when the scene loads, part of the Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] username = Helper.tempLoginCreds().split(",");
        String text = "Welcome, Admin " + Helper.getAdminName(username[0]);
        welcomeMessage.setText(text);
    }

    // method which upon keypress onto editButton runs
    public void editData(ActionEvent e) throws IOException {
        // if loop which does the translation and fade transitions on the two buttons hidden and enables them which causes them to appear
        if (editButton.isSelected()) { 
            addDataButton.setDisable(false);
            minusDataButton.setDisable(false);
            editDataButton.setDisable(false);
            
            Helper.fadeAndTranslate(addDataButton, 500, 500, 0.0, -70, 0.0, 1.0);
            Helper.fadeAndTranslate(minusDataButton, 500, 500, 0.0, 125, 0.0, 1.0);
            Helper.fadeAndTranslate(editDataButton, 500, 500, 0.0, -135, 0.0, 1.0);

        // if loop which does the translation and fade transitions on the two buttons hidden and enables them which causes them to hide again
        } else {
            addDataButton.setDisable(true);
            minusDataButton.setDisable(true);
            
            Helper.translateAndFade(addDataButton, 500, 500, 0.0, 70, 1.0, 0.0);
            Helper.translateAndFade(minusDataButton, 500, 500, 0.0, -125, 1.0, 0.0);
            Helper.translateAndFade(editDataButton, 500, 500, 0.0, 135, 1.0, 0.0);
        }
    }

    // method which upon keypress onto suButton runs
    public void suMode(ActionEvent e) throws IOException {
        // if loop which does the translation and fade transitions on the two buttons hidden and enables them which causes them to appear
        if (suButton.isSelected()) {
            addAdminButton.setDisable(false);
            delUserButton.setDisable(false);
            
            Helper.fadeAndTranslate(addAdminButton, 500, 500, 0.0, -70, 0.0, 1.0);
            Helper.fadeAndTranslate(delUserButton, 500, 500, 0.0, 125, 0.0, 1.0);

        // if loop which does the translation and fade transitions on the two buttons hidden and enables them which causes them to hide again
        } else {
            addAdminButton.setDisable(true);
            delUserButton.setDisable(true);
            
            Helper.translateAndFade(addAdminButton, 500, 500, 0.0, 70, 1.0, 0.0);
            Helper.translateAndFade(delUserButton, 500, 500, 0.0, -125, 1.0, 0.0);
        }
    }

    // method which changes scene to admin add scene mapped to a button
    public void addAdmin(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addAdmin.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which changes scene to user delete scene mapped to a button
    public void deleteUser(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("delUser.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which changes scene to data addition scene mapped to a button
    public void addData(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addData.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which changes scene to data deletion scene mapped to a button
    public void minusData(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("minusData.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which changes scene to data modification page mapped to a button
    public void modifyData(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("editData.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which displays data sorted by user desired company as a list mapped to button
    public void switchToListByCompany(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("company.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which displays data sorted by user desired month mapped to a button
    public void switchToListByMonth(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("month.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which displays data exceeding the set norm as list mapped to a button
    public void switchToBadUse(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("baduse.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which displays data as a list mapped to a button
    public void switchToList(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method which ends logged in session mapped to a button
    public void logout(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
