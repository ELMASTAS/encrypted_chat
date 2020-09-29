/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_sifreli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Server {
    
    
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        

        ServerSocket Socket=new ServerSocket(5060);
        Socket s = Socket.accept();
          Scanner k=new Scanner(System.in);
             sifrelim sd=new sifrelim(new BigInteger("111547"),new BigInteger("34117"), new BigInteger("13"));//mesajı  şifrelemek için nesne oluşturdum 
             decode sdn=new decode (new BigInteger("111547"),new BigInteger("34117"), new BigInteger("13"));
             
             PrintWriter pw=new PrintWriter(s.getOutputStream(),true);// gönderdimmm

        String mesaj=k.nextLine();//mesajı  klavyeen  okudum
       String mm= sd.sifrele(mesaj);// mesaj  gönderdim şifrelemeye
      
      //şifreli mesajı tekraradan buraya alıp göndermen  gerekir 
        //şifrelemede return yaparak geri  dünderdim
        pw.println(mm);// şifreli  mesajı  karsı taraftaki  kullanıcıya gönderdim
        Thread.sleep(100);// mesajşarın çakışmasını engelemek için sleep attım
       BufferedReader br=new BufferedReader(new 
        InputStreamReader(s.getInputStream())); //mesaj alınma  nesnesi
 
       String m=br.readLine();// şifreli  mesajı  okudum 
        System.out.println(m);//şifreli  mesajı  console yazdırdım 
      String czm=sdn.sifreCoz(m);//şifreli  mesajı cözmek için  decodeme  gönderdim
     System.out.println(czm+"karsıdan alınan mesajın cözülmüş  hali");
 
   
}}
       
        ///////////////////
       
    