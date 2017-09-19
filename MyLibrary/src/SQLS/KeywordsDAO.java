package SQLS;

import ClassObjet.Keywords;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class KeywordsDAO extends DAO {

    private final String NAME = KeywordsNames.NAME;

    private String COLUMNS = NAME;

    public KeywordsDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Keywords kw = (Keywords) obj;
        
        
        String query ="IF NOT EXISTS(SELECT * FROM keywords WHERE keyName= '"+kw.getKeyName()+"')"
                +"INSERT INTO KEYWORDS VALUES ('"+kw.getKeyName()+"')";

     
        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING CONTACT : " + ex.getErrorCode() + " / " + ex.getMessage());
            
        }
    }

    @Override
    public void delete(Object obj) {
        String kw = ((Keywords) obj).getKeyName();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM KEYWORDS WHERE ")
                .append(NAME)
                .append(" = ")
                .append("'" + kw + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
          pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Done");
           
        }
    }

    @Override
    public void update(Object obj) {
        Keywords kw = (Keywords) obj;
        StringBuilder query = new StringBuilder("UPDATE KEYWORDS SET ");
        query.append(NAME).append(" = ? ");

        query.append("WHERE " + NAME + " = '")
                .append(kw.getKeyName())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, kw.getKeyName());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING CONTACT : " + ex.getMessage());
            

        }
    }
        
        
    @Override
    public Keywords find(String keyName) {
        Keywords kw = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM Keywords WHERE ")
                .append(NAME)
                .append(" = ")
                .append("'" + keyName + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    kw = new Keywords();
                    kw.setKeyName(rs.getString(NAME));

                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            

        }
        return kw;
        
        
        
    }
    

@Override
        public Vector findAll() {
        Vector<Keywords> keywordsList = new Vector<Keywords>();
        Keywords kw = null;

        String query = "SELECT * FROM Keywords";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    kw = new Keywords();
                    kw.setKeyName(rs.getString(NAME));
                    keywordsList.add(kw);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            

        }
        return keywordsList;
    }
        
     
        
        
           

    public Vector<Keywords> findByColumn(String column, String term) {

        Vector<Keywords> keywordsList = new Vector<Keywords>();
        Keywords kw = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM KEYWORDS WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    kw = new Keywords();
                    
                    kw.setKeyName(NAME);
                    
                    keywordsList.add(kw);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            

        }
        return keywordsList;
    }

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
}
        
        
        
    


    
