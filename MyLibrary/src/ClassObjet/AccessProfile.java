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

    private int accProfilCode;
    private String accProfileName;

    //Constructor
    public AccessProfile() {
    }

    //Setters
    public void setAccProfileCode(int accProfilCode) {
        this.accProfilCode = accProfilCode;
    }

    public void setAccProfileName(String accProfileName) {
        this.accProfileName = accProfileName;
    }

    //Getters
    public int getAccProfileCode() {
        return accProfilCode;
    }

    public String getAccProfileName() {
        return accProfileName;
    }

    @Override
    public String toString() {
        return "Access Profile Code : " + accProfilCode + " / Access Profile Name : " + accProfileName;
    }
    
    

}
