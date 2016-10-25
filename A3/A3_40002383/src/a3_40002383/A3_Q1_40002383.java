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
        String [] nouns;
        int [] nounCheck;
        String [] adj;
        int [] adjCheck;
        
        int randomNoun;
        int randomAdj;
        
        char repeat;
        
        System.out.println("\t----------------------------------------------");
        System.out.println("\tDo you want to write a poem? Lets get started!");
        System.out.println("\t----------------------------------------------");
        
        System.out.println("How many nouns ? min 3");
        nounNum= input.nextInt();
        while (nounNum < 3) {
            System.out.println("How many nouns ? min 3");
            nounNum= input.nextInt();
        }
        nouns = new String [nounNum];
        nounCheck = new int [nounNum];
        for (int i = 0; i < nounNum; i++) {
            nounCheck [i] = 0;
        }
        
        System.out.println("Enter " + nounNum + " nouns");
        for (int i = 0; i < nounNum; i++) {
            nouns [i] = input.next();
        }    
        
        System.out.println("How many adjectives ? min 3");
        adjNum = input.nextInt();
        while (adjNum < 3) {
            System.out.println("How many adjectives ? min 3");
            adjNum= input.nextInt();
        }
        adj = new String [adjNum];
        adjCheck = new int [adjNum];
        for (int i = 0; i < adjNum; i++) {
            adjCheck [i] = 0;
        }
        
        System.out.println("Enter " + adjNum + " adjectives");
        for (int i = 0; i < adjNum; i++) {
            adj [i] = input.next();
        }
        
        System.out.println("\t------------------------------");
        System.out.println("\t\tHere is my Java POEM!!");
        System.out.println("\t\t****LOOK AROUND****");
        System.out.println("\t------------------------------\n");
        
        for (int i = 0; i < 9; i++) {    
            randomAdj = (int)(Math.random()*adjNum);
            randomNoun = (int)(Math.random()*nounNum);
            while (adjCheck[randomAdj] == 1) {
                randomAdj = (int)(Math.random()*adjNum);
            }
            while (nounCheck[randomNoun] == 1) {
                randomNoun = (int)(Math.random()*nounNum);
            }
            adjCheck [randomAdj] = 1;
            nounCheck [randomNoun] = 1;
            
            System.out.print("\t");
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println(adj[randomAdj].toUpperCase() + " " + nouns[randomNoun].toUpperCase());
        }
        
        System.out.print("\n\nAnother Poem (y/n)? ");
        repeat = (input.next().charAt(0));
        
        while (repeat == 'y') {
            System.out.println("\t------------------------------");
            System.out.println("\t\tHere is my Java POEM!!");
            System.out.println("\t\t****LOOK AROUND****");
            System.out.println("\t------------------------------\n");
            
            System.out.println("\n\t" + adj[(int)(Math.random()*adjNum)].toUpperCase() + " " + nouns[(int)(Math.random()*nounNum)].toUpperCase());
            System.out.println("\t\t" + adj[(int)(Math.random()*adjNum)].toUpperCase() + " " + nouns[(int)(Math.random()*nounNum)].toUpperCase());
            System.out.println("\t\t\t" + adj[(int)(Math.random()*adjNum)].toUpperCase() + " " + nouns[(int)(Math.random()*nounNum)].toUpperCase());
            
            System.out.print("\n\nAnother Poem (y/n)? ");
            repeat = (input.next().charAt(0));
        }       
        
    }
    
}
