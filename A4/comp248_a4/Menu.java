//------------------------------------
// Assignment 4
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package comp248_a4;

import java.util.*;

/**
 * Menu class generates options to accept user inputs.
 * 
 * @author Kevin
 */
public class Menu {
    private String topMessage;
    private String topPrompt;
    private String options[];
    private String bottomMessage;
    private String bottomPrompt;
    
    /**
     * default Menu constructor
     */
    public Menu () {
        this.topMessage = null;
        this.topPrompt = null;
        this.options = null;
        this.bottomMessage = null;
        this.bottomPrompt = null;
    }
    
    /**
     * Menu constructor that accepts a string array
     * @param options -> array of string
     */
    public Menu (String[] options) {
        this.options = options;
        this.setTopPrompt("Choose an option:");
        this.setBottomPrompt("Enter an option number: ");
        this.toString();
    }
    
    /**
     * 
     * @return a boolean to check if the menu is empty or not
     */
    public boolean isEmpty () {
        if (this.options == null || this.options.length == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @return the length of the menu in integer
     */
    public int Length () {
        if (this.options == null) {
            return 0;
        } else {
            return options.length;
        }
    }
    
    /**
     * displays the constructed menu
     * @return the scanner input of the user
     */
    public int getOptionNumber() {
        Scanner i = new Scanner(System.in);
        int input;
        do {
            System.out.print(this);
            input = i.nextInt();
            if (this.isEmpty())
                return input;
        } while (input < 1 || input > this.options.length);
            return input;
    }

    /**
     * 
     * @return the string of the top message of the menu
     */
    public String getTopMessage() {
        return this.topMessage;
    }

    /**
     * sets the top message to the user's input
     * @param TopMessage (user's input)
     */
    public void setTopMessage(String TopMessage) {
        this.topMessage = TopMessage;
    }

    /**
     * 
     * @return the string of the bottom message of the menu
     */
    public String getBottomMessage() {
        return this.bottomMessage;
    }

    /**
     * sets the bottom message to the user's input
     * @param BottomMessage (user's input)
     */
    public void setBottomMessage(String BottomMessage) {
        this.bottomMessage = BottomMessage;
    }

    /**
     * 
     * @return the string of the top prompt of the menu
     */
    public String getTopPrompt() {
        return this.topPrompt;
    }

    /**
     * sets the top prompt to the user's input
     * @param TopPrompt (user's input)
     */
    public void setTopPrompt(String TopPrompt) {
        this.topPrompt = TopPrompt;
    }

    /**
     * 
     * @return the string of the bottom prompt of the menu
     */
    public String getBottomPrompt() {
        return this.bottomPrompt;
    }

    /**
     * sets the bottom prompt to the user's input
     * @param BottomPrompt (user's input)
     */
    public void setBottomPrompt(String BottomPrompt) {
        this.bottomPrompt = BottomPrompt;
    }
    
    /**
     * 
     * @return the option string array of the menu
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * set the menu option string array to the user's inputed array
     * @param options (user's input)
     */
    public void setOptions(String[] options) {
        this.options = options;
    }

    /**
     * Menu layout:
     * topMessage
     * topPrompt
     * options
     * bottomMessage
     * bottomPrompt
     * 
     * @return the string of the set menus
     */
    @Override
    public String toString() {
        String output = new String();
        
        output += (this.topMessage == null) ? "" : this.topMessage + "\n";
        output += (this.topPrompt == null) ? "" : this.topPrompt  + "\n";
        if (this.isEmpty() == false) {//not empty
            for (int i = 0; i < this.options.length; i++) {
                output += "\t("+(i+1)+") " + this.options[i] + "\n";
            }
        }
        
        output += (this.bottomMessage == null) ? "" : this.bottomMessage + "\n";
        output += (this.bottomPrompt == null) ? "?-> " : "?-> " + this.bottomPrompt;
        
        return output;
    }
    
}
