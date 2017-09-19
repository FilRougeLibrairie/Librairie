/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelEnCoursChrys;

import ClassObjet.SubTheme;
import ClassObjet.Theme;
import SQLS.SubThemeDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Chrys
 */
public class SubthemeUpdatePanel extends javax.swing.JPanel {

   SubThemeDAO subthemeDAO = new SubThemeDAO();
   SubTheme subtheme =new SubTheme();
   Theme t = new Theme();
   
   
    public SubthemeUpdatePanel() {
        initComponents();
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.setSelectedIndex(-1);
        jTid.setVisible(false);
        jpEdit.setVisible(false);
    }

    private DefaultComboBoxModel initThemeModel() {
        return new DefaultComboBoxModel(initThemeVector());
    }

    private DefaultComboBoxModel initSubthemeModel() {
        return new DefaultComboBoxModel(initSubThemeVector());
    }

    // vector Theme
    private Vector initThemeVector() {
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

        String query = "SELECT * FROM theme ORDER BY thename ;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                v.add(new Theme(rs.getInt("theId"), rs.getString("theName"), rs.getString("thedescription")));

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

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jpEdit = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDescription = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTid = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(initSubthemeModel() );
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 309, 38));

        jLabel1.setText("Sous Thème à modifier:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 189, 40));

        jLabel2.setText("Nom du Sous thème");

        jtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Description");

        jTDescription.setColumns(20);
        jTDescription.setRows(5);
        jScrollPane1.setViewportView(jTDescription);

        jButton2.setText("MODIFIER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEditLayout = new javax.swing.GroupLayout(jpEdit);
        jpEdit.setLayout(jpEditLayout);
        jpEditLayout.setHorizontalGroup(
            jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditLayout.createSequentialGroup()
                .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEditLayout.createSequentialGroup()
                        .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpEditLayout.createSequentialGroup()
                                .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtName, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpEditLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jpEditLayout.setVerticalGroup(
            jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditLayout.createSequentialGroup()
                .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpEditLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 112, 663, 278));

        jComboBox2.setModel(initThemeModel());
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 309, 42));

        jLabel4.setText("Thème ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 185, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNameActionPerformed

    
    

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        if (jComboBox2.getSelectedItem() != null) {
            t = (Theme) jComboBox2.getSelectedItem();
            jComboBox1.setModel(initSubthemeModel());
        } else {
            jComboBox1.setSelectedIndex(-1);
        }

//        subtheme=(SubTheme) jComboBox1.getSelectedItem();

    }//GEN-LAST:event_jComboBox2ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JOptionPane jop1 = new JOptionPane();
        SubTheme s = new SubTheme();
        s.setSubName(jtName.getText());
        s.setSubDescription(jTDescription.getText());
        s.setTheId(t);
        s.setSubId(Integer.valueOf(jTid.getText()));
        
        subthemeDAO.update(s);
        jComboBox1.setModel(initSubthemeModel());
        jComboBox2.setModel(initThemeModel());
        jop1.showMessageDialog(null, "Le sous thème a été modifié avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        if (jComboBox1.getSelectedItem() != null) {
            jtName.setText(subtheme.getSubName());
            jTDescription.setText(subtheme.getSubDescription());
            jTid.setText(String.valueOf(subtheme.getSubId()));
            jpEdit.setVisible(true);
        }
        else{
            
        }


    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTDescription;
    private javax.swing.JTextField jTid;
    private javax.swing.JPanel jpEdit;
    private javax.swing.JTextField jtName;
    // End of variables declaration//GEN-END:variables

 // Vector sous theme
    private Vector initSubThemeVector() {
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

        String query = "SELECT * FROM subtheme WHERE theId = '" + t.getTheId() + "'ORDER BY subname;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                v.add(new SubTheme(rs.getInt("subId"), t, rs.getString("subname"), rs.getString("subdescription")));

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

}
