package PanelModifié;

import ClassObjet.SubTheme;
import ClassObjet.Theme;
import SQLS.SubThemeDAO;
import SQLS.ThemeDAO;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SubThemePanelHS extends javax.swing.JPanel {

    JOptionPane jop1, jop2 = new JOptionPane();
    SubThemeDAO subThemeDAO = new SubThemeDAO();
    SubTheme subTheme = new SubTheme();
    String term = null;
    String column = null;
    Vector<SubTheme> subThemeList;
    String title = null;

    public SubThemePanelHS() {
        initComponents();
        initComponents();
        jTId.setVisible(false);
        jComboBox1.setSelectedIndex(-1);
        jTableSearch.setEnabled(false);
        jbUpdate.setVisible(false);
        jbAdd.setVisible(true);
        jComboBoxSearch.setSelectedIndex(-1);
        jComboBox2.setModel(initThemeModel());
        jComboBox2.setSelectedIndex(-1);
    }

    public DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add(title);

        return new javax.swing.table.DefaultTableModel(
                initSubThemeVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }

    private Vector initSubThemeVector() {
        Vector v = new Vector();

        if (jComboBoxSearch.getSelectedItem() != null) {
            subThemeList = new Vector<SubTheme>();
            String type = (String) jComboBoxSearch.getSelectedItem();

            // cas nom
            if ("Nom du sous thème".equals(type)) {
                title = "Nom du sous thème";
                term = tfSearch.getText().trim();
                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le nom du sous thème")) {
                    subThemeList = subThemeDAO.findAll();
                } else {
                    subThemeList = subThemeDAO.findByColumn("subName", term);
                }

                for (SubTheme subtheme : subThemeList) {
                    SubTheme p = new SubTheme(subtheme.getSubId(), subtheme.getTheId(), subtheme.getSubName(), subtheme.getSubDescription(), subtheme.getSubStatus());
                    v.add(p.getName());

                }
            }

            // cas n°
            if (type.equalsIgnoreCase("N° du sous thème")) {
                title = "N° du sous thème";
                column = "subId";
                term = tfSearch.getText().trim();

                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le n° du sous thème")) {
                    subThemeList = subThemeDAO.findAll();
                } else {

                    subThemeList = subThemeDAO.findByColumn(column, Integer.valueOf(term));
                    System.out.println(subThemeList);
                    for (SubTheme subtheme : subThemeList) {
                        SubTheme p = new SubTheme(subtheme.getSubId(), subtheme.getTheId(), subtheme.getSubName(), subtheme.getSubDescription(), subtheme.getSubStatus());
                        v.add(p.getVector());
                    }
                }

                String termInt = null;
                // car de Inactif
                if (type.equalsIgnoreCase("Sous thème inactif")) {
                    title = "N° du sous thème";
                    column = "subId";
                    termInt = "1";
                    subThemeList = subThemeDAO.findByColumn(column, String.valueOf(termInt));
                    for (SubTheme subtheme : subThemeList) {

                        SubTheme p = new SubTheme(subtheme.getSubId(), subtheme.getTheId(), subtheme.getSubName(), subtheme.getSubDescription(), subtheme.getSubStatus());
                        v.add(p.getVector());
                    }
                }
                // cas Statut actif
                if (type.equalsIgnoreCase("Sous thème actif")) {
                    title = "N° du sous thème";
                    column = "subId";
                    termInt = "0";
                    subThemeList = subThemeDAO.findByColumn(column, termInt);
                    for (SubTheme subtheme : subThemeList) {

                        SubTheme p = new SubTheme(subtheme.getSubId(), subtheme.getTheId(), subtheme.getSubName(), subtheme.getSubDescription(), subtheme.getSubStatus());
                        v.add(p.getVector());
                    }
                }

            }

        }

        return v;
    }

    private DefaultComboBoxModel initThemeModel() {
        return new DefaultComboBoxModel(initThemeVector());
    }

    private Vector initThemeVector() {
        ThemeDAO theDao = new ThemeDAO();
        return theDao.findAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        jTDescription = new javax.swing.JTextArea();
        jTName = new javax.swing.JTextField();
        jbAdd = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTId = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel19.setText("Recherche Sous Thème par :");

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        jLCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        jLCreateNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCreateNew.setText("Nouveau sous thème  ");
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

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nom du sous thème", "N° du sous thème", "Sous thème actif", "Sous thème inactif" }));
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
                .addContainerGap(29, Short.MAX_VALUE))
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

        jPanel2.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 604));

        jLabel5.setText("Statut");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 55, 93, 37));

        jLabel2.setText("Thème Associé");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 132, 37));

        jTDescription.setColumns(20);
        jTDescription.setRows(5);
        jScrollPane1.setViewportView(jTDescription);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 453, 117));
        jPanel2.add(jTName, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 112, 453, 37));

        jbAdd.setBackground(new java.awt.Color(51, 102, 255));
        jbAdd.setText("AJOUTER");
        jbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAddMouseClicked(evt);
            }
        });
        jPanel2.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 176, 42));

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
        jPanel2.add(jbUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 382, 176, 42));

        jLabel6.setText("Nom du thème");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 112, 93, 37));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Actif", "Inactif" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 53, 453, 40));
        jPanel2.add(jTId, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 12, 63, 29));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 450, 40));

        jLabel3.setText("Description");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 132, 37));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
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
        jTName.setText(null);
        jTDescription.setText(null);
        jbUpdate.setVisible(false);
        jbAdd.setVisible(true);
    }//GEN-LAST:event_jLCreateNewMouseReleased

    private void jComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchActionPerformed
        if (jComboBoxSearch.getSelectedItem() != null) {
            if (jComboBoxSearch.getSelectedItem().equals("Nom du sous thème")) {
                tfSearch.setText("Entrer le nom du sous thème");
            }
            if (jComboBoxSearch.getSelectedItem().equals("N° du sous thème")) {
                tfSearch.setText("Entrer le n° du sous thème");
            }
            if (jComboBoxSearch.getSelectedItem().equals("Sous Thème inactif") || jComboBoxSearch.getSelectedItem().equals("Sous Thème actif")) {
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

        //initialiser les paramètres
        if (jComboBoxSearch.getSelectedItem().equals("Nom du sous thème")) {

            term = jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString();
            subThemeList = new Vector<SubTheme>();
            subThemeList = subThemeDAO.findByColumn("subName", term);

            jTName.setText(subThemeList.get(0).getSubName());
            jTDescription.setText(subThemeList.get(0).getSubDescription());
            jTId.setText(String.valueOf(subThemeList.get(0).getSubId()));
            if (subThemeList.get(0).getSubStatus() == 0) {
                jComboBox1.setSelectedIndex(0);
            } else {
                jComboBox1.setSelectedItem("Inactif");
            }
            //initialiser le combobox thème

            jComboBox2.setSelectedItem(subThemeList.get(0).getTheId().getName().toString().trim());

        } else {

            term = jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString();

            subThemeList = new Vector<SubTheme>();
            subThemeList = subThemeDAO.findByColumn("subId", term);
            jTId.setText(String.valueOf(subThemeList.get(0).getSubId()));
            jTName.setText(subThemeList.get(0).getSubName());
            jTDescription.setText(subThemeList.get(0).getSubDescription());
            if (subThemeList.get(0).getSubStatus() == 0) {

                jComboBox1.setSelectedIndex(0);

            } else {

                jComboBox1.setSelectedItem("Inactif");
            }
            jComboBox2.setSelectedItem(subThemeList.get(0).getTheId().getName().toString().trim());

        }
    }//GEN-LAST:event_jTableSearchMouseReleased
Theme theme = new Theme();
    private void jbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAddMouseClicked

        SubTheme subtheme = new SubTheme();

        if (jComboBox1.getSelectedItem().equals("Actif")) {
            subtheme.setSubStatus(0);
        } else {
            subtheme.setSubStatus(1);
        }
        subtheme.setTheId(theme);
        subtheme.setSubName(jTName.getText());
        subtheme.setSubDescription(jTDescription.getText());
        
        
            subThemeDAO.create(subTheme);
            jop1.showMessageDialog(null, "Le thème a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        
        
        jTId.setText(null);
        jTName.setText(null);
        jTDescription.setText(null);
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
        
        SubTheme subtheme = new SubTheme();
        
        JOptionPane jop1 = new JOptionPane();

        id = jTId.getText();
        name = jTName.getText();
        description = jTDescription.getText();
        if (jComboBox1.getSelectedItem().equals("Actif")) {
            stat = 0;
        }
        if (jComboBox1.getSelectedItem().equals("Inactif")) {
            stat = 1;
        }
        subtheme.setTheId(theme);
        subtheme.setSubId(Integer.valueOf(id));
        subtheme.setSubName(name);
        subtheme.setSubDescription(description);
        subtheme.setSubStatus(stat);
        subThemeDAO.update(subtheme);
        jop1.showMessageDialog(null, "Le thème a été modifié avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
    
    }//GEN-LAST:event_jbUpdateMouseReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        theme = (Theme) jComboBox2.getSelectedItem();
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBoxSearch;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLCreateNew;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTDescription;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTName;
    private javax.swing.JTable jTableSearch;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JLabel labelSearchBook;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
