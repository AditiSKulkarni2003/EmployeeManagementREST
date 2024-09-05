package com.employee.details.service;

import com.employee.details.model.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class EmployeeService {

    @PersistenceContext(unitName = "employeePU")
    private EntityManager entityManager;

    public Employee getEmployee(Long id) {
        return entityManager.find(Employee.class, id);
    }
    public List<Employee> getAllEmployees() {

        String sql = "SELECT * FROM employee";
        Query query = entityManager.createNativeQuery(sql, Employee.class);
       // TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees = query.getResultList();
//       for(Employee employee : employees) {
//           System.out.println(employee.toString());
//       }
        System.out.println("Fetched employees: " + employees);
        return employees;
       // return query.getResultList();
    }
}
