package xmlReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class CsReader {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("WebContent/xml/csParser.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("Csvariables");
			
	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
	//	System.out.println(nNode.getTextContent() );		
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

		//	System.out.println("Staff id : " + eElement.getAttribute("id"));
			System.out.println("Weight due to control structure type : " + eElement.getElementsByTagName("Wtcs").item(0).getTextContent());
			System.out.println("Number of conditions in the control structure : " + eElement.getElementsByTagName("NC").item(0).getTextContent());
			System.out.println("Control structure complexity of the previous program statement : " + eElement.getElementsByTagName("hCcspps").item(0).getTextContent());
		//	System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
  		
}
