package com.dbiazon.vendas.entities.dtos;

import com.dbiazon.vendas.entities.Order;

public record OrderResponseDTO(Long id, double basic, double discount) {

	public OrderResponseDTO(Order order) {
		this(order.getId(), order.getBasic(), order.getDiscount());
	}
}
