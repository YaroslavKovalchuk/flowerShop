package main.java.store.serviceDiscountStrategy;

import java.math.BigDecimal;

public interface DiscountStrategy  {
    BigDecimal getFinalCost(BigDecimal cost);
}
