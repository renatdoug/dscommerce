package app;

import entities.Order;
import services.OrderService;
import services.ShippingService;

public class Program {

	public static void main(String[] args) {

		// Criando um objeto Order
        Order order = new Order(2282, 800.00, 10.0); // Código 1, valor básico de R$ 150.00 com desconto de 10%

        // Criando uma instância de ShippingService
        ShippingService shippingService = new ShippingService();

        // Criando uma instância de OrderService com o ShippingService
        OrderService orderService = new OrderService(shippingService);

        // Calculando o total do pedido
        double totalPedido = orderService.total(order);

        // Exibindo o total do pedido
        System.out.println("Pedido código " + order.getCode());
        System.out.printf("Total do pedido: R$ %.2f%n", totalPedido);

	}

}
