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

public class VariableReader {
	int Li_a=0;
	int Li_b=0;
	int Li_c=0;
	int Li_d=0;
	
	List <Integer>XmlValues = new ArrayList<Integer>();

	public List<Integer> GetAllcsValues(){
		  
		  try {

			File fXmlFile = new File("C:\\Users\\Dinu_98x\\OneDrive\\Desktop\\ITPM FINAL PROJECT\\ITPM\\CDE_IT\\WebContent\\xml\\variable.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
	
	
	
			doc.getDocumentElement().normalize();

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("VariableSVM");

			for (int temp = 0; temp < nList.getLength(); temp++) {
		
				Node nNode = nList.item(temp);
				
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
					Element eElement = (Element) nNode;
					
					Li_a = Integer.parseInt((eElement.getElementsByTagName("GlobalV").item(0).getTextContent()));
					XmlValues.add(Li_a);
					Li_b = Integer.parseInt(eElement.getElementsByTagName("LocalV").item(0).getTextContent());
					XmlValues.add(Li_b);
					Li_c =Integer.parseInt(eElement.getElementsByTagName("PrimitiveDataV").item(0).getTextContent());
					XmlValues.add(Li_c);
					Li_d =Integer.parseInt(eElement.getElementsByTagName("CompositeDataV").item(0).getTextContent());
					XmlValues.add(Li_d);
				}
			}
			
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		  System.out.println("variable XML values :  " +XmlValues);
			return XmlValues;
	 }

}
