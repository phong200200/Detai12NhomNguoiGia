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

    public Connection GetConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;Database=DoAnLTM";
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Loi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static Connection GetConnection(String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;Database=DoAnLTM;user="+username+";password="+password+"";
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Loi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
