package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej7 {
	public static void main(String[] args) {
		try {
			System.out.println("Introduce tu nombre: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String nombre = br.readLine();
			System.out.println(nombre);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
