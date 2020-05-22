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
		int tot_Cs = 0;
		int tot_Cv = 0;
		int tot_Cm = 0;
		int tot_Ci = 0;
		int tot_Ccp = 0;
		int tot_Ccs = 0;
		int tot_Tcps = 0;

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
			Two = inheritData.InDirectInh(token1, extention);
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
			Ccspps = controlData.previousComplex(token1, Ccs);

			Cs = sizeData.FindCs(token1);
			tot_Cs = tot_Cs + Cs;
			
			Cv = variableData.FindCv(token1);
			tot_Cv = tot_Cv + Cv;
			
			Cm = methoddata.FindCm(token1);
			tot_Cm = tot_Cm + Cm;
			
			Ci = Li_four;
			tot_Ci = tot_Ci + Ci;
			
			Ccp = (2 * Nr) + (2 * Nmcms) + (1 * Nmrgvs);
			tot_Ccp = tot_Ccp + Ccp;
			
			Ccs = (Wtcs * NC) + Ccspps;
			tot_Ccs = tot_Ccs + Ccs;
			
			Tcps = Cs + Cv + Cm + Ci + Ccp + Ccs;
			tot_Tcps = tot_Tcps + Tcps;

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

		// returning total values
		request.setAttribute("Total_Cs", tot_Cs);
		request.setAttribute("Total_Cv", tot_Cv);
		request.setAttribute("Total_Cm", tot_Cm);
		request.setAttribute("Total_Ci", tot_Ci);
		request.setAttribute("Total_Ccp", tot_Ccp);
		request.setAttribute("Total_Ccs", tot_Ccs);
		request.setAttribute("Total_Tcps", tot_Tcps);

		dispatcher.forward(request, response);

	}

}
