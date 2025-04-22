/**
 * @author Miles Hudock, Harrison Hubbard, Jaydon Tyndell, Fate Franks
 * CSC-331-002
 * 4/22/2025
 * Purpose: Class for creating vending item objects
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
