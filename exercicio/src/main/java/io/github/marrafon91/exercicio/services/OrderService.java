package io.github.marrafon91.exercicio.services;

import io.github.marrafon91.exercicio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private  ShippingService shippingService;

    public double total(Order order) {
        double discountAmount = order.getBasic() * order.getDiscount() / 100;
        double basicValue = order.getBasic() - discountAmount;
        double shippingFee = shippingService.shipment(order);
        return basicValue + shippingFee;
    }
}