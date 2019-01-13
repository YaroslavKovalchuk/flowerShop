package main.java.service;

import java.math.BigDecimal;

public abstract class Service {

    protected String name;
    protected  String description;
    private int id;
    private BigDecimal price;


    public  abstract void done();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

}