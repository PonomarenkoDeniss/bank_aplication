import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Data {
    
    private static void run_sql(String sql){
        try{
             String url = "jdbc:mysql://localhost/bank_system";
             String username = "root";
             String password = "";
             Scanner scanner = new Scanner(System.in);

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){

                   String number =  resultSet.getString(1);
                   String pwd =  resultSet.getString(4);
                   
                   System.out.println(number);
                   System.out.println(pwd);

                }
                System.out.printf("SQL request completed");
            }
        }
            catch(SQLException ex){
                 System.out.println("Connection failed...");
                 System.out.println(ex);
            }
    }
    
    public void SelectSQL(){
        LoginFrame login = new LoginFrame();
        login.GetCustomerNUmber();
        login.GetPasswordNUmber();
        String sql = "Select from users where CLIENT_NUM = '"+login.GetCustomerNUmber()+"' AND PASSWORD = '"+login.GetPasswordNUmber()+"' ";
        run_sql(sql);
    } 

    //delete and update doesnt work - 19/08/2019
    
    public static void main(String args[]) {
        int id  = 1;
        String sql = "SELECT * from users where id = 2";
        run_sql(sql);
    }
}

