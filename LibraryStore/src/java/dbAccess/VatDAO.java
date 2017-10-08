/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import entities.BookLanguage;
import entities.Vat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author CDI305
 */
public class VatDAO extends DAO<Vat> {

    private final String TABLE = "Vat";
    private final String CODE = VATNames.CODE;
    private final String RATE = VATNames.RATE;
    private final String NAME = VATNames.NAME;
    private final String STATUS = VATNames.STATUS;

    private String COLUMNS_CREATE =  RATE + ", " + NAME;

    //Constructor
    public VatDAO() {
        super();
    }

    @Override
    public void create(Vat obj) {
        Vat vat = (Vat) obj;
        String query = "IF NOT EXISTS(SELECT * FROM vat WHERE vatRate= "+vat.getVatRate()+")"
                + "INSERT INTO VAT (" + COLUMNS_CREATE+ ")"
                + "VALUES (?, ?,?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setFloat(1, vat.getVatRate());
            pstmt.setString(2, vat.getVatName());
            pstmt.setInt(3, vat.getVatStatus());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR Create Vat Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            
        }
    }

    @Override
    public void update(Vat obj) {
        Vat vat = (Vat) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(RATE).append(" = ?, ");
        query.append(NAME).append(" = ?, ");
        query.append(STATUS).append(" = ? ");

        query.append("WHERE " + CODE + " = '")
                .append(vat.getVatCode())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setFloat(1, vat.getVatRate());
            pstmt.setString(2, vat.getVatName());
            pstmt.setInt(3, vat.getVatStatus());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            

        }
    }
    
    public Boolean answer(Vat obj){
        Boolean answer=true;
        Vat vat = (Vat) obj;
        String query = "SELECT * FROM vat WHERE vatRate= '"+vat.getVatRate()+"'";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {
                answer=true;
            } else {
                answer=false;
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return answer;
        
        
    }  

    @Override
    public void delete(Vat obj) {
        int vatId = ((Vat) obj).getVatCode();
       
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(CODE)
                .append(" = ")
                .append("'" + vatId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
        }
    }

    @Override
    public Vector<Vat> findAll() {
        Vector<Vat> vatList = new Vector<Vat>();
        Vat vat = null;
        String query = "SELECT * FROM VAT";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    vat = new Vat();
                    vat.setVatCode(rs.getInt(CODE));
                    vat.setVatRate(rs.getFloat(RATE));
                    vat.setVatName(rs.getString(NAME));
                    vat.setVatStatus(rs.getInt(STATUS));
                    vatList.add(vat);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return vatList;
    }

    @Override
    public Vector<Vat> findByColumn(String column, String term) {
        Vector<Vat> vatList = new Vector<Vat>();
        Vat vat = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    vat = new Vat();
                    vat.setVatCode(rs.getInt(CODE));
                    vat.setVatRate(rs.getFloat(RATE));
                    vat.setVatName(rs.getString(NAME));
                    vat.setVatStatus(rs.getInt(STATUS));
                    vatList.add(vat);
                }
            } else {
                throw new SQLException("ResultSet Vat was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return vatList;
    }

    @Override
    public Vat find(int id) {
        Vat vat = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(CODE)
                .append(" = ")
                .append(id);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    vat = new Vat();
                    vat.setVatCode(rs.getInt(CODE));
                    vat.setVatRate(rs.getFloat(RATE));
                    vat.setVatName(rs.getString(NAME));
                    vat.setVatStatus(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return vat;
    }

    @Override
    public Vat find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
