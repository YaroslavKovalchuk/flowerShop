package main.java.goods;

import main.java.database.GoodDB;

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
