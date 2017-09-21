/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelOk;

import java.awt.BorderLayout;


public class FormatPanel extends javax.swing.JPanel {

    
        
    public FormatPanel() {
        initComponents();
         menuChoose.setVisible(true);
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        menuChoose = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRAdd = new javax.swing.JRadioButton();
        jRUpdate = new javax.swing.JRadioButton();
        jpPrinc = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuChoose.setBackground(new java.awt.Color(255, 255, 255));
        menuChoose.setMinimumSize(new java.awt.Dimension(200, 200));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Veuillez  choisir une option:");
        jLabel1.setAlignmentX(0.5F);

        buttonGroup1.add(jRAdd);
        jRAdd.setText("Ajouter");
        jRAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRAddActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRUpdate);
        jRUpdate.setText("Modifier");
        jRUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuChooseLayout = new javax.swing.GroupLayout(menuChoose);
        menuChoose.setLayout(menuChooseLayout);
        menuChooseLayout.setHorizontalGroup(
            menuChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuChooseLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jRAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jRUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        menuChooseLayout.setVerticalGroup(
            menuChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuChooseLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRAdd)
                    .addComponent(jRUpdate))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(menuChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, 70));

        jpPrinc.setBackground(new java.awt.Color(255, 255, 255));
        jpPrinc.setLayout(new java.awt.BorderLayout());
        add(jpPrinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 860, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void jRAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRAddActionPerformed
 if (jRAdd.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.validate();
            jpPrinc.add(new FormatPanelAdd(),BorderLayout.CENTER);
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }
        
      
    }//GEN-LAST:event_jRAddActionPerformed

    private void jRUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRUpdateActionPerformed
        if (jRUpdate.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.validate();
            jpPrinc.add(new FormatPanelUpdate(),BorderLayout.CENTER);
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }

    }//GEN-LAST:event_jRUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRAdd;
    private javax.swing.JRadioButton jRUpdate;
    private javax.swing.JPanel jpPrinc;
    private javax.swing.JPanel menuChoose;
    // End of variables declaration//GEN-END:variables
}
