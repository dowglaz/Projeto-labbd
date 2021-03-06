/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditarCadastroPiloto.java
 *
 * Created on 05/12/2009, 02:26:31
 */

package view_projetofinallabbd;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Henry
 */
public class EditarCadastroPiloto extends javax.swing.JFrame {
    private Connection conn;
    private JTable tabela;
    private int index;
    String cpf;
    String nome;
    String rua;
    String nro;
    String cidade;
    String estado;
    String cep;
    String salario;
    String turno;
    String tipo;
    String nro_licenca = "0" ;
    String horas_voo = "0";
    Vector<String> lista_telefones = new Vector();

    AtualizaPiloto at;
    /** Creates new form EditarCadastroEmpregado
     * @param conn
     * @param tabela
     * @param index
     * @param at
     */
    public EditarCadastroPiloto(Connection conn, JTable tabela, int index, AtualizaPiloto at) {
        initComponents();
        setLocationRelativeTo(null);
        this.conn = conn;
        this.tabela = tabela;
        this.index = index;
        this.listaPilotoIndex();
        this.at = at;
    }
    /** Creates new form EditarCadastroPiloto */
    public EditarCadastroPiloto() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel16.setText("Lembrete: Os tipos pré-definidos são: PILOTO e EMPREGADO.");

        jLabel9.setText("Nº Licença");

        jLabel1.setText("Editar cadastro de empregado");

        jButton1.setText("Aplicar as alterações ao cadastro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF*:");

        jLabel3.setText("Nome*:");

        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Rua:");

        jLabel5.setText("Nº:");

        jLabel6.setText("Cidade:");

        jLabel10.setText("Horas de vôo:");

        jLabel7.setText("Estado:");

        jLabel11.setText("Caso haja mudança de tipo de pessoa, preencha os campos abaixo:");

        jLabel8.setText("CEP:");

        jLabel13.setText("Turno");

        jLabel12.setText("Salário");

        jButton2.setText("Limpar campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jLabel15.setText("Tipo:");

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diurno", "Vespertino", "Noturno" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO" }));

        jLabel14.setText("Fone 1:");

        jLabel17.setText("Fone 3:");

        jLabel18.setText("Fone 2:");

        jLabel19.setText("Fone 4:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField14)
                            .addComponent(jTextField9)
                            .addComponent(jTextField13)
                            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField10)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4)
                                .addComponent(jTextField5)
                                .addComponent(jTextField7)
                                .addComponent(jTextField8)
                                .addComponent(jTextField11)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel16))
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.editarCadastro();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText("");        jTextField3.setText("");
        jTextField4.setText("");        jTextField5.setText("");
        jTextField7.setText("");        jTextField8.setText("");
        jTextField10.setText("");       jTextField11.setText("");
        jTextField12.setText("");
}//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField12ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCadastroPiloto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    private void editarCadastro() {
         PreparedStatement callStmt = null;

          try{
                this.nome = jTextField2.getText();
                this.rua = jTextField3.getText();
                this.nro = jTextField4.getText();
                this.cidade = jTextField5.getText();
                this.estado = jComboBox2.getSelectedItem().toString();
                //jTextField6.getText();
                this.cep = jTextField7.getText();
                this.nro_licenca = jTextField8.getText();
                this.turno = (jComboBox1.getSelectedItem().toString()).toUpperCase();

              this.horas_voo= jTextField10.getText();
              this.tipo = jTextField11.getText();
              this.salario = jTextField12.getText();
      

              String inicioSQL =  "declare "                   +
                      " erro EXCEPTION;                       "+
                      " PRAGMA EXCEPTION_INIT(erro, -12899); " +
                      " begin                                " +
                      "     PackPessoa.atualizaPessoa(?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
             String fimSQL = "commit; 	" +
                " EXCEPTION "+
		" WHEN DUP_VAL_ON_INDEX THEN "+
			" ROLLBACK; "+
			" raise_application_error( -20004, 'Chave duplicada' ); "+
		" WHEN INVALID_NUMBER OR VALUE_ERROR OR erro THEN "+
			" ROLLBACK; "+
			" raise_application_error( -20007, 'Tipo de dado inválido'); "+		
		" WHEN OTHERS THEN " +
		"	ROLLBACK; " +
		"	raise_application_error( -20003, 'Outros problemas.' ); end; ";

             String meioSQL = "";

              String fone1 = jTextField6.getText();
              String fone2 = jTextField13.getText();
              String fone3 = jTextField9.getText();
              String fone4 = jTextField14.getText();

              System.out.println(this.lista_telefones);
              while(this.lista_telefones.size()<4){
                  this.lista_telefones.add("");
                  System.out.println(this.lista_telefones);
                  System.out.println("o primeiro é:" + this.lista_telefones.get(0)+" e seu tamanho é: "+this.lista_telefones.get(0).length());
              }
              System.out.println(this.lista_telefones);
              if(!this.lista_telefones.get(0).equals(fone1)){
                  if(fone1.isEmpty()){
                      meioSQL+="delete from telefones where cpf= " + this.cpf +" and fone='"+this.lista_telefones.get(0)+"';";
                  }else if (this.lista_telefones.get(0).length()==0){
                      meioSQL+="insert into telefones values(" + this.cpf + ",'" + fone1 + "');" ;
                       }else
                      meioSQL += "update telefones set fone ='" + fone1 +"'  where cpf=" + this.cpf +" and fone='"+this.lista_telefones.get(0)+"';";
              }
              if(!this.lista_telefones.get(1).equals(fone2)){
                  if(fone2.isEmpty()){
                      meioSQL+="delete from telefones where cpf= " + this.cpf +" and fone='"+this.lista_telefones.get(1)+"';";
                  }else if (this.lista_telefones.get(1).isEmpty()){
                      meioSQL+="insert into telefones values(" + this.cpf + ",'" + fone2 + "');" ;
                  }else
                      meioSQL += "update telefones set fone ='" + fone2 +"'  where cpf= " + this.cpf +" and fone='"+this.lista_telefones.get(1)+"';";
              }
              if(!this.lista_telefones.get(2).equals(fone3)){
                  if(fone3.isEmpty()){
                      meioSQL+="delete from telefones where cpf= " + this.cpf +" and fone='"+this.lista_telefones.get(2)+"';";
                  }else if (this.lista_telefones.get(2).isEmpty()){
                      meioSQL+="insert into telefones values(" + this.cpf + " ,'" + fone3 + "');" ;
                  }else
                     meioSQL += "update telefones set fone ='" + fone3 +"'  where cpf= " + this.cpf +" and fone='"+this.lista_telefones.get(2)+"';";
              }
              if(!this.lista_telefones.get(3).equals(fone4)){
                  if(fone4.isEmpty()){
                      meioSQL+="delete from telefones where cpf= " + this.cpf +" and fone='"+this.lista_telefones.get(3)+"';";
                  }else if (this.lista_telefones.get(3).isEmpty()){
                      meioSQL+="insert into telefones values( " + this.cpf + " ,'" + fone4 + "');" ;
                  }else
                      meioSQL += "update telefones set fone ='" + fone4 +"'  where cpf= " + this.cpf +" and fone='"+this.lista_telefones.get(3)+"';";
              }



              String plsql = inicioSQL + meioSQL + fimSQL;
              System.out.println(plsql);

              callStmt = conn.prepareCall(plsql);

              if(this.salario.isEmpty()) this.salario = "0";
              if(this.horas_voo.isEmpty()) this.horas_voo = "0";
              if(this.nro_licenca.isEmpty()) this.nro_licenca = "0";
              if(this.nro.isEmpty()) this.nro = "0";

              callStmt.setDouble(1, Double.parseDouble(this.cpf) );
              callStmt.setString(2, this.nome);
              callStmt.setString(3, this.rua);
              callStmt.setDouble(4, Double.parseDouble(this.nro));
              callStmt.setString(5, this.cidade.toUpperCase());
              callStmt.setString(6, this.estado.toUpperCase());
              callStmt.setString(7, this.cep);
              callStmt.setString(8, this.tipo.toUpperCase());
              callStmt.setDouble(9, Double.parseDouble(salario));
              callStmt.setString(10, this.turno.toUpperCase());
              callStmt.setInt(11, Integer.parseInt(this.nro_licenca));
              callStmt.setInt(12, Integer.parseInt(this.horas_voo));
              callStmt.setBlob(13,  (Blob) null);
              callStmt.setDouble(14, 0);
               callStmt.execute();

               JOptionPane.showMessageDialog(null,"Piloto editado com sucesso");
               this.setVisible(false);
               this.at.setVisible(true); //seta o objeto que criou este como visível.
               this.at.listPilotos();

              }
              catch (SQLException e) {
                    Logger.getLogger(EmpregadoFrame.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
                    int erro = e.getErrorCode();

                    //dado duplicado
                    if(erro == 1 || erro == 20004){
                        JOptionPane.showMessageDialog(null,"Erro. Verifique se o número de lincena está correto.");
                    }else if(erro == 1722 || erro == 6502 || erro == 20007){
                        JOptionPane.showMessageDialog(null,"Tipo de dado inválido. " +
                                "Verifique se os campos estão preenchidos corretamente.");
                    }else{
                             JOptionPane.showMessageDialog(null,"Erro! Feche o programa e tente novamente.");
                    }
                }        catch(NumberFormatException e){
                  e.printStackTrace();
                  JOptionPane.showMessageDialog(null,"Erro! Verifique se não há dados errados nos camos numéricos.");

                }finally {
                          if ( callStmt != null){
                            try {
                            callStmt.close();   //fecha a chamada...
                            } catch (SQLException ex) { Logger.getLogger(EmpregadoFrame.class.getName()).log(Level.SEVERE, null, ex);}
                          }
                      }
    }

    private void listaPilotoIndex() {
                

                  ResultSet rs = null;
                  java.sql.Statement stmt = null;
                  try{



                this.cpf = this.tabela.getValueAt(this.index, 0).toString();
                this.nome = this.tabela.getValueAt(this.index, 1).toString();
                this.rua = this.tabela.getValueAt(this.index, 2).toString();
                this.nro = this.tabela.getValueAt(this.index, 3).toString();
                this.cidade = this.tabela.getValueAt(this.index, 4).toString();
                this.estado = this.tabela.getValueAt(this.index, 5).toString();
                this.cep = this.tabela.getValueAt(this.index, 6).toString();
                this.nro_licenca = this.tabela.getValueAt(this.index, 7).toString();
                this.horas_voo = this.tabela.getValueAt(this.index, 8).toString();

                jTextField1.setText(this.cpf);
                jTextField2.setText(this.nome);
                jTextField3.setText(this.rua);
                jTextField4.setText(this.nro);
                jTextField5.setText(this.cidade);
                jTextField7.setText(this.cep);
                jTextField8.setText(this.nro_licenca);
                jTextField10.setText(this.horas_voo);
                jTextField11.setText("PILOTO");
                jTextField12.setText("");

                      stmt =  this.conn.createStatement();

                      String sql =  "select fone from telefones where cpf =" + this.cpf;

                      ResultSet set = stmt.executeQuery(sql);

                      Vector<String> lista = new Vector();

                      while(set.next()){
                          lista.add(set.getString(1));
                      }
                      this.lista_telefones = lista;

                      int count = lista.size(); 

                      if(count > 0 ){
                          jTextField6.setText(lista.get(0));
                      }
                      if(count > 1){
                          jTextField13.setText(lista.get(1));
                      }
                      if(count > 2){
                          jTextField9.setText(lista.get(2));
                      }
                      if(count > 3){
                          jTextField14.setText(lista.get(3));
                      }
                  }catch(SQLException e){

                  }


    }
}

