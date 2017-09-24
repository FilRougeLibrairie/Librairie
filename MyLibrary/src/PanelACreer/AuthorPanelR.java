package PanelACreer;

import ClassObjet.Author;
import ClassObjet.Review;
import SQLS.AuthorDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AuthorPanelR extends javax.swing.JPanel {

    JOptionPane jop1, jop2 = new JOptionPane();
    AuthorDAO authorDAO = new AuthorDAO();
    Review review = new Review();
    String term = null;
    String column = null;
    Vector<Author> authorList;
    String title=null;

    public AuthorPanelR() {
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
                initAuthorVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }

    private Vector initAuthorVector() {
        Vector v = new Vector();
        int termInt = 0;
        if (jComboBoxSearch.getSelectedItem() != null) {
            authorList = new Vector<Author>();
            String type = (String) jComboBoxSearch.getSelectedItem();

            // cas auteur
            if ("Nom d'Auteur".equals(type)) {
                title="Nom de l'auteur";
                term = tfSearch.getText().trim();
                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le nom de l'auteur")) {
                    authorList = authorDAO.findAll();
                } else {
                    authorList = authorDAO.findByColumn("autLastName", term);
                }

                for (Author aut : authorList) {
                    Author p = new Author(aut.getAutLastName());
                    v.add(p.getVectorName());

                }
            }
            // cas n° de l'auteur
            if (type.equalsIgnoreCase("N° de l'Auteur")) {
                title="N° de l'auteur";
                column = "autId";
                term = tfSearch.getText().trim();
                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le n° de l'auteur")) {
                    authorList = authorDAO.findAll();
                } else {
                    authorList = authorDAO.findByColumn(column, term);
                }

                for (Author aut : authorList) {
                    Author p = new Author(aut.getAutId(), aut.getAutLastName(), aut.getAutFirstName(), aut.getAutBiography(), aut.getAutStatusCode());
                    v.add(p.getVector());
                }
            }
            // cas Statut actif
            if (type.equalsIgnoreCase("Statut Actif")) {
                title="N° de l'auteur";
                column = "autStatusCode";
                termInt = 0;
                authorList = authorDAO.findByColumn(column, String.valueOf(termInt));
                for (Author aut : authorList) {

                    Author p = new Author(aut.getAutId(), aut.getAutLastName(), aut.getAutFirstName(), aut.getAutBiography(), aut.getAutStatusCode());
                    v.add(p.getVector());
                }
            }

            // cas Statut inactif
            if (type.equalsIgnoreCase("Statut Inactif")) {
                column = "autStatusCode";
                title="N° de l'auteur";
                termInt = 1;
                authorList = authorDAO.findByColumn(column, String.valueOf(termInt));
                for (Author aut : authorList) {

                    Author p = new Author(aut.getAutId(), aut.getAutLastName(), aut.getAutFirstName(), aut.getAutBiography(), aut.getAutStatusCode());
                    v.add(p.getVector());
                }
            }

        }
        return v;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAuto = new javax.swing.JTextArea();
        jTLastName = new javax.swing.JTextField();
        jTFirstName = new javax.swing.JTextField();
        jbAdd = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTId = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(900, 600));

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

        jLabel19.setText("Recherche auteur par :");

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        jLCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        jLCreateNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCreateNew.setText("Nouvel Auteur");
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

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nom d'Auteur", "N° de l'Auteur", "Statut Actif", "Statut Inactif" }));
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
                .addContainerGap(58, Short.MAX_VALUE))
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jLabel5.setText("Statut");

        jLabel1.setText("Prénom");

        jLabel2.setText("Biographie");

        jTAuto.setColumns(20);
        jTAuto.setRows(5);
        jScrollPane1.setViewportView(jTAuto);

        jbAdd.setBackground(new java.awt.Color(51, 102, 255));
        jbAdd.setText("AJOUTER");
        jbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAddMouseClicked(evt);
            }
        });

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

        jLabel6.setText("Nom");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Actif", "Inactif" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                            .addComponent(jTLastName)
                            .addComponent(jTFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(231, 231, 231))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelSearchBookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchBookMouseReleased

        jTableSearch.setEnabled(true);

    }//GEN-LAST:event_labelSearchBookMouseReleased

    private void jLCreateNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCreateNewMouseClicked

        jTableSearch.setEnabled(false);

    }//GEN-LAST:event_jLCreateNewMouseClicked

    private void jbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAddMouseClicked

        Author author = new Author();

        if (jComboBox1.getSelectedItem().equals("Actif")) {
            author.setAutStatusCode(0);
        } else {
            author.setAutStatusCode(1);
        }

        author.setAutLastName(jTFirstName.getText());
        author.setAutFirstName(jTLastName.getText());
        author.setAutBiography(jTAuto.getText());

        if (authorDAO.answer(author) == false) {
            authorDAO.create(author);
            jop1.showMessageDialog(null, "L'auteur a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String[] confirm = {"oui", "non"};
            JOptionPane jop = new JOptionPane();
            int rang = jop.showOptionDialog(null, "Cet auteur est déjà dans la base Confirmez vous ce choix?", "information", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirm, confirm[1]);
            if (rang == 0) {
                authorDAO.create(author);
                jop1.showMessageDialog(null, "L'auteur a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        jTFirstName.setText(null);
        jTLastName.setText(null);
        jTAuto.setText(null);
        jComboBox1.setSelectedIndex(-1);

    }//GEN-LAST:event_jbAddMouseClicked

    private void jbUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbUpdateMouseClicked

    private void labelSearchBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchBookMouseClicked

        jTableSearch.setModel(initTableModel());


    }//GEN-LAST:event_labelSearchBookMouseClicked

    private void jComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchActionPerformed
        if (jComboBoxSearch.getSelectedItem() != null) {
            if (jComboBoxSearch.getSelectedItem().equals("Nom d'Auteur")) {
                tfSearch.setText("Entrer le nom de l'auteur");
            }
            if (jComboBoxSearch.getSelectedItem().equals("N° de l'Auteur")) {
                tfSearch.setText("Entrer le n° de l'auteur");
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
        if (jComboBoxSearch.getSelectedItem().equals("Nom d'Auteur")) {
            
            term = jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString();

            authorList = new Vector<Author>();
            authorList = authorDAO.findByColumn("autLastName", term);

            jTFirstName.setText(authorList.get(0).getAutFirstName());
            jTLastName.setText(jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString());
            jTAuto.setText(authorList.get(0).getAutBiography());
            jTId.setText(String.valueOf(authorList.get(0).getAutId()));

            System.out.println(authorList.get(0).getAutStatusCode());
            if (authorList.get(0).getAutStatusCode() == 0) {

                jComboBox1.setSelectedIndex(0);

            } else {

                jComboBox1.setSelectedItem("Inactif");
            }
        } else {
            System.out.println("bisou");
            term = jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString();
            System.out.println(term);
            authorList = new Vector<Author>();
            authorList = authorDAO.findByColumn("autId", term);
            jTId.setText(String.valueOf(authorList.get(0).getAutId()));
            jTFirstName.setText(authorList.get(0).getAutFirstName());
            jTLastName.setText(jTableSearch.getValueAt(jTableSearch.getSelectedRow(), 0).toString());
            jTAuto.setText(authorList.get(0).getAutBiography());

            System.out.println(authorList.get(0).getAutStatusCode());
            if (authorList.get(0).getAutStatusCode() == 0) {

                jComboBox1.setSelectedIndex(0);

            } else {

                jComboBox1.setSelectedItem("Inactif");
            }

        }
    }//GEN-LAST:event_jTableSearchMouseReleased

    private void jLCreateNewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCreateNewMouseReleased

        title= "Résultat";
        jComboBoxSearch.setSelectedIndex(-1);
        tfSearch.setText(null);
        jTableSearch.setModel(initTableModel());
jComboBox1.setSelectedIndex(-1);
        
        jTId.setText(null);
        jTFirstName.setText(null);
        jTLastName.setText(null);
        jTAuto.setText(null);
        jbUpdate.setVisible(false);
        jbAdd.setVisible(true);
        
    }//GEN-LAST:event_jLCreateNewMouseReleased

    private void jbUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateMouseReleased

        String id = null;
        String autL = null;
        String autF = null;
        String autA = null;
        String autS = null;
        JOptionPane jop1 = new JOptionPane();
        

        id = jTId.getText();
        autF = jTLastName.getText();
        autL = jTFirstName.getText();
        autA = jTAuto.getText();
        if (jComboBox1.getSelectedItem().equals("Actif")) {
            autS = "0";
        }
        if (jComboBox1.getSelectedItem().equals("Incatif"))  {
            autS = "1";
        }

        Author a = new Author();
        AuthorDAO aut = new AuthorDAO();
        a.setAutId(Integer.valueOf(id));
        a.setAutFirstName(autF);
        a.setAutLastName(autL);
        a.setAutBiography(autA);
        a.setAutStatusCode(Integer.valueOf(autS));
        aut.update(a);
        jop1.showMessageDialog(null, "L'auteur a été modifié avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);






// TODO add your handling code here:
    }//GEN-LAST:event_jbUpdateMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxSearch;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLCreateNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTAuto;
    private javax.swing.JTextField jTFirstName;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTLastName;
    private javax.swing.JTable jTableSearch;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JLabel labelSearchBook;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
