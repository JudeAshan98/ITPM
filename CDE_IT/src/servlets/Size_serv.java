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

@WebServlet("/Size_serv")
public class Size_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String[][] arrayRefVar;
	String Result;
	String token1 = "\n";
	int Nkw = 0;
	int Nid = 0;
	int Nop = 0;
	int Nnv = 0;
	int Nsl = 0;
	int Cs = 0;

	public Size_serv() {
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

		Result = request.getParameter("size_res");
		String extention = request.getParameter("SExtention");
		Scanner scanner = new Scanner(Result);
		SizeData sizeData = new SizeData();
		List<List<Comparable>> p = new ArrayList<List<Comparable>>();
		while (scanner.hasNextLine()) {
			token1 = scanner.nextLine();

			Nkw = sizeData.FindNkw(token1, extention);
			Nid = sizeData.FindNid(token1, extention);
			Nop = sizeData.FindNop(token1, extention);
			Nnv = sizeData.FindNnv(token1);
			Nsl = sizeData.FindNsl(token1, extention);
			Cs = sizeData.FindCs(token1);

			List<Comparable> c = new ArrayList<Comparable>();

			c.add(token1);
			c.add(Nkw);
			c.add(Nid);
			c.add(Nop);
			c.add(Nnv);
			c.add(Nsl);
			c.add(Cs);
			p.add(c);
		}
		scanner.close(); // close the scanner
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Size.jsp");
		request.setAttribute("Code_string", p);
		dispatcher.forward(request, response);
	}

}
