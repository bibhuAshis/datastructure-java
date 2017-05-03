package testPackage.string;

/**
 * Created by bajmd on 03/05/17.
 */
public class Permutations {
    public void findPermutation(String prefix, String str) {
        if (str.length() == 0)
            System.out.println(prefix);
        else {
            for (int i=0; i<str.length(); i++)
                findPermutation(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
        }
    }

    public static void main (String args[]) {
        String inputstring = "AAA";
        Permutations string_permutation  = new Permutations();
        string_permutation.findPermutation("",inputstring);
    }
}
