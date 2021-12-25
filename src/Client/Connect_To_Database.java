/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import javax.swing.JOptionPane;
import DAL.DbConnection;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;

/**
 *
 * @author laihu
 */
public class Connect_To_Database extends javax.swing.JFrame {

    /**
     * Creates new form Connect_To_Database
     */
    public Connect_To_Database() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DbUserName_txt = new javax.swing.JTextField();
        DbPass_txt = new javax.swing.JPasswordField();
        Connect_btn = new javax.swing.JButton();
        return_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DbName_txt = new javax.swing.JTextField();
        Port_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("UserName");

        jLabel2.setText("Password");

        Connect_btn.setText("Kết nối");
        Connect_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Connect_btnActionPerformed(evt);
            }
        });

        return_btn.setText("Quay về");
        return_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_btnActionPerformed(evt);
            }
        });

        jLabel3.setText("DbName");

        jLabel4.setText("Port");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Port_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(return_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DbName_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DbUserName_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DbPass_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Connect_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DbUserName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DbPass_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Connect_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(DbName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(Port_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(return_btn)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void return_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Input_Address_To_UDP_Server inputaddr = new Input_Address_To_UDP_Server();
        inputaddr.show();
    }//GEN-LAST:event_return_btnActionPerformed

    private void Connect_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Connect_btnActionPerformed
        // TODO add your handling code here:
        if (DbUserName_txt.getText().length() > 0 && DbPass_txt.getPassword().length > 0) {
            String Dbname = DbName_txt.getText();
            String port = Port_txt.getText();
            String username = DbUserName_txt.getText();
            String password = DbPass_txt.getText();
//            DbConnection dbconn = new DbConnection(port, Dbname, username, password);
//            Connection conn = dbconn.GetConnection();
//            String URL = dbconn.getUrl();

            //Gửi lên server
            if (Client.ValidateData.isPortvalid(port)) {
                byte[] sendData;
                try {
                    DatagramSocket socket = new DatagramSocket();
                    String diachi = Input_Address_To_UDP_Server.IPAddress;
                    InetAddress ipServer = InetAddress.getByName(diachi);
                    int UDPport = Input_Address_To_UDP_Server.PORT;

                    String chuoi = "";
                    chuoi = "jdbc:sqlserver://localhost:" + port + ";Database=" + Dbname + ";user=" + username + ";password=" + password + "";
                    System.out.println("Chuoi: " + chuoi);
                    String Send = chuoi;  //>>/// Thằng này chứa thông tin gửi
                    sendData = Send.getBytes();

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipServer, UDPport);
                    socket.send(sendPacket);
                    //Nhận từ server
                    String status = Recieve(socket);
                    if (status.equals("Success")) {
                        Input_Information_Form input_info = new Input_Information_Form();
                        this.dispose();
                        input_info.show();
                    }
                } catch (Exception e) {
                    System.out.println("Đéo ổn r: " + e);
                }

                System.out.println("Đc r");
            } else {
                System.out.println("Đéo ổn r");
                JOptionPane.showMessageDialog(null, "Đéo ổn r, thiếu cmj đấy ý", "Đéo ổn r đại vương ơi", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_Connect_btnActionPerformed

    private String Recieve(DatagramSocket socket) {
        //TODO: Tấn nhận về hộ t với, địt mẹ nó ngu r
        
        try {
            String ketqua = "Success";
            return ketqua;
        } catch (Exception e) {
            System.out.println("Hu me roi");
            return null;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connect_To_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connect_To_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connect_To_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connect_To_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connect_To_Database().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connect_btn;
    private javax.swing.JTextField DbName_txt;
    private javax.swing.JPasswordField DbPass_txt;
    private javax.swing.JTextField DbUserName_txt;
    private javax.swing.JTextField Port_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton return_btn;
    // End of variables declaration//GEN-END:variables

}
