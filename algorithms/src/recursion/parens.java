package recursion;

import java.util.HashSet;
import java.util.Set;

public class parens {

	public static void main(String arg[]){
		parens pr = new parens();
		
		System.out.println(pr.generatesParens(10));
		
	}
	
	Set<String> generatesParens( int remaining){
		
		Set<String> set = new HashSet<String>();
		
		if(remaining == 0){
		   set.add("");	
		}
		else{
			
			Set<String> prev = generatesParens(remaining -1);
			for(String str : prev){
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '('){
						String s = insertInside(str, i);
						set.add(s);
					}
				}
				set.add("()" + str);
			}
			
		}
		return set;
		
	}
	String insertInside( String str, int index){
		
		String left = str.substring(0 , index + 1);
		
		String right = str.substring(index + 1 , str.length());
		return left + "()" + right;
	}
	
	
}
