package PanelOk;

import ClassObjet.Forma;
import SQLS.FormatsDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormatPanelAdd extends javax.swing.JPanel {

    JOptionPane jop1,jop2 = new JOptionPane();
    FormatsDAO form = new FormatsDAO();

    public FormatPanelAdd() {
        initComponents();
    }

    public DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add("Numéro");
        v.add("Format");

        return new javax.swing.table.DefaultTableModel(
                initFormatVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false, false, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }

    private Vector initFormatVector() {
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

        String query = "SELECT * FROM FORMATS;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Forma p = new Forma(rs.getInt("forId"), rs.getString("forName"));
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

        jpAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTAddFormat = new javax.swing.JTextField();
        jBSelect = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 900));

        jpAdd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpAddAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setText("FORMAT");

        jBSelect.setText("OK");
        jBSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBSelectMousePressed(evt);
            }
        });
        jBSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAddLayout = new javax.swing.GroupLayout(jpAdd);
        jpAdd.setLayout(jpAddLayout);
        jpAddLayout.setHorizontalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jBSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTAddFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jpAddLayout.setVerticalGroup(
            jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAddLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAddFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jBSelect)
                .addContainerGap())
        );

        add(jpAdd);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSelectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSelectMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSelectMousePressed

    private void jBSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelectActionPerformed

        String a = jTAddFormat.getText();
        Forma format = new Forma();
        format.setForName(a);

        if (form.answer(format) == false) {
            form.create(format);
            jop1.showMessageDialog(null, "Le format a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        else {
            jop2.showMessageDialog(null, "Insertion déjà présente dans la base ", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        jTAddFormat.setText("");

    }//GEN-LAST:event_jBSelectActionPerformed

    private void jpAddAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpAddAncestorAdded

    }//GEN-LAST:event_jpAddAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTAddFormat;
    private javax.swing.JPanel jpAdd;
    // End of variables declaration//GEN-END:variables
}