package moderate;

import java.util.ArrayList;

public class pondSize{
	
	public static void main(String arg[]){
		
		pondSize ps =  new pondSize();
		
		int[][] pond = {{0, 2, 1, 0},{0, 1, 0, 1},{1, 1, 0, 1},{0, 1, 0, 1}};
		
		for(int size: ps.computePondSize(pond))
		{
			System.out.println("Pond size :" + size);
		}	
	}
	
	ArrayList<Integer> computePondSize(int[][] pond){
		
		ArrayList<Integer> size = new ArrayList<Integer>();
		
		for(int r = 0; r < pond.length; r++){
			for(int c = 0; c < pond[r].length; c++){
				if(pond[r][c] == 0){
					int psize = pondSize(pond, r, c);
					size.add(psize);
				}
				
			}
			
		}
		
		return size;
	}
	
	int pondSize(int[][] pond , int r, int c){
		
		if(r < 0 || c < 0 || r >= pond.length || c >= pond[r].length || pond[r][c] != 0){
			return 0;
		}
		int size = 1;
		pond[r][c] = -1;
		for(int dr = -1; dr <= 1; dr++){
			for(int dc = -1; dc <= 1; dc++){
				size += pondSize(pond, r + dr, c + dc);
			}
		}
		return size;
	}
}
