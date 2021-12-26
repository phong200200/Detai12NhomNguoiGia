/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Phong
 */
public class AverageMark {
    public static float Calculate(float math, float lit, float eng){
        return (math + lit + eng) / 3;
    }
}
