package Dictionary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dictionary{
       static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "root");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
      
    public static void startBD()
    {
    DAOFactory db=new DAO(); 
    String local = null;
    String perevod = null;
    DataBase query=new DataBase();
    Scanner scan=new Scanner(System.in);
    Connection dbConn=getDBConnection();
    System.out.println("¬ыберити €зык: 1-русский €зык; 2-английский €зык; 0-выход из программы;");
    int x=scan.nextInt();
    System.out.println(x);
    switch (x)
    {
        case 1: System.out.println("¬ы выбрали русский €зык");local="ru";perevod="en";query.set_query("Select * From "+ local + " order by slovo");db.getSelectDB(dbConn,query); break;
        case 2: System.out.println("¬ы выбрали английский €зык");local="en";perevod="ru";query.set_query("Select * From "+ local + " order by slovo");db.getSelectDB(dbConn,query); break;
        case 0: break;    
        default : System.err.println("¬ы ошиблись, такого €зыка нет"); break;
    } 
    while(x!=0)
    {
        System.out.println("¬ыберите следующие действие:\n1-поиск по слову; \n2-поиск по описанию;\n"
                +"3-перевод слова;\n4-добавить новое слово в словарь;\n5-исправить опечатку в слове или описании; "
                + "\n6-удалить слово;\n7-указать перевод слова\n9-переход к выбору €зыка\n0-выход из программы");
        x=scan.nextInt();
        switch (x)
        {
            case 1: Search.search(db,dbConn,local); break;
            case 2: Search.search_opisanie(db,dbConn,local); break;
            case 3: Search.perevod(db,dbConn,local,perevod); break;
            case 4: Facade.addslovo(db,dbConn, local,perevod); break;
            case 5: Facade.upslovo(db,dbConn, local); break;
            case 6: Facade.delslovo(db,dbConn, local); break;
            case 7: Facade.addpd(db,dbConn, local, perevod); break;
            case 9: startBD(); break; 
            case 0: break;
            default : System.err.println("“акой команды нет"); break;
        }
    }
    try {
          dbConn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args)
    {
     startBD();
    }
    
}

