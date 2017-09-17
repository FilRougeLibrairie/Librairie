/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.AccessProfile;
import ClassObjet.StatusDisplay;
import static Names.SQLNames.AccessProfileNames.PROFILE_CODE;
import static Names.SQLNames.AccessProfileNames.PROFILE_NAME;
import Names.SQLNames.StatusDisplayNames;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author cdi305
 */
public class StatusDisplayDAO extends DAO<StatusDisplay> {
    
    private final String TABLE = "StatusDisplay";
    private final String STATUS_CODE =  StatusDisplayNames.CODE;
    private final String STATUS_NAME = StatusDisplayNames.NAME;
    
     private String COLUMNS_CREATE = STATUS_CODE + ", " + STATUS_NAME;
    
     
     //Constructor

    public StatusDisplayDAO() {
        super();
    }

    @Override
    public String toString() {
        return "StatusDisplayDAO{" + "TABLE=" + TABLE + ", STATUS_CODE=" + STATUS_CODE + ", STTATUS_NAME=" + STATUS_NAME + ", COLUMNS_CREATE=" + COLUMNS_CREATE + '}';
    }

   @Override
    public void create(StatusDisplay obj) {
           StatusDisplay stadi = (StatusDisplay) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + STATUS_CODE + " = '" + stadi.getStaCode() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, stadi.getStaName());
            
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    
    @Override
    public void update(StatusDisplay obj) {
        StatusDisplay stadi = (StatusDisplay) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(STATUS_CODE).append(" = ?, ");
        query.append(STATUS_NAME).append(" = ? ");
        

        query.append("WHERE " + STATUS_CODE + " = '")
                .append(stadi.getStaCode())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, stadi.getStaName());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }
    
    @Override
    public void delete(StatusDisplay obj) {
     int staCode = ((StatusDisplay) obj).getStaCode();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(STATUS_CODE)
                .append(" = ")
                .append("'" + staCode + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }}
    
     @Override
    public Vector<StatusDisplay> findAll() {
        Vector<StatusDisplay> StatusDisplayList = new Vector<StatusDisplay>();
        StatusDisplay stadi = null;    
        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                   stadi = new StatusDisplay();
                   stadi.setStaCode(rs.getInt(STATUS_CODE));
                   stadi.setStaName(rs.getString(STATUS_NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return StatusDisplayList;
     }
    
        @Override
    public Vector<StatusDisplay> findByColumn(String column, String term) {
         Vector<StatusDisplay> StatusDisplayList = new Vector<StatusDisplay>();
        StatusDisplay stadi = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                   stadi = new StatusDisplay();
                   stadi.setStaCode(rs.getInt(STATUS_CODE));
                   stadi.setStaName(rs.getString(STATUS_NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return StatusDisplayList;
    }
    
    @Override
    public StatusDisplay find(int id) {
        StatusDisplay stadi = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(STATUS_CODE)
                .append(" = ")
                .append(id);
        

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                   stadi = new StatusDisplay();
                   stadi.setStaCode(rs.getInt(STATUS_CODE));
                   stadi.setStaName(rs.getString(STATUS_NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            ex.getMessage();

        }
        return stadi;   }
    
    @Override
    public StatusDisplay find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
}
