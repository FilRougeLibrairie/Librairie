/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassObjet;
import Names.SQLNames;
import java.util.Vector;
/**
 *
 * @author Tofi
 */
public class Editor implements SQLNames{

    private int ediId;
    private String ediName;
    private String ediPresentation;
    private int ediStatusCode;
    private Vector<Book> bookList;
    
    
       public Editor(int ediId, String ediName, String ediPresentation, int ediStatusCode) {
        this.ediId = ediId;
        this.ediName = ediName;
        this.ediPresentation = ediPresentation;
        this.ediStatusCode = ediStatusCode;
    }
    
    //Constructor
    public Editor() {
    }

    //Setters
    
    public void setEdiId(int ediId) {
        this.ediId = ediId;
    }

    public void setEdiName(String ediName) {
        this.ediName = ediName;
    }

    public void setEdiPresentation(String ediPresentation) {
        this.ediPresentation = ediPresentation;
    }

    public void setEdiStatusCode(int ediStatusCode) {
        this.ediStatusCode = ediStatusCode;
    }

     public Vector<Book> getBookList() {
        return bookList;
    }

    public Vector getVector() {
        Vector v= new Vector();
       
        v.add(this.getEdiId());
        v.add(this.getEdiName());
        v.add(this.getEdiPresentation());
        v.add(this.getEdiStatusCode());
      
        return v;
    }
    
    //Getters
    
    public int getEdiId() {
        return ediId;
    }

    public String getEdiName() {
        return ediName;
    }

    
    public String getEdiPresentation() {
        return ediPresentation;
    }

    public int getEdiStatusCode() {
        return ediStatusCode;
    }
    
    public String EdiStatusCode() {
        String Statut=null;
        if(ediStatusCode == 1){
            Statut = "Actif";
        }else if(ediStatusCode == 2){
            Statut = "Inactif";
        }
        return Statut;
    }
    
    //To String
    
    public String toString() {
        return "N° = " + ediId + "\n Nom = " + ediName + "\n Presentation = " + ediPresentation + "\n Statut = " + EdiStatusCode() ;
    }

    


}
