
package PanelOk;

import ClassObjet.Keywords;
import SQLS.KeywordsDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class KeywordsUpdatePanel extends javax.swing.JPanel {

    public KeywordsUpdatePanel() {
        initComponents();
    }

     public DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add("Mot clé");

        return new javax.swing.table.DefaultTableModel(
                initKeywordsVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }

    private Vector initKeywordsVector() {
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

        String query = "SELECT * FROM KEYWORDS;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Keywords p = new Keywords(rs.getString("KeyName"));
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

        jPanel1 = new javax.swing.JPanel();
        jpField = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTKW = new javax.swing.JTextField();
        jpTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Nouveau Mot Clé");

        javax.swing.GroupLayout jpFieldLayout = new javax.swing.GroupLayout(jpField);
        jpField.setLayout(jpFieldLayout);
        jpFieldLayout.setHorizontalGroup(
            jpFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFieldLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTKW, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jpFieldLayout.setVerticalGroup(
            jpFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFieldLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jpFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTKW, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel1.add(jpField, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 155, -1, -1));

        jpTable.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jpTableLayout = new javax.swing.GroupLayout(jpTable);
        jpTable.setLayout(jpTableLayout);
        jpTableLayout.setHorizontalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTableLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpTableLayout.setVerticalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(jpTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 43, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Selectionner le mot clé à modifier");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setAlignmentX(0.5F);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 12, 214, 25));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setText("MODIFIER");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 305, 196, 49));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 810, 417));
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained

    }//GEN-LAST:event_jTable1FocusGained

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        jTKW.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown

    }//GEN-LAST:event_jTable1ComponentShown

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        String formatName = null;
        JOptionPane jop1 = new JOptionPane();

        
        formatName = jTKW.getText();

        Keywords kw = new Keywords();
        KeywordsDAO kwDAO = new KeywordsDAO();

        kw.setKeyName(formatName);
        kwDAO.update(kw);
        jTable1.setModel(initTableModel());
        jop1.showMessageDialog(null, "Modification réalisée avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTKW;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpField;
    private javax.swing.JPanel jpTable;
    // End of variables declaration//GEN-END:variables
}
