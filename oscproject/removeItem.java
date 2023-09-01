package com.mycompany.supermarket;

import static com.mycompany.supermarket.Addcustomer.Searchcustomer;
import static com.mycompany.supermarket.Addcustomer.customer;
import static com.mycompany.supermarket.item.Searchitemname;
import static com.mycompany.supermarket.item.items;
import static com.mycompany.supermarket.Purchases.size2;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static com.mycompany.supermarket.Purchases.purchases;

public class removeItem {

    // This method removes an item from a customer's shopping cart
    public static void Removeitem(int id) {
        // Search for the customer with the given ID
        int searchid = Searchcustomer(id);
        
        // If the customer is found
        if (searchid != -1) {
            // Create lists to store item names and their corresponding purchase indexes
            ArrayList<String> nameitemsale = new ArrayList<>();
            ArrayList<Integer> indexpurchases = new ArrayList<>();
            
            // Prepare customer information
            String data = "The customer num : " + customer[searchid].getId() + ",The customer name : " + customer[searchid].getName() + "\n";
            
            // Loop through purchases to find items associated with the customer
            for (int i = 0; i < size2; i++) {
                if (id == purchases[i].getIdcustomer()) {
                    nameitemsale.add(purchases[i].getitemName());
                    indexpurchases.add(i);
                    data += "   " + (i + 1) + "-     " + purchases[i].getIditem() + "      " + purchases[i].getitemName() + "-      [" + purchases[i].getQuantitiy() + "]\n";
                }
            }
            
            // Prompt the user to choose an action
            String data1 = "What do you want to modify ?   \n " +
                    "R. remove item from the shopping cart \n" +
                    "M. Return to the main menu \n" +
                    "  Enter your choice [ R. Remove , M.  Main menu]: ";
            
            String ch = JOptionPane.showInputDialog(null, data + "\n" + data1);
            
            // If the user chooses to remove an item
            if (ch.toUpperCase().equals("R")) {
                String CH = JOptionPane.showInputDialog(null, data + ".......\n0 Return to the main menu \n Enter your item option number  ");
                int hc = Integer.parseInt(CH);
                if (hc == 0) {
                    return;
                }
                
                // Get the item name to remove and display a message
                String itemname = nameitemsale.get(hc - 1);
                String message = "The item [" + purchases[indexpurchases.get(hc - 1)].getIdcustomer() + "     " + itemname + "       [" + purchases[indexpurchases.get(hc - 1)].getQuantitiy() + "] ] is removed from the shopping cart.";
                
                // Delete the item and update its quantity
                int quan = Deleteitem(itemname, id);
                int indexnameitem = Searchitemname(itemname);
                int total = items[indexnameitem].getQuantity() + quan;
                items[indexnameitem].setQuantity(total);
                
                // Show the removal message to the user
                JOptionPane.showMessageDialog(null, message);
            } 
            // If the user chooses to return to the main menu
            else if (ch.toUpperCase().equals("M")) {
                return;
            }
        } 
        // If the customer is not found
        else {
            JOptionPane.showMessageDialog(null, "The customer number is not registered");
        }
    }

    // This method deletes an item from the purchase history
    private static int Deleteitem(String itemname, int id) {
        for (int i = 0; i < size2; i++) {
            if (purchases[i].getIdcustomer() == id) {
                if (itemname.equals(purchases[i].getitemName())) {
                    if (size2 - 1 == i) {
                        int quan = purchases[i].getQuantitiy();
                        size2--;
                        return quan;
                    } else {
                        int quan = purchases[i].getQuantitiy();
                        purchases[i] = purchases[i + 1];
                        size2--;
                        return quan;
                    }
                }
            }
        }
        return 0; 
    }
}
