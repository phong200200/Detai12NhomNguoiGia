/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Business.Crypto;
import Business.Student;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Phong
 */
public class DbAccess {
    private Connection connection;
    private Statement statement;
    private static final String INSERT_INTO = "Insert Into";
    public DbAccess(){
        try {
            DbConnection dbConnection = new DbConnection();
            connection = dbConnection.GetConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
        }
    }
    public ResultSet Query(String input){
        try {
            ResultSet resultSet = statement.executeQuery(input);
            return resultSet;
        } catch (Exception e) {
            return null;
        }
    }
    public int SetMark(Student rawStudent) throws Exception{
        Student encryptedStudent = EncryptStudent(rawStudent);
        String value = "values ('"+ rawStudent.getStudentId()+"'"
                + ",'"+ encryptedStudent.getStudentName() +"'"
                + ",'"+ encryptedStudent.getMath() +"'"
                + ",'"+ encryptedStudent.getLet() +"'"
                + ",'"+ encryptedStudent.getEng() +"')";
        String input = INSERT_INTO 
                + " DiemSV "
                + value;
        try {
            int i = statement.executeUpdate(input);
            return i;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public ResultSet GetMark(String studentId){
        try {
            String query = "Select * from DiemSV where MSSV='"+studentId+"'";
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean ValidateStudentId(String id){
        try {
            String query = "Select * from DiemSV where MSSV='"+id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    private Student EncryptStudent(Student rawStudent) {
        Student student = new Student();
        try {
            String key = rawStudent.getStudentId().substring(2);
            System.out.println("Key : " + key);
            student.setStudentId(rawStudent.getStudentId());
            student.setStudentName(Crypto.Encryption(rawStudent.getStudentName(), key));
            student.setEng(Crypto.Encryption(rawStudent.getEng(), key));
            student.setLet(Crypto.Encryption(rawStudent.getLet(), key));
            student.setMath(Crypto.Encryption(rawStudent.getMath(), key));
        } catch (Exception ex) {
            Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return student;
    }
    
}
