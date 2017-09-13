package SQLS;

import java.sql.Connection;
import java.util.Vector;

public abstract class DAO<T> {

    protected Connection connect = null;

    public DAO() {
        connect =  ConnexionBase.getInstance();  
    }

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract Vector<T> findAll(String tableName);

    public abstract T findById(int id);

    public abstract T findByName(String name);
    

}
