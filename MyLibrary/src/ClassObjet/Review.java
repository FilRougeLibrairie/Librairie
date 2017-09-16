/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjet;

/**
 *
 * @author Tofi
 */
public class Review {

    private int revId;
    private Customer cusId;
    private String booIsbn13;
    private OrderLine ordLineId;
    private Float revNote;
    private String revComment;
    private String revDate;
    private String revIP;
    private String revStatus;
    private Book book;


    //Setters
    public void setRevId(int revId) {
        this.revId = revId;
    }

    public void setCusId(Customer cusId) {
        this.cusId = cusId;
    }

    public void setBooIsbn13(String booIsbn13) {
        this.booIsbn13 = booIsbn13;
    }

    public void setOrdLineId(OrderLine ordLineId) {
        this.ordLineId = ordLineId;
    }

    public void setRevNote(Float revNote) {
        this.revNote = revNote;
    }

    public void setRevComment(String revComment) {
        this.revComment = revComment;
    }

    public void setRevDate(String revDate) {
        this.revDate = revDate;
    }

    public void setRevIP(String revIP) {
        this.revIP = revIP;
    }

    public void setRevStatus(String revStatus) {
        this.revStatus = revStatus;
    }
    
    
    
    //Getters
    public int getRevId() {
        return revId;
    }

    public Customer getCusId() {
        return cusId;
    }

    public String getBooIsbn13() {
        return booIsbn13;
    }

    public OrderLine getOrdLineId() {
        return ordLineId;
    }

    public Float getRevNote() {
        return revNote;
    }

    public String getRevComment() {
        return revComment;
    }

    public String getRevDate() {
        return revDate;
    }

    public String getRevIP() {
        return revIP;
    }

    public String getRevStatus() {
        return revStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    

    @Override
    public String toString() {
        return "Review{" + "revId=" + revId + ", cusId=" + cusId + ", booIsbn13=" + booIsbn13 + ", ordLineId=" + ordLineId + ", revNote=" + revNote + ", revComment=" + revComment + ", revDate=" + revDate + ", revIP=" + revIP + ", revStatus=" + revStatus + '}';
    }
    
    
    
}
