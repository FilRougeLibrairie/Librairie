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
public class Customer {

    private int cusID;
    private String cusGender;
    private String cusFirstName;
    private String cusLastName;
    private String cusOrganisationName;
    private String cusEmail;
    private String cusPhoneNumber;
    private String cusDateOfBirth;
    private String cusPassword;
    private String cusSalt;
    private String cusIP;
    private int cusStatus;
    private String cusComment;
   

    //Constructor
    public Customer() {
    }

    //Setters
    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public void setCusGender(String cusGender) {
        this.cusGender = cusGender;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public void setCusOrganisationName(String cusOrganisationName) {
        this.cusOrganisationName = cusOrganisationName;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public void setCusPhoneNumber(String cusPhoneNumber) {
        this.cusPhoneNumber = cusPhoneNumber;
    }

    public void setCusDateOfBirth(String cusDateOfBirth) {
        this.cusDateOfBirth = cusDateOfBirth;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public String getCusSalt() {
        return cusSalt;
    }

    public void setCusSalt(String cusSalt) {
        this.cusSalt = cusSalt;
    }

    public void setCusIP(String cusIP) {
        this.cusIP = cusIP;
    }

    public void setCusStatus(int cusStatus) {
        this.cusStatus = cusStatus;
    }

    public void setCusComment(String cusComment) {
        this.cusComment = cusComment;
    }

    //Getters
    public int getCusID() {
        return cusID;
    }

    public String getCusGender() {
        return cusGender;
    }

    public String getCusFirstName() {
        return cusFirstName;
    }

    public String getCusLastName() {
        return cusLastName;
    }

    public String getCusOrganisationName() {
        return cusOrganisationName;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public String getCusPhoneNumber() {
        return cusPhoneNumber;
    }

    public String getCusDateOfBirth() {
        return cusDateOfBirth;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public String getCusIP() {
        return cusIP;
    }

    public int getCusStatus() {
        return cusStatus;
    }

    public String getCusComment() {
        return cusComment;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusID=" + cusID + ", cusGender=" + cusGender + ", cusFirstName=" + cusFirstName + ", cusLastName=" + cusLastName + ", cusOrganisationName=" + cusOrganisationName + ", cusEmail=" + cusEmail + ", cusPhoneNumber=" + cusPhoneNumber + ", cusDateOfBirth=" + cusDateOfBirth + ", cusPassword=" + cusPassword + ", cusSalt=" + cusSalt + ", cusIP=" + cusIP + ", cusStatus=" + cusStatus + ", cusComment=" + cusComment + '}';
    }
    
    

}
