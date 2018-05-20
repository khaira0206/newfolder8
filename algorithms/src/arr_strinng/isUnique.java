package arr_strinng;

public class isUnique {

	
	public boolean  isUniqueChar(String str){
		if(str.length() > 128)
			return false;
		
		boolean[] char_set = new boolean[128];
	for(int i = 0; i < str.length(); i++){
		int val = str.charAt(i);
		
		if(char_set[val]){
			return false;
		}
		char_set[val] = true;
		
	}	
	return true;
	} 
	
	
	public static void main(String arg[]){
		isUnique un =  new isUnique();
		System.out.println(un.isUniqueChar("wha euck"));
		
	}
	
}
