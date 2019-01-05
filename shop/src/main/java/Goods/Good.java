package Goods;

import java.math.BigDecimal;

public class Good {
    private int id;
    private Product good;
    private String name;
    private BigDecimal price;

    public Good(int id, Product good, String name, BigDecimal price) {
        this.id = id;
        this.good = good;
        this.name = good.getName();
        this.price = good.getPrice();
    }


    public int getId() {
        return id;
    }

    public Product getGood() {
        return good;
    }

    public void setGood(Product good) {
        this.good = good;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
