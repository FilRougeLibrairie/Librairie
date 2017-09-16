package ui.jfCustomer;

import ClassObjet.Purchase;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class OrderTableItem {

    Purchase purchase;
    int reference;
    String date;
    String status;

    public OrderTableItem(Purchase purchase) {
        this.purchase = purchase;
        this.reference = purchase.getPurId();
        System.out.println(purchase);
        this.date = purchase.getShippingDate();
        this.status = "PAS DE STATUS (OrderTableItem)";
    }

    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        v.add(this.reference);
        v.add(this.status);
        return v;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return date;
    }

}
