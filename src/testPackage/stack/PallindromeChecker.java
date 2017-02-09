package testPackage.stack;

/**
 * Created by bajmd on 26/12/16.
 * Problem Statement: Given an array of characters formed with a's and b's. The string is marked with special character
 * X which represents the middle of the list (e.g. ababa....abXba....ababa). Check whether the string is palindrome.
 */

// Palindrome Checking Logic
class Checker {
    CharStack stack = new CharStack(5);
    void checkPalindrome(String inputString) {
        int i=0;
        boolean isPalindrome = true;
        while (inputString.charAt(i) != 'X') {
            stack.push(inputString.charAt(i));
            i++;
        }
        i++;
        for (; i<inputString.length(); i++) {
            if (stack.pop() != inputString.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome)
            System.out.println("The string is a Palindrome");
        else
            System.out.println("The string is not a Palindrome");
    }
}

public class  PallindromeChecker {
    public static void main (String args[]) {
        Checker palindromeChecker = new Checker();
        palindromeChecker.checkPalindrome("ababaXababa");
    }
}
