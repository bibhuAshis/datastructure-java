package testPackage.CTCI;
import java.util.*;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();

        for (String word : magazine.split(" ")) {
            if (!magazineMap.containsKey(word))
                magazineMap.put(word, 1);
            else
                magazineMap.put(word, magazineMap.get(word)+1);
        }
        for (String word : note.split(" ")) {
            if (!noteMap.containsKey(word))
                noteMap.put(word, 1);
            else
                noteMap.put(word, noteMap.get(word)+1);
        }
    }

    public boolean solve() {
        for (Map.Entry<String, Integer> entry: noteMap.entrySet()) {
            if (!magazineMap.containsKey(entry.getKey()) || entry.getValue() != magazineMap.get(entry.getKey()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int m = 6;//scanner.nextInt();
        int n = 4;//scanner.nextInt();

        // Eat whitespace to beginning of next line
        //scanner.nextLine();

        RansomNote s = new RansomNote("give me one grand today night", "give one grand today");
        //scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
