/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Business.Crypto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Phong
 */
public class DbAccess {
    private Connection connection;
    private Statement statement;
    private static final String INSERT_INTO = "Insert Into";
    private static final String VALUE = "values";
    public DbAccess(){
        try {
            DbConnection dbConnection = new DbConnection();
            connection = dbConnection.GetConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
        }
    }
    
    public int RegisterAccount(String userId, String userName, String password, String classId){
        String passwordEncrypted = Crypto.Encryption(password);
        String input = INSERT_INTO + " Account " + VALUE + "('"+ userId +"','"+ userName +"','"+ passwordEncrypted +"',"+ classId+")";
        try {
            int i = statement.executeUpdate(input);
            return i;
        } catch (Exception e) {
            return -1;
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
}
