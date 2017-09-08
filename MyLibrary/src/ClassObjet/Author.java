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
public class Author {

    private int autId;
    private String autLastName;
    private String autFirstName;
    private String autBiography;
    private int autStatusCode;

    //Constructor
    public Author() {
    }

    //Setters
    public void setAutId(int autId) {
        this.autId = autId;
    }

    public void setAutLastName(String autLastName) {
        this.autLastName = autLastName;
    }

    public void setAutFirstName(String autFirstName) {
        this.autFirstName = autFirstName;
    }

    public void setAutBiography(String autBiography) {
        this.autBiography = autBiography;
    }

    public void setAutStatusCode(int autStatusCode) {
        this.autStatusCode = autStatusCode;
    }

    //Getters
    public int getAutId() {
        return autId;
    }

    public String getAutLastName() {
        return autLastName;
    }

    public String getAutFirstName() {
        return autFirstName;
    }

    public String getAutBiography() {
        return autBiography;
    }

    public int getAutStatusCode() {
        return autStatusCode;
    }

}
