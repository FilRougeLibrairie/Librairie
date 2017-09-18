/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import PanelOk.SubthemePanel;
import PanelOk.ThemePanel;
import PanelOk.AuthorPanel;
import PanelOk.FormatsPanel;
import PanelOk.KWPanel;
import PanelOk.VatPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Chrys
 */
public class PannelCentralSelection extends javax.swing.JPanel {

    /**
     * Creates new form Panel2
     */
    public PannelCentralSelection() {
        initComponents();

        menuAdmin.setVisible(false);
        menuProduct.setVisible(false);
        menuPurchase.setVisible(false);
        jpPrincipal.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenu = new javax.swing.JPanel();
        menuPurchase = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        bPurchase = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        bClient = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        bShipping = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        bAddress = new javax.swing.JLabel();
        menuProduct = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        bBook = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        bEditor = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        bAutor = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        bPrice = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        bKeyWord = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        bTheme = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        bSubTheme = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        bEvent = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        bFormats = new javax.swing.JLabel();
        menuAdmin = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        bAddEmployee = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        bSearchEmployee = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        bAccess = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        bModerate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBClient = new javax.swing.JButton();
        jBProduct = new javax.swing.JButton();
        jBAdmin = new javax.swing.JButton();
        jBStat = new javax.swing.JButton();
        jpPrincipal = new javax.swing.JPanel();

        setBackground(new java.awt.Color(51, 153, 0));
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(2147483647, 600));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(950, 600));
        setLayout(new java.awt.BorderLayout());

        jpMenu.setBackground(new java.awt.Color(0, 0, 0));
        jpMenu.setMaximumSize(new java.awt.Dimension(150, 800));
        jpMenu.setMinimumSize(new java.awt.Dimension(150, 800));
        jpMenu.setPreferredSize(new java.awt.Dimension(150, 800));
        jpMenu.setLayout(null);

        menuPurchase.setBackground(new java.awt.Color(0, 0, 0));
        menuPurchase.setMaximumSize(new java.awt.Dimension(150, 800));
        menuPurchase.setMinimumSize(new java.awt.Dimension(150, 800));
        menuPurchase.setRequestFocusEnabled(false);

        jPanel7.setMinimumSize(new java.awt.Dimension(50, 30));
        jPanel7.setPreferredSize(new java.awt.Dimension(80, 40));
        jPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel7MouseMoved(evt);
            }
        });

        bPurchase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bPurchase.setText("Commande");
        bPurchase.setAlignmentX(0.5F);
        bPurchase.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bPurchaseMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bPurchaseMouseMoved(evt);
            }
        });
        bPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPurchaseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bPurchase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel8.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel8MouseMoved(evt);
            }
        });

        bClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bClient.setText("Fiche Client");
        bClient.setAlignmentX(0.5F);
        bClient.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bClientMouseMoved(evt);
            }
        });
        bClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bClientMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bClient, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel9.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel9MouseMoved(evt);
            }
        });

        bShipping.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bShipping.setText("Livraison");
        bShipping.setAlignmentX(0.5F);
        bShipping.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bShippingMouseMoved(evt);
            }
        });
        bShipping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bShippingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bShipping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bShipping, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel10.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel10MouseMoved(evt);
            }
        });

        bAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bAddress.setText("Fiche Adresse");
        bAddress.setAlignmentX(0.5F);
        bAddress.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bAddressMouseMoved(evt);
            }
        });
        bAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAddressMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuPurchaseLayout = new javax.swing.GroupLayout(menuPurchase);
        menuPurchase.setLayout(menuPurchaseLayout);
        menuPurchaseLayout.setHorizontalGroup(
            menuPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPurchaseLayout.setVerticalGroup(
            menuPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPurchaseLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );

        jpMenu.add(menuPurchase);
        menuPurchase.setBounds(0, 0, 150, 762);

        menuProduct.setBackground(new java.awt.Color(0, 0, 0));
        menuProduct.setMaximumSize(new java.awt.Dimension(150, 800));
        menuProduct.setMinimumSize(new java.awt.Dimension(150, 800));
        menuProduct.setRequestFocusEnabled(false);

        jPanel11.setMinimumSize(new java.awt.Dimension(50, 30));
        jPanel11.setPreferredSize(new java.awt.Dimension(80, 40));
        jPanel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel11MouseMoved(evt);
            }
        });

        bBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bBook.setText("Livre");
        bBook.setAlignmentX(0.5F);
        bBook.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bBookMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bBookMouseMoved(evt);
            }
        });
        bBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bBook, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel12.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel12MouseMoved(evt);
            }
        });

        bEditor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bEditor.setText("Editeur");
        bEditor.setAlignmentX(0.5F);
        bEditor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bEditorMouseMoved(evt);
            }
        });
        bEditor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bEditor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel13.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel13MouseMoved(evt);
            }
        });
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

        bAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bAutor.setText("Auteur");
        bAutor.setAlignmentX(0.5F);
        bAutor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bAutorMouseMoved(evt);
            }
        });
        bAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAutorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel14.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel14MouseMoved(evt);
            }
        });
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        bPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bPrice.setText("Tva");
        bPrice.setAlignmentX(0.5F);
        bPrice.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bPriceMouseMoved(evt);
            }
        });
        bPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPriceMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel15.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel15MouseMoved(evt);
            }
        });
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        bKeyWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bKeyWord.setText("Mots Clés");
        bKeyWord.setAlignmentX(0.5F);
        bKeyWord.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bKeyWordMouseMoved(evt);
            }
        });
        bKeyWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bKeyWordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bKeyWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bKeyWord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel16.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel16MouseMoved(evt);
            }
        });
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        bTheme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bTheme.setText("Thème");
        bTheme.setAlignmentX(0.5F);
        bTheme.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bThemeMouseMoved(evt);
            }
        });
        bTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bThemeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bTheme, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel17.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel17MouseMoved(evt);
            }
        });
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        bSubTheme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bSubTheme.setText("Sous Thème");
        bSubTheme.setAlignmentX(0.5F);
        bSubTheme.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bSubThemeMouseMoved(evt);
            }
        });
        bSubTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSubThemeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bSubTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bSubTheme, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel18.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel18MouseMoved(evt);
            }
        });

        bEvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bEvent.setText("Evenement");
        bEvent.setAlignmentX(0.5F);
        bEvent.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bEventMouseMoved(evt);
            }
        });
        bEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEventMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bEvent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bEvent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel23.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel23.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel23MouseMoved(evt);
            }
        });
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel23MouseClicked(evt);
            }
        });

        bFormats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bFormats.setText("Formats");
        bFormats.setAlignmentX(0.5F);
        bFormats.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bFormatsMouseMoved(evt);
            }
        });
        bFormats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bFormatsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bFormats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bFormats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuProductLayout = new javax.swing.GroupLayout(menuProduct);
        menuProduct.setLayout(menuProductLayout);
        menuProductLayout.setHorizontalGroup(
            menuProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuProductLayout.setVerticalGroup(
            menuProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuProductLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jpMenu.add(menuProduct);
        menuProduct.setBounds(0, 0, 150, 762);

        menuAdmin.setBackground(new java.awt.Color(0, 0, 0));
        menuAdmin.setMaximumSize(new java.awt.Dimension(150, 800));
        menuAdmin.setMinimumSize(new java.awt.Dimension(150, 800));
        menuAdmin.setRequestFocusEnabled(false);

        jPanel19.setMinimumSize(new java.awt.Dimension(50, 30));
        jPanel19.setPreferredSize(new java.awt.Dimension(80, 40));
        jPanel19.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel19MouseMoved(evt);
            }
        });
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });

        bAddEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bAddEmployee.setText("Ajouter un employé");
        bAddEmployee.setAlignmentX(0.5F);
        bAddEmployee.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bAddEmployeeMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bAddEmployeeMouseMoved(evt);
            }
        });
        bAddEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAddEmployeeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bAddEmployeeMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAddEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel20.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel20.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel20MouseMoved(evt);
            }
        });
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });

        bSearchEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bSearchEmployee.setText("Afficher Employé");
        bSearchEmployee.setAlignmentX(0.5F);
        bSearchEmployee.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bSearchEmployeeMouseMoved(evt);
            }
        });
        bSearchEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSearchEmployeeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bSearchEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bSearchEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel21.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel21MouseMoved(evt);
            }
        });

        bAccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bAccess.setText("Gestion des Accès");
        bAccess.setAlignmentX(0.5F);
        bAccess.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bAccessMouseMoved(evt);
            }
        });
        bAccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAccessMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bAccess, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel22.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel22.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel22MouseMoved(evt);
            }
        });

        bModerate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bModerate.setText("Modération");
        bModerate.setAlignmentX(0.5F);
        bModerate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bModerateMouseMoved(evt);
            }
        });
        bModerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bModerateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bModerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bModerate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuAdminLayout = new javax.swing.GroupLayout(menuAdmin);
        menuAdmin.setLayout(menuAdminLayout);
        menuAdminLayout.setHorizontalGroup(
            menuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuAdminLayout.setVerticalGroup(
            menuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAdminLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );

        jpMenu.add(menuAdmin);
        menuAdmin.setBounds(0, 0, 150, 762);

        add(jpMenu, java.awt.BorderLayout.WEST);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jBClient.setText("CLIENT");
        jBClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBClientMouseClicked(evt);
            }
        });

        jBProduct.setText("EDITION");
        jBProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBProductMouseClicked(evt);
            }
        });
        jBProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProductActionPerformed(evt);
            }
        });

        jBAdmin.setText("ADMINISTRATION");
        jBAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBAdminMouseClicked(evt);
            }
        });

        jBStat.setText("STATISTIQUES");
        jBStat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBStatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jBClient, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBStat, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBClient, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBStat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jpPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        jpPrincipal.setLayout(null);
        add(jpPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseMoved

        resetColor(jPanel7);
        resetColor(jPanel8);
        resetColor(jPanel9);
        setColor(jPanel10);
    }//GEN-LAST:event_jPanel10MouseMoved

    private void bAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddressMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bAddressMouseClicked

    private void bAddressMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddressMouseMoved
        resetColor(jPanel7);
        resetColor(jPanel8);
        resetColor(jPanel9);
        setColor(jPanel10);
    }//GEN-LAST:event_bAddressMouseMoved

    private void jPanel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseMoved

        resetColor(jPanel7);
        resetColor(jPanel8);
        setColor(jPanel9);
        resetColor(jPanel10);
    }//GEN-LAST:event_jPanel9MouseMoved

    private void bShippingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bShippingMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bShippingMouseClicked

    private void bShippingMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bShippingMouseMoved
        // TODO add your han
        resetColor(jPanel7);
        resetColor(jPanel8);
        setColor(jPanel9);
        resetColor(jPanel10);
    }//GEN-LAST:event_bShippingMouseMoved

    private void jPanel8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseMoved

        resetColor(jPanel7);
        setColor(jPanel8);
        resetColor(jPanel9);
        resetColor(jPanel10);
    }//GEN-LAST:event_jPanel8MouseMoved

    private void bClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bClientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bClientMouseClicked

    private void bClientMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bClientMouseMoved

        resetColor(jPanel7);
        setColor(jPanel8);
        resetColor(jPanel9);
        resetColor(jPanel10);
    }//GEN-LAST:event_bClientMouseMoved

    private void jPanel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseMoved

        setColor(jPanel7);
        resetColor(jPanel8);
        resetColor(jPanel9);
        resetColor(jPanel10);

    }//GEN-LAST:event_jPanel7MouseMoved

    private void bPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPurchaseMouseClicked

    }//GEN-LAST:event_bPurchaseMouseClicked

    private void bPurchaseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPurchaseMouseMoved

        setColor(jPanel7);
        resetColor(jPanel8);
        resetColor(jPanel9);
        resetColor(jPanel10);
    }//GEN-LAST:event_bPurchaseMouseMoved

    private void bPurchaseMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPurchaseMouseDragged


    }//GEN-LAST:event_bPurchaseMouseDragged

    private void bBookMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBookMouseDragged
        setColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bBookMouseDragged

    private void bBookMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBookMouseMoved
        setColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bBookMouseMoved

    private void bBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBookMouseClicked


    }//GEN-LAST:event_bBookMouseClicked

    private void jPanel11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseMoved
        setColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel11MouseMoved

    private void bEditorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditorMouseMoved
        resetColor(jPanel11);
        setColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bEditorMouseMoved

    private void bEditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditorMouseClicked


    }//GEN-LAST:event_bEditorMouseClicked


    private void jPanel12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseMoved
        resetColor(jPanel11);
        setColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel12MouseMoved

    private void bAutorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAutorMouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        setColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bAutorMouseMoved

    private void bAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAutorMouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        AuthorPanel addAutor = new AuthorPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addAutor, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_bAutorMouseClicked

    private void jPanel13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        setColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel13MouseMoved

    private void jPanel16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        setColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel16MouseMoved

    private void jPanel14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        setColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel14MouseMoved

    private void jPanel15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        setColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel15MouseMoved

    private void bPriceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPriceMouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        setColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bPriceMouseMoved

    private void bPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPriceMouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        VatPanel addVat = new VatPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addVat, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_bPriceMouseClicked

    private void bKeyWordMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKeyWordMouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        setColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bKeyWordMouseMoved


    private void bKeyWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKeyWordMouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        KWPanel addKW = new KWPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addKW, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_bKeyWordMouseClicked

    private void jPanel18MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        setColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel18MouseMoved

    private void jPanel17MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        setColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel17MouseMoved

    private void bThemeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bThemeMouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        setColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bThemeMouseMoved

    private void bThemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bThemeMouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        ThemePanel theme = new ThemePanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(theme, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
        
        
        
    }//GEN-LAST:event_bThemeMouseClicked

    private void bSubThemeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSubThemeMouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        setColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bSubThemeMouseMoved

    private void bSubThemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSubThemeMouseClicked

        
        jpPrincipal.removeAll();
        jpPrincipal.validate();
        SubthemePanel subtheme = new SubthemePanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(subtheme, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();



        
    }//GEN-LAST:event_bSubThemeMouseClicked

    private void bEventMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEventMouseMoved
        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        setColor(jPanel18);
        resetColor(jPanel23);
    }//GEN-LAST:event_bEventMouseMoved

    private void bEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEventMouseClicked


    }//GEN-LAST:event_bEventMouseClicked

    private void bAddEmployeeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseDragged

    }//GEN-LAST:event_bAddEmployeeMouseDragged

    private void bAddEmployeeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseMoved

        setColor(jPanel19);
        resetColor(jPanel20);
        resetColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_bAddEmployeeMouseMoved

    private void bAddEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseClicked

//
//        jpPrincipal.removeAll();
//        jpPrincipal.validate();
//        AddEmployee addEmployee=new AddEmployee();
//        jpPrincipal.setLayout(new BorderLayout());
//        jpPrincipal.add(addEmployee,BorderLayout.NORTH);
//        jpPrincipal.setVisible(true);
//        jpPrincipal.revalidate();

    }//GEN-LAST:event_bAddEmployeeMouseClicked

    private void jPanel19MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseMoved
        setColor(jPanel19);
        resetColor(jPanel20);
        resetColor(jPanel21);
        resetColor(jPanel22);

    }//GEN-LAST:event_jPanel19MouseMoved

    private void bSearchEmployeeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSearchEmployeeMouseMoved

        resetColor(jPanel19);
        setColor(jPanel20);
        resetColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_bSearchEmployeeMouseMoved

    private void bSearchEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSearchEmployeeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bSearchEmployeeMouseClicked

    private void jPanel20MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseMoved
        resetColor(jPanel19);
        setColor(jPanel20);
        resetColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_jPanel20MouseMoved

    private void bAccessMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAccessMouseMoved
        // TODO add your handling code here:

        resetColor(jPanel19);
        resetColor(jPanel20);
        setColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_bAccessMouseMoved

    private void bAccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAccessMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bAccessMouseClicked

    private void jPanel21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseMoved
        resetColor(jPanel19);
        resetColor(jPanel20);
        setColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_jPanel21MouseMoved

    private void jPanel22MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseMoved
        resetColor(jPanel19);
        resetColor(jPanel20);
        resetColor(jPanel21);
        setColor(jPanel22);
    }//GEN-LAST:event_jPanel22MouseMoved

    private void bAddEmployeeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_bAddEmployeeMouseReleased

    private void bModerateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bModerateMouseMoved

        resetColor(jPanel19);
        resetColor(jPanel20);
        resetColor(jPanel21);
        setColor(jPanel22);// TODO add your handling code here:
    }//GEN-LAST:event_bModerateMouseMoved

    private void bModerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bModerateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bModerateMouseClicked

    private void jBProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProductActionPerformed


    }//GEN-LAST:event_jBProductActionPerformed

    private void jBClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBClientMouseClicked
        jpPrincipal.setVisible(false);
        menuAdmin.setVisible(false);
        menuProduct.setVisible(false);
        menuPurchase.setVisible(true);

    }//GEN-LAST:event_jBClientMouseClicked

    private void jBProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProductMouseClicked
        jpPrincipal.setVisible(false);
        menuAdmin.setVisible(false);
        menuProduct.setVisible(true);
        menuPurchase.setVisible(false);
    }//GEN-LAST:event_jBProductMouseClicked

    private void jBStatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBStatMouseClicked
        jpPrincipal.setVisible(false);
        menuAdmin.setVisible(false);
        menuProduct.setVisible(false);
        menuPurchase.setVisible(false);
    }//GEN-LAST:event_jBStatMouseClicked

    private void jBAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAdminMouseClicked
        jpPrincipal.setVisible(false);
        menuAdmin.setVisible(true);
        menuProduct.setVisible(false);
        menuPurchase.setVisible(false);
    }//GEN-LAST:event_jBAdminMouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        AuthorPanel addAutor = new AuthorPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addAutor, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        KWPanel addKW = new KWPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addKW, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        jpPrincipal.setBackground(Color.black);
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked

//        
//         jpPrincipal.removeAll();
//        jpPrincipal.validate();
//        AddEmployee addEmployee=new AddEmployee();
//        jpPrincipal.setLayout(new BorderLayout());
//        jpPrincipal.add(addEmployee,BorderLayout.NORTH);
//        jpPrincipal.setVisible(true);
//        jpPrincipal.revalidate();
//        

    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel23MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseMoved

        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        setColor(jPanel23);


    }//GEN-LAST:event_jPanel23MouseMoved

    private void bFormatsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFormatsMouseMoved

        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        setColor(jPanel23);


    }//GEN-LAST:event_bFormatsMouseMoved

    private void bFormatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFormatsMouseClicked
        // TODO add your handling code here:

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        FormatsPanel addKW = new FormatsPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addKW, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
    }//GEN-LAST:event_bFormatsMouseClicked

    private void jPanel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        FormatsPanel addKW = new FormatsPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addKW, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();

// TODO add your handling code here:
    }//GEN-LAST:event_jPanel23MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        jpPrincipal.removeAll();
        jpPrincipal.validate();
        VatPanel addVat = new VatPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addVat, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        jpPrincipal.removeAll();
        jpPrincipal.validate();
        ThemePanel theme = new ThemePanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(theme, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
        

    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        SubthemePanel subtheme = new SubthemePanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(subtheme, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_jPanel17MouseClicked

    void setColor(JPanel panel) {
        panel.setBackground(new Color(102, 102, 102));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(204, 204, 204));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bAccess;
    private javax.swing.JLabel bAddEmployee;
    private javax.swing.JLabel bAddress;
    private javax.swing.JLabel bAutor;
    private javax.swing.JLabel bBook;
    private javax.swing.JLabel bClient;
    private javax.swing.JLabel bEditor;
    private javax.swing.JLabel bEvent;
    private javax.swing.JLabel bFormats;
    private javax.swing.JLabel bKeyWord;
    private javax.swing.JLabel bModerate;
    private javax.swing.JLabel bPrice;
    private javax.swing.JLabel bPurchase;
    private javax.swing.JLabel bSearchEmployee;
    private javax.swing.JLabel bShipping;
    private javax.swing.JLabel bSubTheme;
    private javax.swing.JLabel bTheme;
    private javax.swing.JButton jBAdmin;
    private javax.swing.JButton jBClient;
    private javax.swing.JButton jBProduct;
    private javax.swing.JButton jBStat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel menuAdmin;
    private javax.swing.JPanel menuProduct;
    private javax.swing.JPanel menuPurchase;
    // End of variables declaration//GEN-END:variables
}
