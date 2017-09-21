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
public class AccessProfile {

    private int accProfileCode;
    private String accProfileName;

    //Constructor
    public AccessProfile() {
    }

    //Setters
    public void setAccProfileCode(int accProfileCode) {
        this.accProfileCode = accProfileCode;
    }

    public void setAccProfileName(String accProfileName) {
        this.accProfileName = accProfileName;
    }

    //Getters
    public int getAccProfileCode() {
        return accProfileCode;
    }

    public String getAccProfileName() {
        return accProfileName;
    }

    @Override
    public String toString() {
        return "Access Profile Code : " + accProfileCode + " / Access Profile Name : " + accProfileName;
    }

    public Object getAccProfileName(String profil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
