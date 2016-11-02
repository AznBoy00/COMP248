/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_40002383;

/**
 *
 * @author Kevin
 */
public class A3_Q3_40002383 {
    public static void main(String[] args) {
        //Object declaration
        Scale alvin = new Scale();
        Scale simon = new Scale(50.0);
        Scale theo = new Scale(110.0, "lbs");
        Scale dave = new Scale(110.0, "lbs");
        
        System.out.println("Alvin's data: " + alvin.toString());
        System.out.println("Simon's data: " + simon.toString());
        System.out.println("Theo's data: " + theo.toString());
        
        System.out.printf("\nSimon's weight in pounds: %.1f\n", simon.getWeightLbs());
        System.out.printf("Theo's weight in kg: %.1f\n", theo.getWeightKg());
        System.out.println("Daily water intake for Simon " + simon.toString() + " = " + simon.waterIntake() + " cups");
        System.out.println("Daily water intake for Theo " + theo.toString() + " = " + theo.waterIntake() + " cups");
        System.out.println("Daily water intake for Simon " + simon.toString() + " and 90min workout= " + (simon.waterIntake() + simon.waterIntake(90)) + " cups");
        System.out.println("Daily water intake for Theo " + theo.toString() + " and 60min workout= " + (theo.waterIntake() + theo.waterIntake(60)) + " cups");
        
        System.out.println("\nAlvin & Simon " + alvin.toString() + " & " + simon.toString() + " =? " + alvin.equals(simon));
        System.out.println("Simon & Theo " + simon.toString() + " & " + theo.toString() + " =? " + simon.equals(theo));
        
        alvin.setWeightAndUnit(50.0, "kg");
        System.out.println("\nAlvin's new data: " + alvin.toString());
        System.out.println("Alvin " + alvin.toString() + " Simon " + simon.toString() + " =? " + alvin.equals(simon));
        System.out.println("Theo " + theo.toString() + " & Alvin " + alvin.toString() + " =? " + theo.equals(alvin));
        
        System.out.println("\nDave's data: " + dave.toString());
        System.out.println("Theo & Dave =? " + theo.toString() + " =? " + dave.toString() + " " + theo.equals(dave));
        System.out.println("Dave & Alvin =? " + dave.toString() + " =? " + alvin.toString() + " " + dave.equals(alvin));
        
        dave.setWeight(50.0);
        System.out.println("\nDave's data: " + dave.toString());
        System.out.println("Dave & Alvin =? " + dave.toString() + " =? " + alvin.toString() + " " + dave.equals(alvin));
        
        alvin.setWeightAndUnit(110.0, "kg");
        System.out.println("\nAlvin's new data: " + alvin.toString());
        System.out.println("Theo & Alvin =? " + theo.toString() + " =? " + alvin.toString() + " " + theo.equals(alvin));
        
        System.out.println("\nTheo < Alvin ? " + theo.toString() + " < " + alvin.toString() + " " + theo.isLessThan(alvin));
        System.out.println("Dave < Alvin ? " + dave.toString() + " < " + alvin.toString() + " " + dave.isLessThan(alvin));
        
        System.out.println("\nTheo > Alvin ? " + theo.toString() + " > " + alvin.toString() + " " + theo.isGreaterThan(alvin));
        System.out.println("Dave > Alvin ? " + dave.toString() + " > " + alvin.toString() + " " + dave.isGreaterThan(alvin));
        
        System.out.println("\nAlvin < Simon ? " + alvin.toString() + " < " + simon.toString() + " " + alvin.isLessThan(simon));
        System.out.println("Simon < Alvin ? " + simon.toString() + " < " + alvin.toString() + " " + simon.isLessThan(alvin));
    }
}
