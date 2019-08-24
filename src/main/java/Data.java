import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//import for hashing
import org.apache.commons.codec.digest.DigestUtils;

public class Data {
   
    public String number;
    public String pwd;
    
    String result;
    
 public static void exec_sql(String sql){
        try{
             String url = "jdbc:mysql://localhost/bank_system";
             String username = "root";
             String password = "";
             
             try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
             }
         }
        
        catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Error: '"+ex+"' " );
         }
    }
     
    public static String PasswordHash(String password) {
        String md5Hex = DigestUtils.md5Hex(password);
        return md5Hex;
    }
    
    public String GetHashingPassword( String pwd){
        String Password = PasswordHash(pwd);
        return Password;
    }
    
    public static void return_rset() throws SQLException {
        
        String url = "jdbc:mysql://localhost/bank_system";
        String username = "root";
        String password = "";
        
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery ("SELECT * FROM users where ID=5" );
        
        ResultSetMetaData rsmd = rset.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++){
            String col_name = rsmd.getColumnName(i);
            System.out.println(col_name);
        }
            

        String result = String.valueOf(rset);
        System.out.print(result);
  }
    
    public static void main(String args[]) {
        try {
            return_rset();
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}