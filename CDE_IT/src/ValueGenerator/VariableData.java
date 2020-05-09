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

	int a, b, c, sum;
	String token1 = "";
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

	// Logic.

	// ------------------------------------------------------------------------------------------------------------------------------
	// WVS Done
	public int FindWvs(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.equals("private")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();

						if ((token1.equals("byte")) || (token1.equals("short")) || (token1.equals("int"))
								|| (token1.equals("long")) || (token1.equals("float")) || (token1.equals("double"))
								|| (token1.equals("boolean")) || (token1.equals("char")) || (token1.equals("byte[]"))
								|| (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
								|| (token1.equals("float[]")) || (token1.equals("double[]"))
								|| (token1.equals("Dimension")) || (token1.equals("boolean[]"))
								|| (token1.equals("char[]"))) {

							Li_Count = Li_Count + 2;

						}
					}
				} else if ((token1.equals("byte")) || (token1.equals("short")) || (token1.equals("int"))
						|| (token1.equals("long")) || (token1.equals("float")) || (token1.equals("double"))
						|| (token1.equals("boolean")) || (token1.equals("char")) || (token1.equals("byte[]"))
						|| (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
						|| (token1.equals("float[]")) || (token1.equals("double[]")) || (token1.equals("Dimension"))
						|| (token1.equals("boolean[]")) || (token1.equals("char[]"))) {

					Li_Count = Li_Count + 1;

				} else {
					scanner.close();
					return a = Li_Count;
				}
			}
		} else if (extention.equals("cpp")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();
				
				if(token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
					scanner.close();
					return a = 0;
				}
				
				if ((token1.equals("byte")) || (token1.equals("short")) || (token1.equals("int"))
						|| (token1.equals("long")) || (token1.equals("float")) || (token1.equals("double"))
						|| (token1.equals("boolean")) || (token1.equals("char")) || (token1.equals("byte[]"))
						|| (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
						|| (token1.equals("float[]")) || (token1.equals("double[]")) || (token1.equals("Dimension"))
						|| (token1.equals("boolean[]")) || (token1.equals("char[]"))) {

					if (scanner.hasNext()) {
						token1 = scanner.next();
						if (!token1.endsWith(")")) {
							Li_Count = Li_Count + 2;
						}
					}

				} else if (token1.startsWith("::")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();
						if (!token1.isEmpty()) {
							Li_Count = Li_Count + 2;
						}
					}
				}
			}

		}

		scanner.close();
		return a = Li_Count;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	// NPDTV Done
	public int FindNpdtv(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.equals("private")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();

						if ((token1.equals("boolean")) || (token1.equals("byte")) || (token1.equals("char"))
								|| (token1.equals("short")) || (token1.equals("int")) || (token1.equals("long"))
								|| (token1.equals("float")) || (token1.equals("double"))) {

							if (scanner.hasNext()) {
								token1 = scanner.next();

								while (token1.endsWith(",")) {
									Li_Count = Li_Count + 1;

									if (scanner.hasNext()) {
										token1 = scanner.next();
									}
								}
								if (token1.endsWith(";")) {
									Li_Count = Li_Count + 1;
								} else {
									Li_Count = Li_Count + 1;
								}
							}
						}
					}
				} else if ((token1.equals("boolean")) || (token1.equals("byte")) || (token1.equals("char"))
						|| (token1.equals("short")) || (token1.equals("int")) || (token1.equals("long"))
						|| (token1.equals("float")) || (token1.equals("double"))) {

					if (scanner.hasNext()) {
						token1 = scanner.next();

						while (token1.endsWith(",")) {
							Li_Count = Li_Count + 1;

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + 1;
						} else {
							Li_Count = Li_Count + 1;
						}
					}
				}
			}
		} else if (extention.equals("cpp")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();
				
				if(token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
					scanner.close();
					return b = 0;
				}
				
				if ((token1.equals("boolean")) || (token1.equals("byte")) || (token1.equals("char"))
						|| (token1.equals("short")) || (token1.equals("int")) || (token1.equals("long"))
						|| (token1.equals("float")) || (token1.equals("double"))) {

					if (scanner.hasNext()) {
						String token2 = "";
						token2 = scanner.next();
						if (!token2.endsWith(")")) {
							Li_Count = Li_Count + 1;
						}
					} else {
						Li_Count = Li_Count + 1;
					}
					if (scanner.hasNext()) {
						token1 = scanner.next();

						while (token1.endsWith(",")) {
							Li_Count = Li_Count + 1;

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + 1;
						} else {
							Li_Count = Li_Count + 1;
						}
					}

				} else if (token1.startsWith("::")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();
						if (!token1.isEmpty()) {
							Li_Count = Li_Count + 1;
						}
					}
				}
			}

		}

		scanner.close();
		return b = Li_Count;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------
	// NCDTV Done
	public int FindNcdtv(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);

		if (extention.equals("java")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.equals("private")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();

						if ((token1.equals("boolean[]")) || (token1.equals("byte[]")) || (token1.equals("char[]"))
								|| (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
								|| (token1.equals("float[]")) || (token1.equals("double[]"))
								|| (token1.equals("Dimension"))) {

							if (scanner.hasNext()) {
								token1 = scanner.next();

								while (token1.endsWith(",")) {
									Li_Count = Li_Count + 1;

									if (scanner.hasNext()) {
										token1 = scanner.next();
									}
								}
								if (token1.endsWith(";")) {
									Li_Count = Li_Count + 1;
								} else {
									Li_Count = Li_Count + 1;
								}
							}

						}
					}
				} else if ((token1.equals("boolean[]")) || (token1.equals("byte[]")) || (token1.equals("char[]"))
						|| (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
						|| (token1.equals("float[]")) || (token1.equals("double[]")) || (token1.equals("Dimension"))) {

					if (scanner.hasNext()) {
						token1 = scanner.next();

						while (token1.endsWith(",")) {
							Li_Count = Li_Count + 1;

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + 1;
						} else {
							Li_Count = Li_Count + 1;
						}
					}

				} else {
					scanner.close();
					return c = Li_Count;
				}
			}
		} else if (extention.equals("cpp")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();
				
				if(token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
					scanner.close();
					return c = 0;
				}
				
				if ((token1.equals("boolean[]")) || (token1.equals("byte[]")) || (token1.equals("char[]"))
						|| (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
						|| (token1.equals("float[]")) || (token1.equals("double[]")) || (token1.equals("Dimension"))) {

					if (scanner.hasNext()) {
						String token2 = "";
						token2 = scanner.next();
						if (!token2.endsWith(")")) {
							Li_Count = Li_Count + 1;
						}
					} else {
						Li_Count = Li_Count + 1;
					}
					if (scanner.hasNext()) {
						token1 = scanner.next();

						while (token1.endsWith(",")) {
							Li_Count = Li_Count + 1;

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + 1;
						} else {
							Li_Count = Li_Count + 1;
						}
					}

				} else if (token1.startsWith("::")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();
						if (!token1.isEmpty()) {
							Li_Count = Li_Count + 2;
						}
					}
				}
			}
		}

		scanner.close();
		return c = Li_Count;
	}

	// -------------------------------------------------------------------------------------------------------------------------------------
	// CV Done
	public int FindCv(String CodeLine) {
		return sum = a * ((b * 1) + (c * 2));
	}
}
