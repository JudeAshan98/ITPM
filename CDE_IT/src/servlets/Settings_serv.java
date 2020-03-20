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
	//ArrayList<Integer> Csettings = new ArrayList<Integer>();
	List<List<Integer>> Csettings =new ArrayList<List<Integer>>();
	
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
		//csList.toArray();
//		int[] myArray = new int[csList.size()];
//		 csList.toArray();
//		 
//		 int[] array = csList.stream().mapToInt(i->i).toArray();
//		 
//		 for(int i=0; i<csList.size(); i++){
//			 myArray[i] = csList.get(i);
//	         System.out.println("Element at the index "+i+" is ::"+myArray[i]);
//	      }
		 
		System.out.println(csList);
		System.out.println("---------------");
		Csettings.add(csList);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/settings.jsp");
		request.setAttribute("CsList",Csettings);
	//	request.setAttribute("InhList",csList);
		dispatcher.forward(request, response);
	}

}
