/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package ui;

import ClassObjet.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**

 *

 * @author cdi312

 */

public class JFBook extends javax.swing.JFrame {



    /**

     * Creates new form JFBook

     */

    public JFBook() {

        initComponents();

    }
    
    
    
    private void Enregistrer(java.awt.event.ActionEvent evt) {                                               
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showInternalMessageDialog(null, "Oops:ClassNotFound :"+ex.getMessage(), "creation Driver", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Oops:ClassNotFound:" + ex.getMessage());
        }

        Connection connexion = null;

        try {
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=MyLibrary;user=sa;password=sa";

            connexion = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Oops:Connect :"+ex.getErrorCode(), "Connexion au serveur", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Oops:Connect:" + ex.getErrorCode()
//                    + "/" + ex.getMessage());
            return;
        }

        try {
            Statement stmt = connexion.createStatement();
            
            String isbn = tfIsbn.getText();
            String vat = String.valueOf(comboVat);
            String editor = tfEditor.getText();
            String title = tfTitle.getText();
            String subTitle = tfSubTitle.getText();
            String yearEdition = tfYearEdition.getText();
            String author = tfAuthor.getText();
            String priceHt = tfPriceHt.getText();
            String resume = taResume.getText();
            String quantity = String.valueOf(tfQuantity);
            String status = String.valueOf(comboStatus);
            String numberPages = tfNumberOfPages.getText();
            String pageNumber = String.valueOf(tfNumberOfPages);
            String language = String.valueOf(comboLanguage);
            String format = String.valueOf(comboFormat);
            
      
//            String query = "INSERT INTO Book VALUES "
//                    + "('" + isbn + "','" + vat + "','" + editor  + "','" + adresseRue + "','" + codePostal + "','" + ville + "','" + email + "','" + typeContact
//                    + "','" + telephonePortable
//                    + "','" + dateNaissance + "')";
//            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Oops: nouvContact" + ex.getMessage(), "Ajout nouveau Contact", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Erreur nouvContact" + ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Contact ajouté", "Ajout d'un contact", JOptionPane.PLAIN_MESSAGE);
    //    jfsupp.synchroCarnet();
        nettoyage();
    }                                              
    

      public DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add("Book");

        return new javax.swing.table.DefaultTableModel(
                initBookVector(), v) {
                    boolean[] canEdit = new boolean[]{
                        false, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    } 
    
    
      private Vector initBookVector() {
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

        String query = "SELECT * FROM BOOK;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Book b = new Book();
                v.add(b.getVector());

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


    /**

     * This method is called from within the constructor to initialize the form.

     * WARNING: Do NOT modify this code. The content of this method is always

     * regenerated by the Form Editor.

     */

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        comboSearch = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        labelSearchBook = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLCreateNew = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        tfIsbn = new javax.swing.JTextField();
        tfSubTitle = new javax.swing.JTextField();
        tfTitle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfYearEdition = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboVat = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        tfPriceHt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfEditor = new javax.swing.JTextField();
        tfAuthor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboTheme = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        comboSubTheme = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        tfNumberOfPages = new javax.swing.JTextField();
        comboLanguage = new javax.swing.JComboBox();
        comboFormat = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResume = new javax.swing.JTextArea();
        panelSave = new javax.swing.JPanel();
        labelSave = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        labelVisualiser = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel5.setText("Rechercher par :");

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ISBN", "Titre", "Sous-titre" }));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 45));

        labelSearchBook.setForeground(new java.awt.Color(255, 255, 255));
        labelSearchBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSearchBook.setText("Rechercher livre");
        labelSearchBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSearchBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSearchBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        jLCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        jLCreateNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCreateNew.setText("Créer Nouveau");
        jLCreateNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLCreateNewMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLCreateNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel8.setText("Sous-titre :");

        tfTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTitleActionPerformed(evt);
            }
        });

        jLabel12.setText("ISBN :");

        jLabel9.setText("Année publication :");

        jLabel7.setText("Titre :");

        jLabel13.setText("Code T.V.A :");

        comboVat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5.5%", "20%" }));

        jLabel10.setText("Prix H.T :");

        jLabel15.setText("Statut :");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "Rupture stock", "En attente de livraison" }));

        jLabel2.setText("Format :");

        jLabel11.setText("Editeur :");

        jLabel16.setText("Langue :");

        jLabel17.setText("Auteur :");

        jLabel4.setText("Thème :");

        comboTheme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inclassable", "Bd & jeunesse", "Littérature & fiction", "Art, culture & société", "Vie pratique", "Scolaire et universitaire", "Savoirs" }));

        jLabel18.setText("Sous-thème :");

        comboSubTheme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bd & humour", "Manga", "Livre jeunesse", "Livre ados et young adults", "Roman et nouvelles", "Romans en poche", "Poésie, théâtre, lettres", "Roman policier et thriller", "Fantasy et science fiction", "Actualite: politique, economie, societe", "Art, cinema, musique", "Esoterisme et pananormal", "Histoire", "Religions et spiritualités", "Histoire", "Religions et spiritualités", "Sciences humaines", "Cuisine et vins", "Erotisme", "Sante, bien être, puériculture", "Scolaire et soutien scolaire", "Rentrée universitaire", "Concours et prépas", "Dictionnaires et langues", "Fantasy et science fiction", "Entreprise, management", "Livres informatique", "Sciences et medecine" }));

        jLabel20.setText("Nombre page :");

        comboLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Français", "------------", "Allemand", "Anglais", "Arabe", "Chinois", "Coréen", "Croate", "Danois", "Espagnol", "Finnois", "Grec", "Hongrois", "Italien", "Néerlandais", "Portugais", "Roumain", "Russe", "Turc" }));

        comboFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grand Carré 30x30cm", "Grand Poche 13x20cm", "Grand Poche 21x26cm", "Magasine 22x28cm", "Paysage Grand Format 33x28cm", "Petit Carré 18x18cm", "Portrait Standard 20x25cm" }));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        taResume.setColumns(20);
        taResume.setRows(5);
        jScrollPane1.setViewportView(taResume);

        panelSave.setBackground(new java.awt.Color(51, 102, 255));
        panelSave.setPreferredSize(new java.awt.Dimension(200, 45));

        labelSave.setForeground(new java.awt.Color(255, 255, 255));
        labelSave.setText("Enregistrer");

        javax.swing.GroupLayout panelSaveLayout = new javax.swing.GroupLayout(panelSave);
        panelSave.setLayout(panelSaveLayout);
        panelSaveLayout.setHorizontalGroup(
            panelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaveLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelSave)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelSaveLayout.setVerticalGroup(
            panelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSave, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Résumé", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Commentaire", "Nombre d'étoiles", "Client ID"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel8.setBackground(new java.awt.Color(51, 102, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 45));

        labelVisualiser.setForeground(new java.awt.Color(255, 255, 255));
        labelVisualiser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVisualiser.setText("Visualiser");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelVisualiser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelVisualiser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Commentaire", jPanel7);

        jLabel14.setText("Couverture :");

        jButton1.setText("Joindre image...");

        jLabel19.setText("Quantité :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel7))
                                            .addGap(30, 30, 30)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tfSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                .addComponent(tfTitle)
                                                .addComponent(tfIsbn)))
                                        .addComponent(jLabel17)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel4))
                                            .addGap(44, 44, 44)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfEditor, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tfAuthor)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(comboTheme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboSubTheme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfQuantity))))
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, 198, Short.MAX_VALUE)
                                    .addComponent(comboVat, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfPriceHt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNumberOfPages, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfYearEdition, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboLanguage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboFormat, 0, 1, Short.MAX_VALUE)
                                    .addComponent(jButton1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfAuthor, tfEditor, tfIsbn, tfSubTitle, tfTitle});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(tfYearEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel20)
                    .addComponent(tfNumberOfPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(tfPriceHt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboVat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(comboSubTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton1)
                    .addComponent(jLabel19)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfAuthor, tfEditor, tfIsbn, tfSubTitle, tfTitle});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboSubTheme, comboTheme});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 838));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    private void jLCreateNewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCreateNewMouseReleased

        System.out.println(evt.getButton());
        nettoyage();
    }//GEN-LAST:event_jLCreateNewMouseReleased

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed

    private void tfTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTitleActionPerformed

    public void nettoyage() {
        tfTitle.setText("");
        tfSubTitle.setText("");
        tfIsbn.setText("");
        tfAuthor.setText("");
        tfEditor.setText("");
        tfQuantity.setText("");
        comboTheme.setVisible(true);
        comboSubTheme.setVisible(true);
        tfYearEdition.setText("");
        tfNumberOfPages.setText("");
        tfPriceHt.setText("");
        taResume.setText("");
        comboVat.setVisible(true);
        comboStatus.setVisible(true);
        comboLanguage.setVisible(true);
        comboFormat.setVisible(true);
    }

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

            java.util.logging.Logger.getLogger(JFBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(JFBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(JFBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(JFBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>



        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new JFBook().setVisible(true);

            }

        });

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFormat;
    private javax.swing.JComboBox comboLanguage;
    private javax.swing.JComboBox comboSearch;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JComboBox comboSubTheme;
    private javax.swing.JComboBox comboTheme;
    private javax.swing.JComboBox comboVat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLCreateNew;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelSave;
    private javax.swing.JLabel labelSearchBook;
    private javax.swing.JLabel labelVisualiser;
    private javax.swing.JPanel panelSave;
    private javax.swing.JTextArea taResume;
    private javax.swing.JTextField tfAuthor;
    private javax.swing.JTextField tfEditor;
    private javax.swing.JTextField tfIsbn;
    private javax.swing.JTextField tfNumberOfPages;
    private javax.swing.JTextField tfPriceHt;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSubTitle;
    private javax.swing.JTextField tfTitle;
    private javax.swing.JTextField tfYearEdition;
    // End of variables declaration//GEN-END:variables

}

