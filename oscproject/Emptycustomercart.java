package com.mycompany.supermarket;

import static com.mycompany.supermarket.Addcustomer.Searchcustomer;
import static com.mycompany.supermarket.Addcustomer.cart;
import static com.mycompany.supermarket.Purchases.purchases;
import static com.mycompany.supermarket.Purchases.size2;
import static com.mycompany.supermarket.item.Searchitemname;
import static com.mycompany.supermarket.item.items;
import javax.swing.JOptionPane;

public class Emptycustomercart {
    // Method to empty a customer's shopping cart
    public static void emptycart(int Id) {
        if (Searchcustomer(Id) != -1) { // Check if the customer exists
            for (int i = 0; i < size2; i++) {
                if (purchases[i].getIdcustomer() == Id) { // Check if the purchase is made by the specified customer
                    int quan3 = purchases[i].getQuantitiy(); // Get the quantity of the purchased item
                    int index = Searchitemname(purchases[i].getitemName()); // Find the index of the purchased item
                    int total = quan3 + items[index].getQuantity(); // Calculate the new quantity of the item in stock
                    items[index].setQuantity(total); // Update the item's quantity in stock
                }
            }
            for (int i = 0; i < 10; i++) {
                if (cart[i].equals(Id)) { // Find the customer in the shopping cart
                    cart[i] = "Empty"; // Remove the customer from the shopping cart
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "The shopping cart has been emptied"); // Show a message confirming cart emptying
        } else {
            JOptionPane.showMessageDialog(null, "The customer number is not registered"); // Show a message if the customer is not found
        }
    }
}
