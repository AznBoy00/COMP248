/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp248_a4;

import java.util.*;

/**
 *
 * @author Kevin
 */
public class Menu {
    
    
    private String topMessage;
    private String topPrompt;
    private String options[];
    private String bottomMessage;
    private String bottomPrompt;
    
    public Menu () {
        this.topMessage = null;
        this.topPrompt = null;
        this.options = null;
        this.bottomMessage = null;
        this.bottomPrompt = null;
    }
    
    public Menu (String[] options) {
        this.options = options;
        this.setTopPrompt("Choose an option:");
        this.setBottomPrompt("?-> Enter an option number:");
        this.toString();
    }
    
    public boolean isEmpty () {
        if (this.options == null || this.options.length == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int Length () {
        if (this.options == null) {
            return 0;
        } else {
            return options.length;
        }
    }
    
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

    public String getTopMessage() {
        return this.topMessage;
    }

    public void setTopMessage(String TopMessage) {
        this.topMessage = TopMessage;
    }

    public String getBottomMessage() {
        return this.bottomMessage;
    }

    public void setBottomMessage(String BottomMessage) {
        this.bottomMessage = BottomMessage;
    }

    public String getTopPrompt() {
        return this.topPrompt;
    }

    public void setTopPrompt(String TopPrompt) {
        this.topPrompt = TopPrompt;
    }

    public String getBottomPrompt() {
        return this.bottomPrompt;
    }

    public void setBottomPrompt(String BottomPrompt) {
        this.bottomPrompt = BottomPrompt;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @Override
    public String toString() {
        
        String output = new String();
        
        output += (this.topMessage == null) ? "" : this.topMessage + "\n";
        output += (this.topPrompt == null) ? "" : this.topPrompt  + "\n";
        if (this.isEmpty() == false) {
            for (int i = 0; i < this.options.length; i++) {
                output += "\t("+(i+1)+") " + this.options[i] + "\n";
            }
        }
        
        output += (this.bottomMessage == null) ? "" : this.bottomMessage + "\n";
        output += (this.bottomPrompt == null) ? "?-> " : "?-> " + this.bottomPrompt;
        
        return output;
    }
    
}
