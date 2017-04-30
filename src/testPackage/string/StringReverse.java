package testPackage.string;

/**
 * Created by bajmd on 27/04/17.
 */
public class StringReverse {
    // Normal Reverse
    String reverse (String str) {
        StringBuilder str1 = new StringBuilder (str);
        char temp;
        int start, end = str1.length() - 1;
        for (start=0; start<end; start++, end--) {
            temp = str1.charAt(start);
            str1.setCharAt(start, str1.charAt(end));
            str1.setCharAt(end, temp);
        }
        //System.out.println(str1);
        return str1.toString();
    }

    // With StringBuffer
    String reverseAlt (String str) {
        StringBuffer str1 = new StringBuffer(str.length());
        for (int i = str.length()-1; i>=0; i--)
            str1.append(str.charAt(i));
        //System.out.println(str1);
        return str1.toString();
    }

    // With XOR
    String reverseXor (String str) {
        StringBuilder str1 = new StringBuilder(str);
        int start, end = str1.length()-1;
        for (start=0; start<end; start++,end--) {
            str1.setCharAt(start, (char) (str1.charAt(start) ^ str1.charAt(end)));
            str1.setCharAt(end, (char) (str1.charAt(end) ^ str1.charAt(start)));
            str1.setCharAt(start, (char) (str1.charAt(start) ^ str1.charAt(end)));
        }
        //System.out.println(str1);
        return str1.toString();
    }

    public static void main (String args[]) {
        String str = "String";
        System.out.println(str);
        StringReverse reverse = new StringReverse();
        System.out.println(reverse.reverse(str));
        System.out.println(reverse.reverseAlt(str));
        System.out.println(reverse.reverseXor(str));
    }
}
