
package Home;

import SQLS.ReviewDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.EventListenerList;

public class Header extends javax.swing.JPanel {

    Timer timer;

    private final int REVIEWS_PENDING_STATUS = 2;

    public Header() throws IOException {
        initComponents();
        findPendingReviews();
        timer = createTimer();
        timer.start();

    }

    private Timer createTimer() {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                findPendingReviews();
            }
        };
        return new Timer(1000*60* 2, action);
    }

    private void findPendingReviews() {
        int pendingReviewsTomoderate = 0;
        ReviewDAO reviewDAO = new ReviewDAO();
        pendingReviewsTomoderate = reviewDAO.countReviewsByStatus(REVIEWS_PENDING_STATUS);
        JLPendingReviews.setText(pendingReviewsTomoderate + " avis en attente de modération");

    }

    public JLabel getJLPendingReviews() {
        return JLPendingReviews;
    }

    public void setJLPendingReviews(JLabel JLPendingReviews) {
        this.JLPendingReviews = JLPendingReviews;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JPanel getjPanelGeneralInfos() {
        return jPanelGeneralInfos;
    }

    public void setjPanelGeneralInfos(JPanel jPanelGeneralInfos) {
        this.jPanelGeneralInfos = jPanelGeneralInfos;
    }

    public JLabel getJlGenInfoDisconnect() {
        return jlGenInfoDisconnect;
    }

    public void setJlGenInfoDisconnect(JLabel jlGenInfoDisconnect) {
        this.jlGenInfoDisconnect = jlGenInfoDisconnect;
    }

    public JLabel getJlLoggedEmpFirstName() {
        return jlLoggedEmpFirstName;
    }

    public void setJlLoggedEmpFirstName(JLabel jlLoggedEmpFirstName) {
        this.jlLoggedEmpFirstName = jlLoggedEmpFirstName;
    }

    public JLabel getJlLoggedEmpLastName() {
        return jlLoggedEmpLastName;
    }

    public void setJlLoggedEmpLastName(JLabel jlLoggedEmpLastName) {
        this.jlLoggedEmpLastName = jlLoggedEmpLastName;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGeneralInfos = new javax.swing.JPanel();
        jlLoggedEmpFirstName = new javax.swing.JLabel();
        jlLoggedEmpLastName = new javax.swing.JLabel();
        jlGenInfoDisconnect = new javax.swing.JLabel();
        JLPendingReviews = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1000, 200));
        setMinimumSize(new java.awt.Dimension(800, 100));
        setPreferredSize(new java.awt.Dimension(200, 100));
        setRequestFocusEnabled(false);
        setLayout(null);

        jPanelGeneralInfos.setBackground(new java.awt.Color(0, 0, 0));

        jlLoggedEmpFirstName.setBackground(new java.awt.Color(0, 0, 0));
        jlLoggedEmpFirstName.setForeground(new java.awt.Color(255, 255, 255));
        jlLoggedEmpFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlLoggedEmpFirstName.setText("Employee First Name");

        jlLoggedEmpLastName.setBackground(new java.awt.Color(0, 0, 0));
        jlLoggedEmpLastName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlLoggedEmpLastName.setForeground(new java.awt.Color(255, 255, 255));
        jlLoggedEmpLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlLoggedEmpLastName.setText("Employee Last Name");

        jlGenInfoDisconnect.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlGenInfoDisconnect.setForeground(new java.awt.Color(255, 0, 0));
        jlGenInfoDisconnect.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlGenInfoDisconnect.setText("Disconnect");
        jlGenInfoDisconnect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlGenInfoDisconnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlGenInfoDisconnectMouseReleased(evt);
            }
        });

        JLPendingReviews.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JLPendingReviews.setForeground(new java.awt.Color(255, 102, 0));
        JLPendingReviews.setText("Fail to retrieve infos");
        JLPendingReviews.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JLPendingReviews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JLPendingReviewsMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelGeneralInfosLayout = new javax.swing.GroupLayout(jPanelGeneralInfos);
        jPanelGeneralInfos.setLayout(jPanelGeneralInfosLayout);
        jPanelGeneralInfosLayout.setHorizontalGroup(
            jPanelGeneralInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralInfosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGeneralInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlGenInfoDisconnect)
                    .addComponent(jlLoggedEmpLastName)
                    .addGroup(jPanelGeneralInfosLayout.createSequentialGroup()
                        .addComponent(JLPendingReviews)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jlLoggedEmpFirstName)))
                .addGap(20, 20, 20))
        );
        jPanelGeneralInfosLayout.setVerticalGroup(
            jPanelGeneralInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralInfosLayout.createSequentialGroup()
                .addGroup(jPanelGeneralInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeneralInfosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlLoggedEmpFirstName))
                    .addGroup(jPanelGeneralInfosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLPendingReviews)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLoggedEmpLastName)
                .addGap(12, 12, 12)
                .addComponent(jlGenInfoDisconnect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanelGeneralInfos);
        jPanelGeneralInfos.setBounds(670, 20, 312, 80);

        jLabel1.setAlignmentX(0.5F);
        jLabel1.setMaximumSize(new java.awt.Dimension(300, 100));
        jLabel1.setMinimumSize(new java.awt.Dimension(300, 100));
        add(jLabel1);
        jLabel1.setBounds(20, 20, 363, 77);
    }// </editor-fold>//GEN-END:initComponents

    private void jlGenInfoDisconnectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGenInfoDisconnectMouseReleased
        try {
            disconnectFromWorkSpace();
        } catch (IOException ex) {
            Logger.getLogger(Header.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlGenInfoDisconnectMouseReleased

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }


    private void JLPendingReviewsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLPendingReviewsMouseReleased
        //jTabbedPane6.setSelectedIndex(2);
//        jTabbedPaneGeneral.setSelectedComponent(jpReviews);
    }//GEN-LAST:event_JLPendingReviewsMouseReleased

    private void disconnectFromWorkSpace() throws IOException {

        jlLoggedEmpFirstName.setText("");
        jlLoggedEmpLastName.setText("");
        jPanelGeneralInfos.setVisible(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLPendingReviews;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelGeneralInfos;
    private javax.swing.JLabel jlGenInfoDisconnect;
    private javax.swing.JLabel jlLoggedEmpFirstName;
    private javax.swing.JLabel jlLoggedEmpLastName;
    // End of variables declaration//GEN-END:variables
}
