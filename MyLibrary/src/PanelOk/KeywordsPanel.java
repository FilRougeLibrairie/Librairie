
package PanelOk;

import java.awt.BorderLayout;


public class KeywordsPanel extends javax.swing.JPanel {

    
    public KeywordsPanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpPrinc = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jRUpdate = new javax.swing.JRadioButton();
        jRAdd = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpPrinc.setBackground(new java.awt.Color(255, 255, 255));
        jpPrinc.setLayout(new java.awt.BorderLayout());
        add(jpPrinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 870, 510));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Veuillez choisir une option");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setAlignmentX(0.5F);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 780, 25));

        buttonGroup1.add(jRUpdate);
        jRUpdate.setText("Modifier");
        jRUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jRUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 103, -1));

        buttonGroup1.add(jRAdd);
        jRAdd.setText("Ajouter");
        jRAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRAddActionPerformed(evt);
            }
        });
        jPanel1.add(jRAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 103, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jRUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRUpdateActionPerformed

        if (jRUpdate.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.validate();
            jpPrinc.add(new KeywordsUpdatePanel(),BorderLayout.CENTER);
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }
    }//GEN-LAST:event_jRUpdateActionPerformed

    private void jRAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRAddActionPerformed

        if (jRAdd.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.validate();
            jpPrinc.add(new KeywordsAddPanel(),BorderLayout.CENTER);
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }
    }//GEN-LAST:event_jRAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRAdd;
    private javax.swing.JRadioButton jRUpdate;
    private javax.swing.JPanel jpPrinc;
    // End of variables declaration//GEN-END:variables
}
