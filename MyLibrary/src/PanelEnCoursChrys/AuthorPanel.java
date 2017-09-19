/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelEnCoursChrys;

import java.awt.BorderLayout;

/**
 *
 * @author Chrys
 */
public class AuthorPanel extends javax.swing.JPanel {

    /**
     * Creates new form AuthorPanel1
     */
    public AuthorPanel() {
        initComponents();
        jpPrinc.setVisible(false);
        jpPrinc.removeAll();
        jpPrinc.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpPrinc = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jRDelete = new javax.swing.JRadioButton();
        jRUpdate = new javax.swing.JRadioButton();
        jRAdd = new javax.swing.JRadioButton();

        setMinimumSize(new java.awt.Dimension(0, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jpPrinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 124, 900, 676));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("AUTEUR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 0, 276, 38));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Veuillez choisir une option");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setAlignmentX(0.5F);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 68, 780, 25));

        buttonGroup1.add(jRDelete);
        jRDelete.setText("Supprimer");
        jRDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jRDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 95, 119, -1));

        buttonGroup1.add(jRUpdate);
        jRUpdate.setText("Modifier");
        jRUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jRUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 95, 103, -1));

        buttonGroup1.add(jRAdd);
        jRAdd.setText("Ajouter");
        jRAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRAddActionPerformed(evt);
            }
        });
        jPanel1.add(jRAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 95, 103, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jRDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRDeleteActionPerformed

        if (jRDelete.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.validate();
            
            jpPrinc.add(new AuthorDeletePanel());
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
            
            
        }
    }//GEN-LAST:event_jRDeleteActionPerformed

    private void jRUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRUpdateActionPerformed

        if (jRUpdate.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.validate();
            
            jpPrinc.add(new AuthorUpdatePanel());
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }
    }//GEN-LAST:event_jRUpdateActionPerformed

    private void jRAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRAddActionPerformed

        if (jRAdd.isSelected() == true) {
            jpPrinc.removeAll();
            
            jpPrinc.add(new AuthorAddPanel());
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }

    }//GEN-LAST:event_jRAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRAdd;
    private javax.swing.JRadioButton jRDelete;
    private javax.swing.JRadioButton jRUpdate;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpPrinc;
    // End of variables declaration//GEN-END:variables
}