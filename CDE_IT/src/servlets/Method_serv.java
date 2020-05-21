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

import ValueGenerator.MethodData;

@WebServlet("/Method_serv")
public class Method_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String[][] arrayRefVar;
	String Result;
	String token1 = "\n";
	int Wmrt = 0;
	int Npdtp = 0;
	int Ncdtp = 0;
	int Cm = 0;
	
    public Method_serv() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		int tot_Wmrt = 0;
		int tot_Npdtp = 0;
		int tot_Ncdtp = 0;
		int tot_Cm = 0;
		
		
		Result = request.getParameter("method_res");
		String extention = request.getParameter("MExtention");
		Scanner scanner = new Scanner(Result);
		MethodData methoddata = new MethodData();
		List<List<Comparable>> p = new ArrayList<List<Comparable>>();
		while (scanner.hasNextLine()) {
			token1 = scanner.nextLine();

			Wmrt = methoddata.FindWmrt(token1, extention);
			tot_Wmrt = tot_Wmrt + Wmrt;
			
			Npdtp = methoddata.FindNpdtp(token1, extention);
			tot_Npdtp = tot_Npdtp + Npdtp;
					
			Ncdtp = methoddata.FindNcdtp(token1, extention);
			tot_Ncdtp = tot_Ncdtp + Ncdtp;
			
			Cm = methoddata.FindCm(token1);
			tot_Cm = tot_Cm + Cm;
					
			List<Comparable> c = new ArrayList<Comparable>();

			c.add(token1);
			c.add(Wmrt);
			c.add(Npdtp);
			c.add(Ncdtp);
			c.add(Cm);
			p.add(c);
		}
		scanner.close(); // close the scanner
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Methods.jsp");
		request.setAttribute("Code_string", p);
		request.setAttribute("Total_Wmrt", tot_Wmrt);
		request.setAttribute("Total_Npdtp", tot_Npdtp);
		request.setAttribute("Total_Ncdtp", tot_Ncdtp);
		request.setAttribute("Total_Cm", tot_Cm);
		dispatcher.forward(request, response);
	}

}
