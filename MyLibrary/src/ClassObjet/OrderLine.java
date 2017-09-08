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
public class OrderLine {

    private int ordLineId;
    private int purId;
    private String booIsbn13;
    private int ordLineQuantity;
    private int ordBookPriceHT;
    private Float ordBookVAT;

    //contstructor
    public OrderLine() {
    }

    //Setters
    public void setOrdLineId(int ordLineId) {
        this.ordLineId = ordLineId;
    }

    public void setPurId(int purId) {
        this.purId = purId;
    }

    public void setBooIsbn13(String booIsbn13) {
        this.booIsbn13 = booIsbn13;
    }

    public void setOrdLineQuantity(int ordLineQuantity) {
        this.ordLineQuantity = ordLineQuantity;
    }

    public void setOrdBookPriceHT(int ordBookPriceHT) {
        this.ordBookPriceHT = ordBookPriceHT;
    }

    public void setOrdBookVAT(Float ordBookVAT) {
        this.ordBookVAT = ordBookVAT;
    }

   //Getters
    public int getOrdLineId() {
        return ordLineId;
    }

    public int getPurId() {
        return purId;
    }

    public String getBooIsbn13() {
        return booIsbn13;
    }

    public int getOrdLineQuantity() {
        return ordLineQuantity;
    }

    public int getOrdBookPriceHT() {
        return ordBookPriceHT;
    }

    public Float getOrdBookVAT() {
        return ordBookVAT;
    }

}
