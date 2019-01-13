package main.java.store.servicePaymentStrategy;

import java.math.BigDecimal;

public class Cash implements PaymentMethod{

    @Override
    public void pay(BigDecimal money) {
        System.out.println("Payed " + money + " using " + toString());
    }

    @Override
    public String toString() {
        return "Cash";
    }
}
