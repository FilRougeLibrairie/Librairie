/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Offer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author cdi312
 */
public class OfferDAO extends DAO {

    private final String TABLE = "Offer";

    private final String ID = OfferNames.ID;
    private final String NAME = OfferNames.NAME;
    private final String TEXT = OfferNames.TEXT;
    private final String START = OfferNames.START;
    private final String END = OfferNames.END;
    private final String DISCOUNT = OfferNames.DISCOUNT;
    private final String PICTURE = OfferNames.PICTURE;
    private final String STATUS = OfferNames.STATUS;

    private String COLUMNS_CREATE = NAME + ", " + TEXT
            + ", " + START + ", " + END + ", " + DISCOUNT + ", " + PICTURE+ " , " +STATUS;

    public OfferDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Offer off = (Offer) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + off.getOffId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, off.getOffName());
            pstmt.setString(2, off.getOffText());
            pstmt.setString(3, off.getOffDateStart());
            pstmt.setString(4, off.getOffDateEnd());
            pstmt.setFloat(5, off.getOffDiscount());
            pstmt.setString(6, off.getOffPicture());
            pstmt.setInt(7, off.getOffStatus());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());

        }
    }

    @Override
    public void delete(Object obj) {
        int offId = ((Offer) obj).getOffId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + offId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
    }

    @Override
    public void update(Object obj) {
        Offer off = (Offer) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(NAME).append(" =?, ");
        query.append(TEXT).append(" =?, ");
        query.append(START).append(" =?, ");
        query.append(END).append(" =?, ");
        query.append(DISCOUNT).append(" =?, ");
        query.append(PICTURE).append(" =? ");

        query.append("WHERE " + ID + " = '")
                .append(off.getOffId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {
            pstmt.setString(1, off.getOffName());
            pstmt.setString(2, off.getOffText());
            pstmt.setString(3, off.getOffDateStart());
            pstmt.setString(4, off.getOffDateEnd());
            pstmt.setFloat(5, off.getOffDiscount());
            pstmt.setString(6, off.getOffPicture());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());

        }
    }

    @Override
    public Vector findAll() {
        Vector<Offer> offerList = new Vector<Offer>();
        Offer offer = null;

        String query = "SELECT * FROM " + TABLE;
        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    offer = new Offer();
                    offer.setOffId(rs.getInt(ID));
                    offer.setOffName(rs.getString(NAME));
                    offer.setOffText(rs.getString(TEXT));
                    offer.setOffDateStart(rs.getString(START));
                    offer.setOffDateEnd(rs.getString(END));
                    offer.setOffDiscount(rs.getFloat(DISCOUNT));
                    offer.setOffPicture(rs.getString(PICTURE));
                    offer.setOffStatus(rs.getInt(STATUS));
                    offerList.add(offer);
                }
            } else {
                throw new SQLException("ResultSet was emplty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return offerList;
    }

    @Override
    public Object find(int id) {
        Offer offer = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    offer.setOffId(rs.getInt(ID));
                    offer.setOffName(rs.getString(NAME));
                    offer.setOffText(rs.getString(TEXT));
                    offer.setOffDateStart(rs.getString(START));
                    offer.setOffDateEnd(rs.getString(END));
                    offer.setOffDiscount(rs.getFloat(DISCOUNT));
                    offer.setOffPicture(rs.getString(PICTURE));
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return offer;
    }

    @Override
    public Object find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Offer> findByColumn(String column, String term) {

        Vector<Offer> offerList = new Vector<Offer>();
        Offer offer = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + "WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    offer.setOffId(rs.getInt(ID));
                    offer.setOffName(rs.getString(NAME));
                    offer.setOffText(rs.getString(TEXT));
                    offer.setOffDateStart(rs.getString(START));
                    offer.setOffDateEnd(rs.getString(END));
                    offer.setOffDiscount(rs.getFloat(DISCOUNT));
                    offer.setOffPicture(rs.getString(PICTURE));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
        }
        return offerList;
    }

    public Offer findCurrentOfferByBook(String isbn13) {
        Offer currentOffer = null;
        StringBuilder query = new StringBuilder();
        query.append("DECLARE ")
                .append("@currentTime DATETIME = GETDATE(), ")
                .append("@book_Isbn varchar(13) = '" + isbn13 + "' ")
                .append("SELECT * ")
                .append("FROM Offer offe ")
                .append("JOIN Have hav ")
                .append("ON offe.offId = Hav.offId ")
                .append("JOIN Book book ")
                .append("ON hav.booIsbn13 = book.booIsbn13 ")
                .append("WHERE book.booIsbn13 = @book_Isbn ")
                .append("AND offe.offDateStart < @currentTime ")
                .append("AND offe.offDateEnd > @currentTime ")
                .append("ORDER BY offDateEnd DESC ");
        
         try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    currentOffer = new Offer();
                    currentOffer.setOffId(rs.getInt(ID));
                    currentOffer.setOffName(rs.getString(NAME));
                    currentOffer.setOffText(rs.getString(TEXT));
                    currentOffer.setOffDateStart(rs.getString(START));
                    currentOffer.setOffDateEnd(rs.getString(END));
                    currentOffer.setOffDiscount(rs.getFloat(DISCOUNT));
                    currentOffer.setOffPicture(rs.getString(PICTURE));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
        }
        return currentOffer;
    }
}
