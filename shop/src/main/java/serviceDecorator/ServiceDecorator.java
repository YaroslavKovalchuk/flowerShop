package main.java.serviceDecorator;

import main.java.database.ServiceDB;
import main.java.goods.Product;

import java.math.BigDecimal;


public abstract class ServiceDecorator extends Product {

    private ServiceDB serviceDB = new ServiceDB();

    public abstract ServiceDecorator done();

    public boolean  writeService(int id,String name, String description, BigDecimal price){
      return serviceDB.addServiceToDB(id,name,description,price);
    }

}