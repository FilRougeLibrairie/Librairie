package PanelModifié;

import ClassObjet.Offer;
import SQLS.OfferDAO;
import java.awt.Color;
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

public class OfferUpdatePanel extends javax.swing.JPanel {

    JDatePickerImpl datePicker, datePicker2;
    private JFileChooser jfc = new JFileChooser();
    private String date, dateEnd;
    JOptionPane jop1, jop2 = new JOptionPane();
    OfferDAO offerDAO = new OfferDAO();
    Offer offer = new Offer();
    Vector<Offer> offerList;
    Vector v = new Vector();
    Offer p = new Offer();

    public OfferUpdatePanel() {
        initComponents();
        jComboStatus.setSelectedIndex(-1);
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

    private void datePicker2ActionPerformed(java.awt.event.ActionEvent evt) {
        Date selectedDate2 = (Date) datePicker2.getModel().getValue();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        dateEnd = df2.format(selectedDate2);
    }

    private DefaultComboBoxModel initOfferModel() {
        return new DefaultComboBoxModel(initOfferVector());
    }

    
    
    // Vector offre
    private Vector initOfferVector() {
        Vector v = new Vector();
        offerList = new Vector<Offer>();
        offerList = offerDAO.findAll();
        for (Offer offer : offerList) {

            p = new Offer(offer.getOffId(), offer.getOffName(), offer.getOffText(), offer.getOffDateStart(), offer.getOffDateEnd(), offer.getOffDiscount(), offer.getOffPicture(), offer.getOffStatus());
            v.add(p.getName());
        }
        return v;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTLink = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTDiscount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelDate1 = new javax.swing.JPanel();
        panelDate = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComment = new javax.swing.JTextArea();
        jComboStatus = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel3.setText("Lien de l'image ");

        jTLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTLinkActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setText("SELECTIONNER UNE IMAGE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("% de Remise:");

        jLabel6.setText("Date de fin:");

        javax.swing.GroupLayout panelDate1Layout = new javax.swing.GroupLayout(panelDate1);
        panelDate1.setLayout(panelDate1Layout);
        panelDate1Layout.setHorizontalGroup(
            panelDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDate1Layout.setVerticalGroup(
            panelDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDateLayout = new javax.swing.GroupLayout(panelDate);
        panelDate.setLayout(panelDateLayout);
        panelDateLayout.setHorizontalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
        panelDateLayout.setVerticalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLabel5.setText("Date de début:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom de l'offre:");

        jLabel2.setText("Commentaire:");

        jTComment.setColumns(20);
        jTComment.setRows(5);
        jScrollPane1.setViewportView(jTComment);

        jComboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Actif", "Inactif" }));
        jComboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(571, 571, 571))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTLink, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(184, 184, 184))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboStatus, 0, 304, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                        .addComponent(jTDiscount)
                                        .addComponent(jTName)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTLink, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 20, 700, 520);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

//        offer.setOffName(jTName.getText());
//        offer.setOffText(jTComment.getText());
//        offer.setOffPicture(jTLink.getText());
//        offer.setOffDateStart(date);
//        offer.setOffDateEnd(dateEnd);
//        offer.setOffDiscount(Float.valueOf(jTDiscount.getText()));
//
//        offerDAO.update(offer);
//        jop1.showMessageDialog(null, "L'offre a été modifiée avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int returnval = jfc.showOpenDialog(jButton2);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            //recuperation du chemin
            jTLink.setText(jfc.getSelectedFile().getAbsolutePath());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLinkActionPerformed

    }//GEN-LAST:event_jTLinkActionPerformed

    int id = 0;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        jComboBox1.setModel(initOfferModel());

        if (jComboBox1.getSelectedIndex() != -1) {


            Object var = jComboBox1.getSelectedItem();
           
            
            
           System.out.println(var) ;
////            String arr[] = sentence.split(" ");
////            String firstWord = arr[0].trim();
////            id = Integer.valueOf(firstWord);
            
            Offer off =(Offer) offerDAO.find(id);
            
            
            jTName.setText(off.getOffName());
            jTComment.setText(off.getOffText());
            jTLink.setText(off.getOffPicture());
//        offer.setOffDateStart(date);
//        offer.setOffDateEnd(dateEnd);
            jTDiscount.setText(String.valueOf(off.getOffDiscount()));

            if(off.getOffStatus()==0){
                jComboStatus.setSelectedItem("Actif");
            }
            else{
                jComboStatus.setSelectedItem("Inactif");
            }
            
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboStatusActionPerformed

    }//GEN-LAST:event_jComboStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTComment;
    private javax.swing.JTextField jTDiscount;
    private javax.swing.JTextField jTLink;
    private javax.swing.JTextField jTName;
    private javax.swing.JPanel panelDate;
    private javax.swing.JPanel panelDate1;
    // End of variables declaration//GEN-END:variables
}
