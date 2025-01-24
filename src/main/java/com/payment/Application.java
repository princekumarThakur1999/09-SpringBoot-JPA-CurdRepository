package com.payment;

import com.payment.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

       ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        //employeeService.addEmployee();
        employeeService.addEmployees();
        //employeeService.deleteEmployee();

        employeeService.findEmployee();
    }

}
