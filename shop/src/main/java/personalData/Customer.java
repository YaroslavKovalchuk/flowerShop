package main.java.personalData;

import main.java.store.servicePaymentStrategy.Card;

public class Customer {

    private int id;
    private String name;
    private String login;
    private String password;
    private Card card;

    public Customer() {
    }

    public Customer(int id, String name, String login, String password, Card cardNumber) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.card = cardNumber;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", NAME='" + name + '\'' +
                ", LOGIN='" + login + '\'' +
                ", PASSWORD='" + password + '\'' +
                ", CARD NUMBER='" + card.getNumber() + '\'' +
                ", CARD CVV='" + card.getCvv() + '\'' +
                ", CARD DATE='" + card.getExpirationDate() + '\'' +
                '}';
    }
}
