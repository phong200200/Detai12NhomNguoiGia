/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.sun.java.accessibility.util.EventID;
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
            //Todo: Validate lúc nhập 8 số, bm sẽ cắt nó ra cho :))
            if (key.length() == 10) {
                System.out.println("Thằng Key này đủ r đấy");

                //Cho điều kiện đúng thì cho nó nhập vào đây, ko thì đá nó ra
                String hello = "2.24";
                System.out.println("key: " + key.substring(2));
                System.out.println("Input: " + hello);
                encrypted = Crypto.Encryption(hello, key.substring(2));
                System.out.println("Encrypted: " + encrypted);
            } else {
                System.out.println("Thừa hoặc thiếu thằng này!");
            }
            System.out.println("Decrypted: " + Crypto.Decryption(encrypted, key.substring(2)));
        } catch (Exception ex) {
            System.out.println("Loi me roi: \t" + ex);
        }

    }

}
