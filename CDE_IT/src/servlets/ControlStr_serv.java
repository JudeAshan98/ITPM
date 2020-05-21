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
	int Wtcs = 0;
	int NC= 0;
	int Ccspps =0;
	int Ccs =0;
	
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
		
		int tot_Wtcs = 0;
		int tot_Nc = 0;
		int tot_Ccspps = 0;
		int tot_Ccs = 0;
		
		Result = request.getParameter("cont_res");
		Scanner scanner  = new Scanner(Result);
		ControlData controlData = new ControlData();
		List<List<Comparable>> p =new ArrayList<List<Comparable>>();
		while(scanner.hasNextLine())  
		{  
			token1 = scanner.nextLine();
			Wtcs = controlData.CtrlWeight(token1);
			tot_Wtcs = tot_Wtcs + Wtcs;
					
			NC = controlData.NofConditions(token1);
			tot_Nc = tot_Nc + NC;
					
			Ccspps = controlData.previousComplex(token1);
			tot_Ccspps = tot_Ccspps + Ccspps;
					
			List<Comparable> c = new ArrayList<Comparable>();
			Ccs = (Wtcs*NC)+Ccspps;
			tot_Ccs = tot_Ccs + Ccs;
			
			c.add(token1);
			c.add(Wtcs);
			c.add(NC);
			c.add(Ccspps);
			c.add(Ccs);
			p.add(c);
		}  
		scanner.close();     //close the scanner  
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Control_structures.jsp");
		request.setAttribute("Code_string", p);
		
		request.setAttribute("Total_Wtcs", tot_Wtcs);
		request.setAttribute("Total_Nc", tot_Nc);
		request.setAttribute("Total_Ccspps", tot_Ccspps);
		request.setAttribute("Total_Ccs", tot_Ccs);
		
		dispatcher.forward(request, response);
	}

}
