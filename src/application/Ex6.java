package application;

import java.io.File;
import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path:");
		String strpath = sc.nextLine();
		
		File path = new File(strpath);
		
		System.out.println("Get name: " + path.getName());
		System.out.println("Get parent: " + path.getParent());
		System.out.println("Get path: " + path.getPath());
		sc.close();

	}

}
