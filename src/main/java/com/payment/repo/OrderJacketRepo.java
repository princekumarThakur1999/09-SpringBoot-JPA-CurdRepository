package com.payment.repo;

import com.payment.entity.OrderJacket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJacketRepo extends JpaRepository<OrderJacket, Integer> {
}
