
package SQLS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnexionBase {
    private String url="jdbc:sqlserver://localhost;database=MyLibrary";
    String user = "sa";
    String mdp = "sa";
    private static Connection connect;

    private ConnexionBase() {
        
        try {
            connect = DriverManager.getConnection(url, user, mdp);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
            
        }
    }
    
    public static Connection getInstance(){
        if(connect==null){
            new ConnexionBase();
        }
        return connect;
    }
}
