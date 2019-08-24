import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//import for hashing
import org.apache.commons.codec.digest.DigestUtils;

public class Data {
    
    public String number;
    public String pwd;
    
    String result;
    
 void exec_sql(String sql){
        try{
             String url = "jdbc:mysql://localhost/bank_system";
             String username = "root";
             String password = "";
             
             try (Connection conn = DriverManager.getConnection(url, username, password)){
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                int rows = preparedStatement.executeUpdate();
                System.out.printf("the operation was successful");
                JOptionPane.showMessageDialog(null,"The operation was successful.");
             }
         }
        
        catch(SQLException ex){
             //JOptionPane.showMessageDialog(null,"Error: '"+ex+"' " );
         }
    }
 
     
    public static String PasswordHash(String password) {
        String md5Hex = DigestUtils.md5Hex(password);
        System.out.print(md5Hex);
        return md5Hex;
    }
    
    public String GetHashingPassword( String pwd){
        String Password = PasswordHash(pwd);
        return Password;
    }
    
   

    
    
    public static void main(String args[]) {

    }

    ResultSet preparedStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ResultSet executeQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

