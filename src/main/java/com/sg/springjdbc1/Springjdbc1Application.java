package com.sg.springjdbc1;

import com.sg.springjdbc1.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springjdbc1Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Springjdbc1Application.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        Employee e1 = new Employee("Kamal","Selva",32332,"kamal@g.com");
        employeeService.deleteEmployeeByName("Kamal");
    }

}
