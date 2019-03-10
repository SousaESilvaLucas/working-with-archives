package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex2and3 {

	public static void main(String[] args) {
		String path = "//home//lucas//eclipse-workspace//working-with-archives//in";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e ) {
			System.out.println(e.getMessage());
		}
		
	}

}
