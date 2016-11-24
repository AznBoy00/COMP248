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
    private ShoppingCart cart;
    private int selection;
    double totalPrice;
    Scanner i = new Scanner(System.in);
    
    private String[] mainMenu = {"Place an order", "Delete an order", "Price the chart", "List the chart", "Proceed to checkout", "Exit this menu"};
    private Menu menu = new Menu(mainMenu);

    private String[] generateCartList() {
        String[] cartList = new String[cart.getCount()];
        for (int j = 0; j < cart.getCount(); j++) {
            cartList[j] = cart.get(j+1).toString();
        }
        return cartList;
    }
    
    public IceCreamStore(){
        cart = new ShoppingCart();
    }
    
    public void placeOrder(){
        IceCreamOrder order = new IceCreamOrder();
        cart.add(order);
    }
    
    public void deleteOrder(){
        String[] cartList = generateCartList();
        Menu deleteMenu = new Menu(cartList);
        
        deleteMenu.setTopMessage("\nYou have selected to remove an order from your cart");
        deleteMenu.setTopPrompt("What would you like to do?");
        deleteMenu.setBottomMessage("\t("+ (cart.getCount()+1) +") Exit this menu");
        System.out.print(deleteMenu);
        selection = i.nextInt();
        
        if (selection <= (cart.getCount())) {
            cart.remove(selection);
            System.out.println("\nThe order you selected was deleted\n");
        } else if (selection == (cart.getCount()+1)) {
            System.out.println("");
        } else {
            System.out.println("\nAn error has occured, please try again.\n");
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
    
    public void reviewOrders() {//TODO
        System.out.println("\nYour current selections of our scrumptious ice creams");
        System.out.print("-----------------------------------------------------");
        System.out.print(cart.toString());
        System.out.print("\n-----------------------------------------------------\n");
    }
    
    public void checkout() {
        reviewOrders();
        printTotalPrice();
        //Empty Cart
        /*for (int j = 0; j < cart.getCount(); j++) {
            cart.remove(j+1);
        }*/
        this.cart = new ShoppingCart();
    }
    
    public void run() {
        if (cart.isEmpty()) {
            menu.setTopMessage("Your Shopping Cart is empty.");
            menu.setTopPrompt("You have only two options : 1 or 6");
            menu.setBottomMessage("Please enter 1 or 6");
        } else if (cart.isFull()) {
            menu.setTopMessage("Your Shopping Cart is full with " + cart.getMAX_ORDERS() + " ice cream orders.");
            menu.setTopPrompt("Cannot place orders ! what would you like to do?");
            menu.setBottomMessage("Please select option 2, 3, 4, 5, or 6");
        } else {
            if (cart.getCount() == 1) {
                menu.setTopMessage("Your shopping cart contains " + cart.getCount() + " ice cream order");
            } else {
                menu.setTopMessage("Your shopping cart contains " + cart.getCount() + " ice cream orders");
            }
            menu.setTopPrompt("What would you like to do?");
            menu.setBottomMessage(null);
        }
        System.out.print(menu);
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
            default:
                run();
                break;
        }
    }
}
