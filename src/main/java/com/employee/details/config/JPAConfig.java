package com.employee.details.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAConfig {

    public static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("employeePU");
    }
}