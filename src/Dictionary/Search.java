package Dictionary;
import java.sql.*;
import java.util.Scanner;

public class Search { 
    public static void search(DAOFactory db,Connection dbConn,String local)
    {
        System.out.println("Введите слово для поиска:");
        Scanner scan=new Scanner(System.in);
        Slovo search=new Slovo();
        DataBase select=new DataBase();
        search.set_slovo(scan.nextLine());
        if("ru".equals(local))
        {
            select.set_query("select * from "+ local + " where slovo like '%"+search.get_slovo()+"%'");
            if(Facade.validate_ru(search.get_slovo())) db.getSelectDB(dbConn,select);   
            else System.err.println("Вы ввели не правильное слово, вы используете другую локаль!");
        }
        else
        {
            select.set_query("select * from "+ local + " where slovo like '%"+search.get_slovo()+"%'");
            if(Facade.validate_en(search.get_slovo())) db.getSelectDB(dbConn,select);   
            else System.err.println("Вы ввели не правильное слово, вы используете другую локаль!");
        }
    }
    public static void search_opisanie(DAOFactory db,Connection dbConn,String local)
    {
        System.out.println("Введите описание слова для поиска:");
        Scanner scan=new Scanner(System.in);
        Slovo search=new Slovo();
        search.set_opisanie(scan.nextLine());
        DataBase select=new DataBase();
        
        if("ru".equals(local))
        {
            select.set_query("select * from "+ local + " where opisanie like'%"+search.get_opisanie()+"%'");
            if(Facade.validate_ru(search.get_opisanie())) db.getSelectDB(dbConn,select);
            else System.err.println("Вы ввели не правильное слово, вы используете другую локаль!");
        }
        else 
        {
            select.set_query("select * from "+ local + " where opisanie like'%"+search.get_opisanie()+"%'");
            if(Facade.validate_en(search.get_opisanie())) db.getSelectDB(dbConn,select);
            else System.err.println("Вы ввели не правильное слово, вы используете другую локаль!");
        }
    }
    public static void perevod(DAOFactory db,Connection dbConn,String local,String perevod)
    {
        System.out.println("Введите слова для перевода:");
        Scanner scan=new Scanner(System.in);
        Slovo search=new Slovo();
        search.set_slovo(scan.next());
        DataBase select=new DataBase();
        DataBase select1=new DataBase();
        if("ru".equals(local))
        {
            select.set_query("select * from "+ local + " where slovo='"+search.get_slovo()+"'");
            select1.set_query("select * from "+ perevod + " where id_"+perevod+" in (select id_perevod from slovo where id_slovo in (select id_"+local+" from "+local+ " where slovo='"+search.get_slovo()+"'))");
            if(Facade.validate_ru(search.get_slovo()))
            {
                db.getSelectDB(dbConn,select);
                db.getSelectDB(dbConn,select1);
            }
            else System.err.println("Вы ввели не правильное слово, вы используете другую локаль!");
        }
        else
        {
            select.set_query("select * from "+ local + " where slovo='"+search.get_slovo()+"'");
            select1.set_query("select * from "+ perevod + " where id_"+perevod+" in (select id_perevod from slovo where id_slovo in (select id_"+local+" from "+local+ " where slovo='"+search.get_slovo()+"'))");
            if(Facade.validate_en(search.get_slovo()))
            {
                db.getSelectDB(dbConn,select);
                db.getSelectDB(dbConn,select1);
            }
            else System.err.println("Вы ввели не правильное слово, вы используете другую локаль!");
        }
    }
}
