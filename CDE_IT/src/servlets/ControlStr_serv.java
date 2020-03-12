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

/**
 * Servlet implementation class ControlStr_serv
 */
@WebServlet("/ControlStr_serv")
public class ControlStr_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	String Result;
	String token1 = "\n";
	//String[] lines ;
	//ArrayList<String> lines;

	
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Result = request.getParameter("cont_res");

	//	lines = Result.split(System.getProperty("line.separator")); //Read string without while loop -- Commented useful for now.
		
		Scanner scanner  = new Scanner(Result);
		List<String> temps = new ArrayList<String>();
		while(scanner.hasNextLine())  
		{  
			token1 = scanner.nextLine();
			temps.add(token1);
		}  
		scanner.close();     //closes the scanner  
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Control_structures.jsp");
		request.setAttribute("Code_string", temps);
		dispatcher.forward(request, response);
	}

}
