package oopsdg;

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

    private Parent root;
    private Scene scene;
    private Stage stage;

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
    private Button suButton;

    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] username = Helper.tempLoginCreds().split(",");
        String text = "Welcome, Admin " + Helper.getAdminName(username[0]);
        welcomeMessage.setText(text);
    }

    public void editData(ActionEvent e) throws IOException {
        if (editButton.isSelected()) {
            addDataButton.setDisable(false);
            minusDataButton.setDisable(false);
            editDataButton.setDisable(false);
            
            Helper.fadeAndTranslate(addDataButton, 500, 500, 0.0, -70, 0.0, 1.0);
            Helper.fadeAndTranslate(minusDataButton, 500, 500, 0.0, 125, 0.0, 1.0);
            Helper.fadeAndTranslate(editDataButton, 500, 500, 0.0, -135, 0.0, 1.0);

        } else {
            addDataButton.setDisable(true);
            minusDataButton.setDisable(true);
            
            Helper.translateAndFade(addDataButton, 500, 500, 0.0, 70, 1.0, 0.0);
            Helper.translateAndFade(minusDataButton, 500, 500, 0.0, -125, 1.0, 0.0);
            Helper.translateAndFade(editDataButton, 500, 500, 0.0, 135, 1.0, 0.0);
        }
    }

    public void addData(ActionEvent e) throws IOException {
        System.out.println("add Data");
    }

    public void minusData(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("minusData.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void modifyData(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("editData.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToListByCompany(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("company.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToListByMonth(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("month.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBadUse(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("baduse.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToList(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
