package SQLS;

import ClassObjet.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ggarvanese
 */
public class EmployeeDAO extends DAO<Employee> {

    private final String ID = "empId";
    private final String FIRSTNAME = "empLastName";
    private final String LASTNAME = "empFirstName";
    private final String LOGIN = "empLogin";
    private final String PASSWORD = "empPassword";
    private final String SALT = "empSalt";
    private final String DATE_START = "empDateStart";
    private final String DATE_END = "empDateEnd";
    private final String STATUS = "empStatus";
    private final String PROFILE = "accProfileCode";
    private final String COMMENT = "empComment";
    
    private String STMT_COLUMNS = ID + "," + FIRSTNAME + "," + LASTNAME + "," + LOGIN
            + "," + PASSWORD + "," + SALT + "," + DATE_START + "," + DATE_END + "," + STATUS
             + "," + PROFILE + "," + COMMENT;
    
    private String PSTMT_COLUMNS = FIRSTNAME + "," + LASTNAME + "," + LOGIN
            + "," + PASSWORD + "," + SALT + "," + DATE_START + "," + DATE_END + "," + STATUS
             + "," + PROFILE + "," + COMMENT + ID;
    
    // Constructor
    public EmployeeDAO(ConnexionBase conn) {
        super(conn);
    }

    @Override
    public boolean create(Employee obj) {
        return false;
    }

    @Override
    public boolean delete(Employee obj) {
        return false;
    }

    @Override
    public boolean update(Employee obj) {
        return false;
    }

    @Override
    public Employee find(int id) {
        Employee employee = new Employee();
        try {
            ResultSet result = this.connect.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Employee WHERE empId = " + id);
           
            if (result.first()) {
                employee = new Employee();
                employee.setEmpId(id);
                employee.setEmpFirstName(result.getString(FIRSTNAME));
                employee.setEmpLastName(result.getString(LASTNAME));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
