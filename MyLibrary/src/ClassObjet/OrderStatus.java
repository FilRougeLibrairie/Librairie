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
    private int staValidate;

    //Constructor
    public OrderStatus() {
    }

    //Setters
    public void setStaCode(int staCode) {
        this.staCode = staCode;
    }

    public void setStaValidate(int staValidate) {
        this.staValidate = staValidate;
    }

    //Getters
    public int getStaCode() {
        return staCode;
    }

    public int getStaValidate() {
        return staValidate;
    }

}
