/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjet;

import java.util.Vector;

/**
 *
 * @author Tofi
 */
public class Purchase {

    private int purId;
    private Customer cusId;
    private ShippingCost shippingCostId;
    private Address addDeliveryId;
    private Address addInvoiceId;
    private String purIP;
    private String shippingDate;
    private int shippingNumber;
    Vector<OrderStatus> orderstatusList;
    

    //Constructor
    public Purchase() {
    }

    //Setters
    public void setPurId(int purId) {
        this.purId = purId;
    }

    public void setCusId(Customer cusId) {
        this.cusId = cusId;
    }

    public void setShippingCostId(ShippingCost shippingCostId) {
        this.shippingCostId = shippingCostId;
    }

    public void setAddDeliveryId(Address addDeliveryId) {
        this.addDeliveryId = addDeliveryId;
    }

    public void setAddInvoiceId(Address addInvoiceId) {
        this.addInvoiceId = addInvoiceId;
    }

    public void setPurIP(String purIP) {
        this.purIP = purIP;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setShippingNumber(int shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    //Getters
    public int getPurId() {
        return purId;
    }

    public Customer getCusId() {
        return cusId;
    }

    public ShippingCost getShippingCostId() {
        return shippingCostId;
    }

    public Address getAddDeliveryId() {
        return addDeliveryId;
    }

    public Address getAddInvoiceId() {
        return addInvoiceId;
    }

    public String getPurIP() {
        return purIP;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public int getShippingNumber() {
        return shippingNumber;
    }

    public Vector<OrderStatus> getOrderstatusList() {
        return orderstatusList;
    }

    public void setOrderstatusList(Vector<OrderStatus> orderstatusList) {
        this.orderstatusList = orderstatusList;
    }
    
    public void addOrderStatus(OrderStatus orderStatus){
        orderstatusList.add(orderStatus);
    }
    
   public void removeOrderStatus(OrderStatus orderStatus){
        orderstatusList.remove(orderStatus);
    }

    @Override
    public String toString() {
        return "Purchase Id :" + purId + "\n"
                + "customer Id : " + cusId + "\n"
                + "Shipping Cost Id : " + shippingCostId + "\n"
                + "Delivery Address Id : " + addDeliveryId + "\n"
                + "Invoice Address Id : " + addInvoiceId + "\n"
                + "Purchase IP : " + purIP + "\n"
                + "Shipping Date : " + shippingDate + "\n"
                + "Shipping Number : " + shippingNumber;
    }

}
