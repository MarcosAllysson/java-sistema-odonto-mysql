package connection;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/clinicaodonto?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        try { Class.forName(DRIVER);
              return DriverManager.getConnection(URL, USER, PASS); } 
        catch (ClassNotFoundException | SQLException ex) { throw new RuntimeException("Error na conexão", ex); }
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try { con.close(); } 
            catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +  ex); }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if(stmt != null){
            try { stmt.close(); } 
            catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +  ex); }
        } closeConnection(con); }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try { rs.close(); } 
            catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +  ex); }
        } closeConnection(con, stmt); }

}
