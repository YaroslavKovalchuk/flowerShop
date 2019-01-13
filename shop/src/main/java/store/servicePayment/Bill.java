package main.java.store.servicePayment;

import main.java.goods.Goods;
import main.java.store.serviceDiscount.DiscountMethodFactory;

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
          sum = sum.add(g.getPrice());
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
