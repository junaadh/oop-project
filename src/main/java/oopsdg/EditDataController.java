package oopsdg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditDataController implements Initializable {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private TableView<Company> list;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Company, Integer> idColumn;

    @FXML
    private TableColumn<Company, String> nameColumn;

    @FXML
    private TableColumn<Company, String> usageColumn;

    @FXML
    private TableColumn<Company, String> monthColumn;

    @FXML
    private TableColumn<Company, String> waterColumn;

    @FXML
    private TextField name;

    @FXML
    private TextField id;

    @FXML
    private TextField usage;

    @FXML
    private TextField month;

    @FXML
    private TextField water;

    @FXML
    private Button modify;

    @FXML
    private Text warningMessage;

    ObservableList<Company> companies = FXCollections.observableArrayList(Initializer.cList);

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        usageColumn.setCellValueFactory(new PropertyValueFactory<>("usage"));

        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));

        waterColumn.setCellValueFactory(new PropertyValueFactory<>("water"));

        list.getItems().addAll(companies);

    }

    public void editData() {
        try {
            int ID = Integer.parseInt(id.getText());
            Admin.guiUpdateCompany(ID, name.getText(), usage.getText(), month.getText(), water.getText());
            Helper.showFloatingToast(stage, name.getText() + " with ID:" + ID + " has been updated successfully", null);
            list.getItems().clear();
            list.getItems().addAll(companies);
            
        } catch (NumberFormatException e) {
            warningMessage.setText("*ID can only be a number");
        }
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
