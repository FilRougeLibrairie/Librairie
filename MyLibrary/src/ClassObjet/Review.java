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
    private int cusId;
    private String booIsbn13;
    private int ordLineId;
    private Float revNote;
    private String revComment;
    private String revDate;
    private String revIP;

    //Constructor
    public Review() {
    }

    //Setters
    public void setRevId(int revId) {
        this.revId = revId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setBooIsbn13(String booIsbn13) {
        this.booIsbn13 = booIsbn13;
    }

    public void setOrdLineId(int ordLineId) {
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

    //Getters
    public int getRevId() {
        return revId;
    }

    public int getCusId() {
        return cusId;
    }

    public String getBooIsbn13() {
        return booIsbn13;
    }

    public int getOrdLineId() {
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

}
