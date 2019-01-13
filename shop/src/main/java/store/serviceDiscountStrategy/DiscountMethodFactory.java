package main.java.store.serviceDiscountStrategy;

import java.math.BigDecimal;

public class DiscountMethodFactory {

    private DiscountStrategy strategy;
    private final BigDecimal sumForLowDiscount = new BigDecimal(1000.0);
    private final BigDecimal sumForHighDiscount = new BigDecimal(10000.0);

    public DiscountStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    //вибір знижки в залежності від загальної суми рахунку
    public BigDecimal applyDiscount(BigDecimal cost){

        if (sumForHighDiscount.compareTo(cost) < 1){
            setStrategy(new HighDiscountStrategy());
        }else if (sumForLowDiscount.compareTo(cost) < 1){
           setStrategy(new LowDiscountStrategy());
        }else setStrategy(new NoDiscountStrategy());

        return strategy.getFinalCost(cost);
    }
}
