package store.servicePayment;

import java.math.BigDecimal;

public interface PaymentMethod {

    public void pay(BigDecimal money);

}
