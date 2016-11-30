//------------------------------------
// Assignment 4
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package comp248_a4;

/**
 * Test file to test menu.java
 * 
 * @author Kevin
 */
public class COMP248_A4_P1 {

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
        Menu m = new Menu();
        
        //TEST1
        //drinkMenu.setTopPrompt(null);
        //drinkMenu.setBottomPrompt(null);
        System.out.println(drinkMenu);
        
        //PART1
        /*
        full_menu.setTopMessage("Quench your thirst with our fine drinks!");
        full_menu.setBottomMessage("Time to obey your thirst!");
        full_menu.setTopPrompt("Choose your thirst crusher:");
        full_menu.setBottomPrompt("Enter a drink number: ");
        // display the menu and then read an option number
        int choice = full_menu.getOptionNumber();
        System.out.println("You entered " + choice );*/
        
        //PART2
        /*
        Menu m = new Menu(); // no messages, no prompts, no options
        // read an integer
        int number1 = m.getOptionNumber();
        System.out.println("You entered " + number1);
        System.out.println("----------------------");
        // introduce bottom prompt
        m.setBottomPrompt("Enter an integer for bottom prompt: ");
        // read an integer
        int number2 = m.getOptionNumber();
        System.out.println("You entered " + number2);
        System.out.println("----------------------");*/
        
        //PART3
        
        // remove bottom prompt
        /*m.setBottomPrompt(null);
        m.setBottomMessage("Enter an integer for bottom message: ");
        int number3 = m.getOptionNumber();
        System.out.println("You entered " + number3);
        System.out.println("----------------------");
        */
        
        //PART4
        /*
        // introduce top message
        m.setTopMessage("*************************************************");
        // introduce top prompt
        m.setTopPrompt("An integer is even if it is twice another integer");
        // reset bottom message
        m.setBottomMessage("*************************************************");
        // intro bottom prompt
        m.setBottomPrompt("Enter an even integer: ");
        // read an integer
        int number4 = m.getOptionNumber();
        System.out.println("You entered " + number4);*/
        
    }
    
}
