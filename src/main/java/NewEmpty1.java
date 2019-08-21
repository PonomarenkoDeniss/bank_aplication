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

             
            String name = "CLAVON Odinokov";
            int c_num = (int) (Math.random() * 89999999) + 10000000;
            String pwd = "18082019";
            long detail = System.currentTimeMillis() / 1000;
            String account = "DP"+( detail + c_num);
            String cash = "201.88";            

            
             try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO users (FULLNAME, CLIENT_NUM, PASSWORD, ACCOUNT, CASH ) Values ('"+name+"','"+c_num+"','"+pwd+"','"+account+"','"+cash+"')";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                /*preparedStatement.setString(1, name);
                preparedStatement.setInt(2, (int) c_num);
                preparedStatement.setString(3, pwd);
                preparedStatement.setString(4, account);
                preparedStatement.setString(5,  cash);
        */
                 
                int rows = preparedStatement.executeUpdate();
                 
                System.out.printf("%d rows added", rows);
             }
         }
        
        catch(SQLException ex){
             System.out.println("Connection failed...");
             System.out.println(ex);
         }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        denis_example();
    }

}