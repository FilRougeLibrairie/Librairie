package SQLS;

import ClassObjet.Employee;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class SQLS_EMP_TEST {

    ConnexionBase connexion;

    public SQLS_EMP_TEST() {

        connexion = new ConnexionBase();
    }

    public Vector loadDatasFromDB() throws SQLException, ParseException {

        Vector<Employee> empList = new Vector<Employee>();
        Employee emp = null;

        try (Statement stmt = this.connexion.getInstance().createStatement();) {

            String query = "SELECT * FROM Employee ORDER BY empLastName, empFirstName";
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
                
                empList.add(emp);
            }
        } catch (SQLException ex) {
            System.err.println("Oops! Statement métode loadContacts : " + ex.getErrorCode() + " / " + ex.getMessage());
            printStackTrace();
        }
        return empList;
    }
}
