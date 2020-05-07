package xmlReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsReader {

	  int Li_if;
	  int Li_Fwd;
	  int Li_Case;
	  int Li_Switch;
	  List <Integer>XmlValues = new ArrayList<Integer>();
	  // This method can read values from the xml and return data to the valuegenerator class.
	public List<Integer> GetAllcsValues(){
		  
    try {

	File fXmlFile = new File("C:\\Users\\Dinu_98x\\git\\git-ITPM-public\\ITPM\\CDE_IT\\WebContent\\xml\\csParser.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	
	
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("Csvariables");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		
	//	System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			Li_if = Integer.parseInt((eElement.getElementsByTagName("IfCon").item(0).getTextContent()));
			XmlValues.add(Li_if);
			Li_Fwd = Integer.parseInt(eElement.getElementsByTagName("Fwd").item(0).getTextContent());
			XmlValues.add(Li_Fwd);
			Li_Switch =Integer.parseInt(eElement.getElementsByTagName("SwitchCon").item(0).getTextContent());
			XmlValues.add(Li_Switch);
			Li_Switch =Integer.parseInt(eElement.getElementsByTagName("CaseCon").item(0).getTextContent());
			XmlValues.add(Li_Switch);
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
	return XmlValues;
    
	 }

}
