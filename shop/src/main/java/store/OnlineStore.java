package main.java.store;

import main.java.database.CustomerDB;
import main.java.database.GoodDB;
import main.java.goods.Goods;
import main.java.personalData.Customer;

import java.util.List;

public class OnlineStore extends Store {

    private String website;
    GoodDB goodDB = new GoodDB();
    CustomerDB customerDB = new CustomerDB();

    public OnlineStore(String name, String website) {
        super(name);
        this.website = website;
    }

    //Вивід катологу товарів на консоль
    public void showAllGoods(){
        for (Goods g:goodDB.getAllGoodsFormDB().keySet()) {
            System.out.println(g.toString());
        }
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Customer> getCustomers() {
        return customerDB.getAllCustomerFormDB();
    }

    public boolean singUp(Customer customer){

        return customerDB.addCustomerToDB(customer);
    }

    public Customer singIn(String login, String password){

        return customerDB.getCustomerFromDB(login,password);
    }


}
