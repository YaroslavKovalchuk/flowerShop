package main.java.goods.properties;

public class LengthOfStem implements FlowersProperty {
    private double length;

    public LengthOfStem(double length){
        this.length = length;
    }


    public void printProperty() {
        System.out.println("length of stem is " + length + " centimeters");
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
