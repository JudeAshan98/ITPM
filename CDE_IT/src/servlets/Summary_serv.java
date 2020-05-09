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

import ValueGenerator.ControlData;
import ValueGenerator.CouplingData;
import ValueGenerator.InheritData;
import ValueGenerator.SizeData;
import ValueGenerator.VariableData;
import ValueGenerator.MethodData;


@WebServlet("/Summary_serv")
public class Summary_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int Cs, Cv, Cm, Ci, Ccp, Ccs, Tcps = 0;
	String Result = "";
	String token1 = "\n";
	String extention = "";

	// Size
	int Nkw = 0;
	int Nid = 0;
	int Nop = 0;
	int Nnv = 0;
	int Nsl = 0;

	// Variable
	int Wvs = 0;
	int Npdtv = 0;
	int Ncdtv = 0;

	// Methods
	int Wmrt = 0;
	int Npdtp = 0;
	int Ncdtp = 0;

	// Inheritance
	int zero = 0;
	int One = 0;
	int Two = 0;
	int Three = 0;
	int Li_four = 0;

	// Control Structure
	int Wtcs = 0;
	int NC = 0;
	int Ccspps = 0;

	// Coupling
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

	public Summary_serv() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SizeData sizeData = new SizeData();
		VariableData variableData = new VariableData();
		MethodData methoddata = new MethodData();
		CouplingData couplingData = new CouplingData();
		InheritData inheritData = new InheritData();
		ControlData controlData = new ControlData();

		Result = request.getParameter("summary_res");
		extention = request.getParameter("SumExtention");
		Scanner scanner = new Scanner(Result);
		List<List<Comparable>> p = new ArrayList<List<Comparable>>();
		while (scanner.hasNextLine()) {
			token1 = scanner.nextLine();

			List<Comparable> c = new ArrayList<Comparable>();

			// Method
			Wmrt = methoddata.FindWmrt(token1, extention);
			Npdtp = methoddata.FindNpdtp(token1, extention);
			Ncdtp = methoddata.FindNcdtp(token1, extention);

			// Size
			Nkw = sizeData.FindNkw(token1, extention);
			Nid = sizeData.FindNid(token1, extention);
			Nop = sizeData.FindNop(token1, extention);
			Nnv = sizeData.FindNnv(token1);
			Nsl = sizeData.FindNsl(token1);

			// variable
			Wvs = variableData.FindWvs(token1, extention);
			Npdtv = variableData.FindNpdtv(token1, extention);
			Ncdtv = variableData.FindNcdtv(token1, extention);

			// Inheritance
			One = inheritData.DirectInh(token1, extention);
			Two = inheritData.InDirectInh(token1);
			Three = One + Two;
			Li_four = inheritData.totalWeight(Three);

			// Coupling
			Nr = couplingData.findNr(token1);
			Nmcms = couplingData.findNmcms(token1);
			Nmcmd = couplingData.findNmcmd(token1);
			Nmcrms = couplingData.findNmcrms(token1);
			Nmcrmd = couplingData.findNmcrmd(token1);
			Nrmcrms = couplingData.findNrmcrms(token1);
			Nrmcrmd = couplingData.findNrmcrmd(token1);
			Nrmcms = couplingData.findNrmcms(token1);
			Nrmcmd = couplingData.findNrmcmd(token1);
			Nmrgvs = couplingData.findNmrgvs(token1);
			Nmrgvd = couplingData.findNmrgvd(token1);
			Nrmrgvs = couplingData.findNrmrgvs(token1);
			Nrmrgvd = couplingData.findNrmrgvd(token1);
			
			// Control Structures
			Wtcs = controlData.CtrlWeight(token1);
			NC = controlData.NofConditions(token1);
			Ccspps = controlData.previousComplex(token1);

			
			Cs = sizeData.FindCs(token1);
			Cv = variableData.FindCv(token1);
			Cm = methoddata.FindCm(token1);
			Ci = Li_four;
			Ccp = (2 * Nr) + (2 * Nmcms) + (1 * Nmrgvs);
			Ccs = (Wtcs * NC) + Ccspps;
			Tcps = Cs + Cv + Cm + Ci + Ccp + Ccs;
			
			c.add(token1);
			c.add(Cs); // Size
			c.add(Cv); // variable
			c.add(Cm); // Method
			c.add(Ci); // Inheritance
			c.add(Ccp); // Coupling 
			c.add(Ccs); // Control Structures
			c.add(Tcps);
			p.add(c);
		}
		scanner.close(); // close the scanner
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/summary.jsp");
		request.setAttribute("Code_string", p);
		dispatcher.forward(request, response);

	}

}
