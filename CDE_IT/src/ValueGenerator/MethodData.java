package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xmlReader.MethodReader;

public class MethodData {
	int Wmrt;
	int Npdtp;
	int Ncdtp;
	int Cm;
	
	String token1 ="";
	List<Integer> ValueList = new ArrayList<Integer>();
	MethodReader methodreader = new MethodReader();
	
	public int getWmrt() {
		return Wmrt;
	}
	public void setWmrt(int wmrt) {
		ValueList = methodreader.GetAllcsValues();
		Wmrt = ValueList.get(0);
	}
	public int getNpdtp() {
		return Npdtp;
	}
	public void setNpdtp(int npdtp) {
		ValueList = methodreader.GetAllcsValues();
		Npdtp = ValueList.get(1);
	}
	public int getNcdtp() {
		return Ncdtp;
	}
	public void setNcdtp(int ncdtp) {
		ValueList = methodreader.GetAllcsValues();
		Ncdtp = ValueList.get(2);
	}
	public int getCm() {
		return Cm;
	}
	public void setCm(int cm) {
		ValueList = methodreader.GetAllcsValues();
		Cm = ValueList.get(3);
	}
	
	//Logic.
	
	//WMRT Done
	public int FindWmrt(String CodeLine) {
		int Li_Count = 0;
		String token1 = "";
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			
			if((token1.contains("public")) || (token1.contains("private"))) {
				
				token1 = scanner.next();
				
				while (!token1.contains("(")) {
					
					if ((token1.contains("int")) || (token1.contains("long")) || (token1.contains("double"))
							|| (token1.contains("float")) || (token1.contains("boolean")) || (token1.contains("char"))
							|| (token1.contains("arrays")) || (token1.contains("objects")) || (token1.contains("records"))
							|| (token1.contains("interfaces")) || (token1.contains("lists"))) {
						Li_Count = Li_Count + 1;
					}
										
					token1 = scanner.next();
				}
				
			}
			
			Li_Count = 0;
			return 0;
			
					
		}
		scanner.close();	
		return Li_Count;

	}
	
	public int FindNpdtp(String CodeLine) {
		int Li_Count = 0;
			
		return Li_Count;
	}
	
	public int FindNcdtp(String CodeLine) {
		int Li_Count = 0;
		
		return Li_Count;
	}
	
	public int FindCm(String CodeLine) {
		int Li_Count = 0;
		
		return Li_Count;
	}
}
