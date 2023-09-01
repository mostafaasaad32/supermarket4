
package com.mycompany.supermarket;


import javax.swing.JOptionPane;
import javax.swing.JTextField;


public   class item extends data {
      public static item items[]=new item[1000];
    public static int size=0;

     private double weight;
    int quantity,price ,prodate,expdate;
    String type;

    public item(int id, int quantity, int price, int prodate, int expdate,String name,String type,double weight) {
       super(name, id);
        this.quantity = quantity;
        this.price = price;
       
        
        this.prodate = prodate;
        this.expdate = expdate;
       
        this.type=type;
           this.weight = weight;
    }
@Override
    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }


    public int getProdate() {
        return prodate;
    }

    public int getExpdate() {
        return expdate;
    }
@Override
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
@Override
    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
 public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
 

    public void setProdate(int prodate) {
        this.prodate = prodate;
    }

    public void setExpdate(int expdate) {
        this.expdate = expdate;
    }
@Override
    public void setName(String name) {
        this.name = name;
    }

 public void setType(String type) {
        this.type = type;
    }
public void Addquan(int quan)
{
 this.quantity+=quan;
    
}
 private static int Searchid(int ID) {
        for (int i = 0; i < size; i++) {
            if (ID==items[i].getId()) {
                return i;
            }
        }
        
        return -1;
    }
 
    public static int Searchitemname(String Name) {
        for (int i = 0; i < size; i++) {
            if (Name.equals(items[i].getName())) {
                return i;
            }
        }
        return -1;
    }
        
public static void ADDitem(){
    
     
    String nu=" ";
   do{
    JTextField id =new JTextField();
     JTextField name =new JTextField();
      JTextField price =new JTextField();
       JTextField quantity =new JTextField();
           JTextField type =new JTextField();
     JTextField prodate =new JTextField();
     JTextField expdate =new JTextField();
    
     
   
   Object [] Message={"Enter item number ",id,"Enter item name ",name,"Enter item quantity ",quantity," Enter the type of item",type,"Enter item price",price};
    Object [] dairy={"Enter the production date ",prodate,"Enter the expire date ",expdate};
     Object [] meat={"Enter the production date ",prodate,"Enter the expire date ",expdate};
      Object [] drinks={"Enter the production date ",prodate,"Enter the expire date ",expdate};
       Object [] fruits={"Enter the production date ",prodate,"Enter the expire date ",expdate};
  int yesorno= JOptionPane.showConfirmDialog(null, Message);
  int result1=1;
    if (type.getText().toUpperCase().equals("D")) {
     result1=   JOptionPane.showConfirmDialog(null, dairy);
    }
    else if (type.getText().toUpperCase().equals("M")) {
        result1 =JOptionPane.showConfirmDialog(null, meat);
    }
    else if (type.getText().toUpperCase().equals("K")) {
      result1=  JOptionPane.showConfirmDialog(null, drinks);
    }
    else if (type.getText().toUpperCase().equals("F")) {
       result1=  JOptionPane.showConfirmDialog(null, fruits);
    }
    if (yesorno==JOptionPane.YES_OPTION && result1==JOptionPane.YES_OPTION) {
        int ID=Integer.parseInt(id.getText());
        String Name=name.getText();
        int Quantity = Integer.parseInt(quantity.getText());
        int Price = Integer.parseInt(price.getText());
        String Type=type.getText();
       
         int Prodate=Integer.parseInt(prodate.getText());
         int Expdate=Integer.parseInt(expdate.getText());
                 
    

        double Weight = 0.0;
        if (Type.toUpperCase().equals("F") || Type.toUpperCase().equals("M")) {
            String weightInput = JOptionPane.showInputDialog(null, "Enter item weight:");
            Weight = Double.parseDouble(weightInput);
        }
        int indexname=Searchitemname(Name);
        int index=Searchid(ID);
        if (indexname!=-1) {
             JOptionPane.showMessageDialog(null,"This item already exists and the new quantity will be added to the old quantity");
             items[indexname].Addquan(Quantity);
             return;
        }
        if (index==-1) {

            items[size]=new item( ID,  Quantity,  Price,  Prodate,  Expdate,  Name,Type,Weight);
        size++;
        JOptionPane.showMessageDialog(null,"the item has been added");
    }
        else {
            JOptionPane.showMessageDialog(null,"This number is already registered");
            
        }
        String re= JOptionPane.showInputDialog(null,"Do you want to add another item(y/n)?");
                nu=re.toUpperCase();
    } 
   
   } while(nu.equals("Y"));
           
   }
   


}
