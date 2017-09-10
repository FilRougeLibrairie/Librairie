package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.xml.bind.DatatypeConverter;

/**
 * The {@code Crypto} static class is used to create and verify passwords
 * @author Guillaume
 */
public class Crypto {
    
    private final static String HASH_ALGORITHM = "SHA-512";

    public static String hashPassword(String salt, char[] password) throws NoSuchAlgorithmException {
        String userPassword = new String(password);
        String userSalt;

        if (salt == null) {
            userSalt = generateSalt();
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
        return UUID.randomUUID().toString();
    }

    public static String createPassword(char[] password) throws NoSuchAlgorithmException {
        return hashPassword(null, password);
    }

}
