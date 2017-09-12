/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ClassObjet.AccessProfile;
import ClassObjet.Employee;
import SQLS.AccessProfile_SQL;
import SQLS.Employee_SQL;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author ggarvanese
 */
public class JPEmployee extends javax.swing.JPanel {


    SQLS.Employee_SQL connexion;
    Vector<Employee> empVect;
    Vector<AccessProfile> accessList;
    
    public JPEmployee() {
        initComponents();
        connexion = new Employee_SQL();
        try {
            empVect = connexion.loadDatasFromDB();
            accessList = connexion.loadDatasFromDB();
            
            for(Employee emp : empVect){
                
               AccessProfile_SQL accessQuery = new AccessProfile_SQL();
               Vector accessName = accessQuery.findNameInTable(emp.getAccProfileCode());
              
                for (int i = 0; i < accessName.size(); i++) {
                    emp.getAccProfileCode().getAccProfileName();
                }
              System.out.println(emp.toString());
              System.out.println(emp.getAccProfileCode().getAccProfileName());

               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JPEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JPEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPEmployee().setVisible(true);
            }
        });
    }
    
    
    
    
     void setColor(JPanel panel) {
        panel.setBackground(new Color(102, 102, 102));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(204, 204, 204));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bouttonAdmin = new javax.swing.JPanel();
        bouttonEmploye = new javax.swing.JPanel();
        jLabelEmploye = new javax.swing.JLabel();
        bouttonProduit = new javax.swing.JPanel();
        jLabelProduit = new javax.swing.JLabel();
        bouttonCommande = new javax.swing.JPanel();
        jLabelCommande = new javax.swing.JLabel();
        bouttonModerateur = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane = new javax.swing.JTabbedPane();
        jToolBar5 = new javax.swing.JToolBar();
        jToolBar6 = new javax.swing.JToolBar();
        jPanel5 = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bouttonAdmin.setBackground(new java.awt.Color(204, 204, 204));
        bouttonAdmin.setForeground(new java.awt.Color(204, 204, 204));
        bouttonAdmin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bouttonAdminMouseMoved(evt);
            }
        });
        bouttonAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bouttonAdminMousePressed(evt);
            }
        });

        javax.swing.GroupLayout bouttonAdminLayout = new javax.swing.GroupLayout(bouttonAdmin);
        bouttonAdmin.setLayout(bouttonAdminLayout);
        bouttonAdminLayout.setHorizontalGroup(
            bouttonAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        bouttonAdminLayout.setVerticalGroup(
            bouttonAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel2.add(bouttonAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 260, 70));

        bouttonEmploye.setBackground(new java.awt.Color(204, 204, 204));
        bouttonEmploye.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bouttonEmployeMouseMoved(evt);
            }
        });
        bouttonEmploye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bouttonEmployeMousePressed(evt);
            }
        });

        jLabelEmploye.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmploye.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelEmploye.setText("Employé");

        javax.swing.GroupLayout bouttonEmployeLayout = new javax.swing.GroupLayout(bouttonEmploye);
        bouttonEmploye.setLayout(bouttonEmployeLayout);
        bouttonEmployeLayout.setHorizontalGroup(
            bouttonEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bouttonEmployeLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabelEmploye)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        bouttonEmployeLayout.setVerticalGroup(
            bouttonEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bouttonEmployeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelEmploye)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.add(bouttonEmploye, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 260, 70));

        bouttonProduit.setBackground(new java.awt.Color(204, 204, 204));
        bouttonProduit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bouttonProduitMouseMoved(evt);
            }
        });
        bouttonProduit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bouttonProduitMousePressed(evt);
            }
        });

        jLabelProduit.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProduit.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelProduit.setText("Produits");

        javax.swing.GroupLayout bouttonProduitLayout = new javax.swing.GroupLayout(bouttonProduit);
        bouttonProduit.setLayout(bouttonProduitLayout);
        bouttonProduitLayout.setHorizontalGroup(
            bouttonProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bouttonProduitLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabelProduit)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        bouttonProduitLayout.setVerticalGroup(
            bouttonProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bouttonProduitLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelProduit)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.add(bouttonProduit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, 70));

        bouttonCommande.setBackground(new java.awt.Color(204, 204, 204));
        bouttonCommande.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bouttonCommandeMouseMoved(evt);
            }
        });
        bouttonCommande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bouttonCommandeMousePressed(evt);
            }
        });

        jLabelCommande.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCommande.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelCommande.setText("Commandes");

        javax.swing.GroupLayout bouttonCommandeLayout = new javax.swing.GroupLayout(bouttonCommande);
        bouttonCommande.setLayout(bouttonCommandeLayout);
        bouttonCommandeLayout.setHorizontalGroup(
            bouttonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bouttonCommandeLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabelCommande)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        bouttonCommandeLayout.setVerticalGroup(
            bouttonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bouttonCommandeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelCommande)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.add(bouttonCommande, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 260, 70));

        bouttonModerateur.setBackground(new java.awt.Color(204, 204, 204));
        bouttonModerateur.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bouttonModerateurMouseMoved(evt);
            }
        });
        bouttonModerateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bouttonModerateurMousePressed(evt);
            }
        });

        javax.swing.GroupLayout bouttonModerateurLayout = new javax.swing.GroupLayout(bouttonModerateur);
        bouttonModerateur.setLayout(bouttonModerateurLayout);
        bouttonModerateurLayout.setHorizontalGroup(
            bouttonModerateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        bouttonModerateurLayout.setVerticalGroup(
            bouttonModerateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel2.add(bouttonModerateur, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 260, 70));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MyLibrarY");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 180, 80));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 170, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 620));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rechercher");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(743, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 1030, 70));

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setToolTipText("");

        jToolBar5.setRollover(true);
        jTabbedPane.addTab("tab1", jToolBar5);

        jToolBar6.setRollover(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        jToolBar6.add(jPanel5);

        jTabbedPane.addTab("tab2", jToolBar6);

        jToolBar7.setRollover(true);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "REFERENCE COMMANDE", "DATE COMMANDE", "PRIX COMMANDE H.T", "PRIX  COMMANDE T.T.C", "STATUT COMMANDE", "DATE LIVRAISON"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(5);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setText("Modifier Commande");

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setText("Créer Commande");

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setText("Annuler commande");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jToolBar7.add(jPanel6);

        jTabbedPane.addTab("tab3", jToolBar7);

        jPanel1.add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 990, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bouttonAdminMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonAdminMouseMoved
        // TODO add your handling code here:
        setColor(bouttonAdmin);
        resetColor(bouttonModerateur);
        resetColor(bouttonCommande);
        resetColor(bouttonProduit);
        resetColor(bouttonEmploye);
    }//GEN-LAST:event_bouttonAdminMouseMoved

    private void bouttonAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonAdminMousePressed
        // TODO add your handling code here:
        setColor(bouttonAdmin);
        resetColor(bouttonModerateur);
        resetColor(bouttonCommande);
        resetColor(bouttonProduit);
        resetColor(bouttonEmploye);

        //        jTabbedPane.setSelectedIndex(5);
    }//GEN-LAST:event_bouttonAdminMousePressed

    private void bouttonEmployeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonEmployeMouseMoved
        // TODO add your handling code here:
        setColor(bouttonEmploye);
        resetColor(bouttonProduit);
        resetColor(bouttonCommande);
        resetColor(bouttonModerateur);
        resetColor(bouttonAdmin);
    }//GEN-LAST:event_bouttonEmployeMouseMoved

    private void bouttonEmployeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonEmployeMousePressed
        // TODO add your handling code here:
        setColor(bouttonEmploye);
        resetColor(bouttonProduit);
        resetColor(bouttonCommande);
        resetColor(bouttonModerateur);
        resetColor(bouttonAdmin);

        jTabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_bouttonEmployeMousePressed

    private void bouttonProduitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonProduitMouseMoved
        // TODO add your handling code here:
        setColor(bouttonProduit);
        resetColor(bouttonEmploye);
        resetColor(bouttonCommande);
        resetColor(bouttonModerateur);
        resetColor(bouttonAdmin);
    }//GEN-LAST:event_bouttonProduitMouseMoved

    private void bouttonProduitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonProduitMousePressed
        // TODO add your handling code here:
        setColor(bouttonProduit);
        resetColor(bouttonEmploye);
        resetColor(bouttonCommande);
        resetColor(bouttonModerateur);
        resetColor(bouttonAdmin);

        jTabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_bouttonProduitMousePressed

    private void bouttonCommandeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonCommandeMouseMoved
        // TODO add your handling code here:
        setColor(bouttonCommande);
        resetColor(bouttonProduit);
        resetColor(bouttonEmploye);
        resetColor(bouttonModerateur);
        resetColor(bouttonAdmin);
    }//GEN-LAST:event_bouttonCommandeMouseMoved

    private void bouttonCommandeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonCommandeMousePressed
        // TODO add your handling code here:
        setColor(bouttonCommande);
        resetColor(bouttonProduit);
        resetColor(bouttonEmploye);
        resetColor(bouttonModerateur);
        resetColor(bouttonAdmin);

        jTabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_bouttonCommandeMousePressed

    private void bouttonModerateurMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonModerateurMouseMoved
        // TODO add your handling code here:
        setColor(bouttonModerateur);
        resetColor(bouttonCommande);
        resetColor(bouttonProduit);
        resetColor(bouttonEmploye);
        resetColor(bouttonAdmin);
    }//GEN-LAST:event_bouttonModerateurMouseMoved

    private void bouttonModerateurMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouttonModerateurMousePressed
        // TODO add your handling code here:
        setColor(bouttonModerateur);
        resetColor(bouttonCommande);
        resetColor(bouttonProduit);
        resetColor(bouttonEmploye);
        resetColor(bouttonAdmin);

        jTabbedPane.setSelectedIndex(3);
    }//GEN-LAST:event_bouttonModerateurMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bouttonAdmin;
    private javax.swing.JPanel bouttonCommande;
    private javax.swing.JPanel bouttonEmploye;
    private javax.swing.JPanel bouttonModerateur;
    private javax.swing.JPanel bouttonProduit;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCommande;
    private javax.swing.JLabel jLabelEmploye;
    private javax.swing.JLabel jLabelProduit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    // End of variables declaration//GEN-END:variables
}