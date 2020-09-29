/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_sifreli;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author idilkoc
 */
public class sifreli {
    
    
    
    
    
    	BigInteger modValue;
	BigInteger key;
	BigInteger exp;

	public  sifreli(BigInteger sayi, BigInteger key, BigInteger exp) {
		this.modValue = sayi;
		this.key = key;
		this.exp = exp;
	}

	public String sifrele(String msg) {

		BigInteger number;
		BigInteger ModPow;
		String sentence="";
		String[] arr = split(msg, 2);
		int val;
		
		for(String s : arr) {
			val = (int)s.charAt(0);
			val <<= 8;
			val += (int)s.charAt(1);
			
			number = BigInteger.valueOf(val);
			ModPow = number.modPow(exp, modValue);//hem ust hemde mod alma işlemini  aldık hızlı  olsun diye 
		
			long val2 = ModPow.longValue();
			char[] chars = new char[3];
			chars[2] = (char)(val2 & 0xFF);
			chars[1] = (char)(val2 >> 8 & 0xFF);
			chars[0] = (char)(val2 >> 16 & 0xFF);
			sentence += new String(chars);
		}
		return sentence;
	}

	public static String[] split(String s, int length) {
		while(s.length()%length != 0)
			s+=" ";
		String[] metinler = new String[s.length() / length];
		int index =0;
		for (int i = 0; i < s.length(); i += length) {
			metinler[index] = s.substring(i, (i+length));
			index++;
		}
		return metinler;
	}
        public static void main(String[] args) {
      sifrelim sd=new sifrelim(new BigInteger("111547"),new BigInteger("34117"), new BigInteger("13"));
      
      Scanner k=new Scanner(System.in);
            System.out.println("lutfen kelimelerinizi giriniz"
                    + "");
      String s=k.nextLine();
 
    String  d=sd.sifrele(s);
            System.out.println(d);
            
            
    }
}


