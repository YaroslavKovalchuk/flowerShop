package storeService;

import service.Service;

import java.math.BigDecimal;

public interface Payment {

     BigDecimal payByCash(int idGoods, int numbers, Service service);

}
