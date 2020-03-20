package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
import xmlReader.VariableReader;

public class VariableData {
	int Wvs;
	int Npdtv;
	int Ncdtv;
	int Cv;
	
	String token1 ="";
	List<Integer> ValueList = new ArrayList<Integer>();
	VariableReader variablereader = new VariableReader();
	
	public int getWvs() {
		return Wvs;
	}
	public void setWvs(int wvs) {
		ValueList = variablereader.GetAllcsValues();
		Wvs = ValueList.get(0);
	}
	public int getNpdtv() {
		return Npdtv;
	}
	public void setNpdtv(int npdtv) {
		ValueList = variablereader.GetAllcsValues();
		Npdtv = ValueList.get(1);
	}
	public int getNcdtv() {
		return Ncdtv;
	}
	public void setNcdtv(int ncdtv) {
		ValueList = variablereader.GetAllcsValues();
		Ncdtv = ValueList.get(2);
	}
	public int getCv() {
		return Cv;
	}
	public void setCv(int cv) {
		ValueList = variablereader.GetAllcsValues();
		Cv = ValueList.get(3);
	}
	
	//Logic.
	
		public int FindWvs(String CodeLine) {
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
		
		public int FindNpdtv(String CodeLine) {
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
		
		public int FindNcdtv(String CodeLine) {
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
		
		public int FindCv(String CodeLine) {
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
