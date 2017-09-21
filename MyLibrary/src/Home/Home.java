/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import ClassObjet.Employee;
import exceptions.CryptoException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.JFMain;
import utils.Crypto;


public class Home extends javax.swing.JFrame {

    
    Employee loggedEmp;
    Header panel1;
    PannelCentralSelection panel2;
    

//    JPCustomer jpc;

    public Home() throws IOException {
        initComponents();
        panel1 = new Header();
        panel2 = new PannelCentralSelection();
        
        // Ajouter le jDeskPrincipal 
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.weightx = 1;
        gbc1.weighty = 1;
        jDeskPrincipal.setVisible(true);
        this.add(jDeskPrincipal, gbc1);

 
        // ELEMENTS INTEGRES QUI MARCHENT loGO+ PAGE principale
        jDeskPrincipal.setLayout(new BorderLayout());
        jDeskPrincipal.add(panel1,BorderLayout.NORTH);   
        jDeskPrincipal.add(panel2,BorderLayout.CENTER);
        
        

        loggedEmp = new Employee();
        loggedEmp.setEmpFirstName("Camille");
        loggedEmp.setEmpLastName("Vasseur");
        loggedEmp.setEmpLogin("1");
        loggedEmp.setEmpSalt("k71nhc5h933kblk4oaouihdhh6");
        loggedEmp.setEmpPassword("32D601355049CDBC0E69DA955DACBC271D1A19999043ED1FAAD09F211E433E0917195DF7EC8A09D1B6C223875036CC11A332178B0E97FDEE28AC982938DE96B3");

        /////// BYPASS CREDENTIALS
      ///firstRun();
      jPanelCredentials.setVisible(false);
        initWorkSpace();
        /////// BYPASS CREDENTIALS
      
      test();
      
    }

    
    
    
    private void test(){
        
        if (panel1.getjPanelGeneralInfos().isVisible()==false){
            firstRun();
        }
    
    }
    
    private void firstRun() {
        
        
        jPanelCredentials.setVisible(true);
        panel1.setVisible(false);
        panel2.setVisible(false);
        jLabelWrongCredentials.setVisible(false);
        
        
    }

    
    

    private void requestEmployeeCredentials() throws NoSuchAlgorithmException, CryptoException {

        String inputUsername = jtfUsername.getText();
        char[] inputPassChar = jPasswordField.getPassword();
        String inputPassStr = new String(inputPassChar);
        String inputPass = null;

       
        try {
            inputPass = Crypto.hashPassword(loggedEmp.getEmpSalt(), inputPassStr);

        } catch (CryptoException ex) {
            Logger.getLogger(JFMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        if (!inputUsername.equalsIgnoreCase(loggedEmp.getEmpLogin()) || !inputPass.equalsIgnoreCase(loggedEmp.getEmpPassword())) {
            jLabelWrongCredentials.setVisible(true);
        } else {
            initWorkSpace();
        }
    }

    private void initWorkSpace() {
        clearCredentials();
        initJpanelGeneralInfos();
        initjTabbedGeneral();
    }

    private void clearCredentials() {
        jPanelCredentials.setVisible(false);
        jLabelWrongCredentials.setVisible(false);
        jtfUsername.setText("");
        jPasswordField.setText("");
    }

    private void initJpanelGeneralInfos() {
        
        panel1.getJlLoggedEmpFirstName().setText(loggedEmp.getEmpFirstName());
        panel1.getJlLoggedEmpFirstName().setBackground(Color.white);
        panel1.getJlLoggedEmpLastName().setText(loggedEmp.getEmpLastName());
        panel1.getJlLoggedEmpLastName().setBackground(Color.white);
        panel1.setVisible(true);

    }

    private void initjTabbedGeneral() {
        panel2.setVisible(true);
       
        
        
    }

    
    
   
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDeskPrincipal = new javax.swing.JDesktopPane();
        jPanelCredentials = new javax.swing.JPanel();
        jLabelLibraryName = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelWrongCredentials = new javax.swing.JLabel();
        jButtonConnexion = new javax.swing.JButton();
        jLabelTeamIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jDeskPrincipal.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        jDeskPrincipal.setMaximumSize(new java.awt.Dimension(2147483647, 700));
        jDeskPrincipal.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jDeskPrincipal, gridBagConstraints);

        jPanelCredentials.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelLibraryName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLibraryName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLibraryName.setText("MyLibrary Management Software");

        jLabelUsername.setText("Username");

        jtfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsernameActionPerformed(evt);
            }
        });

        jLabelPassword.setText("Password");

        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
        });
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyReleased(evt);
            }
        });

        jLabelWrongCredentials.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabelWrongCredentials.setForeground(new java.awt.Color(255, 0, 0));
        jLabelWrongCredentials.setText("Wrong username or password");

        jButtonConnexion.setText("Connexion");
        jButtonConnexion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCredentialsLayout = new javax.swing.GroupLayout(jPanelCredentials);
        jPanelCredentials.setLayout(jPanelCredentialsLayout);
        jPanelCredentialsLayout.setHorizontalGroup(
            jPanelCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCredentialsLayout.createSequentialGroup()
                .addGroup(jPanelCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCredentialsLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanelCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUsername)
                            .addComponent(jLabelPassword)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonConnexion)
                            .addComponent(jLabelWrongCredentials))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTeamIcon))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCredentialsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLibraryName, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelCredentialsLayout.setVerticalGroup(
            jPanelCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCredentialsLayout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(jLabelTeamIcon)
                .addContainerGap())
            .addGroup(jPanelCredentialsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLibraryName, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWrongCredentials)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonConnexion)
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanelCredentials, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsernameActionPerformed

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        jPasswordField.setText("");
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                this.requestEmployeeCredentials();

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(JFMain.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (CryptoException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jPasswordFieldKeyReleased

    private void jButtonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnexionActionPerformed
        try {
            this.requestEmployeeCredentials();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JFMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (CryptoException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConnexionActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Home.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnexion;
    private javax.swing.JDesktopPane jDeskPrincipal;
    private javax.swing.JLabel jLabelLibraryName;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTeamIcon;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelWrongCredentials;
    private javax.swing.JPanel jPanelCredentials;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
