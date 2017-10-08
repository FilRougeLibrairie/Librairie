package dbAccess;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnexionBasePool implements Serializable {

    private DataSource ds;

    public ConnexionBasePool() throws NamingException {
        InitialContext ct = new InitialContext();
        ds = (DataSource) ct.lookup("jdbc/maBase");
    }

    public Connection getInstance() throws SQLException {
        return ds.getConnection();
    }

}
