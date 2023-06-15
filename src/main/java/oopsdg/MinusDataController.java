package oopsdg;

/**
 * @author Junaadh
 */

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

public class MinusDataController implements Initializable {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
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
    private Button submitButton;

    @FXML
    private Text warningMessage;

    // Method which runs by default when the scene loads, part of the Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Company> companies = FXCollections.observableArrayList(Initializer.cList);

        // Set the column names in the TableView TableColumn element using CellValueFactory
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        usageColumn.setCellValueFactory(new PropertyValueFactory<>("usage"));

        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
                
        waterColumn.setCellValueFactory(new PropertyValueFactory<>("water"));

        list.getItems().addAll(companies);
        
    }

    // method to delete data mapped to a button
    public void submit() {
        try {
            int ID = Integer.parseInt(name.getText());
            if (Admin.guiDeleteCompany(ID) == 0) {
                list.getItems().clear();
                name.setPromptText("Enter Company ID");
                ObservableList<Company> companies = FXCollections.observableArrayList(Initializer.cList); 
                list.getItems().addAll(companies);
                Helper.showFloatingToast(stage, "Company with ID:" + ID + " successfully deleted", null);
                           
            }
            
        } catch (NumberFormatException e) {                                 // handles number format exception
            warningMessage.setText("*input a number");                // if anything other than number is inserted
        }                                                                   // sets warning message
    }

    //Method which listens to an Event/ click on the button to which its linked to and changes scene
    public void switchBack(ActionEvent e) throws IOException {
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
