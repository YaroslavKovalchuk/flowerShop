package main.java.goods;

import java.util.HashSet;

public class TypesOfFlowers {

    private static HashSet<String> types = new HashSet<String>();

    static{
        types.add("local flower");
        types.add("Flower from abroad");
    }

    public static void addTypee(String type){
        types.add(type);
    }

    public static void removeType(String removingType){
        types.remove(removingType);
    }

    public static HashSet<String> getTypes(){
        return types;
    }
}
