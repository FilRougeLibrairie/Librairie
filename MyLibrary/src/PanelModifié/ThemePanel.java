package PanelModifié;

import ClassObjet.Theme;
import SQLS.ThemeDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThemePanel extends javax.swing.JPanel {

    JOptionPane jop1, jop2 = new JOptionPane();
    ThemeDAO themeDAO = new ThemeDAO();
    Theme theme = new Theme();
    String term = null;
    String column = null;
    Vector<Theme> themeList;
    String title = null;

    public ThemePanel() {
        initComponents();
        jTId.setVisible(false);
        jComboBox1.setSelectedIndex(-1);
        jTableSearch.setEnabled(false);
        jbUpdate.setVisible(false);
        jbAdd.setVisible(true);
        jComboBoxSearch.setSelectedIndex(-1);
    }

    public DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add(title);

        return new javax.swing.table.DefaultTableModel(
                initThemeVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }

    private Vector initThemeVector() {
        Vector v = new Vector();
        
        if (jComboBoxSearch.getSelectedItem() != null) {
            themeList = new Vector<Theme>();
            String type = (String) jComboBoxSearch.getSelectedItem();

            // cas theme
            if ("Nom du thème".equals(type)) {
                title = "Nom du Thème";
                term = tfSearch.getText().trim();
                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le nom du thème")) {
                    themeList = themeDAO.findAll();
                } else {
                    themeList = themeDAO.findByColumn("theName", term);
                }

                for (Theme theme : themeList) {
                    Theme p = new Theme(theme.getTheName());
                    v.add(p.getName());

                }
            }
            // cas n° de theme
            if (type.equalsIgnoreCase("N° du thème")) {
                title = "N° du thème";
                column = "theId";
                term = tfSearch.getText().trim();
                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le n° du thème")) {
                    themeList = themeDAO.findAllOrdId();
                } else {
                    themeList = themeDAO.findByColumn(column, term);
                }

                for (Theme theme : themeList) {
                    Theme p = new Theme(theme.getTheId());
                    v.add(p.getVector());
                }
            }

        }
        return v;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel9 = new javax.swing.JPanel();
        labelSearchBook = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLCreateNew = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxSearch = new javax.swing.JComboBox();
        tfSearch = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableSearch = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAuto = new javax.swing.JTextArea();
        jTFirstName = new javax.swing.JTextField();
        jbAdd = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTId = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(200, 400));
        jInternalFrame1.setVisible(true);

        jPanel9.setBackground(new java.awt.Color(51, 102, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 45));

        labelSearchBook.setForeground(new java.awt.Color(255, 255, 255));
        labelSearchBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSearchBook.setText("Rechercher");
        labelSearchBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSearchBookMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                labelSearchBookMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSearchBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSearchBook, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel19.setText("Recherche Thème par :");

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        jLCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        jLCreateNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCreateNew.setText("Nouveau Thème");
        jLCreateNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCreateNewMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLCreateNewMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLCreateNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nom du thème", "N° du thème" }));
        jComboBoxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchActionPerformed(evt);
            }
        });

        jTableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Résultat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSearchMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSearchMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTableSearch);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfSearch)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(jComboBoxSearch, javax.swing.GroupLayout.Alignment.LEADING, 0, 166, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jPanel1.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 604));

        jLabel5.setText("Statut");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 55, 93, 37));

        jLabel2.setText("Description");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 132, 37));

        jTAuto.setColumns(20);
        jTAuto.setRows(5);
        jScrollPane1.setViewportView(jTAuto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 453, 117));
        jPanel1.add(jTFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 112, 453, 37));

        jbAdd.setBackground(new java.awt.Color(51, 102, 255));
        jbAdd.setText("AJOUTER");
        jbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAddMouseClicked(evt);
            }
        });
        jPanel1.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 176, 42));

        jbUpdate.setBackground(new java.awt.Color(51, 102, 255));
        jbUpdate.setText("MODIFIER");
        jbUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbUpdateMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbUpdateMouseReleased(evt);
            }
        });
        jPanel1.add(jbUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 382, 176, 42));

        jLabel6.setText("Nom du thème");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 112, 93, 37));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Actif", "Inactif" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 53, 453, 40));
        jPanel1.add(jTId, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 12, 63, 29));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 953, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void labelSearchBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchBookMouseClicked
jTableSearch.setEnabled(true);
        jTableSearch.setModel(initTableModel());
        

    }//GEN-LAST:event_labelSearchBookMouseClicked

    private void labelSearchBookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchBookMouseReleased

        
    }//GEN-LAST:event_labelSearchBookMouseReleased

    private void jLCreateNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCreateNewMouseClicked

        jTableSearch.setEnabled(false);
    }//GEN-LAST:event_jLCreateNewMouseClicked

    private void jLCreateNewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCreateNewMouseReleased

        title = "Résultat";
        jComboBoxSearch.setSelectedIndex(-1);
        tfSearch.setText(null);
        jTableSearch.setModel(initTableModel());
        jComboBox1.setSelectedIndex(-1);
        jTId.setText(null);
        jTFirstName.setText(null);
        jTAuto.setText(null);
        jbUpdate.setVisible(false);
        jbAdd.setVisible(true);
    }//GEN-LAST:event_jLCreateNewMouseReleased

    private void jComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchActionPerformed
        if (jComboBoxSearch.getSelectedItem() != null) {
            if (jComboBoxSearch.getSelectedItem().equals("Nom du thème")) {
                tfSearch.setText("Entrer le nom du thème");
            }
            if (jComboBoxSearch.getSelectedItem().equals("N° du thème")) {
                tfSearch.setText("Entrer le n° du thème");
            }
            if (jComboBoxSearch.getSelectedItem().equals("Statut Actif") || jComboBoxSearch.getSelectedItem().equals("Statut Inactif")) {
                tfSearch.setText(null);
                tfSearch.setEnabled(false);
            } else {
                tfSearch.setEnabled(true);
            }
        }

    }//GEN-LAST:event_jComboBoxSearchActionPerformed

    private void jTableSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSearchMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTableSearchMouseClicked

    private void jTableSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSearchMouseReleased

        jbUpdate.setVisible(true);
        jbAdd.setVisible(false);
        if (jComboBoxSearch.getSelectedItem().equals("Nom du thème")) {

            term = jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString();

            themeList = new Vector<Theme>();
            themeList = themeDAO.findByColumn("theName", term);

            jTFirstName.setText(themeList.get(0).getTheName());
            jTAuto.setText(themeList.get(0).getTheDescription());
            jTId.setText(String.valueOf(themeList.get(0).getTheId()));
            if (themeList.get(0).getStatus() == 0) {
                jComboBox1.setSelectedIndex(0);

            } else {

                jComboBox1.setSelectedItem("Inactif");
            }
        } else {

            term = jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString();

            themeList = new Vector<Theme>();
            themeList = themeDAO.findByColumn("theId", term);
            jTId.setText(String.valueOf(themeList.get(0).getTheId()));
            jTFirstName.setText(themeList.get(0).getTheName());
            jTAuto.setText(themeList.get(0).getTheDescription());
            if (themeList.get(0).getStatus() == 0) {

                jComboBox1.setSelectedIndex(0);

            } else {

                jComboBox1.setSelectedItem("Inactif");
            }

        }
    }//GEN-LAST:event_jTableSearchMouseReleased

    private void jbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAddMouseClicked

        Theme theme = new Theme();

        if (jComboBox1.getSelectedItem().equals("Actif")) {
            theme.setStatus(0);
        } else {
            theme.setStatus(1);
        }

        theme.setTheName(jTFirstName.getText());
        theme.setTheDescription(jTAuto.getText());

        if (themeDAO.answer(theme) == false) {
            themeDAO.create(theme);
            jop1.showMessageDialog(null, "Le thème a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String[] confirm = {"oui", "non"};
            JOptionPane jop = new JOptionPane();
            int rang = jop.showOptionDialog(null, "Ce thème est déjà dans la base Confirmez vous ce choix?", "information", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirm, confirm[1]);
            if (rang == 0) {
                themeDAO.create(theme);
                jop1.showMessageDialog(null, "L'auteur a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        jTId.setText(null);
        jTFirstName.setText(null);
        jTAuto.setText(null);
        jComboBox1.setSelectedIndex(-1);
    }//GEN-LAST:event_jbAddMouseClicked

    private void jbUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbUpdateMouseClicked

    private void jbUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateMouseReleased

        String id = null;
        String name = null;
        String description = null;
        int stat = 0;
        JOptionPane jop1 = new JOptionPane();

        id = jTId.getText();
        name = jTFirstName.getText();
        description = jTAuto.getText();
        if (jComboBox1.getSelectedItem().equals("Actif")) {
            stat = 0;
        }
        if (jComboBox1.getSelectedItem().equals("Inactif")) {
            stat = 1;
        }

        Theme theme = new Theme();
        ThemeDAO themeDAO = new ThemeDAO();
        
        theme.setTheId(Integer.valueOf(id));
        theme.setTheName(name);
        theme.setTheDescription(description);
        theme.setStatus(stat);
        themeDAO.update(theme);
        jop1.showMessageDialog(null, "Le thème a été modifié avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbUpdateMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxSearch;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLCreateNew;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTAuto;
    private javax.swing.JTextField jTFirstName;
    private javax.swing.JTextField jTId;
    private javax.swing.JTable jTableSearch;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JLabel labelSearchBook;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
