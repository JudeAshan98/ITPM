package xmlReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class inheritanceReader {
	
      int Li_zero;
	  int Li_one;
	  int Li_two;
	  int Li_three;
	  int Li_four;
	  List <Integer>XmlValues = new ArrayList<Integer>();
	  // This method can read values from the xml and return data to the valuegenerator class.
	public List<Integer> GetAllcsValues(){
		  
  try {

	File fXmlFile = new File("C:\\Users\\Dinu_98x\\OneDrive\\Desktop\\ITPM FINAL PROJECT\\ITPM\\CDE_IT\\WebContent\\xml\\inheritParser.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	
	
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("inhvariables");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		
	//	System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			
			Element eElement = (Element) nNode;
			
			Li_zero = Integer.parseInt((eElement.getElementsByTagName("zeroU").item(0).getTextContent()));
			XmlValues.add(Li_zero);
			Li_one = Integer.parseInt((eElement.getElementsByTagName("oneU").item(0).getTextContent()));
			XmlValues.add(Li_one);
			Li_two = Integer.parseInt(eElement.getElementsByTagName("twoU").item(0).getTextContent());
			XmlValues.add(Li_two);
			Li_three =Integer.parseInt(eElement.getElementsByTagName("threeU").item(0).getTextContent());
			XmlValues.add(Li_three);
			Li_four =Integer.parseInt(eElement.getElementsByTagName("fourU").item(0).getTextContent());
			XmlValues.add(Li_four);
		}
	}
  } catch (Exception e) {
	e.printStackTrace();
  }
	return XmlValues;
  
	 }


}
