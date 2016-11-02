/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_40002383;

import java.util.Objects;

/**
 *
 * @author Kevin
 */
public class Scale {
    private double weight;
    private String unit;

    public Scale() {
        this.weight = 0.0;
        this.unit = "kg";
    }
    
    public Scale(double weight) {
        this.weight = weight;
        this.unit = "kg";
    }
    
    public Scale(double weight, String unit) {
        this.weight = weight;
        this.unit = unit;
    }

    public double getWeightKg() {
        if (this.unit.equals("kg")) {
            return weight;
        } else {
            return Math.round(weight / 2.2);
        }
    }
    
    public double getWeightLbs() {
        if (this.unit.equals("lbs")) {
            return weight;
        } else {
            return Math.round(weight * 2.2);
        }
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void setWeightAndUnit(double weight, String unit) {
        this.weight = weight;
        this.unit = unit;
    }
    
    public int waterIntake() {
        int cups;
        cups = (int)((getWeightLbs()/2)/8);
        return cups;
    }
    
    public int waterIntake(int minutes) {
        int cups;
        double oz;
        oz = (minutes / 30.0) * 12.0;
        cups = (int)Math.round(oz / 8);
        return cups;
    }

    @Override
    public String toString() {
        return weight + " " + unit;
    }

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
        final Scale other = (Scale) obj;
        if (this.getWeightKg() != other.getWeightKg()) {
            return false;
        }
        return true;
    }
    
    public boolean isLessThan(Scale s) {
        if (this.getWeightKg() < s.getWeightKg()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isGreaterThan(Scale s) {
        if (this.getWeightKg() > s.getWeightKg()) {
            return true;
        } else {
            return false;
        }
    }

}
