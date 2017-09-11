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
        
        System.out.println(Crypto.createPassword("1"));
        
    }
}
