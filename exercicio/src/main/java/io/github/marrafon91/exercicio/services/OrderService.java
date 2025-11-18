package io.github.marrafon91.exercicio.services;

import io.github.marrafon91.exercicio.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ShippingService shippingService;

    public double total(Order order) {
        double basicValue = order.getBasic() - order.getDiscount();
        double shippingFee = shippingService.shipment(order);
        return basicValue + shippingFee;
    }
}