/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.AccessProfile;
import ClassObjet.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author cdi305
 */
public class AccessProfileDAO extends DAO<AccessProfile> {
    
    private final String TABLE = "AccessProfile";
    private final String PROFILE_CODE = AccessProfileNames.PROFILE_CODE;
    private final String PROFILE_NAME = AccessProfileNames.PROFILE_NAME;
    
    private String COLUMNS_CREATE = PROFILE_CODE + ", " + PROFILE_NAME;
    
    //Constructor

    public AccessProfileDAO() {
        super();
    }

    @Override
    public String toString() {
        return "AccessProfileDAO{" + "TABLE=" + TABLE + ", PROFILE_CODE=" + PROFILE_CODE + ", PROFILE_NAME=" + PROFILE_NAME + ", COLUMNS_CREATE=" + COLUMNS_CREATE + '}';
    }
    
    @Override
    public void create(AccessProfile obj) {
           AccessProfile acc = (AccessProfile) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + PROFILE_CODE + " = '" + acc.getAccProfileCode() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, acc.getAccProfileName());
            
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }}
    
    @Override
    public void update(AccessProfile obj) {
        AccessProfile acc = (AccessProfile) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(PROFILE_CODE).append(" = ?, ");
        query.append(PROFILE_NAME).append(" = ? ");
        

        query.append("WHERE " + PROFILE_CODE + " = '")
                .append(acc.getAccProfileCode())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, acc.getAccProfileName());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }
    
    @Override
    public void delete(AccessProfile obj) {
     int accProfileCode = ((AccessProfile) obj).getAccProfileCode();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(PROFILE_CODE)
                .append(" = ")
                .append("'" + accProfileCode + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }}
    
     @Override
    public Vector<AccessProfile> findAll() {
        Vector<AccessProfile> accessProfileList = new Vector<AccessProfile>();
        AccessProfile acc = null;    
        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    acc = new AccessProfile();
                    acc.setAccProfileCode(rs.getInt(PROFILE_CODE));
                    acc.setAccProfileName(rs.getString(PROFILE_NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return accessProfileList;
     }
    
        @Override
    public Vector<AccessProfile> findByCriteria(String criteria, String term) {
         Vector<AccessProfile> accessprofileList = new Vector<AccessProfile>();
        AccessProfile acc = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(criteria)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    acc = new AccessProfile();
                    acc.setAccProfileCode(rs.getInt(PROFILE_CODE));
                    acc.setAccProfileName(rs.getString(PROFILE_NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return accessprofileList;
    }
    
    @Override
    public AccessProfile findById(int id) {
        AccessProfile acc = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(PROFILE_CODE)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                     acc = new AccessProfile();
                    acc.setAccProfileCode(rs.getInt(PROFILE_CODE));
                    acc.setAccProfileName(rs.getString(PROFILE_NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return acc;   }
    
    @Override
    public AccessProfile findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
