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
	
	int a = 0;
	int b = 0;
	int c = 0;
	
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
				
				if((token1.contains("for")) || (token1.contains("while"))) {
					a = 0;
					return 0;
				}
				if((token1.contains("byte")) || (token1.contains("short")) || (token1.contains("int"))
						|| (token1.contains("long")) || (token1.contains("float")) || (token1.contains("double"))
						|| (token1.contains("boolean")) || (token1.contains("char")) || (token1.contains("byte[]")) || (token1.contains("short[]")) || (token1.contains("int[]"))
						|| (token1.contains("long[]")) || (token1.contains("float[]")) || (token1.contains("double[]"))
						|| (token1.contains("boolean[]")) || (token1.contains("char[]"))) {
						
					if((!token1.contains("System.out.print")) && (!token1.contains("System.out.println"))) {
						Li_Count = Li_Count + 1;
					}	
				}
			}
		
			scanner.close();
			a = Li_Count;
			return Li_Count;
		}
		
		//NPDTV Done
		public int FindNpdtv(String CodeLine) {
			int Li_Count = 0;
			Scanner scanner = new Scanner(CodeLine);
			while (scanner.hasNext()) {
				token1 = scanner.next();
				
				if((token1.contains("for")) || (token1.contains("while")) || (token1.contains("System.out.println")) || (token1.contains("System.out.print"))) {
					b = 0;
					return 0;
				}
				
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
			b = Li_Count;
			return Li_Count;
		}
		
		//NCDTV Done
		public int FindNcdtv(String CodeLine) {
			int Li_Count = 0;
			Scanner scanner = new Scanner(CodeLine);
			while (scanner.hasNext()) {
				token1 = scanner.next();
				
				if((token1.contains("for")) || (token1.contains("while")) || (token1.contains("System.out.println")) || (token1.contains("System.out.print"))) {
					c = 0;
					return 0;
				}
				
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
			c = Li_Count;
			return Li_Count;
		}
		
		//CV Done
		public int FindCv(String CodeLine) {			
			int rv = (a * b) + (a * c);
			return rv;
		}
}
