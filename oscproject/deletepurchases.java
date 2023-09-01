package com.mycompany.supermarket;

import static com.mycompany.supermarket.Purchases.purchases;
import static com.mycompany.supermarket.Purchases.size2;

public class deletepurchases {
    
    // Method to remove all purchases associated with a specific customer ID
    public static void Empty(int id) {
        for (int i = 0; i < size2; i++) {
            if (id == purchases[i].getIdcustomer()) { // Check if the purchase is associated with the specified customer ID
                if (size2 - 1 == i) {
                    size2--; // If the purchase is the last element in the array, decrement the array size
                } else {
                    purchases[i] = purchases[i + 1]; // Move the subsequent purchases to fill the gap
                }
            }
        }
    }
}
