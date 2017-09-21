
package Home;

import PanelOk.AccessPanel;

import PanelOk.OfferPanel;
import PanelOk.BookLanguagePanel;
import PanelOk.SubthemePanel;
import PanelOk.ThemePanel;
import PanelOk.AuthorPanel;
import PanelOk.FormatPanel;
import PanelOk.KeywordsPanel;
import PanelOk.VatPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
//import ui.JFBook2;
import ui.jfEditor.JFEditor;
//import PanelEnCoursChrys.JFReview;
import ui.jfCustomer.CustomerPanel;

import ui.jfCustomer.JFCustomer;
//import ui.jfEmployee.JFEmployee;
import ui.jfPurchase.JFPurchase;


public class PannelCentralSelection extends javax.swing.JPanel {
CustomerPanel cus = new CustomerPanel();
    
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
        jPanel24 = new javax.swing.JPanel();
        bFormats1 = new javax.swing.JLabel();
        menuAdmin = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        bAddEmployee = new javax.swing.JLabel();
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
        jInternalFrame1 = new javax.swing.JInternalFrame();

        setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
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
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
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
            .addComponent(bClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bClient, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuPurchaseLayout = new javax.swing.GroupLayout(menuPurchase);
        menuPurchase.setLayout(menuPurchaseLayout);
        menuPurchaseLayout.setHorizontalGroup(
            menuPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPurchaseLayout.setVerticalGroup(
            menuPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPurchaseLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
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
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
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
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
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
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
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
        bFormats.setText("Format");
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

        jPanel24.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel24.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel24MouseMoved(evt);
            }
        });
        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel24MouseClicked(evt);
            }
        });

        bFormats1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bFormats1.setText("Langue");
        bFormats1.setAlignmentX(0.5F);
        bFormats1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bFormats1MouseMoved(evt);
            }
        });
        bFormats1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bFormats1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bFormats1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bFormats1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
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
        bAddEmployee.setText("Employe");
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

        jPanel21.setMinimumSize(new java.awt.Dimension(80, 40));
        jPanel21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel21MouseMoved(evt);
            }
        });
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
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
            .addComponent(bAccess, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
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
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
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
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuAdminLayout.setVerticalGroup(
            menuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAdminLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
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

        jpPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpPrincipal.setPreferredSize(new java.awt.Dimension(800, 900));
        jpPrincipal.setLayout(new java.awt.BorderLayout());

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1000, 700));
        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpPrincipal.add(jInternalFrame1, java.awt.BorderLayout.CENTER);

        add(jpPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseMoved

        resetColor(jPanel7);
        setColor(jPanel8);
        
    }//GEN-LAST:event_jPanel8MouseMoved

    private void bClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bClientMouseClicked

      
             
        
       jpPrincipal.removeAll();
       jpPrincipal.validate();
       jpPrincipal.add(jInternalFrame1);
       JFCustomer cus = new JFCustomer();
        jInternalFrame1.setContentPane(cus.getContentPane());
        jInternalFrame1.setVisible(true);
       jpPrincipal.setVisible(true);
       jpPrincipal.revalidate();
        
        

     
    }//GEN-LAST:event_bClientMouseClicked

    private void bClientMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bClientMouseMoved

        resetColor(jPanel7);
        setColor(jPanel8);
        
    }//GEN-LAST:event_bClientMouseMoved

    private void jPanel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseMoved

        setColor(jPanel7);
        resetColor(jPanel8);
       

    }//GEN-LAST:event_jPanel7MouseMoved

    private void bPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPurchaseMouseClicked

       jpPrincipal.removeAll();
       jpPrincipal.validate();
       jpPrincipal.add(jInternalFrame1);
       JFPurchase pur = new JFPurchase();
        jInternalFrame1.setContentPane(pur.getContentPane());
        jInternalFrame1.setVisible(true);
       jpPrincipal.setVisible(true);
       jpPrincipal.revalidate();
       
       
    }//GEN-LAST:event_bPurchaseMouseClicked

    private void bPurchaseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPurchaseMouseMoved

        setColor(jPanel7);
        resetColor(jPanel8);
        
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
    }//GEN-LAST:event_bBookMouseMoved

    private void bBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBookMouseClicked

        
//       jpPrincipal.removeAll();
//       jpPrincipal.validate();
//       jpPrincipal.add(jInternalFrame1);
//       JFBook2 boo = new JFBook2();
//        jInternalFrame1.setContentPane(boo.getContentPane());
//        jInternalFrame1.setVisible(true);
//       jpPrincipal.setVisible(true);
//       jpPrincipal.revalidate();
        
        

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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
    }//GEN-LAST:event_bEditorMouseMoved

    private void bEditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditorMouseClicked

        
       jpPrincipal.removeAll();
       jpPrincipal.validate();
       jpPrincipal.add(jInternalFrame1);
       JFEditor edit = new JFEditor();
        jInternalFrame1.setContentPane(edit.getContentPane());
        jInternalFrame1.setVisible(true);
       jpPrincipal.setVisible(true);
       jpPrincipal.revalidate();

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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
    }//GEN-LAST:event_bKeyWordMouseMoved


    private void bKeyWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKeyWordMouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        KeywordsPanel addKW = new KeywordsPanel();
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
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
        resetColor(jPanel24);
    }//GEN-LAST:event_bEventMouseMoved

    private void bEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEventMouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        OfferPanel offer = new OfferPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(offer, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();

    }//GEN-LAST:event_bEventMouseClicked

    private void bAddEmployeeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseDragged

    }//GEN-LAST:event_bAddEmployeeMouseDragged

    private void bAddEmployeeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseMoved

        setColor(jPanel19);
        
        resetColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_bAddEmployeeMouseMoved

    private void bAddEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseClicked

        
//        jpPrincipal.removeAll();
//       jpPrincipal.validate();
//       jpPrincipal.add(jInternalFrame1);
//       JFEmployee emp = new JFEmployee();
//        jInternalFrame1.setContentPane(emp.getContentPane());
//        jInternalFrame1.setVisible(true);
//       jpPrincipal.setVisible(true);
//       jpPrincipal.revalidate();

    }//GEN-LAST:event_bAddEmployeeMouseClicked

    private void jPanel19MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseMoved
        setColor(jPanel19);
        resetColor(jPanel21);
        resetColor(jPanel22);

    }//GEN-LAST:event_jPanel19MouseMoved

    private void bAccessMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAccessMouseMoved
        // TODO add your handling code here:

        resetColor(jPanel19);
        setColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_bAccessMouseMoved

    private void bAccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAccessMouseClicked
        
        jpPrincipal.removeAll();
        jpPrincipal.validate();
        AccessPanel acc = new AccessPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(acc, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
        
       
    }//GEN-LAST:event_bAccessMouseClicked

    private void jPanel21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseMoved
        resetColor(jPanel19);
        setColor(jPanel21);
        resetColor(jPanel22);
    }//GEN-LAST:event_jPanel21MouseMoved

    private void jPanel22MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseMoved
        resetColor(jPanel19);
        resetColor(jPanel21);
        setColor(jPanel22);
    }//GEN-LAST:event_jPanel22MouseMoved

    private void bAddEmployeeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddEmployeeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_bAddEmployeeMouseReleased

    private void bModerateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bModerateMouseMoved

        resetColor(jPanel19);
        resetColor(jPanel21);
        setColor(jPanel22);
    }//GEN-LAST:event_bModerateMouseMoved

    private void bModerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bModerateMouseClicked
        
//       jpPrincipal.removeAll();
//       jpPrincipal.validate();
//       jpPrincipal.add(jInternalFrame1);
//       JFReview rev = new JFReview();
//        jInternalFrame1.setContentPane(rev.getContentPane());
//        jInternalFrame1.setVisible(true);
//       jpPrincipal.setVisible(true);
//       jpPrincipal.revalidate();
       
       
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
        KeywordsPanel addKW = new KeywordsPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addKW, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked

//        jpPrincipal.removeAll();
//       jpPrincipal.validate();
//       jpPrincipal.add(jInternalFrame1);
//       JFEmployee emp = new JFEmployee();
//        jInternalFrame1.setContentPane(emp.getContentPane());
//        jInternalFrame1.setVisible(true);
//       jpPrincipal.setVisible(true);
//       jpPrincipal.revalidate();
   

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
        resetColor(jPanel24);


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
        resetColor(jPanel24);


    }//GEN-LAST:event_bFormatsMouseMoved

    private void bFormatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFormatsMouseClicked
        // TODO add your handling code here:

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        FormatPanel addKW = new FormatPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(addKW, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
    }//GEN-LAST:event_bFormatsMouseClicked

    private void jPanel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        FormatPanel addKW = new FormatPanel();
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

    private void jPanel24MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel24MouseMoved

    private void jPanel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        BookLanguagePanel language = new BookLanguagePanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(language, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();


    }//GEN-LAST:event_jPanel24MouseClicked

    private void bFormats1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFormats1MouseMoved

        resetColor(jPanel11);
        resetColor(jPanel12);
        resetColor(jPanel13);
        resetColor(jPanel14);
        resetColor(jPanel15);
        resetColor(jPanel16);
        resetColor(jPanel17);
        resetColor(jPanel18);
        resetColor(jPanel23);
        setColor(jPanel24);


    }//GEN-LAST:event_bFormats1MouseMoved

    private void bFormats1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFormats1MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        BookLanguagePanel language = new BookLanguagePanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(language, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
    }//GEN-LAST:event_bFormats1MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        OfferPanel offer = new OfferPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(offer, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();

// TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        
       
            
       jpPrincipal.removeAll();
       jpPrincipal.validate();
       jpPrincipal.add(jInternalFrame1);
       JFCustomer cus = new JFCustomer();
        jInternalFrame1.setContentPane(cus.getContentPane());
        jInternalFrame1.setVisible(true);
       jpPrincipal.setVisible(true);
       jpPrincipal.revalidate();
        
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked

        
         jpPrincipal.removeAll();
       jpPrincipal.validate();
       jpPrincipal.add(jInternalFrame1);
       JFEditor edit = new JFEditor();
        jInternalFrame1.setContentPane(edit.getContentPane());
        jInternalFrame1.setVisible(true);
       jpPrincipal.setVisible(true);
       jpPrincipal.revalidate();
        




    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked

//        jpPrincipal.removeAll();
//       jpPrincipal.validate();
//       jpPrincipal.add(jInternalFrame1);
//       JFBook2 boo = new JFBook2();
//        jInternalFrame1.setContentPane(boo.getContentPane());
//        jInternalFrame1.setVisible(true);
//       jpPrincipal.setVisible(true);
//       jpPrincipal.revalidate();
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
      
        
       jpPrincipal.removeAll();
       jpPrincipal.validate();
       jpPrincipal.add(jInternalFrame1);
       JFPurchase pur = new JFPurchase();
        jInternalFrame1.setContentPane(pur.getContentPane());
        jInternalFrame1.setVisible(true);
       jpPrincipal.setVisible(true);
       jpPrincipal.revalidate();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked

        jpPrincipal.removeAll();
        jpPrincipal.validate();
        AccessPanel acc = new AccessPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpPrincipal.add(acc, BorderLayout.NORTH);
        jpPrincipal.setVisible(true);
        jpPrincipal.revalidate();
        


    }//GEN-LAST:event_jPanel21MouseClicked

    private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
        
        
//        jpPrincipal.removeAll();
//       jpPrincipal.validate();
//       jpPrincipal.add(jInternalFrame1);
//       JFReview rev = new JFReview();
//        jInternalFrame1.setContentPane(rev.getContentPane());
//        jInternalFrame1.setVisible(true);
//       jpPrincipal.setVisible(true);
//       jpPrincipal.revalidate();
        
        
        
        
    }//GEN-LAST:event_jPanel22MouseClicked

    void setColor(JPanel panel) {
        panel.setBackground(new Color(102, 102, 102));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(204, 204, 204));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bAccess;
    private javax.swing.JLabel bAddEmployee;
    private javax.swing.JLabel bAutor;
    private javax.swing.JLabel bBook;
    private javax.swing.JLabel bClient;
    private javax.swing.JLabel bEditor;
    private javax.swing.JLabel bEvent;
    private javax.swing.JLabel bFormats;
    private javax.swing.JLabel bFormats1;
    private javax.swing.JLabel bKeyWord;
    private javax.swing.JLabel bModerate;
    private javax.swing.JLabel bPrice;
    private javax.swing.JLabel bPurchase;
    private javax.swing.JLabel bSubTheme;
    private javax.swing.JLabel bTheme;
    private javax.swing.JButton jBAdmin;
    private javax.swing.JButton jBClient;
    private javax.swing.JButton jBProduct;
    private javax.swing.JButton jBStat;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel menuAdmin;
    private javax.swing.JPanel menuProduct;
    private javax.swing.JPanel menuPurchase;
    // End of variables declaration//GEN-END:variables
}
