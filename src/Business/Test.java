/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String encrypted = null;
        try {
            // TODO code application logic here
            String key = "1811063475";
            String hello = "2.24";
            System.out.println("key: " + key.substring(2) );
            encrypted = Crypto.Encryption(hello, key.substring(2));
            System.out.println("Encrypted: " + encrypted);
            //Todo: Validate lúc nhập 8 số, bm sẽ cắt nó ra cho :))
            System.out.println("Decrypted: " +Crypto.Decryption(encrypted, key.substring(2)));
        } catch (Exception ex) {
            System.out.println("Loi me roi " + ex);
        }
        
    }
    
}
