package arrs_strings;

public class perm_palindrome {

	public static void main(String arg[]){
		
	perm_palindrome pp = new perm_palindrome();
	 String str = "Tact Coa";
	 System.out.println("Is string perm palindrom  " + pp.isPalindrome(str));
		
	}
	
	boolean isPalindrome(String str){
		
		int[] table = buildCharTable(str);
		
	return checkMaxOneOdd(table);
		
	}
	
	private boolean checkMaxOneOdd(int[] table){
		boolean oddFound = false;
       for(int a : table){
    	
    	   if(a % 2 == 1){
    		  if(oddFound){
    			  return false;
    		  } 
    		  oddFound = true;
    	   }
         }
	return true;	
	}
	private int getCharNumber(Character c){
		
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(val < z && val > a){
			return val - a;
		}
		return -1;
	}

	private int[] buildCharTable(String str) {
		
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : str.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
			}
			
		}
		
		return table;
	}
	
}
