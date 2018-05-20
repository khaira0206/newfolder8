package arr_strinng;

public class Check_Perm1 {

	public static void main(String arg[]){
	
		Check_Perm1 cp = new Check_Perm1();
		
		System.out.println(cp.isPerm("abc", "bac"));
		
	}
	
	public boolean isPerm(String str1, String str2){
		
		if(str1.length() != str2.length()){
			return false;
		}
		
		int[] set = new int[128];
		
		for(int i = 0; i < str1.length(); i++){
			
			set[str1.charAt(i)]++;
			
		}
		
		
		
		for(int i = 0; i < str2.length(); i++){
			set[str2.charAt(i)]--;
			if(set[str2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}
	
	
}
