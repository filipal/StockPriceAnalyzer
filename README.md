# StockPriceAnalyzer
Stock Price Analyzer (average, maximum, cumulative sum stock price, occurrence count of a specific price)

# Stock Price Analyzer Documentation
# Overview
The "Stock Price Analyzer" is a JavaFX application designed to allow users to enter stock prices for specific dates, analyze data through various metrics such as average price, maximum price, occurrences of a specific price, and calculate the cumulative sum of entered prices. This document provides a comprehensive guide on how to use the application, including explanations of the code and user instructions.

# Getting Started
To start using the "Stock Price Analyzer", ensure that you have a compatible JavaFX runtime environment installed on your computer. Launch the application by executing the `Main` class. Upon launching, you will be greeted by the main screen of the application.

# Main Screen
The main screen presents four options:
Enter Stock Prices
Analyze Data
View Stock Prices
Exit

# Enter Stock Prices
Clicking on "Enter Stock Prices" opens a dialog where you can input stock prices for specific dates.
Input Fields:
Stock Price: Enter the price of the stock. For multiple entries separated by semicolons (e.g., `100.5; 200.75; 150.25`).
Date: Select the date for the entered price.

# Error Messages:
Please enter a valid price.: Displayed if the entered price is not a number.
Please select a date.: Displayed if no date is selected.
You can only enter a current or past date.: Displayed if the selected date is in the future.
All prices must be positive.: Displayed if one of the entered prices is negative.
Please enter correct prices separated by semicolons.: Displayed if the format for multiple entries is incorrect.

# Analyze Data
Clicking on "Analyze Data" opens a dialog with options to calculate average price, maximum price, occurrences of a specific price, and cumulative sum.
Functions:
Calculate Average Price: Computes the average of all entered stock prices.
Find Maximum Price: Identifies the highest stock price entered.
Count Occurrences: Requires user to enter a target price and calculates how many times this price occurs.
Compute Cumulative Sum: Calculates the cumulative sum of all entered stock prices and displays it in a scrollable area.
  
# Error Messages for Count Occurrences:
- Please enter a valid price.: Displayed if the entered target price is not a number.

# View Stock Prices
Clicking on "View Stock Prices" displays a table listing all entered stock prices along with their corresponding dates.

# Exit
Clicking on "Exit" closes the application.

# Code Explanation
The application is structured around MVC (Model-View-Controller) architecture, separating the application logic from the user interface. Key classes include:
Main: The entry point of the application, sets up the primary stage.
MainController: Manages interactions on the main screen.
StockPricesDialogController: Handles the logic for entering stock prices.
DataAnalysisDialogController: Contains methods for data analysis functions.
StockPrice: A model class representing a stock price on a specific date.

# Conclusion
The "Stock Price Analyzer" offers a user-friendly interface for entering and analyzing stock price data. It is designed to provide quick insights into stock price trends and statistics. For any issues or further assistance, refer to this documentation or contact the support team.
