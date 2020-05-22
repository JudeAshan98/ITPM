package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xmlReader.CouplingReader;


@WebServlet("/Coupling")
public class Coupling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int Nr;
	private int Nmcms;
	private int Nmcmd;
	private int Nmcrms;
	private int Nmcrmd;
	private int Nrmcrms;
	private int Nrmcrmd;
	private int Nrmcms;
	private int Nrmcmd;
	private int Nmrgvs;
	private int Nmrgvd;
	private int Nrmrgvs;
	private int Nrmrgvd;
	private int Ccp;

	int sum;
	int a;
	int b;
	int c;
	int d;
	int e;
	int f;
	int g;
	int h;
	int i;
	int j;
	int k;
	int l;
	int m;
	int n;

	List<Integer> ValueList = new ArrayList<Integer>();
	CouplingReader couplingreader = new CouplingReader();
	String previousLine = null;

	public int getNr() {
		return Nr;
	}

	public void setNr(int nr) {
		ValueList = couplingreader.GetAllcsValues();
		Nr = ValueList.get(0);
	}

	public int getNmcms() {
		return Nmcms;
	}

	public void setNmcms(int nmcms) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcms = ValueList.get(1);
	}

	public int getNmcmd() {
		return Nmcmd;
	}

	public void setNmcmd(int nmcmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcmd = ValueList.get(2);
	}

	public int getNmcrms() {
		return Nmcrms;
	}

	public void setNmcrms(int nmcrms) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcrms = ValueList.get(3);
	}

	public int getNmcrmd() {
		return Nmcrmd;
	}

	public void setNmcrmd(int nmcrmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcrmd = ValueList.get(4);
	}

	public int getNrmcrms() {
		return Nrmcrms;
	}

	public void setNrmcrms(int nrmcrms) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcrms = ValueList.get(5);
	}

	public int getNrmcrmd() {
		return Nrmcrmd;
	}

	public void setNrmcrmd(int nrmcrmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcrmd = ValueList.get(6);
	}

	public int getNrmcms() {
		return Nrmcms;
	}

	public void setNrmcms(int nrmcms) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcms = ValueList.get(7);
	}

	public int getNrmcmd() {
		return Nrmcmd;
	}

	public void setNrmcmd(int nrmcmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcmd = ValueList.get(8);
	}

	public int getNmrgvs() {
		return Nmrgvs;
	}

	public void setNmrgvs(int nmrgvs) {
		ValueList = couplingreader.GetAllcsValues();
		Nmrgvs = ValueList.get(9);
	}

	public int getNmrgvd() {
		return Nmrgvd;
	}

	public void setNmrgvd(int nmrgvd) {
		ValueList = couplingreader.GetAllcsValues();
		Nmrgvd = ValueList.get(10);
	}

	public int getNrmrgvs() {
		return Nrmrgvs;
	}

	public void setNrmrgvs(int nrmrgvs) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmrgvs = ValueList.get(11);
	}

	public int getNrmrgvd() {
		return Nrmrgvd;
	}

	public void setNrmrgvd(int nrmrgvd) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmrgvd = ValueList.get(12);
	}

	public int getCcp() {
		return Ccp;
	}

	public void setCcp(int ccp) {
		ValueList = couplingreader.GetAllcsValues();
		Ccp = ValueList.get(13);
	}


    public Coupling() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
	//	String type = request.getParameter("selectFactor");
		String code = request.getParameter("couple_res");
		
		HttpSession session = request.getSession();
		session.setAttribute("test_code",code);
		
	//	 if(type.equals("coupling")) {
			int recursive = getNr();
			session.setAttribute("recursive",recursive);
			
			int regularRegular = getNmcms();
			session.setAttribute("regularRegular",regularRegular);
			
			int regularRecursive = getNmcmd();
			session.setAttribute("regularRecursive",regularRecursive);
			
			int recursiveRecursive = getNmcrms();
			session.setAttribute("recursiveRecursive",recursiveRecursive);
			
			int recursiveRegular = getNrmcms();
			session.setAttribute("recursiveRegular",recursiveRegular);
			
			int regularGlobal = getNmrgvs();
			session.setAttribute("regularGlobal",regularGlobal);
			
			int recursiveGlobal = getNrmrgvs();
			session.setAttribute("recursiveGlobal",recursiveGlobal);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Coupling.jsp");
			dispatcher.forward(request, response);
		//}
	}

}
