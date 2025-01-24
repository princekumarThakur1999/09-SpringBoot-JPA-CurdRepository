package com.payment.service;

import com.payment.entity.Employee_Alacriti;
import com.payment.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo empRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.empRepo = employeeRepo;
    }

    public void addEmployee() {
        Employee_Alacriti employeeAlacriti = new Employee_Alacriti();
        employeeAlacriti.setEmployeeId("AL10001");
        employeeAlacriti.setFirstName("John");
        employeeAlacriti.setLastName("Doe");
        employeeAlacriti.setEmail("john.doe@gmail.com");
        employeeAlacriti.setPhoneNumber("+91 2353 232 233");
        employeeAlacriti.setCity("San Francisco");

        empRepo.save(employeeAlacriti);
    }

    public void addEmployees() {
        Employee_Alacriti employeeAlacriti1 = new Employee_Alacriti();

        employeeAlacriti1.setFirstName("Nick");
        employeeAlacriti1.setLastName("Doe");
        employeeAlacriti1.setEmail("Nicl.doe@gmail.com");
        employeeAlacriti1.setPhoneNumber("+91 233 232 233");
        employeeAlacriti1.setCity("San Francisco");

        Employee_Alacriti employeeAlacriti2 = new Employee_Alacriti();

        employeeAlacriti2.setFirstName("devid");
        employeeAlacriti2.setLastName("Doe");
        employeeAlacriti2.setEmail("devid.doe@gmail.com");
        employeeAlacriti2.setPhoneNumber("+91 2223 232 233");
        employeeAlacriti2.setCity("San Francisco");

        Employee_Alacriti employeeAlacriti3 = new Employee_Alacriti();

        employeeAlacriti3.setFirstName("Wick");
        employeeAlacriti3.setLastName("Doe");
        employeeAlacriti3.setEmail("Wick.doe@gmail.com");
        employeeAlacriti3.setPhoneNumber("+91 0293 232 233");
        employeeAlacriti3.setCity("San Francisco");

       List<Employee_Alacriti> emps = Arrays.asList(employeeAlacriti1, employeeAlacriti2, employeeAlacriti3);
        empRepo.saveAll(emps);
    }

    public void deleteEmployee() {
        empRepo.deleteAll();
    }

    public void findEmployee() {
        empRepo.findAll().forEach(System.out::println);

    }
}
