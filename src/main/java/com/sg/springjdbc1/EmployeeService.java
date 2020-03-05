package com.sg.springjdbc1;

import com.sg.springjdbc1.model.Employee;

import java.util.List;

public interface EmployeeService {
    void insertEmployee(Employee emp);
    void insertEmployees(List<Employee> employees);
    void getAllEmployees();
    void getEmployeeByName(String empName);
    public String deleteEmployeeByName(String empName);
}
