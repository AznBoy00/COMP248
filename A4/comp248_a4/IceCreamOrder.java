/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp248_a4;

import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class IceCreamOrder {
    //Variable initialization
    private String flavor;
    private String vessel;
    private String amount;
    private double unitPrice;
    private int quantity;
    
    //Variable for the Scanner.
    private int selection;
    
    /*
        Ice Cream Price Formula from the Assignment:
            Single Scoop for Cone, Cup, Sundae start at $3.49, $2.99, $4.25 respectively.
            Price increases by $1 and $2 for an extra scoop or an extra 2 scoop.
        Users can change the flavors, prices and increments below.
    */
    //Flavor Options
    private String[] flavorName = {"Avocado", "Banana", "Chocolate", "Coffee", "Hazelnut", "Lemon", "Mango", "Mocha", "Vanilla"};
    //Vessel Options
    private String[] vesselName = {"Cone", "Cup", "Sundae"};
    private double[] vesselPrice = {3.49, 2.99, 4.25};
    //Scoop Options
    private String[] scoopAmount = {"Single Scoop", "Double Scoop", "Triple Scoop"};
    private double[] priceIncrement = {0.0, 1.0, 2.0};
    //Quantity Options [Do not touch unless you know what you are doing]
    private String[] quantityName = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    
    //Constructor Initialization
    Scanner i = new Scanner(System.in);
    private Menu flavorMenu = new Menu(flavorName);
    private Menu vesselMenu = new Menu(vesselName);
    private Menu scoopMenu = new Menu(scoopAmount);
    private Menu quantityMenu = new Menu(quantityName); 

    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity) {
        this.flavor = flavor;
        this.vessel = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice) {
        this.flavor = flavor;
        this.vessel = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = 1;
    }

    public IceCreamOrder() {
        showMenu();
    }
    
    public void showMenu() { //Trying to link to arrays using =array[x]
        flavorMenu.setTopMessage("\nPlacing an order is as easy as ABC, and D.");
        flavorMenu.setTopPrompt("Step A: Select your favorite flavour");
        do {
            System.out.print(flavorMenu);
            selection = i.nextInt();
        } while (selection <1 || selection > 9);
        
        switch (selection) {
            case 1:
                this.flavor = flavorName[0];
                break;
            case 2:
                this.flavor = flavorName[1];
                break;
            case 3:
                this.flavor = flavorName[2];
                break;
            case 4:
                this.flavor = flavorName[3];
                break;
            case 5:
                this.flavor = flavorName[4];
                break;
            case 6:
                this.flavor = flavorName[5];
                break;
            case 7:
                this.flavor = flavorName[6];
                break;
            case 8:
                this.flavor = flavorName[7];
                break;
            case 9:
                this.flavor = flavorName[8];
                break;
        }

        vesselMenu.setBottomMessage("\nStep B: Select a vessel for your ice cream :");
        do {
            System.out.print(vesselMenu);
            selection = i.nextInt();
        } while (selection <1 || selection > 3);
        
        switch (selection) {
            case 1:
                this.vessel = vesselName[0];
                this.unitPrice = vesselPrice[0];
                break;
            case 2:
                this.vessel = vesselName[1];
                this.unitPrice = vesselPrice[1];
                break;
            case 3:
                this.vessel = vesselName[2];
                this.unitPrice = vesselPrice[2];
                break;
        }
        
        scoopMenu.setTopMessage("\nStep C: How much ice cream ?");
        do {
            System.out.print(scoopMenu);
            selection = i.nextInt();
        } while (selection <1 || selection > 3);
        
        switch(selection) {
            case 1:
                this.amount = scoopAmount[0];
                this.unitPrice += priceIncrement[0];
                break;
            case 2:
                this.amount = scoopAmount[1];
                this.unitPrice += priceIncrement[1];
                break;
            case 3:
                this.amount = scoopAmount[2];
                this.unitPrice += priceIncrement[2];
                break;
        }
        
        quantityMenu.setTopMessage("\nStep D: how many orders of your current selection ?");
        do {
            System.out.print(quantityMenu);
            selection = i.nextInt();
        } while (selection <1 || selection > 10);
        
        switch (selection) {
            case 1:
                this.quantity = 1;
                break;
            case 2:
                this.quantity = 2;
                break;
            case 3:
                this.quantity = 3;
                break;
            case 4:
                this.quantity = 4;
                break;
            case 5:
                this.quantity = 5;
                break;
            case 6:
                this.quantity = 6;
                break;
            case 7:
                this.quantity = 7;
                break;
            case 8:
                this.quantity = 8;
                break;
            case 9:
                this.quantity = 9;
                break;
            case 10:
                this.quantity = 10;
                break;
        }
    }
    
    public double price() {
        return unitPrice*quantity;
    }

    @Override
    public String toString() {
        return " " + quantity + " orders of " + amount + " of " + flavor + " ice cream in a " + vessel + " for $" + price() + " = " + quantity + " x " + unitPrice;       
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
