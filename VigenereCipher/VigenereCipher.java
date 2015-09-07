package com.ruth.encryption;
import java.util.Scanner;

public class VigenereCipher {
	
	public static void encode (String s, String k){

	    int base = 97;
		char[] k1 =  new char[s.length()] ; //create keyword array
		
		for (int i= 0; i<s.length(); i++) {	//iterate over the keyword array			
			k1[i]= k.charAt(i%k.length()); //map the keyword to the array 
			}
			
			char[]s1 =  s.toCharArray(); //convert string to array
			
		 	for (int j = 0; j < s.length(); j++) {
		 		
		 		int init_value = (int)s1[j] - base; //convert each character from ASCII
	            int key = (int)k1[j] - base; //convert each character from ASCII
		 		int coded_value = (init_value + key)%26 + base; //convert each string character with key
		 		
	        	s1[j] = (char)coded_value;
		 	}
		 	
			String encoded = new String(s1);	
			System.out.println(encoded);	
	}
	public static void decode (String s, String k) {
		
	    int base = 97;
		char[] k1 =  new char[s.length()] ; 
	
		for (int i= 0; i<s.length(); i++) {			
			k1[i]= k.charAt(i%k.length()); //create array with keyword mapped
		}
		
	        char[] s1 =  s.toCharArray();
			for (int j = 0; j < s.length(); j++) {
				if ((int)s1[j] - (int)k1[j] >=0) { //difference in character and keyword is positive
					
					int init_value = (int)s1[j]; 
		            int key = (int)k1[j];
			 		int coded_value = (init_value - key)%26 + base; 
			 		
		        	s1[j] = (char)coded_value;
				}
				else { //negative case
					int init_value = (int)s1[j];
		            int key = (int)k1[j];
					int negval = (26 + init_value -key) % 26 + base; //add 26 to invert the value and give the right mod value 
					s1[j] = (char)negval;
				}
			}
			
			String decoded = new String(s1);	
			System.out.println(decoded);
	}
	

	public static void main(String[] args) {
		
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
        System.out.println("Would you like to encode or decode a message?");
        
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        String key;
        String str;
        
        if (response.equals("encode")){
        	System.out.println("Give the string ");
        	str=in.nextLine();
        	System.out.println("Give the key ");
        	key = in.nextLine();
        	if (str.length() < 1 || key.length() < 1)  //if both key and string are null
        		System.out.println("That is not a valid option.");
        	else
        	encode(str, key);
        }
        else if (response.equals("decode")){
        	System.out.println("Give the string ");
        	str=in.nextLine();
        	System.out.println("Give the key ");
        	key = in.nextLine();
        	if (str.length() < 1 || key.length() < 1)  //if both key and string are null
        		System.out.println("That is not a valid option.");
        	else
        	decode(str, key);
        }
        else {
        	System.out.println("Valid options are encode and deocode ");
        }
	}
}