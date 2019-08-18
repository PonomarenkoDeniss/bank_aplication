import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;  
 
public class NewEmpty1{
    
    
    private static void denis_example(){
        try{
             String url = "jdbc:mysql://localhost/bank_system";
             String username = "root";
             String password = "";
             Scanner scanner = new Scanner(System.in);
             
             /*
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
             //1 
             System.out.print("Input c_name: ");
             String name = scanner.nextLine();
             //2
             System.out.print("C_num is : ");
             int c_num = (int) (Math.random() * 89999999) + 10000000;
             //3
             System.out.print("Input c_pwd: ");
             String pwd = scanner.nextLine();
             //4
             System.out.print("C_num is: ");
             long detail = System.currentTimeMillis();
             String account = "DP"+( detail + c_num);
             
             System.out.print("Input cash");
             String cash = scanner.nextLine();
             */
             
            String name = "Slava Odinokov";
            
            int c_num = (int) (Math.random() * 89999999) + 10000000;
            
            
            String pwd = "18082019";
            
            long detail = System.currentTimeMillis() / 1000;
            String account = "DP"+( detail + c_num);
            
            String cash = "201.88";            
             
            System.out.println("name is " + name);
            System.out.println("c_num is " +c_num);
            System.out.println("pwd is " +pwd);
            System.out.println("detail is " +detail);
            System.out.println("Account is " +account);
            System.out.println("Cash is " +cash);
            
             try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO users (FULLNAME, CLIENT_NUM, PASSWORD, ACCOUNT, CASH ) Values (?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, (int) c_num);
                preparedStatement.setString(3, pwd);
                preparedStatement.setString(4, account);
                preparedStatement.setString(5,  cash);

                 
                int rows = preparedStatement.executeUpdate();
                 
                System.out.printf("%d rows added", rows);
             }
         }
        
        catch(SQLException ex){
             System.out.println("Connection failed...");
              
             System.out.println(ex);
         }
    }
    
    
    
public class JavaDateGetDateExample1 {  
  
} 
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Date d=new Date();  
        /*System.out.println("DAY  : "+d.getDate() );
        System.out.println("Month  : "+d.getMonth() );  
        System.out.println("Year  : "+d.getYear() );
        */
        int year  =  d.getYear() - 100;
        String pwd = ""+ d.getDate();
        pwd += "0" +d.getMonth();
        pwd += "" +year;
        
        System.out.println("PWD = "+pwd);
    }

}