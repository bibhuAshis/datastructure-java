package testPackage;

import java.util.HashMap;
import java.util.Map;

public class MapLearning {

	public static void main(String[] args) {
		Map<String,String> BibhuMap = new HashMap<String,String>();
		//Map<String,String> BibhuMap = Collections.synchronizedMap(hashMap);
		BibhuMap.put("Bibhu", "Jena");
		BibhuMap.put("Mallika", "Desai");
		BibhuMap.put("Aishwarya", "Desai");
		BibhuMap.put("Priyanka", "Subhadarsini");
		BibhuMap.put("", "");
		BibhuMap.put("1", "");
				
		System.out.println("Mallika's last name is"+ " " +BibhuMap.get("Mallika"));
		
		for(Map.Entry<String, String> entry: BibhuMap.entrySet()){
			System.out.println("First Name: " + entry.getKey() +" Last Name: " + entry.getValue());
		}
	}

}