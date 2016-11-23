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
    double totalPrice = 0.0;
    Scanner i = new Scanner(System.in);
    
    public IceCreamStore(){
        //order = new IceCreamOrder();
        cart = new ShoppingCart();
    }
    
    public void placeOrder(){
        if (!cart.isFull()) {
            IceCreamOrder order = new IceCreamOrder();
            cart.add(order);
        } else {
            System.out.println("Cart full, cannot place order.");
        }
        run();
    }
    
    public void deleteOrder(){        
        System.out.println("You have selected to remove an order from your cart");
        System.out.println("What would you like to do?");
        System.out.println(cart.toString());
        System.out.println("("+ (cart.getCount()+1) +") Exit this menu");
        System.out.print("?-> Enter an option number : ");
        selection = i.nextInt();
        
        if (selection <= (cart.getCount())) {
            cart.remove(selection);
            System.out.println("The order you selected was deleted");
        } else {
            System.out.println("An error has occured.");
        }
        run();
    }
    
    public double computeTotalPrice() {
        for (int j = 0; j < cart.getCount(); j++) {
            this.totalPrice += cart.get(j + 1).price();
        }
        return totalPrice;
    }
    
    public void printTotalPrice() {
        computeTotalPrice();
        System.out.println("\n------------------------------------=");
        System.out.println("Total price of all your orders in the cart : " + totalPrice);
        System.out.println("------------------------------------=");
        run();
    }
    
    public void reviewOrders() {
        System.out.println(cart.toString());
    }
    
    public void checkout() {
        reviewOrders();
        printTotalPrice();
        run();
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
                if (cart.isFull()) {
                    run();
                    break;
                }
                placeOrder();
                break;
            case 2:
                deleteOrder();
                break;
            case 3:
                printTotalPrice();
                break;
            case 4:
                System.out.println("Your current selections of our scrumptious ice creams");
                System.out.println("-----------------------------------------------------");
                System.out.println(cart.toString());
                System.out.println("-----------------------------------------------------");
                run();
                break;
            case 5:
                checkout();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
}
