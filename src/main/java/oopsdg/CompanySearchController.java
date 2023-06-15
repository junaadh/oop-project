package oopsdg;

/**
 * @author Junaadh
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CompanySearchController implements Initializable {

    // Initialize root, scene and node to be used to change between GUI scenes
    private Parent root;
    private Scene scene;
    private Stage stage;

    //Inject FXML components to be able to use them in methods
    @FXML
    private TableView<Company> list;

    @FXML
    private ComboBox<String> selectCombo;

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
    
    // Initialize company cList
    private Company company[] = Initializer.cList;

    // Method which runs by default when the scene loads, part of the Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // creates a string array containing only company names to be used in comboBox
        String[] name = new String[company.length];
        for (int i = 0; i < company.length; i++ ) {
            name[i] = ((Company) company[i]).getName();
        }

        // removes any duplicate compnay names by creating a hashset as hashsets entries can only be unique
        HashSet<String> set = new HashSet<>();
        for (String str : name) {
            set.add(str);
        }
        List<String> newSet = new ArrayList<>(set);
        String nameList[] = newSet.toArray(new String[0]);
        
        selectCombo.getItems().addAll(nameList);
        
        // Set the column names in the TableView TableColumn element using CellValueFactory
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        usageColumn.setCellValueFactory(new PropertyValueFactory<>("usage"));
        
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));

        waterColumn.setCellValueFactory(new PropertyValueFactory<>("water"));
        
        //method which maps an action onto combo box
        selectCombo.setOnAction(event -> {
            String selectedValue = selectCombo.getValue();                                              // get selected value in combobox
            
            Company[] filteredCompanies = Helper.filterArrayByColumnName(company, selectedValue);
            list.getItems().clear();

            ObservableList<Company> filtered = FXCollections.observableArrayList(filteredCompanies);
            list.getItems().addAll(filtered);
        });
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