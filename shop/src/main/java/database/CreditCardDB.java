package main.java.database;

import main.java.store.servicePaymentStrategy.Card;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditCardDB {

    private PreparedStatement preparedStatement = null;
    private DBWorker dbWorker;

    private final String SELECT_ALL = "SELECT * FROM credit_card";
    private final String SELECT_ONE = "SELECT * FROM credit_card WHERE number = ?";
    private final String INSERT = "INSERT INTO credit_card VALUES(?,?,?,?,?)";

    private Card card ;
    private List<Card> cards = new ArrayList<>();

    //Додавання кредитної картки до бази даних
    public boolean addCreditCardToDB(Card card){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setInt(1,card.getId());
            preparedStatement.setString(2,card.getNameOnCard());
            preparedStatement.setString(3,card.getNumber());
            preparedStatement.setString(4,card.getCvv());
            preparedStatement.setString(5,card.getExpirationDate());
            preparedStatement.execute();
            dbWorker.getConnection().commit();
            dbWorker.getConnection().close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Отримання кредитної картки з бази даних
    public Card getCreditCardFromDB(String number){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatement.setObject(1,number);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            card = new Card(resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
            dbWorker.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    // отримання списку всіх кредитних карток з бази даних
    public List<Card> getAllCardFormDB(){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Card c = new Card(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                cards.add(c);
            }
            dbWorker.getConnection().commit();
            dbWorker.getConnection().close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return cards;
    }
}
