package ejercicios;

import java.io.IOException;
import java.io.InputStreamReader;

public class Ej5_LeerCaracter {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			int num = isr.read();
			System.out.println(isr.read());
			System.out.println(num);
			System.out.println((char) num);
		} catch (IOException e) {
			System.out.println("error E/S");
		}
	}
}
