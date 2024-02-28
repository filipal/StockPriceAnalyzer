package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import application.StockPricesDialogController;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 * Controller for the Data Analysis dialog.
 * Handles the calculation and display of various stock price statistics.
 */
public class DataAnalysisDialogController {
    
    @FXML
    private Label averagePriceLabel; // Label to display the average stock price

    @FXML
    private Label maximumPriceLabel; // Label to display the maximum stock price

    @FXML
    private Label occurrencesLabel; // Label to display the occurrences of a specific price

    @FXML
    private TextArea cumulativeSumTextArea; // TextArea to display the cumulative sum of stock prices

    @FXML
    private TextField targetPriceField; // TextField for user to enter a target price for occurrences calculation

    /**
     * Calculates and displays the average price of entered stock prices.
     */
    @FXML
    private void calculateAveragePrice(ActionEvent event) {
        double sum = 0;
        for (StockPrice sp : StockPricesDialogController.stockPrices) {
            sum += sp.getPrice();
        }
        double average = sum / StockPricesDialogController.stockPrices.size();
        averagePriceLabel.setText(String.format("Average Price: %.2f", average));
    }

    /**
     * Finds and displays the maximum stock price from entered prices.
     */
    @FXML
    private void findMaximumPrice(ActionEvent event) {
        double max = Double.MIN_VALUE;
        for (StockPrice sp : StockPricesDialogController.stockPrices) {
            if (sp.getPrice() > max) {
                max = sp.getPrice();
            }
        }
        maximumPriceLabel.setText(String.format("Maximum Price: %.2f", max));
    }

    /**
     * Attempts to find the maximum stock price using an ArrayList and prints it to the console.
     */
    private void findMaximumPriceUsingArrayList() {
    	// Check if the stockPrices list is empty. This step is crucial because
        // attempting to find a maximum price in an empty list would not make sense and could lead to errors.
        if (StockPricesDialogController.stockPrices.isEmpty()) {
        	// If the list is empty, inform the user that no stock prices have been entered.
            // This prompts them to enter prices before attempting to find the maximum price again.
            System.out.println("No stock prices have been entered.");
            return; // Exit the method early to prevent further execution since there are no prices to evaluate.
        }
        // Use the Collections.max method to find the maximum price in the list.
        // This method is part of the Java Collections Framework and offers a convenient way
        // to find the largest element in a collection. Here, it's used to determine the highest stock price.
        double maxPrice = Collections.max(StockPricesDialogController.stockPrices.stream().map(StockPrice::getPrice).collect(Collectors.toList()));
        // Print the maximum price found to the console, formatted to show it was obtained
        // using the ArrayList. This provides clear feedback to the user about the operation's result.
        System.out.println("The maximum price using ArrayList: " + maxPrice);
    }

    
    /**
     * Counts and displays the number of occurrences of the specified price.
     */
    @FXML
    private void countOccurrences(ActionEvent event) {
        try {
            double targetPrice = Double.parseDouble(targetPriceField.getText());
            int count = 0;
            for (StockPrice sp : StockPricesDialogController.stockPrices) {
                if (sp.getPrice() == targetPrice) {
                    count++;
                }
            }
            occurrencesLabel.setText("Occurrences: " + count);
        } catch (NumberFormatException e) {
            occurrencesLabel.setText("Please enter a valid price.");
        }
    }

    /**
     * Calculates and displays the cumulative sum of entered stock prices.
     */
    @FXML
    private void computeCumulativeSum(ActionEvent event) {
        ArrayList<Double> cumulativeSums = new ArrayList<>();
        double sum = 0;
        for (StockPrice sp : StockPricesDialogController.stockPrices) {
            sum += sp.getPrice();
            cumulativeSums.add(sum);
        }

        StringBuilder sb = new StringBuilder();
        for (Double cs : cumulativeSums) {
            sb.append(String.format("%.2f\n", cs)); // Add each sum to a new line
        }
        
        cumulativeSumTextArea.setText(sb.toString()); // Set the text in the TextArea
    }
}
