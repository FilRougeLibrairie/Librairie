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
public class GettingAccess {
    
    private int empId;
    private int accProfilCode;
    private String getStartDate;
    private String getEndDate;
    
    //Constructor

    public GettingAccess() {
    }
    
    //Setters

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setAccProfilCode(int accProfilCode) {
        this.accProfilCode = accProfilCode;
    }

    public void setGetStartDate(String getStartDate) {
        this.getStartDate = getStartDate;
    }

    public void setGetEndDate(String getEndDate) {
        this.getEndDate = getEndDate;
    }
    
    
    //Getters

    public int getEmpId() {
        return empId;
    }

    public int getAccProfilCode() {
        return accProfilCode;
    }

    public String getGetStartDate() {
        return getStartDate;
    }

    public String getGetEndDate() {
        return getEndDate;
    }
    
    
    
}
