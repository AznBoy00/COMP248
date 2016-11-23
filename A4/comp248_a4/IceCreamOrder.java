/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp248_a4;

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
        /*System.out.println("Placing an order is as easy as ABC , and D.");
        System.out.println("Step A: Select your favorite flavour");
        System.out.println("?-> Enter an option number :");*/
        
    }
    
    public double price() {
        return unitPrice*quantity;
    }

    @Override
    public String toString() {
        return quantity + "orders of " + amount + " of " + flavor + " ice cream in a " + vessel + " for $" + price() + " = " + quantity + " x " + unitPrice;       
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
