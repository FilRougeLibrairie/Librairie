/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class CustomerDAO extends DAO {
    
    private final String ID = "cusId";
    private final String GENDER = "cusGender";
    private final String FIRST_NAME = "cusFirstName";
    private final String LAST_NAME = "cusLastName";
    private final String COMPANY = "cusOrganisationName";
    private final String EMAIL = "cusEmail";
    private final String PHONE = "cusPhoneNumber";
    private final String BIRTHDAY = "cusDateOfBirth";
    private final String PASSWORD = "cusPassword";
    private final String SALT = "cusSalt";
    private final String IP = "cusIP";
    private final String STATUS = "cusStatus";
    private final String COMMENT = "cusComment";
    
    private String COLUMNS = GENDER + ", " + FIRST_NAME + ", " + LAST_NAME + ", " +
            COMPANY + ", " + EMAIL + ", " + PHONE + ", " + BIRTHDAY + ", " + 
            PASSWORD + ", " + SALT + ", " + IP + ", " + STATUS + ", " + COMMENT;

    public CustomerDAO(ConnexionBase conn) {
        super(conn);
    }

    @Override
    public boolean create(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Vector<Customer> findByCriteria(String criteria, String term) {
        Vector<Customer> customerList = new Vector<Customer>();
        Customer customer = null;
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM Customer WHERE ")
                .append(criteria)
                .append(" = ")
                .append(term);

        try (PreparedStatement pstmt = this.connect.getInstance().prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                customer.setCusID(rs.getInt(ID));
                customer.setCusGender(rs.getString(GENDER));
                customer.setCusFirstName(rs.getString(FIRST_NAME));
                customer.setCusLastName(rs.getString(LAST_NAME));
                customer.setCusOrganisationName(rs.getString(COMPANY));
                customer.setCusEmail(rs.getString(EMAIL));
                customer.setCusPhoneNumber(rs.getString(PHONE));
                customer.setCusDateOfBirth(rs.getString(BIRTHDAY));
                customer.setCusPassword(rs.getString(PASSWORD));
                customer.setCusSalt(rs.getString(SALT));
                customer.setCusIP(rs.getString(IP));
                customer.setCusStatus(rs.getInt(STATUS));
                customer.setCusComment(rs.getString(COMMENT));
                customerList.add(customer);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            ex.printStackTrace();

        }
        return customerList;
    }
}
