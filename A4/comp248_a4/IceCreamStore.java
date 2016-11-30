//------------------------------------
// Assignment 4
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package comp248_a4;


/**
 *
 * @author Kevin
 */
public class IceCreamStore {
    private ShoppingCart cart;
    private int selection;
    double totalPrice;
    
    private String[] mainMenu = {"Place an order", "Delete an order", "Price the chart", "List the chart", "Proceed to checkout", "Exit this menu"};
    private Menu menu = new Menu(mainMenu);

    private String[] generateCartListWithExit() {
        String[] cartList = new String[cart.getCount()+1];
        for (int j = 0; j < cart.getCount(); j++) {
            cartList[j] = cart.get(j+1).toString();
        }
        cartList[cartList.length-1] = "Exit this menu";
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
        String[] menuOptions = generateCartListWithExit();
        
        
        Menu deleteMenu = new Menu(menuOptions);
        
        deleteMenu.setTopMessage("\nYou have selected to remove an order from your cart");
        deleteMenu.setTopPrompt("What would you like to do?");
        
        do {
            selection = deleteMenu.getOptionNumber();
            if (selection == (cart.getCount()+1)) {
                System.out.println("");
            } else if (selection <= (cart.getCount()) && selection > 0) {
                cart.remove(selection);
                System.out.print("\nThe order you selected was deleted\n");
            } else {
                System.out.print("\nAn error has occured, please try again.\n"); 
            }
        } while (selection <= 0 && selection > (cart.getCount()+1));
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
        System.out.println("\n------------------------------------=");
    }
    
    public void reviewOrders() {//TODO
        System.out.println("\nYour current selections of our scrumptious ice creams");
        System.out.print("-----------------------------------------------------");
        System.out.print(cart.toString());
        System.out.println("\n-----------------------------------------------------");
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
        selection = menu.getOptionNumber();
        
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
                    System.out.println("");
                    run();
                } else {
                    System.out.println("");
                    run();
                }
                break;
            case 4:
                if (!cart.isEmpty()) {
                    reviewOrders();
                }
                System.out.println("");
                run();
                break;
            case 5:
                if (!cart.isEmpty()) {
                    checkout();
                }
                System.out.println("");
                run();
                break;
            case 6:
                System.out.println("\nCheers!");
                System.exit(0);
            default:
                System.out.println("");
                run();
                break;
        }
    }
}
