package moderate;

class Result1{
	
	public int hits = 0;
	public int pseudoHits = 0;
	
	public String toString(){
		
		return "(" + hits + ","+ pseudoHits + ")";
	}
	
}

public class masterMind {

	public static void main(String arg[]){
		masterMind mm = new masterMind();
		System.out.println(mm.estimate("GGRR", "RGBY"));
	}
	
	int code(char ch){
		
    switch(ch){
    case 'B':
    	return 0;
    case 'G':
    	return 1;
    case 'R':
    	return 2;
    case 'Y':
    	return 3;
    default:
    	return -1;
    }
		
	}
	int MAX_COLORS = 4;
	
	Result1 estimate(String guess, String solution){
		if(guess.length() != solution.length())
			return null;
		
		Result1 res = new Result1();
		int[] frequecies = new int[MAX_COLORS];
		for(int i = 0; i < guess.length(); i++){
			
			if(guess.charAt(i) == solution.charAt(i)){
				res.hits++;
			}
			else{
			 int code = code(solution.charAt(i));
			 frequecies[code]++;
			}
		}
		
		for(int i = 0; i < guess.length(); i++){
			
			int code = code(guess.charAt(i));
			if(code >= 0 && frequecies[code] > 0 && 
					guess.charAt(i) != solution.charAt(i)){
				res.pseudoHits++;
				frequecies[code] --;
				
			}
		}
		return res;
	}
	
}
