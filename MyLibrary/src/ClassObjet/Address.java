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
public class Address {

    private int addId;
    private Customer cusResidId;
    private Customer cusChargerId;
    private String addLabel;
    private String addFirstName;
    private String addLastName;
    private String addCompany;
    private String addNumber;
    private String addStreetType;
    private String addStreetName;
    private String addComplement;
    private String addZipCode;
    private String addCity;
    private String addSecurityCode;
    private String addPhone;

    //Constructor
    public Address() {
    }

    //Setters
    public void setAddId(int addId) {
        this.addId = addId;
    }

    public void setCusResidId(Customer cusResidId) {
        this.cusResidId = cusResidId;
    }

    public void setCusChargerId(Customer cusChargerId) {
        this.cusChargerId = cusChargerId;
    }

    public void setAddLabel(String addLabel) {
        this.addLabel = addLabel;
    }

    public void setAddFirstName(String addFirstName) {
        this.addFirstName = addFirstName;
    }

    public void setAddLastName(String addLastName) {
        this.addLastName = addLastName;
    }

    public void setAddCompany(String addCompany) {
        this.addCompany = addCompany;
    }

    public void setAddNumber(String addNumber) {
        this.addNumber = addNumber;
    }

    public void setAddStreetType(String addStreetType) {
        this.addStreetType = addStreetType;
    }

    public void setAddStreetName(String addStreetName) {
        this.addStreetName = addStreetName;
    }

    public void setAddComplement(String addComplement) {
        this.addComplement = addComplement;
    }

    public void setAddZipCode(String addZipCode) {
        this.addZipCode = addZipCode;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public void setAddSecurityCode(String addSecurityCode) {
        this.addSecurityCode = addSecurityCode;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    //Getters
    public int getAddId() {
        return addId;
    }

    public Customer getCusResidId() {
        return cusResidId;
    }

    public Customer getCusChargerId() {
        return cusChargerId;
    }

    public String getAddLabel() {
        return addLabel;
    }

    public String getAddFirstName() {
        return addFirstName;
    }

    public String getAddLastName() {
        return addLastName;
    }

    public String getAddCompany() {
        return addCompany;
    }

    public String getAddNumber() {
        return addNumber;
    }

    public String getAddStreetType() {
        return addStreetType;
    }

    public String getAddStreetName() {
        return addStreetName;
    }

    public String getAddComplement() {
        return addComplement;
    }

    public String getAddZipCode() {
        return addZipCode;
    }

    public String getAddCity() {
        return addCity;
    }

    public String getAddSecurityCode() {
        return addSecurityCode;
    }

    public String getAddPhone() {
        return addPhone;
    }

}
