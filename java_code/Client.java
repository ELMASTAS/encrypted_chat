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
import java.net.Socket;
import java.util.Scanner;
 

public class Client {
    
    public static void main(String[] args) throws IOException, InterruptedException {
 Socket s=new Socket("localhost",5060);
    Scanner k=new Scanner(System.in);
   
        BufferedReader br=new BufferedReader(new 
        InputStreamReader(s.getInputStream())); //alindi
     decode sd=new decode (new BigInteger("111547"),new BigInteger("34117"), new BigInteger("13"));
        String m=br.readLine();
      
         System.out.println(m+" normal  sekildeki alınan mesaj ");//karsı taraftan aldığım şifreli mesaj
         
         String f=sd.sifreCoz(m);//şifreyi cözmek için decodem gönderdim
         
        System.out.println(f+" cözülmuş mesaj");//cözülmüş  mesajı  yazdırdım 
        
        Thread.sleep(100);// 
        
        PrintWriter pw=new PrintWriter(s.getOutputStream(),true);// gönderdimmm
      //  System.out.println("iletmek istediğiniz mesajı lütfen giriniz");
      sifrelim sdm=new sifrelim(new BigInteger("111547"),new BigInteger("34117"), new BigInteger("13"));//mesajı  şifrelemek için nesne oluşturdum 
        String mesaj=k.nextLine(); //mesajı  klavyeden okudum 
        String gnd=sdm.sifrele(mesaj);
        System.out.println(gnd+" bu mesaj  karsıya göndermek için şifrelendi");
        pw.println(gnd);
//      sifrelim sd=new sifrelim(new BigInteger("111547"),new BigInteger("34117"), new BigInteger("13"));//mesajı  şifrelemek için nesne oluşturdum 
//
//      
//      sd.sifrele(mesaj);// mesaj  gönderdim 
//      
        
    }}
      

