package ui.jfCustomer;

import ClassObjet.Address;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class AddressTableItem {

    private Address address;
    private String name;
    private int id;

    public AddressTableItem(Address address) {
        this.address = address;
        this.name = this.address.getAddLabel();
        this.id = this.address.getAddId();
    }

    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        return v;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return name;
    }

}
