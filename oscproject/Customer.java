
package com.mycompany.supermarket;

public  class Customer extends data{
    
    int cart;

    public Customer(int cart, String name, int id) {
        super(name, id);
        this.cart = cart;
    }

    public int getCart() {
        return cart;
    }
@Override
    public String getName() {
        return name;
    }
@Override
    public  int getId() {
        return id;
    }

    @Override
    public void setName(String name) {
       
    }

    @Override
    public void setId(int id) {
       
    }
    
}
