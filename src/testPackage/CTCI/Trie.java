package testPackage.CTCI;

class TrieNode{
    private static final int ALPHABATES = 26;
    private TrieNode[] children;
    private int childrenCount;
    private boolean isEndOfString;

    // Constructor
    public TrieNode () {
        children = new TrieNode[ALPHABATES];
        childrenCount = 0;
        isEndOfString = false;
    }

    // Trie Insert
    public void addtoTrie (String s) {
        TrieNode current = this;
        for (int i=0; i< s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (current.children[index] != null)
                current.childrenCount++;
            else {
                current.children[index] = new TrieNode();
                current.childrenCount++;
            }
            current = current.children[index];
        }
        current.isEndOfString = true;
    }

    // Trie Traversal
    public int findinTrie (String s) {
        TrieNode current = this;
        for (int i=0; i< s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (current.children[index] == null)
                return 0;
            current = current.children[index];
        }
        return current.childrenCount;
    }
}

public class  Trie{

    public static void main(String[] args) {
        TrieNode trieobj = new TrieNode();
        //int n = 11;
        //String[] op = {"add", "add", "add", "add", "add", "find", "find", "find", "find", "find"};
        //String[] contact = {"s", "ss", "sss", "ssss", "sssss", "s", "ss", "sss", "ssss", "sssss", "ssssss"};
        int n = 5;
        String[] op = {"add", "add", "add", "find", "find"};
        String[] contact = {"sss", "fff", "rrr",  "sss", "f"};
        for(int a0 = 0; a0 < n; a0++){
            if (op[a0].equals("add"))
                trieobj.addtoTrie(contact[a0]);
            else if (op[a0].equals("find"))
                System.out.println(trieobj.findinTrie(contact[a0]));
        }
    }
}