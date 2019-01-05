package database;

import Goods.Flower;
import Goods.Product;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDB {


    private PreparedStatement preparedStatement = null;
    private DBWorker dbWorker;

    private final String SELECT_ALL = "SELECT * FROM goods";
    private final String SELECT_ONE = "SELECT * FROM goods WHERE id = ?";
    private final String INSERT = "INSERT INTO goods VALUES(?,?,?,?)";
    private final String UPDATE = "UPDATE goods SET numbers = ? WHERE id = ?";
    private final String UPDATE_PRICE = "UPDATE goods SET price = ? WHERE id = ?";
    //private final String INSERT_ALL_service = "INSERT INTO goods_service VALUES(?,?)";


    private List<Product> goods = new ArrayList<>();

    //Додавання товару до бази даних
    public boolean addGoodToDB(Product good){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setInt(1,good.getId());
            preparedStatement.setString(2,good.getName());
            preparedStatement.setBigDecimal(3,good.getPrice());
            PreparedStatement preparedStatementSO = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatementSO.setObject(1,good.getName());
            ResultSet resultSet = preparedStatementSO.executeQuery();
            resultSet.next();
            if (resultSet.getString(2).equals(good.getName())) preparedStatement.setInt(4,resultSet.getInt(4) +1 );
            else preparedStatement.setInt(4,1);
            /*preparedStatement = dbWorker.getConnection().prepareStatement(INSERT_ALL_service);
            while (good.getServices().iterator().hasNext()){
                preparedStatement.setInt(1,good.getId());
                preparedStatement.setInt(2,good.getServices().iterator().next().getId());
            }*/
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
    public ArrayList<Product> getGood(int id, int number) {
        try {
            dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (number <= resultSet.getInt(4)) {
                ArrayList<Product> arr = new ArrayList<>();
                for (int i = 0 ; i < number; ++i) {
                    Product g = new Flower();
                    g.setId(resultSet.getInt(1));
                    g.setName(resultSet.getString(2));
                    g.setPrice(resultSet.getBigDecimal(3));
                    arr.add(g);
                }
                return arr;
            }
            else {
                System.out.println("to much");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    //Змінення кількості товару
    public boolean changeNumbersOfGood(int id, int numbers){
        dbWorker = new DBWorker();
        int curNumber = 0;
        try {
            dbWorker.getConnection().setAutoCommit(false);
            PreparedStatement preparedStatementSO = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatementSO.setObject(1,id);
            ResultSet resultSet = preparedStatementSO.executeQuery();
            resultSet.next();
            curNumber = resultSet.getInt(4);
            if(numbers > curNumber){
                System.out.println("numbers of goods are less then selected");
                return false;
            }
           preparedStatement = dbWorker.getConnection().prepareStatement(UPDATE);
           preparedStatement.setInt(1, curNumber - numbers);
           preparedStatement.setInt(2,id);
           preparedStatement.executeUpdate();
           dbWorker.getConnection().commit();
           return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // змінення ціни товару
    public boolean changePriceOfGood(int id, int interestedRate){
        dbWorker = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(UPDATE_PRICE);
            preparedStatement.setInt(1,id);
            PreparedStatement preparedStatementSO = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatementSO.setObject(1, id);
            ResultSet resultSet = preparedStatementSO.executeQuery();
            resultSet.next();
            preparedStatement.setBigDecimal(2, (resultSet.getBigDecimal(2).multiply(BigDecimal.valueOf(interestedRate
                    / 100))));
            preparedStatement.executeUpdate();
            dbWorker.getConnection().commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //отримання всі товарів з бази даних
    public void showAllGoodsFormDB(){
            dbWorker  = new DBWorker();
            try {
                dbWorker.getConnection().setAutoCommit(false);
                preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " +
                            resultSet.getBigDecimal(3) + "  " +
                            resultSet.getInt(4));
                }
                dbWorker.getConnection().commit();
            } catch (SQLException e ) {
                e.printStackTrace();
            }
            finally {
                try {
                    dbWorker.getConnection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}

