
package SQLS;

import ClassObjet.Shipper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class ShipperDAO extends DAO {
    
    
    
    private final String TABLE = "Shipper";

    private final String ID = ShipperNames.ID;
    private final String NAME = ShipperNames.NAME;

    private String COLUMNS_CREATE = NAME ;

    public ShipperDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Shipper ship = (Shipper) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + ship.getShipperId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, ship.getShipperName());
           

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void delete(Object obj) {
        int shipId = ((Shipper) obj).getShipperId();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + shipId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object obj) {
        Shipper ship = (Shipper) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(NAME).append(" = ? ");
        

        query.append("WHERE " + ID + " = '")
                .append(ship.getShipperId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, ship.getShipperName());
        

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    
    
    @Override
    public Shipper findById(int id) {
        Shipper shipper = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    shipper = new Shipper();
                    shipper.setShipperId(rs.getInt(ID));
                    shipper.setShipperName(rs.getString(NAME));
                   
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return shipper;
    }

    @Override
    public Object findByName(String name) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findAll() {
        Vector<Shipper> shipperList = new Vector<Shipper>();
        Shipper shipper = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    shipper = new Shipper();
                    shipper.setShipperId(rs.getInt(ID));
                    shipper.setShipperName(rs.getString(NAME));
                    shipperList.add(shipper);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return shipperList;
    }

    @Override
    public Vector<Shipper> findByCriteria(String criteria, String term) {

        Vector<Shipper> shipperList = new Vector<Shipper>();
        Shipper shipper = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(criteria)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    shipper = new Shipper();
                    shipper.setShipperId(rs.getInt(ID));
                    shipper.setShipperName(rs.getString(NAME));
                    
                    shipperList.add(shipper);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return shipperList;
    }
}
    
    
    
    
    
    
    
    
    
    
    

