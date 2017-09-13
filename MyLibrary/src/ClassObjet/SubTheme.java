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
public class SubTheme {

    private int subId;
    private Theme theId;
    private String subName;
    private String subDescription;
    private Vector<Book> bookList;

    //Constructor
    public SubTheme() {
    }

    //Setters
    public void setSubId(int subId) {
        this.subId = subId;
    }

    public void setTheId(Theme theId) {
        this.theId = theId;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setSubDescription(String subDescription) {
        this.subDescription = subDescription;
    }

    public void setBookList(Vector<Book> bookList) {
        this.bookList = bookList;
    }

    //Getters
    public int getSubId() {
        return subId;
    }

    public Theme getTheId() {
        return theId;
    }

    public String getSubName() {
        return subName;
    }

    public String getSubDescription() {
        return subDescription;
    }

    public Vector<Book> getBookList() {
        return bookList;
    }
    
    public void addBook(Book book){
        bookList.add(book);
    }
    
    public void removeBook(Book book){
        bookList.remove(book);
    }

}
