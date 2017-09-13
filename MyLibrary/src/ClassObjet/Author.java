/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjet;

import java.util.Vector;

/**
 *
 * @author Tofi
 */
public class Author {

    private int autId;
    private Vector<Book> bookList;
    private String autLastName;
    private String autFirstName;
    private String autBiography;
    private int autStatusCode;

    //Constructor
    public Author() {
    }

    //Setters
    public void setAutId(int autId) {
        this.autId = autId;
    }
    
     public Vector<Book> getBookList() {
        return bookList;
    }

    public void setAutLastName(String autLastName) {
        this.autLastName = autLastName;
    }

    public void setAutFirstName(String autFirstName) {
        this.autFirstName = autFirstName;
    }

    public void setAutBiography(String autBiography) {
        this.autBiography = autBiography;
    }

    public void setAutStatusCode(int autStatusCode) {
        this.autStatusCode = autStatusCode;
    }

    //Getters
    public int getAutId() {
        return autId;
    }
    
    public void setBookList(Vector<Book> booIsbn13) {
        this.bookList = booIsbn13;
    }

    public String getAutLastName() {
        return autLastName;
    }

    public String getAutFirstName() {
        return autFirstName;
    }

    public String getAutBiography() {
        return autBiography;
    }

    public int getAutStatusCode() {
        return autStatusCode;
    }
    
    // Add / Remove Object into Vector
    public void addBook(Book book){
        bookList.add(book);
    }
    
    public void removeBook(Book book){
        bookList.remove(book);
    }
    
    
}
