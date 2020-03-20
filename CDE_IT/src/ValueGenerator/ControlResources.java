package ValueGenerator;

import java.util.ArrayList;
import java.util.List;

import xmlReader.CsReader;

public class ControlResources {

	static List <Integer>test = new ArrayList<>();
	
		public static void Main(String args[]) {
			
			CsReader csReader = new CsReader();
			test = csReader.GetAllcsValues();
			System.out.println(test.get(0));
		}
}
