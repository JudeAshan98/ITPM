package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xmlReader.*;

public class InheritData{
	

	String Result;
	String token1 = "\n";
	private int Li_zero;
	private int Li_one;
	private int Li_two;
	private int Li_three;
	private int Li_four;
//	
//	
	List<Integer> ValueList = new ArrayList<Integer>();
	inheritanceReader inheritanceReader = new inheritanceReader();
	String previousLine = null;
//	
	public int getLi_zero() {
		return Li_zero;
	}
	public void setLi_zero(int li_DirIn) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_zero = ValueList.get(0);
	}

	public int getLi_one() {
		return Li_one;
	}
	public void setLi_one(int li_one) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_one = ValueList.get(1);
	}
	public int getLi_two() {
		return Li_two;
	}
	public void setLi_two(int li_two) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_two = ValueList.get(2);
	}
	public int getLi_three() {
		return Li_three;
	}
	public void setLi_three(int li_three) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_three = ValueList.get(3);
	}
	public int getLi_four() {
		return Li_four;
	}
	public void setLi_four(int li_four) {
		ValueList = inheritanceReader.GetAllcsValues();
		Li_four = ValueList.get(4);
	}
	
	public boolean isJavaObject(Object check)
	{
		//Package p = check.getClass().getPackage();
		System.out.println(check.getClass().getName());

		
		return check.getClass().getName().startsWith("java.lang");
		
	}
	// methods
	
	public int DirectInh(String CodeLine, String ext) {
		String s1="";
		String s2="";
		String s3="";
		String s4="";
		String s5="";
		String s6="";
		String s7="";
		String s8="";
		String s9="";
		int Li_one_count= 0;
		Scanner scanner = new Scanner(CodeLine);
	if(ext.equals("java")) {
	//	Scanner scanner = new Scanner(CodeLine);
		while (scanner.hasNext()) {
			token1 = scanner.next();
			if (token1.contains("extends")) {
				
				s1=scanner.next();
				System.out.println(s1);
				s2=scanner.next();
				
				if(s2.equals("{") || s2.equals("implements")) {
					Object val=valueof(s1);

					Li_one_count=Li_one_count+1;
					return Li_one_count;
				}	
				else {
					s3=scanner.next();
					if(s3.equals("{")||s3.equals("implements"))
					{
						Li_one_count=Li_one_count+2;
						return Li_one_count;
						
					}else {
						s4=scanner.next();
						if(s4.equals("{")||s4.equals("implements")) {
							
							Li_one_count=Li_one_count+3;
							return Li_one_count;
						}else {
							s5=scanner.next();
							if(s5.equals("{")||s4.equals("implements"))
							{
								Li_one_count=Li_one_count+4;
								return Li_one_count;
							}else {
								
								Li_one_count=Li_one_count+5;
								return Li_one_count;
							}
							
						}
						
					}
				}
				

			}
		}
//		scanner.close();
//		System.out.println(Li_one_count);
		return Li_one_count;
	}
		else if(ext.equals("cpp")) {
//			Scanner scanner = new Scanner(CodeLine);
			while (scanner.hasNext()) {
				token1 = scanner.next();
				if (token1.equals(":")) {
					
					s1=scanner.next();
					System.out.println(s1);
					s2=scanner.next();
					s3=scanner.next();
					if(s3.equals("{")) {
						Li_one_count=Li_one_count+1;
						return Li_one_count;
					}	
					else {
						s4=scanner.next();
						s5=scanner.next();
						if(s5.equals("{"))
						{
							Li_one_count=Li_one_count+2;
							return Li_one_count;
							
						}else {
							s6=scanner.next();
							s7=scanner.next();
							if(s7.equals("{")) {
								
								Li_one_count=Li_one_count+3;
								return Li_one_count;
							}else {
								s8=scanner.next();
								s9=scanner.next();
								if(s9.equals("{"))
								{
									Li_one_count=Li_one_count+4;
									return Li_one_count;
								}else {
									
									Li_one_count=Li_one_count+5;
									return Li_one_count;
								}
								
							}
							
						}
					}
					

				}
			}
			
			
			
			
//			scanner.close();
//			System.out.println(Li_one_count);
			return Li_one_count;
		}
	scanner.close();
	System.out.println(Li_one_count);
	return Li_one_count;
		
	}
	
	
	private Object valueof(String s1) {
		// TODO Auto-generated method stub
		return null;
	}
	public int InDirectInh(String CodeLine) {
		
		int Li_two_count= 0;
		return Li_two_count;
	}
	
	
	public int totalWeight(int Three)
	{
		int count=0;
		
		if(Three==0)
		{
			setLi_zero(Li_zero);
			count = count + getLi_zero();
		}else if(Three==1)
		{
			setLi_one(Li_one);
			count = count + getLi_one();
		}else if(Three==2)
		{
			setLi_two(Li_two);
			count = count + getLi_two();
		}else if(Three==3)
		{
			setLi_three(Li_three);
			count = count + getLi_three();
		}else {
			
			setLi_four(Li_four);
			count = count + getLi_four();
		}
		
		
		return count;
	}

}
