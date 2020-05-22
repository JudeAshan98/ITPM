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
 * Servlet implementation class sizeUpdater
 */
@WebServlet("/sizeUpdater")
public class sizeUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sizeUpdater() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keywordS_val = request.getParameter("keywordS");
		String IdentifierS_val = request.getParameter("IdentifierS");
		String OperatorS_val = request.getParameter("OperatorS");
		String NumericalS_val = request.getParameter("NumericalS");
		String literalS_val = request.getParameter("literalS");
	//	String csS_val = request.getParameter("csS");

		try {

			URL url = getClass().getResource("/xmlReader/size.xml");
			File fXmlFile = new File(url.getPath());
			String filepath = fXmlFile.toString();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// Get the SizeSVM element by tag name directly
			Node values = doc.getElementsByTagName("SizeSVM").item(0);

			// loop the SizeSVM child node
			NodeList list = values.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

				Node node = list.item(i);

				// get the child elements, and update the value
				if ("keywordS".equals(node.getNodeName())) {
					node.setTextContent(keywordS_val);
				}
				if ("IdentifierS".equals(node.getNodeName())) {
					node.setTextContent(IdentifierS_val);
				}
				if ("OperatorS".equals(node.getNodeName())) {
					node.setTextContent(OperatorS_val);
				}
				if ("NumericalS".equals(node.getNodeName())) {
					node.setTextContent(NumericalS_val);
				}
				if ("literalS".equals(node.getNodeName())) {
					node.setTextContent(literalS_val);
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
