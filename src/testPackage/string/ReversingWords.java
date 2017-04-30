package testPackage.string;

/**
 * Created by bajmd on 27/04/17.
 */
public class ReversingWords {
    String reverseWords (String str) {
        StringReverse reverser = new StringReverse();
        int start = 0, current = 0;
        StringBuilder str1 = new StringBuilder(reverser.reverse (str));
        System.out.println(str1);
        StringBuilder str2 = new StringBuilder(str1.length());
        while (current < str1.length()) {
            if (str1.charAt(current) != ' ')
                current++;
            else {
                str2.append(reverser.reverse(str1.substring(start, current)) + " ");
                start = current;
                start++;
                current++;
            }
            if (current == str1.length()-1)
                str2.append(reverser.reverse(str1.substring(start)));
        }
        return str2.toString();
    }

    public static void main (String args[]) {
        String string = "Bibhu Ashis Jena";
        System.out.println(string);
        ReversingWords reverse = new ReversingWords();
        System.out.println(reverse.reverseWords(string));
    }
}
