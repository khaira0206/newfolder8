package arr_strinng;

public class perm_palin {

	 int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
	 int index ;
	 boolean odd = false;
	 public boolean countWords(char[] str){
		  
		 for(int i = 0; i < str.length; i++){
			 int val = Character.getNumericValue(str[i]);
			 if(val < Character.getNumericValue('z')  && val > Character.getNumericValue('a') )
			 {
				  index =  val - Character.getNumericValue('a');
			 }
			 else 
			 {
				 index = -1;
			 }
			 if(index != -1)
			 table[index]++;
	        }
		 
		for(int j = 0; j < table.length; j++){
			
			if(table[j] % 2 == 1){
				if(odd){
				return false;
				}
				odd = true;
			}
			
		}
		return true;
	 }
	
	public static void main(String arg[]){
		 String str = "taco act";
		char[] arr = str.toCharArray();
		perm_palin pr = new perm_palin();
		System.out.println(pr.countWords(arr));
		
	}
	
}
