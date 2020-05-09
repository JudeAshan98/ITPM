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

public class CouplingReader {
	
	int Li_a;
	int Li_b;
	int Li_c;
	int Li_d;
	int Li_e;
	int Li_f;
	int Li_g;
	int Li_h;
	int Li_i;
	int Li_j;
	int Li_k;
	int Li_l;
	int Li_m;
	
	List <Integer>XmlValues = new ArrayList<Integer>();
	// This method can read values from the xml and return data to the valuegenerator class.
	public List<Integer> GetAllcsValues(){
		  
  try {

	File fXmlFile = new File("C:\\Users\\Dinu_98x\\OneDrive\\Desktop\\ITPM FINAL PROJECT\\ITPM\\CDE_IT\\WebContent\\xml\\Coupling.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	
	
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("CouplingVariables");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		
	//	System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			Li_a = Integer.parseInt((eElement.getElementsByTagName("recursiveCall").item(0).getTextContent()));
			XmlValues.add(Li_a);
			
			Li_b = Integer.parseInt(eElement.getElementsByTagName("RGregularSame").item(0).getTextContent());
			XmlValues.add(Li_b);
			
			Li_c =Integer.parseInt(eElement.getElementsByTagName("RGregularDiff").item(0).getTextContent());
			XmlValues.add(Li_c);
			
			Li_d =Integer.parseInt(eElement.getElementsByTagName("RGrecursiveSame").item(0).getTextContent());
			XmlValues.add(Li_d);
			
			Li_e = Integer.parseInt((eElement.getElementsByTagName("RGrecursiveDiff").item(0).getTextContent()));
			XmlValues.add(Li_e);
			
			Li_f = Integer.parseInt(eElement.getElementsByTagName("RSrecursiveSame").item(0).getTextContent());
			XmlValues.add(Li_f);
			
			Li_g =Integer.parseInt(eElement.getElementsByTagName("RSrecursiveDiff").item(0).getTextContent());
			XmlValues.add(Li_g);
			
			Li_h =Integer.parseInt(eElement.getElementsByTagName("RSregularSame").item(0).getTextContent());
			XmlValues.add(Li_h);
			
			Li_i = Integer.parseInt((eElement.getElementsByTagName("RSregularDiff").item(0).getTextContent()));
			XmlValues.add(Li_i);
			
			Li_j = Integer.parseInt(eElement.getElementsByTagName("RMGSame").item(0).getTextContent());
			XmlValues.add(Li_j);
			
			Li_k =Integer.parseInt(eElement.getElementsByTagName("RMGDiff").item(0).getTextContent());
			XmlValues.add(Li_k);
			
			Li_l =Integer.parseInt(eElement.getElementsByTagName("RSMGSame").item(0).getTextContent());
			XmlValues.add(Li_l);
			
			Li_m =Integer.parseInt(eElement.getElementsByTagName("RSMGDiff").item(0).getTextContent());
			XmlValues.add(Li_m);
		}
	}
  } catch (Exception e) {
	e.printStackTrace();
  }
	return XmlValues;
  
	 }

}
