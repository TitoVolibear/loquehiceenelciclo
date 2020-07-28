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

// Listar las familias de ciclos formativos y sus ciclos
public class Ejem_ListarFamilias {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Ciclos.xml");
			doc.normalize();
			NodeList nlNombre = doc.getElementsByTagName("nombre");
			for (int i = 0; i < nlNombre.getLength(); i++) {
				Node nNombre = nlNombre.item(i);
				System.out.println("Familia: " + nNombre.getTextContent());
				NodeList nlTitulo = ((Element) nNombre.getNextSibling()).getElementsByTagName("titulo");
				for (int j = 0; j < nlTitulo.getLength(); j++) {
					Node nTitulo = nlTitulo.item(j);
					System.out.println("--Ciclo: " + nTitulo.getTextContent());
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
