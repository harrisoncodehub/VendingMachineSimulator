package com.example.vendingmachinesimulator;

/**
 * VendingItem class.
 * @author Miles Hudock
 * CSC-331-002
 * Wed Apr 16th
 */

public class VendingItem {
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructor for the VendingItem class.
     * @param name      The name of the item.
     * @param price     The price of the item
     * @param quantity   The quantity of the item
     */
    public VendingItem(String name, double price ,int quantity)   {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    // Setters

    /**
     * Sets the name of the item.
     * @param name The name of the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the item.
     * @param price the price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the quantity of the item.
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getters

    /**
     * Gets the name of the item
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the item.
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Methods

    /**
     * Decreases the quantity of the item by one.
     */
    public void decrementQuantity(){
        this.quantity = quantity - 1;
    }

    /**
     * Increases the quantity of the item by one.
     */
     public void incrementQuantity(){
        this.quantity = quantity + 1;
     }

    /**
     * Checks if the item is sold out.
     * @return True if the item is sold out, false otherwise.
     */
     public boolean isSoldOut(){
         return this.quantity <= 0;
     }

    /**
     * Checks if the item is available.
     * @return True if the item is available, false otherwise.
     */
     public boolean isAvailable(){
        return this.quantity > 0;
     }


}
