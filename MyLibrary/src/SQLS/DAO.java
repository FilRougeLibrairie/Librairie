package SQLS;

import Names.SQLNames;
import java.sql.Connection;
import java.util.Vector;

public abstract class DAO<T> implements SQLNames{

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
