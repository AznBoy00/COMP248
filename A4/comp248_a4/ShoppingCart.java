//------------------------------------
// Assignment 4
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package comp248_a4;

/**
 * ShoppingCart class is responsible to manage the shopping cart from the ice cream store.
 * @author Kevin
 */
public class ShoppingCart {
    private IceCreamOrder[] order;
    private int count;
    private final int MAX_ORDERS = 3;
    /**
     * Default constructor which sets the number or orders to 0
     */
    public ShoppingCart() {
        this.order = new IceCreamOrder[MAX_ORDERS];
        this.count = 0;
    }
    /**
     * Adds the order to the array order
     * @param order (user input)
     */
    public void add(IceCreamOrder order) {
        if (count < MAX_ORDERS) {
            this.order[count] = order;
            count++;
        } else {
            System.out.println("Your shopping cart is full. Could not add item.");
        }
    }
    /**
     * Removes the order specified from the array of order
     * @param position (user's input)
     */
    public void remove(int position) {
        position -= 1;
        if (position < count) {
            this.order[position] = null;
            count--;
            for (int i = position; i < (MAX_ORDERS - 1); i++) {
                this.order[i] = this.order[i+1];
                this.order[i+1] = null;
            }
        }
    }
    /**
     * 
     * @return the shopping cart in a list from the array of order
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count; i++) {
            s += "\n\t(" + (i+1) + ") " + order[i].toString();
        }
        return s;
    }
    /**
     * 
     * @return a boolean showing whether the cart is empty or not
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 
     * @return a boolean showing that whether the cart is full or not
     */
    public boolean isFull() {
        if (count == MAX_ORDERS) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 
     * @return an integer representing the number of articles in the cart
     */
    public int getCount() {
        return count;
    }
    /**
     * 
     * @param position (user's position input)
     * @return the position of an object inside the array of cart orders
     */
    public IceCreamOrder get(int position) {
        if (position <= count) {
            position -= 1;
            return this.order[position];
        } else {
            System.out.println("Position is out of range.");
            return null;
        }
    }
    /**
     * 
     * @return the object inside the order array
     */
    public IceCreamOrder[] getOrder() {
        return order;
    }
    /**
     * 
     * @return an integer representing the number of maximum orders a user can order.
     */
    public int getMAX_ORDERS() {
        return MAX_ORDERS;
    }
    
}
