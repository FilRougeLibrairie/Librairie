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
public class OrderStatus {

    private int staCode;
    private String staName;

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

}
