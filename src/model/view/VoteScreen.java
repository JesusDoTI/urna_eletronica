/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.bean.Candidato;
import model.bean.Eleitor;
import model.dao.CandidatoDAO;
import model.dao.ImagemDAO;
import model.dao.VotoDAO;

/**
 *
 * @author Rafael
 */
public final class VoteScreen extends javax.swing.JFrame {

    Eleitor eleitor = new Eleitor();
    Candidato candidato;
    CandidatoDAO candidatoDAO = new CandidatoDAO();
    ImagemDAO imagemDAO = new ImagemDAO();

    public VoteScreen(Eleitor eleitor) {
        initComponents();
        initComplements();
        this.eleitor = eleitor;
    }

    public VoteScreen() {
        initComponents();
        initComplements();
    }

    public void initComplements() {
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCandidato = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        btnConfirma = new javax.swing.JButton();
        btnBranco = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();
        lblChapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/icon/if.PNG"))); // NOI18N

        txtCandidato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCandidatoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCandidatoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtCandidato);

        jLabel1.setText("Número do Candidato");

        btnConfirma.setText("Confirma");
        btnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaActionPerformed(evt);
            }
        });

        btnBranco.setText("Branco");
        btnBranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrancoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBranco, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChapa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirma)
                            .addComponent(btnBranco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblChapa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrancoActionPerformed
        VotoDAO votoDAO = new VotoDAO();
        votoDAO.whiteVote(eleitor.getCpf());
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBrancoActionPerformed

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        VotoDAO votoDAO = new VotoDAO();
        votoDAO.vote(Integer.parseInt(txtCandidato.getText()), eleitor.getCpf());
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void txtCandidatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCandidatoKeyReleased
        candidato = candidatoDAO.select(Integer.parseInt(txtCandidato.getText()));
        lblChapa.setText("Chapa: " + candidato.getChapa());
        try {
            InputStream is = imagemDAO.selectImage(candidato.getImage().getCod());
            byte[] imgByte = new byte[(int) candidato.getImage().getSize()];
            is.read(imgByte);
            ImageIcon image = new ImageIcon(imgByte);
            image.setImage(image.getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_DEFAULT));
            lblImagem.setIcon(image);
            lblImagem.setAlignmentX(NORMAL);
            lblImagem.setAlignmentY(JLabel.CENTER);

        } catch (IOException | NullPointerException ex) {
            lblImagem.setIcon(null);
        }
    }//GEN-LAST:event_txtCandidatoKeyReleased

    private void txtCandidatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCandidatoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCandidatoKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VoteScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoteScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBranco;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChapa;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextPane txtCandidato;
    // End of variables declaration//GEN-END:variables
}
