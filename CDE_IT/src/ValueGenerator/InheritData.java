package ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xmlReader.*;

/**
 * @author Malidi
 *
 */
public class InheritData{
	
private int counter=0;
	        String Result;
	        String token1 = "\n";
private int Li_zero;
private int Li_one;
private int Li_two;
private int Li_three;
private int Li_four;
	
List<Integer> ValueList = new ArrayList<Integer>();
List<String> Names = new ArrayList<String>();
List<String> Inhobjects = new ArrayList<String>();
List<String> NoInheritance = new ArrayList<String>();
	
inheritanceReader inheritanceReader = new inheritanceReader();
String previousLine = null;
	
	public int transValue(int value)
	{
		return value;
	}
	//getters implemeneted
	public int getLi_zero()
	{
		return Li_zero;
	}
	public void setLi_zero(int li_DirIn)
	{
		ValueList = inheritanceReader.GetAllcsValues();
		Li_zero = ValueList.get(0);
	}

	public int getLi_one()
	{
		return Li_one;
	}
	public void setLi_one(int li_one)
	{
		ValueList = inheritanceReader.GetAllcsValues();
		Li_one = ValueList.get(1);
	}
	public int getLi_two()
	{
		return Li_two;
	}
	public void setLi_two(int li_two)
	{
		ValueList = inheritanceReader.GetAllcsValues();
		Li_two = ValueList.get(2);
	}
	public int getLi_three() 
	{
		return Li_three;
	}
	public void setLi_three(int li_three)
	{
		ValueList = inheritanceReader.GetAllcsValues();
		Li_three = ValueList.get(3);
	}
	public int getLi_four()
	{
		return Li_four;
	}
	public void setLi_four(int li_four)
	{
		ValueList = inheritanceReader.GetAllcsValues();
		Li_four = ValueList.get(4);
	}
	
	//method to check if class is user defined or inbuilt
	public static boolean ckIfUserDefined(String className)
	{
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

//Direct Inheritance method	
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

try {
	//Check whether Java code or not
	  if(ext.equals("java")) {
	
		  
		while (scanner.hasNext()) {
		token1 = scanner.next();
		
		//to check if class key word is there
		if(token1.equals("class"))
		{
			counter=counter+1;
			Names.add(scanner.next());
		}
		
		//checking for extends keyword
		if (token1.contains("extends"))
		{
			s1=scanner.next();
			s2=scanner.next();
				
			
			//checking the position of curly bracket
		if(s2.equals("{") || s2.equals("implements"))
		{
			
			//checking if the particular class is a user defined
			if(!ckIfUserDefined(s1))
			{
			   String getVal=Names.get(counter-1);
			   Inhobjects.add(getVal+",1");
               Li_one_count=Li_one_count+1;
			   return Li_one_count;
			}else
			{
				Li_one_count=Li_one_count+0;
				return Li_one_count;
			}
					
		 }	
		 else
		 {
			s3=scanner.next();
					
		 if(s3.equals("{")||s3.equals("implements"))
		 {
		    if(!ckIfUserDefined(s1)&&!ckIfUserDefined(s2))
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",2");
				Li_one_count=Li_one_count+2;
				return Li_one_count;
			}
		    else if((!ckIfUserDefined(s1)&&ckIfUserDefined(s2))||(!ckIfUserDefined(s2)&&ckIfUserDefined(s1)))
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",1");
				Li_one_count=Li_one_count+1;
				return Li_one_count;
			}else
			{
				Li_one_count=Li_one_count+0;
				return Li_one_count;
			}
			}else 
			{
				s4=scanner.next();
			if(s4.equals("{")||s4.equals("implements"))
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",3");
				Li_one_count=Li_one_count+3;
				return Li_one_count;
			}else
			{
				s5=scanner.next();
			if(s5.equals("{")||s5.equals("implements"))
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",4");
				Li_one_count=Li_one_count+4;
				return Li_one_count;
			}else
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",5");
			    Li_one_count=Li_one_count+5;
				return Li_one_count;
			}
							
		  }
						
		 }
	  }
	}
}
		    return Li_one_count;
	    }
	    //Check whether  the code is c++ or not..
		    else if(ext.equals("cpp"))
		    {
		        while (scanner.hasNext()) {
				token1 = scanner.next();
				
			if(token1.equals("class"))
			{
				counter=counter+1;
				Names.add(scanner.next());
			}
			//Check whether ":"is availavle or not..
			if (token1.equals(":"))
			{
		        s1=scanner.next();
				System.out.println(s1);
				s2=scanner.next();
				s3=scanner.next();
			if(s3.equals("{"))
			{
			    String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",1");
				Li_one_count=Li_one_count+1;
				return Li_one_count;
			}else
			{
				s4=scanner.next();
				s5=scanner.next();
			if(s5.equals("{"))
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",2");
				Li_one_count=Li_one_count+2;
				return Li_one_count;
			}else
			{
				s6=scanner.next();
				s7=scanner.next();
			if( s7.equals("{"))
			{
	            String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",3");
				Li_one_count=Li_one_count+3;
				return Li_one_count;
			}else
			{
				s8=scanner.next();
				s9=scanner.next();
			if( s9.equals("{"))
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",4");
				Li_one_count=Li_one_count+4;
				return Li_one_count;
			}else
			{
				String getVal=Names.get(counter-1);
				Inhobjects.add(getVal+",5");
				Li_one_count=Li_one_count+5;
				return Li_one_count;
			}
								
		  }
		}
	  }
	}
 }
       return Li_one_count;
       }
       scanner.close();

       return Li_one_count;
	   }
//if there is any array in code -1 is returned. [If code is not according to code standards]
       catch(Exception e)
		{
			System.out.println("exception is handled");
			return -1;
		}
	}
	
//Method for Indirect Inheritance
public int InDirectInh(String CodeLine, String ext)
{
	String s1="";
    String s2="";
	String s3="";
	String s4="";
	String s5="";
	String s6="";
	String s7="";
	String s8="";
	String s9="";
	int Li_two_count= 0;
	Scanner scanner = new Scanner(CodeLine);
		
	try
	{
	//Check the Java or not...
	  if(ext.equals("java")) {
	     while (scanner.hasNext()) 
	     {
		   token1 = scanner.next();
		
	  if (token1.contains("extends"))
	  {
		  s1=scanner.next();
		  System.out.println(s1);
		  s2=scanner.next();
	  if(s2.equals("{") || s2.equals("implements"))
	  {
		  //checking for the number of classes extended by the particuar class
		  if(Inhobjects.contains(s1+",1"))
		  {
			 Li_two_count=Li_two_count+1;
			 return Li_two_count;
		  }else if(Inhobjects.contains(s1+",2"))
		  {
			 Li_two_count=Li_two_count+2;
			 return Li_two_count;
		  }else if(Inhobjects.contains(s1+",3"))
		  {
			 Li_two_count=Li_two_count+3;
			 return Li_two_count;
		   }else if(Inhobjects.contains(s1+",4"))
		   {
			 Li_two_count=Li_two_count+4;
			 return Li_two_count;
			}else if(Inhobjects.contains(s1+",5"))
			{
			  Li_two_count=Li_two_count+5;
			  return Li_two_count;
			}else
			{
			  Li_two_count=Li_two_count+0;
			  return Li_two_count;
			}
		}	
		else {
			   s3=scanner.next();
					
		if(s3.equals("{")||s3.equals("implements"))
		{
			// splitting the class as the comma is joined with the class
			 String Stringbreaker[]=s1.split(",");
		
			 //Checking for the number of classes inherited by each particular class before
		if(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s2+",1"))
		{
			Li_two_count=Li_two_count+2;
			return Li_two_count;
							
		}else if(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s2+",2"))
		{
			Li_two_count=Li_two_count+4;
			return Li_two_count;
			
		}else if(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s2+",3"))
		{
		    Li_two_count=Li_two_count+6;
			return Li_two_count;
			
		}else if(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s2+",4"))
		{
			Li_two_count=Li_two_count+8;
			return Li_two_count;
			
	    }else if(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s2+",5"))
	    {
		    Li_two_count=Li_two_count+10;
			return Li_two_count;
			
		}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s2+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s2+",1")))
		{
			Li_two_count=Li_two_count+3;
			return Li_two_count;
							
         }else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s2+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s2+",1")))
		 {
			Li_two_count=Li_two_count+4;
			return Li_two_count;
							
         }else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s2+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s2+",1")))
		 {
			Li_two_count=Li_two_count+5;
			return Li_two_count;
							
		}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s2+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s2+",1")))
		{
			Li_two_count=Li_two_count+6;
			return Li_two_count;
							
		}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s2+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s2+",2")))
		{
			Li_two_count=Li_two_count+5;
			return Li_two_count;
							
		}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s2+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s2+",2")))
		{
			Li_two_count=Li_two_count+6;
			return Li_two_count;
							
		}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s2+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s2+",2")))
		{
			Li_two_count=Li_two_count+7;
			return Li_two_count;
							
		}else if((Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s2+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s2+",3")))
		{
			Li_two_count=Li_two_count+7;
			return Li_two_count;
							
		}else if((Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s2+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s2+",3")))
		{
			Li_two_count=Li_two_count+8;
			return Li_two_count;
							
		}else if((Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s2+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s2+",4")))
		{
			Li_two_count=Li_two_count+9;
			return Li_two_count;
							
		}else if(Inhobjects.contains(Stringbreaker[0]+",1")||Inhobjects.contains(s2+",1"))
		{
			Li_two_count=Li_two_count+1;
			return Li_two_count;
							
		}else if(Inhobjects.contains(Stringbreaker[0]+",2")||Inhobjects.contains(s2+",2"))
		{
			Li_two_count=Li_two_count+2;
			return Li_two_count;
		}else if(Inhobjects.contains(Stringbreaker[0]+",3")||Inhobjects.contains(s2+",3"))
		{
			Li_two_count=Li_two_count+3;
			return Li_two_count;
							
		}else if(Inhobjects.contains(Stringbreaker[0]+",4")||Inhobjects.contains(s2+",4"))
		{
			Li_two_count=Li_two_count+4;
			return Li_two_count;
							
		}else if(Inhobjects.contains(Stringbreaker[0]+",5")||Inhobjects.contains(s2+",5"))
		{
			Li_two_count=Li_two_count+5;
			return Li_two_count;
		}else 
		{
			Li_two_count=Li_two_count+0;
			return Li_two_count;
		}
		}else
		  {
			s4=scanner.next();
			if(s4.equals("{")||s4.equals("implements"))
			{
			   String Stringbreaker[]=s1.split(",");
			   String Stringbreaker2[]=s2.split(",");
							
			if(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",1"))
			{
				Li_two_count=Li_two_count+3;
				return Li_two_count;
								
			}else if(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",2"))
			{
				Li_two_count=Li_two_count+6;
				return Li_two_count;
				
			}else if(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",3"))
			{
			    Li_two_count=Li_two_count+9;
				return Li_two_count;
								
			}else if(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",4"))
			{
			    Li_two_count=Li_two_count+12;
				return Li_two_count;
								
			}else if(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",5"))
			{
			   Li_two_count=Li_two_count+15;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",1"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+4;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",1"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+5;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",1"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+6;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",1"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+7;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+5;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+6;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+7;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",1")))
			{
			   Li_two_count=Li_two_count+8;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",1"))) 
			{
			   Li_two_count=Li_two_count+6;
			   return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",1"))) 
			{
				Li_two_count=Li_two_count+6;
				return Li_two_count;
				
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",1")))
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",1"))) 
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",1"))) 
			{
								
				Li_two_count=Li_two_count+9;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",1"))) 
			{
				Li_two_count=Li_two_count+7;
			    return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",1"))) 
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",1")))
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",1")))
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",1"))) 
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",1"))) 
			{
								
				Li_two_count=Li_two_count+9;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",1"))) 
			{
				Li_two_count=Li_two_count+10;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",1")))
			{
				Li_two_count=Li_two_count+11;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",3")))
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",4"))) 
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",5"))) 
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",2"))) 
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",2")))
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",2")))
			{
				Li_two_count=Li_two_count+10;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s3+",2"))) 
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",2")))
			{
				Li_two_count=Li_two_count+10;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",2")))
			{
				Li_two_count=Li_two_count+11;
				return Li_two_count;
								
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s3+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s3+",2")))
			{
				Li_two_count=Li_two_count+12;
				return Li_two_count;
								
			}else if(Inhobjects.contains(Stringbreaker[0]+",1")||Inhobjects.contains(Stringbreaker2[0]+",1")||Inhobjects.contains(s3+",1"))
			{
				Li_two_count=Li_two_count+1;
				return Li_two_count;
								
			}else if(Inhobjects.contains(Stringbreaker[0]+",2")||Inhobjects.contains(Stringbreaker2[0]+",2")||Inhobjects.contains(s3+",2"))
			{
				Li_two_count=Li_two_count+2;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",3")||Inhobjects.contains(Stringbreaker2[0]+",3")||Inhobjects.contains(s3+",3"))
			{
				Li_two_count=Li_two_count+3;
				return Li_two_count;
								
		    }else if(Inhobjects.contains(Stringbreaker[0]+",4")||Inhobjects.contains(Stringbreaker2[0]+",4")||Inhobjects.contains(s3+",4")) 
		    {
			    Li_two_count=Li_two_count+4;
				return Li_two_count;
								
	        }else if(Inhobjects.contains(Stringbreaker[0]+",5")||Inhobjects.contains(Stringbreaker2[0]+",5")||Inhobjects.contains(s3+",5"))
	        {
				Li_two_count=Li_two_count+5;
				return Li_two_count;
								
			}else 
			{
				Li_two_count=Li_two_count+0;
				return Li_two_count;
			}
			}else
			{
			  s5=scanner.next();
			  if(s5.equals("{")||s4.equals("implements"))
				 {
				   Li_two_count=Li_two_count+4;
				   return Li_two_count;
			  }else
			  {
				    Li_two_count=Li_two_count+5;
					return Li_two_count;
			   }
			 }
		   }
         }
	   }
	}

return Li_two_count;
  }
	  //Checking if the code is a c++ file
		    else if(ext.equals("cpp")) {
			while (scanner.hasNext())
			{
              token1 = scanner.next();
			if(token1.equals("class"))
			{
			  counter=counter+1;
			  Names.add(scanner.next());
		    }
			if (token1.equals(":"))
			{
			  s1=scanner.next();
			  System.out.println(s1);
			  s2=scanner.next();
			  s3=scanner.next();
			  
			  //checking for curly bracket position
			 if(s3.equals("{"))
			{
			if(Inhobjects.contains(s1+",1"))
			{
			  Li_two_count=Li_two_count+1;
			  return Li_two_count;
			  
			}else if(Inhobjects.contains(s1+",2"))
			{
			  Li_two_count=Li_two_count+2;
			  return Li_two_count;
			  
			}else if(Inhobjects.contains(s1+",3"))
			{
			  Li_two_count=Li_two_count+3;
			  return Li_two_count;
			  
			}else if(Inhobjects.contains(s1+",4"))
			{
			  Li_two_count=Li_two_count+4;
			  return Li_two_count;
			  
			}else if(Inhobjects.contains(s1+",5"))
			{
		      Li_two_count=Li_two_count+5;
			  return Li_two_count;
			}else
			{
               Li_two_count=Li_two_count+0;
			   return Li_two_count;
			}
		  }	
		  else {
				 s4=scanner.next();
				 s5=scanner.next();
		  if(s5.equals("{"))
		  {
			  //splitting comma and class name as they are joined
            String Stringbreaker[]=s2.split(",");
							
		   if(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s4+",1"))
		   {
				Li_two_count=Li_two_count+2;
				return Li_two_count;
		   }else if(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s4+",2"))
		   {
				Li_two_count=Li_two_count+4;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s4+",3"))
			{
				Li_two_count=Li_two_count+6;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s4+",4"))
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s4+",5"))
			{
				Li_two_count=Li_two_count+10;
				return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s4+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s4+",1")))
			{
				Li_two_count=Li_two_count+3;
				return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s4+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s4+",1")))
			{
				Li_two_count=Li_two_count+4;
				return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s4+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s4+",1")))
			{
				Li_two_count=Li_two_count+5;
				return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(s4+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s4+",1")))
			{
				Li_two_count=Li_two_count+6;
				return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s4+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s4+",2")))
			{
			  Li_two_count=Li_two_count+5;
			  return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s4+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s4+",2")))
			{
			  Li_two_count=Li_two_count+6;
			  return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(s4+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s4+",2")))
			{
			  Li_two_count=Li_two_count+7;
			  return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s4+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s4+",3")))
			{
			   Li_two_count=Li_two_count+7;
			   return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(s4+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s4+",3")))
			{
			   Li_two_count=Li_two_count+8;
			   return Li_two_count;
			}else if((Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(s4+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(s4+",4")))
			{
			   Li_two_count=Li_two_count+9;
			   return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",1")||Inhobjects.contains(s4+",1"))
			{
				Li_two_count=Li_two_count+1;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",2")||Inhobjects.contains(s4+",2"))
			{
				Li_two_count=Li_two_count+2;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",3")||Inhobjects.contains(s4+",3"))
			{
				Li_two_count=Li_two_count+3;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",4")||Inhobjects.contains(s4+",4"))
			{
				Li_two_count=Li_two_count+4;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",5")||Inhobjects.contains(s4+",5"))
			{
				Li_two_count=Li_two_count+5;
				return Li_two_count;
			}else
			{
				Li_two_count=Li_two_count+0;
				return Li_two_count;
			}
			}else
			{
				s6=scanner.next();
				s7=scanner.next();
			if(s7.equals("{"))
			{
				String Stringbreaker[]=s2.split(",");
				String Stringbreaker2[]=s4.split(",");
			if(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",1"))
			{
				Li_two_count=Li_two_count+3;
				return Li_two_count;
									
			}else if(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",2"))
			{
				Li_two_count=Li_two_count+6;
				return Li_two_count;
				
			}else if(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",3"))
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
									
			}else if(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",4")) 
			{
			    Li_two_count=Li_two_count+12;
				return Li_two_count;
									
             }else if(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",5"))
             {
				Li_two_count=Li_two_count+15;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",1"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",1")))
			{
				Li_two_count=Li_two_count+4;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",1"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+5;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",1"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+6;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",1"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+5;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+6;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",1"))) 
			{
			   Li_two_count=Li_two_count+6;
			   return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",1"))) 
			{
			    Li_two_count=Li_two_count+6;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",1")))
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",1")))
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+8;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",1")))
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",1")))
			{
				Li_two_count=Li_two_count+7;
				return Li_two_count;
									
		    }else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",1")))
		    {
				Li_two_count=Li_two_count+8;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",1"))) 
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",1")))
			{
				Li_two_count=Li_two_count+10;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",1")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",1")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",1")))
			{
				Li_two_count=Li_two_count+11;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",3"))) 
			{
			   Li_two_count=Li_two_count+7;
			   return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",4"))) 
			{
			   Li_two_count=Li_two_count+8;
			   return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",2"))||(Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",5"))) 
			{
			   Li_two_count=Li_two_count+9;
			   return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",2")))
			{
			   Li_two_count=Li_two_count+8;
			   return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",2"))) 
			{
			   Li_two_count=Li_two_count+9;
			   return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",3")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",2"))) 
			{
				Li_two_count=Li_two_count+10;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",3"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",3")&&Inhobjects.contains(s6+",2"))) 
			{
				Li_two_count=Li_two_count+9;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",4"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",2"))) 
			{
				Li_two_count=Li_two_count+10;
				return Li_two_count;
									
			}else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",4")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",4")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",2"))) 
			{
				Li_two_count=Li_two_count+11;
				return Li_two_count;
									
		    }else if((Inhobjects.contains(Stringbreaker[0]+",2")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",2")&&Inhobjects.contains(s6+",5"))||(Inhobjects.contains(Stringbreaker[0]+",5")&&Inhobjects.contains(Stringbreaker2[0]+",5")&&Inhobjects.contains(s6+",2")))
		    {
				Li_two_count=Li_two_count+12;
				return Li_two_count;
									
			}else if(Inhobjects.contains(Stringbreaker[0]+",1")||Inhobjects.contains(Stringbreaker2[0]+",1")||Inhobjects.contains(s6+",1"))
			{
				Li_two_count=Li_two_count+1;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",2")||Inhobjects.contains(Stringbreaker2[0]+",2")||Inhobjects.contains(s6+",2"))
			{
				Li_two_count=Li_two_count+2;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",3")||Inhobjects.contains(Stringbreaker2[0]+",3")||Inhobjects.contains(s6+",3"))
			{
				Li_two_count=Li_two_count+3;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",4")||Inhobjects.contains(Stringbreaker2[0]+",4")||Inhobjects.contains(s6+",4")) 
			{
				Li_two_count=Li_two_count+4;
				return Li_two_count;
			}else if(Inhobjects.contains(Stringbreaker[0]+",5")||Inhobjects.contains(Stringbreaker2[0]+",5")||Inhobjects.contains(s6+",5")) 
			{
				Li_two_count=Li_two_count+5;
				return Li_two_count;
			}else
			{
				Li_two_count=Li_two_count+0;
				return Li_two_count;
			}
			}else
			{
				s8=scanner.next();
				s9=scanner.next();
			if(s9.equals("{"))
			{
				Li_two_count=Li_two_count+4;
				return Li_two_count;
			}else 
			{
				Li_two_count=Li_two_count+5;
				return Li_two_count;
		   }
		}
	   }
	  }
	}
 }
  return Li_two_count;
 }// returning -1 if the code is not according to the coding standards
  }catch(Exception e)
  {
	return -1;
  }
  scanner.close();
  return Li_two_count;

	}


//Returing the total inheritance value
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
}else 
{
  setLi_four(Li_four);
  count = count + getLi_four();
}
		
return count;
	}

}
