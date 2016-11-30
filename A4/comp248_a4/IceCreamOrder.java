//------------------------------------
// Assignment 4
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package comp248_a4;

/**
 * IceCreamOder class displays the user all the choices available to customize his/her ice cream order.
 * 
 * @author Kevin
 */

public class IceCreamOrder {
    private String flavor;
    private String vessel;
    private String amount;
    private double unitPrice;
    private int quantity;
    private int selection;
    
    /*
        Ice Cream Price Formula from the Assignment:
            Single Scoop for Cone, Cup, Sundae start at $3.49, $2.99, $4.25 respectively.
            Price increases by $1 and $2 for an extra scoop or an extra 2 scoop.
        Users can change the flavors, prices and increments below.
    */
    
    private String[] flavorName = {"Avocado", "Banana", "Chocolate", "Coffee", "Hazelnut", "Lemon", "Mango", "Mocha", "Vanilla"};
    private String[] vesselName = {"Cone", "Cup", "Sundae"};
    private double[] vesselPrice = {3.49, 2.99, 4.25};
    private String[] scoopAmount = {"Single Scoop", "Double Scoop", "Triple Scoop"};
    private double[] priceIncrement = {0.0, 1.0, 2.0};
    private String[] quantityName = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    
    private Menu flavorMenu = new Menu(flavorName);
    private Menu vesselMenu = new Menu(vesselName);
    private Menu scoopMenu = new Menu(scoopAmount);
    private Menu quantityMenu = new Menu(quantityName); 

    /**
     * IceCreamOrder constructor that receives the values below.
     * @param flavor Ice cream flavor.
     * @param vessel Ice cream vessel.
     * @param amount Ice cream scoop amount.
     * @param unitPrice Ice cream price depending on the size.
     * @param quantity Number of ice cream to include in this order.
     */
    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity) {
        this.flavor = flavor;
        this.vessel = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    /**
     * IceCreamOrder constructor that receives the values below.
     * @param flavor Ice cream flavor.
     * @param vessel Ice cream vessel.
     * @param amount Ice cream scoop amount.
     * @param unitPrice Ice cream price depending on the size.
     */
    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice) {
        this.flavor = flavor;
        this.vessel = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = 1;
    }

    /**
     * Default Constructor
     */
    public IceCreamOrder() {
        showMenu();
    }
    
    /**
     * Shows the menu in which the user inputs his selection to customize his/her ice cream.
     */
    private void showMenu() {
        flavorMenu.setTopMessage("\nPlacing an order is as easy as ABC, and D.");
        flavorMenu.setTopPrompt("Step A: Select your favorite flavour");
        do {
            selection = flavorMenu.getOptionNumber();
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

        vesselMenu.setTopPrompt("\nStep B: Select a vessel for your ice cream :");
        do {
            selection = vesselMenu.getOptionNumber();
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
        
        scoopMenu.setTopPrompt("\nStep C: How much ice cream ?");
        do {
            selection = scoopMenu.getOptionNumber();
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
        
        quantityMenu.setTopPrompt("\nStep D: how many orders of your current selection ?");
        do {
            selection = quantityMenu.getOptionNumber();
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
    
    /**
     * 
     * @return price of ice cream
     */
    public double price() {
        return unitPrice*quantity;
    }

    /**
     * 
     * @return string that describes the quantity, amount, flavor, vessel and price.
     */
    @Override
    public String toString() {
        return quantity + " orders of " + amount + " of " + flavor + " ice cream in a " + vessel + " for $" + price() + " = " + quantity + " x " + unitPrice;       
    }

    /**
     * 
     * @return flavor of ice cream
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * sets flavor of the ice cream
     * @param flavor 
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    
    /**
     * 
     * @return vessel type of the ice cream
     */
    public String getVessel() {
        return vessel;
    }

    /**
     * sets vessel type of the ice cream
     * @param vessel
     */
    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    /**
     * 
     * @return the amount of scoop of the ice cream
     */
    public String getAmount() {
        return amount;
    }

    /**
     * set the amount of scoop of the ice cream
     * @param amount 
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return the price of 1 unit of the ice cream
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * set the price of 1 unit of the ice cream
     * @param unitPrice 
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 
     * @return quantity of ice cream in the order
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set quantity of ice cream in the order
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
