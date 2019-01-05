package storeService;

import service.Service;

import java.math.BigDecimal;

public interface CreditPayment {

    BigDecimal payByCreditCard(int idGoods, int numbers, Service service, String cardNumber);

}
