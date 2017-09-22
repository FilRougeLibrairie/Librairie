package ui;

import ClassObjet.Author;
import ClassObjet.Book;
import ClassObjet.BookLanguage;
import ClassObjet.ClassAssoc.Association;
import ClassObjet.ClassAssoc.Having;
import ClassObjet.Editor;
import ClassObjet.Forma;
import ClassObjet.Review;
import ClassObjet.StatusDisplay;
import ClassObjet.SubTheme;
import ClassObjet.Theme;
import ClassObjet.Vat;
import Names.SQLNames;
import SQLS.AssociationDAO;
import SQLS.AuthorDAO;
import SQLS.BookDAO;
import SQLS.BookLanguageDAO;
import SQLS.EditorDAO;
import SQLS.FormatsDAO;
import SQLS.ReviewDAO;
import SQLS.StatusDisplayDAO;
import SQLS.SubThemeDAO;
import SQLS.ThemeDAO;
import SQLS.VatDAO;
import SQLS.WritingDAO;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.PriceCalculation;

/**
 *
 *
 *
 * @author cdi312 design cdi 305 code
 *
 */
public class JFBook2 extends javax.swing.JFrame {

    Vector vAuthor = new Vector();
    Vector vEditor = new Vector();
    Vector vTheme = new Vector();
    Vector vSubTheme = new Vector();
    Vector vVat = new Vector();
    Vector vStatusDisplay = new Vector();
    Vector vLanguage = new Vector();
    Vector vFormat = new Vector();
    Vector<String> comboAuthorModel;
    private JFileChooser jfc = new JFileChooser();

    public JFBook2() {

        initComponents();
        jComboBoxAuthor.setSelectedIndex(-1);
        jComboBoxAuthor2.setSelectedIndex(-1);
        jComboBoxEditor.setSelectedIndex(-1);
        jComboBoxTheme.setSelectedIndex(-1);
        jComboBoxSubTheme.setSelectedIndex(-1);
        jComboBoxSubTheme2.setSelectedIndex(-1);
        jComboBoxVat.setSelectedIndex(-1);
        jComboBoxStatus.setSelectedIndex(-1);
        jComboBoxLanguage.setSelectedIndex(-1);
        jComboBoxFormat.setSelectedIndex(-1);
    }

    public void nettoyage() {
        tfTitle.setText("");
        tfSubTitle.setText("");
        tfIsbn.setText("");
        jComboBoxAuthor.setSelectedIndex(-1);
        jComboBoxAuthor2.setSelectedIndex(-1);
        jComboBoxEditor.setSelectedIndex(-1);
        tfQuantity.setText("");
        jComboBoxTheme.setSelectedIndex(-1);
        jComboBoxSubTheme.setSelectedIndex(-1);
        jComboBoxSubTheme2.setSelectedIndex(-1);
        tfYearEdition.setText("");
        tfNumberOfPages.setText("");
        tfPriceHt.setText("");
        taResume.setText("");
        jComboBoxVat.setSelectedIndex(-1);
        jComboBoxStatus.setSelectedIndex(-1);
        jComboBoxLanguage.setSelectedIndex(-1);
        jComboBoxFormat.setSelectedIndex(-1);
        tfSearch.setText("");
        tfShowFiles.setText("");
    }

    private DefaultComboBoxModel initAuthorModel() {
        return new DefaultComboBoxModel(initAuthorVector());
    }

    private Vector initAuthorVector() {
        AuthorDAO autDao = new AuthorDAO();
        return autDao.findAll();
    }

    private DefaultComboBoxModel initAuthorModel2() {
        return new DefaultComboBoxModel(initAuthorVector2());
    }

    private Vector initAuthorVector2() {
        AuthorDAO autDao = new AuthorDAO();
        return autDao.findAll();
    }

    private DefaultComboBoxModel initEditorModel() {
        return new DefaultComboBoxModel(initEditorVector());

    }

    private Vector initEditorVector() {
        EditorDAO ediDao = new EditorDAO();
        return ediDao.findAll();
    }

    private DefaultComboBoxModel initThemeModel() {
        return new DefaultComboBoxModel(initThemeVector());
    }

    private Vector initThemeVector() {
        ThemeDAO theDao = new ThemeDAO();
        return theDao.findAll();
    }

    private DefaultComboBoxModel initSubThemeModel() {
        return new DefaultComboBoxModel(initSubThemeVector());

    }

    private Vector initSubThemeVector() {
        SubThemeDAO subDao = new SubThemeDAO();
        return subDao.findAll();

    }

    private DefaultComboBoxModel initSubThemeModel2() {
        return new DefaultComboBoxModel(initSubThemeVector2());

    }

    private Vector initSubThemeVector2() {
        SubThemeDAO subDao = new SubThemeDAO();
        return subDao.findAll();

    }

    private DefaultComboBoxModel initVatModel() {
        return new DefaultComboBoxModel(initVatVector());
    }

    private Vector initVatVector() {
        VatDAO vatDao = new VatDAO();
        return vatDao.findAll();
    }

    private DefaultComboBoxModel initStatusDisplayModel() {
        return new DefaultComboBoxModel(initStatusDisplayVector());
    }

    private Vector initStatusDisplayVector() {
        StatusDisplayDAO staDao = new StatusDisplayDAO();
        return staDao.findAll();
    }

    private DefaultComboBoxModel initFormatModel() {
        return new DefaultComboBoxModel(initFormatVector());
    }

    private Vector initFormatVector() {
        FormatsDAO forDao = new FormatsDAO();
        return forDao.findAll();
    }

    private DefaultComboBoxModel initLanguageModel() {
        return new DefaultComboBoxModel(initLanguageVector());
    }

    private Vector initLanguageVector() {
        BookLanguageDAO langDao = new BookLanguageDAO();
        return langDao.findAll();
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfIsbn = new javax.swing.JTextField();
        tfSubTitle = new javax.swing.JTextField();
        tfTitle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfYearEdition = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxVat = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        tfPriceHt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxTheme = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxSubTheme = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        tfNumberOfPages = new javax.swing.JTextField();
        jComboBoxLanguage = new javax.swing.JComboBox();
        jComboBoxFormat = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResume = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jlSave = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButtonAddPicture = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel9 = new javax.swing.JPanel();
        labelSearchBook = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLCreateNew = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxSearch = new javax.swing.JComboBox();
        tfSearch = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableResultatRecherche = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxSubTheme2 = new javax.swing.JComboBox();
        jComboBoxAuthor = new javax.swing.JComboBox();
        jComboBoxEditor = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxAuthor2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        tfShowFiles = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 630));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 630));

        jLabel8.setText("Sous-titre :");

        jLabel12.setText("ISBN :");

        jLabel9.setText("Année publication :");

        jLabel7.setText("Titre :");

        jLabel13.setText("Code T.V.A :");

        jComboBoxVat.setModel(initVatModel());

        jLabel10.setText("Prix H.T :");

        jLabel15.setText("Statut :");

        jComboBoxStatus.setModel(initStatusDisplayModel());

        jLabel2.setText("Format :");

        jLabel11.setText("Editeur :");

        jLabel16.setText("Langue :");

        jLabel17.setText("Auteur :");

        jLabel4.setText("Thème :");

        jComboBoxTheme.setModel(initThemeModel());
        jComboBoxTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxThemeActionPerformed(evt);
            }
        });

        jLabel18.setText("Sous-thème :");

        jComboBoxSubTheme.setModel(initSubThemeModel());

        jLabel20.setText("Nombre page :");

        jComboBoxLanguage.setModel(initLanguageModel());

        jComboBoxFormat.setModel(initFormatModel());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseReleased(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        taResume.setColumns(20);
        taResume.setLineWrap(true);
        taResume.setRows(5);
        taResume.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taResume);

        jPanel6.setBackground(new java.awt.Color(51, 102, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 45));

        jlSave.setForeground(new java.awt.Color(255, 255, 255));
        jlSave.setText("Enregistrer");
        jlSave.setMaximumSize(new java.awt.Dimension(43, 16));
        jlSave.setMinimumSize(new java.awt.Dimension(43, 16));
        jlSave.setPreferredSize(new java.awt.Dimension(43, 16));
        jlSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jlSave, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Visualiser");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Commentaire", jPanel7);

        jLabel14.setText("Couverture :");

        jButtonAddPicture.setText("Joindre image...");
        jButtonAddPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPictureActionPerformed(evt);
            }
        });

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(200, 400));
        jInternalFrame1.setVisible(true);

        jPanel9.setBackground(new java.awt.Color(51, 102, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 45));

        labelSearchBook.setForeground(new java.awt.Color(255, 255, 255));
        labelSearchBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSearchBook.setText("Rechercher");
        labelSearchBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                labelSearchBookMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSearchBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSearchBook, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel19.setText("Recherche livre par :");

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        jLCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        jLCreateNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCreateNew.setText("Nouveau livre");
        jLCreateNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCreateNewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLCreateNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ISBN", "Titre", "Auteur" }));

        jTableResultatRecherche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Résultat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableResultatRecherche);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfSearch)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jComboBoxSearch, javax.swing.GroupLayout.Alignment.LEADING, 0, 176, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jLabel21.setText("Sous-thème 2 :");

        jComboBoxSubTheme2.setModel(initSubThemeModel2());

        jComboBoxAuthor.setModel(initAuthorModel());

        jComboBoxEditor.setModel(initEditorModel());

        jLabel22.setText("Quantité :");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Enregistrer");

        jLabel25.setText("Auteur 2 :");

        jComboBoxAuthor2.setModel(initAuthorModel2());
        jComboBoxAuthor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAuthor2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Fichier :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIsbn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSubTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxSubTheme2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxTheme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxSubTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxEditor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxAuthor2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAddPicture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jComboBoxLanguage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBoxStatus, 0, 187, Short.MAX_VALUE)
                                                .addComponent(jComboBoxVat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfYearEdition)
                                                .addComponent(tfNumberOfPages)
                                                .addComponent(tfPriceHt, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tfShowFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(157, 157, 157))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(jComboBoxLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAddPicture))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(tfTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel20))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel13)
                                            .addComponent(jComboBoxVat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jComboBoxFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel25)
                                                    .addComponent(jComboBoxAuthor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jComboBoxEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel11)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfYearEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNumberOfPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPriceHt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBoxTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBoxSubTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBoxSubTheme2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel1)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(tfShowFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfIsbn, tfSubTitle, tfTitle});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxSubTheme, jComboBoxTheme});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(922, 686));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLCreateNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCreateNewMouseClicked
        nettoyage();
    }//GEN-LAST:event_jLCreateNewMouseClicked
    Book boo = null;
    BookDAO booDao = new BookDAO();
    AuthorDAO autDao = new AuthorDAO();
    SubThemeDAO subDao = new SubThemeDAO();
    ThemeDAO theDao = new ThemeDAO();

    private void labelSearchBookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchBookMouseReleased

        if (jComboBoxSearch.getSelectedIndex() == 0) {

            boo = booDao.find(tfSearch.getText());
            if (boo != null) {
                tfTitle.setText(boo.getBooTitle());
                tfSubTitle.setText(boo.getBooSubtitle());
                tfIsbn.setText(boo.getBooIsbn13());
                tfQuantity.setText(String.valueOf(boo.getBooQuantity()));
                tfShowFiles.setText(boo.getBooFrontCover());
                tfYearEdition.setText(boo.getBooPublishYear());
                tfPriceHt.setText(String.valueOf(boo.getBooPriceHT()));
                tfNumberOfPages.setText(String.valueOf(boo.getBooPageNumber()));
                taResume.setText(boo.getBooResume());
                Vector<Author> vAut = autDao.findAuthorByBook(tfIsbn.getText());
                int s = 0;
                for (int i = 0; i < jComboBoxAuthor.getModel().getSize(); i++) {
                    for (int j = 0; j < vAut.size(); j++) {
                        if (jComboBoxAuthor.getItemAt(i).toString().trim().equalsIgnoreCase(vAut.get(j).getAutLastName().trim() + " " + vAut.get(j).getAutFirstName().trim())) {
                            System.out.println("");
                            jComboBoxAuthor.setSelectedIndex(i);

                            s = j;
                        }

                    }
                }
                for (int i = 0; i < jComboBoxAuthor2.getModel().getSize(); i++) {
                    for (int j = 0; j < vAut.size(); j++) {
                        if (j != s && jComboBoxAuthor2.getItemAt(i).toString().trim().equalsIgnoreCase(vAut.get(j).getAutLastName().trim() + " " + vAut.get(j).getAutFirstName().trim())) {
                            jComboBoxAuthor2.setSelectedIndex(i);
                        }
                    }
                }

                Vector<SubTheme> vSubT = subDao.findSubThemeByBook(tfIsbn.getText());
                int r = 0;
                for (int i = 0; i < jComboBoxSubTheme.getModel().getSize(); i++) {

                    for (int j = 0; j < vSubT.size(); j++) {
                        if (jComboBoxSubTheme.getItemAt(i).toString().trim().equalsIgnoreCase(vSubT.get(j).getSubName().trim())) {
                            jComboBoxSubTheme.setSelectedIndex(i);
                            r = j;
                        }
                    }
                }
                for (int i = 0; i < jComboBoxSubTheme2.getModel().getSize(); i++) {
                    for (int j = 0; j < vSubT.size(); j++) {
                        if (j != r && jComboBoxSubTheme.getItemAt(i).toString().trim().equalsIgnoreCase(vSubT.get(j).getSubName().trim())) {
                            jComboBoxSubTheme2.setSelectedIndex(i);
                        }
                    }
                }

                Theme the = theDao.findByIsbn(tfIsbn.getText());
                jComboBoxTheme.setSelectedItem(the);
                for (int i = 0; i < jComboBoxTheme.getModel().getSize(); i++) {
                    if (jComboBoxTheme.getItemAt(i).toString().trim().equalsIgnoreCase(the.getTheName().trim())) {
                        jComboBoxTheme.setSelectedIndex(i);
                    }
                }

                Editor edi = new Editor();
                EditorDAO ediDao = new EditorDAO();
                edi = ediDao.find(boo.getEdiId().getEdiId());
                for (int i = 0; i < jComboBoxEditor.getModel().getSize(); i++) {
                    if (jComboBoxEditor.getItemAt(i).toString().equalsIgnoreCase(edi.getEdiName())) {
                        jComboBoxEditor.setSelectedIndex(i);
                    }
                }
                Vat vat = new Vat();
                VatDAO vatDao = new VatDAO();
                vat = vatDao.find(boo.getVatCode().getVatCode());
                jComboBoxVat.setSelectedItem(vat.getVatCode());
                for (int i = 0; i < jComboBoxVat.getModel().getSize(); i++) {
                    if (i == (vat.getVatCode())) {
                        jComboBoxVat.setSelectedIndex(i);
                    }
                }
                StatusDisplay sta = new StatusDisplay();
                StatusDisplayDAO staDao = new StatusDisplayDAO();
                sta = staDao.find(boo.getBooStatus());
                for (int i = 0; i <= jComboBoxStatus.getModel().getSize(); i++) {
                    if (i == (sta.getStaCode())) {
                        jComboBoxStatus.setSelectedIndex(i);
                    }
                }
                BookLanguage booLan = new BookLanguage();
                BookLanguageDAO booLanDAO = new BookLanguageDAO();
                booLan = booLanDAO.find(boo.getBooLangCode().getBooLangCode());
                for (int i = 1; i <= jComboBoxLanguage.getModel().getSize(); i++) {
                    if (i == (booLan.getBooLangCode())) {
                        jComboBoxLanguage.setSelectedIndex(i);
                    }
                }
                Forma form = new Forma();
                FormatsDAO formaDao = new FormatsDAO();
                form = formaDao.find(boo.getFormat().getForId());
                for (int i = 0; i < jComboBoxFormat.getModel().getSize(); i++) {
                    if (i == (form.getForId())) {
                        jComboBoxFormat.setSelectedIndex(i - 1);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Livre inexistant", "Gestion des livres", JOptionPane.PLAIN_MESSAGE);
            }

        } else if (jComboBoxSearch.getSelectedIndex() == 1) {

            BookDAO booDao = new BookDAO();
            AuthorDAO autDao = new AuthorDAO();
            SubThemeDAO subDao = new SubThemeDAO();
            ThemeDAO theDao = new ThemeDAO();
            Vector<Book> v = new Vector<Book>();
            v = booDao.findByColumn(SQLNames.BookNames.TITLE, tfSearch.getText());

            for (Book boo : v) {
                if (v != null) {
                    tfTitle.setText(boo.getBooTitle());
                    tfSubTitle.setText(boo.getBooSubtitle());
                    tfIsbn.setText(boo.getBooIsbn13());
                    tfQuantity.setText(String.valueOf(boo.getBooQuantity()));
                    tfYearEdition.setText(boo.getBooPublishYear());
                    tfPriceHt.setText(String.valueOf(boo.getBooPriceHT()));
                    tfNumberOfPages.setText(String.valueOf(boo.getBooPageNumber()));
                    taResume.setText(boo.getBooResume());
                    tfShowFiles.setText(boo.getBooFrontCover());
                    Vector<Author> vAut = autDao.findAuthorByBook(tfIsbn.getText());
                    int s = 0;
                    for (int i = 0; i < jComboBoxAuthor.getModel().getSize(); i++) {
                        for (int j = 0; j < vAut.size(); j++) {
                            if (jComboBoxAuthor.getItemAt(i).toString().trim().equalsIgnoreCase(vAut.get(j).getAutLastName().trim() + " " + vAut.get(j).getAutFirstName().trim())) {

                                jComboBoxAuthor.setSelectedIndex(i);

                                s = j;
                            }

                        }
                    }
                    for (int i = 0; i < jComboBoxAuthor2.getModel().getSize(); i++) {
                        for (int j = 0; j < vAut.size(); j++) {
                            if (j != s && jComboBoxAuthor2.getItemAt(i).toString().trim().equalsIgnoreCase(vAut.get(j).getAutLastName().trim() + " " + vAut.get(j).getAutFirstName().trim())) {
                                jComboBoxAuthor2.setSelectedIndex(i);
                            }
                        }
                    }

                    Vector<SubTheme> vSubT = subDao.findSubThemeByBook(tfIsbn.getText());
                    int r = 0;
                    for (int i = 0; i < jComboBoxSubTheme.getModel().getSize(); i++) {
                        for (int j = 0; j < vSubT.size(); j++) {
                            if (jComboBoxSubTheme.getItemAt(i).toString().trim().equalsIgnoreCase(vSubT.get(j).getSubName().trim())) {
                                jComboBoxSubTheme.setSelectedIndex(i);
                                r = j;
                            }
                        }
                    }
                    for (int i = 0; i < jComboBoxSubTheme2.getModel().getSize(); i++) {
                        for (int j = 0; j < vSubT.size(); j++) {
                            if (j != r && jComboBoxSubTheme.getItemAt(i).toString().trim().equalsIgnoreCase(vSubT.get(j).getSubName().trim())) {
                                jComboBoxSubTheme2.setSelectedIndex(i);
                            }
                        }
                    }

                    Theme the = theDao.findByIsbn(tfIsbn.getText());
                    jComboBoxTheme.setSelectedItem(the);
                    for (int i = 0; i < jComboBoxTheme.getModel().getSize(); i++) {
                        if (jComboBoxTheme.getItemAt(i).toString().trim().equalsIgnoreCase(the.getTheName().trim())) {
                            jComboBoxTheme.setSelectedIndex(i);
                        }
                    }

                    Editor edi = new Editor();
                    EditorDAO ediDao = new EditorDAO();
                    edi = ediDao.find(boo.getEdiId().getEdiId());
                    for (int i = 0; i < jComboBoxEditor.getModel().getSize(); i++) {
                        if (jComboBoxEditor.getItemAt(i).toString().equalsIgnoreCase(edi.getEdiName())) {
                            jComboBoxEditor.setSelectedIndex(i);
                        }
                    }
                    Vat vat = new Vat();
                    VatDAO vatDao = new VatDAO();
                    vat = vatDao.find(boo.getVatCode().getVatCode());
                    for (int i = 0; i < jComboBoxVat.getModel().getSize(); i++) {
                        if (i == (vat.getVatCode())) {
                            jComboBoxVat.setSelectedIndex(i);
                        }
                    }
                    StatusDisplay sta = new StatusDisplay();
                    StatusDisplayDAO staDao = new StatusDisplayDAO();
                    sta = staDao.find(boo.getBooStatus()); //jComboBoxStatus.setSelectedItem(sta.getStaCode());
                    for (int i = 0; i <= jComboBoxStatus.getModel().getSize(); i++) {
                        if (i == (sta.getStaCode())) {
                            jComboBoxStatus.setSelectedIndex(i);
                        }
                    }
                    BookLanguage booLan = new BookLanguage();
                    BookLanguageDAO booLanDAO = new BookLanguageDAO();
                    booLan = booLanDAO.find(boo.getBooLangCode().getBooLangCode());//jComboBoxLanguage.setSelectedItem(booLan.getBooLangCode());
                    for (int i = 1; i <= jComboBoxLanguage.getModel().getSize(); i++) {
                        if (i == (booLan.getBooLangCode())) {
                            jComboBoxLanguage.setSelectedIndex(i);
                        }
                    }
                    Forma form = new Forma();
                    FormatsDAO formaDao = new FormatsDAO();
                    form = formaDao.find(boo.getFormat().getForId());
                    for (int i = 0; i < jComboBoxFormat.getModel().getSize(); i++) {
                        if (i == (form.getForId())) {
                            jComboBoxFormat.setSelectedIndex(i - 1);
                        }
                    }
                }
            }
            if (jComboBoxSearch.getSelectedIndex() == 2) {

                Vector<Having> vWri = new Vector<Having>();
              
                for (Book boo2 : v) {
                    if (v != null) {
                        tfTitle.setText(boo2.getBooTitle());
                        tfSubTitle.setText(boo2.getBooSubtitle());
                        tfIsbn.setText(boo2.getBooIsbn13());
                        tfQuantity.setText(String.valueOf(boo2.getBooQuantity()));
                        tfYearEdition.setText(boo2.getBooPublishYear());
                        tfPriceHt.setText(String.valueOf(boo2.getBooPriceHT()));
                        tfNumberOfPages.setText(String.valueOf(boo2.getBooPageNumber()));
                        taResume.setText(boo2.getBooResume());
                        tfShowFiles.setText(boo2.getBooFrontCover());
                        Vector<Author> vAut = autDao.findAuthorByBook(tfIsbn.getText());
                        int s = 0;
                        for (int i = 0; i < jComboBoxAuthor.getModel().getSize(); i++) {
                            for (int j = 0; j < vAut.size(); j++) {
                                if (jComboBoxAuthor.getItemAt(i).toString().trim().equalsIgnoreCase(vAut.get(j).getAutLastName().trim() + " " + vAut.get(j).getAutFirstName().trim())) {

                                    jComboBoxAuthor.setSelectedIndex(i);

                                    s = j;
                                }

                            }
                        }
                        for (int i = 0; i < jComboBoxAuthor2.getModel().getSize(); i++) {
                            for (int j = 0; j < vAut.size(); j++) {
                                if (j != s && jComboBoxAuthor2.getItemAt(i).toString().trim().equalsIgnoreCase(vAut.get(j).getAutLastName().trim() + " " + vAut.get(j).getAutFirstName().trim())) {
                                    jComboBoxAuthor2.setSelectedIndex(i);
                                }
                            }
                        }

                        Vector<SubTheme> vSubT = subDao.findSubThemeByBook(tfIsbn.getText());
                        int r = 0;
                        for (int i = 0; i < jComboBoxSubTheme.getModel().getSize(); i++) {
                            for (int j = 0; j < vSubT.size(); j++) {
                                if (jComboBoxSubTheme.getItemAt(i).toString().trim().equalsIgnoreCase(vSubT.get(j).getSubName().trim())) {
                                    jComboBoxSubTheme.setSelectedIndex(i);
                                    r = j;
                                }
                            }
                        }
                        for (int i = 0; i < jComboBoxSubTheme2.getModel().getSize(); i++) {
                            for (int j = 0; j < vSubT.size(); j++) {
                                if (j != r && jComboBoxSubTheme.getItemAt(i).toString().trim().equalsIgnoreCase(vSubT.get(j).getSubName().trim())) {
                                    jComboBoxSubTheme2.setSelectedIndex(i);
                                }
                            }
                        }

                        Theme the = theDao.findByIsbn(tfIsbn.getText());
                        jComboBoxTheme.setSelectedItem(the);
                        for (int i = 0; i < jComboBoxTheme.getModel().getSize(); i++) {
                            if (jComboBoxTheme.getItemAt(i).toString().trim().equalsIgnoreCase(the.getTheName().trim())) {
                                jComboBoxTheme.setSelectedIndex(i);
                            }
                        }

                        Editor edi = new Editor();
                        EditorDAO ediDao = new EditorDAO();
                        edi = ediDao.find(boo.getEdiId().getEdiId());
                        for (int i = 0; i < jComboBoxEditor.getModel().getSize(); i++) {
                            if (jComboBoxEditor.getItemAt(i).toString().equalsIgnoreCase(edi.getEdiName())) {
                                jComboBoxEditor.setSelectedIndex(i);
                            }
                        }
                        Vat vat = new Vat();
                        VatDAO vatDao = new VatDAO();
                        vat = vatDao.find(boo.getVatCode().getVatCode());
                        for (int i = 0; i < jComboBoxVat.getModel().getSize(); i++) {
                            if (i == (vat.getVatCode())) {
                                jComboBoxVat.setSelectedIndex(i);
                            }
                        }
                        StatusDisplay sta = new StatusDisplay();
                        StatusDisplayDAO staDao = new StatusDisplayDAO();
                        sta = staDao.find(boo.getBooStatus()); //jComboBoxStatus.setSelectedItem(sta.getStaCode());
                        for (int i = 0; i <= jComboBoxStatus.getModel().getSize(); i++) {
                            if (i == (sta.getStaCode())) {
                                jComboBoxStatus.setSelectedIndex(i);
                            }
                        }
                        BookLanguage booLan = new BookLanguage();
                        BookLanguageDAO booLanDAO = new BookLanguageDAO();
                        booLan = booLanDAO.find(boo.getBooLangCode().getBooLangCode());//jComboBoxLanguage.setSelectedItem(booLan.getBooLangCode());
                        for (int i = 1; i <= jComboBoxLanguage.getModel().getSize(); i++) {
                            if (i == (booLan.getBooLangCode())) {
                                jComboBoxLanguage.setSelectedIndex(i);
                            }
                        }
                        Forma form = new Forma();
                        FormatsDAO formaDao = new FormatsDAO();
                        form = formaDao.find(boo.getFormat().getForId());
                        for (int i = 0; i < jComboBoxFormat.getModel().getSize(); i++) {
                            if (i == (form.getForId())) {
                                jComboBoxFormat.setSelectedIndex(i - 1);
                            }
                        }
                    }
                }
            }

        }


    }//GEN-LAST:event_labelSearchBookMouseReleased

    private void jComboBoxAuthor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAuthor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAuthor2ActionPerformed

    private void jButtonAddPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPictureActionPerformed
        int returnval = jfc.showOpenDialog(jButtonAddPicture);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            //recuperation du chemin
            tfShowFiles.setText(jfc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonAddPictureActionPerformed

    private void jlSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSaveMouseClicked
        /*----------------------------------------------------------------*/
        /*             recuperation info pour la table BOOK               */
        /*----------------------------------------------------------------*/
        Book boo = new Book();
        boo.setBooIsbn13(tfIsbn.getText());
        boo.setBooTitle(tfTitle.getText());
        boo.setBooSubtitle(tfSubTitle.getText());
        boo.setBooPublishYear(tfYearEdition.getText());
        Float price = PriceCalculation.roundedPrice(Float.valueOf(tfPriceHt.getText()));
        boo.setBooPriceHT(price);
        boo.setBooResume(taResume.getText());
        boo.setBooQuantity(Integer.valueOf(tfQuantity.getText()));
        boo.setBooFrontCover(tfShowFiles.getText());
        boo.setBooPageNumber(Integer.valueOf(tfNumberOfPages.getText()));
        boo.setBooStatus(jComboBoxStatus.getSelectedIndex());
        boo.getVatCode().setVatCode(jComboBoxVat.getSelectedIndex());
        boo.getEdiId().setEdiId(jComboBoxEditor.getSelectedIndex() + 1);
        boo.getBooLangCode().setBooLangCode(jComboBoxLanguage.getSelectedIndex());
        boo.getFormat().setForId(jComboBoxFormat.getSelectedIndex() + 1);
        //creation dans table BOOK
        BookDAO booDao = new BookDAO();
        booDao.create(boo);

        /*----------------------------------------------------------------*/
        /*           recuperation info pour la table Having              */
        /*----------------------------------------------------------------*/
        // pour la JcomboBoxAuthor
        Having wri = new Having();
        wri.setBooIsbn13(tfIsbn.getText());
        Author a = new Author();
        a = (Author) jComboBoxAuthor.getSelectedItem();
        wri.setAutId(a.getAutId());
        //creation
        WritingDAO wriDao = new WritingDAO();
        wriDao.create(wri);

        // Pour la JcomboboxAuthor2
//        Writing wri2 = new Writing();
//        if (jComboBoxAuthor2 != jComboBoxAuthor2.getModel()) {
//            wri2.setBooIsbn13(tfIsbn.getText());
//            Author a2 = new Author();
//            a2 = (Author) jComboBoxAuthor2.getSelectedItem();
//            wri2.setAutId(a2.getAutId());
//            //creation
//            wriDao.create(wri2);
//        }

       
        /*----------------------------------------------------------------*/
        /*           recuperation info pour la table Association          */
        /*----------------------------------------------------------------*/
        // pour la JcomboBoxSubTheme
        Association asso = new Association();
        asso.setBooIsbn13(tfIsbn.getText());
        System.out.println("jcombo subtheme index = " + jComboBoxSubTheme.getSelectedIndex());
        asso.setSubId(jComboBoxSubTheme.getSelectedIndex()+1);
        //création
        AssociationDAO assoDao = new AssociationDAO();
        assoDao.create(asso);

        //pour la JcomboBoxSubTheme2
//        if (jComboBoxSubTheme2 != null) {
//            asso.setBooIsbn13(tfIsbn.getText());
//            asso.setSubId(jComboBoxSubTheme2.getSelectedIndex());
//            //creation
//            assoDao.create(asso);
//        }
        JOptionPane jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Le livre a été ajouté avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
        nettoyage();


    }//GEN-LAST:event_jlSaveMouseClicked

    private void jComboBoxThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxThemeActionPerformed

    }//GEN-LAST:event_jComboBoxThemeActionPerformed

    private void jTabbedPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseReleased
     
    }//GEN-LAST:event_jTabbedPane1MouseReleased

    /**
     *
     * @param args the command line arguments
     *
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

            java.util.logging.Logger.getLogger(JFBook2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(JFBook2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(JFBook2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(JFBook2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new JFBook2().setVisible(true);

            }

        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPicture;
    private javax.swing.JComboBox jComboBoxAuthor;
    private javax.swing.JComboBox jComboBoxAuthor2;
    private javax.swing.JComboBox jComboBoxEditor;
    private javax.swing.JComboBox jComboBoxFormat;
    private javax.swing.JComboBox jComboBoxLanguage;
    private javax.swing.JComboBox jComboBoxSearch;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JComboBox jComboBoxSubTheme;
    private javax.swing.JComboBox jComboBoxSubTheme2;
    private javax.swing.JComboBox jComboBoxTheme;
    private javax.swing.JComboBox jComboBoxVat;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLCreateNew;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableResultatRecherche;
    private javax.swing.JLabel jlSave;
    private javax.swing.JLabel labelSearchBook;
    private javax.swing.JTextArea taResume;
    private javax.swing.JTextField tfIsbn;
    private javax.swing.JTextField tfNumberOfPages;
    private javax.swing.JTextField tfPriceHt;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfShowFiles;
    private javax.swing.JTextField tfSubTitle;
    private javax.swing.JTextField tfTitle;
    private javax.swing.JTextField tfYearEdition;
    // End of variables declaration//GEN-END:variables

}
