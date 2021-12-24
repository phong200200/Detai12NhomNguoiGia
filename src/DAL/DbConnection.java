/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Phong
 */
public class DbConnection {

    private String url;
    private String Port;
    private String DbName;
    private String Username;
    private String Password;

    public DbConnection(String Port, String DbName, String username, String password){
        this.url = "jdbc:sqlserver://localhost:" + Port + ";Database=" + DbName + ";user=" + username + ";password=" + password + "";
    }

    public DbConnection() {
    }
    
    public Connection GetConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Loi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static Connection GetConnection(String Port, String DbName, String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:" + Port + ";Database=" + DbName + ";user=" + username + ";password=" + password + "";
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Loi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
