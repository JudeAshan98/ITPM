package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xmlReader.MethodReader;

public class MethodData {
	// declare the variables
	int Wmrt;
	int Npdtp;
	int Ncdtp;
	int Cm;

	String token1 = "";
	int sum, a, b, c;

	// List for get values
	List<Integer> ValueList = new ArrayList<Integer>();

	// Reader for get weight
	MethodReader methodreader = new MethodReader();
	String previousLine = null;
	
	// Getters and setters
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

	// Logic Part

	// -------------------------------------------------------------------------------------------------------------------
	// WMRT - Weight due to method return type
	// -------------------------------------------------------------------------------------------------------------------
	public int FindWmrt(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		setWmrt(Wmrt);

		if (extention.equals("java")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (!token1.contains("public")) {
					Li_Count = 0;

					scanner.close();
					return a = Li_Count;
				}

			}
			if (scanner.hasNext()) {
				token1 = scanner.next();
			}

			if ((token1.contains("int")) || (token1.contains("long")) || (token1.contains("double"))
					|| (token1.contains("float")) || (token1.contains("boolean")) || (token1.contains("char"))
					|| (token1.contains("arrays")) || (token1.contains("objects")) || (token1.contains("records"))
					|| (token1.contains("interfaces")) || (token1.contains("lists")) || (token1.contains("String"))) {
				Li_Count = Li_Count + getWmrt();

				if (scanner.hasNext()) {
					token1 = scanner.next();
				}

				if (token1.endsWith("()")) {
					Li_Count = Li_Count + getWmrt();
				}
			}
		} else if (extention.equals("cpp")) {
			token1 = "";
			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
					scanner.close();
					return a = 0;
				}

				if ((token1.contains("int")) || (token1.contains("long")) || (token1.contains("double"))
						|| (token1.contains("float")) || (token1.contains("boolean")) || (token1.contains("char"))
						|| (token1.contains("arrays")) || (token1.contains("objects")) || (token1.contains("records"))
						|| (token1.contains("interfaces")) || (token1.contains("lists"))
						|| (token1.contains("String"))) {

					if (scanner.hasNext()) {
						token1 = scanner.next();
					}

					if (token1.endsWith("()")) {
						Li_Count = Li_Count + getWmrt();
					} else if (token1.endsWith("(")) {
						Li_Count = Li_Count + getWmrt();
					} else {
						scanner.close();
						return a = 0;
					}
				}
			}
		}

		scanner.close();
		return a = Li_Count;

	}

	// -------------------------------------------------------------------------------------------------------------------
	// NPDTP - Number of primitive data type parameters
	// -------------------------------------------------------------------------------------------------------------------
	public int FindNpdtp(String CodeLine, String extention) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		setNpdtp(Npdtp);

		if (extention.equals("java")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (!token1.contains("public")) {
					Li_Count = 0;

					scanner.close();
					return b = Li_Count;
				}

			}
			if (scanner.hasNext()) {
				token1 = scanner.next();
			}

			if ((token1.contains("int"))) {

				if (scanner.hasNext()) {
					token1 = scanner.next();
				}

				if (!token1.endsWith("()")) {
					Li_Count = Li_Count + getNpdtp();
				}
			}
		} else if (extention.equals("cpp")) {
			token1 = "";
			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")
						|| token1.startsWith("public")) {
					scanner.close();
					return b = 0;
				}

				if ((token1.contains("int")) || (token1.contains("float")) || (token1.contains("bool"))
						|| (token1.contains("char")) || (token1.contains("double")) || (token1.contains("void"))
						|| (token1.contains("wchar_t"))) {

					if (scanner.hasNext()) {
						token1 = scanner.next();
					}

					if (token1.endsWith("()")) {
						Li_Count = Li_Count + getNpdtp();
					} else if (token1.endsWith("(")) {
						Li_Count = Li_Count + getNpdtp();
					} else {
						scanner.close();
						return b = 0;
					}
				}
			}
		}

		scanner.close();
		return b = Li_Count;
	}

	// -------------------------------------------------------------------------------------------------------------------
	// NCDTP - Number of composite data type parameters
	// -------------------------------------------------------------------------------------------------------------------
	public int FindNcdtp(String CodeLine, String extention) {

		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		setNcdtp(Ncdtp);

		if (extention.equals("java")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (!token1.contains("public")) {
					Li_Count = 0;

					scanner.close();
					return c = Li_Count;
				}

			}
			if (scanner.hasNext()) {
				token1 = scanner.next();
			}

			if ((token1.contains("void"))) {

				if (scanner.hasNext()) {
					token1 = scanner.next();
				}

				if (!token1.endsWith("()")) {
					Li_Count = Li_Count + getNcdtp();
				}
			}

			if (token1.contains("static")) {
				if (scanner.hasNext()) {
					token1 = scanner.next();
				}
				if ((token1.contains("void"))) {

					if (scanner.hasNext()) {
						token1 = scanner.next();
					}

					if (!token1.endsWith("()")) {
						Li_Count = Li_Count + getNcdtp();
					}
				}
			}
		} else if (extention.equals("cpp")) {
			token1 = "";
			while (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
					scanner.close();
					return c = 0;
				}

				if ((token1.equals("int[]")) || (token1.equals("float[]")) || (token1.equals("bool[]"))
						|| (token1.equals("char[]")) || (token1.equals("double[]")) || (token1.equals("void[]"))
						|| (token1.equals("wchar_t[]"))) {

					if (scanner.hasNext()) {
						token1 = scanner.next();
					}

					if (token1.endsWith("()")) {
						Li_Count = Li_Count + getNcdtp();
					} else if (token1.endsWith("(")) {
						Li_Count = Li_Count + getNcdtp();
					} else {
						scanner.close();
						return c = 0;
					}
				}
			}
		}

		scanner.close();
		return c = Li_Count;

	}

	// -------------------------------------------------------------------------------------------------------------------
	// CM - Complexity of a line which includes a method signature
	// -------------------------------------------------------------------------------------------------------------------
	public int FindCm(String CodeLine) {
		return sum = a + (b * 1) + (c * 2);
	}
}
