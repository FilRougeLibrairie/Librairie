
package SQLS;

import ClassObjet.AccessProfile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


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
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + PROFILE_NAME + " = '" + acc.getAccProfileName()+ "')"
                + "INSERT INTO " + TABLE + " (" + PROFILE_NAME + ")"
                + "VALUES (?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, acc.getAccProfileName());
            
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            
        }}
    
    @Override
    public void update(AccessProfile obj) {
        AccessProfile acc = (AccessProfile) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");  
        query.append(PROFILE_NAME).append(" = ? ");
        

        query.append("WHERE " + PROFILE_CODE + " = '")
                .append(acc.getAccProfileCode())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            
            pstmt.setString(1, acc.getAccProfileName());
            
            
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            

        }
    }
    
    @Override
    public void delete(AccessProfile obj) {
     int accProfileCode = ((AccessProfile) obj).getAccProfileCode();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(PROFILE_CODE)
                .append(" = ")
                .append("'" + accProfileCode + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
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
                    accessProfileList.add(acc);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return accessProfileList;
     }
    
        @Override
    public Vector<AccessProfile> findByColumn(String column, String term) {
         Vector<AccessProfile> accessprofileList = new Vector<AccessProfile>();
        AccessProfile acc = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

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
            

        }
        return accessprofileList;
    }
    
    @Override
    public AccessProfile find(int id) {
        AccessProfile acc = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(PROFILE_CODE)
                .append(" = ")
                .append(id);

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
            

        }
        return acc;   }
    
    @Override
    public AccessProfile find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
