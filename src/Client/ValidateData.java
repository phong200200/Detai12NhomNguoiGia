/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

/**
 *
 * @author laihu
 */
public class ValidateData {

    public static void main(String[] args) {
        String point = "ádadkhsdfa";
        if (isSubjectPoint(point)) {
            System.out.println("Chuẩn");
        } else {
            System.out.println("Sai mẹ r");
        }
    }

    public static boolean isSubjectPoint(String p) {
        try {
            Float.parseFloat(p);
            if (Float.parseFloat(p) < 0 || Float.parseFloat(p) > 10) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPortvalid(String p) {
        try {
            Integer.parseInt(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
