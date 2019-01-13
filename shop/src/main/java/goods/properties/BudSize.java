package main.java.goods.properties;

public class BudSize implements FlowersProperty{

    private double size; //cm^3

    public BudSize(double size) {
        this.size = size;
    }

    public void printProperty() {
        System.out.println("size of the bud is " + size + " cubic centimeters");
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
