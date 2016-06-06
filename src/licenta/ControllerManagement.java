/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aslif
 */
public class ControllerManagement implements Initializable {

     /** Holder of a switchable vista. */
    @FXML
    private AnchorPane AnchorPaneHolder;
    
    @FXML
    private TableView TabelaAngajati;
    private TableColumn details = new TableColumn("Details");
   // details.setCellValueFactory(new PropertyValueFactory("details"));

    public void setVista(Node node) {
        AnchorPaneHolder.getChildren().setAll(node);
    }
    
    @FXML
    void handlePersoanepressed(ActionEvent event) {
        ManagamenetNavigator.loadVista(ManagamenetNavigator.PERSOANE);
    }
    
    @FXML
    void handleCursepressed(ActionEvent event) {
        ManagamenetNavigator.loadVista(ManagamenetNavigator.CURSE);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
