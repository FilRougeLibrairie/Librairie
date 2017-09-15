package ui.jfCustomer;

import ClassObjet.Customer;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */


public class CustomerTable {

    Customer customer;
    String name;

    public CustomerTable(Customer customer) {
        this.customer = customer;
        this.name = this.customer.getCusLastName() + " " + this.customer.getCusFirstName();
    }
    
     public Vector getVector(){
        Vector v = new Vector();    
        v.add(this);
        return v;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public String getName() {
        return name;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
