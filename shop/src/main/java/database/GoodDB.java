package main.java.database;


import main.java.goods.Flower;
import main.java.goods.Goods;
import main.java.goods.Product;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodDB {

    Map<Goods,Integer> goodsList = new HashMap<>();

    private PreparedStatement preparedStatement = null;
    private DBWorker dbWorker;

    private final String SELECT_ALL = "SELECT * FROM goods";
    private final String SELECT_ONE = "SELECT * FROM goods WHERE id = ?";
    private final String INSERT = "INSERT INTO goods VALUES(?,?,?,?)";
    private final String UPDATE = "UPDATE goods SET numbers = ? WHERE id = ?";
    private final String UPDATE_PRICE = "UPDATE goods SET price = ? WHERE id = ?";

    //Додавання товару до бази даних
    public boolean addGoodToDB(Product goods, int numbers){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setInt(1,goods.getId());
            preparedStatement.setString(2,goods.getName());
            preparedStatement.setBigDecimal(3,goods.getPrice());
            preparedStatement.setInt(4,numbers);
            preparedStatement.execute();
            dbWorker.getConnection().commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    //отримання товару з бази даних по ід
    public Goods getGoods(int id) {
        Goods goods = null;
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            goods = new Goods(resultSet.getInt(1),
                    new Flower(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getBigDecimal(3)));
            dbWorker.getConnection().commit();
            dbWorker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;

    }

    //Змінення кількості товару
    public boolean changeNumbersOfGoods(int id){
        dbWorker = new DBWorker();
        int currentNumber = 0;
        try {
            dbWorker.getConnection().setAutoCommit(false);
            PreparedStatement preparedStatementSO = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatementSO.setObject(1,id);
            ResultSet resultSet = preparedStatementSO.executeQuery();
            resultSet.next();
            currentNumber = resultSet.getInt(4);
            if(currentNumber <= 0){
                System.out.println("numbers of goods are less than selected");
                return false;
            }
            preparedStatement = dbWorker.getConnection().prepareStatement(UPDATE);
            preparedStatement.setInt(1, currentNumber - 1);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            dbWorker.getConnection().commit();
            dbWorker.getConnection().close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // змінення ціни товару
    public boolean changePriceOfGoods(int id, BigDecimal newCost){
        dbWorker = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(UPDATE_PRICE);
            preparedStatement.setInt(1,id);
            PreparedStatement preparedStatementSO = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatementSO.setObject(1, id);
            ResultSet resultSet = preparedStatementSO.executeQuery();
            resultSet.next();
            preparedStatement.setBigDecimal(2, newCost);
            preparedStatement.executeUpdate();
            dbWorker.getConnection().commit();
            dbWorker.getConnection().close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //отримання всі товарів з бази даних
    public Map<Goods,Integer> getAllGoodsFormDB(){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Goods goods = new Goods(resultSet.getInt(1),
                        new Flower(resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getBigDecimal(3)));
                goodsList.put(goods,resultSet.getInt(4));
            }
            dbWorker.getConnection().commit();
            dbWorker.getConnection().close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return goodsList;
    }
}

