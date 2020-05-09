package xmlUpdater;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Document;

/**
 * Servlet implementation class ControlUpdater
 */
@WebServlet("/ControlUpdater")
public class ControlUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlUpdater() {
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
//		doGet(request, response);
		String Li_if_u = request.getParameter("ifelse");
		String Li_Fwd_u = request.getParameter("fwd");
		String Li_Case_u = request.getParameter("switch");
		String Li_Switch_u = request.getParameter("case");

		try {
			
			System.out.println("Recevied : " +Li_if_u);
			
			File fXmlFile = new File("C:\\Users\\Jude Ashan\\Desktop\\Project\\Branch-Jude\\ITPM\\CDE_IT\\WebContent\\xml\\csParser.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList CsV = doc.getElementsByTagName("Csvariables");
			// loop the staff child node
//			NodeList list = CsV.getChildNodes();

			for (int i = 0; i < CsV.getLength(); i++) {

				Node node = CsV.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					//update the value
					eElement.getElementsByTagName("IfCon").item(0).setTextContent(Li_if_u);
					System.out.println("Ready to update : " +Li_if_u);
					System.out.println("Ready to update : " +eElement.getElementsByTagName("IfCon").item(0));
					eElement.getElementsByTagName("Fwd").item(0).setTextContent(Li_Fwd_u);
					eElement.getElementsByTagName("SwitchCon").item(0).setTextContent(Li_Case_u);
					eElement.getElementsByTagName("CaseCon").item(0).setTextContent(Li_Switch_u);		
				
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
//		request.setAttribute("Code_string", p);
		dispatcher.forward(request, response);
	}

}
