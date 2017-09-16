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
public class OrderStatus {

    private int staCode;
    private String staName;
    Vector<Purchase> purchaseList;

    //Constructor
    public OrderStatus() {
    }

    //Setters
    public void setStaCode(int staCode) {
        this.staCode = staCode;
    }

    public void setStaName(String staName) {
        this.staName = staName;
    }

    //Getters
    public int getStaCode() {
        return staCode;
    }

    public String getStaName() {
        return staName;
    }

    public Vector<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(Vector<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }
    
    public void addPurchase(Purchase purchase){
        purchaseList.add(purchase);
    }

    public void removePurchase(Purchase purchase){
        purchaseList.remove(purchase);
    }

}
