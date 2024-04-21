package services;

import entities.Order;

public class OrderService {
	
	private ShippingService taxShipping;

    public OrderService(ShippingService taxShipping) {
        this.taxShipping = taxShipping;
    }

    public double total(Order order) {
        return order.getBasic() * (1 - order.getDiscount() / 100d) + taxShipping.shipment(order);
    }

}
