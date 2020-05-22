package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import xmlReader.*;

public class VariableData {
	// declare the variables
	String Result;
	String token1 = "\n";
	int Wvs;
	int Npdtv;
	int Ncdtv;
	int Cv;

	int a, b, c, sum;

	// List for get values
	List<Integer> ValueList = new ArrayList<Integer>();

	// Reader for get weight
	VariableReader variableReader = new VariableReader();
	String previousLine = null;

	// Getters and setters
	public int getWvs() {
		return Wvs;
	}

	public void setWvs(int wvs) {
		ValueList = variableReader.GetAllcsValues();
		Wvs = ValueList.get(0);
	}

	public int getNpdtv() {
		return Npdtv;
	}

	public void setNpdtv(int npdtv) {
		ValueList = variableReader.GetAllcsValues();
		Npdtv = ValueList.get(1);
	}

	public int getNcdtv() {
		return Ncdtv;
	}

	public void setNcdtv(int ncdtv) {
		ValueList = variableReader.GetAllcsValues();
		Ncdtv = ValueList.get(2);
	}

	public int getCv() {
		return Cv;
	}

	public void setCv(int cv) {
		ValueList = variableReader.GetAllcsValues();
		Cv = ValueList.get(3);
	}

	// Logic Part

	// -------------------------------------------------------------------------------------------------------------------
	// WVS - Weight due to variable scope
	// -------------------------------------------------------------------------------------------------------------------
	public int FindWvs(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		setWvs(Wvs);

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

							Li_Count = Li_Count + 2 * (getWvs());

						}
					}
				} else if ((token1.equals("byte")) || (token1.equals("short")) || (token1.equals("int"))
						|| (token1.equals("long")) || (token1.equals("float")) || (token1.equals("double"))
						|| (token1.equals("boolean")) || (token1.equals("char")) || (token1.equals("byte[]"))
						|| (token1.equals("short[]")) || (token1.equals("int[]")) || (token1.equals("long[]"))
						|| (token1.equals("float[]")) || (token1.equals("double[]")) || (token1.equals("Dimension"))
						|| (token1.equals("boolean[]")) || (token1.equals("char[]"))) {

					Li_Count = Li_Count + getWvs();

				} else {
					scanner.close();
					return a = Li_Count;
				}
			}
		} else if (extention.equals("cpp")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
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
							Li_Count = Li_Count + getWvs();
						}
					}

				} else if (token1.startsWith("::")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();
						if (!token1.isEmpty()) {
							Li_Count = Li_Count + getWvs();
						}
					}
				}
			}

		}

		scanner.close();
		return a = Li_Count;
	}

	// -------------------------------------------------------------------------------------------------------------------
	// NPDTV - Number of primitive data type variables
	// -------------------------------------------------------------------------------------------------------------------
	public int FindNpdtv(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		setNpdtv(Npdtv);

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
									Li_Count = Li_Count + getNpdtv();

									if (scanner.hasNext()) {
										token1 = scanner.next();
									}
								}
								if (token1.endsWith(";")) {
									Li_Count = Li_Count + getNpdtv();
								} else {
									Li_Count = Li_Count + getNpdtv();
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
							Li_Count = Li_Count + getNpdtv();

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + getNpdtv();
						} else {
							Li_Count = Li_Count + getNpdtv();
						}
					}
				}
			}
		} else if (extention.equals("cpp")) {
			if (scanner.hasNext()) {
				token1 = scanner.next();

				if (token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
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
							Li_Count = Li_Count + getNpdtv();
						}
					}
					if (scanner.hasNext()) {
						token1 = scanner.next();

						while (token1.endsWith(",")) {
							Li_Count = Li_Count + getNpdtv();

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + getNpdtv();
						}
					}

				} else if (token1.startsWith("::")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();
						if (!token1.isEmpty()) {
							Li_Count = Li_Count + getNpdtv();
						}
					}
				}
			}

		}

		scanner.close();
		return b = Li_Count;
	}

	// -------------------------------------------------------------------------------------------------------------------
	// NCDTV - Number of composite data type variables
	// -------------------------------------------------------------------------------------------------------------------
	public int FindNcdtv(String CodeLine, String extention) {
		token1 = "";
		int Li_Count = 0;
		Scanner scanner = new Scanner(CodeLine);
		setNcdtv(Ncdtv);

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
									Li_Count = Li_Count + getNcdtv();

									if (scanner.hasNext()) {
										token1 = scanner.next();
									}
								}
								if (token1.endsWith(";")) {
									Li_Count = Li_Count + getNcdtv();
								} else {
									Li_Count = Li_Count + getNcdtv();
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
							Li_Count = Li_Count + getNcdtv();

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + getNcdtv();
						} else {
							Li_Count = Li_Count + getNcdtv();
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

				if (token1.startsWith("#") || token1.startsWith("//") || token1.startsWith("/*")) {
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
							Li_Count = Li_Count + getNcdtv();
						}
					} else {
						Li_Count = Li_Count + getNcdtv();
					}
					if (scanner.hasNext()) {
						token1 = scanner.next();

						while (token1.endsWith(",")) {
							Li_Count = Li_Count + getNcdtv();

							if (scanner.hasNext()) {
								token1 = scanner.next();
							}
						}
						if (token1.endsWith(";")) {
							Li_Count = Li_Count + getNcdtv();
						} else {
							Li_Count = Li_Count + getNcdtv();
						}
					}

				} else if (token1.startsWith("::")) {
					if (scanner.hasNext()) {
						token1 = scanner.next();
						if (!token1.isEmpty()) {
							Li_Count = Li_Count + 2 * (getNcdtv());
						}
					}
				}
			}
		}

		scanner.close();
		return c = Li_Count;
	}

	// -------------------------------------------------------------------------------------------------------------------
	// CV - Complexity of a program statement due to its variables
	// -------------------------------------------------------------------------------------------------------------------
	public int FindCv(String CodeLine) {
		return sum = a * ((b * 1) + (c * 2));
	}
}
