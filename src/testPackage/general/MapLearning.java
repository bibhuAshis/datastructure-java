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
		BibhuMap.put("Bibhu", "Jena");
		BibhuMap.put("Mallika", "Desai");
		BibhuMap.put("Aishwarya", "Desai");
		BibhuMap.put("Priyanka", "Jena");
		BibhuMap.put("", "");
		BibhuMap.put("Noname", "");

		System.out.println("Mallika's last name is"+ " " +BibhuMap.get("Mallika"));
		
		for(String key: BibhuMap.keySet()){
			System.out.println("First Name: " + key +" Last Name: " + BibhuMap.get(key));
		}
	}

}