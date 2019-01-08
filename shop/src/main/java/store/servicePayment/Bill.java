package store.servicePayment;

import database.GoodDB;
import goods.Goods;
import store.serviceDiscount.DiscountMethodFactory;
import store.serviceDiscount.HighDiscountStrategy;
import store.serviceDiscount.LowDiscountStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<Goods> lineItems = new ArrayList<>();
    private  BigDecimal sum = new BigDecimal(0);
    private DiscountMethodFactory discountMethodFactory = new DiscountMethodFactory();

    public Bill addLineItem(Goods lineItem){
        lineItems.add(lineItem);
        return this;
    }

    public void removeLineItem(Goods lineItem){
        lineItems.remove(lineItem);
    }

    public BigDecimal getCost(){
        for (Goods g:lineItems) {
            sum.add(g.getPrice());
        }
        return discountMethodFactory.applyDiscount(sum);
    }

    public Bill pay(PaymentMethod method){
        method.pay(getCost());
        for (Goods g:lineItems)
        lineItems = null;
        return this;
    }

}
