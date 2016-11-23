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
    //private IceCreamOrder order;
    private ShoppingCart cart;
    private int selection;
    double totalPrice;
    Scanner i = new Scanner(System.in);
    
    public IceCreamStore(){
        cart = new ShoppingCart();
    }
    
    public void placeOrder(){
        IceCreamOrder order = new IceCreamOrder();
        cart.add(order);
    }
    
    public void deleteOrder(){        
        System.out.println("\nYou have selected to remove an order from your cart");
        System.out.println("What would you like to do?");
        System.out.println(cart.toString());
        System.out.println("\t("+ (cart.getCount()+1) +") Exit this menu");
        System.out.print("?-> Enter an option number : ");
        selection = i.nextInt();
        
        if (selection <= (cart.getCount())) {
            cart.remove(selection);
            System.out.println("\nThe order you selected was deleted\n");
        } else if (selection == 4) {
            System.out.println("");
        } else {
            System.out.println("\nAn error has occured\n.");
        }       
    }
    
    public double computeTotalPrice() {
        this.totalPrice = 0.0;
        for (int j = 0; j < cart.getCount(); j++) {
            totalPrice += cart.get(j + 1).price();
        }
        return totalPrice;
    }
    
    public void printTotalPrice() {
        computeTotalPrice();
        System.out.println("------------------------------------=");
        System.out.printf("Total price of all your orders in the cart : $%.2f", totalPrice);
        System.out.println("\n------------------------------------=\n");
    }
    
    public void reviewOrders() {
        System.out.println("\nYour current selections of our scrumptious ice creams");
        System.out.print("-----------------------------------------------------");
        System.out.print(cart.toString());
        System.out.print("\n-----------------------------------------------------\n");
    }
    
    public void checkout() {
        reviewOrders();
        printTotalPrice();
        //Empty Cart
        for (int j = 0; j < cart.getCount(); j++) {
            cart.remove(j+1);
        }
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
            System.out.print("?-> Enter an option number : ");
        } else if (cart.isFull()) {
            System.out.println("Your Shopping Cart is full with " + cart.getMAX_ORDERS() + " ice cream orders.");
            System.out.println("Cannot place orders ! what would you like to do?");
            showMenu();
            System.out.println("Please select option 2, 3, 4, 5, or 6");
            System.out.print("?-> Enter an option number : "); 
        } else {
            System.out.println("Your shopping cart contains " + cart.getCount() + " ice cream order(s)");
            System.out.println("What would you like to do?");
            showMenu();
            System.out.print("?-> Enter an option number : ");
        }
        selection = i.nextInt();
        
        switch (selection) {
            case 1:
                if (!cart.isFull()) { //Was working. Need to Test.
                    placeOrder();
                }
                System.out.println("");
                run();
                break;
            case 2:
                if (!cart.isEmpty()) {
                    deleteOrder();
                }
                run();
                break;
            case 3:
                if (!cart.isEmpty()) {
                    System.out.println("");
                    printTotalPrice();
                }
                run();
                break;
            case 4:
                if (!cart.isEmpty()) {
                    reviewOrders();
                    System.out.println("");
                }
                run();
                break;
            case 5:
                if (!cart.isEmpty()) {
                    checkout();
                }
                run();
                break;
            case 6:
                System.out.println("\nCheers!");
                System.exit(0);
                break;
            default:
                System.out.println("");
                run();
                break;
        }
    }
}
