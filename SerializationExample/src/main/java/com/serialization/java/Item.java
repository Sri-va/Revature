package com.serialization.java;

import java.io.Serializable;

public class Item implements Serializable {

	 

    private String itemID;
    private String desc;
    private double cost;
    private int quantity;

 

    public Item() {
        itemID = "";
        desc = "";
        cost = 0;
        quantity = 0;
    }

 

    public Item(String id, String d, double c, int q) {
        itemID = id;
        desc = d;
        cost = c;
        quantity = q;

 

    }

 

    public String getItemID() {
        return itemID;
    }

 

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

 

    public String getDesc() {
        return desc;
    }

 

    public void setDesc(String desc) {
        this.desc = desc;
    }

 

    public double getCost() {
        return cost;
    }

 

    public void setCost(double cost) {
        this.cost = cost;
    }

 

    public int getQuantity() {
        return quantity;
    }

 

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

 

    @Override
    public String toString() {
        return "Item [itemID=" + itemID + ", desc=" + desc + ", cost=" + cost + ", quantity=" + quantity + "]";
    }

 

}