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
		
		//WVS Done
		public int FindWvs(String CodeLine) {
			int Li_Count = 0;
			Scanner scanner = new Scanner(CodeLine);
			while (scanner.hasNext()) {
				token1 = scanner.next();
				
				if ((token1.contains("static")) || (token1.contains("public"))) {
					String vwvs = token1;
					vwvs = scanner.next();
					
					if((vwvs.contains("byte")) || (vwvs.contains("short")) || (vwvs.contains("int"))
							|| (vwvs.contains("long")) || (vwvs.contains("float")) || (vwvs.contains("double"))
							|| (vwvs.contains("boolean")) || (vwvs.contains("char")) || (vwvs.contains("byte[]")) || (vwvs.contains("short[]")) || (vwvs.contains("int[]"))
							|| (vwvs.contains("long[]")) || (vwvs.contains("float[]")) || (vwvs.contains("double[]"))
							|| (vwvs.contains("boolean[]")) || (vwvs.contains("char[]"))) {
						
						Li_Count = Li_Count + 1;
					}
				}
			}
			scanner.close();	
			return Li_Count;
		}
		
		//NPDTV Done
		public int FindNpdtv(String CodeLine) {
			String token1 = "";
			int Li_Count = 0;
			Scanner scanner = new Scanner(CodeLine);
			while (scanner.hasNext()) {
				token1 = scanner.next();
				if ((token1.contains("byte")) || (token1.contains("short")) || (token1.contains("int"))
						|| (token1.contains("long")) || (token1.contains("float")) || (token1.contains("double"))
						|| (token1.contains("boolean")) || (token1.contains("char"))) {
						
					
					if((!token1.equals("byte[]")) && (!token1.equals("short[]")) && (!token1.equals("int[]")) && (!token1.equals("long[]"))
							&& (!token1.equals("float[]")) && (!token1.equals("double[]")) && (!token1.equals("boolean[]")) && (!token1.equals("char[]"))) {
						Li_Count = Li_Count + 1;
					}
				}
			}
			scanner.close();	
			return Li_Count;
		}
		
		//NCDTV Done
		public int FindNcdtv(String CodeLine) {
			String token1 = "";
			int Li_Count = 0;
			Scanner scanner = new Scanner(CodeLine);
			while (scanner.hasNext()) {
				token1 = scanner.next();
				if ((token1.contains("byte")) || (token1.contains("short")) || (token1.contains("int"))
						|| (token1.contains("long")) || (token1.contains("float")) || (token1.contains("double"))
						|| (token1.contains("boolean")) || (token1.contains("char"))) {
						
					
					if((token1.equals("byte[]")) || (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
							|| (token1.equals("float[]"))|| (token1.equals("double[]")) || (token1.equals("boolean[]")) || (token1.equals("char[]"))) {
						Li_Count = Li_Count + 1;
					}
				}
			}
			scanner.close();	
			return Li_Count;
		}
		
		//CV Done
		public int FindCv(String CodeLine) {
			String token1 = "";
			int Li_Count = 0;
			Scanner scanner1 = new Scanner(CodeLine);
			while (scanner1.hasNext()) {
				token1 = scanner1.next();
				if ((token1.contains("byte")) || (token1.contains("short")) || (token1.contains("int"))
						|| (token1.contains("long")) || (token1.contains("float")) || (token1.contains("double"))
						|| (token1.contains("boolean")) || (token1.contains("char"))) {
						
					
					if((!token1.equals("byte[]")) && (!token1.equals("short[]")) && (!token1.equals("int[]")) && (!token1.equals("long[]"))
							&& (!token1.equals("float[]")) && (!token1.equals("double[]")) && (!token1.equals("boolean[]")) && (!token1.equals("char[]"))) {
						Li_Count = Li_Count + 1;
					}
				}
			}
			scanner1.close();
			int a = Li_Count;
			
			token1 = "";
			Li_Count = 0;
			Scanner scanner2 = new Scanner(CodeLine);
			while (scanner2.hasNext()) {
				token1 = scanner2.next();
				if ((token1.contains("byte")) || (token1.contains("short")) || (token1.contains("int"))
						|| (token1.contains("long")) || (token1.contains("float")) || (token1.contains("double"))
						|| (token1.contains("boolean")) || (token1.contains("char"))) {
						
					
					if((token1.equals("byte[]")) || (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
							|| (token1.equals("float[]"))|| (token1.equals("double[]")) || (token1.equals("boolean[]")) || (token1.equals("char[]"))) {
						Li_Count = Li_Count + 1;
					}
				}
			}
			scanner2.close();
			int b = Li_Count;
			
			token1 = "";
			Li_Count = 0;
			Scanner scanner3 = new Scanner(CodeLine);
			while (scanner3.hasNext()) {
				token1 = scanner3.next();
				
				if ((token1.contains("static")) || (token1.contains("public"))) {
					String vwvs = token1;
					vwvs = scanner3.next();
					
					if((vwvs.contains("byte")) || (vwvs.contains("short")) || (vwvs.contains("int"))
							|| (vwvs.contains("long")) || (vwvs.contains("float")) || (vwvs.contains("double"))
							|| (vwvs.contains("boolean")) || (vwvs.contains("char")) || (vwvs.contains("byte[]")) || (vwvs.contains("short[]")) || (vwvs.contains("int[]"))
							|| (vwvs.contains("long[]")) || (vwvs.contains("float[]")) || (vwvs.contains("double[]"))
							|| (vwvs.contains("boolean[]")) || (vwvs.contains("char[]"))) {
						
						Li_Count = Li_Count + 1;
					}
				}
			}
			scanner3.close();
			int c = Li_Count;
			
			int rv = c * (a+b);
			return rv;
		}
}
