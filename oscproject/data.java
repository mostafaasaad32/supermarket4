
package com.mycompany.supermarket;

public  abstract class data {
    
    String name;
    int id;

    public data(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract void setName(String name) ;
    

    public abstract void setId(int id) ;
      
    

    public abstract String getName() ;
    

    public abstract int getId() ;
    
    
    
}
