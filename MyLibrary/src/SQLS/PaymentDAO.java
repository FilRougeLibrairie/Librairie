/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Payment;
import ClassObjet.Purchase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author cdi303
 */
public class PaymentDAO extends DAO{
    
    
    
    
     private final String TABLE = "Payment";

    private final String ID = PaymentNames.ID;
    private final String PURCHASE_ID = PaymentNames.PURCHASE_ID;  
    private final String VALIDATION = PaymentNames.VALIDATION;
    private final String CHOICE= PaymentNames.CHOICE;
    private final String DATE = PaymentNames.DATE;
    

    private String COLUMNS_CREATE = PURCHASE_ID + ", " + VALIDATION  + ", " + CHOICE + ", "
            + DATE;

    public PaymentDAO() {
        
        super();
    }

    
    @Override
    public void create(Object obj) {
        Payment pay = (Payment) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + pay.getPayId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, pay.getPurId().getPurId());
            pstmt.setBoolean(2, pay.getPayValidate());
            pstmt.setString(3, pay.getPayChoice());
            pstmt.setString(4, pay.getPayDate());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void delete(Object obj) {
        int payId = ((Payment) obj).getPayId();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + payId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    
    @Override
    public void update(Object obj) {
        Payment pay = (Payment) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(PURCHASE_ID).append(" = ?, ");
        query.append(VALIDATION).append(" = ?, ");
        query.append(CHOICE ).append(" = ?, ");
        query.append(DATE).append(" = ? ");

        query.append("WHERE " + ID + " = '")
                .append(pay.getPayId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setInt(1, pay.getPurId().getPurId());
            pstmt.setBoolean(2, pay.getPayValidate());
            pstmt.setString(3, pay.getPayChoice());
            pstmt.setString(4, pay.getPayDate());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    @Override
    public Payment findById(int id) {
        Payment payment = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    payment = new Payment();
                    payment.setPayId(rs.getInt(ID));
                    Purchase pur = new Purchase();
                    pur.setPurId(rs.getInt(PURCHASE_ID));
                    payment.setPurId(pur);
                    payment.setPayValidate(rs.getBoolean(VALIDATION));
                    payment.setPayChoice(rs.getString(CHOICE));
                    payment.setPayDate(rs.getString(ID));
                  
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return payment;
    }
  
    
    
    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findAll() {
        Vector<Payment> paymentList = new Vector<Payment>();
        Payment payment = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    payment = new Payment();
                    payment.setPayId(rs.getInt(ID));
                    Purchase pur = new Purchase();
                    pur.setPurId(rs.getInt(PURCHASE_ID));
                    payment.setPurId(pur);
                    payment.setPayValidate(rs.getBoolean(VALIDATION));
                    payment.setPayChoice(rs.getString(CHOICE));
                    payment.setPayDate(rs.getString(DATE));
                    paymentList.add(payment);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return paymentList;
    }

    @Override
    public Vector<Payment> findByCriteria(String criteria, String term) {

        Vector<Payment> paymentList = new Vector<Payment>();
        Payment payment = null;

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
                     payment = new Payment();
                    payment.setPayId(rs.getInt(ID));
                    Purchase pur = new Purchase();
                    pur.setPurId(rs.getInt(PURCHASE_ID));
                    payment.setPurId(pur);
                    payment.setPayValidate(rs.getBoolean(VALIDATION));
                    payment.setPayChoice(rs.getString(CHOICE));
                    payment.setPayDate(rs.getString(DATE));
                    paymentList.add(payment);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return paymentList;
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
