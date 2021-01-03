package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import model.bean.Consulta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConsultaDAO {
    private Connection con = null;

    public ConsultaDAO() { con = ConnectionFactory.getConnection(); }
    
    public boolean save(Consulta consulta){
        String sql = "INSERT INTO consulta VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"; //12
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, 0);
            stmt.setString(2, consulta.getNome());    
            stmt.setString(3, consulta.getTelefone());
            stmt.setString(4, consulta.getCelular());
            stmt.setString(5, consulta.getCpf());
            stmt.setString(6, consulta.getDataNascimento());
            stmt.setString(7, consulta.getSexo());
            stmt.setString(8, consulta.getDataConsulta());
            stmt.setString(9, consulta.getPagamento());
            stmt.setString(10, consulta.getConsulta());
            stmt.setString(11, consulta.getEmail());
            stmt.setDouble(12, consulta.getTotal());            
            
            stmt.executeUpdate();
            return true;
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error: " +  ex); 
            return false; }
        finally { ConnectionFactory.closeConnection(con, stmt); }
    }
    
    public List<Consulta> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Consulta> consultas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM consulta ORDER BY nome");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                
                consulta.setId(rs.getInt("id"));
                consulta.setNome(rs.getString("nome"));
                consulta.setTelefone(rs.getString("telefone"));
                consulta.setCelular(rs.getString("celular"));
                consulta.setCpf(rs.getString("cpf"));
                consulta.setSexo(rs.getString("sexo"));
                consulta.setDataNascimento(rs.getString("dataNascimento"));
                consulta.setConsulta(rs.getString("consulta"));
                consulta.setPagamento(rs.getString("pagamento"));
                consulta.setDataConsulta(rs.getString("dataConsulta"));
                consulta.setEmail(rs.getString("email"));
                consulta.setTotal(rs.getDouble("total"));
                
                consultas.add(consulta);
            }
        } 
        catch (SQLException ex) { ex.printStackTrace(); } 
        finally { ConnectionFactory.closeConnection(con, stmt, rs); }
        return consultas;
    }
    
    public List<Consulta> readForDesc(String desc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Consulta> consultas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM consulta WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();

                consulta.setId(rs.getInt("id"));
                consulta.setNome(rs.getString("nome"));
                consulta.setTelefone(rs.getString("telefone"));
                consulta.setCelular(rs.getString("celular"));
                consulta.setCpf(rs.getString("cpf"));
                consulta.setSexo(rs.getString("sexo"));
                consulta.setDataNascimento(rs.getString("dataNascimento"));
                consulta.setConsulta(rs.getString("consulta"));
                consulta.setPagamento(rs.getString("pagamento"));
                consulta.setDataConsulta(rs.getString("dataConsulta"));
                consulta.setEmail(rs.getString("email"));
                consulta.setTotal(rs.getDouble("total"));
                
                consultas.add(consulta);
            }
        } 
        catch (SQLException ex) { ex.printStackTrace(); } 
        finally { ConnectionFactory.closeConnection(con, stmt, rs); }

        return consultas;
    }
    
    public void update(Consulta p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE consulta SET nome = ? ,telefone = ?,celular = ? WHERE id = ?");
            stmt.setString(1, p.getNome());    
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getCelular());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex); } 
        finally { ConnectionFactory.closeConnection(con, stmt); }
    }

    public void delete(Consulta p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } 
        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex); } 
        finally { ConnectionFactory.closeConnection(con, stmt); }
    }
    
}
