package arrs_strings;

public class one_Edit_Away {

	public static void main(String arg[]){
		one_Edit_Away oea = new one_Edit_Away();
		System.out.println("String is one edit or replace away  "+oea.oneAway("palee", "palea"));
		
	}
	boolean oneAway(String str1, String str2){
		
		if(str1.length() == str2.length()){
			return oneReplaceAway(str1, str2);
		}else if(str1.length() + 1 == str2.length()){
			return oneEditAway(str1, str2);
		}else if(str1.length() == str2.length() + 1){
			return oneEditAway(str2 , str1);
		}
		
		return false;
		
	}
	boolean oneReplaceAway(String str1, String str2){
		boolean diff = false;
		for(int i = 0; i < str1.length(); i++){
			if(str1.charAt(i) != str2.charAt(i)){
				if(diff){
					return false;
				}
				diff = true;
			}
		}
		return true;
	}
	boolean oneEditAway(String str1, String str2){
		boolean diff = false;
		int index1 = 0;
		int index2 = 0;
		for(index1 = 0; index1 < str2.length() && index2 < str1.length();){
			if(str1.charAt(index1) != str2.charAt(index2)){
				if(diff){
					return false;
				}
				diff = true;
				index1++;
			}else{
			index1++;	
			index2++;
			}
		}
		return true;
	}
	
}
