package com.employee.details.model;

import javax.persistence.*;
import java.util.List;

public class AssociateConsultantDelivery extends Employee {


    private List<String> skillSet;


    private String projectRole;


    private String reportsTo;


    public AssociateConsultantDelivery() {}

    public AssociateConsultantDelivery(List<String> skillSet, String projectRole,String reportsTo) {
        this.skillSet = skillSet;
        this.projectRole = projectRole;
        this.reportsTo = reportsTo;
    }

    // Getters and setters
    public List<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<String> skillSet) {
        this.skillSet = skillSet;
    }

    public String getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(String projectRole) {
        this.projectRole = projectRole;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    // toString method
    @Override
    public String toString() {
        return "AssociateConsultantDelivery{" +
                "skillSet=" + skillSet +
                ", projectRole='" + projectRole + '\'' +
                ", reportsTo=" + reportsTo +
                "} " + super.toString();
    }
}
