package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDAO {
    Connection con = ConnectionFactory.getConnection();
    
    public boolean consultarLogin(String login) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT login FROM usuario WHERE login = ?");
            stmt.setString(1, login);

            rs = stmt.executeQuery();
            check = true;
        } 
        catch (SQLException ex) { ex.printStackTrace(); } 
        finally { ConnectionFactory.closeConnection(con, stmt, rs); }
        return check;
    }
    
    public boolean checkLogin(String login, String senha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT login, senha FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) { check = true; }
        } 
        catch (SQLException ex) { ex.printStackTrace();} 
        finally { ConnectionFactory.closeConnection(con, stmt, rs); }
        return check;
    }
    
    public boolean adicionarUsuario(String login, String senha) {
        PreparedStatement stmt = null;
        
        try {
            String query = "INSERT INTO usuario VALUES (?,?)";
            
            stmt = con.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.executeUpdate();

            return true;
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +  ex); 
            return false; }
        finally { ConnectionFactory.closeConnection(con, stmt); }
    }
}
