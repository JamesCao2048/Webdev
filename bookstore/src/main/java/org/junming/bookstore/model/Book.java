package org.junming.bookstore.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Book implements Serializable {
    private String id;
    private String name;
    private String author;
    private  int stock;
    private int price;
    private String type;

    public Book() {
    }

    public Book(String id,String name, String author, int stock, int price, String type){
        this.id=id;
        this.name=name;
        this.author=author;
        this.stock=stock;
        this.price=price;
        this.type=type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice( int price)
    {
        this.price = price;
    }

    /*private Set orders = new HashSet();

    public Set getOrders() {
        return orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }*/

    public String toString()
    {
        return "id " + getId()+" Name:  " + getName() +
                " Author: "+getAuthor() + " Stock: " + getStock() +" Email: " + getPrice()
                +" Type: "+getType();
    }
}
