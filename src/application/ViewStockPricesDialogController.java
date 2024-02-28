package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import java.time.LocalDate;

public class ViewStockPricesDialogController {

    @FXML
    private TableView<StockPrice> stockPricesTable; // TableView for displaying stock prices

    @FXML
    private TableColumn<StockPrice, LocalDate> dateColumn; // TableColumn for the date of the stock price

    @FXML
    private TableColumn<StockPrice, Number> priceColumn; // TableColumn for the price of the stock

    @FXML
    public void initialize() {
        // Configuring the columns
        // The 'date' and 'price' here refer to the property names in the StockPrice class
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date")); // Linking the date column to the 'date' property of StockPrice
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); // Linking the price column to the 'price' property of StockPrice

        // Assuming that we have a list named stockPrices filled in StockPricesDialogController
        // and that this list is publicly accessible (e.g., as a public static variable)
        // This line fills the TableView with the data from the stockPrices list
        stockPricesTable.setItems(FXCollections.observableArrayList(StockPricesDialogController.stockPrices));
    }
}
