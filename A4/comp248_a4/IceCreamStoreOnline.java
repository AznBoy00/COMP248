//------------------------------------
// Assignment 4
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package comp248_a4;

/**
 * Main class which runs the ice cream store program.
 * 
 * This program prompts several different menus in order to let the user input his or her order.
 * There are many different flavors and type of ice that the user can purchase.
 * The user can also modify the orders inputed.
 * A review and checkout option is inside the program also.
 * 
 * @author Kevin
 */
public class IceCreamStoreOnline {
    
    public static void main(String[] args) {
        //Initialize IceCreamStore
        IceCreamStore shop = new IceCreamStore();
        shop.run();
    }
}
