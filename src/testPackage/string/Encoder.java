package testPackage.string;

/**
 * Created by bajmd on 18/06/18.
 */
public class Encoder {
    public String encodeString (String inputString){
        int length = inputString.length();
        if(length == 0)
            return inputString;
        StringBuilder resultString = new StringBuilder();
        for (int i=0; i<length; ) {
            int count = 1;
            int index = i;
            char ch = inputString.charAt(i);
            while(++i<length && inputString.charAt(i)==ch)
                count++;
            if (count>3) {
                resultString.append(count);
                resultString.append('x');
                resultString.append(inputString.charAt(index));

            }
            else {
                for (int j=0; j<count;j++)
                    resultString.append(inputString.charAt(index));

            }
        }
        return resultString.toString();
    }

    public static void main(String args[]) {
        String inputString = "aaabbbbbCCCCCCCCczx6";
        Encoder encode = new Encoder();
        System.out.println(encode.encodeString(inputString));
    }

}
