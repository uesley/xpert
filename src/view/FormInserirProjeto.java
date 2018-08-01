package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.etapa.Etapa;
import model.projeto.Projeto;
import xPertCore.EtapaCore;

public class FormInserirProjeto extends javax.swing.JFrame {
    private int count = 1;
    public FormInserirProjeto() {
        initComponents();
        configJanela();
    }
    
    public FormInserirProjeto(MenuPrincipal aThis, boolean b) {
        initComponents();
        configJanela();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configJanela (){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Cadastrar Projeto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelProjeto = new javax.swing.JPanel();
        lblProjeto = new javax.swing.JLabel();
        txtProjeto = new javax.swing.JTextField();
        painelAcoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnSimular = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        painelEtapa = new javax.swing.JPanel();
        lblEtapa = new javax.swing.JLabel();
        txtEtapa = new javax.swing.JTextField();
        lblDuracao = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        lblDependencia = new javax.swing.JLabel();
        txtDependencias = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProjeto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inserir Projeto");

        lblProjeto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProjeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProjeto.setText("Projeto");

        txtProjeto.setMinimumSize(new java.awt.Dimension(6, 10));
        txtProjeto.setPreferredSize(new java.awt.Dimension(12, 30));
        txtProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelProjetoLayout = new javax.swing.GroupLayout(painelProjeto);
        painelProjeto.setLayout(painelProjetoLayout);
        painelProjetoLayout.setHorizontalGroup(
            painelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProjetoLayout.createSequentialGroup()
                .addComponent(lblProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );
        painelProjetoLayout.setVerticalGroup(
            painelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        painelAcoes.setPreferredSize(new java.awt.Dimension(225, 25));
        painelAcoes.setLayout(new java.awt.GridLayout(1, 0));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnSalvar);

        btnSimular.setText("Simular");
        painelAcoes.add(btnSimular);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnCancelar);

        painelEtapa.setToolTipText("bvbvbv");
        painelEtapa.setPreferredSize(new java.awt.Dimension(900, 30));
        painelEtapa.setLayout(new java.awt.GridLayout(1, 0));

        lblEtapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEtapa.setText("Etapa");
        lblEtapa.setMaximumSize(new java.awt.Dimension(20, 14));
        lblEtapa.setMinimumSize(new java.awt.Dimension(20, 14));
        lblEtapa.setPreferredSize(new java.awt.Dimension(20, 14));
        painelEtapa.add(lblEtapa);
        painelEtapa.add(txtEtapa);

        lblDuracao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDuracao.setText("Duração");
        lblDuracao.setMaximumSize(new java.awt.Dimension(20, 14));
        lblDuracao.setMinimumSize(new java.awt.Dimension(20, 14));
        lblDuracao.setPreferredSize(new java.awt.Dimension(20, 14));
        painelEtapa.add(lblDuracao);

        txtDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracaoActionPerformed(evt);
            }
        });
        painelEtapa.add(txtDuracao);

        lblDependencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDependencia.setText("Dependências");
        lblDependencia.setMaximumSize(new java.awt.Dimension(20, 14));
        lblDependencia.setMinimumSize(new java.awt.Dimension(20, 14));
        lblDependencia.setPreferredSize(new java.awt.Dimension(20, 14));
        painelEtapa.add(lblDependencia);

        txtDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDependenciasActionPerformed(evt);
            }
        });
        painelEtapa.add(txtDependencias);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        painelEtapa.add(btnInserir);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        painelEtapa.add(btnRemover);

        jTProjeto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Etapa", "Duração", "Dependências"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTProjeto);
        if (jTProjeto.getColumnModel().getColumnCount() > 0) {
            jTProjeto.getColumnModel().getColumn(0).setResizable(false);
            jTProjeto.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTProjeto.getColumnModel().getColumn(1).setResizable(false);
            jTProjeto.getColumnModel().getColumn(2).setResizable(false);
            jTProjeto.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Descrição");

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelEtapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(painelEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelEtapa.getAccessibleContext().setAccessibleName("Adicionar Etapa");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProjetoActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        DefaultTableModel dtmEtapas = (DefaultTableModel) jTProjeto.getModel();
        Object[] dados = {count, txtEtapa.getText(), txtDuracao.getText(), txtDependencias.getText()};
        if (txtDependencias.getText().length() > 0){
            String[] dp = txtDependencias.getText().split(",");
            for( String d : dp){
                int i = Integer.parseInt(d);
                if (i >= count || i <= 0){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar dependencia "+i,"ERRO",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        
        dtmEtapas.addRow(dados);
        //jTProjeto.
        count++;
    }//GEN-LAST:event_btnInserirActionPerformed

    private void txtDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDependenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDependenciasActionPerformed

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracaoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ArrayList<EtapaCore> etapas = new ArrayList();
        Projeto projeto = new Projeto();
        projeto.setNome(txtProjeto.getText());
        projeto.setSimulado(false);
        projeto.setSituacao(0.0f);
        projeto.save();
        
        int[] dependences;
        for (int linha = 0; linha < jTProjeto.getRowCount(); linha++){
            Etapa e = new Etapa(projeto.getId());
            e.setNome(jTProjeto.getModel().getValueAt(linha, 1).toString());
            e.setDuracao_prevista(Integer.parseInt(jTProjeto.getModel().getValueAt(linha, 2).toString()));
            e.save();
            if (jTProjeto.getModel().getValueAt(linha, 3).toString().length() > 0){
                String[] dp = jTProjeto.getModel().getValueAt(linha, 3).toString().split(",");
                for( String d : dp){
                    int i = Integer.parseInt(d);
                    if (i >= count || i < 0){
                        JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar dependencia "+i);
                        continue;
                    }
                    e.addDependencia(i);
                }
            }
        }
        /*String data = JOptionPane.showInputDialog(rootPane, "Digite a data de início:");
        */
        //Como instanciar uma data e adcionar dias a DATA, será preciso a adição disso em projeto core, e projeto e no banco de dados.
        /*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        JOptionPane.showMessageDialog(rootPane, "Data de inicio: "+formatter.format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,120);
        date = cal.getTime();
        JOptionPane.showMessageDialog(rootPane, formatter.format(date));*/
        
        JOptionPane.showMessageDialog(this, "Projeto Salvo com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed


    
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int selected = jTProjeto.getSelectedRow();
        if (JOptionPane.showConfirmDialog(this, 
                "Remover esta etapa removerá tadas as etapas que dependem dela. Continuar?",
                "Confirmar operação",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE) == JOptionPane.CANCEL_OPTION)
            return;
        int rm[] = new int[count];
        dependenciasLinha(selected,rm);
        for (int i =jTProjeto.getRowCount()-1; i >= 0; i--)
            if (rm[i]>0){
                ((DefaultTableModel) jTProjeto.getModel()).removeRow(i);
            }
        for(int i = 0 ; i <jTProjeto.getRowCount(); i++)
            jTProjeto.setValueAt(Integer.toString(i+1), i, 0);
    }//GEN-LAST:event_btnRemoverActionPerformed

    
    private void dependenciasLinha(int selected, int rm[]){
        count--;
        selected +=1;
        for(int i = 0; i< jTProjeto.getRowCount(); i++){
            if (jTProjeto.getValueAt(i, 3).toString().equals("")){
                continue;
            }
            String deps[] = jTProjeto.getValueAt(i, 3)
                            .toString()
                            .split(",");
            for (String d : deps){
                if (d.equals(Integer.toString(selected))){
                    dependenciasLinha(i,rm);
                }
            }
        }
        rm[selected-1] = selected;
        System.out.println("rm : "+selected);
    }
    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormInserirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInserirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInserirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInserirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormInserirProjeto().setVisible(true);
                FormInserirProjeto  form = new FormInserirProjeto();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSimular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProjeto;
    private javax.swing.JLabel lblDependencia;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblEtapa;
    private javax.swing.JLabel lblProjeto;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelEtapa;
    private javax.swing.JPanel painelProjeto;
    private javax.swing.JPanel painelTabela;
    private javax.swing.JTextField txtDependencias;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtEtapa;
    private javax.swing.JTextField txtProjeto;
    // End of variables declaration//GEN-END:variables
}
