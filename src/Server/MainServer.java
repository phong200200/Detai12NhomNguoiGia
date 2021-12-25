/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Business.Crypto;
import Business.Student;
import Client.Input_Address_To_UDP_Server;
import DAL.DbAccess;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Cursor;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Phong
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static final int PORT = 1221;
    private DatagramSocket server = null;

    public MainServer() {
        try {
            server = new DatagramSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Action() {
        try {
            while (true) {
                byte nhanson[] = new byte[256];
                //Thằng nhận
                DatagramPacket repacket = new DatagramPacket(nhanson, nhanson.length);
                System.out.println("Server đã chạy!!! đợi nhận thông tin");

                //Nhận Data r gán vô
                String url = Receive(repacket, server);
                if (url != null) {
                    DbAccess dbAccess = new DbAccess(url);

                    //
                    Send("Success", repacket);
                }

                DatagramPacket repacketInfor = new DatagramPacket(nhanson, nhanson.length);
                String infor = Receive(repacketInfor, server);
                Student student = new Student();
                student = MakeStudent(infor);
                System.out.println("SV: "+ student.getStudentId());
                DbAccess dbaccess = new DbAccess(url);
                int result = dbaccess.SetMark(student);
                if(result == -1){
                    Send("Failed!", repacketInfor);
                }else{
                    Send("Sucess", repacketInfor);
                }
            }
        } catch (Exception ex) {
//            ms.Send("Failed",re);
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        MainServer ms = new MainServer();
        ms.Action();
    }

    public String Receive(DatagramPacket repacket, DatagramSocket server) {
        try {
            boolean flag = false;
            while (!flag) {
//                DatagramSocket server = new DatagramSocket(PORT); 
                server.receive(repacket);
                String strRecieved = new String(repacket.getData(), 0, repacket.getLength()).trim(); // Lấy chuỗi
                System.out.println("Chuỗi nhận: " + strRecieved);
                flag = true;
                return strRecieved;
            }
        } catch (SocketException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        System.out.println("PORT là: " + PORT);
        return null;
    }

    public void Send(String chuoi, DatagramPacket packet) {
        try {
            DatagramSocket server = new DatagramSocket();
//            int port = PORT;
            byte son[] = new byte[256];
            son = String.valueOf(chuoi).getBytes();
            int lenght = son.length;
            InetAddress host = null;
//            InetAddress host = InetAddress.getByName(Input_Address_To_UDP_Server.IPAddress);
            int port;
            host = packet.getAddress();
            port = packet.getPort();
            DatagramPacket gui = new DatagramPacket(son, lenght, host, port);
            server.send(gui);
            System.out.println("Sent: " + gui);
        } catch (Exception e) {

        }
    }

    private Student MakeStudent(String infor) {
        try {
            String[] hs = new String[6];
            hs = infor.split("/");
            Student st = new Student(hs[1],hs[0],hs[2],hs[3],hs[4]);
            return st;
        } catch (Exception ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
