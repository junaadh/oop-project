package oopsdg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MonthSearchController implements Initializable {

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
    private DatePicker monthSelector;

    @FXML
    private Button submitButton;

    private Company company[] = Initializer.cList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        monthSelector.setShowWeekNumbers(false);
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        usageColumn.setCellValueFactory(new PropertyValueFactory<>("usage"));
        
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        
        submitButton.setOnAction(event -> {
            // Get the selected month
            
            LocalDate selectedDate = monthSelector.getValue();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
            String selectedMonth = formatter.format(selectedDate);

            Company[] filteredlist = Helper.filteredArrayByMonth(company, selectedMonth);
            list.getItems().clear();
            ObservableList<Company> companies = FXCollections.observableArrayList(filteredlist);
            list.getItems().addAll(companies);
        });

        
        
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
