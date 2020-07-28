package ejercicios;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej3AlumnosIngreso {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Scanner tec = new Scanner(System.in);
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("grupos.xml");
			doc.normalize();
			int anyoActual = Calendar.getInstance().get(Calendar.YEAR);
			NodeList nlAlumnos = doc.getElementsByTagName("alumno");
			for (int j = 0; j < nlAlumnos.getLength(); j++) {
				Element eAlumno = (Element) nlAlumnos.item(j);
				String sFecha = eAlumno.getElementsByTagName("fechaingreso").item(0).getTextContent();
				try {
					Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(sFecha);
					Calendar c = Calendar.getInstance();
					c.setTime(fecha);
					int anyo = c.get(Calendar.YEAR);
					if (anyo == anyoActual) {
						System.out.println(eAlumno.getElementsByTagName("expediente").item(0).getTextContent());
						System.out.println(eAlumno.getElementsByTagName("nombrealu").item(0).getTextContent());
						System.out.println(eAlumno.getElementsByTagName("fechaingreso").item(0).getTextContent());
						System.out.println("---------");
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		} catch (ParserConfigurationException e) {
			System.out.println("Problema al crear el DocumentBuilder");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("Error al parsear");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de E/S");
			e.printStackTrace();
		}
	}
}
