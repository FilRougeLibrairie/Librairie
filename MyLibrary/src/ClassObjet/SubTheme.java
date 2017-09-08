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
public class SubTheme {

    private int subId;
    private int theId;
    private String subName;
    private String subDescription;

    //Constructor
    public SubTheme() {
    }

   //Setters
    public void setSubId(int subId) {
        this.subId = subId;
    }

    public void setTheId(int theId) {
        this.theId = theId;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setSubDescription(String subDescription) {
        this.subDescription = subDescription;
    }

    //Getters
    public int getSubId() {
        return subId;
    }

    public int getTheId() {
        return theId;
    }

    public String getSubName() {
        return subName;
    }

    public String getSubDescription() {
        return subDescription;
    }

}
