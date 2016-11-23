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
    
    private String flavor;
    private String vessel;
    private String amount;
    private double unitPrice;
    private int quantity;

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
    
    public void showMenu() {
        Scanner i = new Scanner(System.in);
        int selection;
        
        System.out.println("\nPlacing an order is as easy as ABC , and D.");
        System.out.println("Step A: Select your favorite flavour");
        System.out.println("\t(1) Avocado");
        System.out.println("\t(2) Banana");
        System.out.println("\t(3) Chocolate");
        System.out.println("\t(4) Coffee");
        System.out.println("\t(5) Hazelnut");
        System.out.println("\t(6) Lemon");
        System.out.println("\t(7) Mango");
        System.out.println("\t(8) Mocha");
        System.out.println("\t(9) Vanilla");
        //System.out.println("\t(10) Exit this menu");
        System.out.print("?-> Enter an option number : ");
        selection = i.nextInt();
        
        switch (selection) {
            case 1:
                this.flavor = "Avocado";
                break;
            case 2:
                this.flavor = "Banana";
                break;
            case 3:
                this.flavor = "Chocolate";
                break;
            case 4:
                this.flavor = "Coffee";
                break;
            case 5:
                this.flavor = "Hazelnut";
                break;
            case 6:
                this.flavor = "Lemon";
                break;
            case 7:
                this.flavor = "Mango";
                break;
            case 8:
                this.flavor = "Mocha";
                break;
            case 9:
                this.flavor = "Vanilla";
                break;
            /*default:
                this.flavor = null;
                this.vessel = null;
                this.amount = null;
                this.unitPrice = 0;
                this.quantity = 0;
                System.out.println("Input error, returning to main menu.");
                return;*/
        }
        
        System.out.println("\nStep B: Select a vessel for your ice cream :");
        System.out.println("\t(1) Cone");
        System.out.println("\t(2) Cup");
        System.out.println("\t(3) Sundae");
        System.out.print("?-> Enter an option number: ");
        selection = i.nextInt();
        
        switch (selection) {
            case 1:
                this.vessel = "Cone";
                this.unitPrice = 3.49;
                break;
            case 2:
                this.vessel = "Cup";
                this.unitPrice = 2.99;
                break;
            case 3:
                this.vessel = "Sundae";
                this.unitPrice = 4.25;
                break;
        }

        System.out.println("\nStep C: How much ice cream ?");
        System.out.println("\t(1) Single Scoop");
        System.out.println("\t(2) Double Scoop");
        System.out.println("\t(3) Triple Scoop");
        System.out.print("?-> Enter an option number: ");
        selection = i.nextInt();
        
        switch(selection) {
            case 1:
                this.amount = "Single Scoop";
                break;
            case 2:
                this.amount = "Double Scoop";
                this.unitPrice += 1;
                break;
            case 3:
                this.amount = "Triple Scoop";
                this.unitPrice += 2;
                break;
        }
        
        System.out.println("\nStep D: how many orders of your current selection ?");
        System.out.println("\t(1) One");
        System.out.println("\t(2) Two");
        System.out.println("\t(3) Three");
        System.out.println("\t(4) Four");
        System.out.println("\t(5) Five");
        System.out.println("\t(6) Six");
        System.out.println("\t(7) Seven");
        System.out.println("\t(8) Eight");
        System.out.println("\t(9) Nine");
        System.out.println("\t(10) Ten");
        System.out.print("?-> Enter an option number: ");
        selection = i.nextInt();
        System.out.println("");
        
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
