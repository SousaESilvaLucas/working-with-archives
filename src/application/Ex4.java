package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex4 {

	public static void main(String[] args) {
		String [] lines = new String [] {"Good Morning", "Good afternoon", "Good night"};
		String path = "//home//lucas//eclipse-workspace//working-with-archives//out";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch (IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
