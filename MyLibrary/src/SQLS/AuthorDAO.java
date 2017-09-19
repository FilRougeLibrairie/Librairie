
package SQLS;


import ClassObjet.Author;
import ClassObjet.Book;
import Names.SQLNames.AuthorNames;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import static org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.id;



public class AuthorDAO extends DAO{
    
    
    
    private final String TABLE = "Author";
    private final String ID = AuthorNames.ID;   
    private final String LAST_NAME = AuthorNames.LAST_NAME;
    private final String FIRST_NAME = AuthorNames.FIRST_NAME;
    private final String BIOGRAPHY = AuthorNames.BIOGRAPHY; 
    private final String STATUS_CODE = AuthorNames.STATUS_CODE;
    
    
   
    private String COLUMNS_CREATE = LAST_NAME + ", " + FIRST_NAME + ", " + BIOGRAPHY + ", "
            + STATUS_CODE;

    public AuthorDAO() {
       super(); 
    }
    
 
    @Override
    public void create(Object obj) {
        Author aut = (Author) obj;
        String query =
                 "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, aut.getAutLastName());
            pstmt.setString(2, aut.getAutFirstName());
            pstmt.setString(3, aut.getAutBiography());
            pstmt.setInt(4, aut.getAutStatusCode());
            

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            
        }
    }

    
    
    @Override
    public void delete(Object obj) {
        int autId = ((Author) obj).getAutId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + autId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
        }
    }

    @Override
    public void update(Object obj) {
        Author aut = (Author) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
              
     
        query.append(LAST_NAME).append(" = ?, ");
        query.append(FIRST_NAME).append(" = ?, ");
        query.append(BIOGRAPHY).append(" = ?, ");
        query.append(STATUS_CODE).append(" = ? ");
       

        query.append("WHERE " + ID + " = '")
                .append(aut.getAutId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, aut.getAutLastName());
            pstmt.setString(2, aut.getAutFirstName());
            pstmt.setString(3, aut.getAutBiography());
            pstmt.setInt(4, aut.getAutStatusCode());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            

        }
    }

    
    
    @Override
    public Author find(int id) {
        Author author = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    author = new Author();
                    author.setAutId(rs.getInt(ID));
                    author.setAutLastName(rs.getString(LAST_NAME));
                    author.setAutFirstName(rs.getString(FIRST_NAME));
                    author.setAutBiography(rs.getString(BIOGRAPHY));
                    author.setAutStatusCode(rs.getInt(STATUS_CODE));
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return author;
    }

    
    
    
    
    @Override
    public Object find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 
    
    @Override
    public Vector findAll() {
        Vector<Author> authorList = new Vector<Author>();
        Author author = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    author = new Author();
                    author.setAutId(rs.getInt(ID));
                    author.setAutLastName(rs.getString(LAST_NAME));
                    author.setAutFirstName(rs.getString(FIRST_NAME));
                    author.setAutBiography(rs.getString(BIOGRAPHY));
                    author.setAutStatusCode(rs.getInt(STATUS_CODE));
                    
                    
                    authorList.add(author);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return authorList;
    }

    
    
    @Override
    public Vector<Author> findByColumn(String column, String term) {

        Vector<Author> authorList = new Vector<Author>();
        Author author = null;

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
                    author = new Author();
                    author.setAutId(rs.getInt(ID));
                    author.setAutLastName(rs.getString(LAST_NAME));
                    author.setAutFirstName(rs.getString(FIRST_NAME));  
                    author.setAutBiography(rs.getString(BIOGRAPHY));
                    author.setAutStatusCode(rs.getInt(STATUS_CODE));
                    authorList.add(author);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return authorList;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
