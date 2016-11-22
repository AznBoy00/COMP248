//------------------------------------
// Assignment 3 - Question 3
// Written by: Kevin Lin - 4002383
// For COMP 248 Section Q - Fall 2016   
//------------------------------------

package a3_40002383;

/*

    This is the class used for Question 3 where several methods are set in order to give a value in which the main class demands.

 */
public class Scale {
    // Variable initializtion.
    private double weight;
    private String unit;

    // unit is set to kg by default in most cases.
    // Scale constructor used without accepting any value.
    public Scale() {
        this.weight = 0.0;
        this.unit = "kg";
    }
    
    // Scale constructor used by accepting a double value in which sets the weight in kg.
    public Scale(double weight) {
        this.weight = weight;
        this.unit = "kg";
    }
    
    // Scale constructor used by accepting a double value for weight, and String value for unit assuming the user will input "kg" or "lbs".
    public Scale(double weight, String unit) {
        this.weight = weight;
        this.unit = unit;
    }

    // double method that will return the weight of a define object in kg.
    public double getWeightKg() {
        if (this.unit.equals("kg")) {
            return weight;
        } else {
            return Math.round(weight / 2.2); // conversion formula.
        }
    }
    
    // double method that will return the weight of a define object in lbs.
    public double getWeightLbs() {
        if (this.unit.equals("lbs")) {
            return weight;
        } else {
            return Math.round(weight * 2.2); // conversion formula.
        }
    }

    // Method that will set the weight of an object by accepting a double for weight.
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    // Method that will set the weight of an object by accepting a double for weight and a String for unit (Assuming String will be "kg" or "lbs").
    public void setWeightAndUnit(double weight, String unit) {
        this.weight = weight;
        this.unit = unit;
    }
    
    // Method that will return an integer by calculating the number of cups of water the defined object should intake.
    public int waterIntake() {
        int cups;
        cups = (int)((getWeightLbs()/2)/8);
        return cups;
    }
    
    // Method that will return an integer by calculating the extra number of cups of water the defined object should intake by accepting an integer for minutes.
    public int waterIntake(int minutes) {
        int cups;
        double oz;
        oz = (minutes / 30.0) * 12.0;
        cups = (int)Math.round(oz / 8);
        return cups;
    }

    // @Override method used in order to display the proper String instructed by the asssignment question.
    @Override
    public String toString() {
        return weight + " " + unit;
    }

    // @Override method used in order to compare an object with another one in order to execute the proper checks instructed by the assignment question.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scale OTHER = (Scale) obj;
        if (this.getWeightKg() != OTHER.getWeightKg()) {
            return false;
        }
        return true;
    }
    
    // Method that will return a boolean by comparing a defined object (1) with another defined object (2) in the ().
    // Ex: Will return true if (1) is smaller than (2) -> (1<2).
    public boolean isLessThan(Scale s) {
        if (this.getWeightKg() < s.getWeightKg()) {
            return true;
        } else {
            return false;
        }
    }
    
    // Method that will return a boolean by comparing a defined object (1) with another defined object (2) in the ().
    // Ex: Will return true if (1) is bigger than (2) -> (1>2).
    public boolean isGreaterThan(Scale s) {
        if (this.getWeightKg() > s.getWeightKg()) {
            return true;
        } else {
            return false;
        }
    }

}
