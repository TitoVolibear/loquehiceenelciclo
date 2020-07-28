package ejercicios;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej1Alumnos {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("grupos.xml");
			doc.normalize();
			NodeList nlAlumnos = doc.getElementsByTagName("alumno");
			for (int i = 0; i < nlAlumnos.getLength(); i++) {
				Element eAlumno = (Element) nlAlumnos.item(i);
				System.out.println(eAlumno.getElementsByTagName("expediente").item(0).getTextContent());
				System.out.println(eAlumno.getElementsByTagName("nombrealu").item(0).getTextContent());
				System.out.println(eAlumno.getElementsByTagName("fechaingreso").item(0).getTextContent());
				System.out.println("---------");
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
