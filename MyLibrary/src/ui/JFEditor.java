
package ui;

import ClassObjet.Editor;
import SQLS.EditorDAO;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class JFEditor extends javax.swing.JFrame {

  
    public JFEditor() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        panelRechercher = new javax.swing.JPanel();
        labelRechercherOnPanel = new javax.swing.JLabel();
        panelCréer = new javax.swing.JPanel();
        labelCréer = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelRechercher = new javax.swing.JLabel();
        tfRechercher = new javax.swing.JTextField();
        labelNom = new javax.swing.JLabel();
        tfNom = new javax.swing.JTextField();
        comboStatut = new javax.swing.JComboBox<String>();
        labelStatut = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taPresentation = new javax.swing.JTextArea();
        labelPresentation = new javax.swing.JLabel();
        panelSauver = new javax.swing.JPanel();
        labelSauver1 = new javax.swing.JLabel();
        comboTypeRecherche = new javax.swing.JComboBox<String>();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        taResultatsRecherche = new javax.swing.JTextArea();
        panelSupp = new javax.swing.JPanel();
        labelSupprimer = new javax.swing.JLabel();
        tfStatut = new javax.swing.JTextField();
        panelModif = new javax.swing.JPanel();
        labelSupprimer1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Créer Nouveau");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(630, 900));
        getContentPane().setLayout(null);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setToolTipText("");
        panelPrincipal.setMinimumSize(new java.awt.Dimension(630, 900));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(630, 900));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRechercher.setBackground(new java.awt.Color(51, 102, 255));

        labelRechercherOnPanel.setForeground(new java.awt.Color(255, 255, 255));
        labelRechercherOnPanel.setText("               Rechercher ");
        labelRechercherOnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRechercherOnPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRechercherLayout = new javax.swing.GroupLayout(panelRechercher);
        panelRechercher.setLayout(panelRechercherLayout);
        panelRechercherLayout.setHorizontalGroup(
            panelRechercherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRechercherLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelRechercherOnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRechercherLayout.setVerticalGroup(
            panelRechercherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRechercherLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelRechercherOnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(panelRechercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, -1, -1));

        panelCréer.setBackground(new java.awt.Color(51, 102, 255));

        labelCréer.setForeground(new java.awt.Color(255, 255, 255));
        labelCréer.setText("           Créer Nouveau");
        labelCréer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCréerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCréerLayout = new javax.swing.GroupLayout(panelCréer);
        panelCréer.setLayout(panelCréerLayout);
        panelCréerLayout.setHorizontalGroup(
            panelCréerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCréer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        panelCréerLayout.setVerticalGroup(
            panelCréerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCréer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelCréer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        panelPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 820, 10));

        labelRechercher.setText("Rechercher :");
        panelPrincipal.add(labelRechercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 80, 20));
        panelPrincipal.add(tfRechercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 160, 30));

        labelNom.setText("Nom :");
        panelPrincipal.add(labelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 90, 30));
        panelPrincipal.add(tfNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 139, 300, 30));

        comboStatut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choix", "Actif", "Inactif" }));
        panelPrincipal.add(comboStatut, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 90, -1));

        labelStatut.setText("Statut :");
        panelPrincipal.add(labelStatut, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 40, 20));

        taPresentation.setColumns(20);
        taPresentation.setRows(5);
        jScrollPane1.setViewportView(taPresentation);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 300, 150));

        labelPresentation.setText("Presentation :");
        panelPrincipal.add(labelPresentation, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 130, 20));

        panelSauver.setBackground(new java.awt.Color(51, 102, 255));

        labelSauver1.setForeground(new java.awt.Color(255, 255, 255));
        labelSauver1.setText("               Sauvegarder");
        labelSauver1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSauver1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSauverLayout = new javax.swing.GroupLayout(panelSauver);
        panelSauver.setLayout(panelSauverLayout);
        panelSauverLayout.setHorizontalGroup(
            panelSauverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSauverLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelSauver1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSauverLayout.setVerticalGroup(
            panelSauverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSauverLayout.createSequentialGroup()
                .addComponent(labelSauver1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelSauver, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, -1));

        comboTypeRecherche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choix", "Tous", "Nom", "Id", "Statut" }));
        comboTypeRecherche.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTypeRechercheItemStateChanged(evt);
            }
        });
        panelPrincipal.add(comboTypeRecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 30, 70, 30));
        panelPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 820, 10));

        taResultatsRecherche.setColumns(20);
        taResultatsRecherche.setEditable(false);
        taResultatsRecherche.setRows(5);
        jScrollPane2.setViewportView(taResultatsRecherche);

        panelPrincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 620, 240));

        panelSupp.setBackground(new java.awt.Color(153, 153, 153));

        labelSupprimer.setForeground(new java.awt.Color(255, 255, 255));
        labelSupprimer.setText("               Supprimer");
        labelSupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSupprimerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSuppLayout = new javax.swing.GroupLayout(panelSupp);
        panelSupp.setLayout(panelSuppLayout);
        panelSuppLayout.setHorizontalGroup(
            panelSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuppLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSuppLayout.setVerticalGroup(
            panelSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuppLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(panelSupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, -1, -1));
        panelPrincipal.add(tfStatut, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 100, 30));

        panelModif.setBackground(new java.awt.Color(153, 153, 153));

        labelSupprimer1.setForeground(new java.awt.Color(255, 255, 255));
        labelSupprimer1.setText("                 Modifier");
        labelSupprimer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSupprimer1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelModifLayout = new javax.swing.GroupLayout(panelModif);
        panelModif.setLayout(panelModifLayout);
        panelModifLayout.setHorizontalGroup(
            panelModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModifLayout.createSequentialGroup()
                .addComponent(labelSupprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelModifLayout.setVerticalGroup(
            panelModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModifLayout.createSequentialGroup()
                .addComponent(labelSupprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, -1, -1));

        getContentPane().add(panelPrincipal);
        panelPrincipal.setBounds(0, 0, 900, 630);

        setSize(new java.awt.Dimension(916, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelSupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSupprimerMouseClicked
        // TODO add your handling code here:
        if (comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equalsIgnoreCase("Id")) {
            EditorDAO a = new EditorDAO();
            a.delete(((Editor) a.findById(Integer.parseInt(tfRechercher.getText()))));
            tfRechercher.setText("");
            tfNom.setText("");
            taPresentation.setText("");
            taResultatsRecherche.setText("");
            comboTypeRecherche.setSelectedIndex(0);
            comboStatut.setSelectedIndex(0);
            taResultatsRecherche.setText("Editeur Supprimé !");
        }
    }//GEN-LAST:event_labelSupprimerMouseClicked

    private void labelSauver1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSauver1MouseClicked
        // TODO add your handling code here:
        if (comboStatut.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Vous n'avez pas choisi de statut",
                    "Selectionnez un statut",
                    JOptionPane.ERROR_MESSAGE);
        } else if (comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equalsIgnoreCase("Id")) {

            EditorDAO a = new EditorDAO();
            Editor edi = (Editor) a.findById(Integer.parseInt(tfRechercher.getText()));
            edi.setEdiName(tfNom.getText());
            edi.setEdiPresentation(taPresentation.getText());
            if (tfStatut.getText().equalsIgnoreCase("Actif")) {
                edi.setEdiStatusCode(1);
            } else if (tfStatut.getText().equalsIgnoreCase("Inactif")) {
                edi.setEdiStatusCode(2);
            }

        } else {
            EditorDAO a = new EditorDAO();
            Editor e = new Editor();
            e.setEdiName(tfNom.getText());
            e.setEdiPresentation(taPresentation.getText());
            e.setEdiStatusCode(comboStatut.getSelectedIndex());
            a.create(e);

        }
    }//GEN-LAST:event_labelSauver1MouseClicked

    private void labelCréerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCréerMouseClicked
        // TODO add your handling code here:
        tfRechercher.setText("");
        tfNom.setText("");
        taPresentation.setText("");
        taResultatsRecherche.setText("");
        comboTypeRecherche.setSelectedIndex(0);
        comboStatut.setSelectedIndex(0);


    }//GEN-LAST:event_labelCréerMouseClicked

    private void labelRechercherOnPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRechercherOnPanelMouseClicked
        // TODO add your handling code here:
        EditorDAO a = new EditorDAO();
        if (comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equals("Tous")) {
            for (int i = 0; i <= a.findAll().size(); i++) {

                taResultatsRecherche.setText(((Editor) a.findAll().get(i)).toString());
            }
        } else if (comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equals("Nom")) {
            for (int i = 0; i <= a.findByCriteria(a.NAME, tfRechercher.getText()).size(); i++) {
                taResultatsRecherche.setText(a.findByCriteria(a.NAME, tfRechercher.getText()).get(i).toString());
            }
        } else if (comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equals("Id")) {
            tfNom.setEditable(false);
            tfStatut.setEditable(false);
            taPresentation.setEditable(false);
            panelSupp.setBackground(new java.awt.Color(51, 102, 255));
            panelModif.setBackground(new java.awt.Color(51, 102, 255));
            tfNom.setText(((Editor) a.findById(Integer.parseInt(tfRechercher.getText()))).getEdiName());
            tfStatut.setText(((Editor) a.findById(Integer.parseInt(tfRechercher.getText()))).EdiStatusCode());
            taPresentation.setText(((Editor) a.findById(Integer.parseInt(tfRechercher.getText()))).getEdiPresentation());

        } else if (comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equals("Statut")) {
            if (tfRechercher.getText().equalsIgnoreCase("Actif")) {
                for (int i = 0; i <= a.findByStatut(1).size(); i++) {
                    taResultatsRecherche.setText(((Editor) a.findByStatut(1).get(i)).toString());
                }

            } else if (tfRechercher.getText().equalsIgnoreCase("Inactif")) {
                for (int i = 0; i <= a.findByStatut(2).size(); i++) {
                    taResultatsRecherche.setText(((Editor) a.findByStatut(2).get(i)).toString());
                }
            }
        }
    }//GEN-LAST:event_labelRechercherOnPanelMouseClicked

    private void comboTypeRechercheItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTypeRechercheItemStateChanged
        // TODO add your handling code here:
        if (comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equalsIgnoreCase("Tous")) {
            tfRechercher.setEditable(false);
        } else if (!comboTypeRecherche.getItemAt(comboTypeRecherche.getSelectedIndex()).equalsIgnoreCase("Tous")) {
            tfRechercher.setEditable(true);
        }
    }//GEN-LAST:event_comboTypeRechercheItemStateChanged

    private void labelSupprimer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSupprimer1MouseClicked
        // TODO add your handling code here:
        tfNom.setEditable(true);
        tfStatut.setEditable(true);
        taPresentation.setEditable(true);
    }//GEN-LAST:event_labelSupprimer1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboStatut;
    private javax.swing.JComboBox<String> comboTypeRecherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCréer;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPresentation;
    private javax.swing.JLabel labelRechercher;
    private javax.swing.JLabel labelRechercherOnPanel;
    private javax.swing.JLabel labelSauver1;
    private javax.swing.JLabel labelStatut;
    private javax.swing.JLabel labelSupprimer;
    private javax.swing.JLabel labelSupprimer1;
    private javax.swing.JPanel panelCréer;
    private javax.swing.JPanel panelModif;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRechercher;
    private javax.swing.JPanel panelSauver;
    private javax.swing.JPanel panelSupp;
    private javax.swing.JTextArea taPresentation;
    private javax.swing.JTextArea taResultatsRecherche;
    private javax.swing.JTextField tfNom;
    private javax.swing.JTextField tfRechercher;
    private javax.swing.JTextField tfStatut;
    // End of variables declaration//GEN-END:variables
}
