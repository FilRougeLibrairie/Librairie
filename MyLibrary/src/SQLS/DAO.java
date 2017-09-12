package SQLS;

public abstract class DAO<T> {

    protected ConnexionBase connect = null;

    public DAO(ConnexionBase conn) {
        this.connect = conn;
    }

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(int id);

}