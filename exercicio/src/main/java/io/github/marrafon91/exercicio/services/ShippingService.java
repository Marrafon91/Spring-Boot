package io.github.marrafon91.exercicio.services;

import io.github.marrafon91.exercicio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipment(Order order) {
        
        double shippingFee = order.getBasic() - order.getDiscount();

        if (shippingFee <= 100.0) {
            return 20.0;
        } else if (shippingFee <= 200) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
}

