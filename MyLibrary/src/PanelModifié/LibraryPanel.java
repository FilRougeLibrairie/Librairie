package PanelModifié;

import ClassObjet.MyLibrary;
import SQLS.MyLibraryDAO;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.InputsControls;

public class LibraryPanel extends javax.swing.JPanel  {
    
    
    
    
    
    
    
    

    Vector<MyLibrary> myLibraryList;
    private JFileChooser jfc = new JFileChooser();
    private JFileChooser jfc1 = new JFileChooser();
    MyLibraryDAO libDAO = new MyLibraryDAO();
    JOptionPane jop1 = new JOptionPane();
    
    public LibraryPanel() {
        initComponents();
        jTId.setVisible(false);
        init();
    }

    public void init() {

        myLibraryList = new Vector<MyLibrary>();

        
        myLibraryList = libDAO.findAll();
        MyLibrary p = new MyLibrary();
        for (MyLibrary lib : myLibraryList) {
            p = new MyLibrary(lib.getMyLibId(), lib.getMyLibName(), lib.getMyLibLogo(), lib.getMyLibEmail(), lib.getMyLibPhone(), lib.getMyLibSiret(), lib.getMyLibCGU(), lib.getMyLibAddNumber(), lib.getMyLibAddStreetName(), lib.getMyLibAddComplement(), lib.getMyLibAddZipCode(), lib.getMyLibAddCity());

        }

        jTName.setText(p.getMyLibName());
        jTLink.setText(p.getMyLibLogo());
        jTEmail.setText(p.getMyLibEmail());
        jTPhone.setText(p.getMyLibPhone());
        jTLinkCGU.setText(p.getMyLibCGU());
        jTSiret.setText(p.getMyLibSiret());
        jTNum.setText(p.getMyLibAddNumber());
        jTNameStreet.setText(p.getMyLibAddStreetName());
        jTComplement.setText(p.getMyLibAddComplement());
        jTZip.setText(p.getMyLibAddZipCode());
        jTCity.setText(p.getMyLibAddCity());
        jTId.setText(String.valueOf(p.getMyLibId()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jTName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTLink = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTPhone = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        btnSave = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTNum = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTNameStreet = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTComplement = new javax.swing.JTextField();
        jTZip = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTCity = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTLinkCGU = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTSiret = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTId = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Nom de l'enseigne");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));
        add(jTName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 179, -1));

        jLabel9.setText("Logo");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        add(jTLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 179, -1));

        jLabel10.setText("Email");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        add(jTEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 179, -1));

        jLabel14.setText("Telephone");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        add(jTPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 179, -1));

        jPanel22.setBackground(new java.awt.Color(51, 102, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("VALIDER");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 105, 35));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresse"));

        jLabel16.setText("Numéro de la voie");

        jLabel11.setText("Voie");

        jLabel13.setText("Complement");

        jLabel15.setText("Code Postal");

        jLabel17.setText("Ville");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTCity, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTZip, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTNameStreet)
                                    .addComponent(jTComplement, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNum, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTNameStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jTZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel18.setText("Conditions Générales");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
        add(jTLinkCGU, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 179, -1));

        jLabel19.setText("Siret");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));
        add(jTSiret, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 179, -1));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setText("Lien");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 20));
        add(jTId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        jButton3.setBackground(new java.awt.Color(51, 102, 255));
        jButton3.setText("Lien");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 229, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
       
        
        
        MyLibrary lib = new MyLibrary();
      
        
       
        
        lib.setMyLibAddCity(jTCity.getText());
        lib.setMyLibAddComplement(jTComplement.getText());
        lib.setMyLibAddNumber(jTNum.getText());
        lib.setMyLibAddStreetName(jTNameStreet.getText());
        lib.setMyLibAddZipCode(jTZip.getText());
        lib.setMyLibCGU(jTLinkCGU.getText());
        lib.setMyLibEmail(jTEmail.getText());
        lib.setMyLibId(Integer.valueOf(jTId.getText()));
        lib.setMyLibLogo(jTLink.getText());
        lib.setMyLibName(jTName.getText());
        lib.setMyLibPhone(jTPhone.getText());
        lib.setMyLibSiret(jTSiret.getText());
        libDAO.update(lib);
        jop1.showMessageDialog(null, "Les informations ont été modifiées avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
        init();
        
        
        
        

    }//GEN-LAST:event_btnSaveMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

            int returnval = jfc1.showOpenDialog(jButton2);
            if(returnval==JFileChooser.APPROVE_OPTION){
            //recuperation du chemin
            jTLink.setText(jfc1.getSelectedFile().getAbsolutePath());
            }
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
            int returnval = jfc.showOpenDialog(jButton2);
            if(returnval==JFileChooser.APPROVE_OPTION){
            //recuperation du chemin
            jTLinkCGU.setText(jfc.getSelectedFile().getAbsolutePath());
            }
    }//GEN-LAST:event_jButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSave;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JTextField jTCity;
    private javax.swing.JTextField jTComplement;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTLink;
    private javax.swing.JTextField jTLinkCGU;
    private javax.swing.JTextField jTName;
    private javax.swing.JTextField jTNameStreet;
    private javax.swing.JTextField jTNum;
    private javax.swing.JTextField jTPhone;
    private javax.swing.JTextField jTSiret;
    private javax.swing.JTextField jTZip;
    // End of variables declaration//GEN-END:variables
}
