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
public class BookLanguage {
    
    private String booLangCode;
    private String booLangName;
    
    //Constructor

    public BookLanguage() {
    }
    
    //Setters
    
    public void setBooLangCode(String booLangCode) {
        this.booLangCode = booLangCode;
    }

    public void setBooLangName(String booLangName) {
        this.booLangName = booLangName;
    }
    
    //Getters

    public String getBooLangCode() {
        return booLangCode;
    }

    public String getBooLangName() {
        return booLangName;
    }
    
    
}
