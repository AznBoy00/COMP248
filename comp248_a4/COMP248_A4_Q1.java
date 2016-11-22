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
public class COMP248_A4_Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner i = new Scanner(System.in);
        String[] drink_options = {"Water", "Soda Pop", "Beer"};
        String[] option_list = {"Water", "Soda pop", "Beer"};
        Menu drinkMenu = new Menu(drink_options);
        Menu full_menu = new Menu(option_list);//no
        
        //drinkMenu.setTopPrompt(null);
        //drinkMenu.setBottomPrompt(null);
        //System.out.println(drinkMenu);
        /*
        full_menu.setTopMessage("Quench your thirst with our fine drinks!");
        full_menu.setBottomMessage("Time to obey your thirst!");
        full_menu.setTopPrompt("Choose your thirst crusher:");
        full_menu.setBottomPrompt("Enter a drink number: ");
        // display the menu and then read an option number
        int choice = full_menu.readOptionNumber();
        System.out.println("You entered " + choice );*/
        
        // create an empty menu
        Menu m = new Menu(); // no messages, no prompts, no options
        // read an integer
        int number1 = m.readOptionNumber();
        System.out.println("You entered " + number1);
        System.out.println("----------------------");
        // introduce bottom prompt
        m.setBottomPrompt("Enter an integer for bottom prompt: ");
        // read an integer
        int number2 = m.readOptionNumber();
        System.out.println("You entered " + number2);
        System.out.println("----------------------");
        
    }
    
}
