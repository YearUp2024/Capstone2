# Sandwich Ordering Application

Welcome to the Sandwich Ordering Application! 
This program is designed to streamline the process of 
creating and managing customizable sandwich orders for a 
sandwich business. The application allows customers to 
select from a variety of sandwich sizes, breads, toppings, 
and additional options like drinks and chips. With user-friendly 
screens and prompts, the program ensures a smooth experience 
for both customers and operators.

## Features
- **Sandwich Customization**:
    - Choose sandwich size: 4", 8", or 12".
    - Select bread type: white, wheat, rye, or wrap.
    - Add regular and premium toppings, with options for extra toppings.
    - Option to toast the sandwich.
- **Order Add-ons**:
    - Add drinks (Small, Medium, Large) with customizable flavors.
    - Add chips.
- **Order Management**:
    - Review and confirm orders with detailed breakdowns.
    - Save each order to a receipt file named by the date and time of purchase (e.g., `20231031-153000.txt`).
    - Option to cancel the order at any stage.
- **Pricing**:
    - Automatically calculates the total cost of sandwiches, drinks, and chips, considering extra toppings and sandwich size.

## Screens
1. **Home Screen**:
    - `1) New Order`: Start a new order.
    - `2) Exit`: Exit the application.
2. **Order Screen**:
    - `1) Add Sandwich`
    - `2) Add Drink`
    - `3) Add Chips`
    - `4) Checkout`
    - `5) Cancel Order`
3. **Add Sandwich**:
    - Walk through the process of selecting size, bread type, toppings, sauces, and whether the sandwich should be toasted.
4. **Checkout**:
    - Displays order details and calculates the total cost.
    - Confirms the order or allows cancellation.

## Technologies Used
- **Java**: The main programming language for the application.
- **Object-Oriented Design**:
    - Inheritance and Polymorphism to manage menu items and sandwich customization.
- **File Management**:
    - Saves order details in receipts with unique timestamps.
- **Console-Based Interface**:
    - Provides a simple yet efficient user interface.

## Getting Started
1. Clone this repository:
   ```bash
   git clone <repository-url>
   cd SandwichOrderingApp
