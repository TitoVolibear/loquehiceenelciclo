package ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class Ej1_LeeNombre {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String nombre = "";
		int num;
		try {
			do {
				// Lee un byte
				num = System.in.read();
				if (num != 10) { // Si no leo salto de linea
					nombre = nombre + (char) num;
				}
			} while (num != 10); // El codigo 10 es el salto de linea, sera el fin de leer
			System.out.println(nombre);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
