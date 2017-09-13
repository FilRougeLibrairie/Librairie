/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class CustomerDAO extends DAO {
    
    private final String ID = "cusId";
    private final String GENDER = "cusGender";
    private final String FIRST_NAME = "cusFirstName"
    private final String 
    private final String 
    private final String 
    private final String 
    private final String 
    private final String 
    private final String 
    private final String 
    private final String 
    private final String 

    public CustomerDAO(ConnexionBase conn) {
        super(conn);
    }

    @Override
    public boolean create(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id) {
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector<Customer> findByCriteria(String criteria, String term) {
        Vector<Customer> customerList = new Vector<Customer>();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM Customer WHERE ")
                .append(criteria)
                .append(" = ")
                .append(term);

        try (PreparedStatement pstmt = this.connect.getInstance().prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            ex.printStackTrace();

        }
        return customerList;
    }
}
