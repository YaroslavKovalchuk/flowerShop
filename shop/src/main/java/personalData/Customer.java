package personalData;

public class Customer {

    private int id;
    private String name;
    private String login;
    private String password;
    private String cardNumber;

    public Customer() {
    }

    public Customer(int id, String name, String login, String password, String cardNumber) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
