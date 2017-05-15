package testPackage.string;

/**
 * Created by bajmd on 03/05/17.
 */
public class Combinations {
    public void findCombination(String prefix, String str) {
        System.out.println(prefix);
        for (int i=0; i<str.length(); i++)
                findCombination(prefix+str.charAt(i), str.substring(i+1));
    }

    public static void main (String args[]) {
        String input_string = "BIBHU";
        Combinations string_combinations = new Combinations();
        string_combinations.findCombination("", input_string);
    }
}
