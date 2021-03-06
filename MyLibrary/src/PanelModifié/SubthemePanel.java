
package PanelModifié;


public class SubthemePanel extends javax.swing.JPanel {

    
    public SubthemePanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jbAdd = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jpPrinc = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setVisible(true);

        jbAdd.setBackground(new java.awt.Color(0, 51, 204));
        jbAdd.setText("AJOUTER");
        jbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbAddMouseReleased(evt);
            }
        });
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jBUpdate.setBackground(new java.awt.Color(0, 51, 204));
        jBUpdate.setText("MODIFIER");
        jBUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateActionPerformed(evt);
            }
        });

        jBDelete.setBackground(new java.awt.Color(0, 51, 204));
        jBDelete.setText("DESACTIVER");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jBDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(417, Short.MAX_VALUE))
        );

        add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        jpPrinc.setBackground(new java.awt.Color(255, 255, 255));
        add(jpPrinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 643, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        jpPrinc.removeAll();
        jpPrinc.add(new SubthemeAddPanel());
        jpPrinc.revalidate();
        jpPrinc.setVisible(true);
    }//GEN-LAST:event_jbAddActionPerformed

    private void jBUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateActionPerformed
        jpPrinc.removeAll();
        jpPrinc.validate();
        jpPrinc.add(new SubthemeUpdatePanel());
        jpPrinc.revalidate();
        jpPrinc.setVisible(true);
    }//GEN-LAST:event_jBUpdateActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        jpPrinc.removeAll();
        jpPrinc.validate();
        jpPrinc.add(new SubthemeDeletePanel());
        jpPrinc.revalidate();
        jpPrinc.setVisible(true);
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jbAddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAddMouseReleased

                                  
// TODO add your handling code here:
    }//GEN-LAST:event_jbAddMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBUpdate;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JPanel jpPrinc;
    // End of variables declaration//GEN-END:variables
}
