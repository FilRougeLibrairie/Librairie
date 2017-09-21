/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelOk;

import ClassObjet.Author;
import ClassObjet.ClassAssoc.Writing;
import SQLS.AuthorDAO;
import SQLS.WritingDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chrys
 */
public class AuthorDeletePanel extends javax.swing.JPanel {

    /**
     * Creates new form AuthorDeletePanel
     */
    public AuthorDeletePanel() {
        initComponents();
    }

    private DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add("N° d'Auteur");
        v.add("Prenom");
        v.add("Nom");
        v.add("Bibliographie");
        v.add("Statut");

        return new javax.swing.table.DefaultTableModel(
                
                
                initAutorVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                    
                    
                };
    }

    private Vector initAutorVector() {
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

        String query = "SELECT * FROM AUTHOR ORDER BY AutLastName ;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Author p = new Author(rs.getInt("autId"),
                        rs.getString("autFirstName"),
                        rs.getString("autLastName"),
                        rs.getString("autBiography"),
                        rs.getInt("autStatusCode"));
                v.add(p.getVector());

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

        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Selectionner le contact");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setAlignmentX(0.5F);

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setText("SUPPRIMER");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(initTableModel());
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 255, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1FocusGained

    String id = null;
    String autL =null;
    String autF=null;
    String autA= null;
    String autS=null;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        autL=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        autF=jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        autA=jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        autS=jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
                

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown

    }//GEN-LAST:event_jTable1ComponentShown

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked


    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JOptionPane jop1 = new JOptionPane();
        jTable1.setModel(initTableModel());
        Author a = new Author();
        AuthorDAO aut = new AuthorDAO();
        
        
        
        // creation de l'objet auteur dans writing
       
         Writing writing = new Writing();
         writing.setAutId(Integer.valueOf(id));
         writing.getBooIsbn13();
         WritingDAO writ = new WritingDAO();
         
         writ.update(writing);
        
         //suppression de l'auteur
      
        a.setAutId(Integer.valueOf(id));
        a.setAutFirstName(autF);
        a.setAutLastName(autL);
        a.setAutBiography(autA);
        a.setAutStatusCode(Integer.valueOf(autS));
        
        aut.delete(a);
        jTable1.setModel(initTableModel());
        jop1.showMessageDialog(null, "L'auteur a été supprimé avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

//    public void delete() {
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (ClassNotFoundException ex) {
//            System.err.println("Oops:ClassNotFoundException: " + ex.getMessage());
//        }
//
//        Connection connexion = null;
//
//        try {
//            String url = "jdbc:sqlserver://localhost:1433;"
//                    + "databaseName=myLibrary;user=sa;password=sa";
//
//            connexion = DriverManager.getConnection(url);
//        } catch (SQLException ex) {
//            System.err.println("Oops:SQLException: " + ex.getErrorCode() + "\n" + ex.getMessage());
//        }
//
//        try {
//
//            Statement statement = connexion.createStatement();
//
//            String query = "DELETE FROM author WHERE autid=" + id;
//
//            statement.executeUpdate(query);
//
//            statement.close();
//
//        } catch (SQLException ex) {
//            System.err.println("Oops:Statement:  " + ex.getErrorCode() + "\n" + ex.getMessage());
//        }
//
//        try {
//            connexion.close();
//        } catch (SQLException ex) {
//            Logger.getLogger("Oops:close: " + ex.getMessage());
//        }
//
//        System.out.println("Done!");
//
//    }
}
