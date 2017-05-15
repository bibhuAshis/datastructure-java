package testPackage.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajmd on 16/12/16.
 */

public class MapLearning {

	public static void main(String[] args) {
		Map<String,String> BibhuMap = new HashMap<String,String>();
		//Map<String,String> BibhuMap = Collections.synchronizedMap(hashMap);
		BibhuMap.put("Bibhu", "1");
		BibhuMap.put("Mallika", "2");
		BibhuMap.put("Aishwarya", "3");
		BibhuMap.put("Priyanka", "4");
		BibhuMap.put("", "5");
		BibhuMap.put("1", "1");

		System.out.println("Mallika's last name is"+ " " +BibhuMap.get("Mallika"));
		
		for(Map.Entry<String, String> entry: BibhuMap.entrySet()){
			System.out.println("First Name: " + entry.getKey() +" Last Name: " + entry.getValue());
			System.out.println(Integer.parseInt(entry.getValue()) == 1);
		}
	}

}