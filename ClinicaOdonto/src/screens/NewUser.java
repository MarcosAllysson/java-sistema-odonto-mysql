package screens;

import com.mysql.cj.x.protobuf.Mysqlx;
import connection.ConnectionFactory;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class NewUser extends javax.swing.JFrame {
    Connection conexao = ConnectionFactory.getConnection();;
    Statement stmt = null;
    ResultSet resultado = null;
    UsuarioDAO user;
    
    public JTextField getJtfLogin() { return login; }

    public NewUser() {
        initComponents();
        user = new UsuarioDAO();
        Connection connect = ConnectionFactory.getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        login = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        newUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        existente = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setResizable(false);

        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFocusGained(evt);
            }
        });
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });

        pass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pass2FocusLost(evt);
            }
        });
        pass2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pass2PropertyChange(evt);
            }
        });
        pass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass2KeyTyped(evt);
            }
        });

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        jLabel3.setText("Repita a senha:");

        newUser.setText("Cadastrar");
        newUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Novo Usuário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(newUser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(existente, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(newUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(existente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        //chamar método que verifica o login
        verificarLogin(login.getText());
    }//GEN-LAST:event_passMouseClicked

    private void pass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyTyped
    }//GEN-LAST:event_pass2KeyTyped

    private void pass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyPressed
        //verificarSenhas();
    }//GEN-LAST:event_pass2KeyPressed

    private void pass2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pass2PropertyChange
        verificarSenhas();
    }//GEN-LAST:event_pass2PropertyChange

    private void pass2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass2FocusLost
         verificarSenhas();
    }//GEN-LAST:event_pass2FocusLost

    private void newUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserActionPerformed
        String user = (login.getText());
        String password = new String(pass.getPassword());
        
        UsuarioDAO dao = new UsuarioDAO();
        Connection cf = ConnectionFactory.getConnection();
        
        if(verificarSenhas()){ 
            if(dao.adicionarUsuario(user, password)){
                JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso!","NOVO USUÁRIO", JOptionPane.INFORMATION_MESSAGE);
                MenuOptions mo = new MenuOptions();
                mo.setVisible(true);
                this.dispose();
            } else{ JOptionPane.showMessageDialog(rootPane,"Ocorreu um erro","ERRO", JOptionPane.ERROR_MESSAGE); }
        } else{ JOptionPane.showMessageDialog(null, "Senhas não conferem ou usuário indisponível!", "Erro", JOptionPane.WARNING_MESSAGE); /*se o usuário existe, mas a senha é errada*/}
        
        try { conexao.close(); } 
        catch (SQLException ex) { Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_newUserActionPerformed

    private void passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusGained
        //verificarLogin(login.getText());
    }//GEN-LAST:event_passFocusGained

    private boolean verificarSenhas() {
        if (!Arrays.equals(pass.getPassword(), (pass2.getPassword()))) {
            pass.setBackground(Color.red);
            pass2.setBackground(Color.red);
            return false;
        } else {
            pass.setBackground(Color.decode("#e3f0d6"));
            pass2.setBackground(Color.decode("#e3f0d6"));
            return true;
        }
    }
    
    private boolean verificarLogin(String user) {
        UsuarioDAO dao = new UsuarioDAO();
        
        existente.setText("");
        login.setBackground(Color.decode("#f2f1f0"));

        if (dao.consultarLogin(login.getText())) {
            login.setBackground(Color.red);
            existente.setText("Login não disponível");
            login.requestFocusInWindow();
            return false;
        } else  { login.setBackground(Color.decode("#e3f0d6")); return true; }
    }    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new NewUser().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel existente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField login;
    private javax.swing.JButton newUser;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField pass2;
    // End of variables declaration//GEN-END:variables
}
