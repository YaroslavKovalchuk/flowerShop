package store;

import database.GoodDB;
import service.Service;
import storeService.Discaunt;
import storeService.Payment;

import java.math.BigDecimal;

public class DipartmentStore extends Store implements Payment, Discaunt {

    private String location;

    public DipartmentStore(String name) {
        super(name);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public BigDecimal payByCash(int idGoods, int numbers, Service service) { //(Product good)
        BigDecimal resulPrice = null;
        GoodDB goodDB = new GoodDB();
        goodDB.changeNumbersOfGood(idGoods, numbers);
        resulPrice = goodDB.getGood(idGoods,numbers).get(0).getPrice().multiply(BigDecimal.valueOf(numbers)).add(service.getPrice())
                .multiply(BigDecimal.valueOf(numbers));
        return resulPrice;
    }

    @Override
    public boolean addDiscaunt(int idGoods, int interesRate) {
        return new GoodDB().changePriceOfGood(idGoods,interesRate);
    }
}
