/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Business.Crypto;
import Business.Student;
import DAL.DbAccess;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Cursor;
import javax.swing.JOptionPane;

/**
 *
 * @author Phong
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String id = "1811063475";
        DbAccess dbAccess = new DbAccess();

        Student student = new Student(id, "Truong Quoc Phong", "5.0", "8.6", "9.0");

        // TODO code application logic here
        try {

            int result = dbAccess.SetMark(student);
            if (result != 0) {
                System.out.println("Thanh cong");
            } else {
                System.out.println("!!!!Thanh cong");
            }

        } catch (Exception ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi~~ input");
        }

        ResultSet rs = dbAccess.GetMark(id);
        try {
            while (rs.next()) {
                try {
                    String _id = id.substring(2);
                    System.out.println("ID: " + _id);
                    String studentid = rs.getString("MSSV");
                    System.out.println("Sstudentid: " +studentid );
                    
                    String name = rs.getString("HoTen");
                    
                    System.out.println("HoTen: " +name );
                    System.out.println("Decr: " + Crypto.Decryption(name, _id));
                    
                    String math = rs.getString("DiemToan");
                    System.out.println("math: " +math );
                    System.out.println("Decr math: " + Crypto.Decryption(math.trim(), _id));
                    
                    String let = rs.getString("DiemVan");
                    System.out.println("let: " +let );
                    System.out.println("Decr let: " + Crypto.Decryption(let.trim(), _id));
                    
                    String eng = rs.getString("DiemAnh");
                    System.out.println("eng: " +eng );
                    System.out.println("Decr eng: " + Crypto.Decryption(eng.trim(), _id));
                } catch (Exception ex) {
                    Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Recieve() {
        try {
            // TODO code application logic here

            DatagramSocket server = new DatagramSocket(8888);
            System.out.println("Server đã chạy!!! đợi nhận thông tin");
            while (true) {
                //Giai đoạn 3: trao đổi client và server
                //Giai đoạn 3.3: server tạo packet để nhận thông tin từ client( cần 2 tham số: 1 mảng dữ liệu, 2 là chiều dài mảng dữ liêu)
                byte nhanson[] = new byte[256];
                byte nhansob[] = new byte[256];
                DatagramPacket repacket = new DatagramPacket(nhanson, nhanson.length);
                server.receive(repacket);

                DatagramPacket repacket2 = new DatagramPacket(nhansob, nhanson.length);
                server.receive(repacket2);
                //Giai đoạn 3.4: xử lý dữ liệu
                String str = new String(repacket.getData(), 0, repacket.getLength()).trim();
                String str2 = new String(repacket2.getData(), 0, repacket2.getLength()).trim();
                System.out.println("str = " + str);
                System.out.println("str2 = " + str2);
                int n = Integer.parseInt(str);
                int base = Integer.parseInt(str2);
                String convert = "";
                //Giai đoạn 3.5: server tạo packet dùng để gửi (cần 4 tham số: 1 mảng dữ liệu, chiều dài mảng, địa chỉ đích, cổng đích)
                byte send[] = new byte[256];
                send = convert.getBytes();
                InetAddress ip = repacket.getAddress();
                int port = repacket.getPort();
                DatagramPacket guifi = new DatagramPacket(send, send.length, ip, port);
                server.send(guifi);
            }
        } catch (SocketException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
