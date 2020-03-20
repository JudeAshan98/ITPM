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
	List <Integer> ValueList = new ArrayList<Integer>();
	CsReader csReader = new CsReader();
		
	public int getLi_WtVal() {
		
		return Li_WtVal;
	}

	public void setLi_WtVal(int li_WtVal) {
		ValueList = csReader.GetAllcsValues();
		Li_WtVal= ValueList.get(0);
		Li_WtVal = li_WtVal;
	}

	public int getLi_ncVal() {
		return Li_ncVal;
	}

	public void setLi_ncVal(int li_ncVal) {
		ValueList = csReader.GetAllcsValues();
		Li_WtVal = ValueList.get(1);
		Li_ncVal = li_ncVal;
	}

	public int getLi_ccpVal() {
		ValueList = csReader.GetAllcsValues();
		Li_WtVal= ValueList.get(2);
		return Li_ccpVal;
	}

	public void setLi_ccpVal(int li_ccpVal) {
		Li_ccpVal = li_ccpVal;
	}

	public int CtrlWeight(String CodeLine) {
		Scanner scanner = new Scanner(CodeLine);
		int Li_Wtcs = 0;
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if (token1.contains("if")){
				Li_Wtcs = Li_Wtcs + getLi_ccpVal() ;
			}
		}
		
		scanner.close();
		return Li_Wtcs;

	}

	public int NofConditions(String CodeLine) {
		int Li_NC = 0;

		return Li_NC;

	}

	public int previousComplex(String CodeLine) {
		int Li_Ccspps = 0;

		return Li_Ccspps;

	}
}
