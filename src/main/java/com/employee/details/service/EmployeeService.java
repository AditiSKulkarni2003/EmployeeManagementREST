package com.employee.details.service;

import com.employee.details.model.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EmployeeService {

    @PersistenceContext(unitName = "employeePU")
    private EntityManager entityManager;
    public List<Employee> getAllEmployees() {

        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM com.employee.details.model.Employee e ", Employee.class);
        List<Employee> employees = query.getResultList();

        return employees != null ? employees :  new ArrayList<Employee>();
    }


    public Employee getEmployeeById(int empId) {
        return entityManager.find(Employee.class, empId);
    }

    // Create a new employee
    public Employee createEmployee(Employee employee) {
        entityManager.merge(employee);
        return employee;
    }

    // Update an existing employee
    public Employee updateEmployee(int empId, Employee updatedEmployee) {
        Employee existingEmployee = entityManager.find(Employee.class, empId);
        if (existingEmployee != null) {
            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            // Add setters for any other fields you want to update
            entityManager.merge(existingEmployee);
            return existingEmployee;
        }
        return null;
    }


    public boolean deleteEmployee(int empId) {
        Employee employee = entityManager.find(Employee.class, empId);
        if (employee != null) {
            entityManager.remove(employee);
            return true;
        }
        return false;
    }
}
