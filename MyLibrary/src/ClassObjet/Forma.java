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
public class Forma {
    
    private String forName;
    private int forId;
    
    //Constructor

    public Forma() {
    }

    public Forma(String forName) {
        this.forName = forName;
    }

    public Forma(int forId,String forName ) {
        this.forId = forId;
        this.forName = forName;
    }

    
    
   
    //Setters

    public void setForName(String forName) {
        this.forName = forName;
    }

    public void setForId(int forId) {
        this.forId = forId;
    }
    
    //Getters

    public String getForName() {
        return forName;
    }

    public int getForId() {
        return forId;
    }
    
      public Vector getVector() {
        Vector v= new Vector();
       v.add(this.getForId());
        v.add(this.getForName());
        
      
        return v;
    }
    
    
    
    
}
