package com.dbiazon.vendas.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbiazon.vendas.entities.Order;
import com.dbiazon.vendas.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private ShippingService shippingService;

	public OrderService(ShippingService shippingService, OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
		this.shippingService = shippingService;
	}

	@Transactional(readOnly = true)
	public List<Order> findAllOrder() {

		List<Order> listOrder = orderRepository.findAll();

		return listOrder;
	}

	@Transactional
	public Order createOrder(Order order) {

		if (!codeOrder(order.getCode())) {
			return orderRepository.save(order);
		}
		return order;
	}

	public double total(Order order) {

		double shipmentOrder = this.shippingService.shipment(order);

		double basicOrder = order.getBasic();
		double discount = order.getDiscount();
		double basicOrderFinal = basicOrder - (basicOrder * (discount / 100));

		double finalValue = basicOrderFinal + shipmentOrder;

		return finalValue;
	}

	public boolean codeOrder(double code) {
		return orderRepository.existsByCode(code);
	}
}
