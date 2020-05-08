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
	int CS;

	String token1 = "";
	int sum, a, b, c, d, e, f;
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

	public int getCS() {
		return CS;
	}

	public void setCS(int cS) {
		ValueList = sizereader.GetAllcsValues();
		CS = ValueList.get(5);
	}

	// Logic.

	// NKW Done
	// ---------------------------------------------------------------------------------------------------------------------
	public int FindNkw(String CodeLine, String extention) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			String pattern1 = "//.*";
			String pattern2 = "System.*";

			if (scanner.hasNext(pattern1) || scanner.hasNext(pattern2)) {
				scanner.close();
				a = 0;
				return 0;
			}

			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.equals("Scanner")) {
					scanner.close();
					a = 0;
					return 0;
				}

				if ((token1.contains("abstract")) || (token1.contains("assert")) || (token1.contains("break"))
						|| (token1.contains("catch")) || (token1.contains("class")) || (token1.contains("const"))
						|| (token1.contains("continue")) || (token1.contains("default")) || (token1.contains("else"))
						|| (token1.contains("enum")) || (token1.contains("extends")) || (token1.contains("final"))
						|| (token1.contains("finally")) || (token1.contains("goto")) || (token1.contains("implements"))
						|| (token1.contains("instanceof")) || (token1.contains("interface"))
						|| (token1.contains("native")) || (token1.contains("new")) || (token1.contains("package"))
						|| (token1.contains("private")) || (token1.contains("protected")) || (token1.contains("public"))
						|| (token1.contains("return")) || (token1.contains("short")) || (token1.contains("static"))
						|| (token1.contains("strictfp")) || (token1.contains("super"))
						|| (token1.contains("synchronized")) || (token1.contains("this")) || (token1.contains("throw"))
						|| (token1.contains("throws")) || (token1.contains("transient")) || (token1.contains("try"))
						|| (token1.contains("void")) || (token1.contains("volatile")) || (token1.contains("true"))
						|| (token1.contains("false")) || (token1.contains("null"))) {

//					if ((!token1.contains("System.out.print")) && (!token1.contains("System.out.println"))
//							&& (!token1.contains("System.err.print")) && (!token1.contains("System.err.println"))) {
					Li_Count = Li_Count + 1;
//					}
				}

				if (scanner.hasNext(pattern1)) {
					scanner.close();
					return a = Li_Count;
				}
			}
		} else if (extention.equals("cpp")) {
			token1 = "";
			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.equals("//")) {
					break;
				}

				if ((token1.contains("asm")) || (token1.contains("else")) || (token1.contains("new"))
						|| (token1.contains("this")) || (token1.contains("auto")) || (token1.contains("enum"))
						|| (token1.contains("operator")) || (token1.contains("throw")) || (token1.contains("bool"))
						|| (token1.contains("explicit")) || (token1.contains("private")) || (token1.contains("true"))
						|| (token1.contains("break")) || (token1.contains("export")) || (token1.contains("protected"))
						|| (token1.contains("try")) || (token1.contains("case")) || (token1.contains("extern"))
						|| (token1.contains("public")) || (token1.contains("typedef")) || (token1.contains("catch"))
						|| (token1.contains("false")) || (token1.contains("register")) || (token1.contains("typeid"))
						|| (token1.contains("reinterpret_cast")) || (token1.contains("typename"))
						|| (token1.contains("class")) || (token1.contains("for")) || (token1.contains("return"))
						|| (token1.contains("union")) || (token1.contains("const")) || (token1.contains("friend"))
						|| (token1.contains("unsigned")) || (token1.contains("const_cast")) || (token1.contains("goto"))
						|| (token1.contains("signed")) || (token1.contains("using")) || (token1.contains("continue"))
						|| (token1.contains("if")) || (token1.contains("sizeof")) || (token1.contains("virtual"))
						|| (token1.contains("default")) || (token1.contains("inline")) || (token1.contains("static"))
						|| (token1.contains("void")) || (token1.contains("delete")) || (token1.contains("static_cast"))
						|| (token1.contains("volatile")) || (token1.contains("do")) || (token1.contains("long"))
						|| (token1.contains("struct")) || (token1.contains("wchar_t")) || (token1.contains("mutable"))
						|| (token1.contains("switch")) || (token1.contains("while"))
						|| (token1.contains("dynamic_cast")) || (token1.contains("namespace"))
						|| (token1.contains("template"))) {

					Li_Count = Li_Count + 1;
				}
			}
		}
		scanner.close();
		return a = Li_Count;
	}

	// NID Done
	// ---------------------------------------------------------------------------------------------------------------------
	public int FindNid(String CodeLine, String extention) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			String pattern = "//.*";
			String pattern1 = "System.*";
			String pattern2 = "java..*";
			String pattern3 = "import.*";

			if (scanner.hasNext(pattern) || scanner.hasNext(pattern3)) {
				scanner.close();
				b = 0;
				return 0;
			}
			if (scanner.hasNext(pattern1)) {
				Li_Count = Li_Count + 3;
				scanner.close();

				return b = Li_Count;
			}
			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.endsWith("()") || token1.contains("year;") || token1.contains("month;")) {
					Li_Count = Li_Count + 1;
				}
				if (token1.equals("int") || token1.equals("float") || token1.equals("String")) {
					String word = "";
					word = scanner.next();
					while (word.endsWith(",")) {
						Li_Count = Li_Count + 1;
						word = scanner.next();
					}
					if (word.endsWith(";")) {
						Li_Count = Li_Count + 1;
						scanner.close();
						return b = Li_Count;
					} else {
						Li_Count = Li_Count + 1;
					}
				}

				if (scanner.hasNext(pattern2)) {
					Li_Count = Li_Count + 2;
				} else if ((!token1.contains("Scanner")) && (!token1.contains("abstract"))
						&& (!token1.contains("assert")) && (!token1.contains("boolean")) && (!token1.contains("break"))
						&& (!token1.contains("byte")) && (!token1.contains("case")) && (!token1.contains("void"))
						&& (!token1.contains("catch")) && (!token1.contains("char")) && (!token1.contains("class"))
						&& (!token1.contains("const")) && (!token1.contains("continue"))
						&& (!token1.contains("default")) && (!token1.contains("do")) && (!token1.contains("double"))
						&& (!token1.contains("else")) && (!token1.contains("enum")) && (!token1.contains("extends"))
						&& (!token1.contains("final")) && (!token1.contains("finally")) && (!token1.contains("goto"))
						&& (!token1.contains("if")) && (!token1.contains("implements")) && (!token1.contains("import"))
						&& (!token1.contains("instanceof")) && (!token1.contains("float")) && (!token1.contains("for"))
						&& (!token1.contains("int")) && (!token1.contains("long")) && (!token1.contains("interface"))
						&& (!token1.contains("native")) && (!token1.contains("new")) && (!token1.contains("package"))
						&& (!token1.contains("private")) && (!token1.contains("protected"))
						&& (!token1.contains("public")) && (!token1.contains("return")) && (!token1.contains("short"))
						&& (!token1.contains("static")) && (!token1.contains("strictfp")) && (!token1.contains("super"))
						&& (!token1.contains("switch")) && (!token1.contains("synchronized"))
						&& (!token1.contains("this")) && (!token1.contains("throw")) && (!token1.contains("throws"))
						&& (!token1.contains("transient")) && (!token1.contains("try"))
						&& (!token1.contains("volatile")) && (!token1.contains("while")) && (!token1.contains("true"))
						&& (!token1.contains("false")) && (!token1.contains("null")) && (!token1.contains("+"))
						&& (!token1.contains("-")) && (!token1.contains("*")) && (!token1.contains("/"))
						&& (!token1.contains("%")) && (!token1.contains("++")) && (!token1.contains("--"))
						&& (!token1.contains("==")) && (!token1.contains("!=")) && (!token1.contains(">"))
						&& (!token1.contains("<")) && (!token1.contains(">=")) && (!token1.contains("<="))
						&& (!token1.contains(");")) && (!token1.contains("_")) && (!token1.contains("&&"))
						&& (!token1.contains("||")) && (!token1.contains("!")) && (!token1.contains(";"))
						&& (!token1.contains(":")) && (!token1.contains("|")) && (!token1.contains("^"))
						&& (!token1.contains("~")) && (!token1.contains(">>")) && (!token1.contains("<<"))
						&& (!token1.contains(">>>")) && (!token1.contains("<<<")) && (!token1.contains(","))
						&& (!token1.contains("_>")) && (!token1.contains("::")) && (!token1.contains(")"))
						&& (!token1.contains("(")) && (!token1.contains("}")) && (!token1.contains("{"))
						&& (!token1.contains("[")) && (!token1.contains("]")) && (!token1.contains("[]"))
						&& (!token1.contains("+=")) && (!token1.contains("-=")) && (!token1.contains("*="))
						&& (!token1.contains("/=")) && (!token1.contains("=")) && (!token1.contains(">>>="))
						&& (!token1.contains("|=")) && (!token1.contains("&=")) && (!token1.contains("%="))
						&& (!token1.contains("<<=")) && (!token1.contains(">>=")) && (!token1.contains("^="))
						&& (!token1.contains("[0-9'@//]+")) && (!token1.matches(".*\\d.*")) && (!token1.contains("()"))
						&& (!token1.contains("{}"))) {

					if ((!token1.contains("\"")) || (token1.contains("getSize().width"))
							|| (token1.contains("getSize().height"))) {
						Li_Count = Li_Count + 1;
					}

				} else {
					int saasa = 0;
				}
				if (scanner.hasNext(pattern)) {
					scanner.close();
					return b = Li_Count;
				}
				if ((token1.contains("sc.next();")) || token1.contains("Integer.parseInt(enteredYear);")
						|| token1.contains("Integer.parseInt(enteredMonthNumber);")) {
					Li_Count = Li_Count + 2;
				}
			}
		} else if (extention.equals("cpp")) {
			// c++
		}

		scanner.close();
		return b = Li_Count;
	}

	// NOP Done
	// ---------------------------------------------------------------------------------------------------------------------
	public int FindNop(String CodeLine, String extention) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			String pattern = "//.*";
			String pattern1 = "System.*";
			String pattern2 = "import.*";
			if (scanner.hasNext(pattern) || scanner.hasNext(pattern2)) {
				scanner.close();
				c = 0;
				return 0;
			}
			if (scanner.hasNext(pattern1)) {
				Li_Count = Li_Count + 2;
			}

			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.equals("//")) {
					break;
				}

				if (((!token1.contains("System.out.print")) || (!token1.contains("System.out.println"))
						|| (!token1.contains(" ")))
						&& ((token1.contains("+")) || (token1.contains("-")) || (token1.contains("*"))
								|| (token1.contains("/")) || (token1.contains("%")) || (token1.contains("++"))
								|| (token1.contains("--")) || (token1.contains("==")) || (token1.contains("!="))
								|| (token1.contains(">")) || (token1.contains("<")) || (token1.contains(">="))
								|| (token1.contains("<=")) || (token1.contains("&&")) || (token1.contains("||"))
								|| (token1.contains("!")) || (token1.contains("|")) || (token1.contains("^"))
								|| (token1.contains("~")) || (token1.contains(">>")) || (token1.contains("<<"))
								|| (token1.contains(">>>")) || (token1.contains("<<<")) || (token1.contains(","))
								|| (token1.contains("_>")) || (token1.contains("::")) || (token1.contains("+="))
								|| (token1.contains("-=")) || (token1.contains("*=")) || (token1.contains("/="))
								|| (token1.contains("=")) || (token1.contains(">>>=")) || (token1.contains("|="))
								|| (token1.contains("&=")) || (token1.contains("%=")) || (token1.contains("<<="))
								|| (token1.contains(">>=")) || (token1.contains("^=")))) {

					Li_Count = Li_Count + 1;
				}
				if (scanner.hasNext(pattern)) {
					scanner.close();
					return c = Li_Count;
				}
			}
		} else if (extention.equals("cpp")) {
			token1 = "";
			
			while (scanner.hasNext()) {
				token1 = scanner.next();

				if(token1.equals("#include")) {
					scanner.close();
					return c = 0;
				}
				
				if (token1.equals("//")) {
					break;
				}

				if ((token1.contains("+")) || (token1.contains("-")) || (token1.equals("*")) || (token1.equals("/"))
						|| (token1.contains("%")) || (token1.contains("++")) || (token1.contains("--"))
						|| (token1.contains("=")) || (token1.contains("+=")) || (token1.contains("-="))
						|| (token1.contains("*=")) || (token1.contains("/=")) || (token1.contains("%="))
						|| (token1.contains("==")) || (token1.contains("!=")) || (token1.contains(">"))
						|| (token1.contains("<")) || (token1.contains(">=")) || (token1.contains("<="))
						|| (token1.contains("&&")) || (token1.equals("||")) || (token1.contains("!"))
						|| (token1.contains("&")) || (token1.contains("|")) || (token1.contains("^"))
						|| (token1.contains("~")) || (token1.contains("<<")) || (token1.contains(">>"))) {

					Li_Count = Li_Count + 1;
				}
			}
		}

		scanner.close();
		return c = Li_Count;
	}

	// NNV Done
	// ---------------------------------------------------------------------------------------------------------------------
	public int FindNnv(String CodeLine, String extention) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			String pattern = "//.*";

			if (scanner.hasNext(pattern)) {
				scanner.close();
				d = 0;
				return 0;
			}

			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.contains("case")) {
					Li_Count = Li_Count + 1;
				}

				boolean numeric = true;

				try {
					Double num;
					num = Double.parseDouble(token1);
				} catch (NumberFormatException e) {
					numeric = false;
				}

				if (numeric) {
					Li_Count = Li_Count + 1;
				}
				if (scanner.hasNext(pattern)) {
					scanner.close();
					return d = Li_Count;
				}
			}
		} else if (extention.equals("cpp")) {
			// c++
		}

		scanner.close();
		return d = Li_Count;
	}

	// NSL Done
	// ---------------------------------------------------------------------------------------------------------------------
	public int FindNsl(String CodeLine, String extention) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			String pattern = "//.*";
			if (scanner.hasNext(pattern)) {
				scanner.close();
				e = 0;
				return 0;
			}

			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.equals("//")) {
					break;
				}

				if ((token1.contains("\""))) {
					Li_Count = Li_Count + 1;
				}
				if (scanner.hasNext(pattern)) {
					scanner.close();
					return e = Li_Count;
				}
			}

		} else if (extention.equals("cpp")) {
			// C++ Code
		}

		scanner.close();
		return e = (Li_Count / 2);

	}

	// CS Done
	public int FindCs(String CodeLine) {

		return sum = a + b + c + d + e;
	}
}
