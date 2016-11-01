/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_40002383;

import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class A3_Q1_40002383 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

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

        System.out.println("\t----------------------------------------------");
        System.out.println("\tDo you want to write a poem? Lets get started!");
        System.out.println("\t----------------------------------------------");

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
        //getting true length
        if (nouns.length > adj.length) {
            maxRunCount = (adj.length) / 3;
        } else if (adj.length >= nouns.length) {
            maxRunCount = (nouns.length) / 3;
        }
        //shuffling arrays
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
        } while (repeat == 'y');
    }
}
