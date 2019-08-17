import java.sql.*;
import java.util.Scanner;
import java.util.*;


 
public class NewEmpty1{
       
    public static void main(String[] args) {
     
         try{
             String url = "jdbc:mysql://localhost:3306/";
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
             
            String name = "Deniss Ponomarenko";
            
            int c_num = (int) (Math.random() * 89999999) + 10000000;
            
            String pwd = "17082019";
            
            long detail = System.currentTimeMillis();
            String account = "DP"+( detail + c_num);
            
            String cash = "33.58";            
             
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

}
