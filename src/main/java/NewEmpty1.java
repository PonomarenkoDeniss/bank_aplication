import java.sql.SQLException;
import org.apache.commons.codec.digest.DigestUtils;

 
public class NewEmpty1{
    
    
   /* private static void denis_example(){
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
                 /*
                int rows = preparedStatement.executeUpdate();
                 
                System.out.printf("%d rows added", rows);
             }
         }
        
        catch(SQLException ex){
             System.out.println("Connection failed...");
             System.out.println(ex);
         }
    }*/
    
    
    public static String md5Apache(String password) {
        String md5Hex = DigestUtils.md5Hex(password);
        System.out.print(md5Hex);
        return md5Hex;
    }
    
    //

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    String password = "22082019";

    System.out.println("Custom MD5:");
    md5Apache(password);
    
    //2400b037f667be75796aa6c86979f37e      22/08/2019
    //2400b037f667be75796aa6c86979f37e      22/08/2019
    
    //e9242d91fd9a80d37964f5200da0f779
    
    }

}