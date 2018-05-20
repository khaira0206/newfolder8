package moderate;

public class livingPeople1 {

public class Person{
		
		public int birth;
		public int death;
		
		public Person(int birthyear, int deathyear){
			birth = birthyear;
			death = deathyear;
			
		}
		
	}
	
	public static void main(String arg[]){
		
	}
	int maxAliveYear(Person[] people, int min, int max){
		
		int[] year = createMap(people, min, max);
		int best = max(year);
		return best + min;
	}
	
	private int[] createMap(Person[] people, int min, int max) {
		
		int year[] = new int[max - min + 1];
		for(Person person : people){
			
			increamentRange(year, person.birth - min, person.death - min);
		}
		
		return year;
	}
    private void increamentRange(int[] values, int left, int right) {
		
    	for(int i = left; i <= right; i++ ){
    		values[i]++;
    		
    	}
		
	}
	private int max(int[] values) {
		
		int max = 0;
		
		for(int i = 0; i < values.length; i++){
			if(values[i] > values[max]){
				values[max] = values[i];
				max = i;
			}
		}
		
		return max;
	}
	
}
