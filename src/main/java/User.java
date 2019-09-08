import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public final class User {
    private final int id;
    private final String name;
    private final String num;
    private final String pwd;
    private final String acc;
    private final String cash;
    private final String admin;
    
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public User(int ID, String FULLNAME, String NUMBER, String PASSWORD, String ACCOUNT, String CASH, String ADMIN){
        this.id = ID;
        this.name = FULLNAME;
        this.num = NUMBER;
        this.pwd = PASSWORD;
        this.acc = ACCOUNT;
        this.cash = CASH;
        this.admin = ADMIN;
        
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getNumber(){
        return num;
    }
    public String getPassword(){
        return pwd;
    }
    public String getAccount(){
        return acc;
    }    
    public String getCash(){
        return cash;
    }
    public String getAdmin(){
        return admin;
    }    
}
