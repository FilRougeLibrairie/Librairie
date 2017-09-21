
package ui.jfCustomer;

import ClassObjet.Address;
import ClassObjet.Book;
import ClassObjet.Customer;
import ClassObjet.Purchase;
import ClassObjet.Review;
import ClassObjet.StatusDisplay;
import Names.SQLNames;
import SQLS.AddressDAO;
import SQLS.BookDAO;
import SQLS.CustomerDAO;
import SQLS.PurchaseDAO;
import SQLS.ReviewDAO;
import SQLS.StatusDisplayDAO;
import exceptions.CryptoException;
import exceptions.MissingInformationException;
import exceptions.NoCurrentCustomerException;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import utils.Awt1;
import utils.Crypto;
import utils.DateLabelFormatter;


public class CustomerPanel extends javax.swing.JPanel implements SQLNames {

    Vector<Customer> customerList;
    Vector customerTableList;
    Vector addressTableList;
    Vector orderTableList;
    Vector reviewTableList;
    Vector<String> comboAdressModel;
    Vector<String> comboSearchModel;
    Vector<String> comboStatusModel;
    Vector<String> comboGenderModel;
    Vector<String> comboRevStatusModel;
    Customer currentCustomer;
    Address currentAddress;
    Review currentReview;
    JDatePickerImpl datePicker;

    private final String DELETED_MENTION = "SUPPRIME";
    private final String DELETED_NAME_MASK = "***";
    private final String DELETED_DATE_MASK = "1970-01-01";
    private final String DELETED_PHONE_MASK = "0123456789";
    private final String DELETED_EMAIL_MASK = "deleted@deleted.com";
    private final String DELETED_ZIPCODE = "88888";

    private final String RUE = "Rue";
    private final String AVENUE = "Avenue";
    private final String ALLEE = "Allée";
    private final String BOULEVARD = "Boulevard";
    private final String CHEMIN = "Chemin";
    private final String ROUTE = "Route";
    private final String IMPASSE = "Impasse";
    private final String LIEU_DIT = "Lieu-dit";

    private class ErrorMessages {

        public static final String IS_EMPTY = "Ce champs est obligatoire";
        public static final String EMPTY_PASSWORD = "Le mot de passe est obligatoire";
        public static final String CRYPTO = "Un problème de génération du mot de passe est survenu";
    }

    private enum Gender {

        MALE("Homme"),
        FEMALE("Femme");
        private final String databaseName;

        private Gender(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    private enum Status {

        INACTIVE("Inactif"),
        ACTIVE("Actif"),
        DELETED("Supprimé");
        private final String databaseName;

        private Status(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    private enum ReviewStatus {

        PENDING("En attente", 2),
        VALIDATED("Validé", 3),
        REJECTED("Rejeté", 4);
        private final String databaseName;
        private final int databaseCode;

        private ReviewStatus(String databaseName, int order) {
            this.databaseName = databaseName;
            this.databaseCode = order;
        }

        public String getDatabaseName() {
            return databaseName;
        }

        public int getDatabaseCode() {
            return databaseCode;
        }
    }

    private enum SearchCriteria {

        TOUS_LES_CLIENTS("Tous les clients"),
        NOM("Nom"),
        PRENOM("Prénom"),
        SOCIETE("Société"),
        EMAIL("Email"),
        TELEPHONE("Téléphone"),
        IP("Adresse IP"),
        STATUS("Status"),
        GENDER("Genre");
        private final String databaseName;

        private SearchCriteria(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    // Constructor
    public CustomerPanel() {
        initComponents();

        tableCustomers.setCellSelectionEnabled(true);
        tableOrders.setAutoCreateRowSorter(true);
        tableReview.setAutoCreateRowSorter(true);
        comboDeliverStreetType.setModel(initAddressComboBoxModel());
        comboDeliverStreetType.setSelectedIndex(0);
        comboSearch.setModel(initComboSearchModel());
        comboSearch.setSelectedIndex(0);
        comboStatus.setModel(initComboStatusModel());
        comboStatus.setSelectedIndex(0);
        comboGender.setModel(initComboGenderModel());
        comboGender.setSelectedIndex(0);
        comboRevStatus.setModel(initComboRevStatusModelModel());
        comboRevStatus.setSelectedIndex(0);
        labelErrorMessage.setVisible(false);
        labelCustomerID.setText("");

        panBtnDeleteCustomer.setVisible(false);
        panBtnDeleteAddress.setVisible(false);

        panelSearchByReviewStatus.setVisible(false);

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
        panelDate.setSize(100, 100);
        panelDate.add(datePicker);

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

    private DefaultComboBoxModel initComboSearchModel() {
        DefaultComboBoxModel model;
        comboSearchModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboSearchModel);
        for (SearchCriteria comboItem : SearchCriteria.values()) {
            comboSearchModel.add(comboItem.getDatabaseName());
        }
        return model;
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

    private DefaultComboBoxModel initComboStatusModel() {
        DefaultComboBoxModel model;
        comboStatusModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboStatusModel);
        for (Status comboItem : Status.values()) {
            comboStatusModel.add(comboItem.getDatabaseName());
        }
        return model;
    }

    private DefaultComboBoxModel initComboRevStatusModelModel() {
        DefaultComboBoxModel model;
        comboRevStatusModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboRevStatusModel);
        for (ReviewStatus comboItem : ReviewStatus.values()) {
            comboRevStatusModel.add(comboItem.getDatabaseName());
        }
        return model;
    }

    private DefaultComboBoxModel initComboGenderModel() {
        DefaultComboBoxModel model;
        comboGenderModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboGenderModel);
        for (Gender comboItem : Gender.values()) {
            comboGenderModel.add(comboItem.getDatabaseName());
        }
        return model;
    }

    private void setTableCustomerModel() {
        tableCustomers.setModel(initTableCustomersModel());
    }

    private DefaultTableModel initTableCustomersModel() {
        Vector v = new Vector();
        v.add("Résultats");
        return new javax.swing.table.DefaultTableModel(customerTableList, v) {
        };
    }

    private void setTableAddressModel() {
        tableDeliverAdresses.setModel(initTableAddressModel());
    }

    private DefaultTableModel initTableAddressModel() {
        Vector v = new Vector();
        v.add("Nom Label");
        return new javax.swing.table.DefaultTableModel(addressTableList, v) {
        };
    }

    private void setTableOrdersModel() {
        tableOrders.setModel(initTableOrdersModel());
    }

    private DefaultTableModel initTableOrdersModel() {
        Vector v = new Vector();
        v.add("Date");
        v.add("Référence");
        v.add("Status");

        return new javax.swing.table.DefaultTableModel(orderTableList, v) {
        };
    }

    private void setTableReviewModel() {
        tableReview.setModel(initTableReviewModel());
    }

    private DefaultTableModel initTableReviewModel() {
        Vector v = new Vector();
        v.add("Date");
        v.add("Status");
        v.add("Note");
        return new javax.swing.table.DefaultTableModel(reviewTableList, v) {
        };
    }

    private void fillAddressFields(Address addr) {

        tfDeliverLabel.setText(addr.getAddLabel());
        tfDeliverFirstName.setText(addr.getAddFirstName());
        tfDeliverLastName.setText(addr.getAddLastName());
        tfDeliverCompany.setText(addr.getAddCompany());
        tfDeliverStreetNumber.setText(addr.getAddNumber());
        tfDeliverStreetName.setText(addr.getAddStreetName());
        tfDeliverStreetComplement.setText(addr.getAddComplement());
        tfDeliverZipCode.setText(addr.getAddZipCode());
        tfDeliverCity.setText(addr.getAddCity());
        tfDeliverSecurityCode.setText(addr.getAddSecurityCode());
        tfDeliverPhoneNumber.setText(addr.getAddPhone());

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
        comboDeliverStreetType.setSelectedIndex(index);
    }

    private void fillCustomerFields(Customer cus) {
        String gender = cus.getCusGender().trim();
        Boolean isMale = gender.equalsIgnoreCase(Gender.MALE.getDatabaseName().substring(0, 1));
        Boolean isFemale = gender.equalsIgnoreCase(Gender.FEMALE.getDatabaseName().substring(0, 1));

        if (isMale) {
            comboGender.setSelectedIndex(Gender.MALE.ordinal());
        } else if (isFemale) {
            comboGender.setSelectedIndex(Gender.FEMALE.ordinal());
        }

        int status = cus.getCusStatus();
        int index = Status.ACTIVE.ordinal();
        Boolean isActive = (status == Status.ACTIVE.ordinal());
        Boolean isInactive = (status == Status.INACTIVE.ordinal());
        Boolean isDeleted = (status == Status.DELETED.ordinal());

        if (isActive) {
            index = Status.ACTIVE.ordinal();
        }
        if (isInactive) {
            index = Status.INACTIVE.ordinal();
        }
        if (isDeleted) {
            index = Status.DELETED.ordinal();
        }
        comboStatus.setSelectedIndex(index);

        labelCustomerID.setText(String.valueOf(cus.getCusID()));
        tfLastName.setText(cus.getCusLastName());
        tfFirstName.setText(cus.getCusFirstName());
        tfCompany.setText(cus.getCusOrganisationName());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlBirth = new java.sql.Date(cus.getCusDateOfBirth().getTime());
        String dateOfBirth = df.format(sqlBirth);

        tfBirthday.setText(dateOfBirth);
        tfPhone.setText(cus.getCusPhoneNumber());
        tfEmail.setText(cus.getCusEmail());
        tfIPAdress.setText(cus.getCusIP());
        tfComment.setText(cus.getCusComment());
        tfPassword.setText("");

    }

    private void loadingAdressTable(Customer cus) {
        AddressDAO addressDAO = new AddressDAO();
        Vector<Address> addressList = new Vector<Address>();
        addressList = addressDAO.findByCustomerId(cus.getCusID());
        addressTableList = new Vector();

        for (Address addr : addressList) {
            AddressTableItem addressTable = new AddressTableItem(addr);
            addressTableList.add(addressTable.getVector());
        }
        setTableAddressModel();
    }

    private void loadingOrderTable(Customer cus) {
        PurchaseDAO purchaseDAO = new PurchaseDAO();
        Vector<Purchase> orderList = new Vector<Purchase>();
        orderList = purchaseDAO.findByCustomerId(cus.getCusID());
        orderTableList = new Vector();
        
        for (Purchase pur : orderList) {
            // Retrieving OrderStatusList
            try {
                pur.setOrderstatusList(purchaseDAO.findAllOrderStatus(pur.getPurId()));
                OrderTableItem orderTable = new OrderTableItem(pur);
                orderTableList.add(orderTable.getVector());
            } catch (Exception ex) {
                System.out.println("Nothing to display");
            }
        }
        setTableOrdersModel();
    }

    private void loadingReviewTable() {
        ReviewDAO reviewDAO = new ReviewDAO();
        StatusDisplayDAO sdDAO = new StatusDisplayDAO();
        BookDAO bookDAO = new BookDAO();
        Vector<Review> reviewList = new Vector<Review>();
        ReviewTableItem reviewTableItem;
        StatusDisplay statusDisplay;

        reviewList = reviewDAO.findByColumn(SQLNames.ReviewNames.CUSTOMER_ID, currentCustomer.getCusID());
        reviewTableList = new Vector();

        for (Review rev : reviewList) {
            Vector<Book> v = bookDAO.findByColumn(SQLNames.BookNames.ISBN_13, rev.getBooIsbn13());
            for (Book book : v) {
                rev.setBook(book);
            }

            reviewTableItem = new ReviewTableItem(rev);
            statusDisplay = new StatusDisplay();
            statusDisplay = sdDAO.find(rev.getRevStatus());
            reviewTableItem.setStatusName(statusDisplay.getStaName());
            reviewTableList.add(reviewTableItem.getVector());
        }
        setTableReviewModel();
    }

    private void clearCustomerFields() {
        tfLastName.setText("");
        tfFirstName.setText("");
        tfCompany.setText("");
        tfBirthday.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
        tfPassword.setText("");
        tfIPAdress.setText("");
        tfComment.setText("");
        labelCustomerID.setText("");
    }

    private void clearAddressFields() {
        tfDeliverCity.setText("");
        tfDeliverCompany.setText("");
        tfDeliverFirstName.setText("");
        tfDeliverLabel.setText("");
        tfDeliverLastName.setText("");
        tfDeliverPhoneNumber.setText("");
        tfDeliverSecurityCode.setText("");
        tfDeliverStreetComplement.setText("");
        tfDeliverStreetName.setText("");
        tfDeliverStreetNumber.setText("");
        tfDeliverZipCode.setText("");
    }

    private void customerFactory() throws NoSuchAlgorithmException, CryptoException, MissingInformationException {
        Customer cus;
        if (currentCustomer == null) {
            cus = new Customer();
        } else {
            cus = currentCustomer;
        }

        cus.setCusLastName(tfLastName.getText().trim());
        cus.setCusFirstName(tfFirstName.getText().trim());
        cus.setCusOrganisationName(tfCompany.getText().trim());
        cus.setCusPhoneNumber(tfPhone.getText().trim());
        cus.setCusEmail(tfEmail.getText().trim());
        cus.setCusIP(tfIPAdress.getText().trim());
        cus.setCusComment(tfComment.getText().trim());
        cus.setCusGender(comboGender.getSelectedItem().toString());
        cus.setCusStatus(comboStatus.getSelectedIndex());

        if (tfBirthday.getText() != null) {
            cus.setCusDateOfBirth(tfBirthday.getText().trim());
        }

        if (currentCustomer == null && tfPassword.getPassword().length == 0) {
            throw new MissingInformationException(ErrorMessages.IS_EMPTY);
        } else if (tfPassword.getPassword().length > 0) {
            String str = new String(tfPassword.getPassword());
            String[] password = Crypto.createPassword(new String(tfPassword.getPassword()));
            cus.setCusPassword(password[0]);
            cus.setCusSalt(password[1]);
        } else {
            System.out.println("OK : Je suis un client connu qui ne change pas de mot de passe");
        }

        if (tfPassword.getPassword().toString().isEmpty()) {
            manageInputError(true, "tfPassword", "btnSaveCustomer", ErrorMessages.IS_EMPTY);
        } else {
            manageInputError(false, "tfPassword", "btnSaveCustomer", ErrorMessages.IS_EMPTY);
        }

        CustomerDAO customerDAO = new CustomerDAO();
        if (currentCustomer == null) {
            customerDAO.create(cus);
        } else {
            customerDAO.update(cus);
        }
        clearCustomerFields();
        customerDAO.findAll();
        clearTableModels(customerTableList);
    }

    private void addressFactory() throws NoCurrentCustomerException {
        Address addr;
        if (currentAddress == null) {
            addr = new Address();
        } else {
            addr = currentAddress;
        }
        addr.setCusResidId(currentCustomer);
        addr.setCusChargeId(currentCustomer);
        addr.setAddCity(tfDeliverCity.getText().trim());
        addr.setAddCompany(tfDeliverCompany.getText().trim());
        addr.setAddFirstName(tfDeliverFirstName.getText().trim());
        addr.setAddLabel(tfDeliverLabel.getText().trim());
        addr.setAddLastName(tfDeliverLastName.getText().trim());
        addr.setAddPhone(tfDeliverPhoneNumber.getText().trim());
        addr.setAddSecurityCode(tfDeliverSecurityCode.getText().trim());
        addr.setAddComplement(tfDeliverStreetComplement.getText().trim());
        addr.setAddNumber(tfDeliverStreetNumber.getText().trim());
        addr.setAddStreetName(tfDeliverStreetName.getText().trim());
        addr.setAddStreetType(tfDeliverStreetNumber.getText().trim());
        addr.setAddZipCode(tfDeliverZipCode.getText().trim());
        addr.setAddStreetType(comboDeliverStreetType.getSelectedItem().toString().trim());

        AddressDAO addressDAO = new AddressDAO();
        if (currentCustomer == null) {
            addressDAO.create(addr);
        } else {
            addressDAO.update(addr);
        }
        addressDAO.findByCustomerId(currentCustomer.getCusID());
        tableDeliverAdresses.setModel(initTableAddressModel());
        clearAddressFields();
    }

    private void reviewFactory() {
        ReviewDAO reviewDAO = new ReviewDAO();
        int revStatusCode;
        currentReview.setCusId(currentReview.getCusId());
        currentReview.setBooIsbn13(currentReview.getBooIsbn13());
        currentReview.setOrdLineId(currentReview.getOrdLineId());
        currentReview.setRevNote(currentReview.getRevNote());
        currentReview.setRevDate(currentReview.getRevDate().toString());
        currentReview.setRevIP(currentReview.getRevIP());
        currentReview.setRevComment(tfReview.getText().trim());
        if (rbtnValidated.isSelected()) {
            revStatusCode = ReviewStatus.VALIDATED.getDatabaseCode();
        } else if (rbtnRejected.isSelected()) {
            revStatusCode = ReviewStatus.REJECTED.getDatabaseCode();
        } else {
            revStatusCode = ReviewStatus.PENDING.getDatabaseCode();
        }
        currentReview.setRevStatus(revStatusCode);

        reviewDAO.update(currentReview);
    }

    private void searchForCustomer() {
        if (comboSearch.getSelectedItem() != null) {
            String criteria = comboSearch.getSelectedItem().toString();
            String term = tfSearch.getText().trim();
            int statusIndex;
            customerList = new Vector<Customer>();
            CustomerDAO customerDAO = new CustomerDAO();

            if (criteria.equalsIgnoreCase(SearchCriteria.TOUS_LES_CLIENTS.getDatabaseName())) {
                customerList = customerDAO.findAll();
            } else if (criteria.equalsIgnoreCase(SearchCriteria.STATUS.getDatabaseName())) {
                criteria = SQLNames.CustomerNames.STATUS;
                statusIndex = comboStatus.getSelectedIndex();
                customerList = customerDAO.findByColumn(criteria, statusIndex);
            } else if (criteria.equalsIgnoreCase(SearchCriteria.GENDER.getDatabaseName())) {
                criteria = SQLNames.CustomerNames.GENDER;
                term = comboGender.getSelectedItem().toString().substring(0, 1).trim();
                customerList = customerDAO.findByColumn(criteria, term);
            } else if (term != null && !term.isEmpty()) {
                if (criteria.equalsIgnoreCase(SearchCriteria.NOM.getDatabaseName())) {
                    criteria = SQLNames.CustomerNames.LAST_NAME;
                } else if (criteria.equalsIgnoreCase(SearchCriteria.PRENOM.getDatabaseName())) {
                    criteria = SQLNames.CustomerNames.FIRST_NAME;
                } else if (criteria.equalsIgnoreCase(SearchCriteria.SOCIETE.getDatabaseName())) {
                    criteria = SQLNames.CustomerNames.COMPANY;
                } else if (criteria.equalsIgnoreCase(SearchCriteria.EMAIL.getDatabaseName())) {
                    criteria = SQLNames.CustomerNames.EMAIL;
                } else if (criteria.equalsIgnoreCase(SearchCriteria.TELEPHONE.getDatabaseName())) {
                    criteria = SQLNames.CustomerNames.PHONE;
                } else if (criteria.equalsIgnoreCase(SearchCriteria.IP.getDatabaseName())) {
                    criteria = SQLNames.CustomerNames.IP;
                } else if (criteria.equalsIgnoreCase(SearchCriteria.STATUS.getDatabaseName())) {
                    criteria = SQLNames.CustomerNames.STATUS;
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

    private void clearFields() {
        labelBookISBN.setText("");
        labelBookTitle.setText("");
        tfReview.setText("");
    }

    private void deleteCustomer() throws NoSuchAlgorithmException, CryptoException {
        comboStatus.setSelectedIndex(Status.DELETED.ordinal());
        tfLastName.setText(DELETED_NAME_MASK);
        tfFirstName.setText(DELETED_NAME_MASK);
        tfCompany.setText("");
        tfBirthday.setText(DELETED_DATE_MASK);
        tfPhone.setText(DELETED_PHONE_MASK);
        tfEmail.setText(DELETED_EMAIL_MASK);
        tfIPAdress.setText("");
        tfComment.setText("");
        tfPassword.setText("");
    }

    private void deleteAddress() {
        tfDeliverLabel.setText(DELETED_MENTION);
        tfDeliverFirstName.setText(DELETED_NAME_MASK);
        tfDeliverLastName.setText(DELETED_NAME_MASK);
        tfDeliverCompany.setText("");
        tfDeliverStreetNumber.setText("");
        tfDeliverStreetName.setText(DELETED_NAME_MASK);
        tfDeliverStreetComplement.setText("");
        tfDeliverZipCode.setText(DELETED_ZIPCODE);
        tfDeliverCity.setText("");
        tfDeliverSecurityCode.setText("");
        tfDeliverPhoneNumber.setText(DELETED_PHONE_MASK);
    }

    private void manageInputError(Boolean ErrorState, String component, String btnToDisable, String errorMessage) {
//        Component btn = Awt1.getComponentByName(this, btnToDisable);
//        Component tf = Awt1.getComponentByName(this, component);
//
//        if (ErrorState) {
//            labelErrorMessage.setText(errorMessage);
//            labelErrorMessage.setVisible(true);
//            btn.setVisible(false);
//            tf.setBackground(new Color(255, 0, 0, 15));
//        } else {
//            labelErrorMessage.setText("");
//            labelErrorMessage.setVisible(false);
//            btn.setVisible(true);
//            tf.setBackground(Color.WHITE);
//        }
        
        System.out.println("auboulot******************************************************************");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        tfLastName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSaveCustomer = new javax.swing.JLabel();
        tfCompany = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfBirthday = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPhone = new javax.swing.JTextField();
        tfFirstName = new javax.swing.JTextField();
        tfIPAdress = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        tfDeliverStreetComplement = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        comboDeliverStreetType = new javax.swing.JComboBox();
        tfDeliverStreetName = new javax.swing.JTextField();
        tfDeliverCompany = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        tfDeliverLastName = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        tfDeliverStreetNumber = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfDeliverZipCode = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tfDeliverCity = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tfDeliverFirstName = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfDeliverSecurityCode = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        tfDeliverPhoneNumber = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDeliverAdresses = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        btnNewAdress = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnSaveDeliver = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        tfDeliverLabel = new javax.swing.JTextField();
        panBtnDeleteAddress = new javax.swing.JPanel();
        btnDeleteAddress = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOrders = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        btnView = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReview = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfReview = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        btnSaveReview = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        rbtnValidated = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rbtnRejected = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        labelBookISBN = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        labelBookTitle = new javax.swing.JLabel();
        panelSearchByReviewStatus = new javax.swing.JPanel();
        comboRevStatus = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfInvoiceLastName = new javax.swing.JTextField();
        tfInvoiceStreetName = new javax.swing.JTextField();
        tfInvoiceCompany = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnSaveInvoiceAdress = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        tfInvoiceLabel = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabletfInvoiceAdresses = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btnNewAdress2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        panelDate = new javax.swing.JPanel();
        tfPassword = new javax.swing.JPasswordField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        comboGender = new javax.swing.JComboBox();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bntCreateNew = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        comboSearch = new javax.swing.JComboBox();
        tfSearch = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tfComment = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        labelCustomerID = new javax.swing.JLabel();
        labelErrorMessage = new javax.swing.JLabel();
        panBtnDeleteCustomer = new javax.swing.JPanel();
        btnDeleteCustomer = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 630));

        tfLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastNameActionPerformed(evt);
            }
        });
        tfLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfLastNameKeyReleased(evt);
            }
        });

        jLabel13.setText("Genre :");

        jLabel11.setText("Mot de passe :");

        jLabel12.setText("N° téléphone :");

        jLabel9.setText("Nom Société :");

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanel1.setRequestFocusEnabled(false);

        btnSaveCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveCustomer.setText("Enregistrer");
        btnSaveCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSaveCustomerMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel8.setText("Prénom :");

        jLabel14.setText("Date de naissance :");

        jLabel4.setText("Adresse IP");

        jLabel10.setText("Email :");

        jLabel7.setText("Nom :");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setText("Nom voie :");

        comboDeliverStreetType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "rue", "allée ", "avenue", "boulevard ", "chemin ", "route", "impasse", "lieu-dit" }));

        jLabel30.setText("Nom Société :");

        jLabel32.setText("Type :");

        jLabel24.setText("Complément adresse :");

        jLabel28.setText("Ville :");

        jLabel26.setText("Nom :");

        jLabel27.setText("Code postal :");

        jLabel31.setText("N° voie :");

        jLabel29.setText("Prénom :");

        jLabel22.setText("Code sécurité :");

        jLabel33.setText("N° téléphone :");

        tableDeliverAdresses.setModel(new javax.swing.table.DefaultTableModel(
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
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDeliverAdresses.setPreferredSize(new java.awt.Dimension(15, 160));
        tableDeliverAdresses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDeliverAdressesMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tableDeliverAdresses);

        jPanel13.setBackground(new java.awt.Color(51, 102, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNewAdress.setForeground(new java.awt.Color(255, 255, 255));
        btnNewAdress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewAdress.setText("Nouvelle adresse");
        btnNewAdress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewAdress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnNewAdressMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewAdress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewAdress, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(51, 102, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveDeliver.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveDeliver.setText("Enregister");
        btnSaveDeliver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveDeliver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSaveDeliverMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveDeliver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveDeliver, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel45.setText("Label adresse :");

        panBtnDeleteAddress.setBackground(new java.awt.Color(51, 102, 255));
        panBtnDeleteAddress.setPreferredSize(new java.awt.Dimension(200, 45));

        btnDeleteAddress.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteAddress.setText("Supprimer");
        btnDeleteAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeleteAddressMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panBtnDeleteAddressLayout = new javax.swing.GroupLayout(panBtnDeleteAddress);
        panBtnDeleteAddress.setLayout(panBtnDeleteAddressLayout);
        panBtnDeleteAddressLayout.setHorizontalGroup(
            panBtnDeleteAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDeleteAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        panBtnDeleteAddressLayout.setVerticalGroup(
            panBtnDeleteAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDeleteAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfDeliverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfDeliverStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addGap(13, 13, 13)
                        .addComponent(comboDeliverStreetType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfDeliverCompany, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDeliverFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDeliverLastName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDeliverStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addGap(60, 60, 60))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel33))
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfDeliverSecurityCode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDeliverCity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDeliverZipCode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDeliverStreetComplement, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDeliverPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(panBtnDeleteAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDeliverLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDeliverFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDeliverCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDeliverStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32)
                                .addComponent(comboDeliverStreetType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDeliverStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel45)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfDeliverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDeliverStreetComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDeliverZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDeliverCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tfDeliverSecurityCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfDeliverPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel22)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panBtnDeleteAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adresses", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tableOrders.setAutoCreateRowSorter(true);
        tableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Référence", "Statut"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableOrders);

        jPanel11.setBackground(new java.awt.Color(51, 102, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanel11.setRequestFocusEnabled(false);

        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnView.setText("Visualiser");
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Commandes", jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        tableReview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Status", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableReview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableReviewMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableReview);

        tfReview.setColumns(20);
        tfReview.setLineWrap(true);
        tfReview.setRows(5);
        tfReview.setWrapStyleWord(true);
        jScrollPane3.setViewportView(tfReview);

        jPanel12.setBackground(new java.awt.Color(51, 102, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveReview.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveReview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveReview.setText("Enregistrer");
        btnSaveReview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveReview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSaveReviewMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveReview, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveReview, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rbtnValidated.setText("Validé");
        rbtnValidated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnValidatedActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Status");

        rbtnRejected.setText("Rejeté");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnRejected)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbtnValidated)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnValidated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnRejected)
                .addGap(29, 29, 29))
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("ISBN :");

        labelBookISBN.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelBookISBN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBookISBN.setText("labelISBN");

        jLabel35.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel35.setText("TITRE :");

        labelBookTitle.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelBookTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBookTitle.setText("LabelTitre");

        panelSearchByReviewStatus.setBackground(new java.awt.Color(255, 255, 255));
        panelSearchByReviewStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboRevStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En attente", "Validés", "Rejetés" }));
        comboRevStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboRevStatusMouseReleased(evt);
            }
        });
        comboRevStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRevStatusActionPerformed(evt);
            }
        });

        jLabel34.setText("Chercher par :");

        javax.swing.GroupLayout panelSearchByReviewStatusLayout = new javax.swing.GroupLayout(panelSearchByReviewStatus);
        panelSearchByReviewStatus.setLayout(panelSearchByReviewStatusLayout);
        panelSearchByReviewStatusLayout.setHorizontalGroup(
            panelSearchByReviewStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchByReviewStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchByReviewStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboRevStatus, 0, 89, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSearchByReviewStatusLayout.setVerticalGroup(
            panelSearchByReviewStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchByReviewStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboRevStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel6))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(labelBookISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addComponent(labelBookTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSearchByReviewStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(panelSearchByReviewStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(labelBookISBN))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(labelBookTitle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Commentaires", jPanel10);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel16.setText("Code :");

        jLabel17.setText("Date exp");

        jLabel15.setText("Type carte :");

        jLabel18.setText("CVS");

        jLabel19.setText("Titulaire :");

        jPanel7.setBackground(new java.awt.Color(51, 102, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveInvoiceAdress.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveInvoiceAdress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveInvoiceAdress.setText("Enregister");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveInvoiceAdress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveInvoiceAdress, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel44.setText("Label Paiement :");

        tabletfInvoiceAdresses.setModel(new javax.swing.table.DefaultTableModel(
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
        ));
        tabletfInvoiceAdresses.setPreferredSize(new java.awt.Dimension(15, 160));
        tabletfInvoiceAdresses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabletfInvoiceAdressesMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tabletfInvoiceAdresses);

        jPanel15.setBackground(new java.awt.Color(51, 102, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(200, 45));

        btnNewAdress2.setForeground(new java.awt.Color(255, 255, 255));
        btnNewAdress2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewAdress2.setText("Nouvelle adresse");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewAdress2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewAdress2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        panelDate.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelDateLayout = new javax.swing.GroupLayout(panelDate);
        panelDate.setLayout(panelDateLayout);
        panelDateLayout.setHorizontalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );
        panelDateLayout.setVerticalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel44)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfInvoiceLabel)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfInvoiceLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(tfInvoiceCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(tfInvoiceStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(273, 273, 273)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfInvoiceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfInvoiceLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfInvoiceCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfInvoiceStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addContainerGap(132, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Moyens de paiement", jPanel4);

        tfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPasswordKeyReleased(evt);
            }
        });

        jLabel40.setText("Commentaire :");

        jLabel41.setText("Statut");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactif", "Actif", "BlackListé" }));

        comboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Homme", "Femme" }));
        comboGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGenderActionPerformed(evt);
            }
        });

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(200, 400));
        jInternalFrame1.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearch.setText("Rechercher client");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSearchMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel5.setText("Rechercher client par :");

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        bntCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        bntCreateNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntCreateNew.setText("Créer nouveau client");
        bntCreateNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntCreateNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntCreateNewMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bntCreateNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bntCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous les clients", "Nom", "Prénom", "Nom Société", "Email", "N° Téléphone", "Adresse IP", "Status" }));
        comboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSearchActionPerformed(evt);
            }
        });

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Résultats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCustomersMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tableCustomers);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfSearch)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(comboSearch, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jScrollPane7.setViewportView(tfComment);

        jLabel2.setText("Numéro Client :");

        labelCustomerID.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelCustomerID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCustomerID.setText("Client Id");

        labelErrorMessage.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelErrorMessage.setText("ERROR MESSAGE");

        panBtnDeleteCustomer.setBackground(new java.awt.Color(51, 102, 255));
        panBtnDeleteCustomer.setPreferredSize(new java.awt.Dimension(200, 45));
        panBtnDeleteCustomer.setRequestFocusEnabled(false);

        btnDeleteCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteCustomer.setText("Supprimer Client");
        btnDeleteCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDeleteCustomerMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panBtnDeleteCustomerLayout = new javax.swing.GroupLayout(panBtnDeleteCustomer);
        panBtnDeleteCustomer.setLayout(panBtnDeleteCustomerLayout);
        panBtnDeleteCustomerLayout.setHorizontalGroup(
            panBtnDeleteCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        panBtnDeleteCustomerLayout.setVerticalGroup(
            panBtnDeleteCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfLastName)
                            .addComponent(tfFirstName)
                            .addComponent(tfCompany)
                            .addComponent(comboGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfBirthday)
                            .addComponent(tfPhone)
                            .addComponent(tfEmail)
                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIPAdress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(85, 85, 85)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(panBtnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelErrorMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(labelCustomerID))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(tfCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(tfBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tfIPAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panBtnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 675, Short.MAX_VALUE)
                .addGap(112, 112, 112))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLastNameActionPerformed

    private void tfLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLastNameKeyReleased
        if (tfLastName.getText().isEmpty()) {
            tfLastName.setBackground(new Color(255, 0, 0, 15));
            manageInputError(true, "tfLastname", "btnSaveCustomer", ErrorMessages.IS_EMPTY);
        } else {
            tfLastName.setBackground(Color.WHITE);
            manageInputError(false, "tfLastname", "btnSaveCustomer", "");
        }
    }//GEN-LAST:event_tfLastNameKeyReleased

    private void btnSaveCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveCustomerMouseReleased
        try {
            customerFactory();
            //  manageInputError(false, "btnSaveCustomer", ErrorMessages.CRYPTO);
        } catch (NoSuchAlgorithmException ex) {
            //   manageInputError(true, "btnSaveCustomer", ErrorMessages.CRYPTO);
        } catch (CryptoException ex) {
            //   manageInputError(true, "btnSaveCustomer", ErrorMessages.CRYPTO);
        } catch (MissingInformationException ex) {
            //  manageInputError(true, "btnSaveCustomer", ErrorMessages.EMPTY_PASSWORD);
        }
    }//GEN-LAST:event_btnSaveCustomerMouseReleased

    private void tableDeliverAdressesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeliverAdressesMouseReleased
        for (int ligne = 0; ligne < tableDeliverAdresses.getRowCount(); ligne++) {
            if (tableDeliverAdresses.isRowSelected(ligne)) {
                AddressTableItem addressTable = (AddressTableItem) tableDeliverAdresses.getValueAt(ligne, 0);
                currentAddress = addressTable.getAddress();
                fillAddressFields(currentAddress);
            }
        }

        if (currentAddress != null) {
            panBtnDeleteAddress.setVisible(true);
        }
    }//GEN-LAST:event_tableDeliverAdressesMouseReleased

    private void btnNewAdressMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewAdressMouseReleased
        clearAddressFields();
        currentAddress = null;
        panBtnDeleteAddress.setVisible(false);
    }//GEN-LAST:event_btnNewAdressMouseReleased

    private void btnSaveDeliverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveDeliverMouseReleased
        addressFactory();
    }//GEN-LAST:event_btnSaveDeliverMouseReleased

    private void btnDeleteAddressMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteAddressMouseReleased
        if (currentCustomer != null && currentAddress != null) {
            try {
                deleteAddress();
            } catch (Exception ex) {
                Logger.getLogger(JFCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteAddressMouseReleased

    private void tableReviewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReviewMouseReleased
        for (int ligne = 0; ligne < tableReview.getRowCount(); ligne++) {
            if (tableReview.isRowSelected(ligne)) {
                ReviewTableItem reviewTable = (ReviewTableItem) tableReview.getValueAt(ligne, 0);
                currentReview = reviewTable.getReview();
                String reviewText = reviewTable.getComment();
                tfReview.setText(reviewText);
                labelBookISBN.setText(currentReview.getBooIsbn13());
                labelBookTitle.setText(currentReview.getBook().getBooTitle());
            }
        }
    }//GEN-LAST:event_tableReviewMouseReleased

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void btnSaveReviewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveReviewMouseReleased
        if (currentReview != null) {
            reviewFactory();
        }
    }//GEN-LAST:event_btnSaveReviewMouseReleased

    private void rbtnValidatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnValidatedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnValidatedActionPerformed

    private void comboRevStatusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRevStatusMouseReleased

        //        for (int ligne = 0; ligne < tableReview.getRowCount(); ligne++) {
            //            if (tableCustomers.isRowSelected(ligne)) {
                //                CustomerTableItem cusTable = (CustomerTableItem) tableCustomers.getValueAt(ligne, 0);
                //                currentCustomer = cusTable.getCustomer();
                //                fillCustomerFields(currentCustomer);
                //                loadingAdressTable(currentCustomer);
                //                loadingReviewTable(currentCustomer);
                //                loadingOrderTable(currentCustomer);
                //            }
            //        }
    }//GEN-LAST:event_comboRevStatusMouseReleased

    private void comboRevStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRevStatusActionPerformed
        Vector tabToClear = new Vector();
        //tabToClear.add(tableReview);
        // clearTableModels(tabToClear);
        // clearFields();
        //        if (tableReview != null && tableReview.getRowCount() > 0) {
            //            for (int i = 0; i < tableReview.getRowCount(); i++) {
                //                System.out.println(tableReview.getValueAt(i, 0).toString());
                //            }
            //        }
        //  String criteria = comboRevStatus.getSelectedItem().toString();

        // System.out.println(  tableReview.getModel().getValueAt(0, 1)     );
        String criteria = comboRevStatus.getSelectedItem().toString();

        //
        //        if(tableReview != null){
            //            for (int i = 0; i < tableReview.getRowCount(); i++) {
                //              System.out.println(tableReview.getValueAt(i, 1).toString());
                //           }
            //        }
        //        if ( != null) {
            //            for (Object rev : reviewTableList) {
                //                for (Object r : ((ReviewTableItem) rev).getVector()) {
                    //                    System.out.println(r.getClass());
                    //                }
                //            }
            //        }
        //   setTableReviewModel();
        //for(Object rev : reviewTableList){
            //    System.out.println(reviewTableList);
            //  }
    }//GEN-LAST:event_comboRevStatusActionPerformed

    private void tabletfInvoiceAdressesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletfInvoiceAdressesMouseReleased

    }//GEN-LAST:event_tabletfInvoiceAdressesMouseReleased

    private void tfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswordKeyReleased

    }//GEN-LAST:event_tfPasswordKeyReleased

    private void comboGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGenderActionPerformed

    private void btnSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseReleased
        searchForCustomer();
    }//GEN-LAST:event_btnSearchMouseReleased

    private void bntCreateNewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntCreateNewMouseReleased
        Vector tabToClear = new Vector();
        tabToClear.add(tableDeliverAdresses);
        tabToClear.add(tableOrders);
        tabToClear.add(tableReview);
        clearTableModels(tabToClear);
        clearFields();

        clearCustomerFields();
        clearAddressFields();

        currentCustomer = null;
        panBtnDeleteCustomer.setVisible(false);
    }//GEN-LAST:event_bntCreateNewMouseReleased

    private void comboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSearchActionPerformed

    }//GEN-LAST:event_comboSearchActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchForCustomer();
        }
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tableCustomersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomersMouseReleased
        Vector tabToClear = new Vector();
        tabToClear.add(tableDeliverAdresses);
        tabToClear.add(tableOrders);
        tabToClear.add(tableReview);
        clearTableModels(tabToClear);
        clearFields();

        for (int ligne = 0; ligne < tableCustomers.getRowCount(); ligne++) {
            if (tableCustomers.isRowSelected(ligne)) {
                CustomerTableItem cusTable = (CustomerTableItem) tableCustomers.getValueAt(ligne, 0);
                currentCustomer = cusTable.getCustomer();
                fillCustomerFields(currentCustomer);
                loadingAdressTable(currentCustomer);
                loadingReviewTable();
                loadingOrderTable(currentCustomer);
            }
        }

        if (currentCustomer != null) {
            panBtnDeleteCustomer.setVisible(true);
        }
    }//GEN-LAST:event_tableCustomersMouseReleased

    private void btnDeleteCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteCustomerMouseReleased
        if (currentCustomer != null) {
            try {
                deleteCustomer();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(JFCustomer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CryptoException ex) {
                Logger.getLogger(JFCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteCustomerMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bntCreateNew;
    private javax.swing.JLabel btnDeleteAddress;
    private javax.swing.JLabel btnDeleteCustomer;
    private javax.swing.JLabel btnNewAdress;
    private javax.swing.JLabel btnNewAdress2;
    private javax.swing.JLabel btnSaveCustomer;
    private javax.swing.JLabel btnSaveDeliver;
    private javax.swing.JLabel btnSaveInvoiceAdress;
    private javax.swing.JLabel btnSaveReview;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnView;
    private javax.swing.JComboBox comboDeliverStreetType;
    private javax.swing.JComboBox comboGender;
    private javax.swing.JComboBox comboRevStatus;
    private javax.swing.JComboBox comboSearch;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelBookISBN;
    private javax.swing.JLabel labelBookTitle;
    private javax.swing.JLabel labelCustomerID;
    private javax.swing.JLabel labelErrorMessage;
    private javax.swing.JPanel panBtnDeleteAddress;
    private javax.swing.JPanel panBtnDeleteCustomer;
    private javax.swing.JPanel panelDate;
    private javax.swing.JPanel panelSearchByReviewStatus;
    private javax.swing.JRadioButton rbtnRejected;
    private javax.swing.JRadioButton rbtnValidated;
    private javax.swing.JTable tableCustomers;
    private javax.swing.JTable tableDeliverAdresses;
    private javax.swing.JTable tableOrders;
    private javax.swing.JTable tableReview;
    private javax.swing.JTable tabletfInvoiceAdresses;
    private javax.swing.JTextField tfBirthday;
    private javax.swing.JTextPane tfComment;
    private javax.swing.JTextField tfCompany;
    private javax.swing.JTextField tfDeliverCity;
    private javax.swing.JTextField tfDeliverCompany;
    private javax.swing.JTextField tfDeliverFirstName;
    private javax.swing.JTextField tfDeliverLabel;
    private javax.swing.JTextField tfDeliverLastName;
    private javax.swing.JTextField tfDeliverPhoneNumber;
    private javax.swing.JTextField tfDeliverSecurityCode;
    private javax.swing.JTextField tfDeliverStreetComplement;
    private javax.swing.JTextField tfDeliverStreetName;
    private javax.swing.JTextField tfDeliverStreetNumber;
    private javax.swing.JTextField tfDeliverZipCode;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfIPAdress;
    private javax.swing.JTextField tfInvoiceCompany;
    private javax.swing.JTextField tfInvoiceLabel;
    private javax.swing.JTextField tfInvoiceLastName;
    private javax.swing.JTextField tfInvoiceStreetName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextArea tfReview;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
