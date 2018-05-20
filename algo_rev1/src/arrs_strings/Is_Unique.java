package arrs_strings;

public class Is_Unique {

	public static void main(String arg[]){
		Is_Unique iu = new Is_Unique();
		System.out.println("Is string unique  "+iu.isUnique("abcdefghijklmnopqrstua"));
		
	}
	
	boolean isUnique(String str){
		
		if(str.length() > 128){
			return false;
		}
		char[] feq = new char[128];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			System.out.println(str.charAt(i) +"  " + val);
		    feq[str.charAt(i)]++;
		    if(feq[str.charAt(i)] % 2 == 0){
		    	return false;
		    }
		}
		
		return true;
	}
}
