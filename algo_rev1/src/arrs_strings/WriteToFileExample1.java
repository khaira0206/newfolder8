package arrs_strings;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WriteToFileExample1 implements Serializable {


	int[] arr;
	public void input(int[] arr){
		this.arr = arr;	
	
	}
	
	public static void main(String[] args) {
   int[] arr = {1,2,3,4,5};
   WriteToFileExample1 wr = new WriteToFileExample1();
	wr.input(arr);
		try {
			FileOutputStream fileOut =
			         new FileOutputStream("outfile.ser");
			
			
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(wr);
			out.close();
			fileOut.close();
			System.out.print("Serealized data writen to file");
			WriteToFileExample1 wr1 = new WriteToFileExample1();
			
			  FileInputStream fileIn = new FileInputStream("outfile.ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         wr1 =(WriteToFileExample1) in.readObject();
		         in.close();
		         fileIn.close();
		         
		         int[] arr2 = wr1.arr;
		         for(int i = 0; i < arr2.length; i++){
		        	 if(arr[i] != arr2[i]){
		        	 System.out.print("values are not same");
		        	 break;
		        	 }
		         }
		         System.out.println("values are  same");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

			System.out.println("Done");


		}

	}

