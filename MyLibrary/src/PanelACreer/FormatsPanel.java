package PanelACreer;

import ClassObjet.Forma;
import SQLS.FormatsDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormatsPanel extends javax.swing.JPanel {

    JOptionPane jop1, jop2 = new JOptionPane();
    Vector<Forma> formatList;
    FormatsDAO formatsDAO = new FormatsDAO();
    Vector v = new Vector();
    Forma p = new Forma();

    public FormatsPanel() {
        initComponents();
        jpUpdate.setVisible(false);
        jpValidate.setVisible(true);
        jpDesac.setVisible(false);
        jpId.setVisible(false);
        jComboBox1.setSelectedIndex(-1);
        tableSearch.setEnabled(false);
      

    }

    public DefaultTableModel initTableModel() {

        v.add("Nom du format");

        return new javax.swing.table.DefaultTableModel(
                initReviewVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }

    private Vector initReviewVector() {
        Vector v = new Vector();
        formatList = new Vector<Forma>();
        formatList = formatsDAO.findAll();
        for (Forma form : formatList) {

            p = new Forma(form.getForName(), form.getForId(), form.getForStatus());
            v.add(p.getVectorName());
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
        jpDesac = new javax.swing.JPanel();
        btnDes = new javax.swing.JLabel();
        jtFormat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jpUpdate = new javax.swing.JPanel();
        btnSave = new javax.swing.JLabel();
        jpValidate = new javax.swing.JPanel();
        btnSave1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jpId = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));

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

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Statut");

        jpDesac.setBackground(new java.awt.Color(51, 102, 255));
        jpDesac.setPreferredSize(new java.awt.Dimension(200, 45));

        btnDes.setForeground(new java.awt.Color(255, 255, 255));
        btnDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDes.setText("DESACTIVER");
        btnDes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpDesacLayout = new javax.swing.GroupLayout(jpDesac);
        jpDesac.setLayout(jpDesacLayout);
        jpDesacLayout.setHorizontalGroup(
            jpDesacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDes, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jpDesacLayout.setVerticalGroup(
            jpDesacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Nom du format");

        jpUpdate.setBackground(new java.awt.Color(51, 102, 255));
        jpUpdate.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("MODIFIER");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpUpdateLayout = new javax.swing.GroupLayout(jpUpdate);
        jpUpdate.setLayout(jpUpdateLayout);
        jpUpdateLayout.setHorizontalGroup(
            jpUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jpUpdateLayout.setVerticalGroup(
            jpUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpValidate.setBackground(new java.awt.Color(51, 102, 255));
        jpValidate.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSave1.setForeground(new java.awt.Color(255, 255, 255));
        btnSave1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave1.setText("VALIDER");
        btnSave1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSave1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpValidateLayout = new javax.swing.GroupLayout(jpValidate);
        jpValidate.setLayout(jpValidateLayout);
        jpValidateLayout.setHorizontalGroup(
            jpValidateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jpValidateLayout.setVerticalGroup(
            jpValidateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activer", "Desactiver" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtFormat)
                                    .addComponent(jComboBox1, 0, 282, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jpUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jpValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(jpDesac, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jpId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpDesac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void tableSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseReleased
        
        String formName = null;
        formName = tableSearch.getValueAt(tableSearch.getSelectedRow(), 0).toString();
        jtFormat.setText(formName);
        int a = Integer.valueOf(formatsDAO.findByColumn("forName", formName).get(0).getForStatus());
        if (a == 0) {
            jComboBox1.setSelectedIndex(0);
        } else {
            jComboBox1.setSelectedIndex(1);
        }
        jpId.setText(String.valueOf(formatsDAO.findByColumn("forName", formName).get(0).getForId()));


    }//GEN-LAST:event_tableSearchMouseReleased

    private void btnSearchOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchOrderMouseReleased

        tableSearch.setModel(initTableModel());
        tableSearch.setEnabled(true);
        tableSearch.removeAll();
        jpUpdate.setVisible(true);
        jpValidate.setVisible(false);
        jpDesac.setVisible(true);
        jComboBox1.setSelectedIndex(-1);


    }//GEN-LAST:event_btnSearchOrderMouseReleased

    private void btnDesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesMouseClicked

        Forma form = new Forma();
        form.setForId(Integer.valueOf(jpId.getText()));
        form.setForName(jtFormat.getText());
        form.setForStatus(1);
        formatsDAO.update(form);
        jtFormat.setText(null);
        jpId.setText(null);
        jop1.showMessageDialog(null, "Format désactivé avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
        

    }//GEN-LAST:event_btnDesMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked

        Forma form = new Forma();

        form.setForId(Integer.valueOf(jpId.getText()));
        form.setForName(jtFormat.getText());

        if (jComboBox1.getSelectedIndex() == 0) {
            form.setForStatus(0);
        } else {
            form.setForStatus(1);
        }
        formatsDAO.update(form);
        jtFormat.setText(null);
        jpId.setText(null);
        jComboBox1.setSelectedIndex(-1);
        jop1.showMessageDialog(null, "Format modifié avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
        

    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSave1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSave1MouseClicked

        Forma form = new Forma();
        form.setForName(jtFormat.getText());
        if (jComboBox1.getSelectedItem().equals("Activer")) {
            form.setForStatus(0);
        } else {
            form.setForStatus(1);
        }
        if (formatsDAO.answer(form) == false) {
            formatsDAO.create(form);
            jop1.showMessageDialog(null, "Le format a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jtFormat.setText(null);
        jpId.setText(null);
        jComboBox1.setSelectedIndex(-1);


    }//GEN-LAST:event_btnSave1MouseClicked

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked

        jpUpdate.setVisible(false);
        jpValidate.setVisible(true);
        jpDesac.setVisible(false);
        tableSearch.setEnabled(false);


    }//GEN-LAST:event_btnNewMouseClicked

    private void tableSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDes;
    private javax.swing.JLabel btnNew;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnSave1;
    private javax.swing.JLabel btnSearchOrder;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpDesac;
    private javax.swing.JTextField jpId;
    private javax.swing.JPanel jpUpdate;
    private javax.swing.JPanel jpValidate;
    private javax.swing.JTextField jtFormat;
    private javax.swing.JTable tableSearch;
    // End of variables declaration//GEN-END:variables
}
