package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej8_CrearFicheroTexto {
	public static void main(String[] args) {
		FileWriter fw = null;
		// Crear el fichero nombre.txt
		try {
			fw = new FileWriter("nombre.txt");
			// Escribir caracter a caracter
			fw.write('h');
			fw.write('o');
			fw.write('l');
			fw.write('a');
			fw.write('\n');
			// Escribir una linea
			fw.write("€uro");
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
		// Leer el fichero nombre.txt
		FileReader fr = null;
		try {
			fr = new FileReader("nombre.txt");
			int caracter;
			do {
				caracter = fr.read();
				if (caracter != -1) {
					System.out.println((char) caracter);
				}
			} while (caracter != -1); // -1 es el codigo de fin de fichero
		} catch (FileNotFoundException e) {
			System.out.println("No se puede crear o abrir fichero");
		} catch (IOException e) {
			System.out.println("Error de lectura");
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}
		}
		// Leer el fichero linea a linea
		try {
			fr = new FileReader("nombre.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int cont = 0;
			while ((linea = br.readLine()) != null) { // Mientras la linea no sea null
				System.out.println(cont + " - " + linea);
				cont++;
			}
			System.out.println("Total lineas: " + cont);
		} catch (FileNotFoundException e) {
			System.out.println("No se puede crear o abrir fichero");
		} catch (IOException e) {
			System.out.println("Error de lectura");
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}
		}
		// Escribir fichero linea a linea
		try {
			FileWriter fw2 = new FileWriter("nuevo.txt");
			BufferedWriter bw = new BufferedWriter(fw2);
			bw.write("hola");
			bw.newLine();
			bw.write("adios");
			bw.newLine();
			bw.close();
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
