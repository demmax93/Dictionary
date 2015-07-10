package Dictionary;

import java.sql.Connection;

public interface DAOFactory {
   public void getSelectDB(Connection dbConn, DataBase Select);
   public int getSelectDB_id(Connection dbConn, DataBase Select,String local);
   public void setInsertDB(Connection dbConn, String local, String slovo, String opisanie);
   public void setInsertDB_slovo(Connection dbConn, int id_slovo, int id_perevod);
   public void setUpdateDB(Connection dbConn, String local, String updat, String slovo, String opisanie);
   public void getDeleteDB(Connection dbConn, String local, String slovo);
}
