
package PanelModifié;

import ClassObjet.Vat;
import SQLS.VatDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VatPanel extends javax.swing.JPanel {

    
    JOptionPane jop1, jop2 = new JOptionPane();
    Vector<Vat> vatList;
    VatDAO vatDAO = new VatDAO();
    Vector v = new Vector();
    Vat p = new Vat();
    
   
    
    
    public VatPanel() {
        initComponents();
        jbUpdate.setVisible(false);
        jpValid.setVisible(true);
        jpId.setVisible(false);
        jComboBox1.setSelectedIndex(-1);
        tableSearch.setEnabled(false);
    }

    
    public DefaultTableModel initTableModel() {

        v.add("Resultat");

        return new javax.swing.table.DefaultTableModel(
                initVatVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }

    private Vector initVatVector() {
        Vector v = new Vector();
        vatList = new Vector<Vat>();
        vatList = vatDAO.findAll();
        for (Vat vat : vatList) {

            p = new Vat(vat.getVatCode(), vat.getVatRate(),vat.getVatName(),vat.getVatStatus());
            v.add(p.getVector());
        }
        return v;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSearch = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSearchOrder = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jpId = new javax.swing.JTextField();
        jpValid = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtValue = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setVisible(true);

        tableSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSearchMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableSearchMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableSearch);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNew.setText("Nouveau");
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSearchOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchOrder.setText("Rechercher");
        btnSearchOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSearchOrderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Statut");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 239, 106, 36));
        add(jtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 128, 282, 31));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Nom de la TVA");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 128, 106, 31));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activer", "Desactiver" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 240, 282, 36));
        add(jpId, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 12, 76, 37));

        jpValid.setBackground(new java.awt.Color(51, 102, 255));
        jpValid.setText("VALIDER");
        jpValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpValidActionPerformed(evt);
            }
        });
        add(jpValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 336, 125, 37));

        jbUpdate.setBackground(new java.awt.Color(51, 102, 255));
        jbUpdate.setText("MODIFIER");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });
        add(jbUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 294, 125, 37));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Valeur de la TVA");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 177, 126, 31));
        add(jtValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 178, 282, 31));
    }// </editor-fold>//GEN-END:initComponents

    private void tableSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseClicked
        
        
    }//GEN-LAST:event_tableSearchMouseClicked

    private void tableSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseReleased

        int vatCode = 0;
        vatCode = Integer.valueOf(tableSearch.getValueAt(tableSearch.getSelectedRow(), 0).toString());
        jpId.setText(String.valueOf(vatCode));
        
        int a = Integer.valueOf(vatDAO.find(vatCode).getVatStatus());
        if (a == 0) {
            jComboBox1.setSelectedIndex(0);
        } else {
            jComboBox1.setSelectedIndex(1);
        }
        jtValue.setText(String.valueOf(vatDAO.find(vatCode).getVatRate()));
        jtName.setText(vatDAO.find(vatCode).getVatName());
    }//GEN-LAST:event_tableSearchMouseReleased

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked

        jpId.setText(null);
        jtName.setText(null);
        jComboBox1.setSelectedIndex(-1);
        tableSearch.setModel(new DefaultTableModel());
        jbUpdate.setVisible(false);
        jpValid.setVisible(true);
        tableSearch.setEnabled(false);

    }//GEN-LAST:event_btnNewMouseClicked

    private void btnSearchOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchOrderMouseReleased

        tableSearch.setModel(initTableModel());
        tableSearch.setEnabled(true);
        jbUpdate.setVisible(true);
        jpValid.setVisible(false);
        jComboBox1.setSelectedIndex(-1);

    }//GEN-LAST:event_btnSearchOrderMouseReleased

    private void jpValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpValidActionPerformed

        Vat vat = new Vat();
        vat.setVatName(jtName.getText());
        
        if (jComboBox1.getSelectedItem().equals("Activer")) {
            vat.setVatStatus(0);
        } else {
            vat.setVatStatus(1);
        }
        vat.setVatRate(Float.valueOf(jtValue.getText()));
        if (vatDAO.answer(vat) == false) {
            vatDAO.create(vat);
            jop1.showMessageDialog(null, "Le format a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jtName.setText(null);
        jpId.setText(null);
        jtValue.setText(null);
        jComboBox1.setSelectedIndex(-1);
// TODO add your handling code here:
    }//GEN-LAST:event_jpValidActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed

        


        Vat vat = new Vat();
        vat.setVatName(jtName.getText());
        if (jComboBox1.getSelectedIndex() == 0) {
            vat.setVatStatus(0);
        } else {
            vat.setVatStatus(1);
        }
        vat.setVatRate(Float.valueOf(jtValue.getText()));
        vatDAO.update(vat);
        jtName.setText(null);
        jpId.setText(null);
        jtValue.setText(null);
        jtValue.setText(null);
        jComboBox1.setSelectedIndex(-1);
        jop1.showMessageDialog(null, "Format modifié avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);        





// TODO add your handling code here:
    }//GEN-LAST:event_jbUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnNew;
    private javax.swing.JLabel btnSearchOrder;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JTextField jpId;
    private javax.swing.JButton jpValid;
    private javax.swing.JTextField jtName;
    private javax.swing.JTextField jtValue;
    private javax.swing.JTable tableSearch;
    // End of variables declaration//GEN-END:variables
}
