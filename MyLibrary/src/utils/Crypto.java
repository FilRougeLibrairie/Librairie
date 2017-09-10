package utils;

import exceptions.CryptoException;
import static java.lang.Math.random;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.xml.bind.DatatypeConverter;

/**
 * The {@code Crypto} static class is used to create and verify passwords
 *
 * @author Guillaume
 */
public class Crypto {

    private final static String HASH_ALGORITHM = "SHA-512";

    public static String hashPassword(String salt, String password) throws NoSuchAlgorithmException, CryptoException {
        String userPassword = new String(password);
        String userSalt;

        if (salt == null) {
            throw new CryptoException(salt);
        } else {
            userSalt = salt;
        }

        String concatedPassword = userSalt + userPassword;
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] hash = digest.digest(concatedPassword.getBytes(StandardCharsets.UTF_8));
        String hashStr = DatatypeConverter.printHexBinary(hash);
        return hashStr;
    }

    private static String generateSalt() {
        //return UUID.randomUUID().toString();
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static String createPassword(String password) throws NoSuchAlgorithmException, CryptoException {
        return hashPassword(generateSalt(), password);
    }

}
