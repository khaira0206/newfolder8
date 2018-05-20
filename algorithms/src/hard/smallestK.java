package hard;

import java.util.Random;

public class smallestK {

	public static void main(String arg[]){
		int arr[] = {1,4,9,2,3,7,6,8};
		smallestK sK = new smallestK();
		int res[];
		res = sK.smallestK(arr, 5);
		
		for(int i = 0; i < res.length; i++){
			
			System.out.println(res[i]);
		}
	}
	
	int[] smallestK(int[] arr, int k){
		if(k <= 0 || k > arr.length){
			throw new IllegalArgumentException();
			
		}
		int threshold = rank(arr, k -1);
		int[] smallest = new int[k];
		int count = 0;
		for(int a : arr){
			if(a <= threshold){
				smallest[count] = a;
				count++;
			}
		}
		
		return smallest;
	}
	
	int rank(int[] arr, int rank){
		return rank(arr, 0, arr.length - 1, rank );
		
	}
	
	int rank(int[] arr, int left, int right, int rank){
		
		int pivot = arr[randomInRange(left, right)];
		int leftEnd = partition(arr, left, right, pivot);
		
		int leftSize = leftEnd - left + 1;
		if(rank == leftSize - 1){
			return max(arr, left, leftEnd);
			
		}
		else if(rank < leftSize){
			return rank(arr, left, leftEnd, rank);
		}
		else{
			return rank(arr, leftEnd + 1, right, rank - leftSize);
		}
		
	}
  
	int partition(int[] arr, int left, int right, int pivot){
		
		while(left <= right){
			if(arr[left] > pivot){
				swap(arr, left, right);
				right --;
			}
			else if(arr[right] <= pivot){
				swap(arr, left, right);
				left ++;
			}
			else{
				left ++;
				right --;
			}
		}
		return left - 1;
		
	}
	
	void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	int randomInRange(int min, int max){
		Random rand = new Random();
		int num = rand.nextInt(max + 1 - min) + min;
		return num;
	}
	int max(int[] arr, int left, int right){
		int max = Integer.MIN_VALUE;
		for(int i = left; i <= right; i++){
			max = Math.max(arr[i], max);
			
		}
		return max;
		
	}
	
}
