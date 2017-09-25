package PanelModifié;

import java.awt.BorderLayout;

public class KeyWordsPanel extends javax.swing.JPanel {

    public KeyWordsPanel() {
        initComponents();
        initComponents();
        jpPrinc.setVisible(false);
        jpPrinc.removeAll();
        jpPrinc.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpPrinc = new javax.swing.JPanel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jbAdd3 = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        jpPrinc.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpPrinc, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 250, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrinc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 893, 530));

        jInternalFrame4.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame4.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame4.setVisible(true);

        jbAdd3.setBackground(new java.awt.Color(0, 51, 204));
        jbAdd3.setText("AJOUTER");
        jbAdd3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbAdd3MouseReleased(evt);
            }
        });
        jbAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdd3ActionPerformed(evt);
            }
        });

        jBUpdate.setBackground(new java.awt.Color(0, 51, 204));
        jBUpdate.setText("MODIFIER");
        jBUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAdd3, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jBUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jbAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(457, Short.MAX_VALUE))
        );

        add(jInternalFrame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void jbAdd3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAdd3MouseReleased

    }//GEN-LAST:event_jbAdd3MouseReleased

    private void jbAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdd3ActionPerformed
        jpPrinc.removeAll();
        jpPrinc.validate();
        jpPrinc.add(new KeywordsAddPanel(), BorderLayout.CENTER);
        jpPrinc.revalidate();
        jpPrinc.setVisible(true);
    }//GEN-LAST:event_jbAdd3ActionPerformed

    private void jBUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateActionPerformed
        jpPrinc.removeAll();
        jpPrinc.validate();
        jpPrinc.add(new KeywordsUpdatePanel(), BorderLayout.CENTER);
        jpPrinc.revalidate();
        jpPrinc.setVisible(true);
    }//GEN-LAST:event_jBUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBUpdate;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbAdd1;
    private javax.swing.JButton jbAdd2;
    private javax.swing.JButton jbAdd3;
    private javax.swing.JPanel jpPrinc;
    // End of variables declaration//GEN-END:variables
}
