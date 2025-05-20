package com.dbiazon.vendas;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbiazon.vendas.entities.Order;
import com.dbiazon.vendas.services.OrderService;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner {

	private OrderService orderService;

	public VendasApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order = new Order(1034, 150.0, 20.0);
		orderService.createOrder(order);

		Order order2 = new Order(2282, 800.0, 10.0);
		orderService.createOrder(order2);

		Order order3 = new Order(1309, 95.90, 0.0);
		orderService.createOrder(order3);

		List<Order> listOrder = orderService.findAllOrder();

		for (Order orderAll : listOrder) {
			System.out.println("____________________________");
			System.out.println("");
			System.out.println("Saída do primeiro produto");
			System.out.println("Pedido Código " + orderAll.getCode());
			System.out.println("Valor total: R$ " + orderService.total(orderAll));
			System.out.println("");
		}

	}

}
