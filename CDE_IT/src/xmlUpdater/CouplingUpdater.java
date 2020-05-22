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
 * Servlet implementation class CouplingUpdater
 */
@WebServlet("/CouplingUpdater")
public class CouplingUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouplingUpdater() {
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
		String recursiveCall_val = request.getParameter("recursiveCall");
		String RGregularSame_val = request.getParameter("RGregularSame");
		String RGregularDiff_val = request.getParameter("RGregularDiff");
		String RGrecursiveSame_val = request.getParameter("RGrecursiveSame");

		String RGrecursiveDiff_val = request.getParameter("RGrecursiveDiff");
		String RSrecursiveSame_val = request.getParameter("RSrecursiveSame");
		String RSrecursiveDiff_val = request.getParameter("RSrecursiveDiff");
		String RSregularSame_val = request.getParameter("RSregularSame");
		
		String RSregularDiff_val = request.getParameter("RSregularDiff");
		String RMGSame_val = request.getParameter("RMGSame");
		String RMGDiff_val = request.getParameter("RMGDiff");
		String RSMGSame_val = request.getParameter("RSMGSame");
		String RSMGDiff_val = request.getParameter("RSMGDiff");
		
		try {

			URL url = getClass().getResource("/xmlReader/Coupling.xml");
			File fXmlFile = new File(url.getPath());
			String filepath = fXmlFile.toString();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// Get the CouplingVariables element by tag name directly
			Node values = doc.getElementsByTagName("CouplingVariables").item(0);

			// loop the CouplingVariables child node
			NodeList list = values.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

				Node node = list.item(i);

				// get the child elements, and update the value
				if ("recursiveCall".equals(node.getNodeName())) {
					node.setTextContent(recursiveCall_val);
				}
				if ("RGregularSame".equals(node.getNodeName())) {
					node.setTextContent(RGregularSame_val);
				}
				if ("RGregularDiff".equals(node.getNodeName())) {
					node.setTextContent(RGregularDiff_val);
				}
				if ("RGrecursiveSame".equals(node.getNodeName())) {
					node.setTextContent(RGrecursiveSame_val);
				}
				if ("RGrecursiveDiff".equals(node.getNodeName())) {
					node.setTextContent(RGrecursiveDiff_val);
				}
				if ("RSrecursiveSame".equals(node.getNodeName())) {
					node.setTextContent(RSrecursiveSame_val);
				}
				if ("RSrecursiveDiff".equals(node.getNodeName())) {
					node.setTextContent(RSrecursiveDiff_val);
				}
				if ("RSregularSame".equals(node.getNodeName())) {
					node.setTextContent(RSregularSame_val);
				}
				if ("RSregularDiff".equals(node.getNodeName())) {
					node.setTextContent(RSregularDiff_val);
				}
				if ("RMGSame".equals(node.getNodeName())) {
					node.setTextContent(RMGSame_val);
				}
				if ("RMGDiff".equals(node.getNodeName())) {
					node.setTextContent(RMGDiff_val);
				}
				if ("RSMGSame".equals(node.getNodeName())) {
					node.setTextContent(RSMGSame_val);
				}
				if ("RSMGDiff".equals(node.getNodeName())) {
					node.setTextContent(RSMGDiff_val);
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
