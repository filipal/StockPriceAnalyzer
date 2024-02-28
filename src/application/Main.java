package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class of the application.
 * Initializes and shows the main application window.
 */
public class Main extends Application {

    /**
     * Starts the primary stage for this application, onto which
     * the application scene can be set.
     * 
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            // Loading the FXML file for the main screen
            Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            
            // Setting the window title
            primaryStage.setTitle("Stock Price Analyzer");
            
            // Creating the scene with the root element from the FXML file
            Scene scene = new Scene(root);
            
            // Setting the scene on the primary stage
            primaryStage.setScene(scene);
            
            // Displaying the primary stage
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an error
        }
    }

    /**
     * The main entry point for all JavaFX applications.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Launching the JavaFX application
        launch(args);
    }
}
