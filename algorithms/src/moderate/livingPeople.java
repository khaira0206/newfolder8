package moderate;

public class livingPeople {

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
	
	int maxAlive(Person[] people, int min, int max){
		
		int maxAlive = 0;
		int maxAliveYear = min;
		
		for(int year = min; year <= max; year++){
			int alive = 0;
			for(Person person : people){
				if(person.birth <= year && year <= person.death){
					alive++;
				}
			}
			if(alive > maxAlive){
				maxAlive = alive;
				maxAliveYear = year;
			}
		}
		
		return maxAliveYear;
	}
	
}
