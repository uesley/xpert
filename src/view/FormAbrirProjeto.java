package view;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.projeto.Projeto;

public class FormAbrirProjeto extends javax.swing.JFrame {

    private ArrayList<Projeto> listaProjetos = new Projeto().get();

    public FormAbrirProjeto() {
        initComponents();
        configJanela();
    }

    public FormAbrirProjeto(MenuPrincipal aThis, boolean b) {
        initComponents();
        configJanela();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configJanela() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Projetos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        //this.listProjetos = new JList<>(value.toArray(new String[0]));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelAcoes = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        listScroll = new javax.swing.JScrollPane();
        listProjetos = fillProjectTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelAcoes.setPreferredSize(new java.awt.Dimension(1000, 700));
        painelAcoes.setLayout(new java.awt.GridLayout(1, 0));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        painelAcoes.add(btnAbrir);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        painelAcoes.add(btnExcluir);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnCancelar);

        listProjetos.setMaximumSize(new java.awt.Dimension(30, 80));
        listProjetos.setMinimumSize(new java.awt.Dimension(30, 80));
        listScroll.setViewportView(listProjetos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(listScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        int item;
        item = listProjetos.getSelectedIndex();
        JOptionPane.showMessageDialog(null, item);
//        listaProjetos.get(item)
        JFrame newWindow = new FormInfoProjeto(listaProjetos.get(item));
        newWindow.setVisible(true);
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void refreshJlist() {
        listaProjetos = new Projeto().get();
        String settings[] = new String[this.listaProjetos.size()];
        int i = 0;
        for (Projeto projeto : listaProjetos) {
            settings[i++] = projeto.getNome();
        }

        listProjetos = new JList<>(settings);
        listProjetos.setMaximumSize(new java.awt.Dimension(30, 80));
        listProjetos.setMinimumSize(new java.awt.Dimension(30, 80));
        listScroll.setViewportView(listProjetos);
    }
    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       int index = listProjetos.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um projeto para excluir");
            return;
        }
        if (JOptionPane.showConfirmDialog(this,
                "Esta ação não pode ser desfeita e apagará as etapas cadastradas no projeto.\nContinuar mesmo assim?",
                "Deseja Excluir este projeto?",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.OK_OPTION) {
            listaProjetos.get(index).delete();
        }
        refreshJlist();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(FormAbrirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAbrirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAbrirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAbrirProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FormAbrirProjeto form = new FormAbrirProjeto();
            form.setLocationRelativeTo(null);
            form.setVisible(true);
        });
    }

    private JList fillProjectTable() {
        listaProjetos = new Projeto().get();
        String settings[] = new String[this.listaProjetos.size()];
        int i = 0;
        for (Projeto projeto : listaProjetos) {
            settings[i++] = projeto.getNome();
        }
        return new JList<>(settings);
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JList<String> listProjetos;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JPanel painelAcoes;
    // End of variables declaration//GEN-END:variables
}
