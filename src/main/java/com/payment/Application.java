package com.payment;

import com.payment.entity.Employee_Alacriti;
import com.payment.entity.OrderJacket;
import com.payment.repo.OrderJacketRepo;
import com.payment.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

       ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        //employeeService.addEmployee();
       // employeeService.addEmployees();
        //employeeService.deleteEmployee();

       // employeeService.findEmployee();

        //Non Primary column value fetch
        //If we use Optional class it's reducing null pointer exception becs if employeeAlacrity entity class will not fetch from db then employeeAlacrity obj will store null value, Optional value is not throwing null pointer exception
//        for (Employee_Alacriti employeeAlacriti : employeeService.findEmpByFirstName("Nick")) {
//
//            System.out.println(employeeAlacriti.getFirstName() + " " + employeeAlacriti.getLastName());
//        }
//
//        //custum query execute and fetch the employee details
//        for (Employee_Alacriti employeeAlacriti : employeeService.getEmpByLastName("Doe")) {
//
//            System.out.println(employeeAlacriti.getFirstName() + " " + employeeAlacriti.getLastName() + " " +employeeAlacriti.getCity());
//        }

       // employeeService.getEmpbySort("firstName");

        //pageno = first page (1) and pagesize = each page how many content should populate 3 contant
       // employeeService.getEmpbyPagination(1,3);

       // employeeService.getEmpsbyQBE();

        //Generative Values for entity primary column values
        OrderJacketRepo contextBean = context.getBean(OrderJacketRepo.class);

        OrderJacket orderJacket = new OrderJacket();
        orderJacket.setJacketName("Rare Rabbit");
        orderJacket.setJacketSize("XL");
        orderJacket.setJacketPrice("1500.00");

        contextBean.save(orderJacket);

    }



}
