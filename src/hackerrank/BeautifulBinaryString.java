package hackerrank;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeautifulBinaryString {
    private static final String BAD_STRING = "010";

    public static void main(String args[]){
        BeautifulBinaryString beautifulBinaryString = new BeautifulBinaryString();
        int result = beautifulBinaryString.beautifulBinaryString("0101010");
        System.out.println("Result: " + result);
    }

    /**
     * Input is a string
     * a beautiful binary string is one that does not contain '010'
     * return how many swaps are needed to remove this from string
     * @param str
     * @return
     */
    private int beautifulBinaryString(String str) {
        char[] arr = str.toCharArray();
        int counter = 0;
        for(int i=0;i<arr.length-4;i++) {
            String myStr = String.valueOf(arr, i, i+3);
            if(myStr.equalsIgnoreCase(BAD_STRING)) {
                arr[i+1] = '0';
                counter++;
            }
        }

        return counter;
    }

}
