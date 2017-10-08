package treatments;

import dbAccess.CustomerDAO;
import entities.Customer;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author ggarvanese
 */


public class test {
    public static void main(String[] args) {

       
            CustomerDAO cDAO = new CustomerDAO();
            Vector<Customer> v = cDAO.findAll();
            System.out.println("---------------- DEBUT ------------");
            for(Customer c : v){
                System.out.println(c.getCusID());
            }
            System.out.println("---------------- FIN ------------");
      

    }
}
