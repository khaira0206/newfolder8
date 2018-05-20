package arrs_strings;

public class Urlify {

	public static void main(String arg[]){
		Urlify ur = new Urlify();
		System.out.println(" String after urlify is "+ur.urlify("Mr John Smith  b  ", 18));
	}
	
	public String urlify(String str, int len){
		
		int sp_count = 0;
		for(int i = 0; i < len; i++){
			if(str.charAt(i) == ' '){
			sp_count ++;
			}
		}
	int length = len + sp_count * 2;
	char[] new_str = new char[length];
	for(int i = len - 1; i >= 0; i--){
		
		if(str.charAt(i) == ' '){
			new_str[length - 1] = '0';
			new_str[length - 2] = '2';
			new_str[length - 3] = '%';
			length -= 3;
		}else{
		new_str[length - 1] = str.charAt(i);
		length -= 1;
		}
	}
	return new String(new_str);
	}
}
