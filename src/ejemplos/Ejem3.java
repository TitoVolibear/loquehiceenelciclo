package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejem3 {
	public static void main(String[] args) {
		// Leer un fichero de texto y copiarlo en uno nuevo
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		String linea = null;
		try {
			fr = new FileReader("ejemplo2.txt");
			fw = new FileWriter("ejemplo3.txt");
			bw = new BufferedWriter(fw);
			br = new BufferedReader(fr);
			while ((linea = br.readLine()) != null) {
				bw.write(linea.toUpperCase());
				bw.newLine();
			}
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
