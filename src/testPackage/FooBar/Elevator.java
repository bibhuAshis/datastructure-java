package testPackage.FooBar;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajmd on 28/04/17.
 */
class Trie {
    private static final int RANGE = 100;
    private boolean isEndOfString;
    private Trie[] links;

    // Constructor
    public Trie () {
        isEndOfString = false;
        links = new Trie[RANGE];
    }

    // Trie Insert
    public void trieInsert (String s) {
        Trie current = this;
        int i=0, j, index;
        while (i<s.length()) {
            j=i;
            while(j < s.length() && s.charAt(j) != '.'){
                j++;
            }
            if (j >= s.length())
                index = Integer.parseInt(s.substring(i));
            else
                index = Integer.parseInt(s.substring(i,j));
            i = j+1;
            if (current.links[index] == null)
                current.links[index] = new Trie();
            current = current.links[index];
        }
        current.isEndOfString = true;
    }

    // Trie Traversal
    List<String> trieTraverse (Trie t, String str, List<String> result) {
        if (t != null) {
            if (t.isEndOfString){
                String finalString = str.substring(0, str.length()-1);
                result.add(finalString);
            }
            for (int j=0; j<RANGE; j++){
                if (t.links[j] !=null)
                    trieTraverse(t.links[j], str + j +'.', result);
            }
        }
        return result;
    }
}

public class Elevator {
    public String[] answer (String[] s) {
        Trie trie = new Trie();

        // Build Trie
        for (int i=0; i<s.length; i++)
            trie.trieInsert(s[i]);

        // Traverse Trie
        List<String> result = new ArrayList<String>();
        trie.trieTraverse(trie, "", result);
        String[] answer = result.toArray(new String[result.size()]);
        for (int i=0; i<answer.length; i++)
            System.out.println(answer[i]);
        return answer;
    }

    public static void main(String args[]) {
        String[] s = {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2", "0.5"};
        Elevator result = new Elevator();
        result.answer(s);
    }
}
