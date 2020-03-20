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


@WebServlet("/Settings_serv")
public class Settings_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Integer> csList =new ArrayList<Integer>();
	List<List<Integer>> Csettings =new ArrayList<List<Integer>>();
	
	List<Integer> SizeList =new ArrayList<Integer>();
	List<List<Integer>> Sizesettings =new ArrayList<List<Integer>>();
	
	List<Integer> VariableList =new ArrayList<Integer>();
	List<List<Integer>> Variablesettings =new ArrayList<List<Integer>>();
	
	List<Integer> MethodList =new ArrayList<Integer>();
	List<List<Integer>> Methodsettings =new ArrayList<List<Integer>>();
	
    public Settings_serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		CsReader csReader = new CsReader();
		csList.clear();
		Csettings.clear();
		csList = csReader.GetAllcsValues();
		
		SizeReader Sreader = new SizeReader();
		SizeList.clear();
		Sizesettings.clear();
		SizeList = Sreader.GetAllcsValues();
		
		VariableReader Vreader = new VariableReader();
		VariableList.clear();
		Variablesettings.clear();
		VariableList = Vreader.GetAllcsValues();
		
		MethodReader Mreader = new MethodReader();
		MethodList.clear();
		Methodsettings.clear();
		MethodList = Mreader.GetAllcsValues();
		
		Csettings.add(csList);
		Sizesettings.add(SizeList);
		Variablesettings.add(VariableList);
		Methodsettings.add(MethodList);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/settings.jsp");
		request.setAttribute("CsList",Csettings);
		request.setAttribute("SizeList",Sizesettings);
		request.setAttribute("VariableList",Variablesettings);
		request.setAttribute("MethodList",Methodsettings);
		dispatcher.forward(request, response);
	}

}
