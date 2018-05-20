package arrs_strings;

import java.util.Arrays;

public class check_perm {

	public static void main(String arg[]){
		
		check_perm cp = new check_perm();
		System.out.println("Is the permutation of another "+cp.checkPermutation("abc", "acb"));
	}
	
	String sort(String str){
		
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	boolean checkPermutation(String str1, String str2){
		
		if(str1.length() != str2.length()){
			return false;
		}
		
		return sort(str1).equals(sort(str2));
	}
	
}
