/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Address;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class AddressDAO extends DAO {

    private final String TABLE = "Address";

    private final String ID = AddressNames.ID;
    private final String CUST_RESIDENCE_ID = AddressNames.CUST_RESIDENCE_ID;
    private final String CUST_CHARGE_ID = AddressNames.CUST_CHARGE_ID;
    private final String LABEL = AddressNames.LABEL;
    private final String FIRST_NAME = AddressNames.FIRST_NAME;
    private final String LAST_NAME = AddressNames.LAST_NAME;
    private final String COMPANY = AddressNames.COMPANY;
    private final String STREET_NUMBER = AddressNames.STREET_NUMBER;
    private final String STREET_TYPE = AddressNames.STREET_TYPE;
    private final String STREET_NAME = AddressNames.STREET_NAME;
    private final String COMPLEMENT = AddressNames.COMPLEMENT;
    private final String ZIP_CODE = AddressNames.ZIP_CODE;
    private final String CITY = AddressNames.CITY;
    private final String SECURITY_CODE = AddressNames.SECURITY_CODE;
    private final String PHONE = AddressNames.PHONE;

    private String COLUMNS_CREATE = CUST_RESIDENCE_ID + ", " + CUST_CHARGE_ID + ", "
            + LABEL + ", " + FIRST_NAME + ", " + LAST_NAME + ", " + COMPANY + ", "
            + STREET_NUMBER + ", " + STREET_TYPE + ", " + STREET_NAME + ", "
            + COMPLEMENT + ", " + ZIP_CODE + ", " + CITY + ", "
            + SECURITY_CODE + ", " + PHONE;

    public AddressDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Address addr = (Address) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + addr.getAddId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, addr.getCusResidId().getCusID());
            pstmt.setInt(2, addr.getCusChargeId().getCusID());
            pstmt.setString(3, addr.getAddLabel());
            pstmt.setString(4, addr.getAddFirstName());
            pstmt.setString(5, addr.getAddLastName());
            pstmt.setString(6, addr.getAddCompany());
            pstmt.setString(7, addr.getAddNumber());
            pstmt.setString(8, addr.getAddStreetType());
            pstmt.setString(9, addr.getAddStreetName());
            pstmt.setString(10, addr.getAddComplement());
            pstmt.setString(11, addr.getAddZipCode());
            pstmt.setString(12, addr.getAddCity());
            pstmt.setString(13, addr.getAddSecurityCode());
            pstmt.setString(14, addr.getAddPhone());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void delete(Object obj) {
        int addrId = ((Address) obj).getAddId();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + addrId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object obj) {
        Address addr = (Address) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(CUST_RESIDENCE_ID).append(" = ?, ");
        query.append(CUST_CHARGE_ID).append(" = ?, ");
        query.append(LABEL).append(" = ?, ");
        query.append(FIRST_NAME).append(" = ?, ");
        query.append(LAST_NAME).append(" = ?, ");
        query.append(COMPANY).append(" = ?, ");
        query.append(STREET_NUMBER).append(" = ?, ");
        query.append(STREET_TYPE).append(" = ?, ");
        query.append(STREET_NAME).append(" = ?, ");
        query.append(COMPLEMENT).append(" = ?, ");
        query.append(ZIP_CODE).append(" = ?, ");
        query.append(CITY).append(" = ?, ");
        query.append(SECURITY_CODE).append(" = ?, ");
        query.append(PHONE).append(" = ?, ");

        query.append("WHERE " + ID + " = '")
                .append(addr.getAddId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setInt(1, addr.getCusResidId().getCusID());
            pstmt.setInt(2, addr.getCusChargeId().getCusID());
            pstmt.setString(3, addr.getAddLabel());
            pstmt.setString(4, addr.getAddFirstName());
            pstmt.setString(5, addr.getAddLastName());
            pstmt.setString(6, addr.getAddCompany());
            pstmt.setString(7, addr.getAddNumber());
            pstmt.setString(8, addr.getAddStreetType());
            pstmt.setString(9, addr.getAddStreetName());
            pstmt.setString(10, addr.getAddComplement());
            pstmt.setString(11, addr.getAddZipCode());
            pstmt.setString(12, addr.getAddCity());
            pstmt.setString(13, addr.getAddSecurityCode());
            pstmt.setString(14, addr.getAddPhone());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }

    }

    @Override
    public Vector findAll() {
        Vector<Address> addressList = new Vector<Address>();
        Address address = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    address = new Address();
                    address.setAddId(rs.getInt(ID));
                    address.setCusResidId.(rs.getString(CUST_RESIDENCE_ID));
                    address.setCusChargeId(rs.getString(CUST_CHARGE_ID));
                    address.setAddLabel(rs.getString(LABEL));
                    address.setAddFirstName(rs.getString(FIRST_NAME));
                    address.setAddLastName(rs.getString(LAST_NAME));
                    address.setAddCompany(rs.getString(COMPANY));
                    address.setAddNumber(rs.getString(STREET_NUMBER));
                    address.setAddStreetType(rs.getString(STREET_TYPE));
                    address.setAddStreetName(rs.getString(STREET_NAME));
                    address.setAddComplement(rs.getString(COMPLEMENT));
                    address.setAddZipCode(rs.getInt(ZIP_CODE));
                    address.setAddCity(rs.getString(CITY));
                    address.setAddSecurityCode(rs.getString(SECURITY_CODE));
                    address.setAddPhone(rs.getString(PHONE));
                    customerList.add(customer);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return customerList;
    }

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findByCriteria(String criteria, String term) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}