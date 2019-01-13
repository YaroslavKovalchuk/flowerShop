package main.java.store.serviceDiscount;

import java.math.BigDecimal;

public interface DiscountStrategy  {
    BigDecimal getFinalCost(BigDecimal cost);
}
