package bibliocommons.actual.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) {
        List<String> OPEN = Arrays.asList("{","[","(");
        List<String> CLOSED = Arrays.asList("}","]",")");

        String braces = "{{[](){{()}}}}";
        Stack<String> stack = new Stack<>();
        for(int i=0;i<braces.length();i++){
            if(stack.empty()) {
                stack.push(String.valueOf(braces.charAt(i)));
            } else if(OPEN.contains(String.valueOf(braces.charAt(i)))) {
                stack.push(String.valueOf(braces.charAt(i)));
            } else {
                String prev = stack.peek();
                if(OPEN.contains(prev) && OPEN.indexOf(prev) == CLOSED.indexOf(String.valueOf(braces.charAt(i)))) {
                    stack.pop();
                }
            }

        }
        if(stack.empty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
