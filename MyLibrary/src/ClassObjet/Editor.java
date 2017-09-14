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
public class Editor {

    private int ediId;
    private String ediName;
    private String ediPresentation;
    private int ediStatusCode;

    //Constructor
    public Editor() {
    }

    //Setters
    
    public void setEdiId(int ediId) {
        this.ediId = ediId;
    }

    public void setEdiName(String ediName) {
        this.ediName = ediName;
    }

    public void setEdiPresentation(String ediPresentation) {
        this.ediPresentation = ediPresentation;
    }

    public void setEdiStatusCode(int ediStatusCode) {
        this.ediStatusCode = ediStatusCode;
    }

    //Getters
    
    public int getEdiId() {
        return ediId;
    }

    public String getEdiName() {
        return ediName;
    }

    public String getEdiPresentation() {
        return ediPresentation;
    }

    public int getEdiStatusCode() {
        return ediStatusCode;
    }

}
