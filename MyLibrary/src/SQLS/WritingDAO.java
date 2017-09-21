package SQLS;

import ClassObjet.Author;
import ClassObjet.Book;
import ClassObjet.ClassAssoc.Writing;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class WritingDAO extends DAO<Writing> {

    private final String TABLE = "Writing";
    private final String ID = "booIsbn13";
    private final String AUT = "autId";

    private String COLUMNS_CREATE = ID + ", " + AUT;

    @Override
    public void create(Writing obj) {
        Writing wri = (Writing) obj;
        StringBuilder query = new StringBuilder("INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?)");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, wri.getBooIsbn13());
            pstmt.setInt(2, wri.getAutId());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR Create Writing Object : " + ex.getMessage());

        }
    }

    @Override
    public void delete(Writing obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Writing obj) {

        Writing writing = (Writing) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(AUT).append(" = ? ");

        query.append("WHERE " + AUT + " = '")
                .append(writing.getAutId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, "1");

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());

        }

    }

    @Override
    public Vector<Writing> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Writing find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
    public Writing find(String name) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public Vector<Writing> findByColumn(String column, String term) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
