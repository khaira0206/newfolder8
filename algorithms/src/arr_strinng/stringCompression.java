package arr_strinng;

public class stringCompression {
  StringBuilder compressedString = new StringBuilder();
	int consecCount = 0;
	 
	public String compress( String str){
		
		
		
		for(int i=0; i < str.length(); i++){
			consecCount++;
			if(i+1 >= str.length() || str.charAt(i)!= str.charAt(i+1)){
				compressedString.append(str.charAt(i));
				compressedString.append(consecCount);
				consecCount =0;
			}
			
		}
		
		return compressedString.toString();
		
		
	}
	
	public static void main(String args[]){
		stringCompression sc =  new stringCompression();
		long val = System.currentTimeMillis();
		System.out.println(sc.compress("aanncc"));
				long val1 = System.currentTimeMillis();
		long diff = val1 - val;
		 System.out.println(diff);
	}
	
	
	
	
}
