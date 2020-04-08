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
import ValueGenerator.InheritData;
import xmlReader.inheritanceReader;

/**
 * Servlet implementation class Inheritance_serv
 */
@WebServlet("/Inheritance_serv")
public class Inheritance_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String[][] arrayRefVar;
	String Result;
	String token1 = "\n";
	int zero = 0;
	int One= 0;
	int Two =0;
	int Three =0;
	int Four =0;  
	
	private int Li_zero;
	private int Li_one;
	private int Li_two;
	private int Li_three;
	private int Li_four;
	
	List<Integer> ValueList = new ArrayList<Integer>();
	inheritanceReader inheritanceReader = new inheritanceReader();
	
	public int getLi_zero() {
		return Li_zero;
	}
	public void setLi_zero(int li_zero) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_zero = ValueList.get(0);
	}
	
	public int getLi_one() {
		return Li_one;
	}
	public void setLi_one(int li_one) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_one = ValueList.get(1);
	}
	public int getLi_two() {
		return Li_two;
	}
	public void setLi_two(int li_two) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_two = ValueList.get(2);
	}
	public int getLi_three() {
		return Li_three;
	}
	public void setLi_three(int li_three) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_three = ValueList.get(3);
	}
	public int getLi_four() {
		return Li_four;
	}
	public void setLi_four(int li_four) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_four = ValueList.get(4);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
	

    public Inheritance_serv() {
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
		
		Result = request.getParameter("inh_res");
		
		Scanner scanner  = new Scanner(Result);
		InheritData inheritData = new InheritData();
		List<List<Comparable>> p =new ArrayList<List<Comparable>>();
		while(scanner.hasNextLine())  
		{  
			token1 = scanner.nextLine();
			//zero = inheritData.DirectInd(token1);
			//One = inheritData.DirectInhone(token1);
			One=inheritData.DirectInh(token1);
			Two=inheritData.InDirectInh(token1);
			//Three=inheritData.totalInDirectInh();
			Three=One+Two;
			
			Li_four = inheritData.totalWeight(Three);
//			NC = controlData.NofConditions(token1);
//			Ccspps = controlData.previousComplex(token1);
			List<Comparable> c = new ArrayList<Comparable>();
//			Ccs = (Wtcs*NC)+Ccspps;
			c.add(token1);
			//c.add(One);
			c.add(One);
			c.add(Two);
			c.add(Three);
			c.add(Li_four);
			p.add(c);
			
			System.out.print(c);
		}  
		scanner.close();     //close the scanner  
		System.out.print(p);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Inheritance.jsp");
		request.setAttribute("Code_string", p);
		dispatcher.forward(request, response);
	}

}
