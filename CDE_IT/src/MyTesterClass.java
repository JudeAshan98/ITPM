import java.util.ArrayList;
import java.util.List;

import xmlReader.CsReader;

public class MyTesterClass {


		// TODO Auto-generated method stub
		

		static List <Integer>test = new ArrayList<>();
		
		public static void main(String[] args) {
				
				CsReader csReader = new CsReader();
				
				test = csReader.GetAllcsValues();
				
				System.out.println(test.get(2));
	}

}
