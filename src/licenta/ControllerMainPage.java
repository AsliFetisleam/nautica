/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author aslif
 */
public class ControllerMainPage implements Initializable {
    
    @FXML
    public void handleManagementAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(ManagamenetNavigator.MAIN));
        ControllerManagement mainController = loader.getController();
        ManagamenetNavigator.setMainController(mainController);      
        Stage stage = new Stage();
        stage.setScene(new Scene(mainPane ) );
        stage.show();
        
    }
    
    @FXML
    public void handleMapsAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Maps.fxml"));      
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    public void handleRepsAction(ActionEvent event) {
        System.out.println("You clicked Reports!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
