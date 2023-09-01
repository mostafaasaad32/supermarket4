package com.mycompany.supermarket;

import javax.swing.JOptionPane;
import static com.mycompany.supermarket.Addcustomer.Searchcustomer;
import static com.mycompany.supermarket.Addcustomer.customer;
import static com.mycompany.supermarket.Addcustomer.size1;

public class Deletecustomer {
    
    // Method to delete a customer by their ID
    public static void delete(int Idc) {
        
        if (Searchcustomer(Idc) != -1) { // Check if the customer exists
            viewcustomershoppingcart.Display(Idc); // Display the customer's shopping cart
            deletepurchases.Empty(Idc); // Delete all purchases associated with the customer
            
            for (int i = 0; i < size1; i++) {
                if (Idc == customer[i].getId()) { // Find the customer to delete
                    if (size1 - 1 == i) {
                        size1--; // If the customer is the last element in the array, decrement the array size
                        JOptionPane.showMessageDialog(null, "Delete success"); // Show a message confirming deletion
                        break;
                    } else {
                        customer[i] = customer[i + 1]; // Move the subsequent customers to fill the gap
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "The customer number is not registered"); // Show a message if the customer is not found
        }
    }
}
