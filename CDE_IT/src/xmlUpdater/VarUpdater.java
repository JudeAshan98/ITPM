package xmlUpdater;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Servlet implementation class VarUpdater
 */
@WebServlet("/VarUpdater")
public class VarUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VarUpdater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String GlobalV_val = request.getParameter("GlobalV");
		String LocalV_val = request.getParameter("LocalV");
		String PrimitiveDataV_val = request.getParameter("PrimitiveDataV");
		String CompositeDataV_val = request.getParameter("CompositeDataV");

		try {

			URL url = getClass().getResource("/xmlReader/variable.xml");
			File fXmlFile = new File(url.getPath());
			String filepath = fXmlFile.toString();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// Get the VariableSVM element by tag name directly
			Node values = doc.getElementsByTagName("VariableSVM").item(0);

			// loop the VariableSVM child node
			NodeList list = values.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

				Node node = list.item(i);

				// get the child elements, and update the value
				if ("GlobalV".equals(node.getNodeName())) {
					node.setTextContent(GlobalV_val);
				}
				if ("LocalV".equals(node.getNodeName())) {
					node.setTextContent(LocalV_val);
				}
				if ("PrimitiveDataV".equals(node.getNodeName())) {
					node.setTextContent(PrimitiveDataV_val);
				}
				if ("CompositeDataV".equals(node.getNodeName())) {
					node.setTextContent(CompositeDataV_val);
				}

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("Done");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
