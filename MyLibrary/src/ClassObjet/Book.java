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
public class Book {

    // creation des variables
    private String booIsbn13;
    private int vatCode;
    private String ediName;
    private String booTitle;
    private String booSubtitle;
    private String booPublishYear;
    private int booPriceHT;
    private String booResume;
    private int booQuantity;
    private int booStatus;
    private String booFrontCover;
    private int booPageNumber;
    private String booLangCode;
    
    //constructor

    public Book() {
    }
    
    //Setters

    public void setBooIsbn13(String booIsbn13) {
        this.booIsbn13 = booIsbn13;
    }

    public void setVatCode(int vatCode) {
        this.vatCode = vatCode;
    }

    public void setEdiName(String ediName) {
        this.ediName = ediName;
    }

    public void setBooTitle(String booTitle) {
        this.booTitle = booTitle;
    }

    public void setBooSubtitle(String booSubtitle) {
        this.booSubtitle = booSubtitle;
    }

    public void setBooPublishYear(String booPublishYear) {
        this.booPublishYear = booPublishYear;
    }

    public void setBooPriceHT(int booPriceHT) {
        this.booPriceHT = booPriceHT;
    }

    public void setBooResume(String booResume) {
        this.booResume = booResume;
    }

    public void setBooQuantity(int booQuantity) {
        this.booQuantity = booQuantity;
    }

    public void setBooStatus(int booStatus) {
        this.booStatus = booStatus;
    }

    public void setBooFrontCover(String booFrontCover) {
        this.booFrontCover = booFrontCover;
    }

    public void setBooPageNumber(int booPageNumber) {
        this.booPageNumber = booPageNumber;
    }

    public void setBooLangCode(String booLangCode) {
        this.booLangCode = booLangCode;
    }
    
    
    //Getters

    public String getBooIsbn13() {
        return booIsbn13;
    }

    public int getVatCode() {
        return vatCode;
    }

    public String getEdiName() {
        return ediName;
    }

    public String getBooTitle() {
        return booTitle;
    }

    public String getBooSubtitle() {
        return booSubtitle;
    }

    public String getBooPublishYear() {
        return booPublishYear;
    }

    public int getBooPriceHT() {
        return booPriceHT;
    }

    public String getBooResume() {
        return booResume;
    }

    public int getBooQuantity() {
        return booQuantity;
    }

    public int getBooStatus() {
        return booStatus;
    }

    public String getBooFrontCover() {
        return booFrontCover;
    }

    public int getBooPageNumber() {
        return booPageNumber;
    }

    public String getBooLangCode() {
        return booLangCode;
    }
    

}
