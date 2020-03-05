package com.sg.springjdbc1;

import com.sg.springjdbc1.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void insertEmployee(Employee cus);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployeeByName(String empName);
    boolean deleteEmployeeByName(String empName);
}