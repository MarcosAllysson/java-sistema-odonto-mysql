package screens;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.swing.table.TableRowSorter;
import model.bean.Consulta;
import model.dao.ConsultaDAO;

public class ClientScreenScroll extends javax.swing.JFrame {
    Connection conexao = null;
    Statement stmt = null;
    ResultSet resultado = null;

    public ClientScreenScroll() { 
        initComponents(); 
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        table.setRowSorter(new TableRowSorter(modelo));

        readJTable();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nome = new javax.swing.JTextField();
        dataConsulta = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        sexo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pagamento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        consultaSelecionada = new javax.swing.JComboBox<>();
        fileChosen = new javax.swing.JLabel();
        file = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        telefone = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        celular = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        dataNascimento = new javax.swing.JFormattedTextField();
        save = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        cadastrar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        buscarInfo = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dados Pessoais");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        nome.setText("   ");

        try {
            dataConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Prefiro não dizer", " " }));

        jLabel1.setText("Nome Completo:");

        jLabel2.setText("Data:");

        jLabel3.setText("Sexo:");

        jLabel4.setText("CPF:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel8.setText("Forma de Pagamento:");

        pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a opção","À Vista", "Cartão de Crédito", "Cartão de Débito", "Boleto", "Convênio" }));
        pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoActionPerformed(evt);
            }
        });

        jLabel9.setText("Nas:");

        jLabel10.setText("Consulta:");

        consultaSelecionada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione opção", "Consulta", "Limpeza", "Clareamento", "Aparelho", "Raio-x", "Cirurgia" }));
        consultaSelecionada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                consultaSelecionadaItemStateChanged(evt);
            }
        });
        consultaSelecionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaSelecionadaActionPerformed(evt);
            }
        });

        fileChosen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        file.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        file.setText("Selecionar Foto");
        file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefone:");

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Celular:");

        try {
            celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setText("TOTAL R$");

        Total.setText(" ");

        jLabel7.setText("E-mail");

        email.setText("   ");

        try {
            dataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6))
                                    .addGap(87, 87, 87)
                                    .addComponent(jLabel10)
                                    .addGap(247, 247, 247))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(62, 62, 62)
                                            .addComponent(jLabel4))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(consultaSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap()))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(file, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(37, 37, 37)
                                        .addComponent(fileChosen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(195, 195, 195))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))
                    .addComponent(fileChosen, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(file)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consultaSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(3, 3, 3)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total)
                    .addComponent(jLabel11)))
        );

        save.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        save.setText("Marcar Consulta");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Telefone", "Celular", "CPF", "Sexo", "Nasc", "Consulta", "Pagamento", "Data", "Email", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(save)))
                .addGap(0, 183, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(atualizar)
                                .addGap(18, 18, 18)
                                .addComponent(excluir)
                                .addGap(35, 35, 35)
                                .addComponent(buscarInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrar)
                    .addComponent(atualizar)
                    .addComponent(excluir)
                    .addComponent(buscarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(147, 147, 147)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName("Dados Pessoais");

        jScrollPane1.setViewportView(jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("Dados Pessoais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        //Botão cadastrar o usuário
        DefaultTableModel model = (DefaultTableModel) table.getModel();  //Chamar o modelo da tabela, dizer que vai ser tudo default
        Object[] dados = {nome.getText(),telefone.getText(),cpf.getText(), sexo.getSelectedItem().toString(),
            dataNascimento.getText(),dataConsulta.getText(),pagamento.getSelectedItem(),consultaSelecionada.getSelectedItem().toString(),
            celular.getText(), email.getText(), Double.parseDouble(Total.getText())}; //array com os dados da tabela
        model.addRow(dados); //inserir os dados na tabela com o modelo
        
        //Data base
        String nome = this.nome.getText();
        String dataNascimento = this.dataNascimento.getText();
        String telefone = this.telefone.getText();
        String celular = this.celular.getText();
        String cpf = this.cpf.getText();
        String sexo = this.sexo.getSelectedItem().toString();
        String dataConsulta = this.dataConsulta.getText();
        String pagamento = this.pagamento.getSelectedItem().toString();
        String consultaSelecionada = this.consultaSelecionada.getSelectedItem().toString();
        String email = this.email.getText();
        double total = Double.parseDouble(this.Total.getText());
           
        Consulta c = new Consulta(nome, dataNascimento, telefone, celular, cpf, sexo, dataConsulta, pagamento, consultaSelecionada, email, total);
        ConsultaDAO dao = new ConsultaDAO();
        Connection cf = ConnectionFactory.getConnection();
        
        if(dao.save(c)){ JOptionPane.showMessageDialog(this,"Consulta Marcada Com Sucesso! \n\nPlanilha gerada  para consulta."); } 
        else { JOptionPane.showMessageDialog(null, "NOT ok yet!"); }
        
        try { cf.close(); } 
        catch (SQLException ex) { Logger.getLogger(ClientScreenScroll.class.getName()).log(Level.SEVERE, null, ex); }
        // End database
        
        //Planilha
        File arquivo = new File("consulta.csv"); // criar novo arquivo .csv
        try{
            FileOutputStream fos = new FileOutputStream(arquivo,true);
            String texto = "\nNome ; DataNascimento ; Telefone ; Celular ; CPF ; Sexo ; DataConsulta ; FormaPagamento; Consulta ; E-mail ; Total\n";
            byte[] arrayDeBytes = texto.getBytes();
            fos.write(arrayDeBytes); // abertura do array de bytes
                texto = this.nome.getText()+ " ; " 
                        +this.dataNascimento.getText()+ " ; " 
                        +this.telefone.getText()+ " ; " 
                        +this.celular.getText()+ " ; " 
                        +this.cpf.getText()+ " ; "
                        +this.sexo.getSelectedItem().toString()+ " ; "
                        +this.dataConsulta.getText()+ " ; "
                        +this.pagamento.getSelectedItem().toString()+ " ; " 
                        +this.consultaSelecionada.getSelectedItem().toString()+ " ; "
                        +this.email.getText()+ " ; "
                        +Total.getText();
                arrayDeBytes = texto.getBytes();
                fos.write(arrayDeBytes);
            
            fos.close(); // fechamento do array de bytes
        }
        catch (FileNotFoundException fnfe){ JOptionPane.showMessageDialog(null,"Arquivo não encontrado"); }
        catch (IOException ioe){ JOptionPane.showMessageDialog(null,"Ocorreu um erro na leitura"); }
        // Fim planilha
        
        MenuOptions mo = new MenuOptions(); // opening menu options
        //ScreenJTable sjt = new ScreenJTable();
        mo.setVisible(true); 
        this.dispose(); // Closing this frame
    }                                         

    public void calcularTotal() { //caso de um item selecionado
        double valor = 0;
        String servico = (String)consultaSelecionada.getSelectedItem().toString();
        switch(servico) {
            case "Consulta":
                valor += 100;
                break;
            case "Limpeza":
                valor += 130;
                break;
            case "Clareamento":
                valor += 450;
                break;
            case "Aparelho":
                valor += 100;
                break;
            case "Raio-x":
                valor += 80;
                break;
            case "Cirurgia":
                valor += 70;
                break;
        }
        Total.setText(String.valueOf(valor));
    }
    
    private void servicosItemStateChanged(java.awt.event.ItemEvent evt) {                                       
        calcularTotal();
    }//GEN-LAST:event_saveActionPerformed

    private void pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoActionPerformed
        // Área onde é selecionado o método de pagamento que o usuário desejar
        int valorConsulta = 0;
        String[] options = {"1","2","3"};
        String[] convenio = {"Amil Dental","Unimed","OdontoPrev","Outro"};
        String formaPagamento = ((String) pagamento.getSelectedItem());

        if (formaPagamento.equals("Cartão de Crédito")) {
            int parcelas = JOptionPane.showOptionDialog(null, "Parcelas ", "Cartão Crédito", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, null);
            if (parcelas == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"Pagamento em 1x");
                valorConsulta = parcelas;
            } else if (parcelas == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null,"Pagamento em 2x");
                valorConsulta /= parcelas;
            }
            else if (parcelas == JOptionPane.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null,"Pagamento em 3x");
                valorConsulta /= parcelas;
            }
        }

        if (formaPagamento.equals("Cartão de Débito")) { /*JOptionPane.showMessageDialog(null,"Forma de Pagamento: \nCartão de Débito. ");*/ }
        if (formaPagamento.equals("À Vista")) { /*JOptionPane.showMessageDialog(null,"Forma de Pagamento: \nÀ vista");*/ }
        if (formaPagamento.equals("Convênio")) {
            int parcelas = JOptionPane.showOptionDialog(null, "Qual o convênio? ", "Convênio", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, convenio, null);

            if (parcelas == JOptionPane.YES_OPTION){ JOptionPane.showMessageDialog(null,"Convênio Aceito"); }
            else if (parcelas == JOptionPane.NO_OPTION){ JOptionPane.showMessageDialog(null,"Convênio Aceito"); }
            else if (parcelas == JOptionPane.CANCEL_OPTION){ JOptionPane.showMessageDialog(null,"Convênio Aceito"); }
            else if (parcelas == JOptionPane.CANCEL_OPTION+1){ JOptionPane.showMessageDialog(null,"Selecione outra forma de Pagamento");}
        } if(formaPagamento.equals("Boleto")){ /*JOptionPane.showMessageDialog(null,"Forma de Pagamento: \nBoleto");*/ }
    }//GEN-LAST:event_pagamentoActionPerformed

    private void consultaSelecionadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_consultaSelecionadaItemStateChanged
        calcularTotal();
    }//GEN-LAST:event_consultaSelecionadaItemStateChanged

    private void consultaSelecionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaSelecionadaActionPerformed
    }//GEN-LAST:event_consultaSelecionadaActionPerformed

    private void fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileActionPerformed
        JFileChooser jfc = new JFileChooser(); // class responsible to choose files
        jfc.setDialogTitle("Choose File"); // set name when search opens
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY); // show only files
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "png", "jpeg"); // a description and the files extensions
        
        jfc.setFileFilter(filter); // filter the files when "choose" button is clicked
        int retorno = jfc.showOpenDialog(this); // retorno -> is used to verify if something was clicked or not
        
        if(retorno == JFileChooser.APPROVE_OPTION){ // verify if something was selected
            File file = jfc.getSelectedFile(); // pick selected item and save it in "file"
            //this.file.setText(file.getPath()); // see the files's address
            ImageIcon img = new ImageIcon(file.getPath()); // get the file's path
            img.setImage(img.getImage().getScaledInstance(fileChosen.getWidth(), fileChosen.getWidth(), 1)); // resising the picture
            fileChosen.setIcon(img); // fitting the image in the label
        } else { 
            ImageIcon img = new ImageIcon(("src/images/identificador.png")); 
            img.setImage(img.getImage().getScaledInstance(fileChosen.getWidth(), fileChosen.getWidth(), 1)); 
            fileChosen.setIcon(img); 
        }        
    }//GEN-LAST:event_fileActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) table.getModel(); // declarating table
        Object[] data = { nome.getText(),telefone.getText(),cpf.getText(), sexo.getSelectedItem().toString(),
            dataNascimento.getText(), this.dataConsulta.getText(), pagamento.getSelectedItem(),consultaSelecionada.getSelectedItem().toString(),
            celular.getText(), email.getText(), Total.getText()};
        dtm.addRow(data); // putting those data into table
    }//GEN-LAST:event_cadastrarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        if (table.getSelectedRow() != -1) {
            Consulta p = new Consulta();
            ConsultaDAO dao = new ConsultaDAO();
            
            Object m =  table.getValueAt(table.getSelectedRow(), 0);
            p.setId((int) m);
            
            dao.delete(p);

            nome.setText("");
            telefone.setText("");
            celular.setText("");
            //sexo.setText("");
            //consultaSelecionada.setText("");
            cpf.setText("");
            dataNascimento.setText("");
            dataConsulta.setText("");
            //pagamento.setText("");
            email.setText("");
            Total.setText("");

            readJTable();
        } 
        else { JOptionPane.showMessageDialog(null, "Selecione um produto para excluir."); }

    }//GEN-LAST:event_excluirActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (table.getSelectedRow() != -1) {
            Consulta p = new Consulta();
            ConsultaDAO dao = new ConsultaDAO();

            p.setId((int) table.getValueAt(table.getSelectedRow(), 0));
            p.setNome(nome.getText());
            p.setTelefone(telefone.getText());
            p.setCelular(celular.getText());
            p.setSexo(sexo.getSelectedItem().toString());
            p.setConsulta(consultaSelecionada.getSelectedItem().toString());
            p.setCpf(cpf.getText());
            p.setDataNascimento(dataNascimento.getText());
            p.setDataConsulta(dataConsulta.getText());
            p.setPagamento(pagamento.getSelectedItem().toString());
            p.setEmail(email.getText());
            p.setTotal(Double.parseDouble(Total.getText()));
            
            dao.update(p);
            
            nome.setText("");
            telefone.setText("");
            celular.setText("");
            //sexo.setText("");
            //consultaSelecionada.setText("");
            cpf.setText("");
            dataNascimento.setText("");
            dataConsulta.setText("");
            //pagamento.setText("");
            email.setText("");
            Total.setText("");
            
            readJTable();
        }
          else { JOptionPane.showMessageDialog(null, "Error on updating"); }
    }//GEN-LAST:event_atualizarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        readJTableForDesc(buscarInfo.getText());
    }//GEN-LAST:event_buscarActionPerformed

    private void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
        ConsultaDAO pdao = new ConsultaDAO();

        for (Consulta p : pdao.read()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getTelefone(),
                p.getCelular(),
                p.getCpf(),
                p.getSexo(),
                p.getDataNascimento(),
                p.getConsulta(),
                p.getPagamento(),
                p.getDataConsulta(),
                p.getEmail(),
                p.getTotal()
            });
        }
    }
    
    public void readJTableForDesc(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
        ConsultaDAO pdao = new ConsultaDAO();

        for (Consulta p : pdao.readForDesc(desc)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getTelefone(),
                p.getCelular(),
                p.getCpf(),
                p.getSexo(),
                p.getDataNascimento(),
                p.getConsulta(),
                p.getPagamento(),
                p.getDataConsulta(),
                p.getEmail(),
                p.getTotal()
            });
        }
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
            java.util.logging.Logger.getLogger(ClientScreenScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientScreenScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientScreenScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientScreenScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new ClientScreenScroll().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField buscarInfo;
    private javax.swing.JButton cadastrar;
    private javax.swing.JFormattedTextField celular;
    private javax.swing.JComboBox<String> consultaSelecionada;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField dataConsulta;
    private javax.swing.JFormattedTextField dataNascimento;
    private javax.swing.JTextField email;
    private javax.swing.JButton excluir;
    private javax.swing.JButton file;
    private javax.swing.JLabel fileChosen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JComboBox<String> pagamento;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> sexo;
    public javax.swing.JTable table;
    private javax.swing.JFormattedTextField telefone;
    // End of variables declaration//GEN-END:variables
}
