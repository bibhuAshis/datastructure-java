package testPackage.string;

/**
 * Created by bajmd on 27/04/17.
 */
public class StringReverse {
    // Normal Reverse
    void reverse (String str) {
        StringBuilder str1 = new StringBuilder (str);
        char temp;
        int start, end = str1.length() - 1;
        for (start=0; start<end; start++, end--) {
            temp = str1.charAt(start);
            str1.setCharAt(start, str1.charAt(end));
            str1.setCharAt(end, temp);
        }
        System.out.println(str1);
    }

    // With StringBuffer
    void reverseAlt (String str) {
        StringBuffer str1 = new StringBuffer(str.length());
        for (int i = str.length()-1; i>=0; i--)
            str1.append(str.charAt(i));
        System.out.println(str1);
    }

    // With XOR
    void reverseXor (String str) {
        StringBuilder str1 = new StringBuilder(str);
        int start, end = str1.length()-1;
        for (start=0; start<end; start++,end--) {
            str1.setCharAt(start, (char) (str1.charAt(start) ^ str1.charAt(end)));
            str1.setCharAt(end, (char) (str1.charAt(end) ^ str1.charAt(start)));
            str1.setCharAt(start, (char) (str1.charAt(start) ^ str1.charAt(end)));
        }
        System.out.println(str1);
    }

    public static void main (String args[]) {
        String str = "String";
        System.out.println(str);
        StringReverse reverse = new StringReverse();
        reverse.reverse(str);
        reverse.reverseAlt(str);
        reverse.reverseXor(str);
    }
}
