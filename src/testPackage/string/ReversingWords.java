package testPackage.string;

/**
 * Created by bajmd on 27/04/17.
 */
public class ReversingWords {
    void reverseWords (String str) {
        StringBuilder str1;
        int start = 0, current = 0;
        str1 = reverse (str);
        System.out.println(str1);
        StringBuilder str2 = new StringBuilder(str1.length());
        while (current < str1.length()) {
            if (str1.charAt(current) != ' ')
                current++;
            else {
                str2.append(reverse(str1.substring(start, current)) + " ");
                start = current;
                start++;
                current++;
            }
            if (current == str1.length()-1)
                str2.append(reverse(str1.substring(start)));
        }
        System.out.println(str2);
    }

    StringBuilder reverse (String str) {
        StringBuilder str1 = new StringBuilder(str);
        int start, end = str1.length()-1;
        for (start=0; start<end; start++,end--) {
            str1.setCharAt(start, (char) (str1.charAt(start) ^ str1.charAt(end)));
            str1.setCharAt(end, (char) (str1.charAt(end) ^ str1.charAt(start)));
            str1.setCharAt(start, (char) (str1.charAt(start) ^ str1.charAt(end)));
        }
        return str1;
    }

    public static void main (String args[]) {
        String string = "Bibhu Ashis Jena";
        System.out.println(string);
        ReversingWords reverse = new ReversingWords();
        reverse.reverseWords(string);
    }
}
