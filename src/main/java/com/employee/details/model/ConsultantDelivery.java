package com.employee.details.model;

import javax.persistence.*;
import java.util.List;



public class ConsultantDelivery extends Employee {


    private String consultingLevel;


    private List<String> leadProjects;

    // Constructors
    public ConsultantDelivery() {}

    public ConsultantDelivery(String consultingLevel, List<String> leadProjects) {
        this.consultingLevel = consultingLevel;
        this.leadProjects = leadProjects;
    }

    // Getters and setters
    public String getConsultingLevel() {
        return consultingLevel;
    }

    public void setConsultingLevel(String consultingLevel) {
        this.consultingLevel = consultingLevel;
    }

    public List<String> getLeadProjects() {
        return leadProjects;
    }

    public void setLeadProjects(List<String> leadProjects) {
        this.leadProjects = leadProjects;
    }

    // toString method
    @Override
    public String toString() {
        return "ConsultantDelivery{" +
                "consultingLevel='" + consultingLevel + '\'' +
                ", leadProjects=" + leadProjects +
                "} " + super.toString();
    }
}
