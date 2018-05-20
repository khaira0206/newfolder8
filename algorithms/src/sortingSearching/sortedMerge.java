package sortingSearching;

public class sortedMerge {

	public static void main(String arg[]){
		
		
		
	}
	
	void merge(int[] arrA, int[] arrB){
		
		int indexA = arrA.length -1;
		int indexB = arrB.length -1;
		int mergedIndex = indexA + indexB -1;
		
		while(indexB >= 0){
			
			if(indexA >= 0 && arrA[indexA] > arrB[indexB]){
				arrA[mergedIndex] = arrA[indexA];
				indexA --;
				
			}
			else{
				arrA[mergedIndex] = arrB[indexB];
				indexB --;
			}
			mergedIndex --;
		}
		
	}
	
	
}
