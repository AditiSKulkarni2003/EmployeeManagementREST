package com.employee.details.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Manager extends Employee {


    private String teamSize;


    private String location;

    // Constructors
    public Manager() {}

    public Manager(String teamSize, String location) {
        this.teamSize = teamSize;
        this.location = location;
    }

    // Getters and setters
    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString method
    @Override
    public String toString() {
        return "Manager{" +
                "teamSize=" + teamSize +
                ", location='" + location + '\'' +
                "} " + super.toString();
    }
}
