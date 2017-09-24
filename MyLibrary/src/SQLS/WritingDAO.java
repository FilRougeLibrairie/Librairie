package SQLS;


import ClassObjet.ClassAssoc.Having;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Vector;

public class WritingDAO extends DAO<Having> {

    private final String TABLE = "Writing";
    private final String ID = "booIsbn13";
    private final String AUT = "autId";

    private String COLUMNS_CREATE = ID + ", " + AUT;

    @Override
    public void create(Having obj) {
        Having wri = (Having) obj;
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
    public void delete(Having obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Having obj) {

        Having writing = (Having) obj;
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
    public Vector<Having> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Having find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
    public Having find(String name) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public Vector<Having> findByColumn(String column, String term) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
