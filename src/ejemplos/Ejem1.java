package ejemplos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejem1 {
	public static void main(String[] args) throws IOException {
		Scanner tec = new Scanner(System.in);
		System.out.println("Introduce el nombre del archivo: ");
		String nombreArchivo = tec.nextLine();
		
		File f = new File(nombreArchivo);
		System.out.println("Nombre: " + f.getName());
		System.out.println("Ruta: " + f.getPath());
		System.out.println("Ruta absoluta: " + f.getAbsolutePath());
		System.out.println("Ruta canonica: " + f.getCanonicalPath());
		System.out.println("Padre: " + f.getParent());
	}
}
