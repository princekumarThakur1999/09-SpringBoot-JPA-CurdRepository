package com.payment.repo;

import com.payment.entity.Employee_Alacriti;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee_Alacriti, String> {

    List<Employee_Alacriti> findByFirstName(String firstName);

    @Query("from Employee_Alacriti where lastName= :lastName")
    List<Employee_Alacriti> getEmpByLastName(String lastName);
}
