package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ArchiveException;
import entities.Product;

public class Exercise {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input file path: ");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		File outputDirectory = new File(path.getParent() + "//out");
		String summaryFilePath = outputDirectory.getPath() + "//summary.csv";
		List <Product> products = new ArrayList<>();
		
		if (outputDirectory.exists()) {
			if (outputDirectory.isDirectory()) {
				System.out.println("\"" + outputDirectory.getName() + "\"" + " directory already exists");
			}
			if (outputDirectory.isFile()) {
				System.out.println("There is already a file named " + "\"" + outputDirectory.getName() + "\"."
						+ " Would you like to delete it and create a "+ "\"" 
						+ outputDirectory.getName() + "\" directory ? (y/n)");
				char c = sc.next().charAt(0);
				if (c == 'y') {
					outputDirectory.delete();
					boolean success = outputDirectory.mkdir();
					System.out.println("Directory successfully created: " + success);
				}
				else {
					sc.close();
					try {
						throw new ArchiveException("Operation aborted by the user");
					} catch (ArchiveException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
		else {
			boolean success = outputDirectory.mkdir();
			System.out.println("Directory successfully created: " + success);
		}

		
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))){
		
			String[] productInformation = new String[3];
			String line = br.readLine();	
			
			while(line != null) {
				productInformation = line.split(",");	
				String name = productInformation[0];
				double price = Double.parseDouble(productInformation[1]);
				int quantity = Integer.parseInt(productInformation[2]);
				products.add(new Product(name, price, quantity));
				line = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(summaryFilePath))){
				System.out.println("Writing summary!");
				for (Product p : products) {
					bw.write(p.getName() + ", " + String.format("%.2f", p.getTotalPrice()));
					bw.newLine();
				}
				System.out.println("All done!");

			}
		}
		catch (IOException e ) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		sc.close();

	}

}
