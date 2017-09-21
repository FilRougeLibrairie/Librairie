
package PanelOk;



public class ThemePanel extends javax.swing.JPanel {

   
    public ThemePanel() {
        initComponents();
        jpPrinc.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        menuChoose = new javax.swing.JPanel();
        jRAdd = new javax.swing.JRadioButton();
        jRUpdate = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jpPrinc = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(0, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        menuChoose.setBackground(new java.awt.Color(255, 255, 255));
        menuChoose.setMinimumSize(new java.awt.Dimension(200, 200));

        buttonGroup1.add(jRAdd);
        jRAdd.setText("Ajouter");
        jRAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRAddActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRUpdate);
        jRUpdate.setText("Modifier");
        jRUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRUpdateActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Veuillez  choisir une option:");
        jLabel1.setAlignmentX(0.5F);

        javax.swing.GroupLayout menuChooseLayout = new javax.swing.GroupLayout(menuChoose);
        menuChoose.setLayout(menuChooseLayout);
        menuChooseLayout.setHorizontalGroup(
            menuChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuChooseLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jRAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(jRUpdate)
                .addGap(62, 62, 62))
            .addGroup(menuChooseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menuChooseLayout.setVerticalGroup(
            menuChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuChooseLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRAdd)
                    .addComponent(jRUpdate))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpPrinc.setBackground(new java.awt.Color(255, 255, 255));
        jpPrinc.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(menuChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpPrinc, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPrinc, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jRUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRUpdateActionPerformed

        if (jRUpdate.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.add(new ThemeUpdate());
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }

    }//GEN-LAST:event_jRUpdateActionPerformed

    private void jRAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRAddActionPerformed

        if (jRAdd.isSelected() == true) {
            jpPrinc.removeAll();
            jpPrinc.add(new ThemeAdd());
            jpPrinc.revalidate();
            jpPrinc.setVisible(true);
        }

    }//GEN-LAST:event_jRAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRAdd;
    private javax.swing.JRadioButton jRUpdate;
    private javax.swing.JPanel jpPrinc;
    private javax.swing.JPanel menuChoose;
    // End of variables declaration//GEN-END:variables
}
