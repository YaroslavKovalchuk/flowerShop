package main.java.store.servicePayment;

import java.math.BigDecimal;

public interface PaymentMethod {

    void pay(BigDecimal money);

}
