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
public class Vat {

    private int vatCode;
    private Float vatRate;
    private String vatName;

    //Constructor
    public Vat() {
    }

    public Vat(int vatCode, Float vatRate, String vatName) {
        this.vatCode = vatCode;
        this.vatRate = vatRate;
        this.vatName = vatName;
    }
    
    

    //Setters
    public void setVatCode(int vatCode) {
        this.vatCode = vatCode;
    }

    public void setVatRate(Float vatRate) {
        this.vatRate = vatRate;
    }

    public void setVatName(String vatName) {
        this.vatName = vatName;
    }

    //Getters
    public int getVatCode() {
        return vatCode;
    }

    public Float getVatRate() {
        return vatRate;
    }

    public String getVatName() {
        return vatName;
    }
    
    //vector
    
    public Vector getVector() {
        Vector v= new Vector();
       
        v.add(this.getVatCode());
        v.add(this.getVatRate());
        v.add(this.getVatName());
        
      
        return v;
    }

    @Override
    public String toString() {
        return vatRate + " " + vatName;
    }

    
}
