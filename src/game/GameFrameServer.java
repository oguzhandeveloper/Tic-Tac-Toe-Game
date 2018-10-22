/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 * Şuan için bu class hatalı çalışmaktadı
 * TODO: Server Bağlantısı ve Playerlar arasında konuşma
 * TODO: Veri Gönderimi ve Alımı
 * TODO: X ve O Yazdırmada Hata
 * TODO: Client' ı Clients'a dönüştürme 
 * TODO: 
 * 
 * 
 */



package game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author OGUZHAN
 */
public class GameFrameServer {
    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    public static void main(String[] args) {
        if( ss != null)
            ss=null;
        if(s!=null)
            s=null;
        try {
            ss = new ServerSocket(3000); //server start at 1201 port number
            s = ss.accept(); //now server will accept the connections.
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            String msgin = "";
            while (!msgin.equals("exit")) {
                msgin = din.readUTF();
                System.out.println("Client "+msgin);
                ServerYansit();
            }
        } catch (Exception e) {
            System.out.println("Hata Mesaj Alınamadı veya Bağlantı Sağlanamadı");
        }
    }
    
    public static void ServerYansit(){
         try {
            String msg_Out = "";
            msg_Out = "2,true";
            dout.writeUTF(msg_Out); // Sending  the server message   to the  client
        } catch (Exception e) {
            System.out.println("Hata Mesaj Gönderilemedi");
        }
    }
    
    
    
}
