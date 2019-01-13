package main.java.store.servicePaymentStrategy;

import java.math.BigDecimal;

public interface PaymentMethod {

    void pay(BigDecimal money);

}
