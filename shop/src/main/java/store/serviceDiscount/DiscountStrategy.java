package store.serviceDiscount;

import java.math.BigDecimal;

public interface DiscountStrategy  {
    public BigDecimal getFinalCost(BigDecimal cost);
}
