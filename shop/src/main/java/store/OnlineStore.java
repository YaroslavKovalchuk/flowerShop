package main.java.store;

import main.java.database.CustomerDB;
import main.java.database.GoodDB;
import main.java.goods.Goods;
import main.java.personalData.Customer;

import java.util.List;

public class OnlineStore extends Store {

    private String website;
    CustomerDB customerDB = new CustomerDB();

    public OnlineStore(String name, String website) {
        super(name);
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    // отримання списку всіх користувачів
    public List<Customer> getCustomers() {
        return customerDB.getAllCustomerFormDB();
    }

    //реєстрація користувача
    public boolean singUp(Customer customer){

        return customerDB.addCustomerToDB(customer);
    }

    //вхід користувача
    public Customer singIn(String login, String password){

        return customerDB.getCustomerFromDB(login,password);
    }


}
