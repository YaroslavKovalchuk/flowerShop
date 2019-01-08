package goods;

import java.math.BigDecimal;

public class Good {
    private int id;
    private Product goods;

    public Good(int id, Product good) {
        this.id = id;
        this.goods = good;
    }


    public int getId() {
        return id;
    }

    public Product getGood() {
        return goods;
    }

    public void setGood(Product good) {
        this.goods = good;
    }

    public String getName() {
        return goods.getName();
    }

    public BigDecimal getPrice() {
        return goods.getPrice();
    }
}
