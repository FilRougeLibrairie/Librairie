/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exceptions.CryptoException;
import java.security.NoSuchAlgorithmException;
import utils.Crypto;

/**
 *
 * @author cdi308
 */
public class Pass_Gen {
    public static void main(String[] args) throws NoSuchAlgorithmException, CryptoException {
        
        System.out.println(Crypto.createPassword("1"));
        
    }
}
