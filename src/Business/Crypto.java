/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.SECRET_KEY;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Phong
 */
public class Crypto {

    public static String Encryption(String password, String key) 
            throws NoSuchAlgorithmException, 
            NoSuchPaddingException, 
            InvalidKeyException, 
            IllegalBlockSizeException, 
            BadPaddingException {
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] byteEncrypted = cipher.doFinal(password.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
        return encrypted;
    }

    public static String Decryption(String passwordEncrypted, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "DES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] byteEncrypted = BASE64DecoderStream.decode(passwordEncrypted.getBytes());

        byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
        String decrypted = new String(byteDecrypted);
        return decrypted;
    }
}
