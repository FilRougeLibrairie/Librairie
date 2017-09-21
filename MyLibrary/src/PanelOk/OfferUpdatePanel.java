/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelOk;

import ClassObjet.Offer;
import SQLS.OfferDAO;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import utils.DateLabelFormatter;

/**
 *
 * @author Chrys
 */
public class OfferUpdatePanel extends javax.swing.JPanel {

    
    JDatePickerImpl datePicker,datePicker2;
    private JFileChooser jfc = new JFileChooser();
    private String date,dateEnd;
    JOptionPane jop1, jop2 = new JOptionPane();
    OfferDAO offerDAO = new OfferDAO();
    Offer offer = new Offer();
    
    
    
   
    
    
    public OfferUpdatePanel() {
        initComponents();
        
        jComboBox1.setSelectedIndex(-1);
        
        UtilDateModel model = new UtilDateModel();
        UtilDateModel mode2 = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        
        JDatePanelImpl datePanel1 = new JDatePanelImpl(mode2, p);
        
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBackground(Color.WHITE);
        datePicker.setBounds(0, 0, 200, 30);
        datePicker.setVisible(true);
        
        datePicker2 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        datePicker2.setBackground(Color.WHITE);
        datePicker2.setBounds(0, 0, 200, 30);
        datePicker2.setVisible(true);
        
        
        panelDate.setSize(100, 100);
        panelDate.add(datePicker);

        panelDate1.setSize(100, 100);
        panelDate1.add(datePicker2);
    
        
        datePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerActionPerformed(evt);
            }
        });
        
         datePicker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePicker2ActionPerformed(evt);
            }
        });

    }

    
     private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {
        Date selectedDate = (Date) datePicker.getModel().getValue();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        date = df.format(selectedDate);  
    }
     
     
     
     
     
//     
//    
//      private void datePickerActivActionPerformed(java.awt.event.ActionEvent evt) {
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        date = df.format(offer.getOffDateStart());  
//    }
//     
//      
//         private void datePickerEndActionPerformed(java.awt.event.ActionEvent evt) {
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        date = df.format(offer.getOffDateEnd());  
//    }
     
     
    
    private void datePicker2ActionPerformed(java.awt.event.ActionEvent evt) {
        Date selectedDate2 = (Date) datePicker2.getModel().getValue();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        dateEnd = df2.format(selectedDate2);
    }
    
    
     private DefaultComboBoxModel initOfferModel() {
        return new DefaultComboBoxModel(initOfferVector());
    }
    
    // Vector sous theme
    private Vector initOfferVector() {
        Vector v = new Vector();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
            return v;
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=myLibrary;user=sa;password=sa");
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }

        String query = "SELECT * FROM offer ORDER BY offDateStart;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                v.add(new Offer(rs.getInt("offId"), rs.getString("offName"),rs.getString("offText"),rs.getString("offDateStart"), rs.getString("offDateEnd"),rs.getFloat("offDiscount"), rs.getString("offPicture")));

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }

        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }

        System.out.println("Done!");

        return v;
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTName = new javax.swing.JTextField();
        jTDiscount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComment = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTLink = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelDate = new javax.swing.JPanel();
        panelDate1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 500));

        jLabel1.setText("Nom de l'offre:");

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setText("MODIFIER");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Commentaire:");

        jLabel3.setText("Lien de l'image ");

        jLabel4.setText("% de Remise:");

        jTComment.setColumns(20);
        jTComment.setRows(5);
        jScrollPane1.setViewportView(jTComment);

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setText("SELECTIONNER UNE IMAGE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTLinkActionPerformed(evt);
            }
        });

        jLabel5.setText("Date de début:");

        jLabel6.setText("Date de fin:");

        javax.swing.GroupLayout panelDateLayout = new javax.swing.GroupLayout(panelDate);
        panelDate.setLayout(panelDateLayout);
        panelDateLayout.setHorizontalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDateLayout.setVerticalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDate1Layout = new javax.swing.GroupLayout(panelDate1);
        panelDate1.setLayout(panelDate1Layout);
        panelDate1Layout.setHorizontalGroup(
            panelDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        panelDate1Layout.setVerticalGroup(
            panelDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jComboBox1.setModel(initOfferModel() );
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTLink, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTLink, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       
        offer.setOffName(jTName.getText());
        offer.setOffText(jTComment.getText());
        offer.setOffPicture(jTLink.getText());
        offer.setOffDateStart(date);
        offer.setOffDateEnd(dateEnd);
        offer.setOffDiscount(Float.valueOf(jTDiscount.getText()));

        offerDAO.update(offer);
        jop1.showMessageDialog(null, "L'offre a été modifiée avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int returnval = jfc.showOpenDialog(jButton2);
        if(returnval==JFileChooser.APPROVE_OPTION){
            //recuperation du chemin
            jTLink.setText(jfc.getSelectedFile().getAbsolutePath());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTLinkActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        
        

        
         if (jComboBox1.getSelectedItem() != null) {
        offer=(Offer) jComboBox1.getSelectedItem();    
       
        jTName.setText(offer.getOffName());
        jTComment.setText(offer.getOffText());
        jTLink.setText(offer.getOffPicture());
        
        
        
        
//        datePickerActivActionPerformed(evt);
//        datePickerEndActionPerformed(evt);   
        jTDiscount.setText(String.valueOf(offer.getOffDiscount()));
    
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTComment;
    private javax.swing.JTextField jTDiscount;
    private javax.swing.JTextField jTLink;
    private javax.swing.JTextField jTName;
    private javax.swing.JPanel panelDate;
    private javax.swing.JPanel panelDate1;
    // End of variables declaration//GEN-END:variables
}
