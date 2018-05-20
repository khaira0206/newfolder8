package arr_strinng;

public class oneAway {

	public boolean oneEditAway(String str1, String str2){
		
		if(str1.length() == str2.length()){
			return oneEditReplace(str1, str2);
		}
		
		if(str1.length()+1 == str2.length()){
			return oneEditInsert(str1, str2);
		}
		if(str1.length() == str2.length()+1){
			return oneEditInsert(str2, str1);
		}
		return false;
	}
	public boolean oneEditReplace(String str1, String str2){
		boolean diff = false;
		for(int i = 0; i < str2.length(); i++)
		{
			if(str1.charAt(i)!= str2.charAt(i))
		{
				if(diff){
					return false;
		           }
			
		}
	}
		return true;
	}
	
	public boolean oneEditInsert(String str1, String str2){
		boolean diff = false;
	    int index1 = 0;
	    int index2 = 0;
		for(int i = 0; i < str1.length(); i++)
		{
			if(str1.charAt(index1)!= str2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				else{
				index2++;
				}
			}
			index1++;
			index2++;
		}
		return true;
		
	}
	
	public static void main(String args[]){
		
		oneAway oa =new oneAway();
		System.out.println(oa.oneEditAway("pale  ", "paele   "));
		
	}
	
}
