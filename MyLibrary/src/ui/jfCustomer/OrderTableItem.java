package ui.jfCustomer;

import ClassObjet.Purchase;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class OrderTableItem {

    private Purchase purchase;
    private int reference;
    private String date;
    private String status;

    public OrderTableItem(Purchase purchase) {
        this.purchase = purchase;
        this.reference = purchase.getPurId();
        this.date = purchase.getShippingDate();
        String lastStatusName = purchase.getOrderstatusList().lastElement().getStaName();
        if (lastStatusName == null || lastStatusName.isEmpty()) {
            this.status = "Status non renseigné";
        } else {
            this.status = lastStatusName;
        }

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
