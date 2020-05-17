package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

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
		int value = 0;
		
		int totalIn=0;
		int totalDir=0;
		int totalin=0;
		int totalcom=0;
		
		Result = request.getParameter("inh_res");
		String extention = request.getParameter("IExtention");
		Scanner scanner  = new Scanner(Result);
		InheritData inheritData = new InheritData();
		List<List<Comparable>> p =new ArrayList<List<Comparable>>();
		List<Integer> excList=new ArrayList<Integer>();
		
		
		while(scanner.hasNextLine())  
		{  
			token1 = scanner.nextLine();
		
			// passing code line to check direct inheritance
			One=inheritData.DirectInh(token1,extention);
		
			
			totalDir=totalDir+One;
			
			//passing code line to check indirect inheritance
			Two=inheritData.InDirectInh(token1,extention);
			totalIn=totalIn+Two;
			
			//checking if execption returned
			if(One==-1||Two==-1)
			{
				excList.add(-1);
			}
			
			//to calculate addition of direct and indirect inheritance per code line
			Three=One+Two;
			
			totalin=totalin+Three;
			
			//to calculate total complexity per line
			Li_four = inheritData.totalWeight(Three);
			totalcom=totalcom+Li_four;

			List<Comparable> c = new ArrayList<Comparable>();

			c.add(token1);
			
			c.add(One);
			c.add(Two);
			c.add(Three);
			c.add(Li_four);
			p.add(c);
			
			
		}  
		scanner.close();     //close the scanner  
		System.out.print(p);
		
		//setting attributes if exception returned
		
		if(!excList.isEmpty())
		{
			request.setAttribute("check", "There is error in your code.Please follow Coding standards and rectify error ");
			request.setAttribute("link", "Link to check code standard");
			
		}
		
		// redirecting to inheritance view
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Inheritance.jsp");
		request.setAttribute("Code_string", p);
		//returning total values
		request.setAttribute("total_direct", totalDir);
		request.setAttribute("total_indirect", totalIn);
		request.setAttribute("total_inheritance", totalin);
		request.setAttribute("total_complex", totalcom);
		
		//passing the attributes
		dispatcher.forward(request, response);
	}

}
