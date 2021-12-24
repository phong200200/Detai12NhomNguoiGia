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

public class Student {

    private String studentId;
    private String studentName;
    private String math;
    private String let;
    private String eng;

    public Student(String studentId, String studentName, String math, String let, String eng) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.math = math;
        this.let = let;
        this.eng = eng;
    }

    
    public Student() {
    }

    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getLet() {
        return let;
    }

    public void setLet(String let) {
        this.let = let;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }
}
