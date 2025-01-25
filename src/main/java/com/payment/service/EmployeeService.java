package com.payment.service;

import com.payment.entity.Employee_Alacriti;
import com.payment.repo.AlacEmpRepo;
import com.payment.repo.EmployeeRepo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo empRepo;
    
    private AlacEmpRepo alacEmpRepo;
    
    public EmployeeService(EmployeeRepo employeeRepo, AlacEmpRepo alacEmpRepo) {
        this.empRepo = employeeRepo;
        this.alacEmpRepo = alacEmpRepo;
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

    public List<Employee_Alacriti> findEmpByFirstName(String firstName) {

        List<Employee_Alacriti> employeeAlacriti = empRepo.findByFirstName(firstName);

        System.out.println(employeeAlacriti);
        return employeeAlacriti;
    }

    //custom query --> HQL query
    public List<Employee_Alacriti> getEmpByLastName(String lastName) {
        List<Employee_Alacriti> employeeAlacriti = empRepo.getEmpByLastName(lastName);

        System.out.println(employeeAlacriti);
        return employeeAlacriti;
    }

    //by column sorting getting details
    public void getEmpbySort(String Emp_alacriti_column) {

        Sort column = Sort.by(Emp_alacriti_column).descending();
        List<Employee_Alacriti> emps = alacEmpRepo.findAll(column);

        emps.forEach(employeeAlacriti -> System.out.println(employeeAlacriti.getEmployeeId() +" "+employeeAlacriti.getFirstName() + " " +employeeAlacriti.getLastName()+ " " +employeeAlacriti.getEmail()));

    }

    //pagination
    public void getEmpbyPagination(int pageNo, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize-1);
        Page<Employee_Alacriti> pageObj = alacEmpRepo.findAll(pageRequest);

        List<Employee_Alacriti> emps = pageObj.getContent();

        emps.forEach(e -> System.out.println(e.getEmployeeId() +" "+e.getFirstName() + " " +e.getLastName() + " " +e.getEmail()));
    }

    //QBE -> Query by example  --> this query will be created dynamically at runtime  (if we want to create query dynamically then we have to use this)
    public void getEmpsbyQBE() {
        //create emp obje
        Employee_Alacriti employeeAlacriti = new Employee_Alacriti();
        employeeAlacriti.setCity("San Francisco"); //setcity type

        Example<Employee_Alacriti> of = Example.of(employeeAlacriti); //create example obj of emp obj

        //findAll emps whose city san francisco
        for (Employee_Alacriti employee_alacriti : alacEmpRepo.findAll(of)) {
            System.out.println(employee_alacriti.getEmployeeId() + ""+employee_alacriti.getFirstName() + " " +employee_alacriti.getLastName() + " "+employee_alacriti.getEmail() +" "+employee_alacriti.getPhoneNumber());
        }

    }

}

