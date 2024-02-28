package application;

import java.time.LocalDate;

/**
 * Represents a stock price on a specific date.
 */
public class StockPrice {
    private LocalDate date; // The date of the stock price
    private double price; // The price of the stock on that date

    /**
     * Constructs a StockPrice object with a date and price.
     * @param date The date of the stock price.
     * @param price The stock price.
     */
    public StockPrice(LocalDate date, double price) {
        this.date = date;
        this.price = price;
    }

    /**
     * Gets the date of the stock price.
     * @return The date of the stock price.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the stock price.
     * @param date The date to set.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the price of the stock.
     * @return The stock price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the stock.
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the stock price.
     * @return A string that represents the stock price.
     */
    @Override
    public String toString() {
        return "Date: " + date + ", Price: " + price;
    }
}
