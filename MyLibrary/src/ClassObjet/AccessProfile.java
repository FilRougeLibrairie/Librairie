
package ClassObjet;

import java.util.Vector;


public class AccessProfile {

    private int accProfileCode;
    private String accProfileName;

    //Constructor
    public AccessProfile() {
    }

    public AccessProfile(int accProfileCode, String accProfileName) {
        this.accProfileCode = accProfileCode;
        this.accProfileName = accProfileName;
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
     public Vector getVector() {
        Vector v= new Vector();
       
        v.add(this.getAccProfileCode());
        v.add(this.getAccProfileName());
      
        return v;
    }

}
