package store.serviceDiscount;

import java.math.BigDecimal;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal getFinalCost(BigDecimal cost) {
        return cost;
    }
}
