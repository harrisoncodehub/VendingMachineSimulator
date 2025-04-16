/**
 * Item.java
 * @author Harrison Hubbard
 * Date: 4/16/2025
 * Section: CSC-331-002
 *
 * Purpose: Represents an item within the vending machine with name,price and quantity attributes.
 * Implements methods isAvailable and dispense to get information on items in the vending machine / update quantity properities.
 */

package com.example.vendingmachinesimulator;

public class Item {
    private String name;
    private double price;
    private int quantity;


    /**
     * Default constructor of the item object
     * @param name          The name of the item
     * @param price         The price of the item
     * @param quantity      The quantity of the item
     */
    public Item (String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    // Getters

    /**
     * Retrieve's the name of the item
     * @return the name of the item
     */
    public String getName() { return name; }

    /**
     * Retrieve's the price of the item
     * @return the price of the item
     */
    public double getPrice() {return price;}

    /**
     * Retrieve's the quantity of the item
     * @return the quantity of the item
     */
    public double getQuantity() {return quantity;}


    // Setters

    /**
     * Set's the name of the item
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set's the price of the item
     * @param price of the item in $
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Set's the quantity of the item
     * @param quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Methods

    /**
     * Determines if the item is in stock / available
     * @return True or False depending on if the item is in stock or not
     */
    public boolean isAvailable() {
        return quantity < 0;
    }

    /**
     * If the item is selected the quantity will be updated
     */
    public void dispense() {
        if (isAvailable()) {
            quantity = quantity - 1;
        }
    }
}
