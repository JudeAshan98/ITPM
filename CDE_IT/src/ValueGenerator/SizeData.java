package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xmlReader.SizeReader;

public class SizeData {
	
	int Nkw;
	int Nid;
	int Nop;
	int Nnv;
	int Nsl;
	
	String token1 ="";
	List<Integer> ValueList = new ArrayList<Integer>();
	SizeReader sizereader = new SizeReader();
	
	public int getNkw() {
		return Nkw;
	}
	public void setNkw(int nkw) {
		ValueList = sizereader.GetAllcsValues();
		Nkw = ValueList.get(0);
	}
	public int getNid() {
		return Nid;
	}
	public void setNid(int nid) {
		ValueList = sizereader.GetAllcsValues();
		Nid = ValueList.get(1);
	}
	public int getNop() {
		return Nop;
	}
	public void setNop(int nop) {
		ValueList = sizereader.GetAllcsValues();
		Nop = ValueList.get(2);
	}
	public int getNnv() {
		return Nnv;
	}
	public void setNnv(int nnv) {
		ValueList = sizereader.GetAllcsValues();
		Nnv = ValueList.get(3);
	}
	public int getNsl() {
		return Nsl;
	}
	public void setNsl(int nsl) {
		ValueList = sizereader.GetAllcsValues();
		Nsl = ValueList.get(4);
	}

	//Logic.
	
	public int FindNkw(String CodeLine) {
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
	
	public int FindNid(String CodeLine) {
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
	
	public int FindNop(String CodeLine) {
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
	
	public int FindNnv(String CodeLine) {
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
	
	public int FindNsl(String CodeLine) {
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
