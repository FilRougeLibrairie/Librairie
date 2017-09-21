package PanelOk;

import ClassObjet.Forma;
import SQLS.FormatsDAO;
import javax.swing.JOptionPane;

public class FormatPanelAdd extends javax.swing.JPanel {

    JOptionPane jop1,jop2 = new JOptionPane();
    FormatsDAO form = new FormatsDAO();

    public FormatPanelAdd() {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTAddFormat = new javax.swing.JTextField();
        jBSelect = new javax.swing.JButton();

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

        jLabel2.setText("FORMAT");

        jBSelect.setBackground(new java.awt.Color(0, 51, 255));
        jBSelect.setText("AJOUTER");
        jBSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBSelectMousePressed(evt);
            }
        });
        jBSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAddLayout = new javax.swing.GroupLayout(jpAdd);
        jpAdd.setLayout(jpAddLayout);
        jpAddLayout.setHorizontalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jTAddFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jBSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAddLayout.setVerticalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTAddFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jBSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jpAdd);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSelectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSelectMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSelectMousePressed

    private void jBSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelectActionPerformed

        String a = jTAddFormat.getText();
        Forma format = new Forma();
        format.setForName(a);

        if (form.answer(format) == false) {
            form.create(format);
            jop1.showMessageDialog(null, "Le format a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jTAddFormat.setText("");

    }//GEN-LAST:event_jBSelectActionPerformed

    private void jpAddAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpAddAncestorAdded

    }//GEN-LAST:event_jpAddAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTAddFormat;
    private javax.swing.JPanel jpAdd;
    // End of variables declaration//GEN-END:variables
}
