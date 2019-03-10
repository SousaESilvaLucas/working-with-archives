package application;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		File [] folders = path.listFiles(File::isDirectory);
		
		System.out.println("Folders:");
		
		for (File f : folders) {
			System.out.println(f);
		}
		
		File[] files = path.listFiles(File::isFile);
		
		System.out.println("Files:");
		
		for (File f : files) {
			System.out.println(f);
		}
		
		boolean success = new File(strPath + "//subdir").mkdir();
		
		System.out.println("Directory successfully created: " + success);
		
		sc.close();
	}

}
