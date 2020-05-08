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

	String token1 = "";
	int sum, a, b, c;
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

	// Logic.

	// -------------------------------------------------------------------------------------------------------------------
	// WMRT Done
	public int FindWmrt(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

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
				Li_Count = Li_Count + 1;

				if (scanner.hasNext()) {
					token1 = scanner.next();
				}

				if (token1.endsWith("()")) {
					Li_Count = Li_Count + 1;
				}
			}
		} else if (extention.equals("cpp")) {

		}

		scanner.close();
		return a = Li_Count;

	}

	// -------------------------------------------------------------------------------------------------------------------
	// NPDTP Done
	public int FindNpdtp(String CodeLine, String extention) {
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

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
					Li_Count = Li_Count + 1;
				}
			}
		} else if (extention.equals("cpp")) {

		}

		scanner.close();
		return b = Li_Count;
	}

	// -------------------------------------------------------------------------------------------------------------------
	// NCDTP Done
	public int FindNcdtp(String CodeLine, String extention) {

		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

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
					Li_Count = Li_Count + 1;
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
						Li_Count = Li_Count + 1;
					}
				}
			}
		} else if (extention.equals("cpp")) {

		}

		scanner.close();
		return c = Li_Count;

	}

	// -------------------------------------------------------------------------------------------------------------------
	// CM Done
	public int FindCm(String CodeLine) {
		return sum = a + (b * 1) + (c * 2);
	}
}
