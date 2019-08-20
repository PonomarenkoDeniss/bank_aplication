import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Data {
    
    public String number;
    public String pwd;
    
    String result;
    
    private String run_sql_select(String sql){
        try{
             String url = "jdbc:mysql://localhost/bank_system";
             String username = "root";
             String password = "";
             Scanner scanner = new Scanner(System.in);

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){

                   this.result =  resultSet.getString(1) + " ";
                   this.result +=  resultSet.getString(2);
                }
                System.out.println(result);
            }
        }
            catch(SQLException ex){
                 System.out.println("Connection failed...");
                 System.out.println(ex);
            }
       return result;
    }
    
    
    
    public void SelectSQL(){       
        String sql = "SELECT CLIENT_NUM, PASSWORD FROM users WHERE CLIENT_NUM = '" + this.number + "' AND PASSWORD = '"+  this.pwd +"' ;";
        run_sql_select(sql);
    } 

    //delete and update doesnt work - 19/08/2019
    
    public static void main(String args[]) {

    }
}

