/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Customer;
import ClassObjet.OrderLine;
import ClassObjet.Review;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author CDI305
 */
public class ReviewDAO extends DAO<Review> {

    private final String TABLE = "Review";

    private final String ID = ReviewNames.ID;
    private final String CUSTOMER_ID = ReviewNames.CUSTOMER_ID;
    private final String BOOK_ISBN_13 = ReviewNames.BOOK_ISBN_13;
    private final String ORDERLINE_ID = ReviewNames.ORDERLINE_ID;
    private final String NOTE = ReviewNames.NOTE;
    private final String COMMENT = ReviewNames.COMMENT;
    private final String DATE = ReviewNames.DATE;
    private final String IP = ReviewNames.IP;
    private final String STATUS = ReviewNames.STATUS;

    private String COLUMNS_CREATE = CUSTOMER_ID + ", " + BOOK_ISBN_13 + ", " + ORDERLINE_ID + ", "
            + NOTE + ", " + COMMENT + ", " + DATE + ", " + IP + ", "
            + STATUS;

    //Constructor
    public ReviewDAO() {
        super();
    }

    @Override
    public void create(Review obj) {
        Review rev = (Review) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + rev.getRevId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, rev.getCusId().getCusID());
            pstmt.setString(2, rev.getBooIsbn13());
            pstmt.setInt(3, rev.getOrdLineId().getOrdLineId());
            pstmt.setFloat(4, rev.getRevNote());
            pstmt.setString(5, rev.getRevComment());
            pstmt.setDate(6, rev.getRevDate());
            pstmt.setString(7, rev.getRevIP());
            pstmt.setInt(8, rev.getRevStatus());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void update(Review obj) {
        Review rev = (Review) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(CUSTOMER_ID).append(" = ?, ");
        query.append(BOOK_ISBN_13).append(" = ?, ");
        query.append(ORDERLINE_ID).append(" = ?, ");
        query.append(NOTE).append(" = ?, ");
        query.append(COMMENT).append(" = ?, ");
        query.append(DATE).append(" = ?, ");
        query.append(IP).append(" = ?, ");
        query.append(STATUS).append(" = ? ");

        query.append("WHERE " + ID + " = ")
                .append(rev.getRevId());

        System.out.println(query);
        
        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setInt(1, rev.getCusId().getCusID());
            pstmt.setString(2, rev.getBooIsbn13());
            pstmt.setInt(3, rev.getOrdLineId().getOrdLineId());
            pstmt.setFloat(4, rev.getRevNote());
            pstmt.setString(5, rev.getRevComment());
            pstmt.setDate(6, rev.getRevDate());
            pstmt.setString(7, rev.getRevIP());
            pstmt.setInt(8, rev.getRevStatus());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    @Override
    public void delete(Review obj) {
        int revId = ((Review) obj).getRevId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + revId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Review find(int id) {
        Review review = null;
        Customer cus = null;
        OrderLine ord = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    review = new Review();
                    review.setRevId(rs.getInt(ID));
                    cus = new Customer();
                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    review.setCusId(cus);
                    review.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ord = new OrderLine();
                    ord.setOrdLineId(rs.getInt(ORDERLINE_ID));
                    review.setOrdLineId(ord);
                    review.setRevNote(rs.getFloat(NOTE));
                    review.setRevComment(rs.getString(COMMENT));
                    review.setRevDate(rs.getString(DATE));
                    review.setRevIP(rs.getString(IP));
                    review.setRevStatus(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return review;
    }

    @Override
    public Vector<Review> findAll() {
        Vector<Review> reviewList = new Vector<Review>();
        Review review = null;
        Customer cus = null;
        OrderLine ord = null;
        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    review = new Review();
                    review.setRevId(rs.getInt(ID));
                    cus = new Customer();
                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    review.setCusId(cus);
                    review.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ord = new OrderLine();
                    ord.setOrdLineId(rs.getInt(ORDERLINE_ID));
                    review.setOrdLineId(ord);
                    review.setRevNote(rs.getFloat(NOTE));
                    review.setRevComment(rs.getString(COMMENT));
                    review.setRevDate(rs.getString(DATE));
                    review.setRevIP(rs.getString(IP));
                    review.setRevStatus(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return reviewList;
    }

    @Override
    public Review find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Review> findByColumn(String column, String term) {
        Vector<Review> reviewList = new Vector<Review>();
        Review review = null;
        Customer cus = null;
        OrderLine ord = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    review = new Review();
                    review.setRevId(rs.getInt(ID));
                    cus = new Customer();
                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    review.setCusId(cus);
                    review.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ord = new OrderLine();
                    ord.setOrdLineId(rs.getInt(ORDERLINE_ID));
                    review.setOrdLineId(ord);
                    review.setRevNote(rs.getFloat(NOTE));
                    review.setRevComment(rs.getString(COMMENT));
                    review.setRevDate(rs.getString(DATE));
                    review.setRevIP(rs.getString(IP));
                    review.setRevStatus(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return reviewList;
    }

    public Vector<Review> findByColumn(String column, int term) {
        Vector<Review> reviewList = new Vector<Review>();
        Review review = null;
        Customer cus = null;
        OrderLine ord = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("?");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            pstmt.setInt(1, term);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    review = new Review();
                    review.setRevId(rs.getInt(ID));
                    cus = new Customer();
                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    review.setCusId(cus);
                    review.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ord = new OrderLine();
                    ord.setOrdLineId(rs.getInt(ORDERLINE_ID));
                    review.setOrdLineId(ord);
                    review.setRevNote(rs.getFloat(NOTE));
                    review.setRevComment(rs.getString(COMMENT));
                    review.setRevDate(rs.getString(DATE));
                    review.setRevIP(rs.getString(IP));
                    review.setRevStatus(rs.getInt(STATUS));
                    reviewList.add(review);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return reviewList;
    }

    public Vector<Review> findByCriteria(String column, int term, String criteria) {
        Vector<Review> reviewList = new Vector<Review>();
        Review review = null;
        Customer cus = null;
        OrderLine ord = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT " + criteria + " FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append(term);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    review = new Review();
                    review.setRevId(rs.getInt(ID));
                    cus = new Customer();
                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    review.setCusId(cus);
                    review.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ord = new OrderLine();
                    ord.setOrdLineId(rs.getInt(ORDERLINE_ID));
                    review.setOrdLineId(ord);
                    review.setRevNote(rs.getFloat(NOTE));
                    review.setRevComment(rs.getString(COMMENT));
                    review.setRevDate(rs.getString(DATE));
                    review.setRevIP(rs.getString(IP));
                    review.setRevStatus(rs.getInt(STATUS));
                    reviewList.add(review);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return reviewList;
    }

}
