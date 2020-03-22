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
	
	//NKW Done
	public int FindNkw(String CodeLine) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if ((token1.contains("abstract")) || (token1.contains("assert")) || (token1.contains("boolean")) || (token1.contains("break")) || (token1.contains("byte")) || (token1.contains("case")) || (token1.contains("catch")) || (token1.contains("char")) || (token1.contains("class")) ||
					(token1.contains("const")) || (token1.contains("continue")) || (token1.contains("default")) || (token1.contains("do")) || (token1.contains("double")) || (token1.contains("else")) || (token1.contains("enum")) || (token1.contains("extends")) || (token1.contains("final")) ||
					(token1.contains("finally")) || (token1.contains("goto")) || (token1.contains("if")) || (token1.contains("implements")) || (token1.contains("import")) || (token1.contains("instanceof")) ||  (token1.contains("float")) ||  (token1.contains("for")) ||  (token1.contains("int")) ||  (token1.contains("long")) ||
					(token1.contains("interface")) || (token1.contains("native")) || (token1.contains("new")) || (token1.contains("package")) || (token1.contains("private")) || (token1.contains("protected")) || (token1.contains("public")) || (token1.contains("return")) ||
					(token1.contains("short")) || (token1.contains("static")) || (token1.contains("strictfp")) || (token1.contains("super")) || (token1.contains("switch")) || (token1.contains("synchronized")) || (token1.contains("this")) || (token1.contains("throw")) || (token1.contains("throws")) ||
					(token1.contains("transient")) || (token1.contains("try")) || (token1.contains("void")) || (token1.contains("volatile")) || (token1.contains("while")) || (token1.contains("true")) || (token1.contains("false")) || (token1.contains("null"))) {
				
				Li_Count = Li_Count + 1;
			}
		}
		scanner.close();	
		return Li_Count;
	}
	
	//NID Done
	public int FindNid(String CodeLine) {
		int Li_Count = 0;
		
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) { 
			token1 = scanner.next(); 
			if ((!token1.contains("abstract")) && (!token1.contains("assert")) && (!token1.contains("boolean")) && (!token1.contains("break")) && (!token1.contains("byte")) && (!token1.contains("case")) && (!token1.contains("catch")) && (!token1.contains("char")) && (!token1.contains("class")) && 
					(!token1.contains("const")) && (!token1.contains("continue")) && (!token1.contains("default")) && (!token1.contains("do")) && (!token1.contains("double")) && (!token1.contains("else")) && (!token1.contains("enum")) && (!token1.contains("extends")) && (!token1.contains("final")) &&
					(!token1.contains("finally")) && (!token1.contains("goto")) && (!token1.contains("if")) && (!token1.contains("implements")) && (!token1.contains("import")) && (!token1.contains("instanceof")) &&  (!token1.contains("float")) && (!token1.contains("for")) && (!token1.contains("int")) && (!token1.contains("long")) &&
					(!token1.contains("interface")) && (!token1.contains("native")) && (!token1.contains("new")) && (!token1.contains("package")) && (!token1.contains("private")) && (!token1.contains("protected")) && (!token1.contains("public")) && (!token1.contains("return")) &&
					(!token1.contains("short")) && (!token1.contains("static")) && (!token1.contains("strictfp")) && (!token1.contains("super")) && (!token1.contains("switch")) && (!token1.contains("synchronized")) && (!token1.contains("this")) && (!token1.contains("throw")) && (!token1.contains("throws")) &&
					(!token1.contains("transient")) && (!token1.contains("try")) && (!token1.contains("void")) && (!token1.contains("volatile")) && (!token1.contains("while")) && (!token1.contains("true")) && (!token1.contains("false")) && (!token1.contains("null")) &&
					(!token1.contains("+")) && (!token1.contains("-")) && (!token1.contains("*")) && (!token1.contains("/")) && (!token1.contains("%")) && (!token1.contains("++")) && (!token1.contains("--")) &&
					(!token1.contains("==")) && (!token1.contains("!=")) && (!token1.contains(">")) && (!token1.contains("<")) && (!token1.contains(">=")) && (!token1.contains("<=")) && (!token1.contains(");")) && (!token1.contains("_")) &&
					(!token1.contains("&&")) && (!token1.contains("||")) && (!token1.contains("!")) && (!token1.contains(";")) && (!token1.contains(":")) && (!token1.contains("System.out.print")) && (!token1.contains("System.out.println")) &&
					(!token1.contains("|")) && (!token1.contains("^")) && (!token1.contains("~")) && (!token1.contains(">>")) && (!token1.contains("<<")) && (!token1.contains(">>>")) && (!token1.contains("<<<")) &&
					(!token1.contains(",")) && (!token1.contains("_>")) && (!token1.contains("::")) && (!token1.contains(")")) && (!token1.contains("(")) && (!token1.contains("}")) && (!token1.contains("{")) && (!token1.contains("[")) && (!token1.contains("]")) && (!token1.contains("[]")) &&
					(!token1.contains("+=")) && (!token1.contains("-=")) && (!token1.contains("*=")) && (!token1.contains("/=")) && (!token1.contains("=")) && (!token1.contains(">>>=")) && (!token1.contains("|=")) &&(!token1.contains("&=")) && (!token1.contains("%=")) && (!token1.contains("<<=")) &&
					(!token1.contains(">>=")) && (!token1.contains("^=")) && (!token1.contains("[0-9'@//]+")) && (!token1.matches(".*\\d.*"))) {
				
					Li_Count = Li_Count + 1;
			}
			
		}
		scanner.close();	
		return Li_Count;
	}
	
	//NOP Done
	public int FindNop(String CodeLine) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if (((!token1.contains("System.out.print")) || (!token1.contains("System.out.println")) || (!token1.contains(" "))) &&
					((token1.contains("+")) || (token1.contains("-")) || (token1.contains("*")) || (token1.contains("/")) || (token1.contains("%")) || (token1.contains("++")) || (token1.contains("--")) ||
					(token1.contains("==")) || (token1.contains("!=")) || (token1.contains(">")) || (token1.contains("<")) || (token1.contains(">=")) || (token1.contains("<=")) ||
					(token1.contains("&&")) || (token1.contains("||")) || (token1.contains("!")) ||
					(token1.contains("|")) || (token1.contains("^")) || (token1.contains("~")) || (token1.contains(">>")) || (token1.contains("<<")) || (token1.contains(">>>")) || (token1.contains("<<<")) ||
					(token1.contains(",")) || (token1.contains("_>")) || (token1.contains("::")) ||
					(token1.contains("+=")) ||(token1.contains("-=")) ||(token1.contains("*=")) ||(token1.contains("/=")) ||(token1.contains("=")) ||(token1.contains(">>>=")) ||(token1.contains("|=")) ||(token1.contains("&=")) ||(token1.contains("%=")) ||(token1.contains("<<=")) ||(token1.contains(">>=")) ||(token1.contains("^=")))) {
				Li_Count = Li_Count + 1;
			}
		}
		scanner.close();	
		return Li_Count;
	}
	
	//NNV Done
	public int FindNnv(String CodeLine) {
		int Li_Count = 0;
    	
        Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			boolean numeric = true;
			
			try {
	            Double num;
				num = Double.parseDouble(token1);
	        } catch (NumberFormatException e) {
	            numeric = false;
	        }

	        if(numeric) {
	        	Li_Count = Li_Count + 1;
	        }       
		}
		scanner.close();	
		return Li_Count;
	}
	
	//NSL Done
	public int FindNsl(String CodeLine) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if ((token1.equals("int")) || (token1.equals("char")) || (token1.equals("varchar")) || (token1.equals("double")) || (token1.equals("float")) || (token1.equals("String"))) {
				Li_Count = Li_Count + 1;
			}
		}
		scanner.close();	
		return Li_Count;
	}
}
