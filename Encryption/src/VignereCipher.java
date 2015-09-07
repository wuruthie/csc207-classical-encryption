import java.util.Scanner;

public class VigenèreCipher {
	
	
	public static void encode(String s, String k) {
		
		int j = 0; // key counter
		
		for (int i = 0; i < s.length(); i++) {
			if (j%k.length() == 0) // wrapping up j value
				j = 0; 
			
			int init_value = Character.getNumericValue(s.charAt(i));
			int key_value = Character.getNumericValue(k.charAt(j));
			int coded_value = (init_value + key_value)%26;
			s.toCharArray()[i] = (char) coded_value;	
			
			j++; // updating key value
		}
		new String(s);
		System.out.println(s);
	}
	
	public static void decode(String s, String k) {
		
        int j = 0; // key counter
		
		for (int i = 0; i < s.length(); i++) {
			if (j%k.length() == 0) // wrapping up j value
				j = 0; 
			
			int init_value = Character.getNumericValue(s.charAt(i));
			int key_value = Character.getNumericValue(k.charAt(j));
			int coded_value;
			
			if (init_value < key_value) 
			coded_value = (Math.abs(init_value - key_value))%26;
			else 
				coded_value = (init_value - key_value)%26;
			
			s.toCharArray()[i] = (char) coded_value;	
			
			j++; // updating key value
		}
		new String(s);
		System.out.println(s);
	}
	
	
	public static void main(String[] args) {
		System.out.println("This program encrypts and decrypts messages using the Vigenère Cipher.");
		System.out.println("Would you like to encode or decode a message?");
		
		Scanner a = new Scanner(System.in);
		String mode = a.nextLine();

		if (mode.equals("encode")) {
			System.out.println("Enter the string to encode:");
			Scanner b = new Scanner(System.in);
			String str1 = b.nextLine();
			System.out.println("Enter the key:");
			Scanner c = new Scanner(System.in);
			String key1 = c.nextLine();
			encode(str1, key1);
		}
		else if (mode.equals("decode")) {
			System.out.println("Enter the string to decode:");
			Scanner d = new Scanner(System.in);
			String str2 = d.nextLine();
			System.out.println("Enter the key:");
			Scanner e = new Scanner(System.in);
			String key2 = e.nextLine();
			decode(str2, key2);
		}
		else
			System.out.println("Valid options are 'encode' or 'decode'.");		
	}
}