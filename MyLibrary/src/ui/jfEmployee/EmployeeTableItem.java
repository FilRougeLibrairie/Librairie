/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.jfEmployee;

import ClassObjet.Employee;
import ClassObjet.StatusDisplay;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author cdi312
 */
public class EmployeeTableItem {

    Employee employee;
    StatusDisplay statusDisplayNom;
    String lastName;
    String firstName;
    String login;
    int status;
    String profile;
    java.sql.Date startDate;
    java.sql.Date endDate;

    public EmployeeTableItem(Employee employee) {
        this.employee = employee;
        this.lastName = this.employee.getEmpLastName();
        this.firstName = this.employee.getEmpFirstName();
        this.login = this.employee.getEmpLogin();
        this.status = this.employee.getEmpStatus();
        this.profile = this.employee.getAccProfileCode().getAccProfileName();
        this.startDate = this.employee.getEmpDateStart();
        this.endDate = this.employee.getEmpDateEnd();
        
    }

    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        v.add(firstName);
        v.add(login);
        v.add(status);
        v.add(profile);
        v.add(startDate);
        v.add(endDate);
        return v;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public StatusDisplay getStatusDisplayNom() {
        return statusDisplayNom;
    }

    public int getStatus() {
        return status;
    }

    public String getProfile() {
        return profile;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setStatusDisplayNom(StatusDisplay statusDisplayNom) {
        this.statusDisplayNom = statusDisplayNom;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return lastName;
    }
}
