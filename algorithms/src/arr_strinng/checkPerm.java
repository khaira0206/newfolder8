package arr_strinng;

public class checkPerm {

	public String sortString(String str){
		char[] content = str.toCharArray();
		
		 java.util.Arrays.sort(content);
		  return new String(content);
		
	}
	
	public boolean isPerm(String str1, String str2){
		if(str1.length()!= str2.length())
		return false;
		
		
		return sortString(str1).equals(sortString(str2));
	}
	
	public static void main(String arg[]){
		checkPerm perm = new checkPerm();
		System.out.println(perm.isPerm("dog", "god"));
		
	}
	
	
}
