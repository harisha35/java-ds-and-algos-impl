package stacks;

public class DuplicateParenthesis {

    private static boolean areDuplicateParenthesisPresent(String s) {
        int i = 0;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        while(i < length) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    return true;
                }
                while(stack.pop() != '(') {	}
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "(((a+(b))+c+d))";
        if(areDuplicateParenthesisPresent(s)) {
            System.out.println("String " + s + " has duplicate parenthesis");
        } else {
            System.out.println("String " + s + " does not have duplicate parenthesis");
        }
    }
}
