package stacks;

public class BalancedSymbols {

    public static boolean isBalanced(String s) {
        int i = 0;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        while(i < length) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != ')') {
                    return false;
                } else {
                    stack.pop();
                }
            }
            i++;
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(A+B)+(C-D)";
        if(isBalanced(s)) {
            System.out.println("String " + s + " is balanced.");
        } else {
            System.out.println("String " + s + " is not balanced.");
        }
    }
}
