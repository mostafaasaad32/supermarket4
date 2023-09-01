package com.mycompany.supermarket;

import static com.mycompany.supermarket.Addcustomer.Searchcustomer;

import static com.mycompany.supermarket.item.items;

import static com.mycompany.supermarket.Purchases.size2;
import static com.mycompany.supermarket.item.Searchitemname;

import javax.swing.JOptionPane;
import static com.mycompany.supermarket.Purchases.purchases;

public class viewcustomershoppingcart {
    // Display the shopping cart of a customer identified by their ID
    public static void Display(int Id) {
        if (Searchcustomer(Id) != -1) { // Check if the customer exists
            int Totalprice = 0;
            String data = "Item  num    Item name     Quantity      Unit price     Price";
            
            // Loop through the purchases
            for (int i = 0; i < size2; i++) {
                if (Id == purchases[i].getIdcustomer()) { // Check if the purchase is made by the specified customer
                    
                    int qu = purchases[i].getQuantitiy();
                    int index = Searchitemname(purchases[i].getitemName()); // Find the index of the purchased item
                    int total = qu * items[index].getPrice(); // Calculate the total price for this item
                    Totalprice += total; // Add the total price to the overall total
                    data += "\n      " + purchases[i].getIditem() + "                " +
                            purchases[i].getitemName() + "               " +
                            qu + "      " + items[index].getPrice() + "                  " +
                            total;
                }
            }
            
            data += "\n                                              Totalprice" + Totalprice; // Add the total price to the message
            
            JOptionPane.showMessageDialog(null, data); // Display the shopping cart
        } else { // If the customer is not found
            JOptionPane.showMessageDialog(null, "The customer number is not registered");
        }
    }
}
