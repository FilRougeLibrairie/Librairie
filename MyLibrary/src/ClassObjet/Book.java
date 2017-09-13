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
public class Book {

    // creation des variables
    private String booIsbn13;
    private String booTitle;
    private String booSubtitle;
    private String booPublishYear;
    private int booPriceHT;
    private String booResume;
    private int booQuantity;
    private int booStatus;
    private String booFrontCover;
    private int booPageNumber;

    private Vector<Author> authorList;
    private Vector<SubTheme> subThemeList;
    private Vector<Offer> offerList;
    private Vector<Keywords> keyWordsList;
    private Vat vatCode;
    private Editor ediId;
    private BookLanguage booLangCode;
    private Formats format;

    //constructor
    public Book() {
    }

    //Setters
    public void setBooIsbn13(String booIsbn13) {
        this.booIsbn13 = booIsbn13;
    }

    public void setVatCode(Vat vatCode) {
        this.vatCode = vatCode;
    }

    public void setEdiId(Editor ediId) {
        this.ediId = ediId;
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

    public void setBooLangCode(BookLanguage booLangCode) {
        this.booLangCode = booLangCode;
    }

    public void setFormat(Formats format) {
        this.format = format;
    }

    //Getters
    public String getBooIsbn13() {
        return booIsbn13;
    }

    public Vat getVatCode() {
        return vatCode;
    }

    public Editor getEdiId() {
        return ediId;
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

    public BookLanguage getBooLangCode() {
        return booLangCode;
    }

    public Formats getFormat() {
        return format;
    }

    public Vector<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(Vector<Author> authorList) {
        this.authorList = authorList;
    }

    public Vector<SubTheme> getSubThemeList() {
        return subThemeList;
    }

    public void setSubThemeList(Vector<SubTheme> subThemeList) {
        this.subThemeList = subThemeList;
    }

    public Vector<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(Vector<Offer> offerList) {
        this.offerList = offerList;
    }

    public Vector<Keywords> getKeyWordsList() {
        return keyWordsList;
    }

    public void setKeyWordsList(Vector<Keywords> keyWordsList) {
        this.keyWordsList = keyWordsList;
    }

    public void addAuthor(Author author) {
        authorList.add(author);
    }

    public void removeAuthor(Author author) {
        authorList.remove(author);
    }

    public void addSubTheme(SubTheme subTheme) {
        subThemeList.add(subTheme);
    }

    public void removeSubTheme(SubTheme subTheme) {
        subThemeList.remove(subTheme);
    }

    public void addKeywords(Keywords keywords) {
        keyWordsList.add(keywords);
    }

    public void removeKeywords(Keywords keywords) {
        keyWordsList.remove(keywords);
    }

    public void addOffer(Offer offer) {
        offerList.add(offer);
    }

    public void removeOffer(Offer offer) {
        offerList.remove(offer);
    }

    @Override
    public String toString() {
        return "Book{" + "booIsbn13=" + booIsbn13 + ", booTitle=" + booTitle + ", booSubtitle=" + booSubtitle + ", booPublishYear=" + booPublishYear + ", booPriceHT=" + booPriceHT + ", booResume=" + booResume + ", booQuantity=" + booQuantity + ", booStatus=" + booStatus + ", booFrontCover=" + booFrontCover + ", booPageNumber=" + booPageNumber + ", authorList=" + authorList + ", subThemeList=" + subThemeList + ", offerList=" + offerList + ", keyWordsList=" + keyWordsList + ", vatCode=" + vatCode + ", ediId=" + ediId + ", booLangCode=" + booLangCode + '}';
    }

}
