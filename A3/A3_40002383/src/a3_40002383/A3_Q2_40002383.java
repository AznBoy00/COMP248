//------------------------------------
// Assignment 3 - Question 2
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package a3_40002383;

import java.util.Scanner;

/*

    This program prompts the user to input the number of ticket(s) he/she wants to book.
    The user will then input the seat values depending on the amount of tickets he/she wants to book and will inform the user about the cost of the seats.
    The process will repeat when all the seats will be booked or if the user decides not to make more booking(s).

 */
public class A3_Q2_40002383 {
    
    public static void main (String[] args) {
        //Variable initialization
        Scanner input = new Scanner(System.in);
        char[][] seats = new char[6][7];
        int availableSeats = 42;
        int ticketAmount;
        String seatLetter;
        double balance;
        String rebook = "y";
        
        //Initialize empty seats.
        for (int i = 0; i < 6; i++) {
            seats [i][0] = 'A';
            seats [i][1] = 'B';
            seats [i][2] = 'C';
            seats [i][3] = 'D';
            seats [i][4] = 'E';
            seats [i][5] = 'F';
            seats [i][6] = 'G';
        }
        
        //Welcome message.
        System.out.println("-----------------------------------------------");
        System.out.println("--------COMP248 Concert IS BACK IN TOWN--------");
        System.out.println("\t  Hurry book your ticket Now!!");
        System.out.println("-----------------------------------------------\n");
        
        showSeats(seats);
        
        System.out.println("\nRows 1 & 2 Gold 100 CAD/ticket");
        System.out.println("Rows 3 & 4 Silver 70 CAD/ticket");
        System.out.println("Rows 5 & 6 Bronze 40 CAD/ticket");
        
        do {
            //Reset balance on every new booking.
            balance = 0.0;
            
            System.out.println("How many tickets do you need?");
            ticketAmount = input.nextInt();
            
            //Check for legal amount of bookable tickets.
            if ((availableSeats - ticketAmount) < 0) {
                System.out.println("Available seats " + availableSeats);
                System.out.println("Sorry cannot process your request");
                System.out.println("No more seat are available");
                break;
            }
            
            System.out.println("Available seats " + availableSeats);
            availableSeats = availableSeats - ticketAmount;
            
            //Will ask the user to enter the seat letters depending on how many tickets he decides to purchase. (loop)
            for (int i = 0; i < ticketAmount; i++) {
                System.out.println("Input your seat selection");
                System.out.println("Enter the row number and then the seat letter (example: 3B)");
                seatLetter = input.next();
                while (isNotAvailable(seatLetter, seats)) {
                    System.out.println("Input your seat selection");
                    System.out.println("Enter the row number and then the seat letter (example: 3B)");
                    seatLetter = input.next();
                }
                
                //Parse in integer for first[], second[] -65 to its value to determine the numerical value in int in order to locate the array point.
                seats[Integer.parseInt(seatLetter.substring(0,1)) - 1][(int)(seatLetter.charAt(1) - 65)] = 'X';
                balance += getSeatCost(seatLetter);
                
                //Will display 1 decimal number.
                System.out.printf("Your seat is reserved. Your balance is %.2f\n", balance);
                showSeats(seats);
            }
            System.out.println("Reservation complete! Please proceed to payment");
            
            //Rebook tickets (y/n).
            System.out.println("Do you wish to start a new booking? (y/n)?");
            rebook = input.next();
        } while (rebook.charAt(0) == 'y');
        
        System.out.println("Thank you for choosing our reservation system!!");

    }
    
    //Method will show/draw the seats according to the 2D array.
    private static void showSeats(char[][] seats) {
        for (int i = 0; i < 6; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < 7; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //Determine seat cost by a switch statement, default is 0.0 assuming that there will be no other exception.
    private static double getSeatCost(String seatLetter) {
        switch (seatLetter.charAt(0)) {
            case '1':
            case '2':
                return 100.0;
            case '3':
            case '4':
                return 70.0;
            case '5':
            case '6':
                return 40.0;
            default :
                return 0.0;
        }
    }
    
    //Boolean method will return a boolean according to the conditions met. TRUE = error in seat assignment, FALSE = seat is eligible to be assigned as 'X'
    private static boolean isNotAvailable(String seatLetter, char[][] seats) {
        if (seatLetter.length() != 2) {
            System.out.println("Invalid Seat assignment");
            return true;
        } else if (seatLetter.charAt(0) < '1' || seatLetter.charAt(0) > '6') {
            System.out.println("Invalid row number -try again");
            return true;
        } else if (seatLetter.charAt(1) < 'A' || seatLetter.charAt(1) > 'G') {
            System.out.println("Invalid Seat letter - try again");
            return true;
        } else if (seats[Integer.parseInt(seatLetter.substring(0,1))-1][(int)(seatLetter.charAt(1) - 65)] == 'X') {
            System.out.println("Sorry seat is not available");
            return true;
        } else {
            return false;
        }
    }
}