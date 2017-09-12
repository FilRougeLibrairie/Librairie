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
public class Employee {

    private int empId;
    private String empFirstName;
    private String empLastName;
    private String empLogin;
    private String empPassword;
    private String empSalt;
    private String empDateStart;
    private String empDateEnd;
    private AccessProfile accProfileCode;
    private int empStatus;
    private String empComment;

    //Constructor
    public Employee() {
    }

    //Setters
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public void setEmpLogin(String empLogin) {
        this.empLogin = empLogin;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public void setEmpSalt(String empSalt) {
        this.empSalt = empSalt;
    }

    public void setEmpDateStart(String empDateStart) {
        this.empDateStart = empDateStart;
    }

    public void setEmpDateEnd(String empDateEnd) {
        this.empDateEnd = empDateEnd;
    }

    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
    }

    public void setAccProfileCode(AccessProfile accProfileCode) {
        this.accProfileCode = accProfileCode;
    }

    public void setEmpComment(String empComment) {
        this.empComment = empComment;
    }

    //Getters
    public int getEmpId() {
        return empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public String getEmpLogin() {
        return empLogin;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public String getEmpSalt() {
        return empSalt;
    }

    public String getEmpDateStart() {
        return empDateStart;
    }

    public String getEmpDateEnd() {
        return empDateEnd;
    }

    public int getEmpStatus() {
        return empStatus;
    }

    public AccessProfile getAccProfileCode() {
        return accProfileCode;
    }

    public String getEmpComment() {
        return empComment;
    }

    @Override
    public String toString() {
        return "***** Employee ID : " + empId + "\n"
                + "empFirstName=" + empFirstName + "\n"
                + "empLastName=" + empLastName + "\n"
                + "empLogin=" + empLogin + "\n"
                + "empPassword=" + empPassword + "\n"
                + "empSalt=" + empSalt + "\n"
                + "empDateStart=" + empDateStart + "\n"
                + "empDateEnd=" + empDateEnd + "\n"
                + "empStatus=" + empStatus + "\n"
                + "empProfileCode=" + accProfileCode.getAccProfileCode() + "\n"
                + "empComment=" + empComment + "\n"
                + "***************";
    }

}
