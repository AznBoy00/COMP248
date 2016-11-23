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
public class ShoppingCart {
    
    private IceCreamOrder[] order;
    private int count;
    private final int MAX_ORDERS = 3;
    
    public ShoppingCart() {
        this.order = new IceCreamOrder[MAX_ORDERS];
        this.count = 0;
    }
    
    public void add(IceCreamOrder order) {
        if (count < MAX_ORDERS) {
            this.order[count] = order;
            count++;
        } else {
            System.out.println("Your shopping cart is full. Could not add item.");
        }
    }
    
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

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count; i++) {
            s += "(" + (i+1) + ")" + order[i].toString() + "\n";
        }
        return s;
    }
    
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull() {
        if (count == MAX_ORDERS) {
            return true;
        } else {
            return false;
        }
    }
    
    public int size() {
        return count;
    }
    
    public IceCreamOrder get(int position) {
        if (position <= count) {
            position -= 1;
            return this.order[position];
        } else {
            System.out.println("Position is out of range.");
            return null;
        }
    }

    public IceCreamOrder[] getOrder() {
        return order;
    }

    public int getCount() {
        return count;
    }

    public int getMAX_ORDERS() {
        return MAX_ORDERS;
    }
    
}
