//------------------------------------
// Assignment 3 - Question 1
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package a3_40002383;

import java.util.Scanner;

/*

    This program will ask the user to input sets of nouns and adjectives. (min 3 per word types)
    The program will shuffle the inputs and then output 3-line poems without repeating any value.
    The user is then prompted if he/she wants to continue to display for poems of terminate the program.

 */

public class A3_Q1_40002383 {

    public static void main(String[] args) {

        //Variable Declaration
        Scanner input = new Scanner(System.in);
        int nounNum;
        int adjNum;
        String[] nouns;
        String[] adj;

        int runCount = 0;
        int maxRunCount = 0;
        int lineIndex = 0;
        char repeat;
        String temp;
        int randomNum;

        // Welcome message.
        System.out.println("\t----------------------------------------------");
        System.out.println("\tDo you want to write a poem? Lets get started!");
        System.out.println("\t----------------------------------------------");
        
        // Asks user for inputs (nouns & adjectives) up to the number of the numbers of inputs instructed (min 3 each)
        System.out.println("How many nouns ? min 3");
        nounNum = input.nextInt();
        while (nounNum < 3) {
            System.out.println("How many nouns ? min 3");
            nounNum = input.nextInt();
        }
        nouns = new String[nounNum];

        System.out.println("Enter " + nounNum + " nouns");
        for (int i = 0; i < nounNum; i++) {
            nouns[i] = input.next();
        }

        System.out.println("How many adjectives ? min 3");
        adjNum = input.nextInt();
        while (adjNum < 3) {
            System.out.println("How many adjectives ? min 3");
            adjNum = input.nextInt();
        }
        adj = new String[adjNum];

        System.out.println("Enter " + adjNum + " adjectives");
        for (int i = 0; i < adjNum; i++) {
            adj[i] = input.next();
        }
        
        /* 
            Get length of nouns/adjectives in order to determine how many times we can run poems of 3 lines without repeating any value.
            Calculated by dividing the numbers of nouns/adjectives by 3.
        */
        
        if (nouns.length > adj.length) {
            maxRunCount = (adj.length) / 3;
        } else if (adj.length >= nouns.length) {
            maxRunCount = (nouns.length) / 3;
        }
        
        /*
        
            Shuffling nouns and adjectives array by:
                -Taking a random noun/adjective.
                -Adding it to a temporary variable.
                -Change the value of i by the random value.
                -Finally change i by using the temp value.
            This method insures that no values will be duplicated and will be shuffled as instructed.
        
        */
        
        for (int i = 0; i < nouns.length; i++) {
            randomNum = (int) (Math.random() * nouns.length);
            temp = nouns[i];
            nouns[i] = nouns[randomNum];
            nouns[randomNum] = temp;
        }
        for (int i = 0; i < adj.length; i++) {
            randomNum = (int) (Math.random() * adj.length);
            temp = adj[i];
            adj[i] = adj[randomNum];
            adj[randomNum] = temp;
        }

        // Executes poem. Can repeat as many time as the value of maxRunCount. When maxRunCount is reached, shuffling will occur in the loop.
        do {
            System.out.println("\t------------------------------");
            System.out.println("\t\tHere is my Java POEM!!");
            System.out.println("\t\t****LOOK AROUND****");
            System.out.println("\t------------------------------\n");

            for (int i = 0; i < 3; i++) {
                System.out.print("\t");
                for (int j = 0; j < i; j++) {
                    System.out.print("\t");
                }
                System.out.println(adj[lineIndex].toUpperCase() + " " + nouns[lineIndex].toUpperCase());
                lineIndex++;
            }
            System.out.print("\n\nAnother Poem (y/n)? ");
            repeat = (input.next().charAt(0));
            runCount++;
            
            //shuffling arrays
            if (runCount == maxRunCount) {
                runCount = 0;
                lineIndex = 0;
                for (int i = 0; i < nouns.length; i++) {
                    randomNum = (int) (Math.random() * nouns.length);
                    temp = nouns[i];
                    nouns[i] = nouns[randomNum];
                    nouns[randomNum] = temp;
                }
                for (int i = 0; i < adj.length; i++) {
                    randomNum = (int) (Math.random() * adj.length);
                    temp = adj[i];
                    adj[i] = adj[randomNum];
                    adj[randomNum] = temp;
                }
            }
        } while (repeat == 'y'); // Asks user if he/she wants to repeat to display another poem.
    }
}
