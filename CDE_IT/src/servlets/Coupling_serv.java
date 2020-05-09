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
import ValueGenerator.CouplingData;

@WebServlet("/Coupling_serv")
public class Coupling_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String[][] arrayRefVar;
	String Result;
	String token1 = "\n";

	int Nr = 0;
	int Nmcms = 0;
	int Nmcmd = 0;
	int Nmcrms = 0;
	int Nmcrmd = 0;
	int Nrmcrms = 0;
	int Nrmcrmd = 0;
	int Nrmcms = 0;
	int Nrmcmd = 0;
	int Nmrgvs = 0;
	int Nmrgvd = 0;
	int Nrmrgvs = 0;
	int Nrmrgvd = 0;
	int Ccp = 0;

	public Coupling_serv() {
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

		Result = request.getParameter("couple_res");
		Scanner scanner = new Scanner(Result);
		CouplingData couplingdata = new CouplingData();
		List<List<Comparable>> p = new ArrayList<List<Comparable>>();
		while (scanner.hasNextLine()) {
			token1 = scanner.nextLine();

			Nr = couplingdata.findNr(token1);
			Nmcms = couplingdata.findNmcms(token1);
			Nmcmd = couplingdata.findNmcmd(token1);
			Nmcrms = couplingdata.findNmcrms(token1);
			Nmcrmd = couplingdata.findNmcrmd(token1);
			Nrmcrms = couplingdata.findNrmcrms(token1);
			Nrmcrmd = couplingdata.findNrmcrmd(token1);
			Nrmcms = couplingdata.findNrmcms(token1);
			Nrmcmd = couplingdata.findNrmcmd(token1);
			Nmrgvs = couplingdata.findNmrgvs(token1);
			Nmrgvd = couplingdata.findNmrgvd(token1);
			Nrmrgvs = couplingdata.findNrmrgvs(token1);
			Nrmrgvd = couplingdata.findNrmrgvd(token1);
			Ccp = couplingdata.findCcp(token1);

			List<Comparable> c = new ArrayList<Comparable>();

			c.add(token1);

			c.add(Nr);
			c.add(Nmcms);
			c.add(Nmcmd);
			c.add(Nmcrms);
			c.add(Nmcrmd);
			c.add(Nrmcrms);
			c.add(Nrmcrmd);
			c.add(Nrmcms);
			c.add(Nrmcmd);
			c.add(Nmrgvs);
			c.add(Nmrgvd);
			c.add(Nrmrgvs);
			c.add(Nrmrgvd);
			c.add(Ccp);

			p.add(c);
		}

		scanner.close(); // close the scanner
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Coupling.jsp");
		request.setAttribute("Code_string", p);
		dispatcher.forward(request, response);
	}

}
