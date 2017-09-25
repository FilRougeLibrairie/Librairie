package PanelModifié;

import ClassObjet.SubTheme;
import ClassObjet.Theme;
import SQLS.SubThemeDAO;
import SQLS.ThemeDAO;
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
    SubTheme subtheme = new SubTheme();
    Theme t = new Theme();
    ThemeDAO themeDAO = new ThemeDAO();
    JOptionPane jop1 = new JOptionPane();
    public SubthemeUpdatePanel() {
        initComponents();
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.setSelectedIndex(-1);
        jpEdit.setVisible(false);
    }

    private DefaultComboBoxModel initThemeModel() {
        return new DefaultComboBoxModel(themeDAO.findAll());
    }

    private DefaultComboBoxModel initSubthemeModel() {
        return new DefaultComboBoxModel(initSubThemeVector());
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
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(initSubthemeModel() );
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 309, 38));

        jLabel1.setText("Sous Thème à modifier:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 189, 40));

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nom du Sous thème");
        jpEdit.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 30, 185, 35));

        jtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNameActionPerformed(evt);
            }
        });
        jpEdit.add(jtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 30, 310, 35));

        jLabel3.setText("Description");
        jpEdit.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 94, 185, 35));

        jTDescription.setColumns(20);
        jTDescription.setRows(5);
        jScrollPane1.setViewportView(jTDescription);

        jpEdit.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 94, 310, 116));

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setText("MODIFIER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jpEdit.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 170, 42));

        add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 620, 278));

        jComboBox2.setModel(initThemeModel());
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 309, 42));

        jLabel4.setText("Thème ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 185, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNameActionPerformed

    int subthemeValue = 0;

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        if (jComboBox2.getSelectedItem() != null) {
            t = (Theme) jComboBox2.getSelectedItem();
            jComboBox1.setModel(initSubthemeModel());

        } else {
            jComboBox1.setSelectedIndex(-1);
        }

    }//GEN-LAST:event_jComboBox2ActionPerformed
    SubTheme s = new SubTheme();
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        s.setSubId(subthemeValue);
        s.setSubName(jtName.getText());
        s.setSubDescription(jTDescription.getText());
        s.setTheId(t);
        s.setSubStatus(1);
        subthemeDAO.update(s);
        jComboBox1.setModel(initSubthemeModel());
        jComboBox2.setModel(initThemeModel());
        jtName.setText(null);
        jTDescription.setText(null);

        jop1.showMessageDialog(null, "Le sous thème a été modifié avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.setSelectedIndex(-1);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        if(jComboBox1.getSelectedItem() != null){
          
        String sentenceTheme = jComboBox1.getSelectedItem().toString().trim();
        String arrTheme[] = sentenceTheme.split(" ");
        String firstWorSubTheme = arrTheme[0].trim();   
        subthemeValue = Integer.valueOf(firstWorSubTheme); 
        jpEdit.setVisible(true);
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
