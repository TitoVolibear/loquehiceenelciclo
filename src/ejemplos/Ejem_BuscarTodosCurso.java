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

public class Ejem_BuscarTodosCurso {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		try {
			// Cargar el .xml en el Doc
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Ciclos.xml");
			doc.normalize();
			NodeList nlCiclos = doc.getElementsByTagName("titulo");
			for (int i = 0; i < nlCiclos.getLength(); i++) {
				Node nTitulo = nlCiclos.item(i);
				System.out.println("Titulo Ciclo: " + nTitulo.getTextContent());
				Node nCiclo = nTitulo.getParentNode();
				NodeList nlCurso = ((Element) nCiclo).getElementsByTagName("curso");
				for (int j = 0; j < nlCurso.getLength(); j++) {
					Node nCurso = nlCurso.item(j);
					System.out.println("    Curso: " + ((Element) nCurso).getAttribute("numero"));
					NodeList nlModulo = nCurso.getChildNodes();
					for (int k = 0; k < nlModulo.getLength(); k++) {
						Node nModulo = nlModulo.item(k);
						if(nModulo.getNodeType() ==1) {
							System.out.println("        Modulo: " + nModulo.getTextContent());
							System.out.println("            Horas: " + ((Element) nModulo).getAttribute("horas"));
						}
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
