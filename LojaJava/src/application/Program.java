package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String local = leitor.nextLine();
		
		String line;
		String[] lines = new String[10000];
	
		
		try (BufferedReader br = new BufferedReader(new FileReader(local))) {
			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();	
				for (int i=0; i<100; i++) {
		            lines[i] = line;
		            System.out.println(lines);
		        }
				
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		
		String path = "C:\\temp\\out.txt";	
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (String linewrite : lines) {
				bw.write(linewrite);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println();
		
		leitor.close();
	}
}
