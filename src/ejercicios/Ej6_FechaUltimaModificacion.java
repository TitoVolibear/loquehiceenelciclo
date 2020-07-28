package ejercicios;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Ej6_FechaUltimaModificacion {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.println("Introduce la ruta: ");
		String carpeta = tec.nextLine();
		File f = new File(carpeta);
		if (f.exists()) {
			if (f.isDirectory()) {
				File lista_ficheros[] = f.listFiles();
				for (File fich : lista_ficheros) {
					if (fich.isFile()) {
						Date d = new Date(fich.lastModified());
						System.out.println(fich.getName() + " : " + d);
					}
				}
			} else {
				System.out.println(f.getAbsolutePath() + " no es una carpeta.");
			}
		} else {
			System.out.println("La carpeta " + f.getName() + " no existe.");
		}
	}
}
