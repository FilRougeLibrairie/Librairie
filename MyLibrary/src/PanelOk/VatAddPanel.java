
package PanelOk;

import ClassObjet.Vat;
import SQLS.VatDAO;
import javax.swing.JOptionPane;



public class VatAddPanel extends javax.swing.JPanel {
    JOptionPane jop1, jop2 = new JOptionPane();
    VatDAO vatDAO = new VatDAO();
    public VatAddPanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTvatName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTvatRate = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 900));

        jpAdd.setBackground(new java.awt.Color(255, 255, 255));
        jpAdd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpAddAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setText("Valeur de la TVA");

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setText("OK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Type de TVA");

        javax.swing.GroupLayout jpAddLayout = new javax.swing.GroupLayout(jpAdd);
        jpAdd.setLayout(jpAddLayout);
        jpAddLayout.setHorizontalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGroup(jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAddLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAddLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAddLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTvatName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAddLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTvatRate, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jpAddLayout.setVerticalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTvatRate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTvatName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jpAdd);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed

    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a = jTvatRate.getText();
        String b= jTvatName.getText();
        Vat vat = new Vat();
        vat.setVatName(b);
        vat.setVatRate(Float.valueOf(a));

        
        if (vatDAO.answer(vat) == false) {
            vatDAO.create(vat);
            jop1.showMessageDialog(null, "La TVA a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jTvatName.setText("");
        jTvatRate.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpAddAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpAddAncestorAdded

    }//GEN-LAST:event_jpAddAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTvatName;
    private javax.swing.JTextField jTvatRate;
    private javax.swing.JPanel jpAdd;
    // End of variables declaration//GEN-END:variables
}
