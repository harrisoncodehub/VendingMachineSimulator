/**
 * @author Miles Hudock
 * CSC-331-002
 * Wed Apr 16th
 */

package com.example.vendingmachinesimulator;
public class VendingItem {
    private String name;
    private double price;

    /**
     * Constructor for vending item objects
     * @param name
     * @param price
     */
    public VendingItem(String name, double price)   {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets Price of item
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets name of item
     * @return
     */
    public String getName() {
        return name;
    }
}
