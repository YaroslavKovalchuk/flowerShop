package store;

import database.CustomerDB;
import database.GoodDB;
import personalData.Customer;
import service.Service;
import storeService.CreditPayment;
import storeService.Discaunt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OnlineStore extends Store implements CreditPayment, Discaunt {

    private String website;
    private List<Customer> customers = new ArrayList<>();
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

    public List<Customer> getCustomers() {
        return customerDB.getAllCustomerFormDB();
    }

    public boolean singUp(Customer customer){

        return customerDB.addCustomerToDB(customer);
    }

    public Customer singIn(String login, String password){

        return customerDB.getCustomerFromDB(login,password);
    }

    @Override
    public BigDecimal payByCreditCard(int idGoods, int numbers, Service service, String cardNumber) {
         BigDecimal resultPrice = null;
        GoodDB goodDB = new GoodDB();
        CustomerDB customerDB = new CustomerDB();
        for (Customer c: customerDB.getAllCustomerFormDB()) {
            if (c.getCardNumber().equals(cardNumber)){
                goodDB.changeNumbersOfGood(idGoods, numbers);
                resultPrice = goodDB.getGood(idGoods, numbers).get(0).getPrice().multiply(BigDecimal.valueOf(numbers)).add(service.getPrice())
                        .multiply(BigDecimal.valueOf(numbers));
            }else resultPrice = null;
        }
        return resultPrice;
    }

    @Override
    public boolean addDiscaunt(int idGoods, int interesRate) {
        return new GoodDB().changePriceOfGood(idGoods,interesRate);
    }
}
