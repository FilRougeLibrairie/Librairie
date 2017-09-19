/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.jfEmployee;

import ClassObjet.Employee;
import java.util.Vector;

/**
 *
 * @author cdi312
 */
public class EmployeeTableItem {
    
    Employee employee;
    String name;

    public EmployeeTableItem(Employee employee) {
        this.employee = employee;
        this.name = this.employee.getEmpLastName() + " " + this.employee.getEmpFirstName();
    }
    
    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        return v;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getName() {
        return name;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
 public String toString() {
     return name;
    }
}
