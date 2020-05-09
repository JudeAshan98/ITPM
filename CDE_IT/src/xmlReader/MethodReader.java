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

public class MethodReader {
	int Li_a;
	int Li_b;
	int Li_c;
	int Li_d;
	int Li_e;
	List <Integer>XmlValues = new ArrayList<Integer>();

	public List<Integer> GetAllcsValues(){
		  
		  try {

			File fXmlFile = new File("C:\\Users\\Dinu_98x\\OneDrive\\Desktop\\ITPM FINAL PROJECT\\ITPM\\CDE_IT\\WebContent\\xml\\method.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
	
	
	
			doc.getDocumentElement().normalize();

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("MethodSVM");

			for (int temp = 0; temp < nList.getLength(); temp++) {
		
				Node nNode = nList.item(temp);
				
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
					Element eElement = (Element) nNode;
					
					Li_a = Integer.parseInt((eElement.getElementsByTagName("PrimitiveReturnM").item(0).getTextContent()));
					XmlValues.add(Li_a);
					Li_b = Integer.parseInt(eElement.getElementsByTagName("CompositeReturnM").item(0).getTextContent());
					XmlValues.add(Li_b);
					Li_c =Integer.parseInt(eElement.getElementsByTagName("VoidReturnM").item(0).getTextContent());
					XmlValues.add(Li_c);
					Li_d =Integer.parseInt(eElement.getElementsByTagName("PrimitiveParaM").item(0).getTextContent());
					XmlValues.add(Li_d);
					Li_e =Integer.parseInt(eElement.getElementsByTagName("CompositeParaM").item(0).getTextContent());
					XmlValues.add(Li_e);
				}
			}
			
		  } catch (Exception e) {
			e.printStackTrace();
		  }
			return XmlValues;
	 }

}
