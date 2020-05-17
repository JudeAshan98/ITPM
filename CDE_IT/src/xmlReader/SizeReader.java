package xmlReader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SizeReader {
	  int Li_a;
	  int Li_b;
	  int Li_c;
	  int Li_d;
	  int Li_e;
	  int Li_f;
	  List <Integer>XmlValues = new ArrayList<Integer>();
	  // This method can read values from the xml and return data to the valuegenerator class.
	
	  public List<Integer> GetAllcsValues(){
		  
		  try {
			  URL url = getClass().getResource("size.xml");
		    	File fXmlFile = new File(url.getPath());
//			File fXmlFile = new File("C:\\Users\\Jude Ashan\\Desktop\\Project\\Branch-Jude\\ITPM\\CDE_IT\\WebContent\\xml\\size.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
	
	
	
			doc.getDocumentElement().normalize();

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("SizeSVM");

			for (int temp = 0; temp < nList.getLength(); temp++) {
		
				Node nNode = nList.item(temp);
				
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
					Element eElement = (Element) nNode;
					
					Li_a = Integer.parseInt((eElement.getElementsByTagName("keywordS").item(0).getTextContent()));
					XmlValues.add(Li_a);
					Li_b = Integer.parseInt(eElement.getElementsByTagName("IdentifierS").item(0).getTextContent());
					XmlValues.add(Li_b);
					Li_c =Integer.parseInt(eElement.getElementsByTagName("OperatorS").item(0).getTextContent());
					XmlValues.add(Li_c);
					Li_d =Integer.parseInt(eElement.getElementsByTagName("NumericalS").item(0).getTextContent());
					XmlValues.add(Li_d);
					Li_e =Integer.parseInt(eElement.getElementsByTagName("literalS").item(0).getTextContent());
					XmlValues.add(Li_e);
					Li_f =Integer.parseInt(eElement.getElementsByTagName("csS").item(0).getTextContent());
					XmlValues.add(Li_f);
				}
			}
			
		  } catch (Exception e) {
			e.printStackTrace();
		  }
			return XmlValues;
	 }
}
