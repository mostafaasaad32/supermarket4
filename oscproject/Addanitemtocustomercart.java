package com.mycompany.supermarket;

import static com.mycompany.supermarket.Addcustomer.customer;
import static com.mycompany.supermarket.item.items;
import static com.mycompany.supermarket.item.size;
import static com.mycompany.supermarket.Purchases.size2;
import static com.mycompany.supermarket.item.Searchitemname;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static com.mycompany.supermarket.Purchases.purchases;

public class Addanitemtocustomercart {

    // Method to add an item to a customer's cart
    public static int Additemcart(int index) {
        String un = "  ";
        do {
            String data = "The customer num: " + customer[index].getId() + " ,The customer name :" + customer[index].getName() + "\n Items in the store ";
            ArrayList<String> list = new ArrayList<>();

            // Display available items in the store
            for (int i = 0; i < size; i++) {
                list.add(items[i].getName());
                data += "   " + (i + 1) + "-     " + items[i].getId() + "      " + items[i].getName() + "-      [" + items[i].getQuantity() + "]\n";
            }

            data += "...........\n" + "0. Return to main menu \n" + " Enter item choice : ";
            String num = JOptionPane.showInputDialog(null, data);
            int numchoose = Integer.parseInt(num);

            if (numchoose == 0) {
                return 0;
            } else {
                String choose = " ";
                String itemname = " ";
                int Quan = 0;
                int iditem = -1;
                for (int i = 0; i < size; i++) {
                    if (list.get(numchoose - 1).equals(items[i].getName())) {
                        Quan = items[i].getQuantity();
                        iditem = items[i].getId();
                        itemname = items[i].getName();

                        choose = "The item is [" + iditem + "      " + itemname + "                      [" + Quan + "] ]\nEnter required quantity: ";
                        break;
                    }
                }

                String ch = JOptionPane.showInputDialog(null, choose);
                int quan = Integer.parseInt(ch);

                if (Quan >= quan && Quan != 0 && quan > 0) {
                    // Add the item to the customer's purchases
                    purchases[size2] = new Purchases(customer[index].getId(), iditem, quan, itemname);
                    int total = Quan - quan;
                    int indexnameitem = Searchitemname(itemname);
                    items[indexnameitem].setQuantity(total);
                    size2++;
                    JOptionPane.showMessageDialog(null, " The product has been added to the shopping cart");
                    return -1;
                } else {
                    String yesorno = JOptionPane.showInputDialog(null, " Sorry, the requested quantity is not available, the available quantity is [" + Quan + "], please try again");
                }
                String re = JOptionPane.showInputDialog(null, "Do you want to add another item(y/n)?");
                un = re.toUpperCase();
            }
        } while (un.equals("Y"));
        return -1;
    }

    // Method to add an item to a customer's shopping cart
    public static void Addanitemtocustomershoppingcart() {
        String nu = "  ";
        do {
            String IDCustomer = JOptionPane.showInputDialog(null, "Enter the customer number ");
            int id = Integer.parseInt(IDCustomer);
            int index = Addcustomer.Searchcustomer(id);

            if (index != -1) {
                int no = Additemcart(index);
                if (no == 0) {
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "The customer does not exist");
            }

            String re = JOptionPane.showInputDialog(null, "Do you want to try again(y/n)?");
            nu = re.toUpperCase();
        } while (nu.equals("Y"));
    }
}
