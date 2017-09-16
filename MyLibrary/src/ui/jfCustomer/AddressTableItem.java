package ui.jfCustomer;

import ClassObjet.Address;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */


public class AddressTableItem {

    Address address;
    String name;

    public AddressTableItem(Address address) {
        this.address = address;
        this.name = this.address.getAddLabel();
    }
    
     public Vector getVector(){
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

    @Override
    public String toString() {
        return name;
    }

}
