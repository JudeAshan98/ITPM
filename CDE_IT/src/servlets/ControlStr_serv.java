package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ValueGenerator.*;
/**
 * Servlet implementation class ControlStr_serv
 */
@WebServlet("/ControlStr_serv")
public class ControlStr_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	String[][] arrayRefVar;
	String Result;
	String token1 = "\n";
	//String[] lines ;
	//ArrayList<String> lines;
	public int Wtcs = 0;
	int NC= 0;
	int Ccspps =0;
	List<String> cdLine = new ArrayList<String>();
	List<Integer> wtc = new ArrayList<Integer>();
	List<Integer> ncc = new ArrayList<Integer>();
	List<Integer> ccpps = new ArrayList<Integer>();
    public ControlStr_serv() {
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
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Result = request.getParameter("cont_res");

	//	lines = Result.split(System.getProperty("line.separator")); //Read string without while loop -- Commented useful for now.
		
		Scanner scanner  = new Scanner(Result);
		ControlData controlData = new ControlData();
		while(scanner.hasNextLine())  
		{  
			token1 = scanner.nextLine();
			Wtcs = controlData.CtrlWeight(token1);
			NC = controlData.NofConditions(token1);
			Ccspps = controlData.previousComplex(token1);
			
			cdLine.add(token1);
			wtc.add(Ccspps);
			ncc.add(NC);
			ccpps.add(Wtcs);
 
		}  
		
		List arr[]={cdLine,wtc,ncc,ccpps};   
		scanner.close();     //close the scanner  
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Control_structures.jsp");
		request.setAttribute("Code_string", arr);
		dispatcher.forward(request, response);
	}

}
