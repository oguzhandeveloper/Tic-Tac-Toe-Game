/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Geri dönen değer : "draw,player1"
 *
 *
 *
 *
 *
 */
package game;

import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author OGUZHAN
 */
public class GamePanelSocket extends GamePanel {

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

   Thread t1;
   Thread t2;
    public void main(String[] args) {
        if(t1 != null && t2 != null)
        {
            t1.stop();
            t2.stop();
            t1=null;
            t2=null;
        }
        System.out.println("Giriş");
        GamePanelSocket gm=this;
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
                GameFrameServer.main(null);
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2");
               gm.ClientTakeAndConnect();
            }
        });
        t1.start();
        t2.start();
        
        
    }

    public GamePanelSocket(GameFrame mainWindow) {
        super(mainWindow);
    }

    public void ClientTakeAndConnect() {
        try {
            s = new Socket("127.0.0.1", 3000); // here the ip adress  is local address because i am running  the 
            System.out.println("Client Giriş");
            // client and server at same computer
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            String msgin = "";
            while (!msgin.equals("exit")) {
                this.ClientSend();
                msgin = din.readUTF();
                String[] str = msgin.split(",");
                System.out.println(msgin);
                this.player1 = str[1] == "true" ? false : true;
                this.draw = Integer.parseInt(str[0]);
                
            }
            System.out.println("Client Çıkış");

        } catch (Exception e) {
            System.out.println("Hata Mesaj Alınamadı veya servera bağlanılamadı");
        }
    }
    
    public void ClientSend(){
        String msout="";
        try{
            msout = "deneme";
            dout.writeUTF(msout);
        }catch(Exception e){
            System.out.println("Hata Message Gönderilemedi");
        }
    }
    
    
   

}
