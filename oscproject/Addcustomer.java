package com.mycompany.supermarket;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Addcustomer extends data {
    // Arrays to store cart information and customer objects
    public static String cart[] = new String[10];
    public static Customer customer[] = new Customer[100];
    public static int size1 = 0;

    // Initialize the cart with "Empty" values
    public static void cart() {
        for (int i = 0; i < cart.length; i++) {
            cart[i] = "Empty";
        }
    }

    // Search for a customer by ID
    public static int Searchcustomer(int ID) {
        for (int i = 0; i < size1; i++) {
            if (customer[i].getId() == ID) {
                return i;
            }
        }
        return -1;
    }

    // Constructor for Addcustomer class
    public Addcustomer(String name, int id) {
        super(name, id);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    // Method to add a new customer
    public static void addcustomer() {
        cart();

        String nu = " ";
        do {
            JTextField name = new JTextField();
            JTextField id = new JTextField();
            Object message[] = { "Enter customer name: ", name, "Enter customer number: ", id };

            int yesorno = JOptionPane.showConfirmDialog(null, message);
            if (yesorno == JOptionPane.YES_OPTION) {
                int ID = Integer.parseInt(id.getText());

                if (Searchcustomer(ID) != -1) {
                    JOptionPane.showMessageDialog(null, "The customer number is already registered");
                    return;
                }
                boolean flag = true;
                int numberCart = -1;
                do {
                    String nocart = "Numcart                    Status\n";
                    for (int i = 0; i < cart.length; i++) {
                        if (i == cart.length - 1) {
                            nocart += (i + 1) + "                                " + cart[i];
                        } else
                            nocart += (i + 1) + "                                  " + cart[i] + "\n";
                    }
                    String numbercart = JOptionPane.showInputDialog(null, nocart);
                    numberCart = Integer.parseInt(numbercart);
                    if (cart[numberCart - 1].equals("Empty")) {
                        cart[numberCart - 1] = ID + "";
                        flag = false;
                    }
                } while (flag);

                customer[size1] = new Customer(numberCart - 1, name.getText(), ID);
                size1++;
                JOptionPane.showMessageDialog(null, "The customer has been added");
            }
            String re = JOptionPane.showInputDialog(null, "Do you want to add another customer(y/n)?");
            nu = re.toUpperCase();
        } while (nu.equals("Y"));
    }
}
