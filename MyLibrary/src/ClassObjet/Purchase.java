/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjet;

/**
 *
 * @author Tofi
 */
public class Purchase {

    private int purId;
    private int cusId;
    private int shippingCostId;
    private int addDeliveryId;
    private int addInvoiceId;
    private String purIP;
    private String shippingDate;
    private int shippingNumber;

    //Constructor
    public Purchase() {
    }

    //Setters
    public void setPurId(int purId) {
        this.purId = purId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setShippingCostId(int shippingCostId) {
        this.shippingCostId = shippingCostId;
    }

    public void setAddDeliveryId(int addDeliveryId) {
        this.addDeliveryId = addDeliveryId;
    }

    public void setAddInvoiceId(int addInvoiceId) {
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

    public int getCusId() {
        return cusId;
    }

    public int getShippingCostId() {
        return shippingCostId;
    }

    public int getAddDeliveryId() {
        return addDeliveryId;
    }

    public int getAddInvoiceId() {
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

}
