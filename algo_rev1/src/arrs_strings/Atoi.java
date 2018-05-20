package arrs_strings;

import java.util.Scanner;

public class Atoi {

	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		String str = input.next();
		int convert = 0;
		for(int i = 0; i < str.length(); i++){
			convert = convert*10 + str.charAt(i) - '0';
		}
		System.out.println(convert);
		
	}
	
}
