package Goods;

import java.math.BigDecimal;

public abstract class Product {
    protected int id;
    protected String name;
    protected BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

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
