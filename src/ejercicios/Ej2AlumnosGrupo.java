package ejercicios;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej2AlumnosGrupo {
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
			System.out.println("Introduce nombre de grupo: ");
			String gr = tec.nextLine();
			NodeList nlGrupos = doc.getElementsByTagName("grupo");
			boolean enc = false;
			for (int i = 0; i < nlGrupos.getLength(); i++) {
				Element eGrupo = (Element) nlGrupos.item(i);
				NodeList nlNombre = eGrupo.getElementsByTagName("nombre");
				if (nlNombre.item(0).getTextContent().equals(gr)) {
					enc = true;
					NodeList nlAlumnos = eGrupo.getElementsByTagName("alumno");
					for (int j = 0; j < nlAlumnos.getLength(); j++) {
						Element eAlumno = (Element) nlAlumnos.item(j);
						System.out.println(eAlumno.getElementsByTagName("expediente").item(0).getTextContent());
						System.out.println(eAlumno.getElementsByTagName("nombrealu").item(0).getTextContent());
						System.out.println(eAlumno.getElementsByTagName("fechaingreso").item(0).getTextContent());
						System.out.println("---------");
					}
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
