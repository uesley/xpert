package view;

import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

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

        btnImportar.setText("importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        btnExportar.setText("exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(listScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportar)
                    .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        int item;
        item = listProjetos.getSelectedIndex();
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
                "Esta ação não pode ser desfeita e apagará "
                        + "as etapas cadastradas no projeto.\nContinuar mesmo assim?",
                "Deseja Excluir este projeto?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
            listaProjetos.get(index).delete();
        }
        refreshJlist();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        int item = listProjetos.getSelectedIndex();
        if (item < 0){
            JOptionPane.showMessageDialog(null, 
                    "Selecione um projeto para exportar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Projeto p = listaProjetos.get(item);
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "xpert Files", "xpert");
        chooser.setFileFilter(filter);
        String nameFile = "";
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) 
            return;
        nameFile = chooser.getSelectedFile().getAbsolutePath() + ".xpert";
        System.out.println("You chose to open this file: " + nameFile);
        p.export(nameFile);
        JOptionPane.showMessageDialog(null, 
                "Projeto foi exportado para: "+nameFile,
                "Resultado da Exportação",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "xpert Files", "xpert");
        chooser.setFileFilter(filter);
        String nameFile = "";
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) 
            return;
        nameFile = chooser.getSelectedFile().getAbsolutePath();
        System.out.println("You chose to open this file: " + nameFile);
        String projectName = JOptionPane.showInputDialog(null,
                "Entre com um nome para o projeto",
                "",
                JOptionPane.INFORMATION_MESSAGE);
        new Projeto().acquire(nameFile, projectName);
        refreshJlist();
    }//GEN-LAST:event_btnImportarActionPerformed

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
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JList<String> listProjetos;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JPanel painelAcoes;
    // End of variables declaration//GEN-END:variables
}
