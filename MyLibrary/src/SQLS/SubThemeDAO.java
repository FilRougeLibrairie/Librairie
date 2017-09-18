/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.BookLanguage;
import ClassObjet.SubTheme;
import ClassObjet.Theme;
import static Names.SQLNames.StatusDisplayNames.CODE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author CDI305
 */
public class SubThemeDAO extends DAO<SubTheme>{
    
        private final String TABLE = "SubTheme"; 
        private final String ID = SubThemeNames.ID;
        private final String THEME_ID = SubThemeNames.THEME_ID;
        private final String NAME = SubThemeNames.NAME;
        private final String DESCRIPTION = SubThemeNames.DESCRIPTION;

    private String COLUMNS_CREATE = ID + ", " + THEME_ID + "' " + NAME + "' " + DESCRIPTION ;

    //Constructor

    public SubThemeDAO() {
        super();
    }
    

    @Override
    public void create(SubTheme obj) {
        SubTheme subThe = (SubTheme) obj;
        String query = 
                "INSERT INTO SUBTHEME(theId,subName,subDescription)"
                + "VALUES (?,?,?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, subThe.getTheId().getTheId());
            pstmt.setString(2, subThe.getSubName());
            pstmt.setString(3, subThe.getSubDescription());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void update(SubTheme obj) {
        SubTheme subThe = (SubTheme) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(THEME_ID).append(" = ?, ");
        query.append(NAME).append(" = ?, ");
        query.append(DESCRIPTION).append(" = ? ");

        query.append("WHERE " + ID + " = '")
                .append(subThe.getSubId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setInt(1, subThe.getTheId().getTheId());
            pstmt.setString(2, subThe.getSubName());
            pstmt.setString(3, subThe.getSubDescription());
            
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    @Override
    public void delete(SubTheme obj) {
        int subTheId = ((SubTheme) obj).getSubId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + subTheId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Vector<SubTheme> findAll() {
        Vector<SubTheme> subThemeList = new Vector<SubTheme>();
        SubTheme subThe = null;
        Theme the = null;
        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    subThe = new SubTheme();
                    the = new Theme();
                    the.setTheId(rs.getInt(THEME_ID));
                    subThe.setTheId(the);
                    subThe.setSubName(rs.getString(NAME));
                    subThe.setSubDescription(rs.getString(DESCRIPTION));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return subThemeList;
    }

    @Override
    public Vector<SubTheme> findByColumn(String column, String term) {
        Vector<SubTheme> subThemeList = new Vector<SubTheme>();
        SubTheme subThe = null;
        Theme the = null;
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
                    subThe = new SubTheme();
                    the = new Theme();
                    the.setTheId(rs.getInt(THEME_ID));
                    subThe.setTheId(the);
                    subThe.setSubName(rs.getString(NAME));
                    subThe.setSubDescription(rs.getString(DESCRIPTION));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return subThemeList;
    }

    @Override
    public SubTheme find(int id) {
        SubTheme subThe = null;
        Theme the = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(CODE)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    subThe = new SubTheme();
                    the = new Theme();
                    the.setTheId(rs.getInt(THEME_ID));
                    subThe.setTheId(the);
                    subThe.setSubName(rs.getString(NAME));
                    subThe.setSubDescription(rs.getString(DESCRIPTION));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return subThe;
    }

    @Override
    public SubTheme find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
