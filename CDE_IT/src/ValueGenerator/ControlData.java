package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import sun.jvm.hotspot.oops.Array;
import xmlReader.CsReader;

public class ControlData {

//	Declaring variables
	String Result;
	String token1 = "\n";
	private int Li_WtVal;
	private int Li_ncVal;
	private int Li_ccpVal;
	private int Li_case;

	ArrayList<Integer> Open = new ArrayList<Integer>();
	ArrayList<Integer> Close = new ArrayList<Integer>();
	ArrayList<Integer> ccsList = new ArrayList<Integer>();
	int Li_ccs = 0;
	int case_count = 0;

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

	//find Weight due to control structure type 
	public int CtrlWeight(String CodeLine) {
		Scanner scanner = new Scanner(CodeLine);
		int Li_Wtcs = 0;
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if (token1.contains("//")) {
				return Li_Wtcs;
			}
			if (token1.contains("if")) {
				setLi_WtVal(Li_WtVal);
				Li_Wtcs = Li_Wtcs + getLi_WtVal();
			} else if (token1.equals("for") || token1.equals("while") || token1.equals("do")) {
				setLi_ncVal(Li_ncVal);
				Li_Wtcs = Li_Wtcs + getLi_ncVal();
			} else if ((token1.equals("switch"))) {
				setLi_ccpVal(Li_ccpVal);
				Li_Wtcs = Li_Wtcs + getLi_ccpVal();
			} else if ((token1.equals("case"))) {
				setLi_case(Li_case);
				Li_Wtcs = Li_Wtcs + getLi_case();
			}
		}

		scanner.close();
		return Li_Wtcs;

	}

//	find Number of conditions
	public int NofConditions(String CodeLine) {
		Scanner scanner = new Scanner(CodeLine);
		int Li_Count = 0;
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if (token1.contains("//")) {
				return Li_Count;
			}
			if ((token1.equals("if")) || (token1.contains("if(")) || (token1.equals("for")) || (token1.equals("while"))
					|| (token1.equals("while")) || (token1.equals("do")) || (token1.equals("switch"))
					|| (token1.equals("case")) || (token1.equals("&&")) || (token1.equals("||"))) {
				Li_Count = Li_Count + 1;
			}
		}

		scanner.close();
		return Li_Count;

	}

//	find Control structure complexity of the previous program statement
	public int previousComplex(String CodeLine, int ccs) {
		int Li_Ccspps = 0;
		if (ccs == 0 && (ccsList != null && !ccsList.isEmpty())) {
			ccs = ccsList.get(ccsList.size() - 1);
		} else if (ccs == 0 && (ccsList == null && ccsList.isEmpty())) {
			ccs = ccs;
		}
		if (ccsList != null && !ccsList.isEmpty()) {
			Li_ccs = ccsList.get(ccsList.size() - 1);
		}
		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains("case")) {
				ccsList.add(ccs);
				if (ccsList.get(ccsList.size() - 1) == ccsList.get(ccsList.size() - 2)) {
					ccsList.remove(ccsList.size() - 1);
				}
				Li_ccs = ccsList.get(ccsList.size() - 1);
				Li_Ccspps = Li_Ccspps + Li_ccs;
				return Li_Ccspps;
			}

			if (line.contains("if") || line.contains("for") || line.contains("while") || line.contains("while")
					|| line.contains("do") || line.contains("switch")) {

				ccsList.add(ccs);
				Li_ccs = ccsList.get(ccsList.size() - 1);

				Li_Ccspps = Li_Ccspps + Li_ccs;

			}
			if (ccsList != null && !ccsList.isEmpty()) {
				if (line.contains("}")) {
					ccsList.remove(ccsList.size() - 1);
				}
			}
		}
		scanner.close();
		return Li_Ccspps;

	}
}
