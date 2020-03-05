package com.sg.springjdbc1;

import com.sg.springjdbc1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDaoImpl employeeDao;

    @Override
    public void insertEmployee(Employee emp) {
        // this needs to call the EmployeeDAO's insertEmployee() method
        employeeDao.insertEmployee(emp);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        // TODO Auto-generated method stub
    }

    @Override
    public void getAllEmployees() {
        // TODO Auto-generated method stub
    }

    @Override
    public String deleteEmployeeByName(String empName) {
        boolean isSuccess=employeeDao.deleteEmployeeByName(empName);
        if (isSuccess)
            return empName+" has been successfully deleted from the table";
        else
            return "no such employee found "+empName;
    }

    @Override
    public void getEmployeeByName(String empName) {
        // TODO Auto-generated method stub
    }
}

