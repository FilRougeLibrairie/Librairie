package SQLS;

import ClassObjet.AccessProfile;
import ClassObjet.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */


public class Employee_SQL1 {

    ConnexionBase connexion;
    
    

    public Employee_SQL1() {

        connexion = new ConnexionBase();
    }

    public Vector loadDatasFromDB() throws SQLException, ParseException {

        Vector<Employee> empList = new Vector<Employee>();
        
        Employee emp = null;
        AccessProfile accessProfile = null;

        try (Statement stmt = this.connexion.getInstance().createStatement();) {

            String query = "SELECT * "
                    + "FROM Employee emp "
                    + "JOIN AccessProfile accP "
                    + "ON emp.accProfileCode = accP.accProfileCode "
                    + "ORDER BY empLastName, empFirstName";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emp = new Employee();
                
                emp.setEmpId(rs.getInt("empId"));
                emp.setEmpLastName(rs.getString("empLastName"));
                emp.setEmpFirstName(rs.getString("empFirstName"));
                emp.setEmpStatus(rs.getInt("empStatus"));
                emp.setEmpLogin(rs.getString("empLogin"));
                emp.setEmpPassword(rs.getString("empPassword"));
                emp.setEmpSalt("empSalt");
                
                accessProfile = new AccessProfile();
                accessProfile.setAccProfileCode(rs.getInt("accProfileCode"));
                emp.setAccProfileCode(accessProfile);
                //access.setAccProfileCode(rs.getInt("accProfileName"));
                
                empList.add(emp);
            }
        } catch (SQLException ex) {
            System.err.println("Statement Error in method loadContacts, class Employee_SQL : " + ex.getErrorCode() + " / " + ex.getMessage());
        }
        return empList;
    }
}
