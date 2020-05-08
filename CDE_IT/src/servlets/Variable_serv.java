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

import ValueGenerator.VariableData;

@WebServlet("/Variable_serv")
public class Variable_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String[][] arrayRefVar;
	String Result;
	String token1 = "\n";
	int Wvs = 0;
	int Npdtv = 0;
	int Ncdtv = 0;
	int Cv = 0;

	public Variable_serv() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		Result = request.getParameter("variable_res");
		String extention = request.getParameter("VExtention");
		Scanner scanner = new Scanner(Result);
		VariableData variabledata = new VariableData();
		List<List<Comparable>> p = new ArrayList<List<Comparable>>();
		while (scanner.hasNextLine()) {
			token1 = scanner.nextLine();

			Wvs = variabledata.FindWvs(token1, extention);
			Npdtv = variabledata.FindNpdtv(token1, extention);
			Ncdtv = variabledata.FindNcdtv(token1, extention);
			Cv = variabledata.FindCv(token1);

			List<Comparable> c = new ArrayList<Comparable>();

			c.add(token1);
			c.add(Wvs);
			c.add(Npdtv);
			c.add(Ncdtv);
			c.add(Cv);
			p.add(c);
		}
		scanner.close(); // close the scanner
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Variable.jsp");
		request.setAttribute("Code_string", p);
		dispatcher.forward(request, response);
	}

}
