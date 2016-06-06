package licenta;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import javafx.scene.Node;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class ManagamenetNavigator {

    public static final String MAIN    = "Management.fxml";
    public static final String PERSOANE = "ManagementPersoane.fxml";
    public static final String CURSE = "ManagementCurse.fxml";

    private static ControllerManagement mainController;

    public static void setMainController(ControllerManagement mainController) {
        ManagamenetNavigator.mainController = mainController;
    }

    public static void loadVista(String fxml) {
        try {
            mainController.setVista((Node)FXMLLoader.load(ManagamenetNavigator.class.getResource(fxml ) ));
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }

}