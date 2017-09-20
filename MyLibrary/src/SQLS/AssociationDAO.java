
package SQLS;

import ClassObjet.ClassAssoc.Association;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;


public class AssociationDAO extends DAO<Association>{
    
    
    private final String TABLE = "Association";
    private final String ID = "booIsbn13";
    private final String SUBID = "subId";

    private String COLUMNS_CREATE =  ID + ", " + SUBID;
    
    
    
    //Constructor
    public AssociationDAO() {
        super();
    }
    
    
    @Override
    public void create(Association obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Association obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Association obj) {
       
    Association assoc = (Association) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(SUBID).append(" = ? ");

        query.append("WHERE " + SUBID + " = '")
                .append(assoc.getSubId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setInt(1, 38);

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            

        }
    
    
    }

    @Override
    public Vector<Association> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Association find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Association find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Association> findByColumn(String column, String term) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
