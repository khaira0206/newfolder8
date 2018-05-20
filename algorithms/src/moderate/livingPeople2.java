package moderate;

import java.util.Arrays;
 class Person{
	
	public int birth;
	public int death;
	
	public Person(int birthyear, int deathyear){
		birth = birthyear;
		death = deathyear;
		
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}
	
}

public class livingPeople2 {


	
	public static void main(String arg[]){
		
		Person[] per = new Person[10];
		
		for(int i = 0; i < 10 ; i++){
			//Person per[i];
		}
		
		Person per1 = new Person(12,15);
		Person per2 = new Person(20,90);
		Person per3 = new Person(10,98);
		Person per4 = new Person(01,72);
		Person per5 = new Person(10,98);
		Person per6 = new Person(23,82);
		Person per7 = new Person(13,98);
		Person per8 = new Person(90,98);
		Person per9 = new Person(83,99);
		Person per10 = new Person(75,94);
		
		
		livingPeople2 lp = new livingPeople2();
		System.out.println("Max Alive year is : 19" +lp.maxAlive(per, 01, 99));
		
	}
	
	int maxAlive(Person[] people, int min, int max){
		
		int[] birth = getSortedYear(people, true);
		int[] death = getSortedYear(people, false);
		
		int birthIndex = 0;
		int deathIndex = 0;
		int currentlyAlive = 0;
		int maxAlive = 0;
		int maxAiveYear = min;
		while(birthIndex < birth.length){
			
			if(birth[birthIndex] <= death[deathIndex]){
				currentlyAlive ++;
				if(currentlyAlive > maxAlive){
					maxAlive = currentlyAlive;
					maxAiveYear = birth[birthIndex];
				}
				birthIndex ++;
			}else if(birth[birthIndex] > death[deathIndex]){
				currentlyAlive --;
				deathIndex ++;
				
			}
			
		}
		
		return maxAiveYear;
	}

	private int[] getSortedYear(Person[] people, boolean copyBirthYear) {
		
		int[] year = new int[people.length];
		
		for(int i = 0; i <= people.length; i++){
			year[i] = copyBirthYear ? people[i].birth : people[i].death;
		}
		Arrays.sort(year);
		return year;
	}
	
}
