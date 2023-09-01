
package com.mycompany.supermarket;

import javax.swing.JOptionPane;


public class Mainmenu {
       public static void mainmenu()
    {
        while  (true)
        {
String menu="Super market menu \n"+
"1. Add a new item to store \n"+
"2. Add a new customer to store \n"+
"3. Add an item to customer shopping cart \n"+
"4. Remove an item from customer shopping cart \n"+
"5. View the items in customer shopping cart \n"+
"6. End shopping an go to checkout \n"+
"7. Empty customer shopping cart\n"+
"8. Exit the program";

 String num =JOptionPane.showInputDialog(null,menu);

 int ch=Integer.parseInt(num);
 switch(ch){
case 1: 
item.ADDitem();
break;
case 2: 
    Addcustomer.addcustomer();
break;
case 3: 
Addanitemtocustomercart.Addanitemtocustomershoppingcart();
break;
case 4: 
    String id=JOptionPane.showInputDialog(null, " Enter customer number");
    int ID=Integer.parseInt(id);
removeItem.Removeitem(ID);

break;
case 5: 
     String idc=JOptionPane.showInputDialog(null, " Enter customer number");
    int I=Integer.parseInt(idc);
viewcustomershoppingcart.Display(I);    
break;
case 6: 
     String Idc=JOptionPane.showInputDialog(null, " Enter customer number");
    int i=Integer.parseInt(Idc);
Deletecustomer.delete(i);
break;
case 7: 
     String Idc1=JOptionPane.showInputDialog(null, " Enter customer number");
    int i1=Integer.parseInt(Idc1);
    
    Emptycustomercart.emptycart(i1);
    deletepurchases.Empty(i1);
    
break;
case 8: 
System.exit(0);

    break;
 }
 }
    }

  


}
