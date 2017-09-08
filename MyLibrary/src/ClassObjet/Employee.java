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
    private String empDateStart;
    private String empDateEnd;
    private int empStatus;

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

    public void setEmpDateStart(String empDateStart) {
        this.empDateStart = empDateStart;
    }

    public void setEmpDateEnd(String empDateEnd) {
        this.empDateEnd = empDateEnd;
    }

    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
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

    public String getEmpDateStart() {
        return empDateStart;
    }

    public String getEmpDateEnd() {
        return empDateEnd;
    }

    public int getEmpStatus() {
        return empStatus;
    }

}
