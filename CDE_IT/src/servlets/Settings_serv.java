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
import xmlReader.*;

/**
 * Servlet implementation class Settings_serv
 */
@WebServlet("/Settings_serv")
public class Settings_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	List<Integer> csList =new ArrayList<Integer>();
	List<Integer> CupList =new ArrayList<Integer>();
	List<Integer> InhList =new ArrayList<Integer>();
	List<Integer> SizeList =new ArrayList<Integer>();
	List<Integer> MethList =new ArrayList<Integer>();
	List<Integer> VarList =new ArrayList<Integer>();
	
	//ArrayList<Integer> Csettings = new ArrayList<Integer>();
	List<List<Integer>> Csettings =new ArrayList<List<Integer>>();
	List<List<Integer>> Cupettings =new ArrayList<List<Integer>>();
	List<List<Integer>> Inhsettings =new ArrayList<List<Integer>>();
	List<List<Integer>> Sizesettings =new ArrayList<List<Integer>>();
	List<List<Integer>> Methsettings =new ArrayList<List<Integer>>();
	List<List<Integer>> Varsettings =new ArrayList<List<Integer>>();
	
	
	
    public Settings_serv() {
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
		
		CsReader csReader = new CsReader();
		csList.clear();
		Csettings.clear();
		csList = csReader.GetAllcsValues();

		inheritanceReader inhReader = new inheritanceReader();
		InhList.clear();
		Inhsettings.clear();
		InhList = inhReader.GetAllcsValues();
		
		MethodReader methodReader = new MethodReader();
		MethList.clear();
		Methsettings.clear();
		MethList = methodReader.GetAllcsValues();
		
		SizeReader sizeReader = new SizeReader();
		SizeList.clear();
		Sizesettings.clear();
		SizeList = sizeReader.GetAllcsValues();
		 
		VariableReader variableReader = new VariableReader();
		VarList.clear();
		Varsettings.clear();
		VarList = variableReader.GetAllcsValues();
		
		CouplingReader couplingReader = new CouplingReader();
		CupList.clear();
		Cupettings.clear();
		CupList = couplingReader.GetAllcsValues();
		
		
		System.out.println("Control XML Values :" + csList);
		System.out.println("Cupling XML Values :" + CupList);
		System.out.println("Inheritance XML Values :" + InhList);
		System.out.println("Size XML Values :" + SizeList);
		System.out.println("Method XML Values :" + MethList);
		System.out.println("Variable XML Values :" + VarList);
		
		Csettings.add(csList);
		Cupettings.add(CupList);
		Inhsettings.add(InhList);
		Sizesettings.add(SizeList);
		Methsettings.add(MethList);
		Varsettings.add(VarList);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/settings.jsp");
		request.setAttribute("CsList",Csettings);
		request.setAttribute("CupList",Cupettings);
		request.setAttribute("InhList",Inhsettings);
		request.setAttribute("SizeList",Sizesettings);
		request.setAttribute("MethList",Methsettings);
		request.setAttribute("VarList",Varsettings);
		dispatcher.forward(request, response);
	}

}
