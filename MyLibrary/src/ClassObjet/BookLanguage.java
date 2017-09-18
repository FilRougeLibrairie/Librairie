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
    
    private int booLangCode;
    private String booLangName;
    
    //Constructor

    public BookLanguage() {
    }

    public BookLanguage(int booLangCode, String booLangName) {
        this.booLangCode = booLangCode;
        this.booLangName = booLangName;
    }
    
    //Setters
    
    public void setBooLangCode(int booLangCode) {
        this.booLangCode = booLangCode;
    }

    public void setBooLangName(String booLangName) {
        this.booLangName = booLangName;
    }
    
    //Getters

    public int getBooLangCode() {
        return booLangCode;
    }

    public String getBooLangName() {
        return booLangName;
    }

    @Override
    public String toString() {
        return booLangName ;
    }
    
    
    
}
