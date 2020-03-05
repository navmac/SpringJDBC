package com.sg.springjdbc1;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.sg.springjdbc1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{

    @Autowired
    DataSource dataSource;

    // call back method
    @PostConstruct
    private void initialize(){
        System.out.println("Now, setting the data source in initialize method");
        setDataSource(dataSource);
    }


    @Override
    public void insertEmployee(Employee emp) {

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)" ; // ? is a place holder
        getJdbcTemplate().update(sql, emp.getFirstName(),emp.getLastName(),emp.getPhoneNumber(), emp.getEmailId());
        System.out.println("Done inserting");
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee getEmployeeByName(String empName) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean deleteEmployeeByName(String empName) {
        String sql = "DELETE FROM employee WHERE FIRSTNAME='"+empName+"'" ; // ? is a place holder
        System.out.println("Going to fire this SQL NOW: "+sql);
        System.out.println("Currently in deleteEmployeeByName dao method");
        if (getJdbcTemplate().update(sql) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}
