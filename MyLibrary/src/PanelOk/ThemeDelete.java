/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelOk;

import ClassObjet.Theme;
import SQLS.ThemeDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class ThemeDelete extends javax.swing.JPanel {
    Theme theme = new Theme();
    Vector v = new Vector();
    ThemeDAO themeDAO = new ThemeDAO();
    JOptionPane jop1=new JOptionPane();
    
    
    public ThemeDelete() {
        initComponents();
        jComboBox1.setSelectedIndex(-1);
    }

    
    private DefaultComboBoxModel initThemeModel() {
        return new DefaultComboBoxModel(initContactVector());
        
    }

    private Vector initContactVector() {

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
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 600));

        jComboBox1.setModel(initThemeModel());
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Selectionner un thème:");

        jButton4.setText("SUPPRIMER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1))
                .addGap(48, 48, 48)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    Theme t = new Theme();
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

         t = (Theme) jComboBox1.getSelectedItem();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        themeDAO.delete(t);
        jComboBox1.removeAllItems();
        jComboBox1.setModel(initThemeModel());
        jop1.showMessageDialog(null, "Le thème a été supprimé avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
