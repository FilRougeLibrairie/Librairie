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
public class Theme {

    private int theId;
    private String theName;
    private String theDescription;

    //Constructor
    public Theme() {
    }

    //Setters
    public void setTheId(int theId) {
        this.theId = theId;
    }

    public void setTheName(String theName) {
        this.theName = theName;
    }

    public void setTheDescription(String theDescription) {
        this.theDescription = theDescription;
    }

    //Getters
    public int getTheId() {
        return theId;
    }

    public String getTheName() {
        return theName;
    }

    public String getTheDescription() {
        return theDescription;
    }

}