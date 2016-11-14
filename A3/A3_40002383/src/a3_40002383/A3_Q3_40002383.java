//------------------------------------
// Assignment 3 - Question 3
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package a3_40002383;

/*

    This program will display the values of the instructions below by using methods from another class. (Scale.java)

 */

public class A3_Q3_40002383 {
    public static void main(String[] args) {
        //Object declaration.
        Scale alvin = new Scale();
        Scale simon = new Scale(50.0);
        Scale theo = new Scale(110.0, "lbs");
        Scale dave = new Scale(110.0, "lbs");
        
        //Initial Data.
        System.out.println("Alvin's data: " + alvin.toString());
        System.out.println("Simon's data: " + simon.toString());
        System.out.println("Theo's data: " + theo.toString());
        
        //Some weights.
        System.out.printf("\nSimon's weight in pounds: %.1f\n", simon.getWeightLbs());
        System.out.printf("Theo's weight in kg: %.1f\n", theo.getWeightKg());
        System.out.println("Daily water intake for Simon " + simon.toString() + " = " + simon.waterIntake() + " cups");
        System.out.println("Daily water intake for Theo " + theo.toString() + " = " + theo.waterIntake() + " cups");
        System.out.println("Daily water intake for Simon " + simon.toString() + " and 90min workout= " + (simon.waterIntake() + simon.waterIntake(90)) + " cups");
        System.out.println("Daily water intake for Theo " + theo.toString() + " and 60min workout= " + (theo.waterIntake() + theo.waterIntake(60)) + " cups");
        
        //Equality test. True/False
        System.out.println("\nAlvin & Simon " + alvin.toString() + " & " + simon.toString() + " =? " + alvin.equals(simon));
        System.out.println("Simon & Theo " + simon.toString() + " & " + theo.toString() + " =? " + simon.equals(theo));
        
        //Sets new weight for Alvin, more equality test.
        alvin.setWeightAndUnit(50.0, "kg");
        System.out.println("\nAlvin's new data: " + alvin.toString());
        System.out.println("Alvin " + alvin.toString() + " Simon " + simon.toString() + " =? " + alvin.equals(simon));
        System.out.println("Theo " + theo.toString() + " & Alvin " + alvin.toString() + " =? " + theo.equals(alvin));
        
        //More equality tests.
        System.out.println("\nDave's data: " + dave.toString());
        System.out.println("Theo & Dave =? " + theo.toString() + " =? " + dave.toString() + " " + theo.equals(dave));
        System.out.println("Dave & Alvin =? " + dave.toString() + " =? " + alvin.toString() + " " + dave.equals(alvin));
        
        //Sets new weight for Dave then check for equality with Alvin.
        dave.setWeight(50.0);
        System.out.println("\nDave's data: " + dave.toString());
        System.out.println("Dave & Alvin =? " + dave.toString() + " =? " + alvin.toString() + " " + dave.equals(alvin));
        
        //Sets new weight for Alvin in kg then checks equality with Theo.
        alvin.setWeightAndUnit(110.0, "kg");
        System.out.println("\nAlvin's new data: " + alvin.toString());
        System.out.println("Theo & Alvin =? " + theo.toString() + " =? " + alvin.toString() + " " + theo.equals(alvin));
        
        //Various isLessThan(), isGreaterThan() class method tests.
        System.out.println("\nTheo < Alvin ? " + theo.toString() + " < " + alvin.toString() + " " + theo.isLessThan(alvin));
        System.out.println("Dave < Alvin ? " + dave.toString() + " < " + alvin.toString() + " " + dave.isLessThan(alvin));
        
        System.out.println("\nTheo > Alvin ? " + theo.toString() + " > " + alvin.toString() + " " + theo.isGreaterThan(alvin));
        System.out.println("Dave > Alvin ? " + dave.toString() + " > " + alvin.toString() + " " + dave.isGreaterThan(alvin));
        
        System.out.println("\nAlvin < Simon ? " + alvin.toString() + " < " + simon.toString() + " " + alvin.isLessThan(simon));
        System.out.println("Simon < Alvin ? " + simon.toString() + " < " + alvin.toString() + " " + simon.isLessThan(alvin));
    }
}
