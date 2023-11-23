import java.util.Stack;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
public class Brackets {

    public boolean isBalanced(String s){
        if (s.length()==0) return false;

        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character current: brackets){
            if (current.equals('(')) {
                stack.push(')');
            } else if (current.equals('{')){
                stack.push('}');
            } else if (current.equals('[')){
                stack.push(']');
            } else if (stack.isEmpty() || !stack.pop().equals(current)) return false;
        }

        return stack.isEmpty();
    }

}
