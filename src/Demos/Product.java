package Demos;

public class Product {
    String name;
    double price;
    int quantity;

    public Product(){ //default constructor
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }
    public Product(String name){ //parameterized constructor
        this.name = name;
        this.price = 0.0;
        this.quantity = 0;
    }
    public Product(String name, double price){ //parameterized constructor
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }
    public Product(String name, double price, int quantity){ //parameterized constructor
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //getters
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public int getQuantity(){return this.quantity;}

    //setters
    public void setName(String name){this.name = name;}
    public void setPrice(double price){this.price = price;}
    public void getQuantity(int quantity){this.quantity = quantity;}

    


}
