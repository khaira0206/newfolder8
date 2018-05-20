package arr_strinng;

public class urlify {

	public char[]  urlifyString( char[] arr, int length){
		int spacecount = 0;
		
		for(int i = 0; i < length; i++){
			if(arr[i] == ' '){
				spacecount++;
				
			}
			}
			
			int index = length + 2*spacecount - 1;
			arr[length] = '\0';
			for(int j = length - 1; j >=0; j--){
				if(arr[j] == ' '){
				arr[index] = '0';
				arr[index - 1] = '2';
				arr[index - 2] = '%';
				index = index - 3;
			}else{
				arr[index ] = arr[j];
				index = index - 1;
			}
		}
			return arr;
		
	}
	public static void main(String arg[]){
		
		String str = "what is this      ";
		char[] arr = str.toCharArray();
		urlify ur = new urlify();
         System.out.println(ur.urlifyString(arr, 12)); 
	}
	
	
}


	

