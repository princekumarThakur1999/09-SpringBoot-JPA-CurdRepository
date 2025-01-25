package com.payment.repo;

import com.payment.entity.Employee_Alacriti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlacEmpRepo extends JpaRepository<Employee_Alacriti, String> {
}
