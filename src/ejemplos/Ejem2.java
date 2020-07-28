package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejem2 {
	public static void main(String[] args) {
		// Leer linea de caracteres de entrada estandar y escribir en fichero
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("ejemplo2.txt");
			bw = new BufferedWriter(fw);
			System.out.println("Introduce una linea de caracteres: ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String linea = br.readLine();
			// Escribir en el fichero
			bw.write(linea);
			bw.newLine();
			System.out.println("Introduce una linea de caracteres: ");
			while (!(linea = br.readLine()).equals("fin")) {
				bw.write(linea);
				bw.newLine();
				System.out.println("Introduce una linea de caracteres: ");
			}
			// Cerrar Buffers
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se puede crear o abrir fichero");
		} catch (IOException e) {
			System.out.println("Error ");
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}
		}
	}
}
