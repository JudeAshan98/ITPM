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
	
	public int FindWmrt(String CodeLine) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if ((token1.contains("if")) || (token1.contains("for")) || (token1.contains("while"))
					|| (token1.contains("while")) || (token1.contains("do")) || (token1.contains("switch"))
					|| (token1.contains("case"))) {
				Li_Count = Li_Count + 1;
			}
		}
		scanner.close();	
		return Li_Count;
	}
	
	public int FindNpdtp(String CodeLine) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if ((token1.contains("if")) || (token1.contains("for")) || (token1.contains("while"))
					|| (token1.contains("while")) || (token1.contains("do")) || (token1.contains("switch"))
					|| (token1.contains("case"))) {
				Li_Count = Li_Count + 1;
			}
		}
		scanner.close();	
		return Li_Count;
	}
	
	public int FindNcdtp(String CodeLine) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if ((token1.contains("if")) || (token1.contains("for")) || (token1.contains("while"))
					|| (token1.contains("while")) || (token1.contains("do")) || (token1.contains("switch"))
					|| (token1.contains("case"))) {
				Li_Count = Li_Count + 1;
			}
		}
		scanner.close();	
		return Li_Count;
	}
	
	public int FindCm(String CodeLine) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if ((token1.contains("if")) || (token1.contains("for")) || (token1.contains("while"))
					|| (token1.contains("while")) || (token1.contains("do")) || (token1.contains("switch"))
					|| (token1.contains("case"))) {
				Li_Count = Li_Count + 1;
			}
		}
		scanner.close();	
		return Li_Count;
	}
}
