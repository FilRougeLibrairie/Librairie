package dbAccess;

import Names.SQLNames;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.naming.NamingException;

public abstract class DAO<T> implements SQLNames, Serializable{

    protected Connection connect = null;

    public DAO() {
        connect =  ConnexionBase.getInstance();  
    }

    public abstract void create(T obj);

    public abstract void delete(T obj);

    public abstract void update(T obj);

    public abstract Vector<T> findAll();

    public abstract T find(int id);

    public abstract T find(String name);
    
    public abstract Vector<T> findByColumn(String column, String term);
    
}
