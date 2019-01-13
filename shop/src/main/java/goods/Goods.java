package main.java.goods;

import java.math.BigDecimal;

public class Goods {
    private int id;
    private Product product;

    public Goods(int id, Product product) {
        this.id = id;
        this.product = product;
    }


    public int getId() {
        return id;
    }

    public Product getGoods() {
        return product;
    }

    public void setGoods(Product goods) {
        this.product = goods;
    }

    public String getName() {
        return product.getName();
    }

    public BigDecimal getPrice() {
        return product.getPrice();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
