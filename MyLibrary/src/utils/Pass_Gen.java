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
        
        /// Create New Password
        String[] pwd = Crypto.createPassword("1");
        
        System.out.println();
        System.out.println("HASH PASSWORD [0] : " + pwd[0]);
        System.out.println("SALT [1] : " + pwd[1]);
        
        System.out.println("\n********************************\n");
        
        //// Verify passwd
        String passwd = "123";
        String hash = "0A53109BB464455F72D0038CB98090691D16B3B75E80E33A3E6D07984784153A180A5F47439084869C18E94351E848E89A07D658ABB8C2D80D7F2A311D40C8EA";
        String salt = "dk9fu5u0bjflbcq0p64rp6d4gv";
        
        String result = Crypto.hashPassword(salt, passwd);
        System.out.println("Does my passwd & salt match the hashed passwd ? " + result.equalsIgnoreCase(hash));
        System.out.println();
        
        
    }
}
