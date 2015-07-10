package Dictionary;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Facade {
    public static boolean validate_ru(String userNameString){  
        Pattern p = Pattern.compile("^[[�-��-�]{2,}|\\s{1,}|[.,]{1,}]{1,}$");  
        Matcher m = p.matcher(userNameString);  
        return m.matches();  
    }
    public static boolean validate_en(String userNameString){  
        Pattern p = Pattern.compile("[[a-zA-Z]{2,}|\\s{1,}|[.,]{1,}]{1,}$");  
        Matcher m = p.matcher(userNameString);  
        return m.matches();  
    }
    public static void addslovo(DAOFactory db,Connection dbConn,String local,String perevod)
    {
       Slovo sl=new Slovo();
       Scanner scan=new Scanner(System.in);
       System.out.println("������� ����� ������� ������ �������� � �������");
       sl.set_slovo(scan.nextLine());
       if("ru".equals(local))
            while(!validate_ru(sl.get_slovo()))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            sl.set_slovo(scan.nextLine());
       } 
       else
           while(!validate_en(sl.get_slovo()))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           sl.set_slovo(scan.nextLine());
       } 
       System.out.println("������� �������� � ����� �����");
       sl.set_opisanie(scan.nextLine());
       if("ru".equals(local))
            while(!validate_ru(sl.get_opisanie()))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            sl.set_opisanie(scan.nextLine());
       } 
       else
           while(!validate_en(sl.get_opisanie()))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           sl.set_opisanie(scan.nextLine());
       } 
       db.setInsertDB(dbConn, local, sl.get_slovo(), sl.get_opisanie());
    }
    public static void upslovo(DAOFactory db,Connection dbConn,String local)
    {
       System.out.println("������� ����� ������� ������ ��������");
       Scanner scan=new Scanner(System.in);
       String updat;
       Slovo sl=new Slovo();
       updat=scan.nextLine();
       if("ru".equals(local))
               while(!validate_ru(updat))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            updat=scan.nextLine();
       } 
       else
           while(!validate_en(updat))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           updat=scan.nextLine();
       } 
       System.out.println("������� ����������� ������� ����� �����"); 
       sl.set_slovo(scan.nextLine());
       if("ru".equals(local))
            while(!validate_ru(sl.get_slovo()))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            sl.set_slovo(scan.nextLine());
       } 
       else
           while(!validate_en(sl.get_slovo()))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           sl.set_slovo(scan.nextLine());
       } 
       System.out.println("������� �������� � ����� �����");
       sl.set_opisanie(scan.nextLine());
       if("ru".equals(local))
            while(!validate_ru(sl.get_opisanie()))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            sl.set_opisanie(scan.nextLine());
       } 
       else
           while(!validate_en(sl.get_opisanie()))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           sl.set_opisanie(scan.nextLine());
       } 
       db.setUpdateDB(dbConn, local, updat, sl.get_slovo(),sl.get_opisanie());
       
    }
    public static void delslovo(DAOFactory db,Connection dbConn,String local)
    {
       System.out.println("������� ����� ������� ������ �������");
       Scanner scan=new Scanner(System.in);
       Slovo sl=new Slovo();
       sl.set_slovo(scan.nextLine());
        if("ru".equals(local))
            while(!validate_ru(sl.get_slovo()))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            sl.set_slovo(scan.nextLine());
       } 
       else
           while(!validate_en(sl.get_slovo()))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           sl.set_slovo(scan.nextLine());
       } 
       db.getDeleteDB(dbConn, local, sl.get_slovo());
    }  
    public static void addpd(DAOFactory db,Connection dbConn,String local,String perevod)
    {
        System.out.println("������� ����� ��� ��������:");
        Scanner scan=new Scanner(System.in);
        String slovo=scan.nextLine(); 
        DataBase select=new DataBase();
        if("ru".equals(local))
            while(!validate_ru(slovo))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            slovo=scan.nextLine();
       } 
       else
           while(!validate_en(slovo))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           slovo=scan.nextLine();
       } 
        System.out.println("������� ����� ��� ��������:");
        String per=scan.nextLine();
        if("ru".equals(local))
            while(!validate_ru(per))
       {
            System.err.println("�� ����� ����� �� ���������");
            System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� �������� ��������");
            per=scan.nextLine();
       } 
       else
           while(!validate_en(per))
       {
           System.err.println("�� ����� ����� �� ���������");
           System.out.println("������� ����� ��� ���. ����� ������ ��������� ������ ��������� � ��������� ����� ���������� ��������");
           per=scan.nextLine();
       } 
        select.set_query("select id_"+local+" from "+local+" where slovo='"+slovo+"'");
        int id_slovo=db.getSelectDB_id(dbConn,select,local);
        select.set_query("select id_"+perevod+" from "+perevod+" where slovo='"+per+"'");
        int id_perevod=db.getSelectDB_id(dbConn,select,perevod);
        db.setInsertDB_slovo(dbConn, id_slovo, id_perevod);    
    }
}
