/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.security.GeneralSecurityException;

/**
 *
 * @author PC
 */
public class CryptoException extends GeneralSecurityException {

    public CryptoException() {
    }

    public CryptoException(String message) {
        super(message);
    }
    
    
    
}
