package com.payment.repo;

import com.payment.entity.Employee_Alacriti;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee_Alacriti, String> {

}
