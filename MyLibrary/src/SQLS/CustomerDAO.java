/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Customer;
import exceptions.ResultsetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class CustomerDAO extends DAO {

    private final String TABLE = "Customer";

    private final String ID = CustomerNames.ID;
    private final String GENDER = CustomerNames.GENDER;
    private final String FIRST_NAME = CustomerNames.FIRST_NAME;
    private final String LAST_NAME = CustomerNames.LAST_NAME;
    private final String COMPANY = CustomerNames.COMPANY;
    private final String EMAIL = CustomerNames.EMAIL;
    private final String PHONE = CustomerNames.PHONE;
    private final String BIRTHDAY = CustomerNames.BIRTHDAY;
    private final String PASSWORD = CustomerNames.PASSWORD;
    private final String SALT = CustomerNames.SALT;
    private final String IP = CustomerNames.IP;
    private final String STATUS = CustomerNames.STATUS;
    private final String COMMENT = CustomerNames.COMMENT;

    private String COLUMNS_CREATE = GENDER + ", " + FIRST_NAME + ", " + LAST_NAME + ", "
            + COMPANY + ", " + EMAIL + ", " + PHONE + ", " + BIRTHDAY + ", "
            + PASSWORD + ", " + SALT + ", " + IP + ", " + STATUS + ", " + COMMENT;

    public CustomerDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Customer cus = (Customer) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + cus.getCusID() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, cus.getCusGender());
            pstmt.setString(2, cus.getCusFirstName());
            pstmt.setString(3, cus.getCusLastName());
            pstmt.setString(4, cus.getCusOrganisationName());
            pstmt.setString(5, cus.getCusEmail());
            pstmt.setString(6, cus.getCusPhoneNumber());
            pstmt.setDate(7, cus.getCusDateOfBirth());
            pstmt.setString(8, cus.getCusPassword());
            pstmt.setString(9, cus.getCusSalt());
            pstmt.setString(10, cus.getCusIP());
            pstmt.setInt(11, cus.getCusStatus());
            pstmt.setString(12, cus.getCusComment());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        int cusId = ((Customer) obj).getCusID();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + cusId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Customer cus = (Customer) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(FIRST_NAME).append(" = ?, ");
        query.append(LAST_NAME).append(" = ?, ");
        query.append(EMAIL).append(" = ?, ");
        query.append(PHONE).append(" = ?, ");
        query.append(GENDER).append(" = ?, ");
        query.append(BIRTHDAY).append(" = ?, ");
        query.append(COMPANY).append(" = ?, ");
        query.append(PASSWORD).append(" = ?, ");
        query.append(SALT).append(" = ?, ");
        query.append(STATUS).append(" = ?, ");
        query.append(IP).append(" = ?, ");
        query.append(COMMENT).append(" = ? ");

        query.append("WHERE " + ID + " = '")
                .append(cus.getCusID())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, cus.getCusFirstName());
            pstmt.setString(2, cus.getCusLastName());
            pstmt.setString(3, cus.getCusEmail());
            pstmt.setString(4, cus.getCusPhoneNumber());
            pstmt.setString(5, cus.getCusGender());
            pstmt.setDate(6, cus.getCusDateOfBirth());
            pstmt.setString(7, cus.getCusOrganisationName());
            pstmt.setString(8, cus.getCusPassword());
            pstmt.setString(9, cus.getCusSalt());
            pstmt.setInt(10, cus.getCusStatus());
            pstmt.setString(11, cus.getCusIP());
            pstmt.setString(12, cus.getCusComment());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());

        }
    }

    @Override
    public Customer find(int id) {
        Customer customer = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        System.out.println(query);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

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
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
        }
        return customer;
    }

    @Override
    public Object find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findAll() {
        Vector<Customer> customerList = new Vector<Customer>();
        Customer customer = null;

        String query = "SELECT * FROM " + TABLE + " ORDER BY " + CustomerNames.LAST_NAME;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

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
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return customerList;
    }

    @Override
    public Vector<Customer> findByColumn(String column, String term) {

        Vector<Customer> customerList = new Vector<Customer>();
        Customer customer = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" LIKE ")
                .append("'" + term + "%'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

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
            } else {
                throw new ResultsetException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return customerList;
    }

    public Vector<Customer> findByColumn(String column, int term) {

        Vector<Customer> customerList = new Vector<Customer>();
        Customer customer = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append(term);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

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
            } else {
                throw new ResultsetException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
        }
        return customerList;
    }
}
