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
public class Determinate {
    
    private int StaCode;
    private int purId;
    private String detTime;
    
    //Constructor

    public Determinate() {
    }
    
    //Setters

    public void setStaCode(int StaCode) {
        this.StaCode = StaCode;
    }

    public void setPurId(int purId) {
        this.purId = purId;
    }

    public void setDetTime(String detTime) {
        this.detTime = detTime;
    }
    
    //Getters

    public int getStaCode() {
        return StaCode;
    }

    public int getPurId() {
        return purId;
    }

    public String getDetTime() {
        return detTime;
    }
    
}
