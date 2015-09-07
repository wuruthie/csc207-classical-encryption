import java.util.Scanner;

public class CaesarCipher {
	
	public static void encode (String s) {
		
		int base = 97; //to account for ASCII representation		
		
		for (int i=0; i < 26; i++) { //to add key 1-26
			char[] s1 =  s.toCharArray(); //converting string to char array representation
			
			for (int j = 0; j < s.length(); j++) { //iterating through each member of the string array
				//converting each member of the string array to an int and encoding it
				int coded_value = ((int)s1[j] - base + i)%26 + base;
	        	s1[j] = (char) coded_value;
		}
			String encoded = new String(s1); //convert back to string	
			System.out.println("n=" + i +": " + encoded); 
		}
	}
	public static void decode(String s) {
		int base = 97;
		for (int i=0; i < 26; i++)
		{	
			char[] s1 = s.toCharArray();
			for (int j = 0; j < s.length(); j++)
			{
				if ((int)s1[j] - base - i>=0)
				{
				 int coded_value = (((int)s1[j] - base) - i) % 26;
				 s1[j] = (char)(coded_value + base);
				}
				else
				{
				int negval= ( 26 + ((int)s1[j] - base) - i) %26;
				s1[j] = (char)(negval+ base);
				}
			}
			String encoded = new String(s1);	
			System.out.println(i +" " + encoded);
			}
	}

	public static void main(String[] args) {
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.println("Would you like to encode or decode a message?");

		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		
		if (response.equals("encode")) {
			System.out.println("Give a string ");
			String str = in.nextLine();
			
			//to read null string
			if(str.length() < 1) 
			System.out.println("That is not a valid input");
			else 
			encode(str);
		}
		
		else if (response.equals("decode")) {
			System.out.println("Give a string ");
			String str = in.nextLine();
			
			//to read null string
			if(str.length() < 1)
			System.out.println("That is not a valid input");
			else 
			decode(str);
		}
		else	{
			System.out.println("Valid options are encode and deocode ");

		}
	}
}

