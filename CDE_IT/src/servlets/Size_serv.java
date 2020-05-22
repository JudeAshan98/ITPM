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

		int tot_Nkw = 0;
		int tot_Nid = 0;
		int tot_Nop = 0;
		int tot_Nnv = 0;
		int tot_Nsl = 0;
		int tot_Cs = 0;

		Result = request.getParameter("size_res");
		String extention = request.getParameter("SExtention");
		Scanner scanner = new Scanner(Result);
		SizeData sizeData = new SizeData();
		List<List<Comparable>> p = new ArrayList<List<Comparable>>();
		while (scanner.hasNextLine()) {
			token1 = scanner.nextLine();

			Nkw = sizeData.FindNkw(token1, extention);
			tot_Nkw = tot_Nkw + Nkw;

			Nid = sizeData.FindNid(token1, extention);
			tot_Nid = tot_Nid + Nid;

			Nop = sizeData.FindNop(token1, extention);
			tot_Nop = tot_Nop + Nop;

			Nnv = sizeData.FindNnv(token1);
			tot_Nnv = tot_Nnv + Nnv;

			Nsl = sizeData.FindNsl(token1);
			tot_Nsl = tot_Nsl + Nsl;

			Cs = sizeData.FindCs(token1);
			tot_Cs = tot_Cs + Cs;

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
		// returning total values
		request.setAttribute("Total_Nkw", tot_Nkw);
		request.setAttribute("Total_Nid", tot_Nid);
		request.setAttribute("Total_Nop", tot_Nop);
		request.setAttribute("Total_Nnv", tot_Nnv);
		request.setAttribute("Total_Nsl", tot_Nsl);
		request.setAttribute("Total_Cs", tot_Cs);
		dispatcher.forward(request, response);
	}

}
