/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.BookLanguage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author CDI305
 */
public class BookLanguageDAO extends DAO<BookLanguage> {

    private final String TABLE = "BookLanguage";
    private final String CODE = BookLanguageNames.CODE;
    private final String NAME = BookLanguageNames.NAME;

    private String COLUMNS_CREATE = CODE + ", " + NAME;

    //Constructor
    public BookLanguageDAO() {
        super();
    }

    @Override
    public void create(BookLanguage obj) {
        BookLanguage bookLang = (BookLanguage) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + CODE + " = '" + bookLang.getBooLangCode() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, bookLang.getBooLangName());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void update(BookLanguage obj) {
        BookLanguage bookLang = (BookLanguage) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(NAME).append(" = ? ");

        query.append("WHERE " + CODE + " = '")
                .append(bookLang.getBooLangCode())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, bookLang.getBooLangName());
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    @Override
    public void delete(BookLanguage obj) {
        int bookLangId = ((BookLanguage) obj).getBooLangCode();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(CODE)
                .append(" = ")
                .append("'" + bookLangId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Vector<BookLanguage> findAll() {
        Vector<BookLanguage> bookLangList = new Vector<BookLanguage>();
        BookLanguage bookLang = null;
        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    bookLang = new BookLanguage();
                    bookLang.setBooLangCode(rs.getInt(CODE));
                    bookLang.setBooLangName(rs.getString(NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return bookLangList;
    }

    @Override
    public Vector<BookLanguage> findByColumn(String column, String term) {
        Vector<BookLanguage> bookLangList = new Vector<BookLanguage>();
        BookLanguage bookLang = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    bookLang = new BookLanguage();
                    bookLang.setBooLangCode(rs.getInt(CODE));
                    bookLang.setBooLangName(rs.getString(NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return bookLangList;
    }

    @Override
    public BookLanguage find(int id) {
        BookLanguage bookLang = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(CODE)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    bookLang = new BookLanguage();
                    bookLang.setBooLangCode(rs.getInt(CODE));
                    bookLang.setBooLangName(rs.getString(NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return bookLang;
    }

    @Override
    public BookLanguage find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}