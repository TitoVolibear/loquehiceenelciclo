package ejemplos;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Obtener cuantos modulos tiene cada ciclo
public class Ejem_CuantosModulosCiclo {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Ciclos.xml");
			doc.normalize();
			NodeList nlCiclos = doc.getElementsByTagName("ciclo");
			for (int i = 0; i < nlCiclos.getLength(); i++) {
				Node nCiclo = nlCiclos.item(i);
				System.out.println("Ciclo: " + nCiclo.getFirstChild().getTextContent());
				NodeList nlModulos = ((Element) nCiclo).getElementsByTagName("modulo");
				System.out.println("        Nº de modulos: " + nlModulos.getLength());
				Integer totHoras = 0;
				for (int j = 0; j < nlModulos.getLength(); j++) {
					Node nModulo = nlModulos.item(j);
					String horas = ((Element)nModulo).getAttribute("horas");
					totHoras = totHoras + Integer.parseInt(horas);
				}
				System.out.println("        Nº de horas: " + totHoras);
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
