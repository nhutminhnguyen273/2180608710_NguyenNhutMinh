package com.hutech.Buoi222.repository;

import com.hutech.Buoi222.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
