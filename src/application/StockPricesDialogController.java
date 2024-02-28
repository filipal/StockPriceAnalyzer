package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StockPricesDialogController {

    // A static list to hold the stock prices entered by the user
    public static List<StockPrice> stockPrices = new ArrayList<>();

    @FXML
    private DatePicker datePickerField; // DatePicker for selecting the date

    @FXML
    private TextField priceTextField; // TextField for entering the stock price

    @FXML
    private Label errorMessageLabel; // Label to display error messages

    // Method to handle the action of picking a date
    @FXML
    private void handleDatePick(ActionEvent event) {
        LocalDate selectedDate = datePickerField.getValue(); // Getting the selected date
        System.out.println("Selected date: " + selectedDate);
        // No immediate linking of date with price here
    }

    // Method to handle the price input
    @FXML
    private void handlePriceInput(ActionEvent event) {
        try {
            Double enteredPrice = Double.parseDouble(priceTextField.getText()); // Attempting to parse the entered price
            System.out.println("Entered price: " + enteredPrice);
            // Again, no linking here, just capturing the input
        } catch (NumberFormatException e) {
            errorMessageLabel.setText("Please enter a valid price.");
            // Resetting if the input is not valid
        }
    }

    // Method for adding the stock price
    @FXML
    private void addPrice(ActionEvent event) {
        LocalDate date = datePickerField.getValue(); // Getting the selected date

        // Checking if the date is selected
        if (date == null) {
            errorMessageLabel.setText("Please select a date.");
            return;
        }

        // Checking if the date is today or in the past
        if (date.isAfter(LocalDate.now())) {
            errorMessageLabel.setText("You can only enter a current or past date.");
            return;
        }

        // Splitting the prices entered in case of multiple entries separated by semicolons
        String[] prices = priceTextField.getText().split(";");
        boolean allValid = true; // Flag to track if all prices are valid

        for (String priceStr : prices) {
            try {
                double price = Double.parseDouble(priceStr.trim()); // Trimming to remove any leading or trailing spaces

                if (price < 0) {
                    errorMessageLabel.setText("All prices must be positive.");
                    allValid = false;
                    break;
                }

                // If everything is ok, store the data
                stockPrices.add(new StockPrice(date, price));

            } catch (NumberFormatException e) {
                errorMessageLabel.setText("Please enter correct prices separated by semicolons.");
                allValid = false;
                break;
            }
        }

        if (allValid) {
            errorMessageLabel.setText("Prices successfully entered.");
            priceTextField.setText(""); // Clear the price input field after successful addition
            datePickerField.setValue(null); // Clear the date picker field after successful addition
        }
    }
}
