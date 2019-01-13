package main.java.goods;

import main.java.goods.properties.FlowersProperty;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Flower extends Product{

    private ArrayList<FlowersProperty> properties = new ArrayList<>();

    public Flower(int id, String name, BigDecimal price){
        setId(id);
        setName(name);
        setPrice(price);
    }

    public void addProperty(FlowersProperty property){
        properties.add(property);
    }
}
