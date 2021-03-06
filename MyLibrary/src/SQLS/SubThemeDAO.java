package SQLS;

import ClassObjet.Book;
import ClassObjet.SubTheme;
import ClassObjet.Theme;
import static Names.SQLNames.StatusDisplayNames.CODE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SubThemeDAO extends DAO<SubTheme> {

    private final String TABLE = "SubTheme";
    private final String ID = SubThemeNames.ID;
    private final String THEME_ID = SubThemeNames.THEME_ID;
    private final String NAME = SubThemeNames.NAME;
    private final String DESCRIPTION = SubThemeNames.DESCRIPTION;
    private final String STATUS = SubThemeNames.DESCRIPTION;

    private String COLUMNS_CREATE = ID + ", " + THEME_ID + "' " + NAME + "' " + DESCRIPTION;

    //Constructor
    public SubThemeDAO() {
        super();
    }

    @Override
    public void create(SubTheme obj) {
        SubTheme subThe = (SubTheme) obj;
        String query = "IF NOT EXISTS(SELECT * FROM subTheme WHERE subName= '" + subThe.getSubName() + "')"
                + "INSERT INTO SUBTHEME(theId,subName,subDescription,subStatus)"
                + "VALUES (?,?,?,?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, subThe.getTheId().getTheId());
            pstmt.setString(2, subThe.getSubName());
            pstmt.setString(3, subThe.getSubDescription());
            pstmt.setInt(4, subThe.getSubStatus());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());

        }
    }

    public Boolean answer(SubTheme obj) {
        Boolean answer = true;
        SubTheme sub = (SubTheme) obj;
        String query = "SELECT * FROM subtheme WHERE subname= '" + sub.getSubName() + "'";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {
                answer = true;
            } else {
                answer = false;
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return answer;

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
            pstmt.setInt(4, subThe.getSubStatus());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());

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

        }
    }

    public Vector<SubTheme> findSubThemeByBook(String isbn) {
        Vector<SubTheme> vecSubThemeList = new Vector<SubTheme>();
        Book boo = null;
        SubTheme sub = null;
        Theme the = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT sub.subId,  sub.subName")
                .append("FROM Book boo ")
                .append("JOIN Association ass ")
                .append("ON boo.booIsbn13 = ass.booIsbn13 ")
                .append("JOIN SubTheme sub ")
                .append("ON ass.subId = sub.subId ")
                .append("JOIN Theme the ")
                .append("ON sub.theId = the.theId ")
                .append("WHERE boo.booIsbn13 ")
                .append(" = ")
                .append("'" + isbn + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    sub = new SubTheme();
                    sub.setSubId(rs.getInt(SubThemeNames.ID));
                    sub.setSubName(rs.getString(SubThemeNames.NAME));
                    the = new Theme();
                    the.setTheId(rs.getInt(SubThemeNames.THEME_ID));
                    sub.setTheId(the);
                    sub.setSubStatus(rs.getInt(STATUS));
                    vecSubThemeList.add(sub);

                }
            } else {
                throw new SQLException("ResultSet Sub was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR findsubthemebybook Retrieving Object : " + ex.getMessage());

        }
        return vecSubThemeList;

    }

    
    
    
    public Vector<SubTheme> findSubThemeByBookandTheme(String isbn,Theme theme) {
        Vector<SubTheme> vecSubThemeList = new Vector<SubTheme>();
        Book boo = null;
        SubTheme sub = null;
        Theme the = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT sub.subId,  subName, sub.theId ")
                .append("FROM Book boo ")
                .append("JOIN Association ass ")
                .append("ON boo.booIsbn13 = ass.booIsbn13 ")
                .append("JOIN SubTheme sub ")
                .append("ON ass.subId = sub.subId ")
                .append("JOIN Theme the ")
                .append("ON sub.theId = the.theId ")
                .append("WHERE boo.booIsbn13 ")
                .append(" = ")
                .append("'" + isbn + "'AND " + THEME_ID + " = "+ theme.getTheId());

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    sub = new SubTheme();
                    sub.setSubId(rs.getInt(SubThemeNames.ID));
                    sub.setSubName(rs.getString(SubThemeNames.NAME));
                    the = new Theme();
                    the.setTheId(rs.getInt(SubThemeNames.THEME_ID));
                    sub.setTheId(the);
                    sub.setSubStatus(rs.getInt(STATUS));
                    vecSubThemeList.add(sub);

                }
            } else {
                throw new SQLException("ResultSet Sub was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR sub Retrieving Object : " + ex.getMessage());

        }
        return vecSubThemeList;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public Vector<SubTheme> findAll() {
        Vector<SubTheme> subThemeList = new Vector<SubTheme>();
        SubTheme subThe = null;
        Theme the = null;
        String query = "SELECT * FROM " + TABLE+ " ORDER BY " +THEME_ID;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    subThe = new SubTheme();
                    subThe.setSubId(rs.getInt(ID));
                    the = new Theme();
                    the.setTheId(rs.getInt(THEME_ID));
                    subThe.setTheId(the);
                    subThe.setSubName(rs.getString(NAME));
                    subThe.setSubDescription(rs.getString(DESCRIPTION));
                    subThe.setSubStatus(rs.getInt(STATUS));
                    subThemeList.add(subThe);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

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
                .append("'" + term + "' ORDER BY " + NAME );

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
                    subThe.setSubStatus(rs.getInt(STATUS));
                    subThemeList.add(subThe);
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return subThemeList;
    }
    
    
    
    
    
    public Vector<SubTheme> findByColumn(String column, int term) {
        Vector<SubTheme> subThemeList = new Vector<SubTheme>();
        SubTheme subThe = null;
        Theme the = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

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
                    subThe.setSubStatus(rs.getInt(STATUS));
                    subThemeList.add(subThe);
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return subThemeList;
    }
    
    
    
    
    
    
    
    
    
    
    
    public Vector<SubTheme> findByColumnTheme(String column, int subtheme, String column2, int theme) {
        Vector<SubTheme> subThemeList = new Vector<SubTheme>();
        SubTheme subThe = null;
        Theme the = new Theme();
        ThemeDAO themeDAO = new ThemeDAO();
        the=themeDAO.find(theme);
        
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append( column )
                .append(" = ")
                .append("'" + subtheme + "' AND")
                .append( column2 )
                .append(" = ")
                .append("'" + theme + "'")
                
                ;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    subThe = new SubTheme();
                    
                    subThe.setSubId(rs.getInt(ID));
                    subThe.setTheId(the);
                    subThe.setSubName(rs.getString(NAME));
                    subThe.setSubDescription(rs.getString(DESCRIPTION));
                    subThemeList.add(subThe);
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

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
                    subThe.setSubStatus(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return subThe;
    }

    @Override
    public SubTheme find(String name) {

        SubTheme subThe = null;
        Theme the = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(NAME)
                .append(" = ")
                .append("'" + name + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    subThe = new SubTheme();
                    subThe.setSubId(rs.getInt(ID));
                    the = new Theme();
                    the.setTheId(rs.getInt(THEME_ID));
                    subThe.setTheId(the);
                    subThe.setSubName(rs.getString(NAME));
                    subThe.setSubDescription(rs.getString(DESCRIPTION));
                    subThe.setSubStatus(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return subThe;
        
    
        
    }

    // SEARCH by theme
    public void updateByTheme(SubTheme obj) {

        SubTheme sub = (SubTheme) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(ID).append(" = ?, ");
        query.append(THEME_ID).append(" = ? ");

        query.append("WHERE " + THEME_ID + " = '")
                .append(sub.getTheId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, "0");
            pstmt.setString(2, "38");

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());

        }
    }
}
