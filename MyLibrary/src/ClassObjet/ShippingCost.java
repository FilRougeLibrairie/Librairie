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
public class ShippingCost {

    private int shipId;
    private Shipper shipperId;
    private String shipName;
    private Float shipCost;

    //Constructor
    public ShippingCost() {
    }

    //Setters
    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public void setShipperId(Shipper shipperId) {
        this.shipperId = shipperId;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setShipCost(Float shipCost) {
        this.shipCost = shipCost;
    }

    //Getters
    public int getShipId() {
        return shipId;
    }

    public Shipper getShipperId() {
        return shipperId;
    }

    public String getShipName() {
        return shipName;
    }

    public Float getShipCost() {
        return shipCost;
    }

}
