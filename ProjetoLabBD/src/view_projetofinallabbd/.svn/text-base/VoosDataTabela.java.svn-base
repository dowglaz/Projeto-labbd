
/*
 * VoosDataTabela.java
 *
 * Created on 04/12/2009, 13:59:19
 */

package view_projetofinallabbd;

import controler_projetofinallabbd.*;
import model_projetofinallabbd.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.*;

public class VoosDataTabela extends javax.swing.JFrame {

    /** Creates new form VoosDataTabela
     * @param origem
     * @param destino 
     */
    private JFrame chamou;
    private int index_diretos = 0;
    private int index_tres_trechos = 0;
    private int index_dois_trechos = 0;
    Classe classe = null;
    Aeroporto aero_origem = new Aeroporto();
    Aeroporto aero_destino = new Aeroporto();
    private Vector<Vector<Voo>> voos = new Vector<Vector<Voo>>();
    public VoosDataTabela(Object origem, Object destino, java.sql.Date data, String classe, java.sql.Timestamp hora_inf, java.sql.Timestamp hora_sup) {
        initComponents();
        setLocationRelativeTo(null);
        ControllerVoo cv = new ControllerVoo();
        aero_origem = (Aeroporto) origem;
        aero_destino = (Aeroporto) destino;
        this.classe = new Classe(classe);
        voos = cv.fetchVoosDatas(aero_origem.getCodigo(), aero_destino.getCodigo(), data, classe, hora_inf, hora_sup);
        this.fillVoos();
    }

    public VoosDataTabela() {
        this(new Object(),new Object(), new java.sql.Date(0), new String(), new java.sql.Timestamp(0), new java.sql.Timestamp(0));
    }

    private void fillVoos(){
        this.fillVoosDiretos();
        this.fillVoosDoisTrechos();
        this.fillVoosTresTrechos();
    }

     public JFrame getChamou() {
        return chamou;
    }

    public void setChamou(JFrame chamou) {
        this.chamou = chamou;
    }

    private void fillVoosDiretos(){
        this.jLabel2.setText(this.aero_origem.getNome());
        this.jLabel4.setText(this.aero_destino.getNome());
        this.jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String[]{"Numero do trecho","Aeroporto partida","Hora partida","Aeroporto chegada","Hora chegada"}));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // 0 - diretos
        // 1 - dois trechos
        // 2 - tres trechos
        try{
            // tenta pegar os dados do vetor de voos diretos
            this.jLabel40.setText(Integer.toString(voos.get(0).get(index_diretos).getNumero()));
            this.jLabel43.setText(Double.toString(voos.get(0).get(index_diretos).getTarifa(this.classe)));
            this.jLabel45.setText(voos.get(0).get(index_diretos).getCompanhiaAerea());
            this.jLabel17.setText(Integer.toString(index_diretos+1));
            this.jLabel19.setText(Integer.toString(voos.get(0).size()));
            try{
                Vector<Trecho> trecho_tmp = new Vector<Trecho>();
                trecho_tmp = voos.get(0).get(this.index_diretos).getTrechos();
                for (int i = 0; i < trecho_tmp.size(); i++){
                    model.addRow( new Object[]{trecho_tmp.get(i).getNumero(), trecho_tmp.get(i).getAeroporto_partida().getNome(), trecho_tmp.get(i).getHora_partida(), trecho_tmp.get(i).getAeroporto_chegada().getNome(), trecho_tmp.get(i).getHora_chegada()});
                }
            }catch (java.lang.ArrayIndexOutOfBoundsException a){
                javax.swing.JOptionPane.showMessageDialog(null,"O voo nao contem trechos.");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }catch (ArrayIndexOutOfBoundsException e){
            this.jLabel1.setText("Nao existem voos que partem de ");
            this.jPanel1.remove(jScrollPane1);
            this.jPanel1.remove(jLabel40);
            this.jPanel1.remove(jLabel41);
            this.jPanel1.remove(jLabel42);
            this.jPanel1.remove(jLabel44);
            this.jPanel1.remove(jLabel45);
            this.jPanel1.remove(jLabel16);
            this.jPanel1.remove(jLabel17);
            this.jPanel1.remove(jLabel18);
            this.jPanel1.remove(jLabel19);
            this.jPanel1.remove(jLabel46);
            this.jPanel1.remove(jLabel43);
            this.jPanel1.remove(jButton3);
            this.jPanel1.remove(direto_primVooBt);
            this.jPanel1.remove(direto_proxVooBt);
            this.jPanel1.remove(direto_ultVooBt);
            this.jPanel1.remove(direto_vooAntBt);
        }catch (NullPointerException e){
            this.jLabel40.setText(" ");
            this.jLabel43.setText(" ");
            this.jLabel45.setText(" ");
            javax.swing.JOptionPane.showMessageDialog(null,"Erro ao referenciar conjunto de voos diretos. Contate os desenvolvedores.","Erro",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void fillVoosDoisTrechos(){
        this.jLabel12.setText(this.aero_origem.getNome());
        this.jLabel14.setText(this.aero_destino.getNome());
        this.jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String[]{"Numero do trecho","Aeroporto partida","Hora partida","Aeroporto chegada","Hora chegada"}));
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        // 0 - diretos
        // 1 - dois trechos
        // 2 - tres trechos
        try{
            // tenta pegar os dados do vetor de voos diretos
            this.jLabel34.setText(Integer.toString(voos.get(1).get(index_dois_trechos).getNumero()));
            this.jLabel37.setText(Double.toString(voos.get(1).get(index_dois_trechos).getTarifa(this.classe)));
            this.jLabel39.setText(voos.get(1).get(index_diretos).getCompanhiaAerea());
            this.jLabel23.setText(Integer.toString(index_dois_trechos+1));
            this.jLabel22.setText(Integer.toString(voos.get(1).size()));
            try{
                Vector<Trecho> trecho_tmp = new Vector<Trecho>();
                trecho_tmp = voos.get(1).get(this.index_dois_trechos).getTrechos();
                for (int i = 0; i < trecho_tmp.size(); i++){
                    model.addRow( new Object[]{trecho_tmp.get(i).getNumero(), trecho_tmp.get(i).getAeroporto_partida().getNome(), trecho_tmp.get(i).getHora_partida(), trecho_tmp.get(i).getAeroporto_chegada().getNome(), trecho_tmp.get(i).getHora_chegada()});
                }
            }catch (java.lang.ArrayIndexOutOfBoundsException a){
                javax.swing.JOptionPane.showMessageDialog(null,"O voo nao contem trechos.");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }catch (ArrayIndexOutOfBoundsException e){
            this.jLabel6.setText("Nao existem voos que partem de ");
            this.jPanel2.remove(jScrollPane2);
            this.jPanel2.remove(jLabel20);
            this.jPanel2.remove(jLabel21);
            this.jPanel2.remove(jLabel22);
            this.jPanel2.remove(jLabel23);
            this.jPanel2.remove(jLabel34);
            this.jPanel2.remove(jLabel35);
            this.jPanel2.remove(jLabel36);
            this.jPanel2.remove(jLabel37);
            this.jPanel2.remove(jLabel38);
            this.jPanel2.remove(jLabel39);
            this.jPanel2.remove(jLabel48);
            this.jPanel2.remove(jButton5);
            this.jPanel2.remove(dois_trechos_proxVooBt);
            this.jPanel2.remove(dois_trechos_primVooBt);
            this.jPanel2.remove(dois_trechos_vooAntBt);
            this.jPanel2.remove(dois_trechos_ultVooBt);
        }catch (NullPointerException e){
            this.jLabel34.setText(" ");
            this.jLabel37.setText(" ");
            this.jLabel39.setText(" ");
            javax.swing.JOptionPane.showMessageDialog(null,"Erro ao referenciar conjunto de voos em dois trechos. Contate os desenvolvedores.","Erro",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void fillVoosTresTrechos(){
        this.jLabel7.setText(this.aero_origem.getNome());
        this.jLabel9.setText(this.aero_destino.getNome());
        this.jTable3.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String[]{"Numero do trecho","Aeroporto partida","Hora partida","Aeroporto chegada","Hora chegada"}));
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        // 0 - diretos
        // 1 - dois trechos
        // 2 - tres trechos
        try{
            // tenta pegar os dados do vetor de voos diretos
            this.jLabel29.setText(Integer.toString(voos.get(2).get(index_tres_trechos).getNumero()));
            this.jLabel33.setText(Double.toString(voos.get(2).get(index_tres_trechos).getTarifa(this.classe)));
            this.jLabel30.setText(voos.get(2).get(index_tres_trechos).getCompanhiaAerea());
            this.jLabel26.setText(Integer.toString(index_tres_trechos+1));
            this.jLabel27.setText(Integer.toString(voos.get(2).size()));
            try{
                Vector<Trecho> trecho_tmp = new Vector<Trecho>();
                trecho_tmp = voos.get(2).get(this.index_tres_trechos).getTrechos();
                for (int i = 0; i < trecho_tmp.size(); i++){
                    model.addRow( new Object[]{trecho_tmp.get(i).getNumero(), trecho_tmp.get(i).getAeroporto_partida().getNome(), trecho_tmp.get(i).getHora_partida(), trecho_tmp.get(i).getAeroporto_chegada().getNome(), trecho_tmp.get(i).getHora_chegada()});
                }
            }catch (java.lang.ArrayIndexOutOfBoundsException a){
                javax.swing.JOptionPane.showMessageDialog(null,"O voo nao contem trechos.");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }catch (ArrayIndexOutOfBoundsException e){
            this.jLabel11.setText("Nao existem voos que partem de ");
            this.jPanel3.remove(jScrollPane3);
            this.jPanel3.remove(jLabel30);
            this.jPanel3.remove(jLabel31);
            this.jPanel3.remove(jLabel32);
            this.jPanel3.remove(jLabel33);
            this.jPanel3.remove(jLabel24);
            this.jPanel3.remove(jLabel25);
            this.jPanel3.remove(jLabel26);
            this.jPanel3.remove(jLabel27);
            this.jPanel3.remove(jLabel28);
            this.jPanel3.remove(jLabel29);
            this.jPanel3.remove(jLabel47);
            this.jPanel3.remove(jButton4);
            this.jPanel3.remove(tres_trechos_primVooBt);
            this.jPanel3.remove(tres_trechos_proxVooBt);
            this.jPanel3.remove(tres_trechos_UltVooBt);
            this.jPanel3.remove(tres_trechos_vooAntBt);
        }catch (NullPointerException e){
            this.jLabel30.setText(" ");
            this.jLabel33.setText(" ");
            this.jLabel29.setText(" ");
            javax.swing.JOptionPane.showMessageDialog(null,"Erro ao referenciar conjunto de voos em tres trechos. Contate os desenvolvedores.","Erro",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        direto_proxVooBt = new javax.swing.JButton();
        direto_primVooBt = new javax.swing.JButton();
        direto_ultVooBt = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        direto_vooAntBt = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        dois_trechos_primVooBt = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        dois_trechos_vooAntBt = new javax.swing.JButton();
        dois_trechos_proxVooBt = new javax.swing.JButton();
        dois_trechos_ultVooBt = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tres_trechos_primVooBt = new javax.swing.JButton();
        tres_trechos_proxVooBt = new javax.swing.JButton();
        tres_trechos_UltVooBt = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tres_trechos_vooAntBt = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta de voos em datas");

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Aeroporto partida", "Horario partida", "Aeroporto chegada", "Horario chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Voos que partem de ");

        jLabel2.setText("ORIGEM");

        jLabel3.setText("e vão até");

        jLabel4.setText("DESTINO");

        jLabel5.setText("em um trecho (diretos)");

        direto_proxVooBt.setText("Próximo voo");
        direto_proxVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direto_proxVooBtActionPerformed(evt);
            }
        });

        direto_primVooBt.setText("Primeiro voo");
        direto_primVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direto_primVooBtActionPerformed(evt);
            }
        });

        direto_ultVooBt.setText("Ultimo voo");
        direto_ultVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direto_ultVooBtActionPerformed(evt);
            }
        });

        jLabel16.setText("Mostrando voo");

        jLabel17.setText("i");

        jLabel18.setText("de");

        jLabel19.setText("N");

        jLabel40.setText("<voo.numero>");

        jLabel41.setText("Numero do voo:");

        jLabel42.setText("Valor da tarifa:");

        jLabel43.setText("<voo.tarifa>");

        jLabel44.setText("Companhia aérea");

        jLabel45.setText("<voo.companhia_aerea>");

        direto_vooAntBt.setText("Voo anterior");
        direto_vooAntBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direto_vooAntBtActionPerformed(evt);
            }
        });

        jLabel46.setText("Trechos");

        jButton3.setText("Fazer reserva");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel43))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(direto_primVooBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(direto_vooAntBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(direto_proxVooBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(direto_ultVooBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direto_proxVooBt)
                    .addComponent(direto_primVooBt)
                    .addComponent(direto_ultVooBt)
                    .addComponent(direto_vooAntBt)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Voos diretos", jPanel1);

        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Aeroporto partida", "Horario partida", "Aeroporto chegada", "Horario chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setDragEnabled(true);
        jTable2.setEnabled(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setText("Voos que partem de ");

        jLabel7.setText("ORIGEM");

        jLabel8.setText("e vão até");

        jLabel9.setText("DESTINO");

        jLabel10.setText("em dois trechos");

        jLabel20.setText("Mostrando voo");

        jLabel21.setText("de");

        jLabel22.setText("i");

        jLabel23.setText("N");

        dois_trechos_primVooBt.setText("Primeiro voo");
        dois_trechos_primVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dois_trechos_primVooBtActionPerformed(evt);
            }
        });

        jLabel34.setText("<voo.numero>");

        jLabel35.setText("Numero do voo:");

        jLabel36.setText("Valor da tarifa:");

        jLabel37.setText("<voo.tarifa>");

        jLabel38.setText("Companhia aérea");

        jLabel39.setText("<voo.companhia_aerea>");

        dois_trechos_vooAntBt.setText("Voo anterior");
        dois_trechos_vooAntBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dois_trechos_vooAntBtActionPerformed(evt);
            }
        });

        dois_trechos_proxVooBt.setText("Próximo voo");
        dois_trechos_proxVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dois_trechos_proxVooBtActionPerformed(evt);
            }
        });

        dois_trechos_ultVooBt.setText("Ultimo voo");
        dois_trechos_ultVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dois_trechos_ultVooBtActionPerformed(evt);
            }
        });

        jLabel48.setText("Trechos");

        jButton5.setText("Fazer reserva");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37))
                    .addComponent(jLabel48)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(dois_trechos_primVooBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dois_trechos_vooAntBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dois_trechos_proxVooBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dois_trechos_ultVooBt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel34)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel38)
                                    .addGap(18, 18, 18)))
                            .addComponent(jLabel39))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dois_trechos_primVooBt)
                    .addComponent(dois_trechos_vooAntBt)
                    .addComponent(dois_trechos_ultVooBt)
                    .addComponent(dois_trechos_proxVooBt)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        dois_trechos_primVooBt.getAccessibleContext().setAccessibleParent(jPanel3);
        dois_trechos_vooAntBt.getAccessibleContext().setAccessibleParent(jPanel3);
        dois_trechos_proxVooBt.getAccessibleContext().setAccessibleParent(jPanel3);
        dois_trechos_ultVooBt.getAccessibleContext().setAccessibleParent(jPanel3);

        jTabbedPane1.addTab("Voos em dois trechos", jPanel2);

        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Aeroporto partida", "Horario partida", "Aeroporto chegada", "Horario chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setDragEnabled(true);
        jTable3.setEnabled(false);
        jScrollPane3.setViewportView(jTable3);

        jLabel11.setText("Voos que partem de ");

        jLabel12.setText("ORIGEM");

        jLabel13.setText("e vão até");

        jLabel14.setText("DESTINO");

        jLabel15.setText("em tres trechos");

        jLabel24.setText("Mostrando voo");

        jLabel25.setText("de");

        jLabel26.setText("i");

        jLabel27.setText("N");

        tres_trechos_primVooBt.setText("Primeiro voo");
        tres_trechos_primVooBt.setName(""); // NOI18N
        tres_trechos_primVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres_trechos_primVooBtActionPerformed(evt);
            }
        });

        tres_trechos_proxVooBt.setText("Próximo voo");
        tres_trechos_proxVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres_trechos_proxVooBtActionPerformed(evt);
            }
        });

        tres_trechos_UltVooBt.setText("Ultimo voo");
        tres_trechos_UltVooBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres_trechos_UltVooBtActionPerformed(evt);
            }
        });

        jLabel28.setText("Numero do voo:");

        jLabel29.setText("<voo.numero>");

        jLabel30.setText("<voo.companhia_aerea>");

        jLabel31.setText("Companhia aérea");

        jLabel32.setText("Valor da tarifa:");

        jLabel33.setText("<voo.tarifa>");

        tres_trechos_vooAntBt.setText("Voo anterior");
        tres_trechos_vooAntBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres_trechos_vooAntBtActionPerformed(evt);
            }
        });

        jLabel47.setText("Trechos");

        jButton4.setText("Fazer reserva");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tres_trechos_primVooBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres_trechos_vooAntBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres_trechos_proxVooBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres_trechos_UltVooBt)
                        .addGap(189, 189, 189)
                        .addComponent(jButton4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addComponent(jLabel47)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel30))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tres_trechos_primVooBt)
                    .addComponent(tres_trechos_vooAntBt)
                    .addComponent(tres_trechos_UltVooBt)
                    .addComponent(tres_trechos_proxVooBt)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Voos em tres trechos", jPanel3);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Fazer outra consulta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.chamou.dispose();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void direto_vooAntBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direto_vooAntBtActionPerformed
        if(this.index_diretos >= 1){
            this.index_diretos--;
            this.fillVoosDiretos();
        }
    }//GEN-LAST:event_direto_vooAntBtActionPerformed

    private void tres_trechos_vooAntBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres_trechos_vooAntBtActionPerformed
        if(this.index_tres_trechos >= 1){
            this.index_tres_trechos--;
            this.fillVoosTresTrechos();
        }
    }//GEN-LAST:event_tres_trechos_vooAntBtActionPerformed

    private void direto_primVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direto_primVooBtActionPerformed
        this.index_diretos = 0;
        this.fillVoosDiretos();
    }//GEN-LAST:event_direto_primVooBtActionPerformed

    private void direto_proxVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direto_proxVooBtActionPerformed
        if(index_diretos < voos.get(0).size() - 1){
            this.index_diretos++;
            this.fillVoosDiretos();
        }
    }//GEN-LAST:event_direto_proxVooBtActionPerformed

    private void direto_ultVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direto_ultVooBtActionPerformed
        this.index_diretos = this.voos.get(0).size() - 1;
        this.fillVoosDiretos();
    }//GEN-LAST:event_direto_ultVooBtActionPerformed

    private void tres_trechos_primVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres_trechos_primVooBtActionPerformed
        this.index_tres_trechos = 0;
        this.fillVoosTresTrechos();
    }//GEN-LAST:event_tres_trechos_primVooBtActionPerformed

    private void tres_trechos_proxVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres_trechos_proxVooBtActionPerformed
        if(index_tres_trechos < voos.get(2).size() - 1){
            this.index_tres_trechos++;
            this.fillVoosTresTrechos();
        }
    }//GEN-LAST:event_tres_trechos_proxVooBtActionPerformed

    private void tres_trechos_UltVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres_trechos_UltVooBtActionPerformed
        this.index_tres_trechos = this.voos.get(2).size() - 1;
        this.fillVoosTresTrechos();
    }//GEN-LAST:event_tres_trechos_UltVooBtActionPerformed

    private void dois_trechos_primVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dois_trechos_primVooBtActionPerformed
        this.index_dois_trechos = 0;
        this.fillVoosDoisTrechos();
    }//GEN-LAST:event_dois_trechos_primVooBtActionPerformed

    private void dois_trechos_vooAntBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dois_trechos_vooAntBtActionPerformed
        if(this.index_dois_trechos >= 1){
            this.index_dois_trechos--;
            this.fillVoosDoisTrechos();
        }
    }//GEN-LAST:event_dois_trechos_vooAntBtActionPerformed

    private void dois_trechos_proxVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dois_trechos_proxVooBtActionPerformed
        if(index_dois_trechos < voos.get(1).size() - 1){
            this.index_diretos++;
            this.fillVoosDoisTrechos();
        }
    }//GEN-LAST:event_dois_trechos_proxVooBtActionPerformed

    private void dois_trechos_ultVooBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dois_trechos_ultVooBtActionPerformed
        this.index_dois_trechos = this.voos.get(1).size() - 1;
        this.fillVoosDoisTrechos();
    }//GEN-LAST:event_dois_trechos_ultVooBtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoosDataTabela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton direto_primVooBt;
    private javax.swing.JButton direto_proxVooBt;
    private javax.swing.JButton direto_ultVooBt;
    private javax.swing.JButton direto_vooAntBt;
    private javax.swing.JButton dois_trechos_primVooBt;
    private javax.swing.JButton dois_trechos_proxVooBt;
    private javax.swing.JButton dois_trechos_ultVooBt;
    private javax.swing.JButton dois_trechos_vooAntBt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton tres_trechos_UltVooBt;
    private javax.swing.JButton tres_trechos_primVooBt;
    private javax.swing.JButton tres_trechos_proxVooBt;
    private javax.swing.JButton tres_trechos_vooAntBt;
    // End of variables declaration//GEN-END:variables

}
