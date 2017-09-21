package ui.jfPurchase;

import ClassObjet.Address;
import ClassObjet.Book;
import ClassObjet.Customer;
import ClassObjet.OrderLine;
import ClassObjet.Purchase;
import ClassObjet.ShippingCost;
import Names.SQLNames;
import SQLS.AddressDAO;
import SQLS.BookDAO;
import SQLS.CustomerDAO;
import SQLS.OrderLineDAO;
import SQLS.PurchaseDAO;
import SQLS.ShippingCostDAO;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import ui.jfCustomer.AddressTableItem;
import utils.DateLabelFormatter;
import utils.PriceCalculation;

/**
 * ***************************************
 ******************************************
 *
 * GUILLAUME IS CODING * DON'T TOUCH THIS FILE PLEASE :-)
 *
 *****************************************
 ****************************************
 */
public class JFPurchase extends javax.swing.JFrame implements SQLNames {

    Vector comboSearchModel;
    Vector<Purchase> purchaseList;
    Vector addressTableList;
    Vector purchaseTableList;
    Vector orderStatusTableList;
    Vector comboAdressModel;
    PurchaseDAO purchaseDAO;
    Customer currentCustomer;
    Purchase currentPurchase;
    JDatePickerImpl datePicker;
    Address currentShipAddress;
    Address currentInvoiceAddress;

    private final String RUE = "Rue";
    private final String AVENUE = "Avenue";
    private final String ALLEE = "Allée";
    private final String BOULEVARD = "Boulevard";
    private final String CHEMIN = "Chemin";
    private final String ROUTE = "Route";
    private final String IMPASSE = "Impasse";
    private final String LIEU_DIT = "Lieu-dit";

    private enum OrderStatus {

        SUSPENDED(OrderStatusAttrNames.SUSPENDED),
        ORDERED(OrderStatusAttrNames.ORDERED),
        PAYED(OrderStatusAttrNames.PAYED),
        SHIPPED(OrderStatusAttrNames.SHIPPED),
        RECEIVED(OrderStatusAttrNames.RECEIVED),
        RETURN(OrderStatusAttrNames.RETURN),
        RETURN_ACCEPTED(OrderStatusAttrNames.RETURN_ACCEPTED),
        RETURN_REFUSED(OrderStatusAttrNames.RETURN_REFUSED),
        REFUNDED(OrderStatusAttrNames.REFUNDED);
        private final String databaseName;

        private OrderStatus(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    private enum SearchCriteria {

        REFERENCE("Reference"),
        DATE("Date"),
        NAME("Nom");
        private final String databaseName;

        private SearchCriteria(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    // Constructor
    public JFPurchase() {
        initComponents();

        comboSearch.setModel(initComboSearchModel());
        comboInvoiceStreetType.setModel(initAddressComboBoxModel());
        comboShipStreetType.setModel(initAddressComboBoxModel());
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBackground(Color.WHITE);
        datePicker.setBounds(0, 0, 200, 30);
        datePicker.setVisible(true);
        panelPayExpirationDate.setSize(100, 100);
        panelPayExpirationDate.add(datePicker);

        datePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerActionPerformed(evt);
            }
        });

    }

    private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {

        Date selectedDate = (Date) datePicker.getModel().getValue();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(selectedDate);

        System.out.println(date);

    }

    private void setTablePurchaseModel() {
        tableSearchOrder.setModel(initTablePurchaseModel());
    }

    private DefaultTableModel initTablePurchaseModel() {
        Vector v = new Vector();
        v.add("Résultats");
        return new javax.swing.table.DefaultTableModel(purchaseTableList, v) {
        };
    }

    private DefaultComboBoxModel initComboSearchModel() {
        DefaultComboBoxModel model;
        comboSearchModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboSearchModel);
        for (SearchCriteria comboItem : SearchCriteria.values()) {
            comboSearchModel.add(comboItem.getDatabaseName());
        }
        return model;
    }

    private void setTableAddressModel() {
        tableInvoiceAdresses.setModel(initTableAddressModel());
        tableShipAddresses.setModel(initTableAddressModel());
    }

    private DefaultTableModel initTableAddressModel() {
        Vector v = new Vector();
        v.add("Adresse");
        return new javax.swing.table.DefaultTableModel(addressTableList, v) {
        };
    }

    private DefaultComboBoxModel initAddressComboBoxModel() {
        DefaultComboBoxModel model;
        comboAdressModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboAdressModel);
        comboAdressModel.add(RUE);
        comboAdressModel.add(AVENUE);
        comboAdressModel.add(ALLEE);
        comboAdressModel.add(BOULEVARD);
        comboAdressModel.add(CHEMIN);
        comboAdressModel.add(ROUTE);
        comboAdressModel.add(IMPASSE);
        comboAdressModel.add(LIEU_DIT);
        return model;
    }

    private void searchForOrder() {
        PurchaseDAO purchaseDAO = new PurchaseDAO();
        purchaseList = purchaseDAO.findAll();
        purchaseTableList = new Vector();
        for (Purchase pur : purchaseList) {
            PurchaseTableItem purchaseTable = new PurchaseTableItem(pur);
            purchaseTableList.add(purchaseTable.getVector());
        }
        setTablePurchaseModel();

        /*
         if (comboSearch.getSelectedItem() != null) {
         String criteria = comboSearch.getSelectedItem().toString();
         String term = tfSearch.getText().trim();
         int statusIndex;
         customerList = new Vector<Customer>();
         CustomerDAO customerDAO = new CustomerDAO();

         if (criteria.equalsIgnoreCase(SearchCriteria.TOUS_LES_CLIENTS.getDatabaseName())) {
         customerList = customerDAO.findAll();
         } else if (criteria.equalsIgnoreCase(SearchCriteria.STATUS.getDatabaseName())) {
         criteria = CustomerNames.STATUS;
         statusIndex = comboStatus.getSelectedIndex();
         customerList = customerDAO.findByColumn(criteria, statusIndex);
         } else if (criteria.equalsIgnoreCase(SearchCriteria.GENDER.getDatabaseName())) {
         criteria = CustomerNames.GENDER;
         term = comboGender.getSelectedItem().toString().substring(0, 1).trim();
         customerList = customerDAO.findByColumn(criteria, term);
         } else if (term != null && !term.isEmpty()) {
         if (criteria.equalsIgnoreCase(SearchCriteria.NOM.getDatabaseName())) {
         criteria = CustomerNames.LAST_NAME;
         } else if (criteria.equalsIgnoreCase(SearchCriteria.PRENOM.getDatabaseName())) {
         criteria = CustomerNames.FIRST_NAME;
         } else if (criteria.equalsIgnoreCase(SearchCriteria.SOCIETE.getDatabaseName())) {
         criteria = CustomerNames.COMPANY;
         } else if (criteria.equalsIgnoreCase(SearchCriteria.EMAIL.getDatabaseName())) {
         criteria = CustomerNames.EMAIL;
         } else if (criteria.equalsIgnoreCase(SearchCriteria.TELEPHONE.getDatabaseName())) {
         criteria = CustomerNames.PHONE;
         } else if (criteria.equalsIgnoreCase(SearchCriteria.IP.getDatabaseName())) {
         criteria = CustomerNames.IP;
         } else if (criteria.equalsIgnoreCase(SearchCriteria.STATUS.getDatabaseName())) {
         criteria = CustomerNames.STATUS;
         }
         customerList = customerDAO.findByColumn(criteria, term);
         }

         customerTableList = new Vector();
         for (Customer cus : customerList) {
         CustomerTableItem customerTable = new CustomerTableItem(cus);
         customerTableList.add(customerTable.getVector());
         }
         setTableCustomerModel();
         }
        
         */
    }

    private void loadCustomer() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer cus = customerDAO.find(currentPurchase.getCusId().getCusID());
        currentCustomer = cus;
        fillCustomerFields();
    }

    private void loadAddresses() {
        AddressDAO addressDAO = new AddressDAO();
        addressTableList = new Vector<Address>();
        Vector<Address> addressList = addressDAO.findByCustomerId(currentCustomer.getCusID());
        currentShipAddress = addressDAO.find(currentPurchase.getAddDeliveryId().getAddId());
        currentInvoiceAddress = addressDAO.find(currentPurchase.getAddInvoiceId().getAddId());

        for (Address addr : addressList) {
            AddressTableItem addressTable = new AddressTableItem(addr);
            addressTableList.add(addressTable.getVector());
        }

        setTableAddressModel();

        for (int ligne = 0; ligne < tableInvoiceAdresses.getRowCount(); ligne++) {
            AddressTableItem addr = (AddressTableItem) tableInvoiceAdresses.getValueAt(ligne, 0);
            if (addr.getId() == currentInvoiceAddress.getAddId()) {
                tableInvoiceAdresses.changeSelection(ligne, 0, false, false);
                fillInvoiceAddressFields(currentInvoiceAddress);
            }
        }
        for (int ligne = 0; ligne < tableShipAddresses.getRowCount(); ligne++) {
            AddressTableItem addr = (AddressTableItem) tableShipAddresses.getValueAt(ligne, 0);
            if (addr.getId() == currentShipAddress.getAddId()) {
                tableShipAddresses.changeSelection(ligne, 0, false, false);
                fillDeliveryAddressFields(currentShipAddress);
            }
        }
    }

    private void fillInvoiceAddressFields(Address addr) {
        tfInvoiceLabel.setText(addr.getAddLabel());
        tfInvoiceFirstName.setText(addr.getAddFirstName());
        tfInvoiceLastName.setText(addr.getAddLastName());
        tfInvoiceCompany.setText(addr.getAddCompany());
        tfInvoiceStreetNumber.setText(addr.getAddNumber());
        tfInvoiceStreetName.setText(addr.getAddStreetName());
        tfInvoiceComplement.setText(addr.getAddComplement());
        tfInvoiceZipCode.setText(addr.getAddZipCode());
        tfInvoiceCity.setText(addr.getAddCity());

        String addressType = addr.getAddStreetType();
        int index = comboAdressModel.indexOf(RUE);
        Boolean isRue = (addressType.equalsIgnoreCase(RUE));
        Boolean isAvenue = (addressType.equalsIgnoreCase(AVENUE));
        Boolean isAllee = (addressType.equalsIgnoreCase(ALLEE));
        Boolean isBoulevad = (addressType.equalsIgnoreCase(BOULEVARD));
        Boolean isChemin = (addressType.equalsIgnoreCase(CHEMIN));
        Boolean isImpasse = (addressType.equalsIgnoreCase(IMPASSE));
        Boolean isLieuDit = (addressType.equalsIgnoreCase(LIEU_DIT));
        Boolean isRoute = (addressType.equalsIgnoreCase(ROUTE));

        if (isRue) {
            index = comboAdressModel.indexOf(RUE);
        }
        if (isAvenue) {
            index = comboAdressModel.indexOf(AVENUE);
        }
        if (isAllee) {
            index = comboAdressModel.indexOf(ALLEE);
        }
        if (isChemin) {
            index = comboAdressModel.indexOf(CHEMIN);
        }
        if (isBoulevad) {
            index = comboAdressModel.indexOf(BOULEVARD);
        }
        if (isImpasse) {
            index = comboAdressModel.indexOf(IMPASSE);
        }
        if (isLieuDit) {
            index = comboAdressModel.indexOf(LIEU_DIT);
        }
        if (isRoute) {
            index = comboAdressModel.indexOf(ROUTE);
        }
        comboInvoiceStreetType.setSelectedIndex(index);
    }

    private void fillDeliveryAddressFields(Address addr) {
        tfShipLabel.setText(addr.getAddLabel());
        tfShipFirstName.setText(addr.getAddFirstName());
        tfShipLastName.setText(addr.getAddLastName());
        tfShipCompany.setText(addr.getAddCompany());
        ftShipStreetNumber.setText(addr.getAddNumber());
        tfShipStreetName.setText(addr.getAddStreetName());
        tfShipComplement.setText(addr.getAddComplement());
        tfShipZipCode.setText(addr.getAddZipCode());
        tfShipCity.setText(addr.getAddCity());

        String addressType = addr.getAddStreetType();
        int index = comboAdressModel.indexOf(RUE);
        Boolean isRue = (addressType.equalsIgnoreCase(RUE));
        Boolean isAvenue = (addressType.equalsIgnoreCase(AVENUE));
        Boolean isAllee = (addressType.equalsIgnoreCase(ALLEE));
        Boolean isBoulevad = (addressType.equalsIgnoreCase(BOULEVARD));
        Boolean isChemin = (addressType.equalsIgnoreCase(CHEMIN));
        Boolean isImpasse = (addressType.equalsIgnoreCase(IMPASSE));
        Boolean isLieuDit = (addressType.equalsIgnoreCase(LIEU_DIT));
        Boolean isRoute = (addressType.equalsIgnoreCase(ROUTE));

        if (isRue) {
            index = comboAdressModel.indexOf(RUE);
        }
        if (isAvenue) {
            index = comboAdressModel.indexOf(AVENUE);
        }
        if (isAllee) {
            index = comboAdressModel.indexOf(ALLEE);
        }
        if (isChemin) {
            index = comboAdressModel.indexOf(CHEMIN);
        }
        if (isBoulevad) {
            index = comboAdressModel.indexOf(BOULEVARD);
        }
        if (isImpasse) {
            index = comboAdressModel.indexOf(IMPASSE);
        }
        if (isLieuDit) {
            index = comboAdressModel.indexOf(LIEU_DIT);
        }
        if (isRoute) {
            index = comboAdressModel.indexOf(ROUTE);
        }
        comboShipStreetType.setSelectedIndex(index);
    }

    private void loadOrderLineTable() {
        OrderLineDAO ordLineDAO = new OrderLineDAO();
        BookDAO bookDAO = new BookDAO();
        OrderLineTableItem ordItem;
        orderStatusTableList = new Vector();
        Vector<OrderLine> orderLineList = ordLineDAO.findByColumn(OrderLineNames.PURCHASE_ID, currentPurchase.getPurId());
        for (OrderLine ordline : orderLineList) {
            Book book = bookDAO.find(ordline.getBooIsbn13().getBooIsbn13());
            ordline.setBooIsbn13(book);
            ordItem = new OrderLineTableItem(ordline);
            orderStatusTableList.add(ordItem.getVector());
        }
        setTableOrderLineModel();
        calculatePrice();
    }

    private void calculatePrice() {
        ShippingCostDAO shippingCostDAO = new ShippingCostDAO();
        ShippingCost shipCostObject;
        Float totalHT = 0f;
        Float totalVAT = 0f;
        Float totalLinesTTC = 0f;
        Float shippingCost;
        Float totalOrderTTC;

        shipCostObject = shippingCostDAO.find(currentPurchase.getShippingCostId().getShipId());
        currentPurchase.setShippingCostId(shipCostObject);
        shippingCost = currentPurchase.getShippingCostId().getShipCost();

        for (int ligne = 0; ligne < tableOrderLine.getRowCount(); ligne++) {
            OrderLineTableItem ordLineTable = (OrderLineTableItem) tableOrderLine.getValueAt(ligne, 0);
            Float totalHTLine = ordLineTable.getPriceHT();
            Float priceTTCLine = ordLineTable.getPriceTTC();
            totalHT += totalHTLine;
            totalLinesTTC += priceTTCLine;
        }

        totalVAT = PriceCalculation.roundedPrice(totalLinesTTC - totalHT);
        totalOrderTTC = PriceCalculation.roundedPrice(totalLinesTTC + shippingCost);

        labelPriceHT.setText(String.valueOf(totalHT));
        labelTotalVAT.setText(String.valueOf(totalVAT));
        labelShippingCost.setText(String.valueOf(shippingCost));
        labelTotalOrderTTC.setText(String.valueOf(totalOrderTTC));
    }

    private void setTableOrderLineModel() {
        tableOrderLine.setModel(initTableOrderLineModel());
    }

    private DefaultTableModel initTableOrderLineModel() {
        Vector v = new Vector();
        v.add("ISBN");
        v.add("Titre");
        v.add("Quantité");
        v.add("Prix unit. HT");
        v.add("Total HT");
        v.add("TVA");
        v.add("Prix TTC");

        return new javax.swing.table.DefaultTableModel(orderStatusTableList, v) {
        };
    }

    private void fillCustomerFields() {
        tfCustomerFirstName.setText(currentCustomer.getCusFirstName().trim());
        tfCustomerLastName.setText(currentCustomer.getCusLastName().trim());
        if (currentCustomer.getCusOrganisationName() != null) {
            tfCustomerCompany.setText(currentCustomer.getCusOrganisationName().trim());
        }
        tfCustomerBirthDay.setText(currentCustomer.getCusDateOfBirth().toString().trim());
        tfCustomerPhoneNumber.setText(currentCustomer.getCusPhoneNumber());
        tfCustomerIP.setText(currentCustomer.getCusIP());
        tfCustomerComment.setText(currentCustomer.getCusComment());
        tfCustomerEmail.setText(currentCustomer.getCusEmail());
    }

    private void clearTableModels(Vector<JTable> jtableList) {
        DefaultTableModel tabModel;
        for (JTable table : jtableList) {
            tabModel = ((DefaultTableModel) table.getModel());
            int lignes = tabModel.getRowCount();
            for (int i = lignes - 1; i >= 0; i--) {
                tabModel.removeRow(i);
            }
        }
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
        jInternalFrame1 = new javax.swing.JInternalFrame();
        comboSearch = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSearchOrder = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSearchOrder = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNewOrder = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        tfSearch = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOrderLine = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfReference = new javax.swing.JTextField();
        tfOrderDate = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        btnPurchase = new javax.swing.JLabel();
        labelPriceHT = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        labelTotalVAT = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        labelShippingCost = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        labelTotalOrderTTC = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        comboPurchaseStatus = new javax.swing.JComboBox();
        jPanel18 = new javax.swing.JPanel();
        btnPurchase1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfInvoiceLastName = new javax.swing.JTextField();
        tfInvoiceComplement = new javax.swing.JTextField();
        tfInvoiceCompany = new javax.swing.JTextField();
        tfInvoiceZipCode = new javax.swing.JTextField();
        tfInvoiceStreetNumber = new javax.swing.JTextField();
        tfInvoiceFirstName = new javax.swing.JTextField();
        comboInvoiceStreetType = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        tfInvoiceStreetName = new javax.swing.JTextField();
        tfInvoiceCity = new javax.swing.JTextField();
        tfInvoiceLabel = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableInvoiceAdresses = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        btnNewInvoiceAdress = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnSaveInvoiceAddress = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        tfShipLastName = new javax.swing.JTextField();
        tfShipComplement = new javax.swing.JTextField();
        tfShipCompany = new javax.swing.JTextField();
        tfShipZipCode = new javax.swing.JTextField();
        ftShipStreetNumber = new javax.swing.JTextField();
        tfShipLabel = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableShipAddresses = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        tfShipFirstName = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btnNewShipAddress = new javax.swing.JLabel();
        comboShipStreetType = new javax.swing.JComboBox();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        tfShipStreetName = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btnSaveShip = new javax.swing.JLabel();
        tfShipCity = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        tfShipPhone = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        tfShipSecurityCode = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        tfShipperReference = new javax.swing.JTextField();
        tfShipperName = new javax.swing.JTextField();
        tfShipDate = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        btnNewAdress2 = new javax.swing.JLabel();
        panelPayment = new javax.swing.JPanel();
        tfPaySecurityNumber = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        panelPayExpirationDate = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        comboPayCardType = new javax.swing.JComboBox();
        tfPayCardNumber = new javax.swing.JTextField();
        tfPayOwner = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        tfCustomerLastName = new javax.swing.JTextField();
        tfCustomerFirstName = new javax.swing.JTextField();
        tfCustomerCompany = new javax.swing.JTextField();
        tfCustomerPhoneNumber = new javax.swing.JTextField();
        tfCustomerBirthDay = new javax.swing.JTextField();
        tfCustomerEmail = new javax.swing.JTextField();
        tfCustomerIP = new javax.swing.JTextField();
        comboCustomerStatus = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfCustomerComment = new javax.swing.JTextPane();
        jPanel11 = new javax.swing.JPanel();
        btnSaveCustomer = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setVisible(true);

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Référence ", "Date", "Nom client" }));

        jLabel5.setText("Recherche commande par :");

        tableSearchOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
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
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSearchOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableSearchOrderMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableSearchOrder);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSearchOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchOrder.setText("Rechercher");
        btnSearchOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSearchOrderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNewOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnNewOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewOrder.setText("Nouvelle commande");
        btnNewOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnNewOrderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfSearch)
                            .addComponent(comboSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tableOrderLine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Titre", "Quantité", "Prix unitaire HT", "T.V.A", "Prix H.T", "Prix T.T.C"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOrderLine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableOrderLineMouseReleased(evt);
            }
        });
        tableOrderLine.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableOrderLinePropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(tableOrderLine);

        jLabel2.setText("Date de commande :");

        jLabel1.setText("Référence :");

        jLabel6.setText("Frais de livraison :");

        jLabel34.setText("Prix total H.T :");

        jLabel35.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel35.setText("Prix total T.T.C :");

        jLabel36.setText("Prix total T.V.A :");

        jLabel13.setText("Statut :");

        jPanel16.setBackground(new java.awt.Color(51, 102, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(200, 45));

        btnPurchase.setForeground(new java.awt.Color(255, 255, 255));
        btnPurchase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPurchase.setText("Ajouter une ligne");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPurchase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        labelPriceHT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPriceHT.setText("888,88");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("€");

        labelTotalVAT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalVAT.setText("888,88");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("€");

        labelShippingCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelShippingCost.setText("888,88");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("€");

        labelTotalOrderTTC.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelTotalOrderTTC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalOrderTTC.setText("888,88");

        jLabel30.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("€");

        comboPurchaseStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel18.setBackground(new java.awt.Color(51, 102, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(200, 45));

        btnPurchase1.setForeground(new java.awt.Color(255, 255, 255));
        btnPurchase1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPurchase1.setText("Retirer une ligne");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPurchase1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPurchase1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfReference, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfOrderDate)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelTotalVAT, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                            .addComponent(labelPriceHT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labelTotalOrderTTC, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                            .addComponent(labelShippingCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addComponent(comboPurchaseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboPurchaseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(labelPriceHT)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(labelTotalVAT)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelShippingCost)
                            .addComponent(jLabel28)))
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(labelTotalOrderTTC)
                    .addComponent(jLabel30))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Commande", jPanel6);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("N° voie :");

        jLabel21.setText("Ville :");

        jLabel23.setText("Complément adresse :");

        jLabel16.setText("Prénom :");

        jLabel18.setText("Nom voie :");

        jLabel19.setText("Nom :");

        jLabel20.setText("Code postal :");

        jLabel22.setText("Nom Société :");

        comboInvoiceStreetType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "rue", "allée ", "avenue", "boulevard ", "chemin ", "route", "impasse", "lieu-dit" }));

        jLabel42.setText("Type :");

        tableInvoiceAdresses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nom label"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableInvoiceAdresses.setPreferredSize(new java.awt.Dimension(15, 160));
        tableInvoiceAdresses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableInvoiceAdressesMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tableInvoiceAdresses);

        jPanel13.setBackground(new java.awt.Color(51, 102, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNewInvoiceAdress.setForeground(new java.awt.Color(255, 255, 255));
        btnNewInvoiceAdress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewInvoiceAdress.setText("Créer une nouvelle Adresse");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewInvoiceAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewInvoiceAdress, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("Ajouter un label :");

        jPanel9.setBackground(new java.awt.Color(51, 102, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveInvoiceAddress.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveInvoiceAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveInvoiceAddress.setText("Enregister");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveInvoiceAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveInvoiceAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfInvoiceStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboInvoiceStreetType, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfInvoiceStreetName))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addGap(59, 59, 59)
                                                .addComponent(tfInvoiceLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel22)
                                                    .addComponent(jLabel16))
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfInvoiceCompany)
                                                    .addComponent(tfInvoiceFirstName))))
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(tfInvoiceLabel)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel23)
                                                        .addComponent(jLabel21))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfInvoiceZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfInvoiceComplement, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfInvoiceCity, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                        .addGap(36, 36, 36))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfInvoiceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(tfInvoiceLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tfInvoiceFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(tfInvoiceCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(tfInvoiceComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(tfInvoiceZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfInvoiceCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInvoiceStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(comboInvoiceStreetType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInvoiceStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Adresse facturation", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel46.setText("N° voie :");

        jLabel50.setText("Ville :");

        jLabel51.setText("Complément adresse :");

        tableShipAddresses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nom label"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableShipAddresses.setPreferredSize(new java.awt.Dimension(15, 160));
        tableShipAddresses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableShipAddressesMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tableShipAddresses);

        jLabel53.setText("Prénom :");

        jLabel54.setText("Nom voie :");

        jLabel55.setText("Nom :");

        jLabel56.setText("Code postal :");

        jLabel57.setText("Nom Société :");

        jPanel14.setBackground(new java.awt.Color(51, 102, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNewShipAddress.setForeground(new java.awt.Color(255, 255, 255));
        btnNewShipAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewShipAddress.setText("Nouveau label");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewShipAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewShipAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        comboShipStreetType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "rue", "allée ", "avenue", "boulevard ", "chemin ", "route", "impasse", "lieu-dit" }));

        jLabel58.setText("Type :");

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel60.setText("Ajouter un label :");

        jPanel10.setBackground(new java.awt.Color(51, 102, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveShip.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveShip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveShip.setText("Enregister");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveShip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveShip, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel33.setText("N° téléphone :");

        jLabel32.setText("Code sécurité :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel54))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(ftShipStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboShipStreetType, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfShipStreetName))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel55)
                                                .addGap(59, 59, 59)
                                                .addComponent(tfShipLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel57)
                                                    .addComponent(jLabel53))
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfShipCompany)
                                                    .addComponent(tfShipFirstName))))
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(tfShipLabel)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel56)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel51)
                                                        .addComponent(jLabel50)
                                                        .addComponent(jLabel33)
                                                        .addComponent(jLabel32))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tfShipZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                                        .addComponent(tfShipComplement, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                                        .addComponent(tfShipCity, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                                        .addComponent(tfShipPhone)
                                                        .addComponent(tfShipSecurityCode)))))))))
                        .addGap(27, 27, 27))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfShipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(tfShipLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(tfShipFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(tfShipCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(tfShipComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(tfShipZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfShipCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftShipStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(comboShipStreetType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel33)
                    .addComponent(tfShipPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfShipStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel32)
                    .addComponent(tfShipSecurityCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Adresse livraison", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setText("Nom :");

        jLabel39.setText("Date d'expédition :");

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Type de Livraison :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfShipperReference, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(73, 73, 73)
                        .addComponent(tfShipperName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(6, 6, 6)
                        .addComponent(tfShipDate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfShipDate, tfShipperName, tfShipperReference});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(tfShipperReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(tfShipperName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(tfShipDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfShipDate, tfShipperName, tfShipperReference});

        jTabbedPane1.addTab("Transporteur", jPanel8);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 100));

        jPanel17.setBackground(new java.awt.Color(51, 102, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNewAdress2.setForeground(new java.awt.Color(255, 255, 255));
        btnNewAdress2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewAdress2.setText("Payer et passer la commande");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewAdress2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewAdress2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        panelPayment.setBackground(new java.awt.Color(255, 255, 255));
        panelPayment.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfPaySecurityNumber.setText("123");

        jLabel61.setText("CVS");

        jLabel37.setText("Date expiration");

        panelPayExpirationDate.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelPayExpirationDateLayout = new javax.swing.GroupLayout(panelPayExpirationDate);
        panelPayExpirationDate.setLayout(panelPayExpirationDateLayout);
        panelPayExpirationDateLayout.setHorizontalGroup(
            panelPayExpirationDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );
        panelPayExpirationDateLayout.setVerticalGroup(
            panelPayExpirationDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jLabel31.setText("Numéro :");

        jLabel45.setText("Type carte :");

        comboPayCardType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Visa", "MasterCard", "AmericanExpress", "Paypal" }));

        tfPayCardNumber.setText("1234567891234567891");
        tfPayCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPayCardNumberActionPerformed(evt);
            }
        });

        jLabel62.setText("Titulaire :");

        javax.swing.GroupLayout panelPaymentLayout = new javax.swing.GroupLayout(panelPayment);
        panelPayment.setLayout(panelPaymentLayout);
        panelPaymentLayout.setHorizontalGroup(
            panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPaymentLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(panelPayExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPaymentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel45)
                        .addComponent(jLabel31)
                        .addComponent(jLabel37)
                        .addComponent(jLabel62)
                        .addComponent(jLabel61))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfPaySecurityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPayOwner)
                            .addComponent(tfPayCardNumber)
                            .addComponent(comboPayCardType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(91, Short.MAX_VALUE)))
        );
        panelPaymentLayout.setVerticalGroup(
            panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPaymentLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(panelPayExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPaymentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPayOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(comboPayCardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPayCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel61)
                        .addComponent(tfPaySecurityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(panelPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(panelPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Paiement", jPanel12);

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Sous-titre", "ISBN", "Auteur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jLabel29.setText("Recherche livre par :");

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ISBN", "Titre", "Auteur" }));

        jPanel19.setBackground(new java.awt.Color(51, 102, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveCustomer1.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveCustomer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveCustomer1.setText("Ajouter article");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveCustomer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveCustomer1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(51, 102, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSearchOrder1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchOrder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchOrder1.setText("Rechercher");
        btnSearchOrder1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchOrder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSearchOrder1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearchOrder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxSearch, 0, 149, Short.MAX_VALUE)
                                .addComponent(jSeparator3)
                                .addComponent(tfSearch1)
                                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                            .addComponent(jLabel29))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Ajouter article", jPanel7);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 244, 641, -1));

        jLabel8.setText("Nom :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 12, -1, -1));

        jLabel9.setText("Prénom :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 46, -1, -1));

        jLabel10.setText("Nom société :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 80, -1, -1));

        jLabel41.setText("Statut :");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 79, -1, -1));

        jLabel14.setText("Date de naissance :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 114, -1, -1));

        jLabel12.setText("Adresse IP :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 46, -1, -1));

        jLabel11.setText("Numéro téléphone :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 148, -1, -1));

        jLabel15.setText("Email :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 12, -1, -1));

        jLabel40.setText("Commentaire :");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 114, -1, -1));
        jPanel1.add(tfCustomerLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 6, 179, -1));
        jPanel1.add(tfCustomerFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 40, 179, -1));
        jPanel1.add(tfCustomerCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 74, 179, -1));
        jPanel1.add(tfCustomerPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 142, 179, -1));
        jPanel1.add(tfCustomerBirthDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 108, 179, -1));
        jPanel1.add(tfCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 6, 179, -1));
        jPanel1.add(tfCustomerIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 40, 179, -1));

        comboCustomerStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Actif", "Inactif", "BlackListé" }));
        jPanel1.add(comboCustomerStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 74, 179, -1));

        jScrollPane3.setViewportView(tfCustomerComment);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 114, 179, 62));

        jPanel11.setBackground(new java.awt.Color(51, 102, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveCustomer.setText("Enregistrer");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCustomerCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCustomerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCustomerLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCustomerBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCustomerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel41)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel40)
                                            .addComponent(jLabel15))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane3)
                                            .addComponent(tfCustomerIP, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfCustomerEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboCustomerStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCustomerIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(comboCustomerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfCustomerLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfCustomerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfCustomerCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tfCustomerBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfCustomerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewOrderMouseReleased

        System.out.println(evt.getButton());
    }//GEN-LAST:event_btnNewOrderMouseReleased

    private void btnSearchOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchOrderMouseReleased
        searchForOrder();

    }//GEN-LAST:event_btnSearchOrderMouseReleased

    private void tableSearchOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchOrderMouseReleased
        Vector tabToClear = new Vector();
        tabToClear.add(tableInvoiceAdresses);
        tabToClear.add(tableShipAddresses);
        tabToClear.add(tableOrderLine);
        clearTableModels(tabToClear);

        for (int ligne = 0; ligne < tableSearchOrder.getRowCount(); ligne++) {
            if (tableSearchOrder.isRowSelected(ligne)) {
                if ((PurchaseTableItem) tableSearchOrder.getValueAt(ligne, 0) != null) {
                    PurchaseTableItem purTable = (PurchaseTableItem) tableSearchOrder.getValueAt(ligne, 0);
                    currentPurchase = purTable.getPurchase();
                    loadCustomer();
                    loadOrderLineTable();
                    loadAddresses();
                    loadPurchaseInfos();
                }
            }
        }
    }//GEN-LAST:event_tableSearchOrderMouseReleased

    private void tfPayCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPayCardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPayCardNumberActionPerformed

    private void tableOrderLineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrderLineMouseReleased

    }//GEN-LAST:event_tableOrderLineMouseReleased

    private void tableOrderLinePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tableOrderLinePropertyChange
        for (int ligne = 0; ligne < tableOrderLine.getRowCount(); ligne++) {
            if (tableOrderLine.isRowSelected(ligne)) {
                for (int column = 0; column < tableOrderLine.getColumnCount(); column++) {
                    if (tableOrderLine.isColumnSelected(column)) {
                        System.out.println(tableOrderLine.getValueAt(ligne, column).toString().trim());

                        /////
                        ((DefaultTableModel)tableOrderLine.getModel()).fireTableDataChanged();
                        ////
                    }
                }
            }

        }
    }//GEN-LAST:event_tableOrderLinePropertyChange

    private void tableShipAddressesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShipAddressesMouseReleased
        for (int ligne = 0; ligne < tableShipAddresses.getRowCount(); ligne++) {
            if (tableShipAddresses.isRowSelected(ligne)) {
                AddressTableItem addressTable = (AddressTableItem) tableShipAddresses.getValueAt(ligne, 0);
                currentShipAddress = addressTable.getAddress();
                System.out.println(currentShipAddress);
                fillDeliveryAddressFields(currentShipAddress);
            }
        }
    }//GEN-LAST:event_tableShipAddressesMouseReleased

    private void tableInvoiceAdressesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInvoiceAdressesMouseReleased
        for (int ligne = 0; ligne < tableInvoiceAdresses.getRowCount(); ligne++) {
            if (tableInvoiceAdresses.isRowSelected(ligne)) {
                AddressTableItem addressTable = (AddressTableItem) tableInvoiceAdresses.getValueAt(ligne, 0);
                currentInvoiceAddress = addressTable.getAddress();
                System.out.println(currentInvoiceAddress);
                fillInvoiceAddressFields(currentInvoiceAddress);
            }
        }
    }//GEN-LAST:event_tableInvoiceAdressesMouseReleased

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
            java.util.logging.Logger.getLogger(JFPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPurchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnNewAdress2;
    private javax.swing.JLabel btnNewInvoiceAdress;
    private javax.swing.JLabel btnNewOrder;
    private javax.swing.JLabel btnNewShipAddress;
    private javax.swing.JLabel btnPurchase;
    private javax.swing.JLabel btnPurchase1;
    private javax.swing.JLabel btnSaveCustomer;
    private javax.swing.JLabel btnSaveInvoiceAddress;
    private javax.swing.JLabel btnSaveShip;
    private javax.swing.JLabel btnSearchOrder;
    private javax.swing.JLabel btnSearchOrder1;
    private javax.swing.JComboBox comboCustomerStatus;
    private javax.swing.JComboBox comboInvoiceStreetType;
    private javax.swing.JComboBox comboPayCardType;
    private javax.swing.JComboBox comboSearch;
    private javax.swing.JComboBox comboShipStreetType;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JTextField ftShipStreetNumber;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelPriceHT;
    private javax.swing.JLabel labelShippingCost;
    private javax.swing.JLabel labelTotalOrderTTC;
    private javax.swing.JLabel labelTotalVAT;
    private javax.swing.JPanel panelPayExpirationDate;
    private javax.swing.JPanel panelPayment;
    private javax.swing.JTable tableInvoiceAdresses;
    private javax.swing.JTable tableOrderLine;
    private javax.swing.JTable tableSearchOrder;
    private javax.swing.JTable tableShipAddresses;
    private javax.swing.JTextField tfCustomerBirthDay;
    private javax.swing.JTextPane tfCustomerComment;
    private javax.swing.JTextField tfCustomerCompany;
    private javax.swing.JTextField tfCustomerEmail;
    private javax.swing.JTextField tfCustomerFirstName;
    private javax.swing.JTextField tfCustomerIP;
    private javax.swing.JTextField tfCustomerLastName;
    private javax.swing.JTextField tfCustomerPhoneNumber;
    private javax.swing.JTextField tfInvoiceCity;
    private javax.swing.JTextField tfInvoiceCompany;
    private javax.swing.JTextField tfInvoiceComplement;
    private javax.swing.JTextField tfInvoiceFirstName;
    private javax.swing.JTextField tfInvoiceLabel;
    private javax.swing.JTextField tfInvoiceLastName;
    private javax.swing.JTextField tfInvoiceStreetName;
    private javax.swing.JTextField tfInvoiceStreetNumber;
    private javax.swing.JTextField tfInvoiceZipCode;
    private javax.swing.JTextField tfOrderDate;
    private javax.swing.JTextField tfPayCardNumber;
    private javax.swing.JTextField tfPayOwner;
    private javax.swing.JTextField tfPaySecurityNumber;
    private javax.swing.JTextField tfReference;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfShipCity;
    private javax.swing.JTextField tfShipCompany;
    private javax.swing.JTextField tfShipComplement;
    private javax.swing.JTextField tfShipDate;
    private javax.swing.JTextField tfShipFirstName;
    private javax.swing.JTextField tfShipLabel;
    private javax.swing.JTextField tfShipLastName;
    private javax.swing.JTextField tfShipPhone;
    private javax.swing.JTextField tfShipSecurityCode;
    private javax.swing.JTextField tfShipStreetName;
    private javax.swing.JTextField tfShipZipCode;
    private javax.swing.JTextField tfShipperName;
    private javax.swing.JTextField tfShipperReference;
    // End of variables declaration//GEN-END:variables
}
