/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Theme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author cdi312
 */
public class ThemeDAO extends DAO {

    private final String TABLE = "Theme";

    public final String ID = ThemeNames.ID;
    public final String NAME = ThemeNames.NAME;
    public final String DESCRIPTION = ThemeNames.DESCRIPTION;

    private String COLUMNS_CREATE = NAME + ", " + DESCRIPTION;

    public ThemeDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Theme the = (Theme) obj;
        String query = "IF NOT EXISTS(SELECT * FROM theme WHERE theName= '"+the.getTheName()+"')"
                +"INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, the.getTheName());
            pstmt.setString(2, the.getTheDescription());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            
        }
    }

    @Override
    public void delete(Object obj) {
        int theId = ((Theme) obj).getTheId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + theId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
        }
    }

    @Override
    public void update(Object obj) {
        Theme the = (Theme) obj;
        StringBuffer query = new StringBuffer("UPDATE " + TABLE + " SET ");
        query.append(NAME).append(" =?, ");
        query.append(DESCRIPTION).append(" =? ");

        query.append("WHERE " + ID + " = '")
                .append(the.getTheId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {
            pstmt.setString(1, the.getTheName());
            pstmt.setString(2, the.getTheDescription());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            
        }
    }

    @Override
    public Vector findAll() {
        Vector<Theme> themeList = new Vector<Theme>();
        Theme theme = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    theme = new Theme();
                    theme.setTheId(rs.getInt(ID));
                    theme.setTheName(rs.getString(NAME));
                    theme.setTheDescription(rs.getString(DESCRIPTION));

                }
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
        }
        return themeList;
    }

    @Override
    public Object find(int id) {
        Theme theme = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    theme.setTheId(rs.getInt(ID));
                    theme.setTheName(rs.getString(NAME));
                    theme.setTheDescription(rs.getString(DESCRIPTION));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
        }
        return theme;
    }

    @Override
    public Object find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Theme> findByColumn(String column, String term) {

        Vector<Theme> themeList = new Vector<Theme>();
        Theme theme = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + "WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    theme = new Theme();
                    theme.setTheId(rs.getInt(ID));
                    theme.setTheName(rs.getString(NAME));
                    theme.setTheDescription(rs.getString(DESCRIPTION));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
        }
        return themeList;
    }
}
