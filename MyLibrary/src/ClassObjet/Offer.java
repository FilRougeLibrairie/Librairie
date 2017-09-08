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
public class Offer {

    private int offId;
    private String offName;
    private String offText;
    private String offDateStart;
    private String offDateEnd;
    private Float offDiscount;
    private String offPicture;

    //Constructor
    public Offer() {
    }

    //Setters
    public void setOffId(int offId) {
        this.offId = offId;
    }

    public void setOffName(String offName) {
        this.offName = offName;
    }

    public void setOffText(String offText) {
        this.offText = offText;
    }

    public void setOffDateStart(String offDateStart) {
        this.offDateStart = offDateStart;
    }

    public void setOffDateEnd(String offDateEnd) {
        this.offDateEnd = offDateEnd;
    }

    public void setOffDiscount(Float offDiscount) {
        this.offDiscount = offDiscount;
    }

    public void setOffPicture(String offPicture) {
        this.offPicture = offPicture;
    }

    //Getters
    public int getOffId() {
        return offId;
    }

    public String getOffName() {
        return offName;
    }

    public String getOffText() {
        return offText;
    }

    public String getOffDateStart() {
        return offDateStart;
    }

    public String getOffDateEnd() {
        return offDateEnd;
    }

    public Float getOffDiscount() {
        return offDiscount;
    }

    public String getOffPicture() {
        return offPicture;
    }

}
