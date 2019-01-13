package main.java.store.serviceDiscountStrategy;

import java.math.BigDecimal;

public class LowDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal getFinalCost(BigDecimal cost) {
        return  cost.subtract(cost.multiply(BigDecimal.valueOf(0.1)));
    }
}
