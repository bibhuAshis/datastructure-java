package testPackage.FooBar;

/**
 * Created by bajmd on 28/04/17.
 */
public class Cake {
    public int answer (String s) {
        int ans = 0, i=0, j=0;
        StringBuilder str = new StringBuilder(s);
        String pattern;
        while (j+1 < str.length() && (str.charAt(j+1) != str.charAt(i))){
            j++;
        }
        pattern = str.substring(i, j+1);
        int k = j+1;
        while (k+pattern.length()-1 < str.length()) {
            if (str.substring(k, k+pattern.length()).equals(pattern))
                k = k+pattern.length();
            else {
                pattern = str.substring(i, k+1);
                k = k+1;
            }
        }
        ans = str.length() / pattern.length();
        System.out.println(ans);
        return ans;
    }

    public static void main(String args[]) {
        String s = "abccbaabccba";
        Cake sol = new Cake();
        sol.answer(s);
    }
}
