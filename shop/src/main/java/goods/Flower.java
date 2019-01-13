package main.java.goods;

import main.java.goods.properties.FlowersProperty;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Flower extends Product{
    private String type;
    private ArrayList<FlowersProperty> properties = new ArrayList<>();


    public Flower(int id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){this.type = type;}

    public void addProperty(FlowersProperty property){
        properties.add(property);
    }
}
