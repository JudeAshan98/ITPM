import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControlData {
	
	String Result;
	String token1 = "\n";
	

	public int CtrlWeight(String CodeLine) {
		Scanner scanner = new Scanner(CodeLine);
		int Li_Wtcs = 0;
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if (token1.contains("if")){
				Li_Wtcs = Li_Wtcs + 1;
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
