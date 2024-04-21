package services;

import entities.Order;

public class ShippingService {
	
	 public Double shipment(Order order) {

	        double taxShipment;

	        if (order.getBasic() < 100.00) {
	            taxShipment = 20.00;
	        } else if (order.getBasic() < 200.00) {
	            taxShipment = 12.00;
	        } else {
	            taxShipment = 0.00; // Frete grátis
	        }

	        return taxShipment;
	    }

}
