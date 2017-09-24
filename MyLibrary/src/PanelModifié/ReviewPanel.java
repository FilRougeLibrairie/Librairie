package PanelModifié;

import ClassObjet.Customer;
import ClassObjet.OrderLine;
import ClassObjet.Review;
import SQLS.ReviewDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReviewPanel extends javax.swing.JFrame {

    Review review = new Review();
    ReviewDAO reviewDAO = new ReviewDAO();
    String term = null;
    String column = null;
    Vector<Review> reviewList;
    JOptionPane jop1, jop2= new JOptionPane();

    public ReviewPanel() {
        initComponents();
        comboSearch.setSelectedIndex(-1);
        jComboStatut.setEnabled(false);
        jTrevId.setEnabled(false);
        jTOrd.setEnabled(false);
        jTcusId.setEnabled(false);
        jTDate.setEnabled(false);
        jTbooIsbn.setEnabled(false);
        jTIp.setEnabled(false);

    }

    public DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add("N° de la note");

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
        int termInt = 0;
        if (comboSearch.getSelectedItem() != null) {
            reviewList = new Vector<Review>();
            String type = (String) comboSearch.getSelectedItem();
            // cas book
            if ("Livre".equals(type)) {
                term = tfSearch.getText().trim();
                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le n° ISBN du livre")) {
                    reviewList = reviewDAO.findAll();
                } else {
                    reviewList = reviewDAO.findByIsbn(term);
                }
            }

            // cas client
            if (type.equalsIgnoreCase("Client")) {
                column = "cusId";
                term = tfSearch.getText().trim();
                if (term == null || term.isEmpty() || term.equalsIgnoreCase("Entrer le n° de client")) {
                    reviewList = reviewDAO.findAll();
                } else {
                    reviewList = reviewDAO.findByCustomer(term);
                }
            }
            for (Review rev : reviewList) {
                Review p = new Review(rev.getRevId());
                v.add(p.getVector());
            }

            // cas Statut en attente
            if (type.equalsIgnoreCase("Statut en attente")) {
                column = "revStatus";
                termInt = 2;
                reviewList = reviewDAO.findByColumn(column, termInt);
                for (Review rev : reviewList) {

                    Review p = new Review(rev.getRevId());
                    v.add(p.getVector());
                }
            }

            // cas Statut valide
            if (type.equalsIgnoreCase("Statut validé")) {
               column = "revStatus";
                termInt = 3;
                reviewList = reviewDAO.findByColumn(column, termInt);
                for (Review rev : reviewList) {

                    Review p = new Review(rev.getRevId());
                    v.add(p.getVector());
                }
            }

            // cas Statut rejete
            if (type.equalsIgnoreCase("Statut rejeté")) {
                column = "revStatus";
                termInt = 4;
                reviewList = reviewDAO.findByColumn(column, termInt);
                for (Review rev : reviewList) {
                   Review p = new Review(rev.getRevId());
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
        comboSearch = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSearch = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSearchOrder = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTrevId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTOrd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTcusId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTbooIsbn = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTIp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtNote = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTComment = new javax.swing.JTextPane();
        jPanel22 = new javax.swing.JPanel();
        btnSave = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTDate = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        btnNo = new javax.swing.JLabel();
        jComboStatut = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setVisible(true);

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Livre", "Client", "Statut en attente", "Statut validé", "Statut rejeté" }));
        comboSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboSearchMouseClicked(evt);
            }
        });
        comboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSearchActionPerformed(evt);
            }
        });

        jLabel5.setText("Recherche Note  par :");

        tableSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableSearchMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableSearch);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSearchOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchOrder.setText("Rechercher");
        btnSearchOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSearchOrderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(tfSearch)
                            .addComponent(comboSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel8.setText("N° de la note:");

        jLabel9.setText("N° de Ligne de commande");

        jLabel10.setText("N° de client");

        jLabel14.setText("Isbn");

        jLabel15.setText("IP");

        jLabel12.setText("Note");

        jLabel40.setText("Commentaire :");

        jScrollPane3.setViewportView(jTComment);

        jPanel22.setBackground(new java.awt.Color(51, 102, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("VALIDER");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel13.setText("Statut de la note");

        jLabel11.setText("Date");

        jPanel23.setBackground(new java.awt.Color(51, 102, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNo.setForeground(new java.awt.Color(255, 255, 255));
        btnNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNo.setText("REJETER");
        btnNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNo, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jComboStatut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Attente", "Validé", "Rejeté" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTrevId, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                        .addComponent(jTOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTbooIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTcusId, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtNote, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(jTDate, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(jTIp, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(jComboStatut, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel40)
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTrevId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTOrd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTcusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTbooIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboStatut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents
int revId =0;
    private void tableSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseReleased

        revId = Integer.valueOf(tableSearch.getValueAt(tableSearch.getSelectedRow(), 0).toString());
        jTrevId.setText(String.valueOf(reviewDAO.find(revId).getRevId()));
        jTOrd.setText(String.valueOf(reviewDAO.find(revId).getOrdLineId().getOrdLineId()));
        jTcusId.setText(String.valueOf(reviewDAO.find(revId).getCusId().getCusID()));
        jTDate.setText(String.valueOf(reviewDAO.find(revId).getRevDate()));
        jTbooIsbn.setText(String.valueOf(reviewDAO.find(revId).getBooIsbn13()));
        if (reviewDAO.find(revId).getRevStatus() == 2) {
            jComboStatut.setSelectedIndex(0);
        }
        if (reviewDAO.find(revId).getRevStatus() == 3) {
            jComboStatut.setSelectedIndex(1);
        }
        if (reviewDAO.find(revId).getRevStatus() == 4) {
            jComboStatut.setSelectedIndex(2);
        }
        jTIp.setText(String.valueOf(reviewDAO.find(revId).getRevIP()));
        jtNote.setText(String.valueOf(reviewDAO.find(revId).getRevNote()));
        jTComment.setText(String.valueOf(reviewDAO.find(revId).getRevComment()));

    }//GEN-LAST:event_tableSearchMouseReleased

    private void btnSearchOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchOrderMouseReleased
        tableSearch.setModel(initTableModel());
    }//GEN-LAST:event_btnSearchOrderMouseReleased

    private void comboSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboSearchMouseClicked


    }//GEN-LAST:event_comboSearchMouseClicked

    private void comboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSearchActionPerformed

        if (comboSearch.getSelectedItem() != null) {
            if (comboSearch.getSelectedItem().equals("Client")) {
                tfSearch.setText("Entrer le n° de client");
            }
            if (comboSearch.getSelectedItem().equals("Livre")) {
                tfSearch.setText("Entrer le n° ISBN du livre");
            }
            if (comboSearch.getSelectedItem().equals("Statut en attente") || comboSearch.getSelectedItem().equals("Statut validé") || comboSearch.getSelectedItem().equals("Statut rejeté")) {
                tfSearch.setText(null);
                tfSearch.setEnabled(false);
                jComboStatut.setEnabled(false);
            } else {
                tfSearch.setEnabled(true);
            }
        }


    }//GEN-LAST:event_comboSearchActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked

    
    review= new Review();
    
    review.setBooIsbn13(jTbooIsbn.getText());
    Customer cus= new Customer();
    cus.setCusID(Integer.valueOf(jTcusId.getText()));
    review.setCusId(cus);
    OrderLine ord = new OrderLine();
    ord.setOrdLineId(Integer.valueOf(jTOrd.getText()));
    review.setOrdLineId(ord);
    
    review.setRevComment(jTComment.getText());
    review.setRevDate(String.valueOf(reviewDAO.find(revId).getRevDate()));
    review.setRevIP(jTIp.getText());
    review.setRevId(Integer.valueOf(jTrevId.getText()));
    review.setRevNote(Float.valueOf(jtNote.getText()));
    review.setRevStatus(3);
  
        reviewDAO.update(review);
        jop1.showMessageDialog(null, "Commentaire validé", "Information", JOptionPane.INFORMATION_MESSAGE);
        tableSearch.setModel(initTableModel());
        
        
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoMouseClicked

        
review= new Review();
    
    review.setBooIsbn13(jTbooIsbn.getText());
    Customer cus= new Customer();
    cus.setCusID(Integer.valueOf(jTcusId.getText()));
    review.setCusId(cus);
    OrderLine ord = new OrderLine();
    ord.setOrdLineId(Integer.valueOf(jTOrd.getText()));
    review.setOrdLineId(ord);
    
    review.setRevComment(jTComment.getText());
    review.setRevDate(String.valueOf(reviewDAO.find(revId).getRevDate()));
    review.setRevIP(jTIp.getText());
    review.setRevId(Integer.valueOf(jTrevId.getText()));
    review.setRevNote(Float.valueOf(jtNote.getText()));
    review.setRevStatus(4);
  
        reviewDAO.update(review);
        jop1.showMessageDialog(null, "Commentaire refusé", "Information", JOptionPane.INFORMATION_MESSAGE);
        tableSearch.setModel(initTableModel());





// TODO add your handling code here:
    }//GEN-LAST:event_btnNoMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReviewPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReviewPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReviewPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReviewPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReviewPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnNo;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnSearchOrder;
    private javax.swing.JComboBox comboSearch;
    private javax.swing.JComboBox jComboStatut;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTComment;
    private javax.swing.JTextField jTDate;
    private javax.swing.JTextField jTIp;
    private javax.swing.JTextField jTOrd;
    private javax.swing.JTextField jTbooIsbn;
    private javax.swing.JTextField jTcusId;
    private javax.swing.JTextField jTrevId;
    private javax.swing.JTextField jtNote;
    private javax.swing.JTable tableSearch;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
