/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.jfEmployee;

import ClassObjet.AccessProfile;
import ClassObjet.Employee;
import ClassObjet.StatusDisplay;
import Names.SQLNames;
import SQLS.AccessProfileDAO;
import SQLS.EmployeeDAO;
import exceptions.CryptoException;
import exceptions.MissingInformationException;
import java.awt.Color;
import java.awt.Component;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import utils.Awt1;
import utils.Crypto;
import utils.DateLabelFormatter;

public class JFEmployee extends javax.swing.JFrame implements SQLNames {

    Vector<Employee> employeeList;
    Vector<AccessProfile> employeeListProfile;
    Vector<StatusDisplay> employeeListStatus;
    Vector employeeTableList;
    Vector<String> comboSearchModel;
    Vector<String> comboStatusModel;
    Vector<String> comboProfilModel;
    Employee currentEmployee;
    JDatePickerImpl datePicker;

    private final String DELETED_MENTION = "SUPPRIME";
    private final String DELETED_NAME_MASK = "***";
    private final String DELETED_LOGIN_MASK = "***";
    private final String DELETED_PASSWORD_MASK = "***";
    private final String DELETED_COMENT_MASK = "***";
    private final String DELETED_DATE_MASK = "1970-01-01";

    private class ErrorMessages {

        public static final String IS_EMPTY = "Ce champs est obligatoire";
        public static final String EMPTY_PASSWORD = "Le mot de passe est obligatoire";
        public static final String CRYPTO = "Un problème de génération du mot de passe est survenu";
    }

//    private class ConfirmMessage {
//        
//        public static final String SAVED = "Informations enregistrées";
//    }
    private enum Status {

        ACTIVE("Actif"),
        INACTIVE("Inactif");
        private final String databaseName;

        private Status(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    private enum ProfileType {

        NO_ACCESS("Aucun Accès"),
        ADMINISTRATOR("Administrateur"),
        EDITOR("Editeur"),
        CUSTOMER("Client"),
        MODERATOR("Moderateur"),
        ACCESS_DENIED("Accès refusé");

        private final String databaseName;

        private ProfileType(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    private enum SearchCriteria {

        LAST_NAME("Nom"),
        FIRST_NAME("Prénom"),
        LOGIN("Login"),
        STATUS("Statut"),
        PROFIL("Profil");
        private final String databaseName;

        private SearchCriteria(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getDatabaseName() {
            return databaseName;
        }
    }

    public JFEmployee() {
        initComponents();
        tableEmployee.setCellSelectionEnabled(true);
        comboSearch.setModel(initComboSearchModel());
        comboSearch.setSelectedIndex(0);
        comboStatus.setModel(initComboStatusModel());
        comboProfile.setModel(initComboProfileModel());
        labelErrorMessage.setVisible(false);
        labelPreviousPassword.setVisible(false);
        tfPreviousPassword.setVisible(false);
        confirmSaveMessage.setVisible(false);

//                UtilDateModel model = new UtilDateModel();
//        Properties p = new Properties();
//        p.put("text.today", "Today");
//        p.put("text.month", "Month");
//        p.put("text.year", "Year");
//        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//        datePicker.setBackground(Color.WHITE);
//        datePicker.setBounds(0, 0, 200, 30);
//        datePicker.setVisible(true);
//        panelDate.setSize(100, 100);
//        panelDate.add(datePicker);
//
//        datePicker.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                datePickerActionPerformed(evt);
//            }
//        });
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

    private DefaultComboBoxModel initComboStatusModel() {
        DefaultComboBoxModel model;
        comboStatusModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboStatusModel);
        for (Status comboItem : Status.values()) {
            comboStatusModel.add(comboItem.getDatabaseName());
        }
        return model;
    }

    private DefaultComboBoxModel initComboProfileModel() {
        DefaultComboBoxModel model;
        comboProfilModel = new Vector<String>();
        model = new DefaultComboBoxModel(comboProfilModel);
        for (ProfileType comboItem : ProfileType.values()) {
            comboProfilModel.add(comboItem.getDatabaseName());
        }
        return model;
    }

    private void setTableEmployeeModel() {
        tableEmployee.setModel(initTableEmployeeModel());
    }

    private DefaultTableModel initTableEmployeeModel() {

        Vector v = new Vector();

        v.add("Nom");
        v.add("Prénom");
        v.add("Login");
        v.add("Statut");
        v.add("Profil");
        v.add("Date d'entrée");
        v.add("Date de sortie");

        return new javax.swing.table.DefaultTableModel(employeeTableList, v) {
        };
    }

    private void searchForEmployee() {
        if (comboSearch.getSelectedItem() != null) {
            String criteria = comboSearch.getSelectedItem().toString();
            String term = tfSearch.getText().trim();

            int statusIndex;
            employeeList = new Vector<Employee>();
            EmployeeDAO employeeDAO = new EmployeeDAO();

            if (criteria.equalsIgnoreCase(SearchCriteria.STATUS.getDatabaseName())) {
                employeeList = employeeDAO.findAll();
                statusIndex = comboStatus.getSelectedIndex();
                employeeList = employeeDAO.findByColumn(criteria, statusIndex);

//                 } else if (criteria.equalsIgnoreCase((SearchCriteria.PROFIL.getDatabaseName()))) {
//               employeeList = employeeDAO.findAll();
//               statusIndex = comboProfil.getSelectedIndex();
//               employeeList = employeeDAO.findByColumn(criteria, statusIndex);
                
            } else if (criteria.equalsIgnoreCase((SearchCriteria.PROFIL.getDatabaseName()))) {  
                employeeListProfile = new Vector<AccessProfile>();
                AccessProfileDAO accessProfileDAO = new AccessProfileDAO();
                criteria = EmployeeNames.ACCESS_PROFILE;
                term = comboProfile.getSelectedItem().toString().trim(); 
                employeeListProfile = accessProfileDAO.findByColumn(criteria, term);

            } else if (term != null && !term.isEmpty()) {
            }
            if (criteria.equalsIgnoreCase(SearchCriteria.LAST_NAME.getDatabaseName())) {
                criteria = EmployeeNames.LAST_NAME;
            } else if (criteria.equalsIgnoreCase(SearchCriteria.FIRST_NAME.getDatabaseName())) {
                criteria = EmployeeNames.FIRST_NAME;
            } else if (criteria.equalsIgnoreCase(SearchCriteria.LOGIN.getDatabaseName())) {
                criteria = EmployeeNames.LOGIN;
            }
            employeeList = employeeDAO.findByColumn(criteria, term);
            System.out.println(employeeList.size());
        }
        employeeTableList = new Vector();
        for (Employee emp : employeeList) {
            EmployeeTableItem employeeTable = new EmployeeTableItem(emp);
            employeeTableList.add(employeeTable.getVector());
        }
        setTableEmployeeModel();
    }

    private void fillEmployeeFields(Employee emp) {
        int status = emp.getEmpStatus();
        int index = Status.ACTIVE.ordinal();
        Boolean isActive = (status == Status.ACTIVE.ordinal());
        Boolean isInactive = (status == Status.INACTIVE.ordinal());

        if (isActive) {
            index = Status.ACTIVE.ordinal();
        }
        if (isInactive) {
            index = Status.INACTIVE.ordinal();
        }
        comboStatus.setSelectedIndex(index);

        int access = emp.getAccProfileCode().getAccProfileCode();
        int indexProfile = ProfileType.NO_ACCESS.ordinal();
        Boolean isNoAccess = (access == ProfileType.NO_ACCESS.ordinal());
        Boolean isAdministrator = (access == ProfileType.ADMINISTRATOR.ordinal());
        Boolean isCustomer = (access == ProfileType.CUSTOMER.ordinal());
        Boolean isEditor = (access == ProfileType.EDITOR.ordinal());
        Boolean isModerator = (access == ProfileType.MODERATOR.ordinal());
        Boolean isAccessDenied = (access == ProfileType.ACCESS_DENIED.ordinal());

        if (isNoAccess) {
            indexProfile = ProfileType.NO_ACCESS.ordinal();
        }
        if (isAdministrator) {
            indexProfile = ProfileType.ADMINISTRATOR.ordinal();
        }
        if (isCustomer) {
            indexProfile = ProfileType.CUSTOMER.ordinal();
        }
        if (isEditor) {
            indexProfile = ProfileType.EDITOR.ordinal();
        }
        if (isModerator) {
            indexProfile = ProfileType.MODERATOR.ordinal();
        }
        if (isAccessDenied) {
            indexProfile = ProfileType.ACCESS_DENIED.ordinal();
        }

        comboProfile.setSelectedIndex(indexProfile);

        tfLastName.setText(emp.getEmpLastName());
        tfFirstName.setText(emp.getEmpFirstName());
        tfLogin.setText(emp.getEmpLogin());
        tfPassword.setText("");
        tfComment.setText(emp.getEmpComment());

        DateFormat dfStart = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlStartD = new java.sql.Date(emp.getEmpDateStart().getTime());
        String startDate = dfStart.format(sqlStartD);
        tfStartDate.setText(startDate);

        DateFormat dfEnd = new SimpleDateFormat("yyyy-MM-dd");

        if (emp.getEmpDateEnd() != null) {
            java.sql.Date sqlEndD = new java.sql.Date(emp.getEmpDateEnd().getTime());
            String endDate = dfEnd.format(sqlEndD);
            tfEndDate.setText(endDate);
        } else {
            tfEndDate.setText("");
        }
    }

    private void newEmployee() throws MissingInformationException, NoSuchAlgorithmException, CryptoException {

        Employee emp;
        emp = new Employee();

        emp.setEmpLastName(tfLastName.getText().trim());
        emp.setEmpFirstName(tfFirstName.getText().trim());
        emp.setEmpLogin(tfLogin.getText().trim());
        emp.setEmpPassword(tfPassword.getText().trim());
        emp.setEmpComment(tfComment.getText().trim());
        emp.setEmpStatus(comboStatus.getSelectedIndex());
        AccessProfile access = new AccessProfile();
        access.setAccProfileCode(comboProfile.getSelectedIndex());
        emp.setAccProfileCode(access);
        emp.setEmpDateStart(tfStartDate.getText().trim());
        emp.setEmpDateStart(tfEndDate.getText().trim());
        
        if (tfPassword.getPassword().length == 0) {
            throw new MissingInformationException(ErrorMessages.IS_EMPTY);
        } else if (tfPassword.getPassword().length > 0) {
            String str = new String(tfPassword.getPassword());
            String[] password = Crypto.createPassword(new String(tfPassword.getPassword()));
            emp.setEmpPassword(password[0]);
            emp.setEmpSalt(password[1]);
        } else {
            System.out.println("Les informations employé sont enregistrées");
        }
        if (tfPassword.getPassword().toString().isEmpty()) {
            manageInputError(true, "tfPassword", "btnSaveEmployee", ErrorMessages.EMPTY_PASSWORD);
        } else {
            manageInputError(false, "tfPassword", "btnSaveEmployee", ErrorMessages.EMPTY_PASSWORD);
        }

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.create(emp);
        System.out.println("create");

        confirmSaveMessage.setVisible(true);
        employeeDAO.findAll();
    }

    private void updateEmployee() throws MissingInformationException, NoSuchAlgorithmException, CryptoException {

        Employee emp;
        emp = currentEmployee;

        emp.setEmpLastName(tfLastName.getText().trim());
        emp.setEmpFirstName(tfFirstName.getText().trim());
        emp.setEmpLogin(tfLogin.getText().trim());
        emp.setEmpPassword(tfPassword.getText().trim());
        emp.setEmpComment(tfComment.getText().trim());
        emp.setEmpStatus(comboStatus.getSelectedIndex());
        AccessProfile access = new AccessProfile();
        access.setAccProfileCode(comboProfile.getSelectedIndex());
        emp.setAccProfileCode(access);

//        if (tfStartDate.getText() != null) {
            emp.setEmpDateStart(tfStartDate.getText().trim());
//        }
//        if (tfEndDate.getText() != null) {
            emp.setEmpDateStart(tfEndDate.getText().trim());
//        }
       
//            labelPreviousPassword.setVisible(true);
//            tfPreviousPassword.setVisible(true);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.update(emp);
        System.out.println("update");

        confirmSaveMessage.setVisible(true);
        employeeDAO.findAll();
//        clearFields();
//        clearTableModel(employeeTableList);
    }

    private void manageInputError(Boolean ErrorState, String component, String btnToDisable, String errorMessage) {
        Component btn = Awt1.getComponentByName(this, btnToDisable);
        Component tf = Awt1.getComponentByName(this, component);

        if (ErrorState) {
            labelErrorMessage.setText(errorMessage);
            labelErrorMessage.setVisible(true);
            btn.setVisible(false);
            tf.setBackground(new Color(255, 0, 0, 15));
        } else {
            labelErrorMessage.setText("");
            labelErrorMessage.setVisible(false);
            btn.setVisible(true);
            tf.setBackground(Color.WHITE);
        }
    }

    public void clearFields() {

        tfLastName.setText("");
        tfFirstName.setText("");
        tfLogin.setText("");
        tfPassword.setText("");
        tfComment.setText("");

        int index1 = Status.ACTIVE.ordinal();
        comboStatus.setSelectedIndex(index1);

        int index2 = ProfileType.NO_ACCESS.ordinal();
        comboProfile.setSelectedIndex(index2);

        tfStartDate.setText("");
        tfEndDate.setText("");
    }

//    private void clearTableModel(Vector<JTable> jtableList) {
//        DefaultTableModel tabModel;
//        for (JTable table : jtableList) {
//            tabModel = ((DefaultTableModel) table.getModel());
//            int lignes = tabModel.getRowCount();
//            for (int i = lignes - 1; i >= 0; i--) {
//                tabModel.removeRow(i);
//            }
//        }
//    }
    void setColor(JPanel panel) {
        panel.setBackground(new Color(0, 51, 153));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(51, 102, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelStatut = new javax.swing.JLabel();
        comboProfile = new javax.swing.JComboBox();
        tfLastName = new javax.swing.JTextField();
        labelLastName = new javax.swing.JLabel();
        labelFirstName = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        labelPassword = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        tfEndDate = new javax.swing.JTextField();
        labelEndDate = new javax.swing.JLabel();
        labelStartDate = new javax.swing.JLabel();
        tfStartDate = new javax.swing.JTextField();
        labelComment = new javax.swing.JLabel();
        labelProfil = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnSaveEmployee = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        spComment = new javax.swing.JScrollPane();
        tfComment = new javax.swing.JTextPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        labelSearch = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCreateNew = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        comboSearch = new javax.swing.JComboBox();
        tfSearch = new javax.swing.JTextField();
        labelErrorMessage = new javax.swing.JLabel();
        labelPreviousPassword = new javax.swing.JLabel();
        tfPreviousPassword = new javax.swing.JPasswordField();
        confirmSaveMessage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSaveEmployee1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 630));

        labelStatut.setText("Statut :");

        comboProfile.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucun Accès", "Administrateur", "Editeur", "Client", "Moderateur", "Accès refusé" }));

        labelLastName.setText("Nom :");

        labelFirstName.setText("Prénom :");

        labelPassword.setText("Mot de passe :");

        labelLogin.setText("Login :");

        labelEndDate.setText("Date de sortie :");

        labelStartDate.setText("Date d'entrée :");

        labelComment.setText("Commentaire :");

        labelProfil.setText("Profil :");

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEmployee.setText("  Enregister nouvel employé");
        btnSaveEmployee.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveEmployeeMouseMoved(evt);
            }
        });
        btnSaveEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveEmployeeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSaveEmployeeMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(btnSaveEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Actif", "Non-actif" }));

        tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prénom", "Login", "Satut", "Profil", "Date d'entrée", "date de sortie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableEmployee.setSelectionBackground(new java.awt.Color(51, 102, 255));
        tableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableEmployeeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableEmployeeMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableEmployee);

        spComment.setViewportView(tfComment);

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(200, 400));
        jInternalFrame1.setVisible(true);

        jPanel6.setBackground(new java.awt.Color(51, 102, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearch.setText("Rechercher");
        btnSearch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSearchMouseMoved(evt);
            }
        });
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSearchMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        labelSearch.setText("Recherche employé par :");

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 45));

        btnCreateNew.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCreateNew.setText("Nouvel Employé");
        btnCreateNew.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCreateNewMouseMoved(evt);
            }
        });
        btnCreateNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateNewMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCreateNewMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCreateNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nom", "Prénom", "Login", "Statut", "Profil" }));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfSearch)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(comboSearch, javax.swing.GroupLayout.Alignment.LEADING, 0, 176, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelErrorMessage.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelErrorMessage.setText("ERROR MESSAGE");

        labelPreviousPassword.setText("ancien mot de passe :");

        confirmSaveMessage.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        confirmSaveMessage.setForeground(new java.awt.Color(51, 102, 255));
        confirmSaveMessage.setText("Informations enregistrées!");

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 45));

        btnSaveEmployee1.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEmployee1.setText("       Enregistrer mise à jour");
        btnSaveEmployee1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveEmployee1MouseMoved(evt);
            }
        });
        btnSaveEmployee1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveEmployee1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSaveEmployee1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEmployee1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEmployee1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelLogin)
                                            .addComponent(labelFirstName)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(labelLastName)))
                                        .addGap(84, 84, 84))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelPreviousPassword)
                                            .addComponent(labelPassword))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(tfPassword)
                                    .addComponent(tfLogin, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(tfPreviousPassword, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(49, 49, 49))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(confirmSaveMessage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelProfil)
                                    .addComponent(labelStatut))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboProfile, 0, 166, Short.MAX_VALUE)
                                    .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelStartDate)
                                    .addComponent(labelEndDate)
                                    .addComponent(labelComment))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEndDate)
                                    .addComponent(spComment)
                                    .addComponent(tfStartDate)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfLastName)
                                    .addComponent(labelLastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfFirstName)
                                    .addComponent(labelFirstName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfLogin)
                                    .addComponent(labelLogin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfPassword)
                                    .addComponent(labelPassword)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelStatut)
                                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelProfil)
                                            .addComponent(comboProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfStartDate)
                                    .addComponent(labelStartDate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfEndDate)
                                    .addComponent(labelEndDate))
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelPreviousPassword)
                                    .addComponent(tfPreviousPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelErrorMessage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmSaveMessage)
                                .addGap(77, 77, 77))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(labelComment)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(spComment, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(922, 668));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseReleased
        searchForEmployee();
        confirmSaveMessage.setVisible(false);
    }//GEN-LAST:event_btnSearchMouseReleased

    private void tableEmployeeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseReleased

        tfEndDate.setText("");

        for (int ligne = 0; ligne < tableEmployee.getRowCount(); ligne++) {
            if (tableEmployee.isRowSelected(ligne)) {
                EmployeeTableItem empTable = (EmployeeTableItem) tableEmployee.getValueAt(ligne, 0);
                currentEmployee = empTable.getEmployee();
                fillEmployeeFields(currentEmployee);
            }
        }
        confirmSaveMessage.setVisible(false);
    }//GEN-LAST:event_tableEmployeeMouseReleased

    private void btnCreateNewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateNewMouseReleased
        clearFields();
        confirmSaveMessage.setVisible(false);
    }//GEN-LAST:event_btnCreateNewMouseReleased

    private void tableEmployeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMousePressed


    }//GEN-LAST:event_tableEmployeeMousePressed

    private void btnCreateNewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateNewMouseMoved
        setColor(jPanel3);
        resetColor(jPanel4);
        resetColor(jPanel6);
        resetColor(jPanel5);

    }//GEN-LAST:event_btnCreateNewMouseMoved

    private void btnSearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseMoved
        setColor(jPanel6);
        resetColor(jPanel3);
        resetColor(jPanel4);
        resetColor(jPanel5);

    }//GEN-LAST:event_btnSearchMouseMoved

    private void btnSaveEmployeeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEmployeeMouseMoved
        setColor(jPanel4);
        resetColor(jPanel3);
        resetColor(jPanel6);
        resetColor(jPanel5);
    }//GEN-LAST:event_btnSaveEmployeeMouseMoved

    private void btnCreateNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateNewMouseClicked
        resetColor(jPanel3);
    }//GEN-LAST:event_btnCreateNewMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        resetColor(jPanel6);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnSaveEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEmployeeMouseClicked
        resetColor(jPanel4);
    }//GEN-LAST:event_btnSaveEmployeeMouseClicked

    private void btnSaveEmployeeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEmployeeMouseReleased

        try {
            newEmployee();
        } catch (MissingInformationException ex) {
            Logger.getLogger(JFEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JFEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CryptoException ex) {
            Logger.getLogger(JFEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        searchForEmployee();

    }//GEN-LAST:event_btnSaveEmployeeMouseReleased

    private void btnSaveEmployee1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEmployee1MouseMoved
        setColor(jPanel5);
        resetColor(jPanel4);
        resetColor(jPanel3);
        resetColor(jPanel6);

    }//GEN-LAST:event_btnSaveEmployee1MouseMoved

    private void btnSaveEmployee1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEmployee1MouseClicked
        resetColor(jPanel5);
    }//GEN-LAST:event_btnSaveEmployee1MouseClicked

    private void btnSaveEmployee1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEmployee1MouseReleased
        try {
            updateEmployee();
        } catch (MissingInformationException ex) {
            Logger.getLogger(JFEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JFEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CryptoException ex) {
            Logger.getLogger(JFEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveEmployee1MouseReleased

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
            java.util.logging.Logger.getLogger(JFEmployee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEmployee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEmployee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEmployee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCreateNew;
    private javax.swing.JLabel btnSaveEmployee;
    private javax.swing.JLabel btnSaveEmployee1;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JComboBox comboProfile;
    private javax.swing.JComboBox comboSearch;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JLabel confirmSaveMessage;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelComment;
    private javax.swing.JLabel labelEndDate;
    private javax.swing.JLabel labelErrorMessage;
    private javax.swing.JLabel labelFirstName;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPreviousPassword;
    private javax.swing.JLabel labelProfil;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JLabel labelStartDate;
    private javax.swing.JLabel labelStatut;
    private javax.swing.JScrollPane spComment;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTextPane tfComment;
    private javax.swing.JTextField tfEndDate;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JPasswordField tfPreviousPassword;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfStartDate;
    // End of variables declaration//GEN-END:variables
}
