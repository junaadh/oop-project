package oopsdg;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

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

    private Parent root;
    private Scene scene;
    private Stage stage;

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
    
    private Company company[] = Initializer.cList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] name = new String[company.length];
        for (int i = 0; i < company.length; i++ ) {
            name[i] = ((Company) company[i]).getName();
        }

        selectCombo.getItems().addAll(name);

        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        usageColumn.setCellValueFactory(new PropertyValueFactory<>("usage"));
        
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));

        waterColumn.setCellValueFactory(new PropertyValueFactory<>("water"));
        
        selectCombo.setOnAction(event -> {
            String selectedValue = selectCombo.getValue();
            
            Company[] filteredCompanies = Helper.filterArrayByColumnName(company, selectedValue);
            list.getItems().clear();
            filteredCompanies = removeDuplicates(filteredCompanies);

            ObservableList<Company> filtered = FXCollections.observableArrayList(filteredCompanies);
            list.getItems().addAll(filtered);
        });
    }


    private Company[] removeDuplicates(Company[] filteredCompanies) {
            Set<Company> companySet = new HashSet<>(Arrays.asList(filteredCompanies));
            return companySet.toArray(new Company[0]);    
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