package utils;

import exceptions.CryptoException;
import java.security.NoSuchAlgorithmException;
import utils.Crypto;

/**
 *
 * @author ggarvanese
 */
public class Pass_Gen {
    public static void main(String[] args) throws NoSuchAlgorithmException, CryptoException {
        
       String[] pwd = Crypto.createPassword("1");
        System.out.println(pwd[0]);
        System.out.println(pwd[1]);
        
    }
}
