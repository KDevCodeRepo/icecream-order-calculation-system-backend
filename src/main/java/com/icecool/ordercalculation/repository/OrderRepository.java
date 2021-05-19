package com.icecool.ordercalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icecool.ordercalculation.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
