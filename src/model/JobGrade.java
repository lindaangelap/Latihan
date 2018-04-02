/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;

/**
 *
 * @author hp
 */
public class JobGrade {
    private String gradelevel;
    private int lowestSalary;
    private int highestSalary;

    public String getGradelevel() {
        return gradelevel;
    }

    public JobGrade() {
    }
    
    public JobGrade(String gradelevel, int lowestSalary, int highestSalary) {
        this.gradelevel = gradelevel;
        this.lowestSalary = lowestSalary;
        this.highestSalary = highestSalary;
    }
    
    public void setGradelevel(String gradelevel) {
        this.gradelevel = gradelevel;
    }

    public int getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(int lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public int getHighestSalary() {
        return highestSalary;
    }

    public void setHighestSalary(int highestSalary) {
        this.highestSalary = highestSalary;
    }
    
    
}




