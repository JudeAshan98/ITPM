package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xmlReader.CouplingReader;

public class CouplingData {
	String Result;
	String token1 = "\n";

	private int Nr;
	private int Nmcms;
	private int Nmcmd;
	private int Nmcrms;
	private int Nmcrmd;
	private int Nrmcrms;
	private int Nrmcrmd;
	private int Nrmcms;
	private int Nrmcmd;
	private int Nmrgvs;
	private int Nmrgvd;
	private int Nrmrgvs;
	private int Nrmrgvd;
	private int Ccp;

	int sum;
	int a;
	int b;
	int c;
	int d;
	int e;
	int f;
	int g;
	int h;
	int i;
	int j;
	int k;
	int l;
	int m;
	int n;

	List<Integer> ValueList = new ArrayList<Integer>();
	CouplingReader couplingreader = new CouplingReader();
	String previousLine = null;

	public int getNr() {
		return Nr;
	}

	public void setNr(int nr) {
		ValueList = couplingreader.GetAllcsValues();
		Nr = ValueList.get(0);
	}

	public int getNmcms() {
		return Nmcms;
	}

	public void setNmcms(int nmcms) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcms = ValueList.get(1);
	}

	public int getNmcmd() {
		return Nmcmd;
	}

	public void setNmcmd(int nmcmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcmd = ValueList.get(2);
	}

	public int getNmcrms() {
		return Nmcrms;
	}

	public void setNmcrms(int nmcrms) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcrms = ValueList.get(3);
	}

	public int getNmcrmd() {
		return Nmcrmd;
	}

	public void setNmcrmd(int nmcrmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nmcrmd = ValueList.get(4);
	}

	public int getNrmcrms() {
		return Nrmcrms;
	}

	public void setNrmcrms(int nrmcrms) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcrms = ValueList.get(5);
	}

	public int getNrmcrmd() {
		return Nrmcrmd;
	}

	public void setNrmcrmd(int nrmcrmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcrmd = ValueList.get(6);
	}

	public int getNrmcms() {
		return Nrmcms;
	}

	public void setNrmcms(int nrmcms) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcms = ValueList.get(7);
	}

	public int getNrmcmd() {
		return Nrmcmd;
	}

	public void setNrmcmd(int nrmcmd) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmcmd = ValueList.get(8);
	}

	public int getNmrgvs() {
		return Nmrgvs;
	}

	public void setNmrgvs(int nmrgvs) {
		ValueList = couplingreader.GetAllcsValues();
		Nmrgvs = ValueList.get(9);
	}

	public int getNmrgvd() {
		return Nmrgvd;
	}

	public void setNmrgvd(int nmrgvd) {
		ValueList = couplingreader.GetAllcsValues();
		Nmrgvd = ValueList.get(10);
	}

	public int getNrmrgvs() {
		return Nrmrgvs;
	}

	public void setNrmrgvs(int nrmrgvs) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmrgvs = ValueList.get(11);
	}

	public int getNrmrgvd() {
		return Nrmrgvd;
	}

	public void setNrmrgvd(int nrmrgvd) {
		ValueList = couplingreader.GetAllcsValues();
		Nrmrgvd = ValueList.get(12);
	}

	public int getCcp() {
		return Ccp;
	}

	public void setCcp(int ccp) {
		ValueList = couplingreader.GetAllcsValues();
		Ccp = ValueList.get(13);
	}

	// Logic

	// ------------------------------------------------------------------------------------------------------------------
	// NR Done
	public int findNr(String CodeLine) {
		int Li_Count = 0;
		String token1 = "";

		Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();

			if ((!token1.contains("static"))) {
				System.out.println(token1);
			} else {
				if ((token1.contains("static"))) {
					token1 = scanner.next();
					if ((token1.contains("int")) || (token1.contains("float")) || (token1.contains("double"))) {
						Li_Count = Li_Count + 1;
					}
				}
			}

		}
		scanner.close();
		return a = Li_Count;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNmcms(String CodeLine) {
		int Li_Count = 0;
		
		return b = Li_Count;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNmcmd(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNmcrms(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNmcrmd(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNrmcrms(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNrmcrmd(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNrmcms(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNrmcmd(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMRGVS
	public int findNmrgvs(String CodeLine) {
		int Li_Count = 0;
		
		return c = Li_Count;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNmrgvd(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNrmrgvs(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findNrmrgvd(String CodeLine) {
		int variable = 0;

		return variable;
	}

	// --------------------------------------------------------------------------------------------------------------------
	// NMCMS
	public int findCcp(String CodeLine) {
		return sum = (2 * a) + (2 * b) + (1 * c);
	}
}