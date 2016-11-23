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
public class IceCreamStore {
    private IceCreamOrder order = new IceCreamOrder();
    private ShoppingCart cart = new ShoppingCart();
    private int selection;
    double totalPrice = 0.0;
    Scanner i = new Scanner(System.in);
    
    public void placeOrder(){
        if (!cart.isFull()) {
            
        } else {
            System.out.println("Cart full, cannot place order.");
        }
    }
    
    public void deleteOrder(){        
        System.out.println("You have selected to remove an order from your cart");
        System.out.println("What would you like to do?");
        cart.toString();
        System.out.println("("+ (cart.getCount()+1) +") Exit this menu");
        System.out.print("?-> Enter an option number : ");
        selection = i.nextInt();
        
        if (selection == (cart.getCount()+1)) {
            placeOrder();
        } else if (cart.get(selection) != null) {
            cart.remove(selection);
            System.out.println("The order you selected was deleted");
        } else {
            System.out.println("An error has occured.");
        }
    }
    
    public double computeTotalPrice() {
        for (int i = 0; i < cart.getCount(); i++) {
            this.totalPrice += cart.get(i).price();
        }
        return totalPrice;
    }
    
    public void printTotalPrice() {
        System.out.println(totalPrice);
    }
    
    public void reviewOrders() {
        cart.toString();
    }
    
    public void checkout() {
        reviewOrders();
        printTotalPrice();
    }
    
    private void showMenu() {
        System.out.println("\t(1) Place an order");
        System.out.println("\t(2) Delete an order");
        System.out.println("\t(3) Price the cart");
        System.out.println("\t(4) List the cart");
        System.out.println("\t(5) Proceed to checkout");
        System.out.println("\t(6) Exit this menu");
    }
    
    public void run() {
        if (cart.isEmpty()) {
            System.out.println("Your Shopping Cart is empty .");
            System.out.println("You have only two options : 1 or 6");
            showMenu();
            System.out.print("?-> Enter an option number :");
        } else if (cart.isFull()) {
            System.out.println("Your Shopping Cart is full with 5 ice cream orders.");
            System.out.println("Cannot place orders ! what would you like to do?");
            showMenu();
            System.out.println("Please select option 2, 3, 4, 5, or 6");
            System.out.print("?-> Enter an option number :");
            
        } else {
            System.out.println("Your shopping cart contains " + cart.getCount() + " ice cream order(s)");
            System.out.println("What would you like to do?");
            showMenu();
            System.out.print("?-> Enter an option number :");
        }
        
    }
}
