package testPackage.general;

/**
 * Created by bajmd on 28/04/17.
 */
class TrieNode {
    char value;
    boolean isEndOfString;
    public TrieNode (char ch) {
        value = ch;
        isEndOfString = false;
    }
}
public class Elevator {
    public String answer (String[] s) {
        String ans = null;

        return ans;
    }

    public static void main(String args[]) {
        String[] s = {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"};
        Elevator result = new Elevator();
        result.answer(s);
    }
}
