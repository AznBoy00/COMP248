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

    /**
     * Default constructor for IceCreamStore
     */
    public IceCreamStore(){
        cart = new ShoppingCart();
    }
    
    /**
     * 
     * @return a string array of the cart and adds an exit option
     */
    private String[] generateCartListWithExit() {
        String[] cartList = new String[cart.getCount()+1];
        for (int j = 0; j < cart.getCount(); j++) {
            cartList[j] = cart.get(j+1).toString();
        }
        cartList[cartList.length-1] = "Exit this menu";
        return cartList;
    }
    
    /**
     * place order to cart
     */
    private void placeOrder(){
        IceCreamOrder order = new IceCreamOrder();
        cart.add(order);
    }
    
    /**
     * delete order from the cart while it includes many checks along with an exit menu option
     */
    private void deleteOrder(){
        String[] menuOptions = generateCartListWithExit();
        
        
        Menu deleteMenu = new Menu(menuOptions);
        
        deleteMenu.setTopMessage("\nYou have selected to remove an order from your cart");
        deleteMenu.setTopPrompt("What would you like to do?");
        
        do {
            selection = deleteMenu.getOptionNumber();
            if (selection == (cart.getCount()+1)) {
                //Do nothing, will go back to main menu.
            } else if (selection <= (cart.getCount()) && selection > 0) {
                cart.remove(selection);
                System.out.print("\nThe order you selected was deleted");
            } else {
                System.out.print("\nAn error has occured, please try again."); 
            }
        } while (selection <= 0 && selection > (cart.getCount()+1));
    }
    
    /**
     * 
     * @return the total price of the order by adding the price values of each order together with a loop
     */
    private double computeTotalPrice() {
        this.totalPrice = 0.0;
        for (int j = 0; j < cart.getCount(); j++) {
            totalPrice += cart.get(j + 1).price();
        }
        return totalPrice;
    }
    
    /**
     * print the total price of the order.
     */
    private void printTotalPrice() {
        computeTotalPrice();
        System.out.println("------------------------------------=");
        System.out.printf("Total price of all your orders in the cart : $%.2f", totalPrice);
        System.out.println("\n------------------------------------=");
    }
    
    /**
     * display the cart
     */
    private void reviewOrders() {
        System.out.println("\nYour current selections of our scrumptious ice creams");
        System.out.print("-----------------------------------------------------");
        System.out.print(cart.toString());
        System.out.println("\n-----------------------------------------------------");
    }
    
    /**
     * checkout the cart by showing the order and the price, then it will re-initiate the constructor
     */
    private void checkout() {
        reviewOrders();
        printTotalPrice();
        this.cart = new ShoppingCart();
    }
    
    /**
     * display the main menu
     */
    public void run() {
        if (cart.isEmpty()) { //message when the cart is empty
            menu.setTopMessage("Your Shopping Cart is empty.");
            menu.setTopPrompt("You have only two options : 1 or 6");
            menu.setBottomMessage("Please enter 1 or 6");
        } else if (cart.isFull()) { //message when the cart is full
            menu.setTopMessage("Your Shopping Cart is full with " + cart.getMAX_ORDERS() + " ice cream orders.");
            menu.setTopPrompt("Cannot place orders ! what would you like to do?");
            menu.setBottomMessage("Please select option 2, 3, 4, 5, or 6");
        } else { //otherwise it will display the default messages below.
            if (cart.getCount() == 1) {
                menu.setTopMessage("Your shopping cart contains " + cart.getCount() + " ice cream order");
            } else {
                menu.setTopMessage("Your shopping cart contains " + cart.getCount() + " ice cream orders");
            }
            menu.setTopPrompt("What would you like to do?");
            menu.setBottomMessage(null);
        }
        selection = menu.getOptionNumber();
        
        switch (selection) {//added many empty println in order to make the program skip lines properly corresponding to the assignement examples.
            case 1://option 1 to place an order
                if (!cart.isFull()) {
                    placeOrder();
                }
                System.out.println("");
                run();
                break;
            case 2://option 2 to delete an order
                if (!cart.isEmpty()) {
                    deleteOrder();
                }
                System.out.println("");
                run();
                break;
            case 3://option 3 to print the total price
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
            case 4://option 4 to display the current orders in the cart
                if (!cart.isEmpty()) {
                    reviewOrders();
                }
                System.out.println("");
                run();
                break;
            case 5://option 5 to checkout and clear the cart
                if (!cart.isEmpty()) {
                    checkout();
                }
                System.out.println("");
                run();
                break;
            case 6://option 6 to exit the program
                System.out.println("\nCheers!");
                System.exit(0);
            default://anything else will re execute this method
                System.out.println("");
                run();
                break;
        }
    }
}
