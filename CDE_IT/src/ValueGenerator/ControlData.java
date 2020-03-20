package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import xmlReader.CsReader;

public class ControlData {

	String Result;
	String token1 = "\n";
	private int Li_WtVal;
	private int Li_ncVal;
	private int Li_ccpVal;
	private int Li_case;
	List<Integer> ValueList = new ArrayList<Integer>();
	CsReader csReader = new CsReader();
	String previousLine = null;

	public int getLi_WtVal() {
		return Li_WtVal;
	}

	public void setLi_WtVal(int li_WtVal) {
		ValueList = csReader.GetAllcsValues();
		Li_WtVal = ValueList.get(0);
	}

	public int getLi_ncVal() {
		return Li_ncVal;
	}

	public void setLi_ncVal(int li_ncVal) {
		ValueList = csReader.GetAllcsValues();
		Li_ncVal = ValueList.get(1);
	}

	public int getLi_ccpVal() {
		return Li_ccpVal;
	}

	public void setLi_ccpVal(int li_ccpVal) {
		ValueList = csReader.GetAllcsValues();
		Li_ccpVal = ValueList.get(2);
	}

	public int getLi_case() {
		return Li_case;
	}

	public void setLi_case(int li_case) {
		ValueList = csReader.GetAllcsValues();
		Li_case = ValueList.get(3);
	}

	public int CtrlWeight(String CodeLine) {
		Scanner scanner = new Scanner(CodeLine);
		int Li_Wtcs = 0;
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if (token1.contains("if") || token1.contains("else")) {
				setLi_WtVal(Li_WtVal);
				Li_Wtcs = Li_Wtcs + getLi_WtVal();
			} else if (token1.contains("for") || token1.contains("while") || token1.contains("do")) {
				setLi_ncVal(Li_ncVal);
				Li_Wtcs = Li_Wtcs + getLi_ncVal();
			} else if ((token1.contains("switch"))) {
				setLi_ccpVal(Li_ccpVal);
				Li_Wtcs = Li_Wtcs + getLi_ccpVal();
			} else if ((token1.contains("case"))) {
				setLi_case(Li_case);
				Li_Wtcs = Li_Wtcs + getLi_case();
			}
		}

		scanner.close();
		return Li_Wtcs;

	}

	public int NofConditions(String CodeLine) {
		Scanner scanner = new Scanner(CodeLine);
		int Li_Count = 0;
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

	public int previousComplex(String CodeLine) {
		int Li_Ccspps = 0;
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains("if") || line.contains("for") || line.contains("while") || line.contains("while")
					|| line.contains("do") || line.contains("switch") || line.contains("case")) {
				if (previousLine.contains("if") || previousLine.contains("for") || previousLine.contains("while")
						|| previousLine.contains("while") || previousLine.contains("do")
						|| previousLine.contains("switch") || previousLine.contains("case")) {

					Li_Ccspps = Li_Ccspps + 2;
				}
			}
			previousLine = line;
		}
		scanner.close();
		return Li_Ccspps;

	}
}
