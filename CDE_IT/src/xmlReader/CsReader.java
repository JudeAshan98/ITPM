package xmlReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.List;

public class CsReader {

	public static void main(String argv[]) {

	  int Li_type;
	  int Li_NcP;
	  int Li_Prev;
	  
	  
	List<Integer> GetAllcsValues(){
		  
    try {

	File fXmlFile = new File("WebContent/xml/csParser.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("Inhvariables");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			Li_type = Integer.parseInt((eElement.getElementsByTagName("Wtcs").item(0).getTextContent()));
			System.out.println(Li_type);
			
			Li_NcP = Integer.parseInt(eElement.getElementsByTagName("NC").item(0).getTextContent());
			System.out.println(Li_NcP);
			
			Li_Prev =Integer.parseInt(eElement.getElementsByTagName("hCcspps").item(0).getTextContent());
			System.out.println(Li_Prev);

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    
	  }
  }

}
