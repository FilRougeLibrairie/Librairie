package PanelOk;

import ClassObjet.Keywords;
import SQLS.KeywordsDAO;
import javax.swing.JOptionPane;

public class KeywordsAddPanel extends javax.swing.JPanel {

    JOptionPane jop1, jop2 = new JOptionPane();
    KeywordsDAO kwDAO = new KeywordsDAO();

    public KeywordsAddPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTAddLanguage = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jpAdd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpAddAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setText("MOT CLE");

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

        javax.swing.GroupLayout jpAddLayout = new javax.swing.GroupLayout(jpAdd);
        jpAdd.setLayout(jpAddLayout);
        jpAddLayout.setHorizontalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jTAddLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jpAddLayout.setVerticalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAddLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        add(jpAdd);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed


    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a = jTAddLanguage.getText();
        Keywords keywords = new Keywords();
        keywords.setKeyName(a);

        if (kwDAO.answer(keywords) == false) {
            kwDAO.create(keywords);
            jop1.showMessageDialog(null, "Le mot clé a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jTAddLanguage.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpAddAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpAddAncestorAdded

    }//GEN-LAST:event_jpAddAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTAddLanguage;
    private javax.swing.JPanel jpAdd;
    // End of variables declaration//GEN-END:variables
}
