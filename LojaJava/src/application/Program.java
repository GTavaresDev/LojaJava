package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) throws FileNotFoundException {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String local = leitor.nextLine();
		
		FileInputStream entradaArquivo = new FileInputStream(new File(local));		
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		List<Product> products = new ArrayList<>();
		
	
		
		//Preciso agora dar um jeito de escrever esses dados em um novo arquivo
		
		String path = "C:\\Text\\out2.txt";	
		
		try ( BufferedWriter writer = new BufferedWriter(new FileWriter(path));	){
			while(lerArquivo.hasNext()) {
				String linha = lerArquivo.nextLine();
				
				if(linha != null && !linha.isEmpty()) {
					String [] dados = linha.split("\\,");
					Product product = new Product();
					product.setName(dados[0]);
					product.setPrice(Double.parseDouble(dados[1]));
					product.setQuantity(Integer.parseInt(dados[2]));
					
					
					System.out.println("Product :" + product);
					products.add(product);
					writer.write("Product :" + product.getName() + ", Price: " + product.totalPrice());
		            writer.newLine(); // Escreve nova linha no arquivo de destino
					
					
					
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		leitor.close();
		lerArquivo.close();
	}
}
