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
    
    public ShoppingCart() {
        this.order = new IceCreamOrder[5];
        this.count = 0;
    }
    
    public void add(IceCreamOrder order) {
        if (count < 5) {
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
            for (int i = position; i < 4; i++) {
                this.order[i] = this.order[i+1];
                this.order[i+1] = null;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count; i++) {
            s += order[i].toString() + "\n";
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
        if (count == 5) {
            return true;
        } else {
            return false;
        }
    }
    
    public int size() {
        return count;
    }
    
    public IceCreamOrder get(int position) {
        if (position < count) {
            position -= 1;
            return this.order[position];
        } else {
            System.out.println("Position is out of range.");
            return null;
        }
    }
    
}
