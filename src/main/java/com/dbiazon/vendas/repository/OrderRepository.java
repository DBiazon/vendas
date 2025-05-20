package com.dbiazon.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbiazon.vendas.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	boolean  existsByCode(double code);
}
