package SQLS;

import ClassObjet.Book;
import ClassObjet.OrderLine;
import ClassObjet.Purchase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class OrderLineDAO extends DAO {

    private final String TABLE = "OrderLine";

    private final String ID = OrderLineNames.ID;
    private final String PURCHASE_ID = OrderLineNames.PURCHASE_ID;
    private final String BOOK_ISBN_13 = OrderLineNames.BOOK_ISBN_13;
    private final String QUANTITY = OrderLineNames.QUANTITY;
    private final String PRICE_HT = OrderLineNames.PRICE_HT;
    private final String VAT = OrderLineNames.VAT;

    Vector<OrderLine> orderLineList;
    OrderLine ordLine;
    Purchase pur;
    Book book;

    private String COLUMNS_CREATE = PURCHASE_ID + ", " + BOOK_ISBN_13 + ", "
            + QUANTITY + ", " + PRICE_HT + ", " + VAT;

    public OrderLineDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        ordLine = (OrderLine) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + pur.getPurId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, ordLine.getPurId().getPurId());
            pstmt.setString(2, ordLine.getBooIsbn13().getBooIsbn13());
            pstmt.setInt(3, ordLine.getOrdLineQuantity());
            pstmt.setFloat(4, ordLine.getOrdBookPriceHT());
            pstmt.setFloat(5, ordLine.getOrdBookVAT());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            
        }
    }

    @Override
    public void delete(Object obj) {
        int ordLineId = ((OrderLine) obj).getOrdLineId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append(ordLineId);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            
        }
    }

    @Override
    public void update(Object obj) {
        ordLine = (OrderLine) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(PURCHASE_ID).append(" = ?, ");
        query.append(BOOK_ISBN_13).append(" = ?, ");
        query.append(QUANTITY).append(" = ?, ");
        query.append(PRICE_HT).append(" = ?, ");
        query.append(VAT).append(" = ? ");

        query.append("WHERE " + ID + " = ")
                .append(ordLine.getOrdLineId());

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setInt(1, ordLine.getPurId().getPurId());
            pstmt.setString(2, ordLine.getBooIsbn13().getBooIsbn13());
            pstmt.setInt(3, ordLine.getOrdLineQuantity());
            pstmt.setFloat(4, ordLine.getOrdBookPriceHT());
            pstmt.setFloat(5, ordLine.getOrdBookVAT());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            

        }
    }

    @Override
    public Vector findAll() {
        orderLineList = new Vector<OrderLine>();
        pur = null;
        ordLine = null;
        book = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    pur = new Purchase();
                    book = new Book();

                    ordLine.setOrdLineId(rs.getInt(ID));
                    pur.setPurId(rs.getInt(PURCHASE_ID));
                    ordLine.setPurId(pur);
                    book.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ordLine.setBooIsbn13(book);
                    ordLine.setOrdLineQuantity(rs.getInt(QUANTITY));
                    ordLine.setOrdBookVAT(rs.getFloat(VAT));
                    ordLine.setOrdBookPriceHT(rs.getFloat(PRICE_HT));

                    orderLineList.add(ordLine);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
        }
        return orderLineList;
    }

    @Override
    public OrderLine find(int id) {
        pur = null;
        ordLine = null;
        book = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append(id);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    ordLine = new OrderLine();
                    pur = new Purchase();
                    book = new Book();

                    ordLine.setOrdLineId(rs.getInt(ID));
                    pur.setPurId(rs.getInt(PURCHASE_ID));
                    ordLine.setPurId(pur);
                    book.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ordLine.setBooIsbn13(book);
                    ordLine.setOrdLineQuantity(rs.getInt(QUANTITY));
                    ordLine.setOrdBookVAT(rs.getFloat(VAT));
                    ordLine.setOrdBookPriceHT(rs.getFloat(PRICE_HT));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return ordLine;
    }

    @Override
    public Object find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findByColumn(String column, String term) {
        orderLineList = new Vector<OrderLine>();
        pur = null;
        ordLine = null;
        book = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    ordLine = new OrderLine();
                    pur = new Purchase();
                    book = new Book();

                    ordLine.setOrdLineId(rs.getInt(ID));
                    pur.setPurId(rs.getInt(PURCHASE_ID));
                    ordLine.setPurId(pur);
                    book.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ordLine.setBooIsbn13(book);
                    ordLine.setOrdLineQuantity(rs.getInt(QUANTITY));
                    ordLine.setOrdBookVAT(rs.getFloat(VAT));
                    ordLine.setOrdBookPriceHT(rs.getFloat(PRICE_HT));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return orderLineList;
    }
    
    public Vector findByColumn(String column, int term) {
        orderLineList = new Vector<OrderLine>();
        pur = null;
        ordLine = null;
        book = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append(term);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    ordLine = new OrderLine();
                    pur = new Purchase();
                    book = new Book();

                    ordLine.setOrdLineId(rs.getInt(ID));
                    pur.setPurId(rs.getInt(PURCHASE_ID));
                    ordLine.setPurId(pur);
                    book.setBooIsbn13(rs.getString(BOOK_ISBN_13));
                    ordLine.setBooIsbn13(book);
                    ordLine.setOrdLineQuantity(rs.getInt(QUANTITY));
                    ordLine.setOrdBookVAT(rs.getFloat(VAT));
                    ordLine.setOrdBookPriceHT(rs.getFloat(PRICE_HT));
                    orderLineList.add(ordLine);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return orderLineList;
    }

}
