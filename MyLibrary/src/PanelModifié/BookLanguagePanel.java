package PanelModifié;

import ClassObjet.BookLanguage;
import SQLS.BookLanguageDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookLanguagePanel extends javax.swing.JPanel {

    JOptionPane jop1, jop2 = new JOptionPane();
    Vector<BookLanguage> bookLanguageList;
    BookLanguageDAO bookLanguageDAO = new BookLanguageDAO();
    Vector v = new Vector();
    BookLanguage p = new BookLanguage();

    public BookLanguagePanel() {
        initComponents();
        jpUpdate.setVisible(false);
        jpValidate.setVisible(true);
        jComboBox1.setSelectedIndex(-1);
        tableSearch.setEnabled(false);
        jTID.setVisible(false);

    }

    public DefaultTableModel initTableModel() {

        v.add("Nom du language");

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
        bookLanguageList = new Vector<BookLanguage>();
        bookLanguageList = bookLanguageDAO.findAll();
        for (BookLanguage booLanguage : bookLanguageList) {

            p = new BookLanguage(booLanguage.getBooLangCode(), booLanguage.getBooLangName(), booLanguage.getBooLangStatus());
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
        jtLanguage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jpUpdate = new javax.swing.JPanel();
        btnSave = new javax.swing.JLabel();
        jpValidate = new javax.swing.JPanel();
        btnSave1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTID = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 900));
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

        add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Statut");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 226, 111, 36));
        add(jtLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 151, 282, 31));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Nom du language");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 150, -1, 31));

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

        add(jpUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 105, 35));

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

        add(jpValidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 105, 35));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activer", "Desactiver" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 227, 282, 36));
        add(jTID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 27, 21, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void tableSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseClicked

    }//GEN-LAST:event_tableSearchMouseClicked

    private void tableSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseReleased

        String bookLanguageName = null;
        bookLanguageName = tableSearch.getValueAt(tableSearch.getSelectedRow(), 0).toString();
        jtLanguage.setText(bookLanguageName);
        int a = Integer.valueOf(bookLanguageDAO.findByColumn("bookLangName", bookLanguageName).get(0).getBooLangStatus());
        if (a == 0) {
            jComboBox1.setSelectedIndex(0);
        } else {
            jComboBox1.setSelectedIndex(1);
        }
        jTID.setText(String.valueOf(bookLanguageDAO.findByColumn("bookLangName", bookLanguageName).get(0).getBooLangCode()));


    }//GEN-LAST:event_tableSearchMouseReleased

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked

        
        jpUpdate.setVisible(false);
        jpValidate.setVisible(true);
        jComboBox1.setSelectedIndex(-1);
        tableSearch.setModel(new DefaultTableModel());
        tableSearch.setEnabled(false);

    }//GEN-LAST:event_btnNewMouseClicked

    private void btnSearchOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchOrderMouseReleased
        
        
        
        
        tableSearch.setEnabled(true);     
        tableSearch.setModel(initTableModel());
        tableSearch.revalidate();
        tableSearch.removeAll();
        jpUpdate.setVisible(true);
        jpValidate.setVisible(false);
        jComboBox1.setSelectedIndex(-1);

    }//GEN-LAST:event_btnSearchOrderMouseReleased

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked

        String a = jtLanguage.getText();
        BookLanguage language = new BookLanguage();
        language.setBooLangName(a);

        if (jComboBox1.getSelectedIndex() == 0) {
            language.setBooLangStatus(0);
        } else {
            language.setBooLangStatus(1);
        }

        if (bookLanguageDAO.answer(language) == false) {
            bookLanguageDAO.create(language);
            jop1.showMessageDialog(null, "Le language a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jtLanguage.setText(null);
        jTID.setText(null);
        jComboBox1.setSelectedIndex(-1);

    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSave1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSave1MouseClicked

        BookLanguage bookLanguage = new BookLanguage();
        bookLanguage.setBooLangName(jtLanguage.getText());
        if (jComboBox1.getSelectedItem().equals("Activer")) {
            bookLanguage.setBooLangStatus(0);
        } else {
            bookLanguage.setBooLangStatus(1);
        }
        if (bookLanguageDAO.answer(bookLanguage) == false) {
            bookLanguageDAO.create(bookLanguage);
            jop1.showMessageDialog(null, "Le language a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jtLanguage.setText(null);
        jTID.setText(null);
        jComboBox1.setSelectedIndex(-1);

    }//GEN-LAST:event_btnSave1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField jTID;
    private javax.swing.JPanel jpUpdate;
    private javax.swing.JPanel jpValidate;
    private javax.swing.JTextField jtLanguage;
    private javax.swing.JTable tableSearch;
    // End of variables declaration//GEN-END:variables
}
