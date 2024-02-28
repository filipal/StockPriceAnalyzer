package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controller for the main application window.
 * Handles navigation between different parts of the application.
 */
public class MainController {

    @FXML
    private Button stockPricesButton; // Button to open the "Enter Stock Prices" dialog

    @FXML
    private Button dataAnalysisButton; // Button to open the "Analyze Data" dialog

    @FXML
    private Button viewStockPricesButton; // Button to open the "View Stock Prices" dialog

    @FXML
    private Button exitButton; // Button to exit the application

    /**
     * Handles clicks on the "Enter Stock Prices" button.
     * Opens the StockPricesDialog.
     */
    @FXML
    private void openStockPricesDialog(ActionEvent event) {
        openDialog("StockPricesDialog.fxml", "Enter Stock Prices");
    }

    /**
     * Handles clicks on the "Analyze Data" button.
     * Opens the DataAnalysisDialog.
     */
    @FXML
    private void openDataAnalysisDialog(ActionEvent event) {
        openDialog("DataAnalysisDialog.fxml", "Analyze Data");
    }

    /**
     * Handles clicks on the "View Stock Prices" button.
     * Opens the ViewStockPricesDialog.
     */
    @FXML
    private void openViewStockPricesDialog(ActionEvent event) {
        openDialog("ViewStockPricesDialog.fxml", "View Stock Prices");
    }

    /**
     * Handles clicks on the "Exit" button.
     * Exits the application.
     */
    @FXML
    private void exitApplication(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Helper method to open a dialog window based on the FXML file and title.
     * @param fxmlFile The FXML file to load.
     * @param title The title for the dialog window.
     */
    private void openDialog(String fxmlFile, String title) {
        try {
            // Load the FXML file and create a new stage for the popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent parent = fxmlLoader.load();

            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Make the dialog modal
            stage.setScene(scene);
            stage.setTitle(title);
            stage.showAndWait(); // Display the dialog and wait until it is closed
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an error
        }
    }
}
