package SQLS;

import ClassObjet.Book;
import ClassObjet.BookLanguage;
import ClassObjet.Editor;
import ClassObjet.Formats;
import ClassObjet.Vat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class BookDAO extends DAO {

    private final String TABLE = "Book";

    private final String ISBN_13 = BookNames.ISBN_13;
    private final String VAT_CODE = BookNames.VAT_CODE;
    private final String EDITOR_CODE = BookNames.EDITOR_CODE;
    private final String TITLE = BookNames.TITLE;
    private final String SUBTITLE = BookNames.SUBTITLE;
    private final String PUBLICATION_YEAR = BookNames.PUBLICATION_YEAR;
    private final String PRICE_HT = BookNames.PRICE_HT;
    private final String RESUME = BookNames.RESUME;
    private final String QUANTITY = BookNames.QUANTITY;
    private final String STATUS = BookNames.STATUS;
    private final String FRONT_COVER = BookNames.FRONT_COVER;
    private final String PAGE_NUMBER = BookNames.PAGE_NUMBER;
    private final String LANGUAGE_ID = BookNames.LANGUAGE_ID;
    private final String FORMAT_ID = BookNames.FORMAT_ID;

    Vector<Book> bookList;
    private Book book;
    private Vat vatCode;
    private Editor ediId;
    private BookLanguage booLangCode;
    private Formats format;

    private String COLUMNS_CREATE = ISBN_13 + ", " + VAT_CODE + ", "
            + EDITOR_CODE + ", " + TITLE + ", " + SUBTITLE + ", "
            + PUBLICATION_YEAR + ", " + PRICE_HT + ", " + RESUME + ", "
            + QUANTITY + ", " + STATUS + ", " + FRONT_COVER + ", "
            + PAGE_NUMBER + ", " + LANGUAGE_ID + ", " + FORMAT_ID;

    public BookDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        book = (Book) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ISBN_13 + " = '" + book.getBooIsbn13() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, book.getBooIsbn13());
            pstmt.setFloat(2, book.getVatCode().getVatCode());
            pstmt.setInt(3, book.getEdiId().getEdiId());
            pstmt.setString(4, book.getBooTitle());
            pstmt.setString(5, book.getBooSubtitle());
            pstmt.setString(6, book.getBooPublishYear());
            pstmt.setInt(7, book.getBooPriceHT());
            pstmt.setString(8, book.getBooResume());
            pstmt.setInt(9, book.getBooQuantity());
            pstmt.setInt(10, book.getBooStatus());
            pstmt.setString(11, book.getBooFrontCover());
            pstmt.setInt(12, book.getBooPageNumber());
            pstmt.setInt(13, book.getBooLangCode().getBooLangCode());
            pstmt.setInt(14, book.getFormat().getForId());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void delete(Object obj) {
        String bookId = ((Book) obj).getBooIsbn13();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ISBN_13)
                .append(" = ")
                .append("'" + bookId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object obj) {
        book = (Book) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(VAT_CODE).append(" = ?, ");
        query.append(EDITOR_CODE).append(" = ?, ");
        query.append(TITLE).append(" = ?, ");
        query.append(SUBTITLE).append(" = ?, ");
        query.append(PUBLICATION_YEAR).append(" = ? ");
        query.append(PRICE_HT).append(" = ? ");
        query.append(RESUME).append(" = ? ");
        query.append(QUANTITY).append(" = ? ");
        query.append(STATUS).append(" = ? ");
        query.append(FRONT_COVER).append(" = ? ");
        query.append(PAGE_NUMBER).append(" = ? ");
        query.append(LANGUAGE_ID).append(" = ? ");
        query.append(FORMAT_ID).append(" = ? ");

        query.append("WHERE " + ISBN_13 + " = '")
                .append(book.getBooIsbn13())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setFloat(1, book.getVatCode().getVatCode());
            pstmt.setInt(2, book.getEdiId().getEdiId());
            pstmt.setString(3, book.getBooTitle());
            pstmt.setString(4, book.getBooSubtitle());
            pstmt.setString(5, book.getBooPublishYear());
            pstmt.setInt(6, book.getBooPriceHT());
            pstmt.setString(7, book.getBooResume());
            pstmt.setInt(8, book.getBooQuantity());
            pstmt.setInt(9, book.getBooStatus());
            pstmt.setString(10, book.getBooFrontCover());
            pstmt.setInt(11, book.getBooPageNumber());
            pstmt.setInt(12, book.getBooLangCode().getBooLangCode());
            pstmt.setInt(13, book.getFormat().getForId());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    @Override
    public Vector findAll() {
        bookList = new Vector<Book>();
        book = null;
        vatCode = null;
        ediId = null;
        booLangCode = null;
        format = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    book = new Book();
                    vatCode = new Vat();
                    ediId = new Editor();
                    booLangCode = new BookLanguage();
                    format = new Formats();
                    
                    book.setBooIsbn13(rs.getString(ISBN_13));
                    
                    //////   RUNNING  ///////////
                    

                    bookList.add(book);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return bookList;
    }

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findByCriteria(String criteria, String term) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
