/*Класс для работы с базой данных словаря*/
package Dictionary;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO implements DAOFactory{
    @Override
    public void getSelectDB(Connection dbConn, DataBase Select) {
        int k=0;
        Statement statement = null;
        try {
            statement = dbConn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(Select.get_query());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        try {
            while (rs.next()) {
                System.out.println(rs.getRow() + ". " + rs.getString("slovo") + "-" + rs.getString("opisanie"));
                k++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        if(k==0)
            System.err.println("Такого слова нет");
    }
    @Override
    public int getSelectDB_id(Connection dbConn, DataBase Select,String local) {
        Statement statement = null;
        int x = 0;
        try {
            statement = dbConn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(Select.get_query());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
              x=rs.getInt("id_"+local);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    @Override
        public void setInsertDB(Connection dbConn, String local, String slovo, String opisanie) {
        Statement statement = null;
        try {
            statement = dbConn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBase insert =  new DataBase();
        insert.set_query("insert into " + local + " (slovo,opisanie)values('"+ slovo + "','" + opisanie + "')");
        try {
            int x=statement.executeUpdate(insert.get_query());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
        public void setInsertDB_slovo(Connection dbConn, int id_slovo, int id_perevod) {
        Statement statement = null;
        try {
            statement = dbConn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBase insert = new DataBase();
        insert.set_query("insert into slovo (id_slovo,id_perevod)values("+ id_slovo + "," + id_perevod + ")");
        try {
            int x=statement.executeUpdate(insert.get_query());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        

    @Override
    public void setUpdateDB(Connection dbConn, String local, String updat, String slovo, String opisanie) {
        Statement statement = null;
        try {
            statement = dbConn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBase update = new DataBase();
        update.set_query("update " + local + " set slovo='" + slovo + "',opisanie='" + opisanie + "' where slovo='" + updat+"'");
        try {
            boolean x = statement.execute(update.get_query());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getDeleteDB(Connection dbConn, String local, String slovo) {
        Statement statement = null;
        try {
            statement = dbConn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBase delete = new DataBase();
        delete.set_query("delete from " + local + " where slovo='" + slovo+"'");
        try {
            boolean x = statement.execute(delete.get_query());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    




