
package com.mycompany.supermarket;


public class Purchases {
     public static Purchases[] purchases=new Purchases[1000];
    public static int size2=0;

    int idcustomer,iditem,quantitiy;
    String name;

    public Purchases(int idcustomer, int idname, int quantitiy, String name) {
        this.idcustomer = idcustomer;
        this.iditem = idname;
        this.quantitiy = quantitiy;
        this.name = name;
    }

    public int getIdcustomer() {
        return idcustomer;
    }

    public int getIditem() {
        return iditem;
    }

    public int getQuantitiy() {
        return quantitiy;
    }

    public String getitemName() {
        return name;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public void setIditem(int idname) {
        this.iditem = idname;
    }

    public void setQuantitiy(int quantitiy) {
        this.quantitiy = quantitiy;
    }

    public void setitemName(String name) {
        this.name = name;
    }
    
}
